package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

@zzare
public final class zzase
{
  private final int errorCode;
  private final String type;
  private String url;
  private final String zzdlz;
  private final String zzdol;
  private final boolean zzdom;
  private final List<String> zzdoz;
  private final String zzdpa;
  private final String zzdpb;
  private final boolean zzdpc;
  private final String zzdpd;
  private final boolean zzdpe;
  private final JSONObject zzdpf;

  public zzase(JSONObject paramJSONObject)
  {
    this.url = paramJSONObject.optString("url");
    this.zzdpa = paramJSONObject.optString("base_uri");
    this.zzdpb = paramJSONObject.optString("post_parameters");
    String str1 = paramJSONObject.optString("drt_include");
    int j;
    String str2;
    List localList;
    label110: JSONObject localJSONObject;
    if ((str1 != null) && ((str1.equals("1")) || (str1.equals("true"))))
    {
      j = i;
      this.zzdpc = j;
      this.zzdlz = paramJSONObject.optString("request_id");
      this.type = paramJSONObject.optString("type");
      str2 = paramJSONObject.optString("errors");
      if (str2 != null)
        break label201;
      localList = null;
      this.zzdoz = localList;
      if (paramJSONObject.optInt("valid", 0) == i)
        i = -2;
      this.errorCode = i;
      this.zzdpd = paramJSONObject.optString("fetched_ad");
      this.zzdpe = paramJSONObject.optBoolean("render_test_ad_label");
      localJSONObject = paramJSONObject.optJSONObject("preprocessor_flags");
      if (localJSONObject == null)
        break label216;
    }
    while (true)
    {
      this.zzdpf = localJSONObject;
      this.zzdol = paramJSONObject.optString("analytics_query_ad_event_id");
      this.zzdom = paramJSONObject.optBoolean("is_analytics_logging_enabled");
      return;
      j = 0;
      break;
      label201: localList = Arrays.asList(str2.split(","));
      break label110;
      label216: localJSONObject = new JSONObject();
    }
  }

  public final String getUrl()
  {
    return this.url;
  }

  public final String zztu()
  {
    return this.zzdpa;
  }

  public final String zztv()
  {
    return this.zzdpb;
  }

  public final boolean zztw()
  {
    return this.zzdpc;
  }

  public final JSONObject zztx()
  {
    return this.zzdpf;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzase
 * JD-Core Version:    0.6.2
 */