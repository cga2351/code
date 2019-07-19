package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzdpf
  implements zzdpe
{
  public final Map<?, ?> zzae(Object paramObject)
  {
    return (zzdpd)paramObject;
  }

  public final Map<?, ?> zzaf(Object paramObject)
  {
    return (zzdpd)paramObject;
  }

  public final boolean zzag(Object paramObject)
  {
    return !((zzdpd)paramObject).isMutable();
  }

  public final Object zzah(Object paramObject)
  {
    ((zzdpd)paramObject).zzavj();
    return paramObject;
  }

  public final Object zzai(Object paramObject)
  {
    return zzdpd.zzayt().zzayu();
  }

  public final zzdpc<?, ?> zzaj(Object paramObject)
  {
    throw new NoSuchMethodError();
  }

  public final int zzb(int paramInt, Object paramObject1, Object paramObject2)
  {
    zzdpd localzzdpd = (zzdpd)paramObject1;
    if (localzzdpd.isEmpty());
    Iterator localIterator;
    do
    {
      return 0;
      localIterator = localzzdpd.entrySet().iterator();
    }
    while (!localIterator.hasNext());
    Map.Entry localEntry = (Map.Entry)localIterator.next();
    localEntry.getKey();
    localEntry.getValue();
    throw new NoSuchMethodError();
  }

  public final Object zzc(Object paramObject1, Object paramObject2)
  {
    zzdpd localzzdpd1 = (zzdpd)paramObject1;
    zzdpd localzzdpd2 = (zzdpd)paramObject2;
    if (!localzzdpd2.isEmpty())
    {
      if (!localzzdpd1.isMutable())
        localzzdpd1 = localzzdpd1.zzayu();
      localzzdpd1.zza(localzzdpd2);
    }
    return localzzdpd1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdpf
 * JD-Core Version:    0.6.2
 */