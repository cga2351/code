package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
@ParametersAreNonnullByDefault
public final class zzamm
{
  private final String zzdei;
  private final String zzdej;
  public final List<String> zzdek;
  private final String zzdel;
  private final String zzdem;
  private final List<String> zzden;
  private final List<String> zzdeo;
  private final List<String> zzdep;
  private final List<String> zzdeq;
  private final List<String> zzder;
  public final String zzdes;
  private final List<String> zzdet;
  private final List<String> zzdeu;
  private final List<String> zzdev;
  private final String zzdew;
  private final String zzdex;
  private final String zzdey;
  private final String zzdez;
  private final String zzdfa;
  private final List<String> zzdfb;
  private final String zzdfc;
  public final String zzdfd;
  private final long zzdfe;

  public zzamm(JSONObject paramJSONObject)
    throws JSONException
  {
    this.zzdej = paramJSONObject.optString("id");
    JSONArray localJSONArray = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    for (int i = 0; i < localJSONArray.length(); i++)
      localArrayList.add(localJSONArray.getString(i));
    this.zzdek = Collections.unmodifiableList(localArrayList);
    this.zzdel = paramJSONObject.optString("allocation_id", null);
    zzk.zzly();
    this.zzden = zzamo.zza(paramJSONObject, "clickurl");
    zzk.zzly();
    this.zzdeo = zzamo.zza(paramJSONObject, "imp_urls");
    zzk.zzly();
    this.zzdep = zzamo.zza(paramJSONObject, "downloaded_imp_urls");
    zzk.zzly();
    this.zzder = zzamo.zza(paramJSONObject, "fill_urls");
    zzk.zzly();
    this.zzdet = zzamo.zza(paramJSONObject, "video_start_urls");
    zzk.zzly();
    this.zzdev = zzamo.zza(paramJSONObject, "video_complete_urls");
    zzk.zzly();
    this.zzdeu = zzamo.zza(paramJSONObject, "video_reward_urls");
    this.zzdew = paramJSONObject.optString("transaction_id");
    this.zzdex = paramJSONObject.optString("valid_from_timestamp");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("ad");
    List localList;
    String str1;
    label245: String str2;
    label271: String str3;
    label291: String str4;
    label339: JSONObject localJSONObject4;
    if (localJSONObject1 != null)
    {
      zzk.zzly();
      localList = zzamo.zza(localJSONObject1, "manual_impression_urls");
      this.zzdeq = localList;
      if (localJSONObject1 == null)
        break label416;
      str1 = localJSONObject1.toString();
      this.zzdei = str1;
      JSONObject localJSONObject2 = paramJSONObject.optJSONObject("data");
      if (localJSONObject2 == null)
        break label422;
      str2 = localJSONObject2.toString();
      this.zzdes = str2;
      if (localJSONObject2 == null)
        break label428;
      str3 = localJSONObject2.optString("class_name");
      this.zzdem = str3;
      this.zzdey = paramJSONObject.optString("html_template", null);
      this.zzdez = paramJSONObject.optString("ad_base_url", null);
      JSONObject localJSONObject3 = paramJSONObject.optJSONObject("assets");
      if (localJSONObject3 == null)
        break label434;
      str4 = localJSONObject3.toString();
      this.zzdfa = str4;
      zzk.zzly();
      this.zzdfb = zzamo.zza(paramJSONObject, "template_ids");
      localJSONObject4 = paramJSONObject.optJSONObject("ad_loader_options");
      if (localJSONObject4 == null)
        break label440;
    }
    label416: label422: label428: label434: label440: for (String str5 = localJSONObject4.toString(); ; str5 = null)
    {
      this.zzdfc = str5;
      this.zzdfd = paramJSONObject.optString("response_type", null);
      this.zzdfe = paramJSONObject.optLong("ad_network_timeout_millis", -1L);
      return;
      localList = null;
      break;
      str1 = null;
      break label245;
      str2 = null;
      break label271;
      str3 = null;
      break label291;
      str4 = null;
      break label339;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamm
 * JD-Core Version:    0.6.2
 */