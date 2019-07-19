package com.yandex.mobile.ads.impl;

import android.webkit.WebView;
import com.yandex.mobile.ads.AdRequestError;
import java.util.Map;

public final class gn
  implements dn
{
  private final ea a;
  private final dn b;

  gn(ea paramea, dn paramdn)
  {
    this.a = paramea;
    this.b = paramdn;
  }

  public final void a(WebView paramWebView, Map<String, String> paramMap)
  {
    this.b.a(paramWebView, paramMap);
  }

  public final void a(String paramString)
  {
    this.a.b(paramString);
  }

  public final void b(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }

  public final void onAdFailedToLoad(AdRequestError paramAdRequestError)
  {
    this.b.onAdFailedToLoad(paramAdRequestError);
  }

  public final void onAdLoaded()
  {
    this.a.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.gn
 * JD-Core Version:    0.6.2
 */