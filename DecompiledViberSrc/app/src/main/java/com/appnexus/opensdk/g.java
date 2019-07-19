package com.appnexus.opensdk;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.appnexus.opensdk.utils.Clog;

class g extends WebChromeClient
{
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    Clog.v(Clog.jsLogTag, Clog.getString(R.string.console_message, paramConsoleMessage.message(), paramConsoleMessage.lineNumber(), paramConsoleMessage.sourceId()));
    return true;
  }

  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Clog.v(Clog.jsLogTag, Clog.getString(R.string.js_alert, paramString2, paramString1));
    paramJsResult.confirm();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.g
 * JD-Core Version:    0.6.2
 */