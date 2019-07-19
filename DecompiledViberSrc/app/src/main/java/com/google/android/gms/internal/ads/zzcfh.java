package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class zzcfh
{
  private Map<String, String> zzcxs = new LinkedHashMap();

  public zzcfh(Context paramContext, String paramString)
  {
    Map localMap = this.zzcxs;
    localMap.put("s", "gmob_sdk");
    localMap.put("v", "3");
    localMap.put("os", Build.VERSION.RELEASE);
    localMap.put("sdk", Build.VERSION.SDK);
    zzk.zzlg();
    localMap.put("device", zzaxj.zzwc());
    localMap.put("app", paramString);
    zzk.zzlg();
    if (zzaxj.zzau(paramContext));
    for (String str = "1"; ; str = "0")
    {
      localMap.put("is_lite_sdk", str);
      localMap.put("e", TextUtils.join(",", zzact.zzqo()));
      return;
    }
  }

  public final void zzb(zzcxt paramzzcxt)
  {
    if (paramzzcxt.zzgky.zzgkt.size() > 0)
      switch (((zzcxl)paramzzcxt.zzgky.zzgkt.get(0)).zzflt)
      {
      default:
        this.zzcxs.put("ad_format", "unknown");
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    while (true)
    {
      if (!TextUtils.isEmpty(paramzzcxt.zzgky.zzgku.zzceq))
        this.zzcxs.put("gqi", paramzzcxt.zzgky.zzgku.zzceq);
      return;
      this.zzcxs.put("ad_format", "banner");
      continue;
      this.zzcxs.put("ad_format", "interstitial");
      continue;
      this.zzcxs.put("ad_format", "native_express");
      continue;
      this.zzcxs.put("ad_format", "native_advanced");
      continue;
      this.zzcxs.put("ad_format", "rewarded");
    }
  }

  public final void zzi(Bundle paramBundle)
  {
    if (paramBundle.containsKey("cnt"))
      this.zzcxs.put("network_coarse", Integer.toString(paramBundle.getInt("cnt")));
    if (paramBundle.containsKey("gnt"))
      this.zzcxs.put("network_fine", Integer.toString(paramBundle.getInt("gnt")));
  }

  public final Map<String, String> zzqy()
  {
    return this.zzcxs;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcfh
 * JD-Core Version:    0.6.2
 */