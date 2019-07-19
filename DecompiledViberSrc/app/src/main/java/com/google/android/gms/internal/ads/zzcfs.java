package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfs
  implements zzdth<Set<zzbuy<zzbsq>>>
{
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<zzcfy> zzfuc;
  private final zzcfo zzfux;

  private zzcfs(zzcfo paramzzcfo, zzdtt<zzcfy> paramzzdtt, zzdtt<Executor> paramzzdtt1)
  {
    this.zzfux = paramzzcfo;
    this.zzfuc = paramzzdtt;
    this.zzfgg = paramzzdtt1;
  }

  public static Set<zzbuy<zzbsq>> zza(zzcfo paramzzcfo, zzcfy paramzzcfy, Executor paramExecutor)
  {
    return (Set)zzdtn.zza(zzcfo.zzc(paramzzcfy, paramExecutor), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static zzcfs zzd(zzcfo paramzzcfo, zzdtt<zzcfy> paramzzdtt, zzdtt<Executor> paramzzdtt1)
  {
    return new zzcfs(paramzzcfo, paramzzdtt, paramzzdtt1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcfs
 * JD-Core Version:    0.6.2
 */