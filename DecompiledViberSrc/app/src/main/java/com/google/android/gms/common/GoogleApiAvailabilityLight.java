package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
@ShowFirstParty
public class GoogleApiAvailabilityLight
{

  @KeepForSdk
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

  @KeepForSdk
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 0;

  @KeepForSdk
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

  @KeepForSdk
  static final String TRACKING_SOURCE_DIALOG = "d";

  @KeepForSdk
  static final String TRACKING_SOURCE_NOTIFICATION = "n";
  private static final GoogleApiAvailabilityLight zzm = new GoogleApiAvailabilityLight();

  @KeepForSdk
  public static GoogleApiAvailabilityLight getInstance()
  {
    return zzm;
  }

  @VisibleForTesting
  private static String zza(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gcore_");
    localStringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    localStringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString))
      localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    if (paramContext != null)
      localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("-");
    if (paramContext != null);
    try
    {
      localStringBuilder.append(Wrappers.packageManager(paramContext).getPackageInfo(paramContext.getPackageName(), 0).versionCode);
      label94: return localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label94;
    }
  }

  @KeepForSdk
  public void cancelAvailabilityErrorNotifications(Context paramContext)
  {
    GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(paramContext);
  }

  @KeepForSdk
  @ShowFirstParty
  public int getApkVersion(Context paramContext)
  {
    return GooglePlayServicesUtilLight.getApkVersion(paramContext);
  }

  @KeepForSdk
  @ShowFirstParty
  public int getClientVersion(Context paramContext)
  {
    return GooglePlayServicesUtilLight.getClientVersion(paramContext);
  }

  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public Intent getErrorResolutionIntent(int paramInt)
  {
    return getErrorResolutionIntent(null, paramInt, null);
  }

  @KeepForSdk
  @ShowFirstParty
  public Intent getErrorResolutionIntent(Context paramContext, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
    case 2:
      if ((paramContext != null) && (DeviceProperties.isWearableWithoutPlayStore(paramContext)))
        return zzg.zzs();
      return zzg.zza("com.google.android.gms", zza(paramContext, paramString));
    case 3:
    }
    return zzg.zzg("com.google.android.gms");
  }

  @KeepForSdk
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2, null);
  }

  @KeepForSdk
  @ShowFirstParty
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = getErrorResolutionIntent(paramContext, paramInt1, paramString);
    if (localIntent == null)
      return null;
    return PendingIntent.getActivity(paramContext, paramInt2, localIntent, 134217728);
  }

  @KeepForSdk
  public String getErrorString(int paramInt)
  {
    return GooglePlayServicesUtilLight.getErrorString(paramInt);
  }

  @KeepForSdk
  @HideFirstParty
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    return isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }

  @KeepForSdk
  public int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    int i = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(paramContext, paramInt);
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, i))
      i = 18;
    return i;
  }

  @KeepForSdk
  @ShowFirstParty
  public boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, paramInt);
  }

  @KeepForSdk
  @ShowFirstParty
  public boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(paramContext, paramInt);
  }

  @KeepForSdk
  public boolean isUninstalledAppPossiblyUpdating(Context paramContext, String paramString)
  {
    return GooglePlayServicesUtilLight.isUninstalledAppPossiblyUpdating(paramContext, paramString);
  }

  @KeepForSdk
  public boolean isUserResolvableError(int paramInt)
  {
    return GooglePlayServicesUtilLight.isUserRecoverableError(paramInt);
  }

  @KeepForSdk
  public void verifyGooglePlayServicesIsAvailable(Context paramContext, int paramInt)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    GooglePlayServicesUtilLight.ensurePlayServicesAvailable(paramContext, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GoogleApiAvailabilityLight
 * JD-Core Version:    0.6.2
 */