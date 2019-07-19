package com.appboy;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import com.appboy.a.b;
import com.appboy.f.c;
import com.appboy.push.a;
import com.appboy.push.d;

public final class AppboyFcmReceiver extends BroadcastReceiver
{
  private static final String a = c.a(AppboyFcmReceiver.class);

  boolean a(Context paramContext, Intent paramIntent)
  {
    NotificationManagerCompat localNotificationManagerCompat = NotificationManagerCompat.from(paramContext);
    if ("deleted_messages".equals(paramIntent.getStringExtra("message_type")))
    {
      int k = paramIntent.getIntExtra("total_deleted", -1);
      if (k == -1)
      {
        c.e(a, "Unable to parse FCM message. Intent: " + paramIntent.toString());
        return false;
      }
      c.c(a, "FCM deleted " + k + " messages. Fetch them from Appboy.");
      return false;
    }
    Bundle localBundle1 = paramIntent.getExtras();
    c.c(a, "Push message payload received: " + localBundle1);
    Bundle localBundle2 = d.a(localBundle1);
    localBundle1.putBundle("extra", localBundle2);
    if (!localBundle1.containsKey("appboy_push_received_timestamp"))
      localBundle1.putLong("appboy_push_received_timestamp", System.currentTimeMillis());
    if (d.d(localBundle1))
    {
      c.c(a, "Push message is uninstall tracking push. Doing nothing. Not forwarding this notification to broadcast receivers.");
      return false;
    }
    d.e(paramContext, localBundle1);
    if (d.b(paramIntent))
    {
      c.b(a, "Received notification push");
      int i = d.b(localBundle1);
      localBundle1.putInt("nid", i);
      b localb = new b(paramContext);
      i locali = d.a();
      if (localBundle1.containsKey("ab_c"))
        if (!localBundle1.containsKey("appboy_story_newly_received"))
        {
          c.b(a, "Received the initial push story notification.");
          localBundle1.putBoolean("appboy_story_newly_received", true);
          d.d(paramContext, localBundle1);
        }
      Notification localNotification;
      while (true)
      {
        localNotification = locali.a(localb, paramContext, localBundle1, localBundle2);
        if (localNotification != null)
          break;
        c.b(a, "Notification created by notification factory was null. Not displaying notification.");
        return false;
        d.d(paramContext, localBundle1);
      }
      localNotificationManagerCompat.notify("appboy_notification", i, localNotification);
      d.a(paramContext, localBundle1);
      d.a(paramContext, localb, localBundle1);
      if ((localBundle1 != null) && (localBundle1.containsKey("nd")))
      {
        int j = Integer.parseInt(localBundle1.getString("nd"));
        d.a(paramContext, getClass(), i, j);
      }
      return true;
    }
    c.b(a, "Received data push");
    d.d(paramContext, localBundle1);
    d.a(paramContext, localBundle1);
    d.b(paramContext, localBundle1);
    return false;
  }

  void b(Context paramContext, Intent paramIntent)
  {
    if (d.a(paramIntent))
      new a(paramContext, paramIntent);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    c.c(a, "Received broadcast message. Message: " + paramIntent.toString());
    String str = paramIntent.getAction();
    if (("com.google.android.c2dm.intent.RECEIVE".equals(str)) || ("firebase_messaging_service_routing_action".equals(str)))
    {
      b(paramContext, paramIntent);
      return;
    }
    if ("com.appboy.action.CANCEL_NOTIFICATION".equals(str))
    {
      d.d(paramContext, paramIntent);
      return;
    }
    if ("com.appboy.action.APPBOY_ACTION_CLICKED".equals(str))
    {
      a.a(paramContext, paramIntent);
      return;
    }
    if ("com.appboy.action.STORY_TRAVERSE".equals(str))
    {
      b(paramContext, paramIntent);
      return;
    }
    if ("com.appboy.action.APPBOY_STORY_CLICKED".equals(str))
    {
      d.e(paramContext, paramIntent);
      return;
    }
    if ("com.appboy.action.APPBOY_PUSH_CLICKED".equals(str))
    {
      d.a(paramContext, paramIntent);
      return;
    }
    if ("com.appboy.action.APPBOY_PUSH_DELETED".equals(str))
    {
      d.b(paramContext, paramIntent);
      return;
    }
    c.d(a, "The FCM receiver received a message not sent from Appboy. Ignoring the message.");
  }

  public class a extends AsyncTask<Void, Void, Void>
  {
    private final Context b;
    private final Intent c;

    public a(Context paramIntent, Intent arg3)
    {
      this.b = paramIntent;
      Object localObject;
      this.c = localObject;
      execute(new Void[0]);
    }

    protected Void a(Void[] paramArrayOfVoid)
    {
      try
      {
        AppboyFcmReceiver.this.a(this.b, this.c);
        return null;
      }
      catch (Exception localException)
      {
        while (true)
          c.d(AppboyFcmReceiver.a(), "Failed to create and display notification.", localException);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.AppboyFcmReceiver
 * JD-Core Version:    0.6.2
 */