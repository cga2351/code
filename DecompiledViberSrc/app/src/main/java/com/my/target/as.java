package com.my.target;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class as extends WebView
{
  private final WebViewClient a = new c(null);
  private final WebChromeClient b = new b(null);
  private JSONObject c;
  private a d;
  private boolean e;
  private boolean f;

  public as(Context paramContext)
  {
    this(paramContext, null);
  }

  public as(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  public as(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    final d locald = new d(getContext(), this);
    locald.a(new as.d.a()
    {
      public void a()
      {
        as.a(as.this, true);
      }
    });
    setOnTouchListener(new View.OnTouchListener()
    {
      @SuppressLint({"ClickableViewAccessibility"})
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        locald.a(paramAnonymousMotionEvent);
        return false;
      }
    });
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setSupportZoom(false);
    localWebSettings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
    localWebSettings.setAllowFileAccess(false);
    localWebSettings.setAllowContentAccess(false);
    if (Build.VERSION.SDK_INT >= 16)
    {
      localWebSettings.setAllowFileAccessFromFileURLs(false);
      localWebSettings.setAllowUniversalAccessFromFileURLs(false);
    }
    setWebChromeClient(this.b);
    setWebViewClient(this.a);
  }

  private void a()
  {
    this.f = false;
  }

  private void a(String paramString)
  {
    if (this.d != null)
      this.d.b(paramString);
  }

  public void a(du paramdu)
  {
    String str = "javascript:AdmanJS.execute(" + paramdu.a().toString() + ")";
    dp.a(str);
    loadUrl(str);
  }

  public void a(JSONObject paramJSONObject, String paramString)
  {
    this.e = false;
    this.f = false;
    loadDataWithBaseURL("https://ad.mail.ru/", paramString, "text/html", "UTF-8", null);
    this.c = paramJSONObject;
  }

  public void setBannerWebViewListener(a parama)
  {
    this.d = parama;
  }

  public static abstract interface a
  {
    public abstract void a(ec paramec);

    public abstract void a(String paramString);

    public abstract void b(String paramString);
  }

  private class b extends WebChromeClient
  {
    private b()
    {
    }

    public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      String str = paramConsoleMessage.message();
      int i = paramConsoleMessage.lineNumber();
      dp.a("js console message: " + str + " at line: " + i);
      ec localec = dr.a(paramConsoleMessage);
      if (localec != null)
      {
        if (as.a(as.this) != null)
          as.a(as.this).a(localec);
        return true;
      }
      return false;
    }
  }

  private class c extends WebViewClient
  {
    private c()
    {
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if (!as.d(as.this))
      {
        as.b(as.this, true);
        dp.a("page loaded");
        super.onPageFinished(paramWebView, paramString);
        if (as.e(as.this) == null);
      }
      try
      {
        as.this.a(new dv(as.e(as.this)));
        return;
      }
      catch (JSONException localJSONException)
      {
        dp.a("js call executing error " + localJSONException.getMessage());
      }
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      dp.a("load page started");
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      dp.a("load failed. error: " + paramInt + " description: " + paramString1 + " url: " + paramString2);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      as.a locala;
      if (as.a(as.this) != null)
      {
        locala = as.a(as.this);
        if (paramString1 == null)
          break label82;
      }
      while (true)
      {
        locala.a(paramString1);
        return;
        label82: paramString1 = "unknown JS error";
      }
    }

    @TargetApi(23)
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
      CharSequence localCharSequence = paramWebResourceError.getDescription();
      String str1 = null;
      if (localCharSequence != null)
        str1 = localCharSequence.toString();
      int i = paramWebResourceError.getErrorCode();
      String str2 = paramWebResourceRequest.getUrl().toString();
      dp.a("load failed. error: " + i + " description: " + str1 + " url: " + str2);
      as.a locala;
      if (as.a(as.this) != null)
      {
        locala = as.a(as.this);
        if (str1 == null)
          break label124;
      }
      while (true)
      {
        locala.a(str1);
        return;
        label124: str1 = "Unknown JS error";
      }
    }

    public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
    {
      super.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
      dp.a("scale new: " + paramFloat2 + " old: " + paramFloat1);
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      if (as.b(as.this))
      {
        Uri localUri = paramWebResourceRequest.getUrl();
        if (localUri != null)
        {
          String str = localUri.toString();
          if ((str != null) && (!str.startsWith("adman://onEvent,")))
          {
            as.a(as.this, str);
            as.c(as.this);
          }
        }
      }
      return true;
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if ((as.b(as.this)) && (paramString != null) && (!paramString.startsWith("adman://onEvent,")))
      {
        as.a(as.this, paramString);
        as.c(as.this);
      }
      return true;
    }
  }

  private static class d extends GestureDetector
  {
    private final View a;
    private a b;

    d(Context paramContext, View paramView)
    {
      this(paramContext, paramView, new GestureDetector.SimpleOnGestureListener());
    }

    private d(Context paramContext, View paramView, GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
    {
      super(paramSimpleOnGestureListener);
      this.a = paramView;
      setIsLongpressEnabled(false);
    }

    private boolean a(MotionEvent paramMotionEvent, View paramView)
    {
      if ((paramMotionEvent == null) || (paramView == null));
      float f1;
      float f2;
      do
      {
        return false;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
      }
      while ((f1 < 0.0F) || (f1 > paramView.getWidth()) || (f2 < 0.0F) || (f2 > paramView.getHeight()));
      return true;
    }

    void a(MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      default:
      case 1:
      case 0:
      case 2:
      }
      do
      {
        return;
        if (this.b != null)
        {
          dp.a("Gestures: user clicked");
          this.b.a();
          return;
        }
        dp.a("View's onUserClick() is not registered.");
        return;
        onTouchEvent(paramMotionEvent);
        return;
      }
      while (!a(paramMotionEvent, this.a));
      onTouchEvent(paramMotionEvent);
    }

    void a(a parama)
    {
      this.b = parama;
    }

    static abstract interface a
    {
      public abstract void a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.as
 * JD-Core Version:    0.6.2
 */