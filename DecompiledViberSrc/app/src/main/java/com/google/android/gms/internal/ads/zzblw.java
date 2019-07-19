package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzblw
  implements zzblt
{
  private zzaxc zzdum;

  public zzblw(zzaxc paramzzaxc)
  {
    this.zzdum = paramzzaxc;
  }

  public final void zzk(Map<String, String> paramMap)
  {
    this.zzdum.zzaj(Boolean.parseBoolean((String)paramMap.get("content_vertical_opted_out")));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzblw
 * JD-Core Version:    0.6.2
 */