package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzdg
  implements Runnable
{
  zzdg(zzda paramzzda, long paramLong)
  {
  }

  public final void run()
  {
    boolean bool1 = true;
    zzda localzzda = this.zzarh;
    long l = this.zzarn;
    localzzda.zzaf();
    localzzda.zzgg();
    localzzda.zzcl();
    localzzda.zzgt().zzjn().zzby("Resetting analytics data (FE)");
    localzzda.zzgo().zzln();
    if (localzzda.zzgv().zzbc(localzzda.zzgk().zzal()))
      localzzda.zzgu().zzanh.set(l);
    boolean bool2 = localzzda.zzada.isEnabled();
    boolean bool3;
    if (!localzzda.zzgv().zzhz())
    {
      zzbd localzzbd = localzzda.zzgu();
      if (!bool2)
      {
        bool3 = bool1;
        localzzbd.zzi(bool3);
      }
    }
    else
    {
      localzzda.zzgl().resetAnalyticsData();
      if (bool2)
        break label168;
    }
    while (true)
    {
      localzzda.zzarf = bool1;
      if (this.zzarh.zzgv().zza(zzai.zzald))
        this.zzarh.zzgl().zza(new AtomicReference());
      return;
      bool3 = false;
      break;
      label168: bool1 = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzdg
 * JD-Core Version:    0.6.2
 */