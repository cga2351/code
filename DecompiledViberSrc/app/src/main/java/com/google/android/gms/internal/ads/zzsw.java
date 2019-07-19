package com.google.android.gms.internal.ads;

import android.os.SystemClock;

public final class zzsw
  implements zzso
{
  private boolean started;
  private zzln zzasc = zzln.zzaug;
  private long zzbno;
  private long zzbnp;

  public final void start()
  {
    if (!this.started)
    {
      this.zzbnp = SystemClock.elapsedRealtime();
      this.started = true;
    }
  }

  public final void stop()
  {
    if (this.started)
    {
      zzdj(zzdv());
      this.started = false;
    }
  }

  public final void zza(zzso paramzzso)
  {
    zzdj(paramzzso.zzdv());
    this.zzasc = paramzzso.zzhq();
  }

  public final zzln zzb(zzln paramzzln)
  {
    if (this.started)
      zzdj(zzdv());
    this.zzasc = paramzzln;
    return paramzzln;
  }

  public final void zzdj(long paramLong)
  {
    this.zzbno = paramLong;
    if (this.started)
      this.zzbnp = SystemClock.elapsedRealtime();
  }

  public final long zzdv()
  {
    long l1 = this.zzbno;
    long l2;
    if (this.started)
    {
      l2 = SystemClock.elapsedRealtime() - this.zzbnp;
      if (this.zzasc.zzauh == 1.0F)
        l1 += zzkt.zzea(l2);
    }
    else
    {
      return l1;
    }
    return l1 + this.zzasc.zzef(l2);
  }

  public final zzln zzhq()
  {
    return this.zzasc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzsw
 * JD-Core Version:    0.6.2
 */