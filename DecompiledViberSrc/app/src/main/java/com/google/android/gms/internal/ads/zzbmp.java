package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzbmp
  implements zzdth<zzbmm>
{
  private final zzdtt<zzalz> zzfge;
  private final zzdtt<zzbmk> zzfgf;
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<zzbmh> zzfgh;
  private final zzdtt<Clock> zzfgi;

  private zzbmp(zzdtt<zzalz> paramzzdtt, zzdtt<zzbmk> paramzzdtt1, zzdtt<Executor> paramzzdtt2, zzdtt<zzbmh> paramzzdtt3, zzdtt<Clock> paramzzdtt4)
  {
    this.zzfge = paramzzdtt;
    this.zzfgf = paramzzdtt1;
    this.zzfgg = paramzzdtt2;
    this.zzfgh = paramzzdtt3;
    this.zzfgi = paramzzdtt4;
  }

  public static zzbmp zza(zzdtt<zzalz> paramzzdtt, zzdtt<zzbmk> paramzzdtt1, zzdtt<Executor> paramzzdtt2, zzdtt<zzbmh> paramzzdtt3, zzdtt<Clock> paramzzdtt4)
  {
    return new zzbmp(paramzzdtt, paramzzdtt1, paramzzdtt2, paramzzdtt3, paramzzdtt4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbmp
 * JD-Core Version:    0.6.2
 */