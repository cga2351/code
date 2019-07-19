package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.h;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable
  implements Runnable
{
  private static final String a = i.a("ForceStopRunnable");
  private static final long b = TimeUnit.DAYS.toMillis(3650L);
  private final Context c;
  private final h d;

  public ForceStopRunnable(Context paramContext, h paramh)
  {
    this.c = paramContext.getApplicationContext();
    this.d = paramh;
  }

  private static PendingIntent a(Context paramContext, int paramInt)
  {
    return PendingIntent.getBroadcast(paramContext, -1, a(paramContext), paramInt);
  }

  static Intent a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext, BroadcastReceiver.class));
    localIntent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
    return localIntent;
  }

  static void b(Context paramContext)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    PendingIntent localPendingIntent = a(paramContext, 134217728);
    long l = System.currentTimeMillis() + b;
    if (localAlarmManager != null)
    {
      if (Build.VERSION.SDK_INT >= 19)
        localAlarmManager.setExact(0, l, localPendingIntent);
    }
    else
      return;
    localAlarmManager.set(0, l, localPendingIntent);
  }

  public boolean a()
  {
    if (a(this.c, 536870912) == null)
    {
      b(this.c);
      return true;
    }
    return false;
  }

  boolean b()
  {
    return this.d.i().a();
  }

  public void run()
  {
    if (b())
    {
      i.a().b(a, "Rescheduling Workers.", new Throwable[0]);
      this.d.j();
      this.d.i().a(false);
    }
    while (true)
    {
      this.d.k();
      return;
      if (a())
      {
        i.a().b(a, "Application was force-stopped, rescheduling.", new Throwable[0]);
        this.d.j();
      }
      else
      {
        WorkDatabase localWorkDatabase = this.d.d();
        k localk = localWorkDatabase.m();
        try
        {
          localWorkDatabase.f();
          List localList = localk.d();
          if ((localList == null) || (localList.isEmpty()))
            break label205;
          i.a().b(a, "Found unfinished work, scheduling it.", new Throwable[0]);
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
            localk.b(((j)localIterator.next()).a, -1L);
        }
        finally
        {
          localWorkDatabase.g();
        }
        androidx.work.impl.e.a(this.d.e(), localWorkDatabase, this.d.f());
        label205: localWorkDatabase.h();
        localWorkDatabase.g();
        i.a().b(a, "Unfinished Workers exist, rescheduling.", new Throwable[0]);
      }
    }
  }

  public static class BroadcastReceiver extends BroadcastReceiver
  {
    private static final String a = i.a("ForceStopRunnable$Rcvr");

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && ("ACTION_FORCE_STOP_RESCHEDULE".equals(paramIntent.getAction())))
      {
        i.a().a(a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
        ForceStopRunnable.b(paramContext);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.ForceStopRunnable
 * JD-Core Version:    0.6.2
 */