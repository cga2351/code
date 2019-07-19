package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@zzare
@TargetApi(11)
public final class zzbia extends zzbib
{
  public zzbia(zzbha paramzzbha, zzwh paramzzwh, boolean paramBoolean)
  {
    super(paramzzbha, paramzzwh, paramBoolean);
  }

  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return zza(paramWebView, paramString, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbia
 * JD-Core Version:    0.6.2
 */