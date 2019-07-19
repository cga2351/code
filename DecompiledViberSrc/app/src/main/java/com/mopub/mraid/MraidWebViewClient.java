package com.mopub.mraid;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.resource.MraidJavascript;
import java.io.ByteArrayInputStream;
import java.util.Locale;

public class MraidWebViewClient extends WebViewClient
{
  private static final String a = "javascript:" + MraidJavascript.JAVASCRIPT_SOURCE;

  private WebResourceResponse a()
  {
    return new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(a.getBytes()));
  }

  boolean a(String paramString)
  {
    return "mraid.js".equals(Uri.parse(paramString.toLowerCase(Locale.US)).getLastPathSegment());
  }

  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (a(paramString))
      return a();
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.MraidWebViewClient
 * JD-Core Version:    0.6.2
 */