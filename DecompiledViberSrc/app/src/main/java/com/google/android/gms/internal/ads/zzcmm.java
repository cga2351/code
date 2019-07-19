package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public abstract class zzcmm<AdT>
  implements zzcju<AdT>
{
  private static Bundle zzm(Bundle paramBundle)
  {
    if (paramBundle == null)
      return new Bundle();
    return new Bundle(paramBundle);
  }

  protected abstract zzbbi<AdT> zza(zzcxu paramzzcxu, Bundle paramBundle);

  public final boolean zza(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return !TextUtils.isEmpty(paramzzcxl.zzgkh.optString("pubid", ""));
  }

  public final zzbbi<AdT> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    String str1 = paramzzcxl.zzgkh.optString("pubid", "");
    zzcxu localzzcxu1 = paramzzcxt.zzgkx.zzfjp;
    zzcxw localzzcxw = new zzcxw().zzg(localzzcxu1.zzghg).zzd(localzzcxu1.zzdln).zzd(localzzcxu1.zzgkz).zzft(localzzcxu1.zzglb).zzc(localzzcxu1.zzgla).zzb(localzzcxu1.zzglc).zzc(localzzcxu1.zzgld).zzb(localzzcxu1.zzdgu).zzfu(localzzcxu1.zzgle).zzb(localzzcxu1.zzglh).zzfv(localzzcxu1.zzglf).zzft(str1);
    Bundle localBundle1 = zzm(localzzcxu1.zzghg.zzcgw);
    Bundle localBundle2 = zzm(localBundle1.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
    localBundle2.putInt("gw", 1);
    String str2 = paramzzcxl.zzgkh.optString("mad_hac", null);
    if (str2 != null)
      localBundle2.putString("mad_hac", str2);
    String str3 = paramzzcxl.zzgkh.optString("adJson", null);
    if (str3 != null)
      localBundle2.putString("_ad", str3);
    localBundle2.putBoolean("_noRefresh", true);
    Iterator localIterator = paramzzcxl.zzgkk.keys();
    while (localIterator.hasNext())
    {
      String str5 = (String)localIterator.next();
      String str6 = paramzzcxl.zzgkk.optString(str5, null);
      if (str5 != null)
        localBundle2.putString(str5, str6);
    }
    localBundle1.putBundle("com.google.ads.mediation.admob.AdMobAdapter", localBundle2);
    zzcxu localzzcxu2 = localzzcxw.zzg(new zzxx(localzzcxu1.zzghg.versionCode, localzzcxu1.zzghg.zzcgo, localBundle2, localzzcxu1.zzghg.zzcgp, localzzcxu1.zzghg.zzcgq, localzzcxu1.zzghg.zzcgr, localzzcxu1.zzghg.zzcgs, localzzcxu1.zzghg.zzbqn, localzzcxu1.zzghg.zzcgt, localzzcxu1.zzghg.zzcgu, localzzcxu1.zzghg.zzmw, localzzcxu1.zzghg.zzcgv, localBundle1, localzzcxu1.zzghg.zzcgx, localzzcxu1.zzghg.zzcgy, localzzcxu1.zzghg.zzcgz, localzzcxu1.zzghg.zzcha, localzzcxu1.zzghg.zzchb, localzzcxu1.zzghg.zzchc, localzzcxu1.zzghg.zzchd, localzzcxu1.zzghg.zzche)).zzamq();
    Bundle localBundle3 = new Bundle();
    zzcxn localzzcxn = paramzzcxt.zzgky.zzgku;
    Bundle localBundle4 = new Bundle();
    localBundle4.putStringArrayList("nofill_urls", new ArrayList(localzzcxn.zzdfj));
    localBundle4.putInt("refresh_interval", localzzcxn.zzgkr);
    localBundle4.putString("gws_query_id", localzzcxn.zzceq);
    localBundle3.putBundle("parent_common_config", localBundle4);
    String str4 = paramzzcxt.zzgkx.zzfjp.zzglb;
    Bundle localBundle5 = new Bundle();
    localBundle5.putString("initial_ad_unit_id", str4);
    localBundle5.putString("allocation_id", paramzzcxl.zzdel);
    localBundle5.putStringArrayList("click_urls", new ArrayList(paramzzcxl.zzdfg));
    localBundle5.putStringArrayList("imp_urls", new ArrayList(paramzzcxl.zzdfh));
    localBundle5.putStringArrayList("manual_tracking_urls", new ArrayList(paramzzcxl.zzdnn));
    localBundle5.putStringArrayList("fill_urls", new ArrayList(paramzzcxl.zzgkc));
    localBundle5.putStringArrayList("video_start_urls", new ArrayList(paramzzcxl.zzdoa));
    localBundle5.putStringArrayList("video_reward_urls", new ArrayList(paramzzcxl.zzdob));
    localBundle5.putStringArrayList("video_complete_urls", new ArrayList(paramzzcxl.zzgkb));
    localBundle5.putString("transaction_id", paramzzcxl.zzdew);
    localBundle5.putString("valid_from_timestamp", paramzzcxl.zzdex);
    localBundle5.putBoolean("is_closable_area_disabled", paramzzcxl.zzbrn);
    if (paramzzcxl.zzdnz != null)
    {
      Bundle localBundle6 = new Bundle();
      localBundle6.putInt("rb_amount", paramzzcxl.zzdnz.zzdqo);
      localBundle6.putString("rb_type", paramzzcxl.zzdnz.type);
      localBundle5.putParcelableArray("rewards", new Bundle[] { localBundle6 });
    }
    localBundle3.putBundle("parent_ad_config", localBundle5);
    return zza(localzzcxu2, localBundle3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcmm
 * JD-Core Version:    0.6.2
 */