package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.yandex.metrica.ConfigurationJobService;

@TargetApi(26)
public class eo
  implements ep, es
{
  private final Context a;
  private final JobScheduler b;

  public eo(Context paramContext)
  {
    this(paramContext, (JobScheduler)paramContext.getSystemService("jobscheduler"));
  }

  eo(Context paramContext, JobScheduler paramJobScheduler)
  {
    this.a = paramContext;
    this.b = paramJobScheduler;
  }

  public void a()
  {
    this.b.cancel(1512302345);
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    JobInfo.Builder localBuilder = new JobInfo.Builder(1512302345, new ComponentName(this.a.getPackageName(), ConfigurationJobService.class.getName())).setMinimumLatency(paramLong);
    if (paramBoolean)
      localBuilder.setOverrideDeadline(paramLong);
    this.b.schedule(localBuilder.build());
  }

  public void a(Bundle paramBundle)
  {
    JobInfo localJobInfo = new JobInfo.Builder(1512302346, new ComponentName(this.a.getPackageName(), ConfigurationJobService.class.getName())).setTransientExtras(paramBundle).setOverrideDeadline(10L).build();
    this.b.schedule(localJobInfo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.eo
 * JD-Core Version:    0.6.2
 */