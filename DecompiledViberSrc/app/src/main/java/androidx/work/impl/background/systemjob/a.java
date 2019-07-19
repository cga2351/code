package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobInfo.TriggerContentUri;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import androidx.work.c;
import androidx.work.d;
import androidx.work.d.a;
import androidx.work.i;
import java.util.Iterator;
import java.util.Set;

class a
{
  private static final String a = i.a("SystemJobInfoConverter");
  private final ComponentName b;

  a(Context paramContext)
  {
    this.b = new ComponentName(paramContext.getApplicationContext(), SystemJobService.class);
  }

  static int a(androidx.work.j paramj)
  {
    int i = 1.a[paramj.ordinal()];
    int j = 0;
    switch (i)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    do
    {
      do
      {
        i.a().b(a, String.format("API version too low. Cannot convert network type value %s", new Object[] { paramj }), new Throwable[0]);
        j = 1;
        return j;
        return 1;
        return 2;
      }
      while (Build.VERSION.SDK_INT < 24);
      return 3;
    }
    while (Build.VERSION.SDK_INT < 26);
    return 4;
  }

  private static JobInfo.TriggerContentUri a(d.a parama)
  {
    if (parama.b());
    for (int i = 1; ; i = 0)
      return new JobInfo.TriggerContentUri(parama.a(), i);
  }

  JobInfo a(androidx.work.impl.b.j paramj, int paramInt)
  {
    c localc = paramj.j;
    int i = a(localc.a());
    PersistableBundle localPersistableBundle = new PersistableBundle();
    localPersistableBundle.putString("EXTRA_WORK_SPEC_ID", paramj.a);
    localPersistableBundle.putBoolean("EXTRA_IS_PERIODIC", paramj.a());
    JobInfo.Builder localBuilder = new JobInfo.Builder(paramInt, this.b).setRequiredNetworkType(i).setRequiresCharging(localc.b()).setRequiresDeviceIdle(localc.c()).setExtras(localPersistableBundle);
    int j;
    if (!localc.c())
    {
      if (paramj.l == androidx.work.a.b)
      {
        j = 0;
        localBuilder.setBackoffCriteria(paramj.m, j);
      }
    }
    else
    {
      if (!paramj.a())
        break label239;
      if (Build.VERSION.SDK_INT < 24)
        break label211;
      localBuilder.setPeriodic(paramj.h, paramj.i);
    }
    while (true)
      label144: if ((Build.VERSION.SDK_INT >= 24) && (localc.i()))
      {
        Iterator localIterator = localc.h().a().iterator();
        while (true)
          if (localIterator.hasNext())
          {
            localBuilder.addTriggerContentUri(a((d.a)localIterator.next()));
            continue;
            j = 1;
            break;
            label211: i.a().b(a, "Flex duration is currently not supported before API 24. Ignoring.", new Throwable[0]);
            localBuilder.setPeriodic(paramj.h);
            break label144;
            label239: localBuilder.setMinimumLatency(paramj.g);
            break label144;
          }
        localBuilder.setTriggerContentUpdateDelay(localc.f());
        localBuilder.setTriggerContentMaxDelay(localc.g());
      }
    localBuilder.setPersisted(false);
    if (Build.VERSION.SDK_INT >= 26)
    {
      localBuilder.setRequiresBatteryNotLow(localc.d());
      localBuilder.setRequiresStorageNotLow(localc.e());
    }
    return localBuilder.build();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemjob.a
 * JD-Core Version:    0.6.2
 */