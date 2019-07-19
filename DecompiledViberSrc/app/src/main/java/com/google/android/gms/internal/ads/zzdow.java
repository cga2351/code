package com.google.android.gms.internal.ads;

import java.util.List;

final class zzdow extends zzdot
{
  private zzdow()
  {
    super(null);
  }

  private static <E> zzdoi<E> zzd(Object paramObject, long paramLong)
  {
    return (zzdoi)zzdqy.zzp(paramObject, paramLong);
  }

  final <L> List<L> zza(Object paramObject, long paramLong)
  {
    zzdoi localzzdoi1 = zzd(paramObject, paramLong);
    if (!localzzdoi1.zzavi())
    {
      int i = localzzdoi1.size();
      if (i == 0);
      for (int j = 10; ; j = i << 1)
      {
        zzdoi localzzdoi2 = localzzdoi1.zzfl(j);
        zzdqy.zza(paramObject, paramLong, localzzdoi2);
        return localzzdoi2;
      }
    }
    return localzzdoi1;
  }

  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzd(paramObject1, paramLong);
    zzdoi localzzdoi = zzd(paramObject2, paramLong);
    int i = ((zzdoi)localObject).size();
    int j = localzzdoi.size();
    if ((i > 0) && (j > 0))
    {
      if (!((zzdoi)localObject).zzavi())
        localObject = ((zzdoi)localObject).zzfl(j + i);
      ((zzdoi)localObject).addAll(localzzdoi);
    }
    if (i > 0);
    while (true)
    {
      zzdqy.zza(paramObject1, paramLong, localObject);
      return;
      localObject = localzzdoi;
    }
  }

  final void zzb(Object paramObject, long paramLong)
  {
    zzd(paramObject, paramLong).zzavj();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdow
 * JD-Core Version:    0.6.2
 */