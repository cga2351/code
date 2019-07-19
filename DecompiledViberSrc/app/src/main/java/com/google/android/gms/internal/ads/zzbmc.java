package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbmc
  implements zzblt
{
  private final zzaxc zzdum;

  public zzbmc(zzaxc paramzzaxc)
  {
    this.zzdum = paramzzaxc;
  }

  public final void zzk(Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("key");
    String str2 = (String)paramMap.get("value");
    if ("auto_collect_location".equals(str1))
      this.zzdum.zzak(Boolean.parseBoolean(str2));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbmc
 * JD-Core Version:    0.6.2
 */