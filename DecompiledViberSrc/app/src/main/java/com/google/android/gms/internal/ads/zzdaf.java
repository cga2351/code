package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzdaf
  implements zzdth<zzdad>
{
  private final zzdtt<Context> zzeol;
  private final zzdtt<zzbai> zzero;
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<Clock> zzfgi;
  private final zzdtt<zzbaj> zzfgo;
  private final zzdtt<String> zzggq;
  private final zzdtt<String> zzggr;
  private final zzdtt<zzcmt> zzgnt;

  private zzdaf(zzdtt<Executor> paramzzdtt, zzdtt<zzbai> paramzzdtt1, zzdtt<zzcmt> paramzzdtt2, zzdtt<zzbaj> paramzzdtt3, zzdtt<String> paramzzdtt4, zzdtt<String> paramzzdtt5, zzdtt<Context> paramzzdtt6, zzdtt<Clock> paramzzdtt7)
  {
    this.zzfgg = paramzzdtt;
    this.zzero = paramzzdtt1;
    this.zzgnt = paramzzdtt2;
    this.zzfgo = paramzzdtt3;
    this.zzggq = paramzzdtt4;
    this.zzggr = paramzzdtt5;
    this.zzeol = paramzzdtt6;
    this.zzfgi = paramzzdtt7;
  }

  public static zzdaf zzc(zzdtt<Executor> paramzzdtt, zzdtt<zzbai> paramzzdtt1, zzdtt<zzcmt> paramzzdtt2, zzdtt<zzbaj> paramzzdtt3, zzdtt<String> paramzzdtt4, zzdtt<String> paramzzdtt5, zzdtt<Context> paramzzdtt6, zzdtt<Clock> paramzzdtt7)
  {
    return new zzdaf(paramzzdtt, paramzzdtt1, paramzzdtt2, paramzzdtt3, paramzzdtt4, paramzzdtt5, paramzzdtt6, paramzzdtt7);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdaf
 * JD-Core Version:    0.6.2
 */