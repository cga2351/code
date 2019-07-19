package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class zzdto<T>
{
  private final List<T> zzhun = new ArrayList(11);

  private zzdto(int paramInt)
  {
  }

  public static <T> zzdto<T> zzhp(int paramInt)
  {
    return new zzdto(11);
  }

  public final zzdto<T> zzas(T paramT)
  {
    this.zzhun.add(zzdtn.zza(paramT, "Set contributions cannot be null"));
    return this;
  }

  public final zzdto<T> zzb(Collection<? extends T> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      zzdtn.zza(localIterator.next(), "Set contributions cannot be null");
    this.zzhun.addAll(paramCollection);
    return this;
  }

  public final Set<T> zzbbg()
  {
    switch (this.zzhun.size())
    {
    default:
      return Collections.unmodifiableSet(new HashSet(this.zzhun));
    case 0:
      return Collections.emptySet();
    case 1:
    }
    return Collections.singleton(this.zzhun.get(0));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdto
 * JD-Core Version:    0.6.2
 */