package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcft
  implements zzdth<Set<zzbuy<zzbtj>>>
{
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<zzcfy> zzfuc;
  private final zzcfo zzfux;

  private zzcft(zzcfo paramzzcfo, zzdtt<zzcfy> paramzzdtt, zzdtt<Executor> paramzzdtt1)
  {
    this.zzfux = paramzzcfo;
    this.zzfuc = paramzzdtt;
    this.zzfgg = paramzzdtt1;
  }

  public static zzcft zze(zzcfo paramzzcfo, zzdtt<zzcfy> paramzzdtt, zzdtt<Executor> paramzzdtt1)
  {
    return new zzcft(paramzzcfo, paramzzdtt, paramzzdtt1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcft
 * JD-Core Version:    0.6.2
 */