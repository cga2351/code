package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzwh
{
  private static final zzwh zzcbl = new zzwh();
  private final zzwm zzcbm = new zzvk();
  private final ConcurrentMap<Class<?>, zzwl<?>> zzcbn = new ConcurrentHashMap();

  public static zzwh zzxt()
  {
    return zzcbl;
  }

  public final <T> zzwl<T> zzak(T paramT)
  {
    return zzi(paramT.getClass());
  }

  public final <T> zzwl<T> zzi(Class<T> paramClass)
  {
    zzuq.zza(paramClass, "messageType");
    zzwl localzzwl1 = (zzwl)this.zzcbn.get(paramClass);
    zzwl localzzwl2;
    if (localzzwl1 == null)
    {
      localzzwl2 = this.zzcbm.zzh(paramClass);
      zzuq.zza(paramClass, "messageType");
      zzuq.zza(localzzwl2, "schema");
      localzzwl1 = (zzwl)this.zzcbn.putIfAbsent(paramClass, localzzwl2);
      if (localzzwl1 == null);
    }
    else
    {
      return localzzwl1;
    }
    return localzzwl2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwh
 * JD-Core Version:    0.6.2
 */