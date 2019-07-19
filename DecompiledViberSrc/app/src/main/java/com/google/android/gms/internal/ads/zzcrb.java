package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzk;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcrb
{
  public final String zzgfw;
  public String zzgfx;

  public zzcrb(JsonReader paramJsonReader)
    throws IllegalStateException, IOException, JSONException, NumberFormatException
  {
    String str1 = "";
    paramJsonReader.beginObject();
    label11: 
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      if (str2 == null)
        str2 = "";
      switch (str2.hashCode())
      {
      default:
      case -995427962:
      }
      label52: for (int i = -1; ; i = 0)
        switch (i)
        {
        default:
          paramJsonReader.skipValue();
          break label11;
          if (!str2.equals("params"))
            break label52;
        case 0:
        }
      str1 = paramJsonReader.nextString();
    }
    this.zzgfw = str1;
    paramJsonReader.endObject();
  }

  final zzcrb zzn(Bundle paramBundle)
  {
    try
    {
      this.zzgfx = zzk.zzlg().zzd(paramBundle).toString();
      return this;
    }
    catch (JSONException localJSONException)
    {
      this.zzgfx = "{}";
    }
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcrb
 * JD-Core Version:    0.6.2
 */