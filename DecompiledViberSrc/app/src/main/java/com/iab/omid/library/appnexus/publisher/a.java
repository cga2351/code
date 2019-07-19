package com.iab.omid.library.appnexus.publisher;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class a extends AdSessionStatePublisher
{
  @SuppressLint({"SetJavaScriptEnabled"})
  public a(WebView paramWebView)
  {
    if ((paramWebView != null) && (!paramWebView.getSettings().getJavaScriptEnabled()))
      paramWebView.getSettings().setJavaScriptEnabled(true);
    a(paramWebView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.publisher.a
 * JD-Core Version:    0.6.2
 */