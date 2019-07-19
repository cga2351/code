package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class zzczk<O>
{
  private final E zzgme;

  @Nullable
  private final String zzgmf;
  private final List<zzbbi<?>> zzgmj;
  private final zzbbi<?> zzgmm;
  private final zzbbi<O> zzgmn;

  private zzczk(E paramE, String paramString, zzbbi<?> paramzzbbi, List<zzbbi<?>> paramList, zzbbi<O> paramzzbbi1)
  {
    this.zzgme = paramString;
    this.zzgmf = paramzzbbi;
    this.zzgmm = paramList;
    this.zzgmj = paramzzbbi1;
    Object localObject;
    this.zzgmn = localObject;
  }

  private final <O2> zzczk<O2> zza(zzbam<O, O2> paramzzbam, Executor paramExecutor)
  {
    return new zzczk(this.zzgmk, this.zzgme, this.zzgmf, this.zzgmm, this.zzgmj, zzbas.zza(this.zzgmn, paramzzbam, paramExecutor));
  }

  public final zzczk<O> zza(long paramLong, TimeUnit paramTimeUnit)
  {
    return new zzczk(this.zzgmk, this.zzgme, this.zzgmf, this.zzgmm, this.zzgmj, zzbas.zza(this.zzgmn, paramLong, paramTimeUnit, zzcze.zzb(this.zzgmk)));
  }

  public final <O2> zzczk<O2> zza(zzbam<O, O2> paramzzbam)
  {
    return zza(paramzzbam, zzcze.zza(this.zzgmk));
  }

  public final <T extends Throwable> zzczk<O> zza(Class<T> paramClass, zzbam<T, O> paramzzbam)
  {
    return new zzczk(this.zzgmk, this.zzgme, this.zzgmf, this.zzgmm, this.zzgmj, zzbas.zza(this.zzgmn, paramClass, paramzzbam, zzcze.zza(this.zzgmk)));
  }

  public final <T extends Throwable> zzczk<O> zza(Class<T> paramClass, zzczb<T, O> paramzzczb)
  {
    return zza(paramClass, new zzczn(paramzzczb));
  }

  public final zzczd<E, O> zzane()
  {
    Object localObject = this.zzgme;
    if (this.zzgmf == null);
    for (String str = this.zzgmk.zzw(this.zzgme); ; str = this.zzgmf)
    {
      zzczd localzzczd = new zzczd(localObject, str, this.zzgmn);
      zzcze.zzc(this.zzgmk).zza(localzzczd);
      this.zzgmm.zza(new zzczo(this, localzzczd), zzbbn.zzeah);
      zzbas.zza(localzzczd, new zzczp(this, localzzczd), zzbbn.zzeah);
      return localzzczd;
    }
  }

  public final <O2> zzczk<O2> zzb(zzbbi<O2> paramzzbbi)
  {
    return zza(new zzczm(paramzzbbi), zzbbn.zzeah);
  }

  public final <O2> zzczk<O2> zzb(zzczb<O, O2> paramzzczb)
  {
    return zza(new zzczl(paramzzczb));
  }

  public final zzczk<O> zzfy(String paramString)
  {
    return new zzczk(this.zzgmk, this.zzgme, paramString, this.zzgmm, this.zzgmj, this.zzgmn);
  }

  public final zzczk<O> zzx(E paramE)
  {
    zzczd localzzczd = zzane();
    return this.zzgmk.zza(paramE, localzzczd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzczk
 * JD-Core Version:    0.6.2
 */