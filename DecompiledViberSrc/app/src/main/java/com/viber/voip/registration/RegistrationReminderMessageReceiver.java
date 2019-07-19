package com.viber.voip.registration;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.a;
import com.viber.voip.notif.e.m;
import com.viber.voip.notif.g;
import com.viber.voip.settings.b;
import com.viber.voip.settings.d.b;
import java.util.concurrent.TimeUnit;

public class RegistrationReminderMessageReceiver extends BroadcastReceiver
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.HOURS.toMillis(3L);
  private static final long c = TimeUnit.HOURS.toMillis(24L);

  public static String a(Context paramContext, int paramInt)
  {
    int i;
    if (4 == paramInt)
      i = R.string.registration_reminder_message_2_steps;
    while (i == 0)
    {
      return null;
      if (paramInt != 0)
      {
        i = 0;
        if (1 != paramInt);
      }
      else
      {
        i = R.string.registration_reminder_message_1_step;
      }
    }
    return paramContext.getString(i);
  }

  public static void a(Context paramContext)
  {
    if (d.b.e.d() > 0);
    for (long l = c; ; l = b)
    {
      ((AlarmManager)paramContext.getSystemService("alarm")).set(2, l + SystemClock.elapsedRealtime(), c(paramContext));
      return;
    }
  }

  private void a(Context paramContext, String paramString)
  {
    int i = 1;
    if (d.b.e.d() < i);
    while (true)
    {
      g.a(paramContext).a().a(paramString, i);
      return;
      int j = 0;
    }
  }

  public static void b(Context paramContext)
  {
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel(c(paramContext));
    d.b.e.e();
    g.a(paramContext).a().c();
  }

  private static PendingIntent c(Context paramContext)
  {
    return PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, RegistrationReminderMessageReceiver.class), 134217728);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = ViberApplication.isActivated();
    if ("com.viber.voip.action.REGISTRATION_REMINDER_CANCELED_ACTION".equals(paramIntent.getAction()))
    {
      d.b.e.g();
      a(ViberApplication.getApplication());
      a.a().d();
    }
    while (bool)
      return;
    String str = a(paramContext, ViberApplication.getInstance().getActivationController().getStep());
    if (str != null)
      a(paramContext, str);
    a.a().c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.RegistrationReminderMessageReceiver
 * JD-Core Version:    0.6.2
 */