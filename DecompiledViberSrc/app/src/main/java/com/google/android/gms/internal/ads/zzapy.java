package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzapy
{
  private final boolean zzdis;
  private final boolean zzdit;
  private final boolean zzdiu;
  private final boolean zzdiv;
  private final boolean zzdiw;

  private zzapy(zzaqa paramzzaqa)
  {
    this.zzdis = zzaqa.zza(paramzzaqa);
    this.zzdit = zzaqa.zzb(paramzzaqa);
    this.zzdiu = zzaqa.zzc(paramzzaqa);
    this.zzdiv = zzaqa.zzd(paramzzaqa);
    this.zzdiw = zzaqa.zze(paramzzaqa);
  }

  public final JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("sms", this.zzdis).put("tel", this.zzdit).put("calendar", this.zzdiu).put("storePicture", this.zzdiv).put("inlineVideo", this.zzdiw);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzc("Error occured while obtaining the MRAID capabilities.", localJSONException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapy
 * JD-Core Version:    0.6.2
 */