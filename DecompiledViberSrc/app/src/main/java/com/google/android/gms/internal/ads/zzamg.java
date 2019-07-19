package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

final class zzamg
  implements zzahv
{
  private final zzbbs zzddx;

  public zzamg(zzame paramzzame, zzbbs paramzzbbs)
  {
    this.zzddx = paramzzbbs;
  }

  public final void onFailure(@Nullable String paramString)
  {
    if (paramString == null);
    try
    {
      this.zzddx.setException(new zzalj());
      return;
      this.zzddx.setException(new zzalj(paramString));
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public final void zzc(JSONObject paramJSONObject)
  {
    try
    {
      this.zzddx.set(zzame.zza(this.zzdee).zzd(paramJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      this.zzddx.set(localJSONException);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamg
 * JD-Core Version:    0.6.2
 */