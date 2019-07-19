package com.mopub.mobileads;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.UrlHandler.MoPubSchemeListener;
import com.mopub.common.UrlHandler.ResultActions;
import java.util.EnumSet;

class d extends WebViewClient
{
  private final EnumSet<UrlAction> a;
  private final Context b;
  private final String c;
  private final HtmlWebViewListener d;
  private final BaseHtmlWebView e;
  private final String f;

  d(HtmlWebViewListener paramHtmlWebViewListener, BaseHtmlWebView paramBaseHtmlWebView, String paramString1, String paramString2)
  {
    UrlAction localUrlAction = UrlAction.HANDLE_MOPUB_SCHEME;
    UrlAction[] arrayOfUrlAction = new UrlAction[8];
    arrayOfUrlAction[0] = UrlAction.IGNORE_ABOUT_SCHEME;
    arrayOfUrlAction[1] = UrlAction.HANDLE_PHONE_SCHEME;
    arrayOfUrlAction[2] = UrlAction.OPEN_APP_MARKET;
    arrayOfUrlAction[3] = UrlAction.OPEN_NATIVE_BROWSER;
    arrayOfUrlAction[4] = UrlAction.OPEN_IN_APP_BROWSER;
    arrayOfUrlAction[5] = UrlAction.HANDLE_SHARE_TWEET;
    arrayOfUrlAction[6] = UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK;
    arrayOfUrlAction[7] = UrlAction.FOLLOW_DEEP_LINK;
    this.a = EnumSet.of(localUrlAction, arrayOfUrlAction);
    this.d = paramHtmlWebViewListener;
    this.e = paramBaseHtmlWebView;
    this.f = paramString1;
    this.c = paramString2;
    this.b = paramBaseHtmlWebView.getContext();
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    new UrlHandler.Builder().withDspCreativeId(this.c).withSupportedUrlActions(this.a).withResultActions(new UrlHandler.ResultActions()
    {
      public void urlHandlingFailed(String paramAnonymousString, UrlAction paramAnonymousUrlAction)
      {
      }

      public void urlHandlingSucceeded(String paramAnonymousString, UrlAction paramAnonymousUrlAction)
      {
        if (d.a(d.this).wasClicked())
        {
          d.b(d.this).onClicked();
          d.a(d.this).onResetUserClick();
        }
      }
    }).withMoPubSchemeListener(new UrlHandler.MoPubSchemeListener()
    {
      public void onClose()
      {
        d.b(d.this).onCollapsed();
      }

      public void onCrash()
      {
      }

      public void onFailLoad()
      {
        d.a(d.this).stopLoading();
        d.b(d.this).onFailed(MoPubErrorCode.UNSPECIFIED);
      }

      public void onFinishLoad()
      {
        d.b(d.this).onLoaded(d.a(d.this));
      }
    }).build().handleUrl(this.b, paramString, this.e.wasClicked());
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.d
 * JD-Core Version:    0.6.2
 */