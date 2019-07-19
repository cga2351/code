package com.appboy.push;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import com.appboy.AppboyAdmReceiver;
import com.appboy.AppboyFcmReceiver;
import com.appboy.f.f;
import com.appboy.g;
import com.appboy.ui.AppboyNavigator;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.UriAction;
import com.appboy.ui.support.UriUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static final String a = com.appboy.f.c.a(d.class);

  @TargetApi(26)
  private static int a(NotificationChannel paramNotificationChannel)
  {
    return paramNotificationChannel.getImportance();
  }

  public static int a(com.appboy.a.b paramb, NotificationCompat.Builder paramBuilder)
  {
    int i = paramb.e();
    if (i == 0)
    {
      com.appboy.f.c.b(a, "Small notification icon resource was not found. Will use the app icon when displaying notifications.");
      i = paramb.o();
    }
    while (true)
    {
      paramBuilder.setSmallIcon(i);
      return i;
      com.appboy.f.c.b(a, "Setting small icon for notification via resource id");
    }
  }

  @TargetApi(26)
  static NotificationChannel a(NotificationManager paramNotificationManager, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      com.appboy.f.c.b(a, "Notification extras bundle was null. Could not find a valid notification channel");
      return null;
    }
    String str = paramBundle.getString("ab_nc", null);
    if (!com.appboy.f.i.c(str))
    {
      NotificationChannel localNotificationChannel2 = paramNotificationManager.getNotificationChannel(str);
      if (localNotificationChannel2 != null)
      {
        com.appboy.f.c.b(a, "Found notification channel in extras with id: " + str);
        return localNotificationChannel2;
      }
      com.appboy.f.c.b(a, "Notification channel from extras is invalid, no channel found with id: " + str);
    }
    NotificationChannel localNotificationChannel1 = paramNotificationManager.getNotificationChannel("com_appboy_default_notification_channel");
    if (localNotificationChannel1 != null)
      return localNotificationChannel1;
    com.appboy.f.c.b(a, "Appboy default notification channel does not exist on device.");
    return null;
  }

  private static PendingIntent a(Context paramContext, String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramString).setClass(paramContext, b());
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    return PendingIntent.getBroadcast(paramContext, f.a(), localIntent, 1073741824);
  }

  public static Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null)
      return null;
    if ((paramBundle.containsKey("appboy_story_newly_received")) && (!paramBundle.getBoolean("appboy_story_newly_received")))
      return paramBundle.getBundle("extra");
    if (!com.appboy.e.a.booleanValue())
      return a(paramBundle.getString("extra", "{}"));
    return new Bundle(paramBundle);
  }

  public static Bundle a(String paramString)
  {
    Bundle localBundle;
    try
    {
      localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject(paramString);
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBundle.putString(str, localJSONObject.getString(str));
      }
    }
    catch (JSONException localJSONException)
    {
      com.appboy.f.c.d(a, "Unable parse JSON into a bundle.", localJSONException);
      return null;
    }
    return localBundle;
  }

  public static com.appboy.i a()
  {
    Object localObject = com.appboy.a.k();
    if (localObject == null)
      localObject = b.a();
    return localObject;
  }

  private static String a(Bundle paramBundle, String paramString)
  {
    if (paramBundle != null)
    {
      String str = paramBundle.getString(paramString, null);
      if (!com.appboy.f.i.c(str))
        return str;
    }
    return null;
  }

  public static void a(Context paramContext, int paramInt)
  {
    try
    {
      com.appboy.f.c.b(a, "Cancelling notification action with id: " + paramInt);
      Intent localIntent = new Intent("com.appboy.action.CANCEL_NOTIFICATION").setClass(paramContext, b());
      localIntent.putExtra("nid", paramInt);
      f.a(paramContext, localIntent);
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(a, "Exception occurred attempting to cancel notification.", localException);
    }
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      g(paramContext, paramIntent);
      f(paramContext, paramIntent);
      if (new com.appboy.a.b(paramContext).k())
        c(paramContext, paramIntent);
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(a, "Exception occurred attempting to handle notification opened intent.", localException);
    }
  }

  public static void a(Context paramContext, Bundle paramBundle)
  {
    com.appboy.f.c.b(a, "Sending push message received broadcast");
    b(paramContext, ".intent.APPBOY_PUSH_RECEIVED", paramBundle);
  }

  public static void a(Context paramContext, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    try
    {
      paramBuilder.setContentIntent(a(paramContext, "com.appboy.action.APPBOY_PUSH_CLICKED", paramBundle));
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(a, "Error setting content intent.", localException);
    }
  }

  public static void a(Context paramContext, NotificationCompat.Builder paramBuilder, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 != null)
    {
      com.appboy.f.c.b(a, "Setting style for notification");
      paramBuilder.setStyle(c.a(paramContext, paramBundle1, paramBundle2, paramBuilder));
    }
  }

  public static void a(Context paramContext, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, paramClass);
    localIntent.setAction("com.appboy.action.CANCEL_NOTIFICATION");
    localIntent.putExtra("nid", paramInt1);
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent, 134217728);
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramInt2 >= 1000)
    {
      com.appboy.f.c.b(a, "Setting Notification duration alarm for " + paramInt2 + " ms");
      localAlarmManager.set(3, SystemClock.elapsedRealtime() + paramInt2, localPendingIntent);
    }
  }

  public static void a(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      com.appboy.f.c.b(a, "Setting ticker for notification");
      paramBuilder.setTicker(paramBundle.getString("t"));
    }
  }

  public static void a(com.appboy.a.b paramb, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      com.appboy.f.c.b(a, "Setting title for notification");
      paramBuilder.setContentTitle(com.appboy.push.a.a.a(paramb, paramBundle.getString("t")));
    }
  }

  public static boolean a(int paramInt)
  {
    return (paramInt >= -2) && (paramInt <= 2);
  }

  public static boolean a(Context paramContext, com.appboy.a.b paramb, Bundle paramBundle)
  {
    if (!com.appboy.f.h.a(paramContext, "android.permission.WAKE_LOCK"))
      return false;
    if (!paramb.A())
      return false;
    if (Build.VERSION.SDK_INT >= 26)
    {
      NotificationChannel localNotificationChannel = a((NotificationManager)paramContext.getSystemService("notification"), paramBundle);
      if (localNotificationChannel == null)
      {
        com.appboy.f.c.b(a, "Not waking screen on Android O+ device, could not find notification channel.");
        return false;
      }
      int i = a(localNotificationChannel);
      if (i == 1)
      {
        com.appboy.f.c.b(a, "Not acquiring wake-lock for Android O+ notification with importance: " + i);
        return false;
      }
    }
    else if (c(paramBundle) == -2)
    {
      return false;
    }
    PowerManager.WakeLock localWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(268435482, a);
    localWakeLock.acquire();
    localWakeLock.release();
    return true;
  }

  public static boolean a(Context paramContext, com.appboy.a.b paramb, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (paramBundle.containsKey("ab_c"))
    {
      com.appboy.f.c.b(a, "Large icon not supported in story push.");
      return false;
    }
    if (paramBundle != null);
    try
    {
      if (paramBundle.containsKey("ab_li"))
      {
        com.appboy.f.c.b(a, "Setting large icon for notification");
        paramBuilder.setLargeIcon(com.appboy.f.b.a(paramContext, Uri.parse(paramBundle.getString("ab_li")), com.appboy.b.a.b));
        return true;
      }
      com.appboy.f.c.b(a, "Large icon bitmap url not present in extras. Attempting to use resource id instead.");
      int i = paramb.f();
      if (i != 0)
      {
        paramBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), i));
        return true;
      }
      com.appboy.f.c.b(a, "Large icon resource id not present for notification");
      com.appboy.f.c.b(a, "Large icon not set for notification");
      return false;
    }
    catch (Exception localException)
    {
      while (true)
        com.appboy.f.c.d(a, "Error setting large notification icon", localException);
    }
  }

  public static boolean a(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    return (localBundle != null) && ("true".equals(localBundle.getString("_ab")));
  }

  public static int b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("n"))
        try
        {
          int j = Integer.parseInt(paramBundle.getString("n"));
          com.appboy.f.c.b(a, "Using notification id provided in the message's extras bundle: " + j);
          return j;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          com.appboy.f.c.d(a, "Unable to parse notification id provided in the message's extras bundle. Using default notification id instead: -1", localNumberFormatException);
          return -1;
        }
      int i = (paramBundle.getString("t", "") + paramBundle.getString("a", "")).hashCode();
      com.appboy.f.c.b(a, "Message without notification id provided in the extras bundle received. Using a hash of the message: " + i);
      return i;
    }
    com.appboy.f.c.b(a, "Message without extras bundle received. Using default notification id: ");
    return -1;
  }

  public static Class<?> b()
  {
    if (com.appboy.e.a.booleanValue())
      return AppboyAdmReceiver.class;
    return AppboyFcmReceiver.class;
  }

  public static String b(Context paramContext, com.appboy.a.b paramb, Bundle paramBundle)
  {
    String str = a(paramBundle, "ab_nc");
    if (Build.VERSION.SDK_INT < 26)
    {
      if (str != null)
        return str;
      return "com_appboy_default_notification_channel";
    }
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    if (str != null)
    {
      if (localNotificationManager.getNotificationChannel(str) != null)
      {
        com.appboy.f.c.b(a, "Found notification channel in extras with id: " + str);
        return str;
      }
      com.appboy.f.c.b(a, "Notification channel from extras is invalid. No channel found with id: " + str);
    }
    if (localNotificationManager.getNotificationChannel("com_appboy_default_notification_channel") == null)
    {
      com.appboy.f.c.b(a, "Appboy default notification channel does not exist on device; creating");
      NotificationChannel localNotificationChannel = new NotificationChannel("com_appboy_default_notification_channel", paramb.m(), 3);
      localNotificationChannel.setDescription(paramb.n());
      localNotificationManager.createNotificationChannel(localNotificationChannel);
    }
    return "com_appboy_default_notification_channel";
  }

  public static void b(Context paramContext, Intent paramIntent)
  {
    try
    {
      com.appboy.f.c.b(a, "Sending notification deleted broadcast");
      b(paramContext, ".intent.APPBOY_PUSH_DELETED", paramIntent.getExtras());
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(a, "Exception occurred attempting to handle notification delete intent.", localException);
    }
  }

  public static void b(Context paramContext, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    com.appboy.f.c.b(a, "Setting delete intent.");
    try
    {
      paramBuilder.setDeleteIntent(a(paramContext, "com.appboy.action.APPBOY_PUSH_DELETED", paramBundle));
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(a, "Error setting delete intent.", localException);
    }
  }

  public static void b(Context paramContext, com.appboy.a.b paramb, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramBundle != null) && (paramBundle.containsKey("ab_pn")))
    {
      String str = b(paramContext, paramb, paramBundle);
      Bundle localBundle = a(paramBundle.getString("ab_pn"));
      NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext, str);
      b(paramb, localBuilder, localBundle);
      a(paramb, localBuilder, localBundle);
      d(localBuilder, localBundle);
      a(paramb, localBuilder);
      c(paramb, localBuilder, localBundle);
      paramBuilder.setPublicVersion(localBuilder.build());
    }
  }

  private static void b(Context paramContext, String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext.getPackageName() + paramString);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    f.a(paramContext, localIntent);
  }

  public static void b(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (paramBundle.containsKey("ab_c"))
    {
      com.appboy.f.c.b(a, "Set show when not supported in story push.");
      paramBuilder.setShowWhen(false);
    }
  }

  public static void b(com.appboy.a.b paramb, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      com.appboy.f.c.b(a, "Setting content for notification");
      paramBuilder.setContentText(com.appboy.push.a.a.a(paramb, paramBundle.getString("a")));
    }
  }

  @TargetApi(21)
  public static boolean b(int paramInt)
  {
    return (paramInt == -1) || (paramInt == 0) || (paramInt == 1);
  }

  public static boolean b(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle.containsKey("ab_sync_geos"))
    {
      if (Boolean.parseBoolean(paramBundle.getString("ab_sync_geos")))
      {
        com.appboy.b.a(paramContext, true);
        return true;
      }
      com.appboy.f.c.b(a, "Geofence sync key was false. Not syncing geofences.");
    }
    while (true)
    {
      return false;
      com.appboy.f.c.b(a, "Geofence sync key not included in push payload. Not syncing geofences.");
    }
  }

  public static boolean b(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    return (localBundle != null) && (localBundle.containsKey("t")) && (localBundle.containsKey("a"));
  }

  public static int c(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("p")));
    try
    {
      int i = Integer.parseInt(paramBundle.getString("p"));
      if (a(i))
        return i;
      com.appboy.f.c.e(a, "Received invalid notification priority " + i);
      return 0;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        com.appboy.f.c.d(a, "Unable to parse custom priority. Returning default priority of 0", localNumberFormatException);
    }
  }

  public static void c(Context paramContext, Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getBundleExtra("extra");
    if (localBundle == null)
      localBundle = new Bundle();
    localBundle.putString("cid", paramIntent.getStringExtra("cid"));
    localBundle.putString("source", "Appboy");
    String str = paramIntent.getStringExtra("uri");
    if (!com.appboy.f.i.c(str))
    {
      com.appboy.f.c.b(a, "Found a deep link " + str);
      boolean bool = "true".equalsIgnoreCase(paramIntent.getStringExtra("ab_use_webview"));
      com.appboy.f.c.b(a, "Use webview set to: " + bool);
      localBundle.putString("uri", str);
      localBundle.putBoolean("ab_use_webview", bool);
      UriAction localUriAction = ActionFactory.createUriActionFromUrlString(str, localBundle, bool, com.appboy.b.e.a);
      AppboyNavigator.getAppboyNavigator().gotoUri(paramContext, localUriAction);
      return;
    }
    com.appboy.f.c.b(a, "Push notification had no deep link. Opening main activity.");
    paramContext.startActivity(UriUtils.getMainActivityIntent(paramContext, localBundle));
  }

  public static void c(Context paramContext, Bundle paramBundle)
  {
    if (!paramBundle.containsKey("ab_c"));
    while (!paramBundle.getBoolean("appboy_story_newly_received", false))
      return;
    String str = a.a(0, paramBundle, "ab_c*_i");
    int i = 0;
    while (!com.appboy.f.i.c(str))
    {
      com.appboy.f.c.a(a, "Pre-fetching bitmap at URL: " + str);
      com.appboy.a.a(paramContext).h().a(paramContext, str, com.appboy.b.a.c);
      i++;
      str = a.a(i, paramBundle, "ab_c*_i");
    }
    paramBundle.putBoolean("appboy_story_newly_received", false);
  }

  public static void c(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("sd")))
    {
      String str = paramBundle.getString("sd");
      if (str != null)
      {
        if (str.equals("d"))
        {
          com.appboy.f.c.b(a, "Setting default sound for notification.");
          paramBuilder.setDefaults(1);
        }
      }
      else
        return;
      com.appboy.f.c.b(a, "Setting sound for notification via uri.");
      paramBuilder.setSound(Uri.parse(str));
      return;
    }
    com.appboy.f.c.b(a, "Sound key not present in notification extras. Not setting sound for notification.");
  }

  public static void c(com.appboy.a.b paramb, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramBundle != null) && (paramBundle.containsKey("ac")))
      {
        com.appboy.f.c.b(a, "Using accent color for notification from extras bundle");
        paramBuilder.setColor((int)Long.parseLong(paramBundle.getString("ac")));
      }
    }
    else
      return;
    com.appboy.f.c.b(a, "Using default accent color for notification");
    paramBuilder.setColor(paramb.p());
  }

  public static void d(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.hasExtra("nid"))
      {
        int i = paramIntent.getIntExtra("nid", -1);
        com.appboy.f.c.b(a, "Cancelling notification action with id: " + i);
        ((NotificationManager)paramContext.getSystemService("notification")).cancel("appboy_notification", i);
      }
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(a, "Exception occurred handling cancel notification intent.", localException);
    }
  }

  public static void d(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      String str = paramBundle.getString("cid");
      if (!com.appboy.f.i.c(str))
      {
        com.appboy.a.a(paramContext).c(str);
        return;
      }
      com.appboy.f.c.b(a, "Could not log push delivery event due to null or blank campaign id in push extras bundle: " + paramBundle);
      return;
    }
    com.appboy.f.c.b(a, "Could not log push delivery event due to null push extras bundle.");
  }

  public static void d(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("s")))
    {
      String str = paramBundle.getString("s");
      if (str != null)
      {
        com.appboy.f.c.b(a, "Setting summary text for notification");
        paramBuilder.setSubText(str);
      }
      return;
    }
    com.appboy.f.c.b(a, "Summary text not present in notification extras. Not setting summary text for notification.");
  }

  public static boolean d(Bundle paramBundle)
  {
    if (paramBundle != null)
      try
      {
        if (paramBundle.containsKey("appboy_uninstall_tracking"))
          return true;
        Bundle localBundle = paramBundle.getBundle("extra");
        if (localBundle != null)
        {
          boolean bool = localBundle.containsKey("appboy_uninstall_tracking");
          return bool;
        }
      }
      catch (Exception localException)
      {
        com.appboy.f.c.d(a, "Failed to determine if push is uninstall tracking. Returning false.", localException);
      }
    return false;
  }

  public static void e(Context paramContext, Intent paramIntent)
  {
    try
    {
      com.appboy.a.a(paramContext).a(paramIntent.getStringExtra("appboy_campaign_id"), paramIntent.getStringExtra("appboy_story_page_id"));
      if (!com.appboy.f.i.c(paramIntent.getStringExtra("appboy_action_uri")))
      {
        paramIntent.putExtra("uri", paramIntent.getStringExtra("appboy_action_uri"));
        String str = paramIntent.getStringExtra("appboy_action_use_webview");
        if (!com.appboy.f.i.c(str))
          paramIntent.putExtra("ab_use_webview", str);
      }
      while (true)
      {
        paramContext.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f(paramContext, paramIntent);
        if (!new com.appboy.a.b(paramContext).k())
          break;
        c(paramContext, paramIntent);
        return;
        paramIntent.removeExtra("uri");
      }
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(a, "Caught exception while handling story click.", localException);
    }
  }

  public static void e(Context paramContext, Bundle paramBundle)
  {
    if ((!com.appboy.e.a.booleanValue()) && (paramBundle.containsKey("ab_cd")))
    {
      String str1 = paramBundle.getString("ab_cd", null);
      String str2 = paramBundle.getString("ab_cd_uid", null);
      com.appboy.f.c.b(a, "Push contains associated Content Cards card. User id: " + str2 + " Card data: " + str1);
      com.appboy.b.a(paramContext, str1, str2);
    }
  }

  public static void e(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      com.appboy.f.c.b(a, "Setting priority for notification");
      paramBuilder.setPriority(c(paramBundle));
    }
  }

  static void f(Context paramContext, Intent paramIntent)
  {
    com.appboy.f.c.b(a, "Sending notification opened broadcast");
    b(paramContext, ".intent.APPBOY_NOTIFICATION_OPENED", paramIntent.getExtras());
  }

  public static void f(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramBundle != null) && (paramBundle.containsKey("ab_ct")))
      {
        com.appboy.f.c.b(a, "Setting category for notification");
        paramBuilder.setCategory(paramBundle.getString("ab_ct"));
        return;
      }
      com.appboy.f.c.b(a, "Category not present in notification extras. Not setting category for notification.");
      return;
    }
    com.appboy.f.c.b(a, "Notification category not supported on this android version. Not setting category for notification.");
  }

  private static void g(Context paramContext, Intent paramIntent)
  {
    com.appboy.a.a(paramContext).a(paramIntent);
  }

  public static void g(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramBundle == null) || (!paramBundle.containsKey("ab_vs")))
        return;
      try
      {
        int i = Integer.parseInt(paramBundle.getString("ab_vs"));
        if (b(i))
        {
          com.appboy.f.c.b(a, "Setting visibility for notification");
          paramBuilder.setVisibility(i);
          return;
        }
        com.appboy.f.c.e(a, "Received invalid notification visibility " + i);
        return;
      }
      catch (Exception localException)
      {
        com.appboy.f.c.d(a, "Failed to parse visibility from notificationExtras", localException);
        return;
      }
    }
    com.appboy.f.c.b(a, "Notification visibility not supported on this android version. Not setting visibility for notification.");
  }

  public static void h(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    String str;
    if (Build.VERSION.SDK_INT >= 26)
    {
      str = paramBundle.getString("ab_bc", null);
      if (com.appboy.f.i.c(str));
    }
    try
    {
      paramBuilder.setNumber(Integer.parseInt(str));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      com.appboy.f.c.d(a, "Caught exception while setting number on notification.", localNumberFormatException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.push.d
 * JD-Core Version:    0.6.2
 */