package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.a.a;

@KeepForSdk
public class b
{
  @KeepForSdk
  public static void a(Intent paramIntent)
  {
    a("_nr", paramIntent);
  }

  private static void a(String paramString, Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    String str1 = paramIntent.getStringExtra("google.c.a.c_id");
    if (str1 != null)
      localBundle.putString("_nmid", str1);
    String str2 = paramIntent.getStringExtra("google.c.a.c_l");
    if (str2 != null)
      localBundle.putString("_nmn", str2);
    String str3 = paramIntent.getStringExtra("google.c.a.m_l");
    if (!TextUtils.isEmpty(str3))
      localBundle.putString("label", str3);
    String str4 = paramIntent.getStringExtra("google.c.a.m_c");
    if (!TextUtils.isEmpty(str4))
      localBundle.putString("message_channel", str4);
    String str5 = paramIntent.getStringExtra("from");
    if ((str5 != null) && (str5.startsWith("/topics/")));
    while (true)
    {
      if (str5 != null)
        localBundle.putString("_nt", str5);
      if (paramIntent.hasExtra("google.c.a.ts"));
      try
      {
        localBundle.putInt("_nmt", Integer.parseInt(paramIntent.getStringExtra("google.c.a.ts")));
        if (!paramIntent.hasExtra("google.c.a.udt"));
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          localBundle.putInt("_ndt", Integer.parseInt(paramIntent.getStringExtra("google.c.a.udt")));
          if (Log.isLoggable("FirebaseMessaging", 3))
          {
            String str6 = String.valueOf(localBundle);
            Log.d("FirebaseMessaging", 22 + String.valueOf(paramString).length() + String.valueOf(str6).length() + "Sending event=" + paramString + " params=" + str6);
          }
          a locala = (a)FirebaseApp.getInstance().a(a.class);
          if (locala != null)
          {
            locala.a("fcm", paramString, localBundle);
            return;
            str5 = null;
            continue;
            localNumberFormatException2 = localNumberFormatException2;
            Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", localNumberFormatException2);
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          while (true)
            Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", localNumberFormatException1);
          Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
      }
    }
  }

  @KeepForSdk
  public static void b(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!"1".equals(paramIntent.getStringExtra("google.c.a.tc")))
        break label137;
      a locala = (a)FirebaseApp.getInstance().a(a.class);
      if (Log.isLoggable("FirebaseMessaging", 3))
        Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
      if (locala == null)
        break label126;
      String str = paramIntent.getStringExtra("google.c.a.c_id");
      locala.a("fcm", "_ln", str);
      Bundle localBundle = new Bundle();
      localBundle.putString("source", "Firebase");
      localBundle.putString("medium", "notification");
      localBundle.putString("campaign", str);
      locala.a("fcm", "_cmp", localBundle);
    }
    while (true)
    {
      a("_no", paramIntent);
      return;
      label126: Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
      continue;
      label137: if (Log.isLoggable("FirebaseMessaging", 3))
        Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
    }
  }

  @KeepForSdk
  public static void c(Intent paramIntent)
  {
    a("_nd", paramIntent);
  }

  @KeepForSdk
  public static void d(Intent paramIntent)
  {
    a("_nf", paramIntent);
  }

  @KeepForSdk
  public static boolean e(Intent paramIntent)
  {
    if (paramIntent == null);
    while ("com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(paramIntent.getAction()))
      return false;
    return "1".equals(paramIntent.getStringExtra("google.c.a.e"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.messaging.b
 * JD-Core Version:    0.6.2
 */