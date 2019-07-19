package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

public final class zzcxn
{
  public final int responseCode;
  public final String zzceq;
  public final List<String> zzdfj;
  public final String zzdol;
  public final long zzfyb;
  public final int zzgkr;

  zzcxn(JsonReader paramJsonReader)
    throws IllegalStateException, IOException, JSONException, NumberFormatException
  {
    List localList1 = Collections.emptyList();
    String str1 = "";
    String str2 = "";
    long l = 0L;
    paramJsonReader.beginObject();
    List localList2 = localList1;
    int j = 0;
    while (paramJsonReader.hasNext())
    {
      String str3 = paramJsonReader.nextName();
      if ("nofill_urls".equals(str3))
        localList2 = zzazd.zza(paramJsonReader);
      else if ("refresh_interval".equals(str3))
        j = paramJsonReader.nextInt();
      else if ("gws_query_id".equals(str3))
        str1 = paramJsonReader.nextString();
      else if ("analytics_query_ad_event_id".equals(str3))
        str2 = paramJsonReader.nextString();
      else if ("response_code".equals(str3))
        i = paramJsonReader.nextInt();
      else if ("latency".equals(str3))
        l = paramJsonReader.nextLong();
      else
        paramJsonReader.skipValue();
    }
    paramJsonReader.endObject();
    this.zzdfj = localList2;
    this.zzgkr = j;
    this.zzceq = str1;
    this.zzdol = str2;
    this.responseCode = i;
    this.zzfyb = l;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxn
 * JD-Core Version:    0.6.2
 */