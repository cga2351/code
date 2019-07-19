package com.yandex.mobile.ads.impl;

import android.webkit.WebView;
import com.yandex.mobile.ads.AdRequestError;
import java.util.Map;

public abstract interface dn
{
  public abstract void a(WebView paramWebView, Map<String, String> paramMap);

  public abstract void a(String paramString);

  public abstract void b(boolean paramBoolean);

  public abstract void onAdFailedToLoad(AdRequestError paramAdRequestError);

  public abstract void onAdLoaded();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dn
 * JD-Core Version:    0.6.2
 */