package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzcew
  implements zzczy
{
  private zzwh zzftz;
  private Map<zzczr, zzcey> zzfuj;

  zzcew(zzwh paramzzwh, Map<zzczr, zzcey> paramMap)
  {
    this.zzfuj = paramMap;
    this.zzftz = paramzzwh;
  }

  public final void zza(zzczr paramzzczr, String paramString)
  {
  }

  public final void zza(zzczr paramzzczr, String paramString, Throwable paramThrowable)
  {
    if (this.zzfuj.containsKey(paramzzczr))
      this.zzftz.zza(((zzcey)this.zzfuj.get(paramzzczr)).zzfum);
  }

  public final void zzb(zzczr paramzzczr, String paramString)
  {
    if (this.zzfuj.containsKey(paramzzczr))
      this.zzftz.zza(((zzcey)this.zzfuj.get(paramzzczr)).zzfuk);
  }

  public final void zzc(zzczr paramzzczr, String paramString)
  {
    if (this.zzfuj.containsKey(paramzzczr))
      this.zzftz.zza(((zzcey)this.zzfuj.get(paramzzczr)).zzful);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcew
 * JD-Core Version:    0.6.2
 */