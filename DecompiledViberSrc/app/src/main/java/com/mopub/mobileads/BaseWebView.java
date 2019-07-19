package com.mopub.mobileads;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Views;
import com.mopub.mobileads.util.WebViews;

public class BaseWebView extends WebView
{
  private static boolean b = false;
  protected boolean a;

  public BaseWebView(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    enablePlugins(false);
    a();
    WebViews.setDisableJSChromeClient(this);
    if (!b)
    {
      a(getContext());
      b = true;
    }
  }

  private void a()
  {
    getSettings().setAllowFileAccess(false);
    getSettings().setAllowContentAccess(false);
    getSettings().setAllowFileAccessFromFileURLs(false);
    getSettings().setAllowUniversalAccessFromFileURLs(false);
  }

  private void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT == 19)
    {
      WebView localWebView = new WebView(paramContext.getApplicationContext());
      localWebView.setBackgroundColor(0);
      localWebView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.width = 1;
      localLayoutParams.height = 1;
      localLayoutParams.type = 2005;
      localLayoutParams.flags = 16777240;
      localLayoutParams.format = -2;
      localLayoutParams.gravity = 8388659;
      ((WindowManager)paramContext.getSystemService("window")).addView(localWebView, localLayoutParams);
    }
  }

  public void destroy()
  {
    if (this.a)
      return;
    this.a = true;
    Views.removeFromParent(this);
    removeAllViews();
    super.destroy();
  }

  public void enablePlugins(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 18)
      return;
    if (paramBoolean)
    {
      getSettings().setPluginState(WebSettings.PluginState.ON);
      return;
    }
    getSettings().setPluginState(WebSettings.PluginState.OFF);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    WebViews.manageThirdPartyCookies(this);
  }

  @Deprecated
  @VisibleForTesting
  void setIsDestroyed(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.BaseWebView
 * JD-Core Version:    0.6.2
 */