package com.appboy;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.appboy.a.b;
import com.appboy.f.c;
import com.appboy.push.d;

public final class AppboyAdmReceiver extends BroadcastReceiver
{
  private static final String a = c.a(AppboyAdmReceiver.class);

  boolean a(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("error");
    String str2 = paramIntent.getStringExtra("registration_id");
    String str3 = paramIntent.getStringExtra("unregistered");
    if (str1 != null)
      c.e(a, "Error during ADM registration: " + str1);
    while (true)
    {
      return true;
      if (str2 != null)
      {
        c.c(a, "Registering for ADM messages with registrationId: " + str2);
        a.a(paramContext).e(str2);
      }
      else
      {
        if (str3 == null)
          break;
        c.d(a, "The device was un-registered from ADM: " + str3);
      }
    }
    c.d(a, "The ADM registration intent is missing error information, registration id, and unregistration confirmation. Ignoring.");
    return false;
  }

  boolean a(b paramb, Context paramContext, Intent paramIntent)
  {
    c.c(a, "Received ADM registration. Message: " + paramIntent.toString());
    if (paramb.c())
    {
      c.b(a, "ADM enabled in appboy.xml. Continuing to process ADM registration intent.");
      a(paramContext, paramIntent);
      return true;
    }
    c.d(a, "ADM not enabled in appboy.xml. Ignoring ADM registration intent. Note: you must set com_appboy_push_adm_messaging_registration_enabled to true in your appboy.xml to enable ADM.");
    return false;
  }

  boolean b(Context paramContext, Intent paramIntent)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    if ("deleted_messages".equals(paramIntent.getStringExtra("message_type")))
    {
      int k = paramIntent.getIntExtra("total_deleted", -1);
      if (k == -1)
        c.e(a, "Unable to parse ADM message. Intent: " + paramIntent.toString());
      while (true)
      {
        return false;
        c.c(a, "ADM deleted " + k + " messages. Fetch them from Appboy.");
      }
    }
    Bundle localBundle1 = paramIntent.getExtras();
    c.b(a, "Push message payload received: " + localBundle1);
    if (d.d(localBundle1))
    {
      c.c(a, "Push message is uninstall tracking push. Doing nothing. Not forwarding this notification to broadcast receivers.");
      return false;
    }
    if (!localBundle1.containsKey("appboy_push_received_timestamp"))
      localBundle1.putLong("appboy_push_received_timestamp", System.currentTimeMillis());
    d.d(paramContext, localBundle1);
    Bundle localBundle2 = d.a(localBundle1);
    localBundle1.putBundle("extra", localBundle2);
    if (d.b(paramIntent))
    {
      int i = d.b(localBundle1);
      localBundle1.putInt("nid", i);
      b localb = new b(paramContext);
      Notification localNotification = d.a().a(localb, paramContext, localBundle1, localBundle2);
      if (localNotification == null)
      {
        c.b(a, "Notification created by notification factory was null. Not displaying notification.");
        return false;
      }
      localNotificationManager.notify("appboy_notification", i, localNotification);
      d.a(paramContext, localBundle1);
      d.a(paramContext, localb, localBundle1);
      if (localBundle1.containsKey("nd"))
      {
        int j = Integer.parseInt(localBundle1.getString("nd"));
        d.a(paramContext, getClass(), i, j);
      }
      return true;
    }
    d.a(paramContext, localBundle1);
    d.b(paramContext, localBundle1);
    return false;
  }

  void c(Context paramContext, Intent paramIntent)
  {
    if (d.a(paramIntent))
      new a(paramContext, paramIntent);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    c.c(a, "Received broadcast message. Message: " + paramIntent.toString());
    String str = paramIntent.getAction();
    if ("com.amazon.device.messaging.intent.REGISTRATION".equals(str))
    {
      a(new b(paramContext), paramContext, paramIntent);
      return;
    }
    if ("com.amazon.device.messaging.intent.RECEIVE".equals(str))
    {
      c(paramContext, paramIntent);
      return;
    }
    if ("com.appboy.action.CANCEL_NOTIFICATION".equals(str))
    {
      d.d(paramContext, paramIntent);
      return;
    }
    if ("com.appboy.action.APPBOY_ACTION_CLICKED".equals(str))
    {
      com.appboy.push.a.a(paramContext, paramIntent);
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
    c.d(a, "The ADM receiver received a message not sent from Appboy. Ignoring the message.");
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
        AppboyAdmReceiver.this.b(this.b, this.c);
        return null;
      }
      catch (Exception localException)
      {
        while (true)
          c.d(AppboyAdmReceiver.a(), "Failed to create and display notification.", localException);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.AppboyAdmReceiver
 * JD-Core Version:    0.6.2
 */