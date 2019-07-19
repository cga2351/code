package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzwa<T>
  implements zzwl<T>
{
  private final zzvv zzcaw;
  private final boolean zzcax;
  private final zzxd<?, ?> zzcbg;
  private final zzuc<?> zzcbh;

  private zzwa(zzxd<?, ?> paramzzxd, zzuc<?> paramzzuc, zzvv paramzzvv)
  {
    this.zzcbg = paramzzxd;
    this.zzcax = paramzzuc.zze(paramzzvv);
    this.zzcbh = paramzzuc;
    this.zzcaw = paramzzvv;
  }

  static <T> zzwa<T> zza(zzxd<?, ?> paramzzxd, zzuc<?> paramzzuc, zzvv paramzzvv)
  {
    return new zzwa(paramzzxd, paramzzuc, paramzzvv);
  }

  public final boolean equals(T paramT1, T paramT2)
  {
    if (!this.zzcbg.zzal(paramT1).equals(this.zzcbg.zzal(paramT2)))
      return false;
    if (this.zzcax)
      return this.zzcbh.zzw(paramT1).equals(this.zzcbh.zzw(paramT2));
    return true;
  }

  public final int hashCode(T paramT)
  {
    int i = this.zzcbg.zzal(paramT).hashCode();
    if (this.zzcax)
    {
      zzuf localzzuf = this.zzcbh.zzw(paramT);
      i = i * 53 + localzzuf.hashCode();
    }
    return i;
  }

  public final T newInstance()
  {
    return this.zzcaw.zzwi().zzwn();
  }

  public final void zza(T paramT, zzwk paramzzwk, zzub paramzzub)
    throws IOException
  {
    zzxd localzzxd = this.zzcbg;
    zzuc localzzuc = this.zzcbh;
    Object localObject1 = localzzxd.zzam(paramT);
    zzuf localzzuf = localzzuc.zzx(paramT);
    label259: label313: 
    while (true)
    {
      int k;
      Object localObject3;
      try
      {
        int i = paramzzwk.zzvh();
        if (i == 2147483647)
          return;
        int j = paramzzwk.getTag();
        if (j == 11)
          break label313;
        if ((j & 0x7) == 2)
        {
          Object localObject4 = localzzuc.zza(paramzzub, this.zzcaw, j >>> 3);
          if (localObject4 != null)
          {
            localzzuc.zza(paramzzwk, localObject4, paramzzub, localzzuf);
            bool = true;
            if (bool)
              continue;
            return;
          }
          bool = localzzxd.zza(localObject1, paramzzwk);
          continue;
        }
        boolean bool = paramzzwk.zzvi();
        continue;
        if (paramzzwk.zzvh() == 2147483647)
          break label259;
        int m = paramzzwk.getTag();
        if (m == 16)
        {
          k = paramzzwk.zzus();
          localObject3 = localzzuc.zza(paramzzub, this.zzcaw, k);
          continue;
        }
        if (m != 26)
          break label250;
        if (localObject3 != null)
        {
          localzzuc.zza(paramzzwk, localObject3, paramzzub, localzzuf);
          continue;
        }
      }
      finally
      {
        localzzxd.zzg(paramT, localObject1);
      }
      zzte localzzte = paramzzwk.zzur();
      continue;
      label250: if (!paramzzwk.zzvi())
      {
        if (paramzzwk.getTag() != 12)
          throw zzuv.zzwt();
        if (localzzte != null)
          if (localObject3 != null)
          {
            localzzuc.zza(localzzte, localObject3, paramzzub, localzzuf);
          }
          else
          {
            localzzxd.zza(localObject1, k, localzzte);
            continue;
            localObject3 = null;
            localzzte = null;
            k = 0;
          }
      }
    }
  }

  public final void zza(T paramT, zzxy paramzzxy)
    throws IOException
  {
    Iterator localIterator = this.zzcbh.zzw(paramT).iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      zzuh localzzuh = (zzuh)localEntry.getKey();
      if ((localzzuh.zzwa() != zzxx.zzcem) || (localzzuh.zzwb()) || (localzzuh.zzwc()))
        throw new IllegalStateException("Found invalid MessageSet item.");
      if ((localEntry instanceof zzva))
        paramzzxy.zza(localzzuh.zzc(), ((zzva)localEntry).zzxa().zztw());
      else
        paramzzxy.zza(localzzuh.zzc(), localEntry.getValue());
    }
    zzxd localzzxd = this.zzcbg;
    localzzxd.zzc(localzzxd.zzal(paramT), paramzzxy);
  }

  public final int zzai(T paramT)
  {
    zzxd localzzxd = this.zzcbg;
    int i = 0 + localzzxd.zzan(localzzxd.zzal(paramT));
    if (this.zzcax)
      i += this.zzcbh.zzw(paramT).zzvy();
    return i;
  }

  public final boolean zzaj(T paramT)
  {
    return this.zzcbh.zzw(paramT).isInitialized();
  }

  public final void zzd(T paramT1, T paramT2)
  {
    zzwn.zza(this.zzcbg, paramT1, paramT2);
    if (this.zzcax)
      zzwn.zza(this.zzcbh, paramT1, paramT2);
  }

  public final void zzy(T paramT)
  {
    this.zzcbg.zzy(paramT);
    this.zzcbh.zzy(paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwa
 * JD-Core Version:    0.6.2
 */