package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzbly
  implements zzblt
{
  private final zzcxj zzfez;

  public zzbly(zzcxj paramzzcxj)
  {
    this.zzfez = paramzzcxj;
  }

  public final void zzk(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("render_in_browser");
    if (!TextUtils.isEmpty(str));
    try
    {
      this.zzfez.zzbb(Boolean.parseBoolean(str));
      return;
    }
    catch (Exception localException)
    {
    }
    throw new IllegalStateException("Invalid render_in_browser state");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbly
 * JD-Core Version:    0.6.2
 */