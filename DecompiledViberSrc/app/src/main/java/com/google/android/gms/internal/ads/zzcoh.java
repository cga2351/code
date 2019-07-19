package com.google.android.gms.internal.ads;

public final class zzcoh<AdT, AdapterT, ListenerT extends zzbsl>
  implements zzdth<zzcod<AdT, AdapterT, ListenerT>>
{
  private final zzdtt<zzcjy<AdapterT, ListenerT>> zzfem;
  private final zzdtt<zzbbm> zzfhh;
  private final zzdtt<zzczs> zzfhu;
  private final zzdtt<zzcjz<AdT, AdapterT, ListenerT>> zzgcl;

  private zzcoh(zzdtt<zzczs> paramzzdtt, zzdtt<zzbbm> paramzzdtt1, zzdtt<zzcjy<AdapterT, ListenerT>> paramzzdtt2, zzdtt<zzcjz<AdT, AdapterT, ListenerT>> paramzzdtt3)
  {
    this.zzfhu = paramzzdtt;
    this.zzfhh = paramzzdtt1;
    this.zzfem = paramzzdtt2;
    this.zzgcl = paramzzdtt3;
  }

  public static <AdT, AdapterT, ListenerT extends zzbsl> zzcoh<AdT, AdapterT, ListenerT> zzf(zzdtt<zzczs> paramzzdtt, zzdtt<zzbbm> paramzzdtt1, zzdtt<zzcjy<AdapterT, ListenerT>> paramzzdtt2, zzdtt<zzcjz<AdT, AdapterT, ListenerT>> paramzzdtt3)
  {
    return new zzcoh(paramzzdtt, paramzzdtt1, paramzzdtt2, paramzzdtt3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcoh
 * JD-Core Version:    0.6.2
 */