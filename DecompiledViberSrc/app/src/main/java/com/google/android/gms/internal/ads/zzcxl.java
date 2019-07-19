package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzk;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcxl
{
  public final String zzatl;
  public final boolean zzbrn;
  public final String zzdel;
  public final String zzdew;
  public final String zzdex;
  public final List<String> zzdfg;
  public final List<String> zzdfh;
  public final String zzdfm;
  public final boolean zzdft;
  public final boolean zzdfu;
  public final boolean zzdfv;
  public final List<String> zzdnn;
  public final String zzdnq;
  public final String zzdnt;

  @Nullable
  public final zzatp zzdnz;
  public final List<String> zzdoa;
  public final List<String> zzdob;
  public final boolean zzdoj;
  public final boolean zzdom;
  public final boolean zzdon;
  public final boolean zzdpe;
  public final String zzemw;
  public final int zzflt;
  public final List<String> zzgjy;
  public final int zzgjz;
  public final List<String> zzgka;
  public final List<String> zzgkb;
  public final List<String> zzgkc;
  public final List<zzcxm> zzgkd;

  @Nullable
  public final zzcxp zzgke;
  public final List<String> zzgkf;
  public final List<zzcxm> zzgkg;
  public final JSONObject zzgkh;
  public final zzauz zzgki;
  public final JSONObject zzgkj;
  public final JSONObject zzgkk;
  public final boolean zzgkl;
  public final int zzgkm;
  public final int zzgkn;
  public final JSONObject zzgko;
  public final int zzgkp;

  zzcxl(JsonReader paramJsonReader)
    throws IllegalStateException, IOException, JSONException, NumberFormatException
  {
    List localList1 = Collections.emptyList();
    int i = 0;
    List localList2 = Collections.emptyList();
    List localList3 = Collections.emptyList();
    List localList4 = Collections.emptyList();
    int j = 0;
    List localList5 = Collections.emptyList();
    Collections.emptyList();
    List localList6 = Collections.emptyList();
    List localList7 = Collections.emptyList();
    String str1 = "";
    String str2 = "";
    zzatp localzzatp = null;
    List localList8 = Collections.emptyList();
    List localList9 = Collections.emptyList();
    List localList10 = Collections.emptyList();
    zzcxp localzzcxp = null;
    List localList11 = Collections.emptyList();
    List localList12 = Collections.emptyList();
    JSONObject localJSONObject1 = new JSONObject();
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    zzauz localzzauz = null;
    String str7 = "";
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    int k = -1;
    int m = 0;
    boolean bool7 = false;
    String str8 = "";
    JSONObject localJSONObject4 = new JSONObject();
    boolean bool8 = false;
    boolean bool9 = false;
    int n = 0;
    paramJsonReader.beginObject();
    label189: 
    while (paramJsonReader.hasNext())
    {
      String str9 = paramJsonReader.nextName();
      if (str9 == null)
        str9 = "";
      int i1;
      switch (str9.hashCode())
      {
      default:
        i1 = -1;
      case 1839650832:
      case -1152230954:
      case -776859333:
      case -437057161:
      case 230323073:
      case 791122864:
      case 1638957285:
      case 673261304:
      case 1688341040:
      case -1078050970:
      case 1010584092:
      case -982608540:
      case 1100650276:
      case -1115838944:
      case 2072888499:
      case 754887508:
      case 3107:
      case -1360811658:
      case -1306015996:
      case -1081936678:
      case 3076010:
      case 3355:
      case 107433883:
      case -1051269058:
      case -544216775:
      case 597473788:
      case -1980587809:
      case -1289032093:
      case -1234181075:
      case 1321720943:
      case -29338502:
      case 63195984:
      case -1440104884:
      case 418392395:
      case -1439500848:
      case -404326515:
      case -1428969291:
      case 1637553475:
      case -1965512151:
      case 1875425491:
      case -1146534047:
      case -1403779768:
      }
      while (true)
        switch (i1)
        {
        default:
          paramJsonReader.skipValue();
          break label189;
          if (!str9.equals("renderers"))
            break label564;
          i1 = 0;
          continue;
          if (!str9.equals("ad_type"))
            break label564;
          i1 = 1;
          continue;
          if (!str9.equals("click_urls"))
            break label564;
          i1 = 2;
          continue;
          if (!str9.equals("imp_urls"))
            break label564;
          i1 = 3;
          continue;
          if (!str9.equals("ad_load_urls"))
            break label564;
          i1 = 4;
          continue;
          if (!str9.equals("impression_type"))
            break label564;
          i1 = 5;
          continue;
          if (!str9.equals("video_start_urls"))
            break label564;
          i1 = 6;
          continue;
          if (!str9.equals("reward_granted_urls"))
            break label564;
          i1 = 7;
          continue;
          if (!str9.equals("video_reward_urls"))
            break label564;
          i1 = 8;
          continue;
          if (!str9.equals("video_complete_urls"))
            break label564;
          i1 = 9;
          continue;
          if (!str9.equals("transaction_id"))
            break label564;
          i1 = 10;
          continue;
          if (!str9.equals("valid_from_timestamp"))
            break label564;
          i1 = 11;
          continue;
          if (!str9.equals("rewards"))
            break label564;
          i1 = 12;
          continue;
          if (!str9.equals("fill_urls"))
            break label564;
          i1 = 13;
          continue;
          if (!str9.equals("manual_tracking_urls"))
            break label564;
          i1 = 14;
          continue;
          if (!str9.equals("container_sizes"))
            break label564;
          i1 = 15;
          continue;
          if (!str9.equals("ad"))
            break label564;
          i1 = 16;
          continue;
          if (!str9.equals("ad_sizes"))
            break label564;
          i1 = 17;
          continue;
          if (!str9.equals("adapters"))
            break label564;
          i1 = 18;
          continue;
          if (!str9.equals("allocation_id"))
            break label564;
          i1 = 19;
          continue;
          if (!str9.equals("data"))
            break label564;
          i1 = 20;
          continue;
          if (!str9.equals("id"))
            break label564;
          i1 = 21;
          continue;
          if (!str9.equals("qdata"))
            break label564;
          i1 = 22;
          continue;
          if (!str9.equals("active_view"))
            break label564;
          i1 = 23;
          continue;
          if (!str9.equals("safe_browsing"))
            break label564;
          i1 = 24;
          continue;
          if (!str9.equals("debug_dialog_string"))
            break label564;
          i1 = 25;
          continue;
          if (!str9.equals("debug_signals"))
            break label564;
          i1 = 26;
          continue;
          if (!str9.equals("extras"))
            break label564;
          i1 = 27;
          continue;
          if (!str9.equals("allow_pub_rendered_attribution"))
            break label564;
          i1 = 28;
          continue;
          if (!str9.equals("allow_pub_owned_ad_view"))
            break label564;
          i1 = 29;
          continue;
          if (!str9.equals("allow_custom_click_gesture"))
            break label564;
          i1 = 30;
          continue;
          if (!str9.equals("render_test_label"))
            break label564;
          i1 = 31;
          continue;
          if (!str9.equals("is_custom_close_blocked"))
            break label564;
          i1 = 32;
          continue;
          if (!str9.equals("is_closable_area_disabled"))
            break label564;
          i1 = 33;
          continue;
          if (!str9.equals("orientation"))
            break label564;
          i1 = 34;
          continue;
          if (!str9.equals("render_timeout_ms"))
            break label564;
          i1 = 35;
          continue;
          if (!str9.equals("enable_omid"))
            break label564;
          i1 = 36;
          continue;
          if (!str9.equals("bid_response"))
            break label564;
          i1 = 37;
          continue;
          if (!str9.equals("omid_settings"))
            break label564;
          i1 = 38;
          continue;
          if (!str9.equals("is_analytics_logging_enabled"))
            break label564;
          i1 = 39;
          continue;
          if (!str9.equals("is_scroll_aware"))
            break label564;
          i1 = 40;
          continue;
          if (!str9.equals("showable_impression_type"))
            break label564;
          i1 = 41;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
        case 19:
        case 20:
        case 21:
        case 22:
        case 23:
        case 24:
        case 25:
        case 26:
        case 27:
        case 28:
        case 29:
        case 30:
        case 31:
        case 32:
        case 33:
        case 34:
        case 35:
        case 36:
        case 37:
        case 38:
        case 39:
        case 40:
        case 41:
        }
      localList1 = zzazd.zza(paramJsonReader);
      continue;
      String str11 = paramJsonReader.nextString();
      if ("banner".equals(str11))
      {
        i = 1;
      }
      else if ("interstitial".equals(str11))
      {
        i = 2;
      }
      else if ("native_express".equals(str11))
      {
        i = 3;
      }
      else if ("native".equals(str11))
      {
        i = 4;
      }
      else if ("rewarded".equals(str11))
      {
        i = 5;
      }
      else
      {
        i = 0;
        continue;
        localList2 = zzazd.zza(paramJsonReader);
        continue;
        localList3 = zzazd.zza(paramJsonReader);
        continue;
        localList4 = zzazd.zza(paramJsonReader);
        continue;
        j = paramJsonReader.nextInt();
        if ((j != 0) && (j != 1))
        {
          j = 0;
          continue;
          localList5 = zzazd.zza(paramJsonReader);
          continue;
          zzazd.zza(paramJsonReader);
          continue;
          localList6 = zzazd.zza(paramJsonReader);
          continue;
          localList7 = zzazd.zza(paramJsonReader);
          continue;
          str1 = paramJsonReader.nextString();
          continue;
          str2 = paramJsonReader.nextString();
          continue;
          localzzatp = zzatp.zza(zzazd.zzd(paramJsonReader));
          continue;
          localList8 = zzazd.zza(paramJsonReader);
          continue;
          localList9 = zzazd.zza(paramJsonReader);
          continue;
          localList10 = zzcxm.zze(paramJsonReader);
          continue;
          localzzcxp = new zzcxp(paramJsonReader);
          continue;
          localList12 = zzcxm.zze(paramJsonReader);
          continue;
          localList11 = zzazd.zza(paramJsonReader);
          continue;
          str3 = paramJsonReader.nextString();
          continue;
          localJSONObject1 = zzazd.zzc(paramJsonReader);
          continue;
          str4 = paramJsonReader.nextString();
          continue;
          str5 = paramJsonReader.nextString();
          continue;
          str6 = zzazd.zzc(paramJsonReader).toString();
          continue;
          localzzauz = zzauz.zzg(zzazd.zzc(paramJsonReader));
          continue;
          str7 = paramJsonReader.nextString();
          continue;
          localJSONObject2 = zzazd.zzc(paramJsonReader);
          continue;
          localJSONObject3 = zzazd.zzc(paramJsonReader);
          continue;
          bool1 = paramJsonReader.nextBoolean();
          continue;
          bool2 = paramJsonReader.nextBoolean();
          continue;
          bool3 = paramJsonReader.nextBoolean();
          continue;
          bool4 = paramJsonReader.nextBoolean();
          continue;
          bool5 = paramJsonReader.nextBoolean();
          continue;
          bool6 = paramJsonReader.nextBoolean();
          continue;
          String str10 = paramJsonReader.nextString();
          if ("landscape".equalsIgnoreCase(str10))
          {
            zzk.zzli();
            k = 6;
          }
          else if ("portrait".equalsIgnoreCase(str10))
          {
            zzk.zzli();
            k = 7;
          }
          else
          {
            k = -1;
            continue;
            m = paramJsonReader.nextInt();
            continue;
            bool7 = paramJsonReader.nextBoolean();
            continue;
            str8 = paramJsonReader.nextString();
            continue;
            localJSONObject4 = zzazd.zzc(paramJsonReader);
            continue;
            bool8 = paramJsonReader.nextBoolean();
            continue;
            bool9 = paramJsonReader.nextBoolean();
            continue;
            n = paramJsonReader.nextInt();
          }
        }
      }
    }
    label564: paramJsonReader.endObject();
    this.zzgjy = localList1;
    this.zzflt = i;
    this.zzdfg = localList2;
    this.zzdfh = localList3;
    this.zzgka = localList4;
    this.zzgjz = j;
    this.zzdoa = localList5;
    this.zzdob = localList6;
    this.zzgkb = localList7;
    this.zzdew = str1;
    this.zzdex = str2;
    this.zzdnz = localzzatp;
    this.zzgkc = localList8;
    this.zzdnn = localList9;
    this.zzgkd = localList10;
    this.zzgke = localzzcxp;
    this.zzgkf = localList11;
    this.zzgkg = localList12;
    this.zzdel = str3;
    this.zzgkh = localJSONObject1;
    this.zzatl = str4;
    this.zzdfm = str5;
    this.zzdnt = str6;
    this.zzgki = localzzauz;
    this.zzdnq = str7;
    this.zzgkj = localJSONObject2;
    this.zzgkk = localJSONObject3;
    this.zzdft = bool1;
    this.zzdfu = bool2;
    this.zzdfv = bool3;
    this.zzdpe = bool4;
    this.zzgkl = bool5;
    this.zzbrn = bool6;
    this.zzgkm = k;
    this.zzgkn = m;
    this.zzdoj = bool7;
    this.zzemw = str8;
    this.zzgko = localJSONObject4;
    this.zzdom = bool8;
    this.zzdon = bool9;
    this.zzgkp = n;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxl
 * JD-Core Version:    0.6.2
 */