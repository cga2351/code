package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import com.mopub.common.AdReport;
import com.mopub.common.Constants;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.network.Networking;

public class BaseHtmlWebView extends BaseWebView
{
  private final ViewGestureDetector b;

  public BaseHtmlWebView(Context paramContext, AdReport paramAdReport)
  {
    super(paramContext);
    b();
    getSettings().setJavaScriptEnabled(true);
    this.b = new ViewGestureDetector(paramContext, this, paramAdReport);
    enablePlugins(true);
    setBackgroundColor(0);
  }

  private void b()
  {
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollBarEnabled(false);
    setVerticalScrollbarOverlay(false);
    getSettings().setSupportZoom(false);
  }

  void a()
  {
    setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        BaseHtmlWebView.a(BaseHtmlWebView.this).onTouchEvent(paramAnonymousMotionEvent);
        return paramAnonymousMotionEvent.getAction() == 2;
      }
    });
  }

  void a(String paramString)
  {
    loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://" + Constants.HOST + "/", paramString, "text/html", "utf-8", null);
  }

  public void init()
  {
    a();
  }

  public void loadUrl(String paramString)
  {
    if (paramString == null)
      return;
    if (paramString.startsWith("javascript:"))
    {
      super.loadUrl(paramString);
      return;
    }
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("Loading url: " + paramString);
    MoPubLog.log(localSdkLogEvent, arrayOfObject);
  }

  public void onResetUserClick()
  {
    ViewGestureDetector localViewGestureDetector = this.b;
    if (localViewGestureDetector != null)
      localViewGestureDetector.onResetUserClick();
  }

  public void stopLoading()
  {
    if (this.a)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = (BaseHtmlWebView.class.getSimpleName() + "#stopLoading() called after destroy()");
      MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
      return;
    }
    WebSettings localWebSettings = getSettings();
    if (localWebSettings == null)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = (BaseHtmlWebView.class.getSimpleName() + "#getSettings() returned null");
      MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
      return;
    }
    localWebSettings.setJavaScriptEnabled(false);
    super.stopLoading();
    localWebSettings.setJavaScriptEnabled(true);
  }

  public boolean wasClicked()
  {
    ViewGestureDetector localViewGestureDetector = this.b;
    return (localViewGestureDetector != null) && (localViewGestureDetector.isClicked());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.BaseHtmlWebView
 * JD-Core Version:    0.6.2
 */