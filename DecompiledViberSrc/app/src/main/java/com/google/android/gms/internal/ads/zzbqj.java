package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqj
  implements zzdth<zzbuy<zzbsq>>
{
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<zzbmf> zzfhr;

  private zzbqj(zzdtt<zzbmf> paramzzdtt, zzdtt<Executor> paramzzdtt1)
  {
    this.zzfhr = paramzzdtt;
    this.zzfgg = paramzzdtt1;
  }

  public static zzbuy<zzbsq> zza(zzbmf paramzzbmf, Executor paramExecutor)
  {
    return (zzbuy)zzdtn.zza(new zzbuy(paramzzbmf, paramExecutor), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static zzbqj zzh(zzdtt<zzbmf> paramzzdtt, zzdtt<Executor> paramzzdtt1)
  {
    return new zzbqj(paramzzdtt, paramzzdtt1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbqj
 * JD-Core Version:    0.6.2
 */