package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

public final class zzcjv<DelegateT, AdapterT>
  implements zzcju<AdapterT>
{

  @VisibleForTesting
  private final zzcju<DelegateT> zzfzl;
  private final zzban<DelegateT, AdapterT> zzfzm;

  public zzcjv(zzcju<DelegateT> paramzzcju, zzban<DelegateT, AdapterT> paramzzban)
  {
    this.zzfzl = paramzzcju;
    this.zzfzm = paramzzban;
  }

  public final boolean zza(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return this.zzfzl.zza(paramzzcxt, paramzzcxl);
  }

  public final zzbbi<AdapterT> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return zzbas.zza(this.zzfzl.zzb(paramzzcxt, paramzzcxl), this.zzfzm, zzaxh.zzdvr);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcjv
 * JD-Core Version:    0.6.2
 */