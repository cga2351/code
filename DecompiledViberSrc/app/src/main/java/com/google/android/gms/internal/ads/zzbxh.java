package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzbxh
  implements zzbpd<zzbpg>
{
  private final zzbzb zzfgy;
  private final Map<String, zzcju<zzbpg>> zzfis;
  private final Map<String, zzcju<zzbym>> zzflz;
  private final Map<String, zzclv<zzbym>> zzfma;
  private final zzdtt<zzbpd<zzbne>> zzfmb;

  zzbxh(Map<String, zzcju<zzbpg>> paramMap, Map<String, zzcju<zzbym>> paramMap1, Map<String, zzclv<zzbym>> paramMap2, zzdtt<zzbpd<zzbne>> paramzzdtt, zzbzb paramzzbzb)
  {
    this.zzfis = paramMap;
    this.zzflz = paramMap1;
    this.zzfma = paramMap2;
    this.zzfmb = paramzzdtt;
    this.zzfgy = paramzzbzb;
  }

  public final zzcju<zzbpg> zze(int paramInt, String paramString)
  {
    zzcju localzzcju1 = (zzcju)this.zzfis.get(paramString);
    if (localzzcju1 != null)
      return localzzcju1;
    switch (paramInt)
    {
    case 2:
    case 3:
    default:
      return null;
    case 1:
      if (this.zzfgy.zzail() == null)
        return null;
      zzcju localzzcju3 = ((zzbpd)this.zzfmb.get()).zze(paramInt, paramString);
      if (localzzcju3 == null)
        return null;
      return zzbpg.zza(localzzcju3);
    case 4:
    }
    zzclv localzzclv = (zzclv)this.zzfma.get(paramString);
    if (localzzclv != null)
      return zzbpg.zza(localzzclv);
    zzcju localzzcju2 = (zzcju)this.zzflz.get(paramString);
    if (localzzcju2 != null)
      return zzbpg.zza(localzzcju2);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbxh
 * JD-Core Version:    0.6.2
 */