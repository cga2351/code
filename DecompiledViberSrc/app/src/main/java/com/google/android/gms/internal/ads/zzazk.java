package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzazk
{
  private final Object lock = new Object();
  private long zzdxz;

  @GuardedBy("lock")
  private long zzdya = -9223372036854775808L;

  public zzazk(long paramLong)
  {
    this.zzdxz = paramLong;
  }

  public final boolean tryAcquire()
  {
    synchronized (this.lock)
    {
      long l = zzk.zzln().elapsedRealtime();
      if (this.zzdya + this.zzdxz > l)
        return false;
      this.zzdya = l;
      return true;
    }
  }

  public final void zzfe(long paramLong)
  {
    synchronized (this.lock)
    {
      this.zzdxz = paramLong;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzazk
 * JD-Core Version:    0.6.2
 */