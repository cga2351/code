package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzdpw
{
  private static final zzdpw zzhkj = new zzdpw();
  private final zzdqb zzhkk = new zzdoy();
  private final ConcurrentMap<Class<?>, zzdqa<?>> zzhkl = new ConcurrentHashMap();

  public static zzdpw zzazg()
  {
    return zzhkj;
  }

  public final <T> zzdqa<T> zzan(T paramT)
  {
    return zzg(paramT.getClass());
  }

  public final <T> zzdqa<T> zzg(Class<T> paramClass)
  {
    zzdoc.zza(paramClass, "messageType");
    zzdqa localzzdqa1 = (zzdqa)this.zzhkl.get(paramClass);
    zzdqa localzzdqa2;
    if (localzzdqa1 == null)
    {
      localzzdqa2 = this.zzhkk.zzf(paramClass);
      zzdoc.zza(paramClass, "messageType");
      zzdoc.zza(localzzdqa2, "schema");
      localzzdqa1 = (zzdqa)this.zzhkl.putIfAbsent(paramClass, localzzdqa2);
      if (localzzdqa1 == null);
    }
    else
    {
      return localzzdqa1;
    }
    return localzzdqa2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdpw
 * JD-Core Version:    0.6.2
 */