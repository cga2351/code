package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzdpp<T>
  implements zzdqa<T>
{
  private final zzdpj zzhju;
  private final boolean zzhjv;
  private final zzdqs<?, ?> zzhke;
  private final zzdno<?> zzhkf;

  private zzdpp(zzdqs<?, ?> paramzzdqs, zzdno<?> paramzzdno, zzdpj paramzzdpj)
  {
    this.zzhke = paramzzdqs;
    this.zzhjv = paramzzdno.zzm(paramzzdpj);
    this.zzhkf = paramzzdno;
    this.zzhju = paramzzdpj;
  }

  static <T> zzdpp<T> zza(zzdqs<?, ?> paramzzdqs, zzdno<?> paramzzdno, zzdpj paramzzdpj)
  {
    return new zzdpp(paramzzdqs, paramzzdno, paramzzdpj);
  }

  public final boolean equals(T paramT1, T paramT2)
  {
    if (!this.zzhke.zzao(paramT1).equals(this.zzhke.zzao(paramT2)))
      return false;
    if (this.zzhjv)
      return this.zzhkf.zzy(paramT1).equals(this.zzhkf.zzy(paramT2));
    return true;
  }

  public final int hashCode(T paramT)
  {
    int i = this.zzhke.zzao(paramT).hashCode();
    if (this.zzhjv)
    {
      zzdnr localzzdnr = this.zzhkf.zzy(paramT);
      i = i * 53 + localzzdnr.hashCode();
    }
    return i;
  }

  public final T newInstance()
  {
    return this.zzhju.zzaxu().zzaxz();
  }

  public final void zza(T paramT, zzdpz paramzzdpz, zzdnn paramzzdnn)
    throws IOException
  {
    zzdqs localzzdqs = this.zzhke;
    zzdno localzzdno = this.zzhkf;
    Object localObject1 = localzzdqs.zzap(paramT);
    zzdnr localzzdnr = localzzdno.zzz(paramT);
    label259: label313: 
    while (true)
    {
      int k;
      Object localObject3;
      try
      {
        int i = paramzzdpz.zzaws();
        if (i == 2147483647)
          return;
        int j = paramzzdpz.getTag();
        if (j == 11)
          break label313;
        if ((j & 0x7) == 2)
        {
          Object localObject4 = localzzdno.zza(paramzzdnn, this.zzhju, j >>> 3);
          if (localObject4 != null)
          {
            localzzdno.zza(paramzzdpz, localObject4, paramzzdnn, localzzdnr);
            bool = true;
            if (bool)
              continue;
            return;
          }
          bool = localzzdqs.zza(localObject1, paramzzdpz);
          continue;
        }
        boolean bool = paramzzdpz.zzawt();
        continue;
        if (paramzzdpz.zzaws() == 2147483647)
          break label259;
        int m = paramzzdpz.getTag();
        if (m == 16)
        {
          k = paramzzdpz.zzawd();
          localObject3 = localzzdno.zza(paramzzdnn, this.zzhju, k);
          continue;
        }
        if (m != 26)
          break label250;
        if (localObject3 != null)
        {
          localzzdno.zza(paramzzdpz, localObject3, paramzzdnn, localzzdnr);
          continue;
        }
      }
      finally
      {
        localzzdqs.zzg(paramT, localObject1);
      }
      zzdmq localzzdmq = paramzzdpz.zzawc();
      continue;
      label250: if (!paramzzdpz.zzawt())
      {
        if (paramzzdpz.getTag() != 12)
          throw zzdoj.zzayh();
        if (localzzdmq != null)
          if (localObject3 != null)
          {
            localzzdno.zza(localzzdmq, localObject3, paramzzdnn, localzzdnr);
          }
          else
          {
            localzzdqs.zza(localObject1, k, localzzdmq);
            continue;
            localObject3 = null;
            localzzdmq = null;
            k = 0;
          }
      }
    }
  }

  public final void zza(T paramT, zzdrn paramzzdrn)
    throws IOException
  {
    Iterator localIterator = this.zzhkf.zzy(paramT).iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      zzdnt localzzdnt = (zzdnt)localEntry.getKey();
      if ((localzzdnt.zzaxm() != zzdrm.zzhnk) || (localzzdnt.zzaxn()) || (localzzdnt.zzaxo()))
        throw new IllegalStateException("Found invalid MessageSet item.");
      if ((localEntry instanceof zzdoo))
        paramzzdrn.zzb(localzzdnt.zzac(), ((zzdoo)localEntry).zzayn().zzavf());
      else
        paramzzdrn.zzb(localzzdnt.zzac(), localEntry.getValue());
    }
    zzdqs localzzdqs = this.zzhke;
    localzzdqs.zzc(localzzdqs.zzao(paramT), paramzzdrn);
  }

  public final void zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzdmn paramzzdmn)
    throws IOException
  {
    zzdqt localzzdqt = ((zzdoa)paramT).zzhhd;
    if (localzzdqt == zzdqt.zzazz())
    {
      localzzdqt = zzdqt.zzbaa();
      ((zzdoa)paramT).zzhhd = localzzdqt;
    }
    zzdoa.zzc localzzc = (zzdoa.zzc)paramT;
    if (localzzc.zzhhj.isImmutable())
      localzzc.zzhhj = ((zzdnr)localzzc.zzhhj.clone());
    Object localObject1 = null;
    while (paramInt1 < paramInt2)
    {
      int i = zzdmm.zza(paramArrayOfByte, paramInt1, paramzzdmn);
      int j = paramzzdmn.zzhcl;
      if (j != 11)
      {
        if ((j & 0x7) == 2)
        {
          zzdoa.zzd localzzd2 = (zzdoa.zzd)this.zzhkf.zza(paramzzdmn.zzhco, this.zzhju, j >>> 3);
          if (localzzd2 != null)
          {
            zzdpw.zzazg();
            throw new NoSuchMethodError();
          }
          paramInt1 = zzdmm.zza(j, paramArrayOfByte, i, paramInt2, localzzdqt, paramzzdmn);
          localObject1 = localzzd2;
        }
        else
        {
          paramInt1 = zzdmm.zza(j, paramArrayOfByte, i, paramInt2, paramzzdmn);
        }
      }
      else
      {
        int k = i;
        int m = 0;
        Object localObject2 = null;
        while (k < paramInt2)
        {
          k = zzdmm.zza(paramArrayOfByte, k, paramzzdmn);
          int n = paramzzdmn.zzhcl;
          int i1 = n >>> 3;
          int i2 = n & 0x7;
          switch (i1)
          {
          default:
          case 2:
          case 3:
          }
          do
          {
            do
            {
              if (n == 12)
                break label398;
              k = zzdmm.zza(n, paramArrayOfByte, k, paramInt2, paramzzdmn);
              break;
            }
            while (i2 != 0);
            int i4 = zzdmm.zza(paramArrayOfByte, k, paramzzdmn);
            m = paramzzdmn.zzhcl;
            zzdoa.zzd localzzd1 = (zzdoa.zzd)this.zzhkf.zza(paramzzdmn.zzhco, this.zzhju, m);
            k = i4;
            localObject1 = localzzd1;
            break;
            if (localObject1 != null)
            {
              zzdpw.zzazg();
              throw new NoSuchMethodError();
            }
          }
          while (i2 != 2);
          int i3 = zzdmm.zze(paramArrayOfByte, k, paramzzdmn);
          zzdmq localzzdmq = (zzdmq)paramzzdmn.zzhcn;
          k = i3;
          localObject2 = localzzdmq;
        }
        label398: if (localObject2 != null)
          localzzdqt.zzc(0x2 | m << 3, localObject2);
        paramInt1 = k;
      }
    }
    if (paramInt1 != paramInt2)
      throw zzdoj.zzayj();
  }

  public final void zzaa(T paramT)
  {
    this.zzhke.zzaa(paramT);
    this.zzhkf.zzaa(paramT);
  }

  public final int zzak(T paramT)
  {
    zzdqs localzzdqs = this.zzhke;
    int i = 0 + localzzdqs.zzaq(localzzdqs.zzao(paramT));
    if (this.zzhjv)
      i += this.zzhkf.zzy(paramT).zzaxk();
    return i;
  }

  public final boolean zzam(T paramT)
  {
    return this.zzhkf.zzy(paramT).isInitialized();
  }

  public final void zzd(T paramT1, T paramT2)
  {
    zzdqc.zza(this.zzhke, paramT1, paramT2);
    if (this.zzhjv)
      zzdqc.zza(this.zzhkf, paramT1, paramT2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdpp
 * JD-Core Version:    0.6.2
 */