package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import java.io.IOException;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcxp
  implements zzazg
{

  @Nullable
  public final String zzdkp;

  @Nullable
  public final String zzdkr;
  public final JSONObject zzfmo;
  private final JSONObject zzgks;

  zzcxp(JsonReader paramJsonReader)
    throws IllegalStateException, IOException, JSONException, NumberFormatException
  {
    this.zzgks = zzazd.zzc(paramJsonReader);
    this.zzdkr = this.zzgks.optString("ad_html", null);
    this.zzdkp = this.zzgks.optString("ad_base_url", null);
    this.zzfmo = this.zzgks.optJSONObject("ad_json");
  }

  public final void zza(JsonWriter paramJsonWriter)
    throws IOException
  {
    zzazd.zza(paramJsonWriter, this.zzgks);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxp
 * JD-Core Version:    0.6.2
 */