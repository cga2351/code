package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzbzo
  implements zzdth<zzbzk>
{
  private final zzdtt<Context> zzeol;
  private final zzdtt<zzaxc> zzerl;
  private final zzdtt<zzbyw> zzewu;
  private final zzdtt<zzbzs> zzeyn;
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<Executor> zzfhh;
  private final zzdtt<zzcxu> zzfhq;
  private final zzdtt<zzbys> zzfnh;

  private zzbzo(zzdtt<Context> paramzzdtt, zzdtt<zzaxc> paramzzdtt1, zzdtt<zzcxu> paramzzdtt2, zzdtt<zzbyw> paramzzdtt3, zzdtt<zzbys> paramzzdtt4, zzdtt<zzbzs> paramzzdtt5, zzdtt<Executor> paramzzdtt6, zzdtt<Executor> paramzzdtt7)
  {
    this.zzeol = paramzzdtt;
    this.zzerl = paramzzdtt1;
    this.zzfhq = paramzzdtt2;
    this.zzewu = paramzzdtt3;
    this.zzfnh = paramzzdtt4;
    this.zzeyn = paramzzdtt5;
    this.zzfhh = paramzzdtt6;
    this.zzfgg = paramzzdtt7;
  }

  public static zzbzo zza(zzdtt<Context> paramzzdtt, zzdtt<zzaxc> paramzzdtt1, zzdtt<zzcxu> paramzzdtt2, zzdtt<zzbyw> paramzzdtt3, zzdtt<zzbys> paramzzdtt4, zzdtt<zzbzs> paramzzdtt5, zzdtt<Executor> paramzzdtt6, zzdtt<Executor> paramzzdtt7)
  {
    return new zzbzo(paramzzdtt, paramzzdtt1, paramzzdtt2, paramzzdtt3, paramzzdtt4, paramzzdtt5, paramzzdtt6, paramzzdtt7);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbzo
 * JD-Core Version:    0.6.2
 */