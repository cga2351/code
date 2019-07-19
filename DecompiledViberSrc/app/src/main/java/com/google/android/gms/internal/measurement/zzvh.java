package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzvh extends zzvf
{
  private static final Class<?> zzcae = Collections.unmodifiableList(Collections.emptyList()).getClass();

  private zzvh()
  {
    super(null);
  }

  private static <L> List<L> zza(Object paramObject, long paramLong, int paramInt)
  {
    Object localObject = zzc(paramObject, paramLong);
    if (((List)localObject).isEmpty())
      if ((localObject instanceof zzve))
      {
        localObject = new zzvd(paramInt);
        zzxj.zza(paramObject, paramLong, localObject);
      }
    do
    {
      return localObject;
      if (((localObject instanceof zzwg)) && ((localObject instanceof zzuu)))
      {
        localObject = ((zzuu)localObject).zzal(paramInt);
        break;
      }
      localObject = new ArrayList(paramInt);
      break;
      if (zzcae.isAssignableFrom(localObject.getClass()))
      {
        ArrayList localArrayList = new ArrayList(paramInt + ((List)localObject).size());
        localArrayList.addAll((Collection)localObject);
        zzxj.zza(paramObject, paramLong, localArrayList);
        return localArrayList;
      }
      if ((localObject instanceof zzxg))
      {
        zzvd localzzvd = new zzvd(paramInt + ((List)localObject).size());
        localzzvd.addAll((zzxg)localObject);
        zzxj.zza(paramObject, paramLong, localzzvd);
        return localzzvd;
      }
    }
    while ((!(localObject instanceof zzwg)) || (!(localObject instanceof zzuu)) || (((zzuu)localObject).zztz()));
    zzuu localzzuu = ((zzuu)localObject).zzal(paramInt + ((List)localObject).size());
    zzxj.zza(paramObject, paramLong, localzzuu);
    return localzzuu;
  }

  private static <E> List<E> zzc(Object paramObject, long paramLong)
  {
    return (List)zzxj.zzp(paramObject, paramLong);
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
      zzxj.zza(paramObject1, paramLong, localList2);
      return;
      localList2 = localList1;
    }
  }

  final void zzb(Object paramObject, long paramLong)
  {
    List localList = (List)zzxj.zzp(paramObject, paramLong);
    if ((localList instanceof zzve));
    for (Object localObject = ((zzve)localList).zzxc(); ; localObject = Collections.unmodifiableList(localList))
    {
      zzxj.zza(paramObject, paramLong, localObject);
      do
      {
        do
          return;
        while (zzcae.isAssignableFrom(localList.getClass()));
        if ((!(localList instanceof zzwg)) || (!(localList instanceof zzuu)))
          break;
      }
      while (!((zzuu)localList).zztz());
      ((zzuu)localList).zzsw();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzvh
 * JD-Core Version:    0.6.2
 */