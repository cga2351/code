package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcvd<T>
  implements zzdth<zzcva<T>>
{
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<Set<zzcuz<? extends zzcuy<T>>>> zzgik;

  private zzcvd(zzdtt<Executor> paramzzdtt, zzdtt<Set<zzcuz<? extends zzcuy<T>>>> paramzzdtt1)
  {
    this.zzfgg = paramzzdtt;
    this.zzgik = paramzzdtt1;
  }

  public static <T> zzcvd<T> zzat(zzdtt<Executor> paramzzdtt, zzdtt<Set<zzcuz<? extends zzcuy<T>>>> paramzzdtt1)
  {
    return new zzcvd(paramzzdtt, paramzzdtt1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcvd
 * JD-Core Version:    0.6.2
 */