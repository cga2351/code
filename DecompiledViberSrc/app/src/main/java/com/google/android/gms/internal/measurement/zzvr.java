package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzvr
  implements zzvq
{
  public final Map<?, ?> zzac(Object paramObject)
  {
    return (zzvp)paramObject;
  }

  public final Map<?, ?> zzad(Object paramObject)
  {
    return (zzvp)paramObject;
  }

  public final boolean zzae(Object paramObject)
  {
    return !((zzvp)paramObject).isMutable();
  }

  public final Object zzaf(Object paramObject)
  {
    ((zzvp)paramObject).zzsw();
    return paramObject;
  }

  public final Object zzag(Object paramObject)
  {
    return zzvp.zzxg().zzxh();
  }

  public final zzvo<?, ?> zzah(Object paramObject)
  {
    throw new NoSuchMethodError();
  }

  public final int zzb(int paramInt, Object paramObject1, Object paramObject2)
  {
    zzvp localzzvp = (zzvp)paramObject1;
    if (localzzvp.isEmpty());
    Iterator localIterator;
    do
    {
      return 0;
      localIterator = localzzvp.entrySet().iterator();
    }
    while (!localIterator.hasNext());
    Map.Entry localEntry = (Map.Entry)localIterator.next();
    localEntry.getKey();
    localEntry.getValue();
    throw new NoSuchMethodError();
  }

  public final Object zzc(Object paramObject1, Object paramObject2)
  {
    zzvp localzzvp1 = (zzvp)paramObject1;
    zzvp localzzvp2 = (zzvp)paramObject2;
    if (!localzzvp2.isEmpty())
    {
      if (!localzzvp1.isMutable())
        localzzvp1 = localzzvp1.zzxh();
      localzzvp1.zza(localzzvp2);
    }
    return localzzvp1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzvr
 * JD-Core Version:    0.6.2
 */