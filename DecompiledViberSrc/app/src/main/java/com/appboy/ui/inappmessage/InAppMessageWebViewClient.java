package com.appboy.ui.inappmessage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appboy.e.b;
import com.appboy.f.a;
import com.appboy.f.c;
import com.appboy.f.i;
import com.appboy.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.appboy.ui.support.UriUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class InAppMessageWebViewClient extends WebViewClient
{
  private static final String TAG = c.a(InAppMessageWebViewClient.class);
  private Context mContext;
  private final b mInAppMessage;
  private IInAppMessageWebViewClientListener mInAppMessageWebViewClientListener;

  public InAppMessageWebViewClient(Context paramContext, b paramb, IInAppMessageWebViewClientListener paramIInAppMessageWebViewClientListener)
  {
    this.mInAppMessageWebViewClientListener = paramIInAppMessageWebViewClientListener;
    this.mInAppMessage = paramb;
    this.mContext = paramContext;
  }

  private void appendBridgeJavascript(WebView paramWebView)
  {
    String str = a.a(this.mContext.getAssets(), "appboy-html-in-app-message-javascript-component.js");
    if (str == null)
    {
      AppboyInAppMessageManager.getInstance().hideCurrentlyDisplayingInAppMessage(false);
      c.e(TAG, "Failed to get HTML in-app message javascript additions");
      return;
    }
    paramWebView.loadUrl("javascript:" + str);
  }

  static Bundle getBundleFromUrl(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (i.c(paramString))
      return localBundle;
    Map localMap = UriUtils.getQueryParameters(Uri.parse(paramString));
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)localMap.get(str));
    }
    return localBundle;
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    appendBridgeJavascript(paramWebView);
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (this.mInAppMessageWebViewClientListener == null)
      c.c(TAG, "InAppMessageWebViewClient was given null IInAppMessageWebViewClientListener listener. Returning true.");
    Bundle localBundle;
    String str;
    do
    {
      return true;
      if (i.c(paramString))
      {
        c.c(TAG, "InAppMessageWebViewClient.shouldOverrideUrlLoading was given null or blank url. Returning true.");
        return true;
      }
      Uri localUri = Uri.parse(paramString);
      localBundle = getBundleFromUrl(paramString);
      if (!localUri.getScheme().equals("appboy"))
        break;
      str = localUri.getAuthority();
      if (str.equals("close"))
      {
        this.mInAppMessageWebViewClientListener.onCloseAction(this.mInAppMessage, paramString, localBundle);
        return true;
      }
      if (str.equals("feed"))
      {
        this.mInAppMessageWebViewClientListener.onNewsfeedAction(this.mInAppMessage, paramString, localBundle);
        return true;
      }
    }
    while (!str.equals("customEvent"));
    this.mInAppMessageWebViewClientListener.onCustomEventAction(this.mInAppMessage, paramString, localBundle);
    return true;
    this.mInAppMessageWebViewClientListener.onOtherUrlAction(this.mInAppMessage, paramString, localBundle);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageWebViewClient
 * JD-Core Version:    0.6.2
 */