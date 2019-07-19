package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

public final class zzczg
{
  private final E zzgme;
  private final List<zzbbi<?>> zzgmj;

  private zzczg(E paramE, List<zzbbi<?>> paramList)
  {
    this.zzgme = paramList;
    Object localObject;
    this.zzgmj = localObject;
  }

  public final <O> zzczk<O> zzc(Callable<O> paramCallable)
  {
    zzbbd localzzbbd = zzbas.zzf(this.zzgmj);
    zzbbi localzzbbi = localzzbbd.zza(zzczh.zzghi, zzbbn.zzeah);
    return new zzczk(this.zzgmk, this.zzgme, null, localzzbbi, this.zzgmj, localzzbbd.zza(paramCallable, zzcze.zza(this.zzgmk)), null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzczg
 * JD-Core Version:    0.6.2
 */