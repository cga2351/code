package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;

public final class zzcxj
{
  private final Object lock = new Object();
  private final Clock zzbsb;
  private volatile long zzdub = 0L;

  @GuardedBy("lock")
  private volatile int zzgjt = zzcxk.zzgju;

  public zzcxj(Clock paramClock)
  {
    this.zzbsb = paramClock;
  }

  private final void zzamk()
  {
    long l1 = this.zzbsb.currentTimeMillis();
    synchronized (this.lock)
    {
      if (this.zzgjt == zzcxk.zzgjw)
      {
        long l2 = this.zzdub;
        zzaci localzzaci = zzact.zzcwe;
        if (l2 + ((Long)zzyr.zzpe().zzd(localzzaci)).longValue() <= l1)
          this.zzgjt = zzcxk.zzgju;
      }
      return;
    }
  }

  private final void zzs(int paramInt1, int paramInt2)
  {
    zzamk();
    long l = this.zzbsb.currentTimeMillis();
    synchronized (this.lock)
    {
      if (this.zzgjt != paramInt1)
        return;
      this.zzgjt = paramInt2;
      if (this.zzgjt == zzcxk.zzgjw)
        this.zzdub = l;
      return;
    }
  }

  public final boolean zzaml()
  {
    while (true)
    {
      synchronized (this.lock)
      {
        zzamk();
        if (this.zzgjt == zzcxk.zzgjv)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public final boolean zzamm()
  {
    while (true)
    {
      synchronized (this.lock)
      {
        zzamk();
        if (this.zzgjt == zzcxk.zzgjw)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public final void zzbb(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      zzs(zzcxk.zzgju, zzcxk.zzgjv);
      return;
    }
    zzs(zzcxk.zzgjv, zzcxk.zzgju);
  }

  public final void zzuy()
  {
    zzs(zzcxk.zzgjv, zzcxk.zzgjw);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxj
 * JD-Core Version:    0.6.2
 */