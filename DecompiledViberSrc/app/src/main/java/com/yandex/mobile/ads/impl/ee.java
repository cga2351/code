package com.yandex.mobile.ads.impl;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.util.Locale;

final class ee extends dl
{
  private String a;

  ee(dm paramdm)
  {
    super(paramdm);
  }

  private static boolean a(Uri paramUri)
  {
    return "mraid.js".equals(paramUri.getLastPathSegment());
  }

  private static WebResourceResponse b(String paramString)
  {
    return new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(paramString.getBytes()));
  }

  final void a(String paramString)
  {
    this.a = paramString;
  }

  @TargetApi(21)
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (!TextUtils.isEmpty(this.a))
    {
      Uri localUri = paramWebResourceRequest.getUrl();
      if ((localUri != null) && (a(localUri)))
        return b(this.a);
    }
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }

  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 21) && (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.a)) && (a(Uri.parse(paramString.toLowerCase(Locale.US)))))
      return b(this.a);
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ee
 * JD-Core Version:    0.6.2
 */