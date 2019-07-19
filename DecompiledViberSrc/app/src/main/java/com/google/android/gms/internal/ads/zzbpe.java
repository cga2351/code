package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbpe<AdT>
  implements zzbpd<AdT>
{
  private final Map<String, zzcju<AdT>> zzfis;

  zzbpe(Map<String, zzcju<AdT>> paramMap)
  {
    this.zzfis = paramMap;
  }

  public final zzcju<AdT> zze(int paramInt, String paramString)
  {
    return (zzcju)this.zzfis.get(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbpe
 * JD-Core Version:    0.6.2
 */