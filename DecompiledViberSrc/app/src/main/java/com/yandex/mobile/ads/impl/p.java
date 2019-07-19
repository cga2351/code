package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;

final class p extends z
{
  public p(Context paramContext)
  {
    super(paramContext);
    a_(paramContext);
  }

  static c a(WeakReference<Context> paramWeakReference)
  {
    if ((paramWeakReference.get() instanceof c))
      return (c)paramWeakReference.get();
    return null;
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  protected final void a_(Context paramContext)
  {
    super.a_(paramContext);
    setBackgroundColor(-1);
    setInitialScale(1);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    b_();
    setScrollbarFadingEnabled(true);
    setDrawingCacheEnabled(true);
    setWebChromeClient(new a(paramContext));
    setWebViewClient(new b(paramContext));
  }

  final class a extends WebChromeClient
  {
    private final WeakReference<Context> b;

    a(Context arg2)
    {
      Object localObject;
      this.b = new WeakReference(localObject);
    }

    public final void onProgressChanged(WebView paramWebView, int paramInt)
    {
      p.c localc = p.a(this.b);
      if (localc != null)
        localc.a(paramWebView, paramInt);
    }
  }

  final class b extends WebViewClient
  {
    private final WeakReference<Context> b;

    b(Context arg2)
    {
      Object localObject;
      this.b = new WeakReference(localObject);
    }

    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      p.c localc = p.a(this.b);
      if (localc != null)
        localc.i();
    }

    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      p.c localc = p.a(this.b);
      if (localc != null)
        localc.h();
    }

    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      boolean bool1 = TextUtils.isEmpty(paramString);
      boolean bool2 = false;
      if (!bool1)
        if (!df.b(paramString))
        {
          boolean bool3 = df.c(paramString);
          bool2 = false;
          if (bool3);
        }
        else
        {
          bool2 = df.a(paramWebView.getContext(), paramString, false);
        }
      return bool2;
    }
  }

  static abstract interface c
  {
    public abstract void a(WebView paramWebView, int paramInt);

    public abstract void h();

    public abstract void i();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.p
 * JD-Core Version:    0.6.2
 */