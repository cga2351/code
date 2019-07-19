package com.google.android.gms.internal.measurement;

import java.io.IOException;

abstract class zzxd<T, B>
{
  abstract void zza(B paramB, int paramInt, long paramLong);

  abstract void zza(B paramB, int paramInt, zzte paramzzte);

  abstract void zza(B paramB, int paramInt, T paramT);

  abstract void zza(T paramT, zzxy paramzzxy)
    throws IOException;

  abstract boolean zza(zzwk paramzzwk);

  final boolean zza(B paramB, zzwk paramzzwk)
    throws IOException
  {
    int i = paramzzwk.getTag();
    int j = i >>> 3;
    switch (i & 0x7)
    {
    default:
      throw zzuv.zzwu();
    case 0:
      zza(paramB, j, paramzzwk.zzul());
      return true;
    case 5:
      zzc(paramB, j, paramzzwk.zzuo());
      return true;
    case 1:
      zzb(paramB, j, paramzzwk.zzun());
      return true;
    case 2:
      zza(paramB, j, paramzzwk.zzur());
      return true;
    case 3:
      Object localObject = zzyk();
      int k = 0x4 | j << 3;
      while ((paramzzwk.zzvh() != 2147483647) && (zza(localObject, paramzzwk)));
      if (k != paramzzwk.getTag())
        throw zzuv.zzwt();
      zza(paramB, j, zzaf(localObject));
      return true;
    case 4:
    }
    return false;
  }

  abstract T zzaf(B paramB);

  abstract int zzai(T paramT);

  abstract T zzal(Object paramObject);

  abstract B zzam(Object paramObject);

  abstract int zzan(T paramT);

  abstract void zzb(B paramB, int paramInt, long paramLong);

  abstract void zzc(B paramB, int paramInt1, int paramInt2);

  abstract void zzc(T paramT, zzxy paramzzxy)
    throws IOException;

  abstract void zzf(Object paramObject, T paramT);

  abstract void zzg(Object paramObject, B paramB);

  abstract T zzh(T paramT1, T paramT2);

  abstract void zzy(Object paramObject);

  abstract B zzyk();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxd
 * JD-Core Version:    0.6.2
 */