package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import org.json.JSONObject;

final class zzahu
  implements zzahv
{
  zzahu(zzaht paramzzaht, zzbbs paramzzbbs)
  {
  }

  public final void onFailure(@Nullable String paramString)
  {
    this.zzdar.setException(new zzalj(paramString));
  }

  public final void zzc(JSONObject paramJSONObject)
  {
    this.zzdar.set(paramJSONObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzahu
 * JD-Core Version:    0.6.2
 */