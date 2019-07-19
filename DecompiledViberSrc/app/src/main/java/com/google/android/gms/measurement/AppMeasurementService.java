package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzey;
import com.google.android.gms.measurement.internal.zzfc;

public final class AppMeasurementService extends Service
  implements zzfc
{
  private zzey<AppMeasurementService> zzadc;

  private final zzey<AppMeasurementService> zzfz()
  {
    if (this.zzadc == null)
      this.zzadc = new zzey(this);
    return this.zzadc;
  }

  public final boolean callServiceStopSelfResult(int paramInt)
  {
    return stopSelfResult(paramInt);
  }

  public final IBinder onBind(Intent paramIntent)
  {
    return zzfz().onBind(paramIntent);
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

  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return zzfz().onStartCommand(paramIntent, paramInt1, paramInt2);
  }

  public final boolean onUnbind(Intent paramIntent)
  {
    return zzfz().onUnbind(paramIntent);
  }

  public final void zza(JobParameters paramJobParameters, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }

  public final void zza(Intent paramIntent)
  {
    AppMeasurementReceiver.completeWakefulIntent(paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementService
 * JD-Core Version:    0.6.2
 */