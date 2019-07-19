package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;

public final class ConnectionErrorMessages
{

  @GuardedBy("sCache")
  private static final SimpleArrayMap<String, String> zaof = new SimpleArrayMap();

  public static String getAppName(Context paramContext)
  {
    Object localObject = paramContext.getPackageName();
    try
    {
      String str2 = Wrappers.packageManager(paramContext).getApplicationLabel((String)localObject).toString();
      localObject = str2;
      return localObject;
    }
    catch (NullPointerException localNullPointerException)
    {
      String str1;
      do
        str1 = paramContext.getApplicationInfo().name;
      while (TextUtils.isEmpty(str1));
      return str1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label27: break label27;
    }
  }

  public static String getDefaultNotificationChannelName(Context paramContext)
  {
    return paramContext.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_channel_name);
  }

  public static String getErrorDialogButtonMessage(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    switch (paramInt)
    {
    default:
      return localResources.getString(17039370);
    case 1:
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_button);
    case 3:
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_button);
    case 2:
    }
    return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_button);
  }

  public static String getErrorMessage(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    String str = getAppName(paramContext);
    switch (paramInt)
    {
    case 4:
    case 6:
    case 8:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 19:
    default:
      return localResources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, new Object[] { str });
    case 1:
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_text, new Object[] { str });
    case 3:
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_text, new Object[] { str });
    case 18:
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_updating_text, new Object[] { str });
    case 2:
      if (DeviceProperties.isWearableWithoutPlayStore(paramContext))
        return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_wear_update_text);
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_text, new Object[] { str });
    case 9:
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_unsupported_text, new Object[] { str });
    case 7:
      return zaa(paramContext, "common_google_play_services_network_error_text", str);
    case 5:
      return zaa(paramContext, "common_google_play_services_invalid_account_text", str);
    case 16:
      return zaa(paramContext, "common_google_play_services_api_unavailable_text", str);
    case 17:
      return zaa(paramContext, "common_google_play_services_sign_in_failed_text", str);
    case 20:
    }
    return zaa(paramContext, "common_google_play_services_restricted_profile_text", str);
  }

  public static String getErrorNotificationMessage(Context paramContext, int paramInt)
  {
    if (paramInt == 6)
      return zaa(paramContext, "common_google_play_services_resolution_required_text", getAppName(paramContext));
    return getErrorMessage(paramContext, paramInt);
  }

  public static String getErrorNotificationTitle(Context paramContext, int paramInt)
  {
    if (paramInt == 6);
    for (String str = zaa(paramContext, "common_google_play_services_resolution_required_title"); ; str = getErrorTitle(paramContext, paramInt))
    {
      if (str == null)
        str = paramContext.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker);
      return str;
    }
  }

  public static String getErrorTitle(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    switch (paramInt)
    {
    case 12:
    case 13:
    case 14:
    case 15:
    case 19:
    default:
      Log.e("GoogleApiAvailability", 33 + "Unexpected error code " + paramInt);
    case 4:
    case 6:
    case 18:
      return null;
    case 1:
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_title);
    case 3:
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_title);
    case 2:
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_title);
    case 9:
      Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
      return null;
    case 7:
      Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
      return zaa(paramContext, "common_google_play_services_network_error_title");
    case 8:
      Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
      return null;
    case 10:
      Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
      return null;
    case 5:
      Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
      return zaa(paramContext, "common_google_play_services_invalid_account_title");
    case 11:
      Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
      return null;
    case 16:
      Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
      return null;
    case 17:
      Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
      return zaa(paramContext, "common_google_play_services_sign_in_failed_title");
    case 20:
    }
    Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
    return zaa(paramContext, "common_google_play_services_restricted_profile_title");
  }

  private static String zaa(Context paramContext, String paramString)
  {
    Resources localResources;
    int i;
    synchronized (zaof)
    {
      String str1 = (String)zaof.get(paramString);
      if (str1 != null)
        return str1;
      localResources = GooglePlayServicesUtil.getRemoteResource(paramContext);
      if (localResources == null)
        return null;
      i = localResources.getIdentifier(paramString, "string", "com.google.android.gms");
      if (i == 0)
      {
        String str2 = String.valueOf(paramString);
        if (str2.length() != 0)
        {
          str3 = "Missing resource: ".concat(str2);
          Log.w("GoogleApiAvailability", str3);
          return null;
        }
        String str3 = new String("Missing resource: ");
      }
    }
    String str4 = localResources.getString(i);
    if (TextUtils.isEmpty(str4))
    {
      String str5 = String.valueOf(paramString);
      if (str5.length() != 0);
      for (String str6 = "Got empty resource: ".concat(str5); ; str6 = new String("Got empty resource: "))
      {
        Log.w("GoogleApiAvailability", str6);
        return null;
      }
    }
    zaof.put(paramString, str4);
    return str4;
  }

  private static String zaa(Context paramContext, String paramString1, String paramString2)
  {
    Resources localResources = paramContext.getResources();
    String str = zaa(paramContext, paramString1);
    if (str == null)
      str = localResources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
    return String.format(localResources.getConfiguration().locale, str, new Object[] { paramString2 });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.ConnectionErrorMessages
 * JD-Core Version:    0.6.2
 */