package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzcnj
  implements zzcjy<zzamt, zzcla>
{
  private final zzclb zzfvd;

  @GuardedBy("this")
  private final Map<String, zzcjx<zzamt, zzcla>> zzgbu = new HashMap();

  public zzcnj(zzclb paramzzclb)
  {
    this.zzfvd = paramzzclb;
  }

  public final zzcjx<zzamt, zzcla> zzd(String paramString, JSONObject paramJSONObject)
    throws Throwable
  {
    try
    {
      zzcjx localzzcjx = (zzcjx)this.zzgbu.get(paramString);
      if (localzzcjx == null)
      {
        zzamt localzzamt = this.zzfvd.zze(paramString, paramJSONObject);
        if (localzzamt == null)
          return null;
        localzzcjx = new zzcjx(localzzamt, new zzcla(), paramString);
        this.zzgbu.put(paramString, localzzcjx);
      }
      return localzzcjx;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcnj
 * JD-Core Version:    0.6.2
 */