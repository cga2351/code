package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzey;
import com.google.android.gms.measurement.internal.zzfc;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService
  implements zzfc
{
  private zzey<AppMeasurementJobService> zzadc;

  private final zzey<AppMeasurementJobService> zzfz()
  {
    if (this.zzadc == null)
      this.zzadc = new zzey(this);
    return this.zzadc;
  }

  public final boolean callServiceStopSelfResult(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public final void onCreate()
  {
    super.onCreate();
    zzfz().onCreate();
  }

  public final void onDestroy()
  {
    zzfz().onDestroy();
    super.onDestroy();
  }

  public final void onRebind(Intent paramIntent)
  {
    zzfz().onRebind(paramIntent);
  }

  public final boolean onStartJob(JobParameters paramJobParameters)
  {
    return zzfz().onStartJob(paramJobParameters);
  }

  public final boolean onStopJob(JobParameters paramJobParameters)
  {
    return false;
  }

  public final boolean onUnbind(Intent paramIntent)
  {
    return zzfz().onUnbind(paramIntent);
  }

  @TargetApi(24)
  public final void zza(JobParameters paramJobParameters, boolean paramBoolean)
  {
    jobFinished(paramJobParameters, false);
  }

  public final void zza(Intent paramIntent)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementJobService
 * JD-Core Version:    0.6.2
 */