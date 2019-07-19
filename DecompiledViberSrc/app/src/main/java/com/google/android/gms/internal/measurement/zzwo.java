package com.google.android.gms.internal.measurement;

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

class zzwo<K extends Comparable<K>, V> extends AbstractMap<K, V>
{
  private boolean zzbqa;
  private final int zzcbt;
  private List<zzwv> zzcbu;
  private Map<K, V> zzcbv;
  private volatile zzwx zzcbw;
  private Map<K, V> zzcbx;
  private volatile zzwr zzcby;

  private zzwo(int paramInt)
  {
    this.zzcbt = paramInt;
    this.zzcbu = Collections.emptyList();
    this.zzcbv = Collections.emptyMap();
    this.zzcbx = Collections.emptyMap();
  }

  private final int zza(K paramK)
  {
    int i = -1 + this.zzcbu.size();
    if (i >= 0)
    {
      int i1 = paramK.compareTo((Comparable)((zzwv)this.zzcbu.get(i)).getKey());
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
        int n = paramK.compareTo((Comparable)((zzwv)this.zzcbu.get(m)).getKey());
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

  static <FieldDescriptorType extends zzuh<FieldDescriptorType>> zzwo<FieldDescriptorType, Object> zzbw(int paramInt)
  {
    return new zzwp(paramInt);
  }

  private final V zzby(int paramInt)
  {
    zzyf();
    Object localObject = ((zzwv)this.zzcbu.remove(paramInt)).getValue();
    if (!this.zzcbv.isEmpty())
    {
      Iterator localIterator = zzyg().entrySet().iterator();
      this.zzcbu.add(new zzwv(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    return localObject;
  }

  private final void zzyf()
  {
    if (this.zzbqa)
      throw new UnsupportedOperationException();
  }

  private final SortedMap<K, V> zzyg()
  {
    zzyf();
    if ((this.zzcbv.isEmpty()) && (!(this.zzcbv instanceof TreeMap)))
    {
      this.zzcbv = new TreeMap();
      this.zzcbx = ((TreeMap)this.zzcbv).descendingMap();
    }
    return (SortedMap)this.zzcbv;
  }

  public void clear()
  {
    zzyf();
    if (!this.zzcbu.isEmpty())
      this.zzcbu.clear();
    if (!this.zzcbv.isEmpty())
      this.zzcbv.clear();
  }

  public boolean containsKey(Object paramObject)
  {
    Comparable localComparable = (Comparable)paramObject;
    return (zza(localComparable) >= 0) || (this.zzcbv.containsKey(localComparable));
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    if (this.zzcbw == null)
      this.zzcbw = new zzwx(this, null);
    return this.zzcbw;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzwo localzzwo;
    int i;
    int j;
    do
    {
      return true;
      if (!(paramObject instanceof zzwo))
        return super.equals(paramObject);
      localzzwo = (zzwo)paramObject;
      i = size();
      if (i != localzzwo.size())
        return false;
      j = zzyc();
      if (j != localzzwo.zzyc())
        return entrySet().equals(localzzwo.entrySet());
      for (int k = 0; k < j; k++)
        if (!zzbx(k).equals(localzzwo.zzbx(k)))
          return false;
    }
    while (j == i);
    return this.zzcbv.equals(localzzwo.zzcbv);
  }

  public V get(Object paramObject)
  {
    Comparable localComparable = (Comparable)paramObject;
    int i = zza(localComparable);
    if (i >= 0)
      return ((zzwv)this.zzcbu.get(i)).getValue();
    return this.zzcbv.get(localComparable);
  }

  public int hashCode()
  {
    int i = zzyc();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += ((zzwv)this.zzcbu.get(j)).hashCode();
      j++;
    }
    if (this.zzcbv.size() > 0)
      return k + this.zzcbv.hashCode();
    return k;
  }

  public final boolean isImmutable()
  {
    return this.zzbqa;
  }

  public V remove(Object paramObject)
  {
    zzyf();
    Comparable localComparable = (Comparable)paramObject;
    int i = zza(localComparable);
    if (i >= 0)
      return zzby(i);
    if (this.zzcbv.isEmpty())
      return null;
    return this.zzcbv.remove(localComparable);
  }

  public int size()
  {
    return this.zzcbu.size() + this.zzcbv.size();
  }

  public final V zza(K paramK, V paramV)
  {
    zzyf();
    int i = zza(paramK);
    if (i >= 0)
      return ((zzwv)this.zzcbu.get(i)).setValue(paramV);
    zzyf();
    if ((this.zzcbu.isEmpty()) && (!(this.zzcbu instanceof ArrayList)))
      this.zzcbu = new ArrayList(this.zzcbt);
    int j = -(i + 1);
    if (j >= this.zzcbt)
      return zzyg().put(paramK, paramV);
    if (this.zzcbu.size() == this.zzcbt)
    {
      zzwv localzzwv = (zzwv)this.zzcbu.remove(-1 + this.zzcbt);
      zzyg().put((Comparable)localzzwv.getKey(), localzzwv.getValue());
    }
    this.zzcbu.add(j, new zzwv(this, paramK, paramV));
    return null;
  }

  public final Map.Entry<K, V> zzbx(int paramInt)
  {
    return (Map.Entry)this.zzcbu.get(paramInt);
  }

  public void zzsw()
  {
    Map localMap1;
    if (!this.zzbqa)
    {
      if (!this.zzcbv.isEmpty())
        break label55;
      localMap1 = Collections.emptyMap();
      this.zzcbv = localMap1;
      if (!this.zzcbx.isEmpty())
        break label66;
    }
    label55: label66: for (Map localMap2 = Collections.emptyMap(); ; localMap2 = Collections.unmodifiableMap(this.zzcbx))
    {
      this.zzcbx = localMap2;
      this.zzbqa = true;
      return;
      localMap1 = Collections.unmodifiableMap(this.zzcbv);
      break;
    }
  }

  public final int zzyc()
  {
    return this.zzcbu.size();
  }

  public final Iterable<Map.Entry<K, V>> zzyd()
  {
    if (this.zzcbv.isEmpty())
      return zzws.zzyi();
    return this.zzcbv.entrySet();
  }

  final Set<Map.Entry<K, V>> zzye()
  {
    if (this.zzcby == null)
      this.zzcby = new zzwr(this, null);
    return this.zzcby;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwo
 * JD-Core Version:    0.6.2
 */