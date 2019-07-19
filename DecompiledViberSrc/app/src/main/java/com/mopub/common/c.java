package com.mopub.common;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.MoPubErrorCode;
import java.util.EnumSet;

class c extends WebViewClient
{
  private static final EnumSet<UrlAction> a = EnumSet.of(localUrlAction, arrayOfUrlAction);
  private MoPubBrowser b;

  static
  {
    UrlAction localUrlAction = UrlAction.HANDLE_PHONE_SCHEME;
    UrlAction[] arrayOfUrlAction = new UrlAction[5];
    arrayOfUrlAction[0] = UrlAction.OPEN_APP_MARKET;
    arrayOfUrlAction[1] = UrlAction.OPEN_IN_APP_BROWSER;
    arrayOfUrlAction[2] = UrlAction.HANDLE_SHARE_TWEET;
    arrayOfUrlAction[3] = UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK;
    arrayOfUrlAction[4] = UrlAction.FOLLOW_DEEP_LINK;
  }

  public c(MoPubBrowser paramMoPubBrowser)
  {
    this.b = paramMoPubBrowser;
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    Drawable localDrawable1;
    if (paramWebView.canGoBack())
    {
      localDrawable1 = Drawables.LEFT_ARROW.createDrawable(this.b);
      this.b.getBackButton().setImageDrawable(localDrawable1);
      if (!paramWebView.canGoForward())
        break label81;
    }
    label81: for (Drawable localDrawable2 = Drawables.RIGHT_ARROW.createDrawable(this.b); ; localDrawable2 = Drawables.UNRIGHT_ARROW.createDrawable(this.b))
    {
      this.b.getForwardButton().setImageDrawable(localDrawable2);
      return;
      localDrawable1 = Drawables.UNLEFT_ARROW.createDrawable(this.b);
      break;
    }
  }

  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("MoPubBrowser error: " + paramString1);
    MoPubLog.log(localSdkLogEvent, arrayOfObject);
  }

  public boolean onRenderProcessGone(WebView paramWebView, RenderProcessGoneDetail paramRenderProcessGoneDetail)
  {
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    if ((paramRenderProcessGoneDetail != null) && (paramRenderProcessGoneDetail.didCrash()));
    for (MoPubErrorCode localMoPubErrorCode = MoPubErrorCode.RENDER_PROCESS_GONE_WITH_CRASH; ; localMoPubErrorCode = MoPubErrorCode.RENDER_PROCESS_GONE_UNSPECIFIED)
    {
      arrayOfObject[0] = localMoPubErrorCode;
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
      this.b.finish();
      return true;
    }
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    return new UrlHandler.Builder().withSupportedUrlActions(a).withoutMoPubBrowser().withResultActions(new UrlHandler.ResultActions()
    {
      public void urlHandlingFailed(String paramAnonymousString, UrlAction paramAnonymousUrlAction)
      {
      }

      public void urlHandlingSucceeded(String paramAnonymousString, UrlAction paramAnonymousUrlAction)
      {
        if (paramAnonymousUrlAction.equals(UrlAction.OPEN_IN_APP_BROWSER))
        {
          c.a(c.this).getWebView().loadUrl(paramAnonymousString);
          return;
        }
        c.a(c.this).finish();
      }
    }).build().handleResolvedUrl(this.b.getApplicationContext(), paramString, true, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.c
 * JD-Core Version:    0.6.2
 */