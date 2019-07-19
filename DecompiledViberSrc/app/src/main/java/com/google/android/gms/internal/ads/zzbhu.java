package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;

@zzare
@TargetApi(17)
public final class zzbhu<WebViewT extends zzbhy,  extends zzbig,  extends zzbii>
{
  private final zzbhx zzemf;
  private final WebViewT zzemg;

  private zzbhu(WebViewT paramWebViewT, zzbhx paramzzbhx)
  {
    this.zzemf = paramzzbhx;
    this.zzemg = paramWebViewT;
  }

  public static zzbhu<zzbha> zzc(zzbha paramzzbha)
  {
    return new zzbhu(paramzzbha, new zzbhv(paramzzbha));
  }

  @JavascriptInterface
  public final String getClickSignals(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      zzaxa.zzds("Click string is empty, not proceeding.");
      return "";
    }
    zzdh localzzdh = ((zzbig)this.zzemg).zzaal();
    if (localzzdh == null)
    {
      zzaxa.zzds("Signal utils is empty, ignoring.");
      return "";
    }
    zzdc localzzdc = localzzdh.zzcg();
    if (localzzdc == null)
    {
      zzaxa.zzds("Signals object is empty, ignoring.");
      return "";
    }
    if (this.zzemg.getContext() == null)
    {
      zzaxa.zzds("Context is null, ignoring.");
      return "";
    }
    return localzzdc.zza(this.zzemg.getContext(), paramString, ((zzbii)this.zzemg).getView(), this.zzemg.zzyd());
  }

  @JavascriptInterface
  public final void notify(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      zzaxa.zzep("URL is empty, ignoring message");
      return;
    }
    zzaxj.zzdvx.post(new zzbhw(this, paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbhu
 * JD-Core Version:    0.6.2
 */