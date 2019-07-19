package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

public final class zzdtl<K, V>
{
  private final LinkedHashMap<K, zzdtt<V>> zzhum;

  private zzdtl(int paramInt)
  {
    this.zzhum = zzdte.zzhm(paramInt);
  }

  public final zzdtl<K, V> zza(K paramK, zzdtt<V> paramzzdtt)
  {
    this.zzhum.put(zzdtn.zza(paramK, "key"), (zzdtt)zzdtn.zza(paramzzdtt, "provider"));
    return this;
  }

  public final zzdtj<K, V> zzbbf()
  {
    return new zzdtj(this.zzhum, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdtl
 * JD-Core Version:    0.6.2
 */