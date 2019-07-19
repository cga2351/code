package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzbyx extends zzbyw
{
  private final boolean zzdft;
  private final boolean zzdfu;
  private final boolean zzdoj;
  private final JSONObject zzfov;

  public zzbyx(zzcxl paramzzcxl, JSONObject paramJSONObject)
  {
    super(paramzzcxl);
    this.zzfov = zzazd.zza(paramJSONObject, new String[] { "tracking_urls_and_actions", "active_view" });
    this.zzdfu = zzazd.zza(false, paramJSONObject, new String[] { "allow_pub_owned_ad_view" });
    this.zzdft = zzazd.zza(false, paramJSONObject, new String[] { "attribution", "allow_pub_rendering" });
    this.zzdoj = zzazd.zza(false, paramJSONObject, new String[] { "enable_omid" });
  }

  public final JSONObject zzaie()
  {
    if (this.zzfov != null)
      return this.zzfov;
    try
    {
      JSONObject localJSONObject = new JSONObject(this.zzfou.zzdnt);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public final boolean zzaif()
  {
    return this.zzdfu;
  }

  public final boolean zzaig()
  {
    return this.zzdft;
  }

  public final boolean zzaih()
  {
    return this.zzdoj;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbyx
 * JD-Core Version:    0.6.2
 */