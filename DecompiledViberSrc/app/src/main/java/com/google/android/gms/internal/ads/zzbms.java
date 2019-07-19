package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzbms
  implements zzdth<zztw>
{
  private final zzdtt<JSONObject> zzewv;
  private final zzdtt<zzcxl> zzfgn;
  private final zzdtt<zzbaj> zzfgo;
  private final zzdtt<String> zzfgp;

  private zzbms(zzdtt<zzcxl> paramzzdtt, zzdtt<zzbaj> paramzzdtt1, zzdtt<JSONObject> paramzzdtt2, zzdtt<String> paramzzdtt3)
  {
    this.zzfgn = paramzzdtt;
    this.zzfgo = paramzzdtt1;
    this.zzewv = paramzzdtt2;
    this.zzfgp = paramzzdtt3;
  }

  public static zzbms zza(zzdtt<zzcxl> paramzzdtt, zzdtt<zzbaj> paramzzdtt1, zzdtt<JSONObject> paramzzdtt2, zzdtt<String> paramzzdtt3)
  {
    return new zzbms(paramzzdtt, paramzzdtt1, paramzzdtt2, paramzzdtt3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbms
 * JD-Core Version:    0.6.2
 */