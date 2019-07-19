package com.appboy.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout.LayoutParams;
import com.appboy.b.e;
import com.appboy.f.a;
import com.appboy.f.c;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.activities.AppboyBaseActivity;
import java.util.List;

@SuppressLint({"SetJavaScriptEnabled"})
public class AppboyWebViewActivity extends AppboyBaseActivity
{
  private static final String TAG = c.a(AppboyWebViewActivity.class);

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(2);
    requestWindowFeature(5);
    getWindow().setFlags(16777216, 16777216);
    setContentView(R.layout.com_appboy_webview_activity);
    setProgressBarVisibility(true);
    WebView localWebView = (WebView)findViewById(R.id.com_appboy_webview_activity_webview);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setAllowFileAccess(false);
    localWebSettings.setPluginState(WebSettings.PluginState.OFF);
    localWebSettings.setDisplayZoomControls(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localWebView.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        if (paramAnonymousInt < 100)
        {
          AppboyWebViewActivity.this.setProgressBarVisibility(true);
          return;
        }
        AppboyWebViewActivity.this.setProgressBarVisibility(false);
      }
    });
    localWebView.setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramAnonymousString1));
        AppboyWebViewActivity.this.startActivity(localIntent);
      }
    });
    localWebView.getSettings().setCacheMode(2);
    localWebView.setLayerType(2, null);
    localWebView.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        try
        {
          if (!a.a.contains(Uri.parse(paramAnonymousString).getScheme()))
          {
            ActionFactory.createUriActionFromUrlString(paramAnonymousString, AppboyWebViewActivity.this.getIntent().getExtras(), false, e.d).execute(paramAnonymousWebView.getContext());
            AppboyWebViewActivity.this.finish();
            return true;
          }
        }
        catch (Exception localException)
        {
          c.b(AppboyWebViewActivity.TAG, "Unexpected exception while processing url " + paramAnonymousString + ". Passing url back to WebView.", localException);
        }
        return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
      }
    });
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("url")))
      localWebView.loadUrl(localBundle.getString("url"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.AppboyWebViewActivity
 * JD-Core Version:    0.6.2
 */