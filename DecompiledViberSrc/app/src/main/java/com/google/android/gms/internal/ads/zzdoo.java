package com.google.android.gms.internal.ads;

import java.util.Map.Entry;

final class zzdoo<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, zzdom> zzhis;

  private zzdoo(Map.Entry<K, zzdom> paramEntry)
  {
    this.zzhis = paramEntry;
  }

  public final K getKey()
  {
    return this.zzhis.getKey();
  }

  public final Object getValue()
  {
    if ((zzdom)this.zzhis.getValue() == null)
      return null;
    return zzdom.zzaym();
  }

  public final Object setValue(Object paramObject)
  {
    if (!(paramObject instanceof zzdpj))
      throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    return ((zzdom)this.zzhis.getValue()).zzq((zzdpj)paramObject);
  }

  public final zzdom zzayn()
  {
    return (zzdom)this.zzhis.getValue();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdoo
 * JD-Core Version:    0.6.2
 */