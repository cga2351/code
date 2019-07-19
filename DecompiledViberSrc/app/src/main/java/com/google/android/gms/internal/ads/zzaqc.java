package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzare
public class zzaqc
{
  private final zzbha zzdbu;
  private final String zzdjf;

  public zzaqc(zzbha paramzzbha)
  {
    this(paramzzbha, "");
  }

  public zzaqc(zzbha paramzzbha, String paramString)
  {
    this.zzdbu = paramzzbha;
    this.zzdjf = paramString;
  }

  public final void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      this.zzdbu.zza("onSizeChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzc("Error occured while dispatching size change.", localJSONException);
    }
  }

  public final void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("width", paramInt1).put("height", paramInt2).put("maxSizeWidth", paramInt3).put("maxSizeHeight", paramInt4).put("density", paramFloat).put("rotation", paramInt5);
      this.zzdbu.zza("onScreenInfoChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzc("Error occured while obtaining screen information.", localJSONException);
    }
  }

  public final void zzb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      this.zzdbu.zza("onDefaultPositionReceived", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzc("Error occured while dispatching default position.", localJSONException);
    }
  }

  public final void zzdh(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("message", paramString).put("action", this.zzdjf);
      if (this.zzdbu != null)
        this.zzdbu.zza("onError", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzc("Error occurred while dispatching error event.", localJSONException);
    }
  }

  public final void zzdi(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("js", paramString);
      this.zzdbu.zza("onReadyEventReceived", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzc("Error occured while dispatching ready Event.", localJSONException);
    }
  }

  public final void zzdj(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("state", paramString);
      this.zzdbu.zza("onStateChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzc("Error occured while dispatching state change.", localJSONException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaqc
 * JD-Core Version:    0.6.2
 */