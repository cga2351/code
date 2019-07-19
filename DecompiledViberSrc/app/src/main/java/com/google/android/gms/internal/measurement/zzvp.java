package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzvp<K, V> extends LinkedHashMap<K, V>
{
  private static final zzvp zzcan;
  private boolean zzbtn = true;

  static
  {
    zzvp localzzvp = new zzvp();
    zzcan = localzzvp;
    localzzvp.zzbtn = false;
  }

  private zzvp()
  {
  }

  private zzvp(Map<K, V> paramMap)
  {
    super(paramMap);
  }

  private static int zzab(Object paramObject)
  {
    if ((paramObject instanceof byte[]))
      return zzuq.hashCode((byte[])paramObject);
    if ((paramObject instanceof zzur))
      throw new UnsupportedOperationException();
    return paramObject.hashCode();
  }

  public static <K, V> zzvp<K, V> zzxg()
  {
    return zzcan;
  }

  private final void zzxi()
  {
    if (!this.zzbtn)
      throw new UnsupportedOperationException();
  }

  public final void clear()
  {
    zzxi();
    super.clear();
  }

  public final Set<Map.Entry<K, V>> entrySet()
  {
    if (isEmpty())
      return Collections.emptySet();
    return super.entrySet();
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Map))
    {
      Map localMap = (Map)paramObject;
      int i;
      if (this != localMap)
        if (size() != localMap.size())
          i = 0;
      while (i != 0)
      {
        return true;
        Iterator localIterator = entrySet().iterator();
        label171: 
        while (true)
        {
          if (!localIterator.hasNext())
            break label173;
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (!localMap.containsKey(localEntry.getKey()))
          {
            i = 0;
            break;
          }
          Object localObject1 = localEntry.getValue();
          Object localObject2 = localMap.get(localEntry.getKey());
          if (((localObject1 instanceof byte[])) && ((localObject2 instanceof byte[])));
          for (boolean bool = Arrays.equals((byte[])localObject1, (byte[])localObject2); ; bool = localObject1.equals(localObject2))
          {
            if (bool)
              break label171;
            i = 0;
            break;
          }
        }
        label173: i = 1;
      }
    }
    return false;
  }

  public final int hashCode()
  {
    Iterator localIterator = entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      i += (zzab(localEntry.getKey()) ^ zzab(localEntry.getValue()));
    }
    return i;
  }

  public final boolean isMutable()
  {
    return this.zzbtn;
  }

  public final V put(K paramK, V paramV)
  {
    zzxi();
    zzuq.checkNotNull(paramK);
    zzuq.checkNotNull(paramV);
    return super.put(paramK, paramV);
  }

  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    zzxi();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      zzuq.checkNotNull(localObject);
      zzuq.checkNotNull(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }

  public final V remove(Object paramObject)
  {
    zzxi();
    return super.remove(paramObject);
  }

  public final void zza(zzvp<K, V> paramzzvp)
  {
    zzxi();
    if (!paramzzvp.isEmpty())
      putAll(paramzzvp);
  }

  public final void zzsw()
  {
    this.zzbtn = false;
  }

  public final zzvp<K, V> zzxh()
  {
    if (isEmpty())
      return new zzvp();
    return new zzvp(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzvp
 * JD-Core Version:    0.6.2
 */