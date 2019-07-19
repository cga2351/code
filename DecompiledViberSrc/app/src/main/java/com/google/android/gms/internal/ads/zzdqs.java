package com.google.android.gms.internal.ads;

import java.io.IOException;

abstract class zzdqs<T, B>
{
  abstract void zza(B paramB, int paramInt, long paramLong);

  abstract void zza(B paramB, int paramInt, zzdmq paramzzdmq);

  abstract void zza(B paramB, int paramInt, T paramT);

  abstract void zza(T paramT, zzdrn paramzzdrn)
    throws IOException;

  abstract boolean zza(zzdpz paramzzdpz);

  final boolean zza(B paramB, zzdpz paramzzdpz)
    throws IOException
  {
    int i = paramzzdpz.getTag();
    int j = i >>> 3;
    switch (i & 0x7)
    {
    default:
      throw zzdoj.zzayi();
    case 0:
      zza(paramB, j, paramzzdpz.zzavw());
      return true;
    case 5:
      zzc(paramB, j, paramzzdpz.zzavz());
      return true;
    case 1:
      zzb(paramB, j, paramzzdpz.zzavy());
      return true;
    case 2:
      zza(paramB, j, paramzzdpz.zzawc());
      return true;
    case 3:
      Object localObject = zzazy();
      int k = 0x4 | j << 3;
      while ((paramzzdpz.zzaws() != 2147483647) && (zza(localObject, paramzzdpz)));
      if (k != paramzzdpz.getTag())
        throw zzdoj.zzayh();
      zza(paramB, j, zzah(localObject));
      return true;
    case 4:
    }
    return false;
  }

  abstract void zzaa(Object paramObject);

  abstract T zzah(B paramB);

  abstract int zzak(T paramT);

  abstract T zzao(Object paramObject);

  abstract B zzap(Object paramObject);

  abstract int zzaq(T paramT);

  abstract B zzazy();

  abstract void zzb(B paramB, int paramInt, long paramLong);

  abstract void zzc(B paramB, int paramInt1, int paramInt2);

  abstract void zzc(T paramT, zzdrn paramzzdrn)
    throws IOException;

  abstract void zzf(Object paramObject, T paramT);

  abstract void zzg(Object paramObject, B paramB);

  abstract T zzh(T paramT1, T paramT2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdqs
 * JD-Core Version:    0.6.2
 */