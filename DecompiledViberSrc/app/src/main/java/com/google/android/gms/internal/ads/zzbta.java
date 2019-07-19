package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public final class zzbta extends zzbtr<zzbte>
{
  private final Clock zzbsb;

  @GuardedBy("this")
  private boolean zzfga = false;
  private final ScheduledExecutorService zzfkf;

  @GuardedBy("this")
  private long zzfkg = -1L;

  @GuardedBy("this")
  private long zzfkh = -1L;

  @GuardedBy("this")
  private ScheduledFuture<?> zzfki;

  public zzbta(ScheduledExecutorService paramScheduledExecutorService, Clock paramClock)
  {
    super(Collections.emptySet());
    this.zzfkf = paramScheduledExecutorService;
    this.zzbsb = paramClock;
  }

  private final void zzagj()
  {
    zza(zzbtb.zzfka);
  }

  private final void zzfg(long paramLong)
  {
    try
    {
      if ((this.zzfki != null) && (!this.zzfki.isDone()))
        this.zzfki.cancel(true);
      this.zzfkg = (paramLong + this.zzbsb.elapsedRealtime());
      this.zzfki = this.zzfkf.schedule(new zzbtd(this, null), paramLong, TimeUnit.MILLISECONDS);
      return;
    }
    finally
    {
    }
  }

  public final void onPause()
  {
    try
    {
      if (!this.zzfga)
      {
        if ((this.zzfki == null) || (this.zzfki.isCancelled()))
          break label65;
        this.zzfki.cancel(true);
      }
      label65: for (this.zzfkh = (this.zzfkg - this.zzbsb.elapsedRealtime()); ; this.zzfkh = -1L)
      {
        this.zzfga = true;
        return;
      }
    }
    finally
    {
    }
  }

  public final void onResume()
  {
    try
    {
      if (this.zzfga)
      {
        if ((this.zzfkh > 0L) && (this.zzfki.isCancelled()))
          zzfg(this.zzfkh);
        this.zzfga = false;
      }
      return;
    }
    finally
    {
    }
  }

  public final void zzagi()
  {
    try
    {
      this.zzfga = false;
      zzfg(0L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzdk(int paramInt)
  {
    if (paramInt <= 0);
    while (true)
    {
      return;
      long l;
      while (true)
      {
        try
        {
          l = TimeUnit.SECONDS.toMillis(paramInt);
          if (!this.zzfga)
            break label64;
          if ((this.zzfkh > 0L) && (l < this.zzfkh))
          {
            this.zzfkh = l;
            break;
          }
        }
        finally
        {
        }
        l = this.zzfkh;
      }
      label64: if ((this.zzbsb.elapsedRealtime() > this.zzfkg) || (this.zzfkg - this.zzbsb.elapsedRealtime() > l))
        zzfg(l);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbta
 * JD-Core Version:    0.6.2
 */