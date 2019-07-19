package com.appboy.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Action.Builder;
import android.support.v4.app.NotificationCompat.Builder;
import com.appboy.a.b;
import com.appboy.f.c;
import com.appboy.f.f;
import com.appboy.f.i;

public class a
{
  private static final String a = c.a(a.class);

  public static String a(int paramInt, Bundle paramBundle, String paramString)
  {
    return a(paramInt, paramBundle, paramString, "");
  }

  public static String a(int paramInt, Bundle paramBundle, String paramString1, String paramString2)
  {
    String str = paramBundle.getString(paramString1.replace("*", String.valueOf(paramInt)));
    if (str == null)
      return paramString2;
    return str;
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    String str;
    int i;
    while (true)
    {
      try
      {
        str = paramIntent.getStringExtra("appboy_action_type");
        if (i.c(str))
        {
          c.d(a, "Notification action button type was blank or null. Doing nothing.");
          return;
        }
        i = paramIntent.getIntExtra("nid", -1);
        a(paramContext, paramIntent, str);
        if ((!str.equals("ab_uri")) && (!str.equals("ab_open")))
          break;
        d.a(paramContext, i);
        paramContext.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        if ((str.equals("ab_uri")) && (paramIntent.getExtras().containsKey("appboy_action_uri")))
        {
          paramIntent.putExtra("uri", paramIntent.getStringExtra("appboy_action_uri"));
          if (paramIntent.getExtras().containsKey("appboy_action_use_webview"))
            paramIntent.putExtra("ab_use_webview", paramIntent.getStringExtra("appboy_action_use_webview"));
          d.f(paramContext, paramIntent);
          if (!new b(paramContext).k())
            return;
          d.c(paramContext, paramIntent);
          return;
        }
      }
      catch (Exception localException)
      {
        c.d(a, "Caught exception while handling notification action button click.", localException);
        return;
      }
      paramIntent.removeExtra("uri");
    }
    if (str.equals("ab_none"))
    {
      d.a(paramContext, i);
      return;
    }
    c.d(a, "Unknown notification action button clicked. Doing nothing.");
  }

  private static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    String str1 = paramIntent.getStringExtra("cid");
    String str2 = paramIntent.getStringExtra("appboy_action_id");
    com.appboy.a.a(paramContext).a(str1, str2, paramString);
  }

  public static void a(Context paramContext, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (paramBundle == null);
    while (true)
    {
      try
      {
        c.d(a, "Notification extras were null. Doing nothing.");
        return;
        if (!i.c(a(i, paramBundle, "ab_a*_a")))
        {
          a(paramContext, paramBuilder, paramBundle, i);
          i++;
          continue;
        }
      }
      catch (Exception localException)
      {
        c.d(a, "Caught exception while adding notification action buttons.", localException);
      }
      return;
      int i = 0;
    }
  }

  private static void a(Context paramContext, NotificationCompat.Builder paramBuilder, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = new Bundle(paramBundle);
    String str = a(paramInt, paramBundle, "ab_a*_a");
    localBundle.putInt("appboy_action_index", paramInt);
    localBundle.putString("appboy_action_type", str);
    localBundle.putString("appboy_action_id", a(paramInt, paramBundle, "ab_a*_id"));
    localBundle.putString("appboy_action_uri", a(paramInt, paramBundle, "ab_a*_uri"));
    localBundle.putString("appboy_action_use_webview", a(paramInt, paramBundle, "ab_a*_use_webview"));
    Intent localIntent2;
    if (str.equals("ab_none"))
    {
      c.a(a, "Adding notification action with type: " + str + " . Setting intent class to notification receiver.");
      localIntent2 = new Intent("com.appboy.action.APPBOY_ACTION_CLICKED").setClass(paramContext, d.b());
      localIntent2.putExtras(localBundle);
    }
    Intent localIntent1;
    for (PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, f.a(), localIntent2, 134217728); ; localPendingIntent = PendingIntent.getActivity(paramContext, f.a(), localIntent1, 134217728))
    {
      NotificationCompat.Action.Builder localBuilder = new NotificationCompat.Action.Builder(0, a(paramInt, paramBundle, "ab_a*_t"), localPendingIntent);
      localBuilder.addExtras(new Bundle(localBundle));
      paramBuilder.addAction(localBuilder.build());
      return;
      c.a(a, "Adding notification action with type: " + str + " Setting intent class to AppboyNotificationRoutingActivity");
      localIntent1 = new Intent("com.appboy.action.APPBOY_ACTION_CLICKED").setClass(paramContext, AppboyNotificationRoutingActivity.class);
      localIntent1.putExtras(localBundle);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.push.a
 * JD-Core Version:    0.6.2
 */