package com.mopub.mobileads.util;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

public class WebViews
{
  public static void manageThirdPartyCookies(WebView paramWebView)
  {
    Preconditions.checkNotNull(paramWebView);
    CookieManager localCookieManager = CookieManager.getInstance();
    if (Build.VERSION.SDK_INT >= 21)
      localCookieManager.setAcceptThirdPartyCookies(paramWebView, MoPub.canCollectPersonalInformation());
  }

  public static void manageWebCookies()
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    if (MoPub.canCollectPersonalInformation())
    {
      localCookieManager.setAcceptCookie(true);
      CookieManager.setAcceptFileSchemeCookies(true);
      return;
    }
    localCookieManager.setAcceptCookie(false);
    CookieManager.setAcceptFileSchemeCookies(false);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localCookieManager.removeSessionCookies(null);
      localCookieManager.removeAllCookies(null);
      localCookieManager.flush();
      return;
    }
    localCookieManager.removeSessionCookie();
    localCookieManager.removeAllCookie();
  }

  public static void onPause(WebView paramWebView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramWebView.stopLoading();
      paramWebView.loadUrl("");
    }
    paramWebView.onPause();
  }

  public static void setDisableJSChromeClient(WebView paramWebView)
  {
    paramWebView.setWebChromeClient(new WebChromeClient()
    {
      public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { paramAnonymousString2 });
        paramAnonymousJsResult.confirm();
        return true;
      }

      public boolean onJsBeforeUnload(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { paramAnonymousString2 });
        paramAnonymousJsResult.confirm();
        return true;
      }

      public boolean onJsConfirm(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { paramAnonymousString2 });
        paramAnonymousJsResult.confirm();
        return true;
      }

      public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { paramAnonymousString2 });
        paramAnonymousJsPromptResult.confirm();
        return true;
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.util.WebViews
 * JD-Core Version:    0.6.2
 */