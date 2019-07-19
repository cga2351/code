package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

public final class zzczi
{
  private final E zzgme;

  private zzczi(E paramE)
  {
    Object localObject;
    this.zzgme = localObject;
  }

  private final <O> zzczk<O> zza(Callable<O> paramCallable, zzbbm paramzzbbm)
  {
    return new zzczk(this.zzgmk, this.zzgme, null, zzcze.zzand(), Collections.emptyList(), paramzzbbm.zza(paramCallable), null);
  }

  public final zzczk<?> zza(zzczc paramzzczc, zzbbm paramzzbbm)
  {
    return zza(new zzczj(paramzzczc), paramzzbbm);
  }

  public final <O> zzczk<O> zzb(zzbbi<O> paramzzbbi)
  {
    return new zzczk(this.zzgmk, this.zzgme, null, zzcze.zzand(), Collections.emptyList(), paramzzbbi, null);
  }

  public final <O> zzczk<O> zzd(Callable<O> paramCallable)
  {
    return zza(paramCallable, zzcze.zza(this.zzgmk));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzczi
 * JD-Core Version:    0.6.2
 */