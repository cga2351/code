package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcmy<AdT>
  implements zzdth<zzcmw<AdT>>
{
  private final zzdtt<zzdad> zzerr;
  private final zzdtt<zzbpd<AdT>> zzfgf;
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<ScheduledExecutorService> zzfgv;
  private final zzdtt<zzczs> zzfhu;
  private final zzdtt<zzbrl> zzgah;
  private final zzdtt<zzcmt> zzgbp;

  private zzcmy(zzdtt<zzczs> paramzzdtt, zzdtt<zzcmt> paramzzdtt1, zzdtt<zzbrl> paramzzdtt2, zzdtt<zzdad> paramzzdtt3, zzdtt<zzbpd<AdT>> paramzzdtt4, zzdtt<Executor> paramzzdtt5, zzdtt<ScheduledExecutorService> paramzzdtt6)
  {
    this.zzfhu = paramzzdtt;
    this.zzgbp = paramzzdtt1;
    this.zzgah = paramzzdtt2;
    this.zzerr = paramzzdtt3;
    this.zzfgf = paramzzdtt4;
    this.zzfgg = paramzzdtt5;
    this.zzfgv = paramzzdtt6;
  }

  public static <AdT> zzcmy<AdT> zza(zzdtt<zzczs> paramzzdtt, zzdtt<zzcmt> paramzzdtt1, zzdtt<zzbrl> paramzzdtt2, zzdtt<zzdad> paramzzdtt3, zzdtt<zzbpd<AdT>> paramzzdtt4, zzdtt<Executor> paramzzdtt5, zzdtt<ScheduledExecutorService> paramzzdtt6)
  {
    return new zzcmy(paramzzdtt, paramzzdtt1, paramzzdtt2, paramzzdtt3, paramzzdtt4, paramzzdtt5, paramzzdtt6);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcmy
 * JD-Core Version:    0.6.2
 */