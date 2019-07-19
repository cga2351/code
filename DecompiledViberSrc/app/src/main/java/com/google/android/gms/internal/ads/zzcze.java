package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

public abstract class zzcze<E>
{
  private static final zzbbi<?> zzgmh = zzbas.zzm(null);
  private final ScheduledExecutorService zzfkf;
  private final zzbbm zzfqw;
  private final zzczq<E> zzgmi;

  public zzcze(zzbbm paramzzbbm, ScheduledExecutorService paramScheduledExecutorService, zzczq<E> paramzzczq)
  {
    this.zzfqw = paramzzbbm;
    this.zzfkf = paramScheduledExecutorService;
    this.zzgmi = paramzzczq;
  }

  public final zzczg zza(E paramE, zzbbi<?>[] paramArrayOfzzbbi)
  {
    return new zzczg(this, paramE, Arrays.asList(paramArrayOfzzbbi), null);
  }

  public final <I> zzczk<I> zza(E paramE, zzbbi<I> paramzzbbi)
  {
    return new zzczk(this, paramE, null, paramzzbbi, Collections.singletonList(paramzzbbi), paramzzbbi, null);
  }

  public final zzczi zzv(E paramE)
  {
    return new zzczi(this, paramE, null);
  }

  protected abstract String zzw(E paramE);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcze
 * JD-Core Version:    0.6.2
 */