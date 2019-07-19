package com.google.android.gms.internal.ads;

import android.os.SystemClock;

final class zzgm
{
  private boolean started;
  private long zzacl;
  private long zzacx;

  private static long zzdk(long paramLong)
  {
    return 1000L * SystemClock.elapsedRealtime() - paramLong;
  }

  public final void start()
  {
    if (!this.started)
    {
      this.started = true;
      this.zzacx = zzdk(this.zzacl);
    }
  }

  public final void stop()
  {
    if (this.started)
    {
      this.zzacl = zzdk(this.zzacx);
      this.started = false;
    }
  }

  public final void zzdj(long paramLong)
  {
    this.zzacl = paramLong;
    this.zzacx = zzdk(paramLong);
  }

  public final long zzdv()
  {
    if (this.started)
      return zzdk(this.zzacx);
    return this.zzacl;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzgm
 * JD-Core Version:    0.6.2
 */