package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzdpd<K, V> extends LinkedHashMap<K, V>
{
  private static final zzdpd zzhjl;
  private boolean zzhci = true;

  static
  {
    zzdpd localzzdpd = new zzdpd();
    zzhjl = localzzdpd;
    localzzdpd.zzhci = false;
  }

  private zzdpd()
  {
  }

  private zzdpd(Map<K, V> paramMap)
  {
    super(paramMap);
  }

  private static int zzad(Object paramObject)
  {
    if ((paramObject instanceof byte[]))
      return zzdoc.hashCode((byte[])paramObject);
    if ((paramObject instanceof zzdod))
      throw new UnsupportedOperationException();
    return paramObject.hashCode();
  }

  public static <K, V> zzdpd<K, V> zzayt()
  {
    return zzhjl;
  }

  private final void zzayv()
  {
    if (!this.zzhci)
      throw new UnsupportedOperationException();
  }

  public final void clear()
  {
    zzayv();
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
      i += (zzad(localEntry.getKey()) ^ zzad(localEntry.getValue()));
    }
    return i;
  }

  public final boolean isMutable()
  {
    return this.zzhci;
  }

  public final V put(K paramK, V paramV)
  {
    zzayv();
    zzdoc.checkNotNull(paramK);
    zzdoc.checkNotNull(paramV);
    return super.put(paramK, paramV);
  }

  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    zzayv();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      zzdoc.checkNotNull(localObject);
      zzdoc.checkNotNull(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }

  public final V remove(Object paramObject)
  {
    zzayv();
    return super.remove(paramObject);
  }

  public final void zza(zzdpd<K, V> paramzzdpd)
  {
    zzayv();
    if (!paramzzdpd.isEmpty())
      putAll(paramzzdpd);
  }

  public final void zzavj()
  {
    this.zzhci = false;
  }

  public final zzdpd<K, V> zzayu()
  {
    if (isEmpty())
      return new zzdpd();
    return new zzdpd(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdpd
 * JD-Core Version:    0.6.2
 */