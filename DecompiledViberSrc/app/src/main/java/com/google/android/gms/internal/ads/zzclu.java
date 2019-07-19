package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzclu
  implements zzcjy<zzamt, zzckz>
{
  private final zzclb zzfvd;

  public zzclu(zzclb paramzzclb)
  {
    this.zzfvd = paramzzclb;
  }

  public final zzcjx<zzamt, zzckz> zzd(String paramString, JSONObject paramJSONObject)
    throws Throwable
  {
    zzamt localzzamt = this.zzfvd.zze(paramString, paramJSONObject);
    if (localzzamt == null)
      return null;
    return new zzcjx(localzzamt, new zzckz(), paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzclu
 * JD-Core Version:    0.6.2
 */