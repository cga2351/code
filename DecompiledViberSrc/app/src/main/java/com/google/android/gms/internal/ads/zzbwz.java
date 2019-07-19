package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import org.json.JSONObject;

public final class zzbwz
  implements zzo, zzbsq
{
  private final zzbaj zzbtd;
  private final zzbha zzdbu;
  private final zzcxl zzfif;

  @VisibleForTesting
  private IObjectWrapper zzfig;
  private final int zzflt;
  private final Context zzlj;

  public zzbwz(Context paramContext, zzbha paramzzbha, zzcxl paramzzcxl, zzbaj paramzzbaj, int paramInt)
  {
    this.zzlj = paramContext;
    this.zzdbu = paramzzbha;
    this.zzfif = paramzzcxl;
    this.zzbtd = paramzzbaj;
    this.zzflt = paramInt;
  }

  public final void onAdLoaded()
  {
    String str1;
    if (((this.zzflt == 7) || (this.zzflt == 3)) && (this.zzfif.zzdoj) && (this.zzdbu != null) && (zzk.zzlv().zzl(this.zzlj)))
    {
      int i = this.zzbtd.zzdze;
      int j = this.zzbtd.zzdzf;
      str1 = 23 + i + "." + j;
      if (this.zzfif.zzgko.optInt("media_type", -1) != 0)
        break label196;
    }
    label196: for (String str2 = null; ; str2 = "javascript")
    {
      this.zzfig = zzk.zzlv().zza(str1, this.zzdbu.getWebView(), "", "javascript", str2);
      if ((this.zzfig != null) && (this.zzdbu.getView() != null))
      {
        zzk.zzlv().zza(this.zzfig, this.zzdbu.getView());
        this.zzdbu.zzam(this.zzfig);
        zzk.zzlv().zzaa(this.zzfig);
      }
      return;
    }
  }

  public final void onPause()
  {
  }

  public final void onResume()
  {
  }

  public final void zzsz()
  {
    this.zzfig = null;
  }

  public final void zzta()
  {
    if ((this.zzfig != null) && (this.zzdbu != null))
      this.zzdbu.zza("onSdkImpression", new HashMap());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbwz
 * JD-Core Version:    0.6.2
 */