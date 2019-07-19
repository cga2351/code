package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzamn
{
  private final long zzdfe;
  public final List<zzamm> zzdff;
  private final List<String> zzdfg;
  private final List<String> zzdfh;
  private final List<String> zzdfi;
  private final List<String> zzdfj;
  private final List<String> zzdfk;
  private final boolean zzdfl;
  private final String zzdfm;
  private final long zzdfn;
  private final String zzdfo;
  private final int zzdfp;
  private final int zzdfq;
  private final long zzdfr;
  private final boolean zzdfs;
  private final boolean zzdft;
  private final boolean zzdfu;
  private final boolean zzdfv;
  private int zzdfw;
  private int zzdfx;
  private boolean zzdfy;

  public zzamn(JSONObject paramJSONObject)
    throws JSONException
  {
    String str2;
    if (zzaxa.isLoggable(2))
    {
      String str1 = String.valueOf(paramJSONObject.toString(2));
      if (str1.length() == 0)
        break label182;
      str2 = "Mediation Response JSON: ".concat(str1);
    }
    while (true)
    {
      zzaxa.zzds(str2);
      JSONArray localJSONArray = paramJSONObject.getJSONArray("ad_networks");
      ArrayList localArrayList = new ArrayList(localJSONArray.length());
      int i = 0;
      int j = -1;
      label68: if (i < localJSONArray.length());
      try
      {
        zzamm localzzamm = new zzamm(localJSONArray.getJSONObject(i));
        if ("banner".equalsIgnoreCase(localzzamm.zzdfd))
          this.zzdfy = true;
        localArrayList.add(localzzamm);
        if (j < 0)
        {
          Iterator localIterator = localzzamm.zzdek.iterator();
          do
            if (!localIterator.hasNext())
              break;
          while (!((String)localIterator.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"));
        }
        for (int k = 1; ; k = 0)
        {
          if (k != 0)
            j = i;
          label176: i++;
          break label68;
          label182: str2 = new String("Mediation Response JSON: ");
          break;
        }
        this.zzdfw = j;
        this.zzdfx = localJSONArray.length();
        this.zzdff = Collections.unmodifiableList(localArrayList);
        this.zzdfm = paramJSONObject.optString("qdata");
        this.zzdfq = paramJSONObject.optInt("fs_model_type", -1);
        this.zzdfr = paramJSONObject.optLong("timeout_ms", -1L);
        JSONObject localJSONObject = paramJSONObject.optJSONObject("settings");
        if (localJSONObject != null)
        {
          this.zzdfe = localJSONObject.optLong("ad_network_timeout_millis", -1L);
          zzk.zzly();
          this.zzdfg = zzamo.zza(localJSONObject, "click_urls");
          zzk.zzly();
          this.zzdfh = zzamo.zza(localJSONObject, "imp_urls");
          zzk.zzly();
          this.zzdfi = zzamo.zza(localJSONObject, "downloaded_imp_urls");
          zzk.zzly();
          this.zzdfj = zzamo.zza(localJSONObject, "nofill_urls");
          zzk.zzly();
          this.zzdfk = zzamo.zza(localJSONObject, "remote_ping_urls");
          this.zzdfl = localJSONObject.optBoolean("render_in_browser", false);
          long l1 = localJSONObject.optLong("refresh", -1L);
          long l2;
          zzatp localzzatp;
          if (l1 > 0L)
          {
            l2 = l1 * 1000L;
            this.zzdfn = l2;
            localzzatp = zzatp.zza(localJSONObject.optJSONArray("rewards"));
            if (localzzatp != null)
              break label490;
            this.zzdfo = null;
          }
          for (this.zzdfp = 0; ; this.zzdfp = localzzatp.zzdqo)
          {
            this.zzdfs = localJSONObject.optBoolean("use_displayed_impression", false);
            this.zzdft = localJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.zzdfu = localJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.zzdfv = localJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
            l2 = -1L;
            break;
            label490: this.zzdfo = localzzatp.type;
          }
        }
        this.zzdfe = -1L;
        this.zzdfg = null;
        this.zzdfh = null;
        this.zzdfi = null;
        this.zzdfj = null;
        this.zzdfk = null;
        this.zzdfn = -1L;
        this.zzdfo = null;
        this.zzdfp = 0;
        this.zzdfs = false;
        this.zzdfl = false;
        this.zzdft = false;
        this.zzdfu = false;
        this.zzdfv = false;
        return;
      }
      catch (JSONException localJSONException)
      {
        break label176;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamn
 * JD-Core Version:    0.6.2
 */