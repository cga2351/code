package com.mopub.common.privacy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.CloseableLayout;
import com.mopub.common.CloseableLayout.OnCloseListener;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.mobileads.MoPubErrorCode;
import java.io.File;

class a extends CloseableLayout
{
  static int a = 101;
  private final WebView b = c();
  private b c;
  private a d;
  private final WebViewClient e = new WebViewClient()
  {
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      if (a.b(a.this) != null)
        a.b(a.this).onLoadProgress(a.a);
      super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
    }

    public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
      if (a.b(a.this) != null)
        a.b(a.this).onLoadProgress(0);
    }

    public boolean onRenderProcessGone(WebView paramAnonymousWebView, RenderProcessGoneDetail paramAnonymousRenderProcessGoneDetail)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      if ((paramAnonymousRenderProcessGoneDetail != null) && (paramAnonymousRenderProcessGoneDetail.didCrash()));
      for (MoPubErrorCode localMoPubErrorCode = MoPubErrorCode.RENDER_PROCESS_GONE_WITH_CRASH; ; localMoPubErrorCode = MoPubErrorCode.RENDER_PROCESS_GONE_UNSPECIFIED)
      {
        arrayOfObject[0] = localMoPubErrorCode;
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
        return true;
      }
    }

    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      if ("mopub://consent?yes".equals(paramAnonymousString))
        if (a.a(a.this) != null)
          a.a(a.this).onConsentClick(ConsentStatus.EXPLICIT_YES);
      do
      {
        do
        {
          return true;
          if (!"mopub://consent?no".equals(paramAnonymousString))
            break;
        }
        while (a.a(a.this) == null);
        a.a(a.this).onConsentClick(ConsentStatus.EXPLICIT_NO);
        return true;
        if (!"mopub://close".equals(paramAnonymousString))
          break;
      }
      while (a.a(a.this) == null);
      a.a(a.this).onCloseClick();
      return true;
      if (!TextUtils.isEmpty(paramAnonymousString))
        try
        {
          Intents.launchActionViewIntent(a.this.getContext(), Uri.parse(paramAnonymousString), "Cannot open native browser for " + paramAnonymousString);
          return true;
        }
        catch (IntentNotResolvableException localIntentNotResolvableException)
        {
          MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localIntentNotResolvableException.getMessage();
          MoPubLog.log(localSdkLogEvent, arrayOfObject);
        }
      return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
    }
  };

  public a(Context paramContext)
  {
    super(paramContext);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(WebView paramWebView)
  {
    paramWebView.setWebViewClient(this.e);
    setOnCloseListener(new CloseableLayout.OnCloseListener()
    {
      public void onClose()
      {
        if (a.a(a.this) != null)
          a.a(a.this).onCloseClick();
      }
    });
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  private WebView c()
  {
    WebView localWebView = new WebView(getContext());
    localWebView.setVerticalScrollBarEnabled(false);
    localWebView.setHorizontalScrollBarEnabled(false);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setSupportZoom(false);
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setLoadsImagesAutomatically(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
    localWebSettings.setAllowFileAccess(false);
    localWebSettings.setAllowContentAccess(false);
    if (Build.VERSION.SDK_INT >= 16)
      localWebSettings.setAllowUniversalAccessFromFileURLs(false);
    if (Build.VERSION.SDK_INT >= 17)
      localWebView.setId(View.generateViewId());
    setCloseVisible(false);
    addView(localWebView, new FrameLayout.LayoutParams(-1, -1));
    return localWebView;
  }

  void a(a parama)
  {
    Preconditions.checkNotNull(parama);
    this.d = parama;
  }

  void a(String paramString, b paramb)
  {
    Preconditions.checkNotNull(paramString);
    this.c = paramb;
    a(this.b);
    this.b.loadDataWithBaseURL("https://" + Constants.HOST + "/", paramString, "text/html", "UTF-8", null);
  }

  static abstract interface a
  {
    public abstract void onCloseClick();

    public abstract void onConsentClick(ConsentStatus paramConsentStatus);
  }

  static abstract interface b
  {
    public abstract void onLoadProgress(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.a
 * JD-Core Version:    0.6.2
 */