package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;

final class zzawq
{
  private final Object lock = new Object();
  private volatile int zzdua = zzawr.zzduc;
  private volatile long zzdub = 0L;

  public final void zzuy()
  {
    long l1 = zzk.zzln().currentTimeMillis();
    long l2;
    synchronized (this.lock)
    {
      if (this.zzdua == zzawr.zzdue)
      {
        long l3 = this.zzdub;
        zzaci localzzaci = zzact.zzcwe;
        if (l3 + ((Long)zzyr.zzpe().zzd(localzzaci)).longValue() <= l1)
          this.zzdua = zzawr.zzduc;
      }
      l2 = zzk.zzln().currentTimeMillis();
    }
    synchronized (this.lock)
    {
      if (this.zzdua != 2)
      {
        return;
        localObject2 = finally;
        throw localObject2;
      }
      this.zzdua = 3;
      if (this.zzdua == zzawr.zzdue)
        this.zzdub = l2;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawq
 * JD-Core Version:    0.6.2
 */