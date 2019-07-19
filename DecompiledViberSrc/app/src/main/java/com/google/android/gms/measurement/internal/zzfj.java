package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzdi;

public final class zzfj extends zzfm
{
  private final zzy zzatg;
  private final AlarmManager zzyt = (AlarmManager)getContext().getSystemService("alarm");
  private Integer zzyu;

  protected zzfj(zzfn paramzzfn)
  {
    super(paramzzfn);
    this.zzatg = new zzfk(this, paramzzfn.zzmh(), paramzzfn);
  }

  private final int getJobId()
  {
    String str1;
    if (this.zzyu == null)
    {
      str1 = String.valueOf(getContext().getPackageName());
      if (str1.length() == 0)
        break label51;
    }
    label51: for (String str2 = "measurement".concat(str1); ; str2 = new String("measurement"))
    {
      this.zzyu = Integer.valueOf(str2.hashCode());
      return this.zzyu.intValue();
    }
  }

  private final PendingIntent zzeo()
  {
    Context localContext = getContext();
    return PendingIntent.getBroadcast(localContext, 0, new Intent().setClassName(localContext, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
  }

  @TargetApi(24)
  private final void zzlr()
  {
    JobScheduler localJobScheduler = (JobScheduler)getContext().getSystemService("jobscheduler");
    int i = getJobId();
    zzgt().zzjo().zzg("Cancelling job. JobID", Integer.valueOf(i));
    localJobScheduler.cancel(i);
  }

  public final void cancel()
  {
    zzcl();
    this.zzyt.cancel(zzeo());
    this.zzatg.cancel();
    if (Build.VERSION.SDK_INT >= 24)
      zzlr();
  }

  protected final boolean zzgy()
  {
    this.zzyt.cancel(zzeo());
    if (Build.VERSION.SDK_INT >= 24)
      zzlr();
    return false;
  }

  public final void zzh(long paramLong)
  {
    zzcl();
    zzgw();
    Context localContext1 = getContext();
    if (!zzbm.zza(localContext1))
      zzgt().zzjn().zzby("Receiver not registered/enabled");
    if (!zzfx.zza(localContext1, false))
      zzgt().zzjn().zzby("Service not registered/enabled");
    cancel();
    long l = paramLong + zzbx().elapsedRealtime();
    if ((paramLong < Math.max(0L, ((Long)zzai.zzajr.get()).longValue())) && (!this.zzatg.zzej()))
    {
      zzgt().zzjo().zzby("Scheduling upload with DelayedRunnable");
      this.zzatg.zzh(paramLong);
    }
    zzgw();
    if (Build.VERSION.SDK_INT >= 24)
    {
      zzgt().zzjo().zzby("Scheduling upload with JobScheduler");
      Context localContext2 = getContext();
      ComponentName localComponentName = new ComponentName(localContext2, "com.google.android.gms.measurement.AppMeasurementJobService");
      int i = getJobId();
      PersistableBundle localPersistableBundle = new PersistableBundle();
      localPersistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
      JobInfo localJobInfo = new JobInfo.Builder(i, localComponentName).setMinimumLatency(paramLong).setOverrideDeadline(paramLong << 1).setExtras(localPersistableBundle).build();
      zzgt().zzjo().zzg("Scheduling job. JobID", Integer.valueOf(i));
      zzdi.zza(localContext2, localJobInfo, "com.google.android.gms", "UploadAlarm");
      return;
    }
    zzgt().zzjo().zzby("Scheduling upload with AlarmManager");
    this.zzyt.setInexactRepeating(2, l, Math.max(((Long)zzai.zzajm.get()).longValue(), paramLong), zzeo());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzfj
 * JD-Core Version:    0.6.2
 */