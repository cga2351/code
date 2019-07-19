package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzdov extends zzdot
{
  private static final Class<?> zzhjc = Collections.unmodifiableList(Collections.emptyList()).getClass();

  private zzdov()
  {
    super(null);
  }

  private static <L> List<L> zza(Object paramObject, long paramLong, int paramInt)
  {
    Object localObject = zzc(paramObject, paramLong);
    if (((List)localObject).isEmpty())
      if ((localObject instanceof zzdos))
      {
        localObject = new zzdor(paramInt);
        zzdqy.zza(paramObject, paramLong, localObject);
      }
    do
    {
      return localObject;
      if (((localObject instanceof zzdpv)) && ((localObject instanceof zzdoi)))
      {
        localObject = ((zzdoi)localObject).zzfl(paramInt);
        break;
      }
      localObject = new ArrayList(paramInt);
      break;
      if (zzhjc.isAssignableFrom(localObject.getClass()))
      {
        ArrayList localArrayList = new ArrayList(paramInt + ((List)localObject).size());
        localArrayList.addAll((Collection)localObject);
        zzdqy.zza(paramObject, paramLong, localArrayList);
        return localArrayList;
      }
      if ((localObject instanceof zzdqv))
      {
        zzdor localzzdor = new zzdor(paramInt + ((List)localObject).size());
        localzzdor.addAll((zzdqv)localObject);
        zzdqy.zza(paramObject, paramLong, localzzdor);
        return localzzdor;
      }
    }
    while ((!(localObject instanceof zzdpv)) || (!(localObject instanceof zzdoi)) || (((zzdoi)localObject).zzavi()));
    zzdoi localzzdoi = ((zzdoi)localObject).zzfl(paramInt + ((List)localObject).size());
    zzdqy.zza(paramObject, paramLong, localzzdoi);
    return localzzdoi;
  }

  private static <E> List<E> zzc(Object paramObject, long paramLong)
  {
    return (List)zzdqy.zzp(paramObject, paramLong);
  }

  final <L> List<L> zza(Object paramObject, long paramLong)
  {
    return zza(paramObject, paramLong, 10);
  }

  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    List localList1 = zzc(paramObject2, paramLong);
    List localList2 = zza(paramObject1, paramLong, localList1.size());
    int i = localList2.size();
    int j = localList1.size();
    if ((i > 0) && (j > 0))
      localList2.addAll(localList1);
    if (i > 0);
    while (true)
    {
      zzdqy.zza(paramObject1, paramLong, localList2);
      return;
      localList2 = localList1;
    }
  }

  final void zzb(Object paramObject, long paramLong)
  {
    List localList = (List)zzdqy.zzp(paramObject, paramLong);
    if ((localList instanceof zzdos));
    for (Object localObject = ((zzdos)localList).zzayp(); ; localObject = Collections.unmodifiableList(localList))
    {
      zzdqy.zza(paramObject, paramLong, localObject);
      do
      {
        do
          return;
        while (zzhjc.isAssignableFrom(localList.getClass()));
        if ((!(localList instanceof zzdpv)) || (!(localList instanceof zzdoi)))
          break;
      }
      while (!((zzdoi)localList).zzavi());
      ((zzdoi)localList).zzavj();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdov
 * JD-Core Version:    0.6.2
 */