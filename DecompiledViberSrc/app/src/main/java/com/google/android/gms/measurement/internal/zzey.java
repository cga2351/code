package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.Preconditions;

public final class zzey<T extends Context,  extends zzfc>
{
  private final T zzaby;

  public zzey(T paramT)
  {
    Preconditions.checkNotNull(paramT);
    this.zzaby = paramT;
  }

  private final void zzb(Runnable paramRunnable)
  {
    zzfn localzzfn = zzfn.zzn(this.zzaby);
    localzzfn.zzgs().zzc(new zzfb(this, localzzfn, paramRunnable));
  }

  private final zzas zzgt()
  {
    return zzbw.zza(this.zzaby, null).zzgt();
  }

  public final IBinder onBind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzgt().zzjg().zzby("onBind called with null intent");
      return null;
    }
    String str = paramIntent.getAction();
    if ("com.google.android.gms.measurement.START".equals(str))
      return new zzby(zzfn.zzn(this.zzaby));
    zzgt().zzjj().zzg("onBind received unknown action", str);
    return null;
  }

  public final void onCreate()
  {
    zzbw localzzbw = zzbw.zza(this.zzaby, null);
    zzas localzzas = localzzbw.zzgt();
    localzzbw.zzgw();
    localzzas.zzjo().zzby("Local AppMeasurementService is starting up");
  }

  public final void onDestroy()
  {
    zzbw localzzbw = zzbw.zza(this.zzaby, null);
    zzas localzzas = localzzbw.zzgt();
    localzzbw.zzgw();
    localzzas.zzjo().zzby("Local AppMeasurementService is shutting down");
  }

  public final void onRebind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzgt().zzjg().zzby("onRebind called with null intent");
      return;
    }
    String str = paramIntent.getAction();
    zzgt().zzjo().zzg("onRebind called. action", str);
  }

  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzbw localzzbw = zzbw.zza(this.zzaby, null);
    zzas localzzas = localzzbw.zzgt();
    if (paramIntent == null)
      localzzas.zzjj().zzby("AppMeasurementService started with null intent");
    String str;
    do
    {
      return 2;
      str = paramIntent.getAction();
      localzzbw.zzgw();
      localzzas.zzjo().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), str);
    }
    while (!"com.google.android.gms.measurement.UPLOAD".equals(str));
    zzb(new zzez(this, paramInt2, localzzas, paramIntent));
    return 2;
  }

  @TargetApi(24)
  public final boolean onStartJob(JobParameters paramJobParameters)
  {
    zzbw localzzbw = zzbw.zza(this.zzaby, null);
    zzas localzzas = localzzbw.zzgt();
    String str = paramJobParameters.getExtras().getString("action");
    localzzbw.zzgw();
    localzzas.zzjo().zzg("Local AppMeasurementJobService called. action", str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str))
      zzb(new zzfa(this, localzzas, paramJobParameters));
    return true;
  }

  public final boolean onUnbind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzgt().zzjg().zzby("onUnbind called with null intent");
      return true;
    }
    String str = paramIntent.getAction();
    zzgt().zzjo().zzg("onUnbind called for intent. action", str);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzey
 * JD-Core Version:    0.6.2
 */