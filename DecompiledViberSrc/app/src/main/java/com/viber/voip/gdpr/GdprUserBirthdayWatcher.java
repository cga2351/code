package com.viber.voip.gdpr;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.v;

public class GdprUserBirthdayWatcher extends BroadcastReceiver
{
  private static final Logger a = ViberEnv.getLogger();

  public static void a(Context paramContext)
  {
    b(paramContext);
    long l = d.v.i.d();
    if (l == d.v.i.f());
    e locale;
    do
    {
      return;
      locale = e.a(l);
    }
    while (!locale.c());
    a(paramContext, locale.a());
  }

  private static void a(Context paramContext, long paramLong)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager != null)
    {
      if (a.d())
        localAlarmManager.setExact(1, paramLong, c(paramContext));
    }
    else
      return;
    localAlarmManager.set(1, paramLong, c(paramContext));
  }

  private static void b(Context paramContext)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager != null)
      localAlarmManager.cancel(c(paramContext));
  }

  private static PendingIntent c(Context paramContext)
  {
    return PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, GdprUserBirthdayWatcher.class), 134217728);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    f.a(paramContext).a(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.GdprUserBirthdayWatcher
 * JD-Core Version:    0.6.2
 */