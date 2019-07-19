package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class zzse
{
  private final ExecutorService zzaqh;
  private zzsg<? extends zzsh> zzbmr;
  private IOException zzbms;

  public zzse(String paramString)
  {
    this.zzaqh = zzsy.zzax(paramString);
  }

  public final boolean isLoading()
  {
    return this.zzbmr != null;
  }

  public final <T extends zzsh> long zza(T paramT, zzsf<T> paramzzsf, int paramInt)
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper != null);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkState(bool);
      long l = SystemClock.elapsedRealtime();
      new zzsg(this, localLooper, paramT, paramzzsf, paramInt, l).zzeq(0L);
      return l;
    }
  }

  public final void zza(Runnable paramRunnable)
  {
    if (this.zzbmr != null)
      this.zzbmr.zzl(true);
    this.zzaqh.execute(paramRunnable);
    this.zzaqh.shutdown();
  }

  public final void zzbm(int paramInt)
    throws IOException
  {
    if (this.zzbms != null)
      throw this.zzbms;
    if (this.zzbmr != null)
      this.zzbmr.zzbm(this.zzbmr.zzbmv);
  }

  public final void zzgb()
  {
    this.zzbmr.zzl(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzse
 * JD-Core Version:    0.6.2
 */