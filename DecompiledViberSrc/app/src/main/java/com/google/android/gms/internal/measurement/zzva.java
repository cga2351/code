package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class zzva<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, zzuy> zzbzu;

  private zzva(Map.Entry<K, zzuy> paramEntry)
  {
    this.zzbzu = paramEntry;
  }

  public final K getKey()
  {
    return this.zzbzu.getKey();
  }

  public final Object getValue()
  {
    if ((zzuy)this.zzbzu.getValue() == null)
      return null;
    return zzuy.zzwz();
  }

  public final Object setValue(Object paramObject)
  {
    if (!(paramObject instanceof zzvv))
      throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    return ((zzuy)this.zzbzu.getValue()).zzi((zzvv)paramObject);
  }

  public final zzuy zzxa()
  {
    return (zzuy)this.zzbzu.getValue();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzva
 * JD-Core Version:    0.6.2
 */