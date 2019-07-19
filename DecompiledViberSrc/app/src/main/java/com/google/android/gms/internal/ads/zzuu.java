package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

final class zzuu
  implements Runnable
{
  private ValueCallback<String> zzbvo = new zzuv(this);

  zzuu(zzus paramzzus, zzum paramzzum, WebView paramWebView, boolean paramBoolean)
  {
  }

  public final void run()
  {
    if (this.zzbvq.getSettings().getJavaScriptEnabled());
    try
    {
      this.zzbvq.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbvo);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.zzbvo.onReceiveValue("");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzuu
 * JD-Core Version:    0.6.2
 */