package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Arrays;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;

public final class d
{
  private static final AtomicInteger a = new AtomicInteger((int)SystemClock.elapsedRealtime());
  private final Context b;
  private final String c;

  @GuardedBy("this")
  private Bundle d;

  public d(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.c = paramString;
  }

  private final int a(String paramString)
  {
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      Resources localResources = this.b.getResources();
      j = localResources.getIdentifier(paramString, "drawable", this.c);
      if ((j != 0) && (a(j)));
      do
      {
        return j;
        j = localResources.getIdentifier(paramString, "mipmap", this.c);
      }
      while ((j != 0) && (a(j)));
      Log.w("FirebaseMessaging", 61 + String.valueOf(paramString).length() + "Icon resource " + paramString + " not found. Notification will use default icon.");
    }
    int i = a().getInt("com.google.firebase.messaging.default_notification_icon", 0);
    if ((i == 0) || (!a(i)));
    while (true)
    {
      try
      {
        j = b(0).icon;
        if ((j != 0) && (a(j)))
          break;
        return 17301651;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        String str = String.valueOf(localNameNotFoundException);
        Log.w("FirebaseMessaging", 35 + String.valueOf(str).length() + "Couldn't get own application info: " + str);
      }
      j = i;
    }
  }

  private final PendingIntent a(int paramInt, Intent paramIntent)
  {
    return PendingIntent.getBroadcast(this.b, paramInt, new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(this.b, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", paramIntent), 1073741824);
  }

  private final Bundle a()
  {
    try
    {
      Bundle localBundle;
      if (this.d != null)
        localBundle = this.d;
      while (true)
      {
        return localBundle;
        try
        {
          ApplicationInfo localApplicationInfo = b(128);
          if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
          {
            this.d = localApplicationInfo.metaData;
            localBundle = this.d;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          String str = String.valueOf(localNameNotFoundException);
          Log.w("FirebaseMessaging", 35 + String.valueOf(str).length() + "Couldn't get own application info: " + str);
          localBundle = Bundle.EMPTY;
        }
      }
    }
    finally
    {
    }
  }

  public static String a(Bundle paramBundle, String paramString)
  {
    String str = paramBundle.getString(paramString);
    if (str == null)
      str = paramBundle.getString(paramString.replace("gcm.n.", "gcm.notification."));
    return str;
  }

  private static void a(Intent paramIntent, Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.startsWith("google.c.a.")) || (str.equals("from")))
        paramIntent.putExtra(str, paramBundle.getString(str));
    }
  }

  @TargetApi(26)
  private final boolean a(int paramInt)
  {
    if (Build.VERSION.SDK_INT != 26);
    while (true)
    {
      return true;
      Resources localResources = this.b.getResources();
      try
      {
        if ((localResources.getDrawable(paramInt, null) instanceof AdaptiveIconDrawable))
        {
          Log.e("FirebaseMessaging", 77 + "Adaptive icons cannot be used in notifications. Ignoring icon id: " + paramInt);
          return false;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        Log.e("FirebaseMessaging", 66 + "Couldn't find resource " + paramInt + ", treating it as an invalid icon");
      }
    }
    return false;
  }

  private final ApplicationInfo b(int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return this.b.getPackageManager().getApplicationInfo(this.c, paramInt);
  }

  private final Integer b(String paramString)
  {
    if (Build.VERSION.SDK_INT < 21);
    int i;
    do
    {
      return null;
      if (!TextUtils.isEmpty(paramString))
        try
        {
          Integer localInteger2 = Integer.valueOf(Color.parseColor(paramString));
          return localInteger2;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.w("FirebaseMessaging", 54 + String.valueOf(paramString).length() + "Color " + paramString + " not valid. Notification will use default color.");
        }
      i = a().getInt("com.google.firebase.messaging.default_notification_color", 0);
    }
    while (i == 0);
    try
    {
      Integer localInteger1 = Integer.valueOf(ContextCompat.getColor(this.b, i));
      return localInteger1;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
    }
    return null;
  }

  public static boolean b(Bundle paramBundle)
  {
    return ("1".equals(a(paramBundle, "gcm.n.e"))) || (a(paramBundle, "gcm.n.icon") != null);
  }

  public static Object[] b(Bundle paramBundle, String paramString)
  {
    String str1 = String.valueOf(paramString);
    String str2 = String.valueOf("_loc_args");
    String str3;
    String str4;
    Object localObject;
    if (str2.length() != 0)
    {
      str3 = str1.concat(str2);
      str4 = a(paramBundle, str3);
      if (!TextUtils.isEmpty(str4))
        break label61;
      localObject = null;
    }
    label61: String str5;
    String str6;
    while (true)
    {
      return localObject;
      str3 = new String(str1);
      break;
      try
      {
        JSONArray localJSONArray = new JSONArray(str4);
        localObject = new String[localJSONArray.length()];
        for (int i = 0; i < localObject.length; i++)
          localObject[i] = localJSONArray.opt(i);
      }
      catch (JSONException localJSONException)
      {
        str5 = String.valueOf(paramString);
        str6 = String.valueOf("_loc_args");
        if (str6.length() == 0);
      }
    }
    for (String str7 = str5.concat(str6); ; str7 = new String(str5))
    {
      String str8 = str7.substring(6);
      Log.w("FirebaseMessaging", 41 + String.valueOf(str8).length() + String.valueOf(str4).length() + "Malformed " + str8 + ": " + str4 + "  Default value will be used.");
      return null;
    }
  }

  public static String c(Bundle paramBundle)
  {
    String str = a(paramBundle, "gcm.n.sound2");
    if (TextUtils.isEmpty(str))
      str = a(paramBundle, "gcm.n.sound");
    return str;
  }

  public static String c(Bundle paramBundle, String paramString)
  {
    String str1 = String.valueOf(paramString);
    String str2 = String.valueOf("_loc_key");
    if (str2.length() != 0);
    for (String str3 = str1.concat(str2); ; str3 = new String(str1))
      return a(paramBundle, str3);
  }

  @TargetApi(26)
  private final String c(String paramString)
  {
    if (!PlatformVersion.isAtLeastO())
      paramString = null;
    while (true)
    {
      return paramString;
      try
      {
        i = b(0).targetSdkVersion;
        if (i < 26)
          return null;
        NotificationManager localNotificationManager = (NotificationManager)this.b.getSystemService(NotificationManager.class);
        if (!TextUtils.isEmpty(paramString))
        {
          if (localNotificationManager.getNotificationChannel(paramString) != null)
            continue;
          Log.w("FirebaseMessaging", 122 + String.valueOf(paramString).length() + "Notification Channel requested (" + paramString + ") has not been created by the app. Manifest configuration, or default, value will be used.");
        }
        paramString = a().getString("com.google.firebase.messaging.default_notification_channel_id");
        if (!TextUtils.isEmpty(paramString))
        {
          if (localNotificationManager.getNotificationChannel(paramString) != null)
            continue;
          Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
        }
        while (true)
        {
          if (localNotificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null)
          {
            int j = this.b.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", this.c);
            localNotificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.b.getString(j), 3));
          }
          return "fcm_fallback_notification_channel";
          Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        while (true)
          int i = 0;
      }
    }
  }

  static Uri d(Bundle paramBundle)
  {
    String str = a(paramBundle, "gcm.n.link_android");
    if (TextUtils.isEmpty(str))
      str = a(paramBundle, "gcm.n.link");
    if (!TextUtils.isEmpty(str))
      return Uri.parse(str);
    return null;
  }

  private final String d(Bundle paramBundle, String paramString)
  {
    String str = a(paramBundle, paramString);
    if (!TextUtils.isEmpty(str))
      return str;
    return e(paramBundle, paramString);
  }

  private final CharSequence e(Bundle paramBundle)
  {
    String str1 = d(paramBundle, "gcm.n.title");
    if (!TextUtils.isEmpty(str1))
      return str1;
    try
    {
      CharSequence localCharSequence = b(0).loadLabel(this.b.getPackageManager());
      return localCharSequence;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      String str2 = String.valueOf(localNameNotFoundException);
      Log.e("FirebaseMessaging", 35 + String.valueOf(str2).length() + "Couldn't get own application info: " + str2);
    }
    return "";
  }

  private final String e(Bundle paramBundle, String paramString)
  {
    String str1 = c(paramBundle, paramString);
    if (TextUtils.isEmpty(str1))
      return null;
    Resources localResources = this.b.getResources();
    int i = localResources.getIdentifier(str1, "string", this.c);
    if (i == 0)
    {
      String str4 = String.valueOf(paramString);
      String str5 = String.valueOf("_loc_key");
      if (str5.length() != 0);
      for (String str6 = str4.concat(str5); ; str6 = new String(str4))
      {
        String str7 = str6.substring(6);
        Log.w("FirebaseMessaging", 49 + String.valueOf(str7).length() + String.valueOf(paramString).length() + str7 + " resource not found: " + paramString + " Default value will be used.");
        return null;
      }
    }
    Object[] arrayOfObject = b(paramBundle, paramString);
    if (arrayOfObject == null)
      return localResources.getString(i);
    try
    {
      String str3 = localResources.getString(i, arrayOfObject);
      return str3;
    }
    catch (MissingFormatArgumentException localMissingFormatArgumentException)
    {
      String str2 = Arrays.toString(arrayOfObject);
      Log.w("FirebaseMessaging", 58 + String.valueOf(paramString).length() + String.valueOf(str2).length() + "Missing format argument for " + paramString + ": " + str2 + " Default value will be used.", localMissingFormatArgumentException);
    }
    return null;
  }

  private static boolean f(Bundle paramBundle)
  {
    return (paramBundle != null) && ("1".equals(paramBundle.getString("google.c.a.e")));
  }

  public final f a(Bundle paramBundle)
  {
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.b, c(a(paramBundle, "gcm.n.android_channel_id")));
    localBuilder.setAutoCancel(true);
    localBuilder.setContentTitle(e(paramBundle));
    String str1 = d(paramBundle, "gcm.n.body");
    if (!TextUtils.isEmpty(str1))
    {
      localBuilder.setContentText(str1);
      localBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(str1));
    }
    localBuilder.setSmallIcon(a(a(paramBundle, "gcm.n.icon")));
    String str2 = c(paramBundle);
    Uri localUri1;
    Object localObject;
    label177: PendingIntent localPendingIntent1;
    label185: PendingIntent localPendingIntent2;
    label206: String str4;
    if (TextUtils.isEmpty(str2))
    {
      localUri1 = null;
      if (localUri1 != null)
        localBuilder.setSound(localUri1);
      String str3 = a(paramBundle, "gcm.n.click_action");
      if (TextUtils.isEmpty(str3))
        break label383;
      Intent localIntent1 = new Intent(str3);
      localIntent1.setPackage(this.c);
      localIntent1.setFlags(268435456);
      localObject = localIntent1;
      if (localObject != null)
        break label468;
      localPendingIntent1 = null;
      localBuilder.setContentIntent(localPendingIntent1);
      boolean bool = f(paramBundle);
      localPendingIntent2 = null;
      if (bool)
        break label691;
      if (localPendingIntent2 != null)
        localBuilder.setDeleteIntent(localPendingIntent2);
      Integer localInteger = b(a(paramBundle, "gcm.n.color"));
      if (localInteger != null)
        localBuilder.setColor(localInteger.intValue());
      str4 = a(paramBundle, "gcm.n.tag");
      if (TextUtils.isEmpty(str4))
        break label726;
    }
    while (true)
    {
      return new f(localBuilder, str4, 0);
      if ((!"default".equals(str2)) && (this.b.getResources().getIdentifier(str2, "raw", this.c) != 0))
      {
        String str7 = this.c;
        localUri1 = Uri.parse(24 + String.valueOf(str7).length() + String.valueOf(str2).length() + "android.resource://" + str7 + "/raw/" + str2);
        break;
      }
      localUri1 = RingtoneManager.getDefaultUri(2);
      break;
      label383: Uri localUri2 = d(paramBundle);
      if (localUri2 != null)
      {
        Intent localIntent4 = new Intent("android.intent.action.VIEW");
        localIntent4.setPackage(this.c);
        localIntent4.setData(localUri2);
        localObject = localIntent4;
        break label177;
      }
      Intent localIntent5 = this.b.getPackageManager().getLaunchIntentForPackage(this.c);
      if (localIntent5 == null)
        Log.w("FirebaseMessaging", "No activity found to launch app");
      localObject = localIntent5;
      break label177;
      label468: ((Intent)localObject).addFlags(67108864);
      Bundle localBundle = new Bundle(paramBundle);
      Iterator localIterator1 = localBundle.keySet().iterator();
      while (localIterator1.hasNext())
      {
        String str6 = (String)localIterator1.next();
        if ((str6 != null) && (str6.startsWith("google.c.")))
          localIterator1.remove();
      }
      ((Intent)localObject).putExtras(localBundle);
      Iterator localIterator2 = localBundle.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str5 = (String)localIterator2.next();
        if ((str5.startsWith("gcm.n.")) || (str5.startsWith("gcm.notification.")))
          ((Intent)localObject).removeExtra(str5);
      }
      localPendingIntent1 = PendingIntent.getActivity(this.b, a.incrementAndGet(), (Intent)localObject, 1073741824);
      if (!f(paramBundle))
        break label185;
      Intent localIntent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
      a(localIntent2, paramBundle);
      localIntent2.putExtra("pending_intent", localPendingIntent1);
      localPendingIntent1 = a(a.incrementAndGet(), localIntent2);
      break label185;
      label691: Intent localIntent3 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
      a(localIntent3, paramBundle);
      localPendingIntent2 = a(a.incrementAndGet(), localIntent3);
      break label206;
      label726: long l = SystemClock.uptimeMillis();
      str4 = 37 + "FCM-Notification:" + l;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.messaging.d
 * JD-Core Version:    0.6.2
 */