package com.google.android.gms.gcm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class zzd
{
  static zzd zzk;
  private final Context zzl;
  private String zzm;
  private final AtomicInteger zzn = new AtomicInteger((int)SystemClock.elapsedRealtime());

  private zzd(Context paramContext)
  {
    this.zzl = paramContext.getApplicationContext();
  }

  static zzd zzd(Context paramContext)
  {
    try
    {
      if (zzk == null)
        zzk = new zzd(paramContext);
      zzd localzzd = zzk;
      return localzzd;
    }
    finally
    {
    }
  }

  static String zzd(Bundle paramBundle, String paramString)
  {
    String str = paramBundle.getString(paramString);
    if (str == null)
      str = paramBundle.getString(paramString.replace("gcm.n.", "gcm.notification."));
    return str;
  }

  private final String zze(Bundle paramBundle, String paramString)
  {
    String str1 = zzd(paramBundle, paramString);
    if (!TextUtils.isEmpty(str1))
      return str1;
    String str2 = String.valueOf(paramString);
    String str3 = String.valueOf("_loc_key");
    if (str3.length() != 0);
    String str5;
    for (String str4 = str2.concat(str3); ; str4 = new String(str2))
    {
      str5 = zzd(paramBundle, str4);
      if (!TextUtils.isEmpty(str5))
        break;
      return null;
    }
    Resources localResources = this.zzl.getResources();
    int i = localResources.getIdentifier(str5, "string", this.zzl.getPackageName());
    if (i == 0)
    {
      String str15 = String.valueOf(paramString);
      String str16 = String.valueOf("_loc_key");
      if (str16.length() != 0);
      for (String str17 = str15.concat(str16); ; str17 = new String(str15))
      {
        String str18 = str17.substring(6);
        Log.w("GcmNotification", 49 + String.valueOf(str18).length() + String.valueOf(str5).length() + str18 + " resource not found: " + str5 + " Default value will be used.");
        return null;
      }
    }
    String str6 = String.valueOf(paramString);
    String str7 = String.valueOf("_loc_args");
    if (str7.length() != 0);
    String str9;
    for (String str8 = str6.concat(str7); ; str8 = new String(str6))
    {
      str9 = zzd(paramBundle, str8);
      if (!TextUtils.isEmpty(str9))
        break;
      return localResources.getString(i);
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(str9);
      String[] arrayOfString = new String[localJSONArray.length()];
      for (int j = 0; j < arrayOfString.length; j++)
        arrayOfString[j] = localJSONArray.opt(j);
      String str14 = localResources.getString(i, arrayOfString);
      return str14;
    }
    catch (JSONException localJSONException)
    {
      String str10 = String.valueOf(paramString);
      String str11 = String.valueOf("_loc_args");
      if (str11.length() != 0);
      for (String str12 = str10.concat(str11); ; str12 = new String(str10))
      {
        String str13 = str12.substring(6);
        Log.w("GcmNotification", 41 + String.valueOf(str13).length() + String.valueOf(str9).length() + "Malformed " + str13 + ": " + str9 + "  Default value will be used.");
        return null;
      }
    }
    catch (MissingFormatArgumentException localMissingFormatArgumentException)
    {
      while (true)
        Log.w("GcmNotification", 58 + String.valueOf(str5).length() + String.valueOf(str9).length() + "Missing format argument for " + str5 + ": " + str9 + " Default value will be used.", localMissingFormatArgumentException);
    }
  }

  private final Bundle zzf()
  {
    try
    {
      ApplicationInfo localApplicationInfo2 = this.zzl.getPackageManager().getApplicationInfo(this.zzl.getPackageName(), 128);
      localApplicationInfo1 = localApplicationInfo2;
      if ((localApplicationInfo1 != null) && (localApplicationInfo1.metaData != null))
        return localApplicationInfo1.metaData;
      return Bundle.EMPTY;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        ApplicationInfo localApplicationInfo1 = null;
    }
  }

  final boolean zze(Bundle paramBundle)
  {
    String str1 = zze(paramBundle, "gcm.n.title");
    if (TextUtils.isEmpty(str1));
    for (Object localObject1 = this.zzl.getApplicationInfo().loadLabel(this.zzl.getPackageManager()); ; localObject1 = str1)
    {
      String str2 = zze(paramBundle, "gcm.n.body");
      String str3 = zzd(paramBundle, "gcm.n.icon");
      Resources localResources;
      int j;
      String str4;
      String str5;
      Uri localUri;
      label121: Intent localIntent1;
      if (!TextUtils.isEmpty(str3))
      {
        localResources = this.zzl.getResources();
        int m = localResources.getIdentifier(str3, "drawable", this.zzl.getPackageName());
        if (m != 0)
        {
          j = m;
          str4 = zzd(paramBundle, "gcm.n.color");
          str5 = zzd(paramBundle, "gcm.n.sound2");
          if (!TextUtils.isEmpty(str5))
            break label364;
          localUri = null;
          String str6 = zzd(paramBundle, "gcm.n.click_action");
          if (TextUtils.isEmpty(str6))
            break label478;
          localIntent1 = new Intent(str6);
          localIntent1.setPackage(this.zzl.getPackageName());
          localIntent1.setFlags(268435456);
        }
      }
      label364: Intent localIntent2;
      label1028: for (Object localObject2 = localIntent1; ; localObject2 = localIntent2)
      {
        Bundle localBundle = new Bundle(paramBundle);
        GcmListenerService.zzd(localBundle);
        ((Intent)localObject2).putExtras(localBundle);
        Iterator localIterator = localBundle.keySet().iterator();
        label478: PendingIntent localPendingIntent;
        String str7;
        String str8;
        while (true)
          if (localIterator.hasNext())
          {
            String str10 = (String)localIterator.next();
            if ((str10.startsWith("gcm.n.")) || (str10.startsWith("gcm.notification.")))
            {
              ((Intent)localObject2).removeExtra(str10);
              continue;
              int n = localResources.getIdentifier(str3, "mipmap", this.zzl.getPackageName());
              if (n != 0)
              {
                j = n;
                break;
              }
              Log.w("GcmNotification", 57 + String.valueOf(str3).length() + "Icon resource " + str3 + " not found. Notification will use app icon.");
              int i = this.zzl.getApplicationInfo().icon;
              if (i == 0)
                i = 17301651;
              j = i;
              break;
              if ((!"default".equals(str5)) && (this.zzl.getResources().getIdentifier(str5, "raw", this.zzl.getPackageName()) != 0))
              {
                String str11 = this.zzl.getPackageName();
                localUri = Uri.parse(24 + String.valueOf(str11).length() + String.valueOf(str5).length() + "android.resource://" + str11 + "/raw/" + str5);
                break label121;
              }
              localUri = RingtoneManager.getDefaultUri(2);
              break label121;
              localIntent2 = this.zzl.getPackageManager().getLaunchIntentForPackage(this.zzl.getPackageName());
              if (localIntent2 != null)
                break label1028;
              Log.w("GcmNotification", "No activity found to launch app");
              localPendingIntent = null;
              str7 = zzd(paramBundle, "gcm.n.android_channel_id");
              boolean bool = PlatformVersion.isAtLeastO();
              str8 = null;
              if (bool)
              {
                int k = this.zzl.getApplicationInfo().targetSdkVersion;
                str8 = null;
                if (k >= 26)
                  break label809;
              }
            }
          }
        label809: NotificationManager localNotificationManager2;
        while (true)
        {
          NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.zzl).setAutoCancel(true).setSmallIcon(j);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
            localBuilder.setContentTitle((CharSequence)localObject1);
          if (!TextUtils.isEmpty(str2))
          {
            localBuilder.setContentText(str2);
            localBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(str2));
          }
          if (!TextUtils.isEmpty(str4))
            localBuilder.setColor(Color.parseColor(str4));
          if (localUri != null)
            localBuilder.setSound(localUri);
          if (localPendingIntent != null)
            localBuilder.setContentIntent(localPendingIntent);
          if (str8 != null)
            localBuilder.setChannelId(str8);
          Notification localNotification = localBuilder.build();
          String str9 = zzd(paramBundle, "gcm.n.tag");
          if (Log.isLoggable("GcmNotification", 3))
            Log.d("GcmNotification", "Showing notification");
          NotificationManager localNotificationManager1 = (NotificationManager)this.zzl.getSystemService("notification");
          if (TextUtils.isEmpty(str9))
          {
            long l = SystemClock.uptimeMillis();
            str9 = 37 + "GCM-Notification:" + l;
          }
          localNotificationManager1.notify(str9, 0, localNotification);
          return true;
          localPendingIntent = PendingIntent.getActivity(this.zzl, this.zzn.getAndIncrement(), (Intent)localObject2, 1073741824);
          break;
          localNotificationManager2 = (NotificationManager)this.zzl.getSystemService(NotificationManager.class);
          if (!TextUtils.isEmpty(str7))
          {
            if (localNotificationManager2.getNotificationChannel(str7) != null)
              str8 = str7;
            else
              Log.w("GcmNotification", 122 + String.valueOf(str7).length() + "Notification Channel requested (" + str7 + ") has not been created by the app. Manifest configuration, or default, value will be used.");
          }
          else if (this.zzm != null)
          {
            str8 = this.zzm;
          }
          else
          {
            this.zzm = zzf().getString("com.google.android.gms.gcm.default_notification_channel_id");
            if (TextUtils.isEmpty(this.zzm))
              break label1016;
            if (localNotificationManager2.getNotificationChannel(this.zzm) == null)
              break label954;
            str8 = this.zzm;
          }
        }
        label954: Log.w("GcmNotification", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
        while (true)
        {
          if (localNotificationManager2.getNotificationChannel("fcm_fallback_notification_channel") == null)
            localNotificationManager2.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.zzl.getString(R.string.gcm_fallback_notification_channel_label), 3));
          this.zzm = "fcm_fallback_notification_channel";
          str8 = this.zzm;
          break;
          label1016: Log.w("GcmNotification", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.zzd
 * JD-Core Version:    0.6.2
 */