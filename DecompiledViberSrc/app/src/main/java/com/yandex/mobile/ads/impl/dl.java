package com.yandex.mobile.ads.impl;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class dl extends WebViewClient
{
  private final dm a;

  public dl(dm paramdm)
  {
    this.a = paramdm;
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.a.d();
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = paramString1;
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    this.a.a(paramWebView.getContext(), paramString);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dl
 * JD-Core Version:    0.6.2
 */