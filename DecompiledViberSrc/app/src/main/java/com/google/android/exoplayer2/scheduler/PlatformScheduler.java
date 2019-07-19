package com.google.android.exoplayer2.scheduler;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.g.ag;

@TargetApi(21)
public final class PlatformScheduler
{
  private static void b(String paramString)
  {
  }

  public static final class PlatformSchedulerService extends JobService
  {
    public boolean onStartJob(JobParameters paramJobParameters)
    {
      PlatformScheduler.a("PlatformSchedulerService started");
      PersistableBundle localPersistableBundle = paramJobParameters.getExtras();
      if (new a(localPersistableBundle.getInt("requirements")).a(this))
      {
        PlatformScheduler.a("Requirements are met");
        String str1 = localPersistableBundle.getString("service_action");
        String str2 = localPersistableBundle.getString("service_package");
        Intent localIntent = new Intent(str1).setPackage(str2);
        PlatformScheduler.a("Starting service action: " + str1 + " package: " + str2);
        ag.a(this, localIntent);
      }
      while (true)
      {
        return false;
        PlatformScheduler.a("Requirements are not met");
        jobFinished(paramJobParameters, true);
      }
    }

    public boolean onStopJob(JobParameters paramJobParameters)
    {
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.scheduler.PlatformScheduler
 * JD-Core Version:    0.6.2
 */