package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzbos
  implements zzbrv, zzbsq
{
  private final zzbaj zzbtd;
  private final zzbha zzdbu;
  private final zzcxl zzfif;

  @GuardedBy("this")
  private IObjectWrapper zzfig;

  @GuardedBy("this")
  private boolean zzfih;
  private final Context zzlj;

  public zzbos(Context paramContext, zzbha paramzzbha, zzcxl paramzzcxl, zzbaj paramzzbaj)
  {
    this.zzlj = paramContext;
    this.zzdbu = paramzzbha;
    this.zzfif = paramzzcxl;
    this.zzbtd = paramzzbaj;
  }

  private final void zzafv()
  {
    while (true)
    {
      try
      {
        boolean bool = this.zzfif.zzdoj;
        if (!bool)
          return;
        if ((this.zzdbu == null) || (!zzk.zzlv().zzl(this.zzlj)))
          continue;
        int i = this.zzbtd.zzdze;
        int j = this.zzbtd.zzdzf;
        String str1 = 23 + i + "." + j;
        if (this.zzfif.zzgko.optInt("media_type", -1) == 0)
        {
          str2 = null;
          this.zzfig = zzk.zzlv().zza(str1, this.zzdbu.getWebView(), "", "javascript", str2);
          View localView = this.zzdbu.getView();
          if ((this.zzfig == null) || (localView == null))
            continue;
          zzk.zzlv().zza(this.zzfig, localView);
          this.zzdbu.zzam(this.zzfig);
          zzk.zzlv().zzaa(this.zzfig);
          this.zzfih = true;
          continue;
        }
      }
      finally
      {
      }
      String str2 = "javascript";
    }
  }

  public final void onAdImpression()
  {
    try
    {
      if (!this.zzfih)
        zzafv();
      if ((this.zzfif.zzdoj) && (this.zzfig != null) && (this.zzdbu != null))
        this.zzdbu.zza("onSdkImpression", new ArrayMap());
      return;
    }
    finally
    {
    }
  }

  public final void onAdLoaded()
  {
    try
    {
      boolean bool = this.zzfih;
      if (bool);
      while (true)
      {
        return;
        zzafv();
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbos
 * JD-Core Version:    0.6.2
 */