package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzawm
{
  private String zzdmm;
  private final long zzdtj;
  private final List<String> zzdtk = new ArrayList();
  private final List<String> zzdtl = new ArrayList();
  private final Map<String, zzamn> zzdtm = new HashMap();
  private String zzdtn;
  private JSONObject zzdto;
  private boolean zzdtp = false;

  public zzawm(String paramString, long paramLong)
  {
    this.zzdmm = paramString;
    this.zzdtj = paramLong;
    if (!TextUtils.isEmpty(paramString));
    while (true)
    {
      int j;
      JSONObject localJSONObject1;
      String str2;
      String str3;
      try
      {
        this.zzdto = new JSONObject(paramString);
        if (this.zzdto.optInt("status", -1) != 1)
        {
          this.zzdtp = false;
          zzaxa.zzep("App settings could not be fetched successfully.");
          return;
        }
        this.zzdtp = true;
        this.zzdtn = this.zzdto.optString("app_id");
        JSONArray localJSONArray1 = this.zzdto.optJSONArray("ad_unit_id_settings");
        if (localJSONArray1 == null)
          break label286;
        j = 0;
        if (j >= localJSONArray1.length())
          break label286;
        localJSONObject1 = localJSONArray1.getJSONObject(j);
        str2 = localJSONObject1.optString("format");
        str3 = localJSONObject1.optString("ad_unit_id");
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
          break label343;
        if ("interstitial".equalsIgnoreCase(str2))
          this.zzdtl.add(str3);
      }
      catch (JSONException localJSONException)
      {
        zzaxa.zzd("Exception occurred while processing app setting json", localJSONException);
        zzk.zzlk().zza(localJSONException, "AppSettings.parseAppSettingsJson");
        return;
      }
      if ("rewarded".equalsIgnoreCase(str2))
      {
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("mediation_config");
        if (localJSONObject2 != null)
        {
          zzamn localzzamn = new zzamn(localJSONObject2);
          this.zzdtm.put(str3, localzzamn);
          break label343;
          label286: JSONArray localJSONArray2 = this.zzdto.optJSONArray("persistable_banner_ad_unit_ids");
          int i = 0;
          if (localJSONArray2 != null)
            while (i < localJSONArray2.length())
            {
              String str1 = localJSONArray2.optString(i);
              this.zzdtk.add(str1);
              i++;
            }
          return;
        }
      }
      label343: j++;
    }
  }

  public final long zzuq()
  {
    return this.zzdtj;
  }

  public final boolean zzur()
  {
    return this.zzdtp;
  }

  public final String zzus()
  {
    return this.zzdmm;
  }

  public final String zzut()
  {
    return this.zzdtn;
  }

  public final Map<String, zzamn> zzuu()
  {
    return this.zzdtm;
  }

  public final JSONObject zzuv()
  {
    return this.zzdto;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawm
 * JD-Core Version:    0.6.2
 */