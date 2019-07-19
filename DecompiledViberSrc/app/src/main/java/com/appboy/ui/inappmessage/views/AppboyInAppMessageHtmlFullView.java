package com.appboy.ui.inappmessage.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.appboy.f.c;
import com.appboy.ui.R.id;
import com.appboy.ui.inappmessage.jsinterface.AppboyInAppMessageHtmlJavascriptInterface;

public class AppboyInAppMessageHtmlFullView extends AppboyInAppMessageHtmlBaseView
{
  private static final String TAG = c.a(AppboyInAppMessageHtmlFullView.class);
  private WebView mMessageWebView;

  public AppboyInAppMessageHtmlFullView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  @SuppressLint({"AddJavascriptInterface", "SetJavaScriptEnabled"})
  public WebView getMessageWebView()
  {
    if (this.mMessageWebView == null)
    {
      this.mMessageWebView = ((AppboyInAppMessageWebView)findViewById(R.id.com_appboy_inappmessage_html_full_webview));
      if (this.mMessageWebView != null)
      {
        WebSettings localWebSettings = this.mMessageWebView.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setUseWideViewPort(true);
        localWebSettings.setLoadWithOverviewMode(true);
        localWebSettings.setDisplayZoomControls(false);
        this.mMessageWebView.setLayerType(2, null);
        this.mMessageWebView.setBackgroundColor(0);
        this.mMessageWebView.setWebChromeClient(new WebChromeClient()
        {
          public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
          {
            c.b(AppboyInAppMessageHtmlFullView.TAG, "Html In-app log. Line: " + paramAnonymousConsoleMessage.lineNumber() + ". SourceId: " + paramAnonymousConsoleMessage.sourceId() + ". Log Level: " + paramAnonymousConsoleMessage.messageLevel() + ". Message: " + paramAnonymousConsoleMessage.message());
            return true;
          }
        });
        this.mMessageWebView.addJavascriptInterface(new AppboyInAppMessageHtmlJavascriptInterface(getContext()), "appboyInternalBridge");
      }
    }
    return this.mMessageWebView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageHtmlFullView
 * JD-Core Version:    0.6.2
 */