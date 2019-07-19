package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

public final class zzdtj<K, V>
  implements zzdth<Map<K, V>>
{
  private static final zzdtt<Map<Object, Object>> zzhuk = zzdti.zzar(Collections.emptyMap());
  private final Map<K, zzdtt<V>> zzhul;

  private zzdtj(Map<K, zzdtt<V>> paramMap)
  {
    this.zzhul = Collections.unmodifiableMap(paramMap);
  }

  public static <K, V> zzdtl<K, V> zzho(int paramInt)
  {
    return new zzdtl(paramInt, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdtj
 * JD-Core Version:    0.6.2
 */