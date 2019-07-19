package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzdl;

abstract class zzy
{
  private static volatile Handler handler;
  private final zzct zzahn;
  private final Runnable zzyo;
  private volatile long zzyp;

  zzy(zzct paramzzct)
  {
    Preconditions.checkNotNull(paramzzct);
    this.zzahn = paramzzct;
    this.zzyo = new zzz(this, paramzzct);
  }

  private final Handler getHandler()
  {
    if (handler != null)
      return handler;
    try
    {
      if (handler == null)
        handler = new zzdl(this.zzahn.getContext().getMainLooper());
      Handler localHandler = handler;
      return localHandler;
    }
    finally
    {
    }
  }

  final void cancel()
  {
    this.zzyp = 0L;
    getHandler().removeCallbacks(this.zzyo);
  }

  public abstract void run();

  public final boolean zzej()
  {
    return this.zzyp != 0L;
  }

  public final void zzh(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      this.zzyp = this.zzahn.zzbx().currentTimeMillis();
      if (!getHandler().postDelayed(this.zzyo, paramLong))
        this.zzahn.zzgt().zzjg().zzg("Failed to schedule delayed post. time", Long.valueOf(paramLong));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzy
 * JD-Core Version:    0.6.2
 */