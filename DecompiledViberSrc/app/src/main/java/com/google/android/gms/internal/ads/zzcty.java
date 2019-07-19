package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcty<S extends zzcuy>
  implements zzcuz<S>
{
  private final ScheduledExecutorService zzfkf;
  private final zzcuz<S> zzggw;
  private final long zzgho;

  public zzcty(zzcuz<S> paramzzcuz, long paramLong, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.zzggw = paramzzcuz;
    this.zzgho = paramLong;
    this.zzfkf = paramScheduledExecutorService;
  }

  public final zzbbi<S> zzalm()
  {
    zzbbi localzzbbi = this.zzggw.zzalm();
    if (this.zzgho > 0L)
      localzzbbi = zzbas.zza(localzzbbi, this.zzgho, TimeUnit.MILLISECONDS, this.zzfkf);
    return zzbas.zza(localzzbbi, Throwable.class, zzctz.zzbra, zzbbn.zzeah);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcty
 * JD-Core Version:    0.6.2
 */