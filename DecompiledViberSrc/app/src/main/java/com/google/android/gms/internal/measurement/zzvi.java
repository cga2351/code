package com.google.android.gms.internal.measurement;

import java.util.List;

final class zzvi extends zzvf
{
  private zzvi()
  {
    super(null);
  }

  private static <E> zzuu<E> zzd(Object paramObject, long paramLong)
  {
    return (zzuu)zzxj.zzp(paramObject, paramLong);
  }

  final <L> List<L> zza(Object paramObject, long paramLong)
  {
    zzuu localzzuu1 = zzd(paramObject, paramLong);
    if (!localzzuu1.zztz())
    {
      int i = localzzuu1.size();
      if (i == 0);
      for (int j = 10; ; j = i << 1)
      {
        zzuu localzzuu2 = localzzuu1.zzal(j);
        zzxj.zza(paramObject, paramLong, localzzuu2);
        return localzzuu2;
      }
    }
    return localzzuu1;
  }

  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzd(paramObject1, paramLong);
    zzuu localzzuu = zzd(paramObject2, paramLong);
    int i = ((zzuu)localObject).size();
    int j = localzzuu.size();
    if ((i > 0) && (j > 0))
    {
      if (!((zzuu)localObject).zztz())
        localObject = ((zzuu)localObject).zzal(j + i);
      ((zzuu)localObject).addAll(localzzuu);
    }
    if (i > 0);
    while (true)
    {
      zzxj.zza(paramObject1, paramLong, localObject);
      return;
      localObject = localzzuu;
    }
  }

  final void zzb(Object paramObject, long paramLong)
  {
    zzd(paramObject, paramLong).zzsw();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzvi
 * JD-Core Version:    0.6.2
 */