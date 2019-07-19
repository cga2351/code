package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzdqd<K extends Comparable<K>, V> extends AbstractMap<K, V>
{
  private boolean zzheh;
  private final int zzhkr;
  private List<zzdqk> zzhks;
  private Map<K, V> zzhkt;
  private volatile zzdqm zzhku;
  private Map<K, V> zzhkv;
  private volatile zzdqg zzhkw;

  private zzdqd(int paramInt)
  {
    this.zzhkr = paramInt;
    this.zzhks = Collections.emptyList();
    this.zzhkt = Collections.emptyMap();
    this.zzhkv = Collections.emptyMap();
  }

  private final int zza(K paramK)
  {
    int i = -1 + this.zzhks.size();
    if (i >= 0)
    {
      int i1 = paramK.compareTo((Comparable)((zzdqk)this.zzhks.get(i)).getKey());
      if (i1 > 0)
        return -(i + 2);
      if (i1 == 0)
        return i;
    }
    while (true)
    {
      int k;
      int j;
      if (k <= j)
      {
        int m = (k + j) / 2;
        int n = paramK.compareTo((Comparable)((zzdqk)this.zzhks.get(m)).getKey());
        if (n < 0)
          j = m - 1;
        else if (n > 0)
          k = m + 1;
        else
          return m;
      }
      else
      {
        return -(k + 1);
        j = i;
        k = 0;
      }
    }
  }

  private final void zzazs()
  {
    if (this.zzheh)
      throw new UnsupportedOperationException();
  }

  private final SortedMap<K, V> zzazt()
  {
    zzazs();
    if ((this.zzhkt.isEmpty()) && (!(this.zzhkt instanceof TreeMap)))
    {
      this.zzhkt = new TreeMap();
      this.zzhkv = ((TreeMap)this.zzhkt).descendingMap();
    }
    return (SortedMap)this.zzhkt;
  }

  static <FieldDescriptorType extends zzdnt<FieldDescriptorType>> zzdqd<FieldDescriptorType, Object> zzgy(int paramInt)
  {
    return new zzdqe(paramInt);
  }

  private final V zzha(int paramInt)
  {
    zzazs();
    Object localObject = ((zzdqk)this.zzhks.remove(paramInt)).getValue();
    if (!this.zzhkt.isEmpty())
    {
      Iterator localIterator = zzazt().entrySet().iterator();
      this.zzhks.add(new zzdqk(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    return localObject;
  }

  public void clear()
  {
    zzazs();
    if (!this.zzhks.isEmpty())
      this.zzhks.clear();
    if (!this.zzhkt.isEmpty())
      this.zzhkt.clear();
  }

  public boolean containsKey(Object paramObject)
  {
    Comparable localComparable = (Comparable)paramObject;
    return (zza(localComparable) >= 0) || (this.zzhkt.containsKey(localComparable));
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    if (this.zzhku == null)
      this.zzhku = new zzdqm(this, null);
    return this.zzhku;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzdqd localzzdqd;
    int i;
    int j;
    do
    {
      return true;
      if (!(paramObject instanceof zzdqd))
        return super.equals(paramObject);
      localzzdqd = (zzdqd)paramObject;
      i = size();
      if (i != localzzdqd.size())
        return false;
      j = zzazp();
      if (j != localzzdqd.zzazp())
        return entrySet().equals(localzzdqd.entrySet());
      for (int k = 0; k < j; k++)
        if (!zzgz(k).equals(localzzdqd.zzgz(k)))
          return false;
    }
    while (j == i);
    return this.zzhkt.equals(localzzdqd.zzhkt);
  }

  public V get(Object paramObject)
  {
    Comparable localComparable = (Comparable)paramObject;
    int i = zza(localComparable);
    if (i >= 0)
      return ((zzdqk)this.zzhks.get(i)).getValue();
    return this.zzhkt.get(localComparable);
  }

  public int hashCode()
  {
    int i = zzazp();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += ((zzdqk)this.zzhks.get(j)).hashCode();
      j++;
    }
    if (this.zzhkt.size() > 0)
      return k + this.zzhkt.hashCode();
    return k;
  }

  public final boolean isImmutable()
  {
    return this.zzheh;
  }

  public V remove(Object paramObject)
  {
    zzazs();
    Comparable localComparable = (Comparable)paramObject;
    int i = zza(localComparable);
    if (i >= 0)
      return zzha(i);
    if (this.zzhkt.isEmpty())
      return null;
    return this.zzhkt.remove(localComparable);
  }

  public int size()
  {
    return this.zzhks.size() + this.zzhkt.size();
  }

  public final V zza(K paramK, V paramV)
  {
    zzazs();
    int i = zza(paramK);
    if (i >= 0)
      return ((zzdqk)this.zzhks.get(i)).setValue(paramV);
    zzazs();
    if ((this.zzhks.isEmpty()) && (!(this.zzhks instanceof ArrayList)))
      this.zzhks = new ArrayList(this.zzhkr);
    int j = -(i + 1);
    if (j >= this.zzhkr)
      return zzazt().put(paramK, paramV);
    if (this.zzhks.size() == this.zzhkr)
    {
      zzdqk localzzdqk = (zzdqk)this.zzhks.remove(-1 + this.zzhkr);
      zzazt().put((Comparable)localzzdqk.getKey(), localzzdqk.getValue());
    }
    this.zzhks.add(j, new zzdqk(this, paramK, paramV));
    return null;
  }

  public void zzavj()
  {
    Map localMap1;
    if (!this.zzheh)
    {
      if (!this.zzhkt.isEmpty())
        break label55;
      localMap1 = Collections.emptyMap();
      this.zzhkt = localMap1;
      if (!this.zzhkv.isEmpty())
        break label66;
    }
    label55: label66: for (Map localMap2 = Collections.emptyMap(); ; localMap2 = Collections.unmodifiableMap(this.zzhkv))
    {
      this.zzhkv = localMap2;
      this.zzheh = true;
      return;
      localMap1 = Collections.unmodifiableMap(this.zzhkt);
      break;
    }
  }

  public final int zzazp()
  {
    return this.zzhks.size();
  }

  public final Iterable<Map.Entry<K, V>> zzazq()
  {
    if (this.zzhkt.isEmpty())
      return zzdqh.zzazv();
    return this.zzhkt.entrySet();
  }

  final Set<Map.Entry<K, V>> zzazr()
  {
    if (this.zzhkw == null)
      this.zzhkw = new zzdqg(this, null);
    return this.zzhkw;
  }

  public final Map.Entry<K, V> zzgz(int paramInt)
  {
    return (Map.Entry)this.zzhks.get(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdqd
 * JD-Core Version:    0.6.2
 */