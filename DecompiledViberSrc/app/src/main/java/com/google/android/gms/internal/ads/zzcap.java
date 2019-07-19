package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONObject;

public final class zzcap
{
  private final zzbbm zzfqw;
  private final zzcat zzfqx;
  private final zzcbc zzfqy;

  public zzcap(zzbbm paramzzbbm, zzcat paramzzcat, zzcbc paramzzcbc)
  {
    this.zzfqw = paramzzbbm;
    this.zzfqx = paramzzcat;
    this.zzfqy = paramzzcbc;
  }

  public final zzbbi<zzbys> zza(zzcxt paramzzcxt, zzcxl paramzzcxl, JSONObject paramJSONObject)
  {
    zzbbi localzzbbi1 = this.zzfqw.zza(new zzcaq(this, paramzzcxt, paramzzcxl, paramJSONObject));
    zzbbi localzzbbi2 = this.zzfqx.zzd(paramJSONObject, "images");
    zzbbi localzzbbi3 = this.zzfqx.zzc(paramJSONObject, "secondary_image");
    zzbbi localzzbbi4 = this.zzfqx.zzc(paramJSONObject, "app_icon");
    zzbbi localzzbbi5 = this.zzfqx.zze(paramJSONObject, "attribution");
    zzbbi localzzbbi6 = this.zzfqx.zzl(paramJSONObject);
    zzcat localzzcat = this.zzfqx;
    Object localObject;
    if (!paramJSONObject.optBoolean("enable_omid"))
      localObject = zzbas.zzm(null);
    while (true)
    {
      zzbbi localzzbbi7 = this.zzfqy.zzg(paramJSONObject, "custom_assets");
      return zzbas.zza(new zzbbi[] { localzzbbi1, localzzbbi2, localzzbbi3, localzzbbi4, localzzbbi5, localzzbbi6, localObject, localzzbbi7 }).zza(new zzcar(this, localzzbbi1, localzzbbi2, localzzbbi4, localzzbbi3, localzzbbi5, paramJSONObject, localzzbbi6, (zzbbi)localObject, localzzbbi7), this.zzfqw);
      JSONObject localJSONObject = paramJSONObject.optJSONObject("omid_settings");
      if (localJSONObject == null)
      {
        localObject = zzbas.zzm(null);
      }
      else
      {
        String str = localJSONObject.optString("omid_html");
        if (TextUtils.isEmpty(str))
          localObject = zzbas.zzm(null);
        else
          localObject = zzbas.zza(zzbas.zzm(null), new zzcax(localzzcat, str), zzbbn.zzeag);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcap
 * JD-Core Version:    0.6.2
 */