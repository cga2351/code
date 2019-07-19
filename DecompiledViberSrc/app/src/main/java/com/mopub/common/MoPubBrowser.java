package com.mopub.common;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.util.WebViews;

public class MoPubBrowser extends Activity
{
  public static final String DESTINATION_URL_KEY = "URL";
  public static final String DSP_CREATIVE_ID = "mopub-dsp-creative-id";
  public static final int MOPUB_BROWSER_REQUEST_CODE = 1;
  private WebView a;
  private ImageButton b;
  private ImageButton c;
  private ImageButton d;
  private ImageButton e;
  private boolean f;

  private ImageButton a(Drawable paramDrawable)
  {
    ImageButton localImageButton = new ImageButton(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
    localLayoutParams.gravity = 16;
    localImageButton.setLayoutParams(localLayoutParams);
    localImageButton.setImageDrawable(paramDrawable);
    return localImageButton;
  }

  private void a()
  {
    WebSettings localWebSettings = this.a.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    this.a.loadUrl(getIntent().getStringExtra("URL"));
    this.a.setWebViewClient(new c(this));
  }

  private void b()
  {
    this.b.setBackgroundColor(0);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (MoPubBrowser.a(MoPubBrowser.this).canGoBack())
          MoPubBrowser.a(MoPubBrowser.this).goBack();
      }
    });
    this.c.setBackgroundColor(0);
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (MoPubBrowser.a(MoPubBrowser.this).canGoForward())
          MoPubBrowser.a(MoPubBrowser.this).goForward();
      }
    });
    this.d.setBackgroundColor(0);
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoPubBrowser.a(MoPubBrowser.this).reload();
      }
    });
    this.e.setBackgroundColor(0);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoPubBrowser.this.finish();
      }
    });
  }

  private void c()
  {
    CookieSyncManager.createInstance(this);
    CookieSyncManager.getInstance().startSync();
  }

  private View d()
  {
    LinearLayout localLinearLayout1 = new LinearLayout(this);
    localLinearLayout1.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout1.setOrientation(1);
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout1.addView(localRelativeLayout);
    LinearLayout localLinearLayout2 = new LinearLayout(this);
    localLinearLayout2.setId(1);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams1.addRule(12);
    localLinearLayout2.setLayoutParams(localLayoutParams1);
    localLinearLayout2.setBackgroundDrawable(Drawables.BACKGROUND.createDrawable(this));
    localRelativeLayout.addView(localLinearLayout2);
    this.b = a(Drawables.UNLEFT_ARROW.createDrawable(this));
    this.c = a(Drawables.UNRIGHT_ARROW.createDrawable(this));
    this.d = a(Drawables.REFRESH.createDrawable(this));
    this.e = a(Drawables.CLOSE.createDrawable(this));
    localLinearLayout2.addView(this.b);
    localLinearLayout2.addView(this.c);
    localLinearLayout2.addView(this.d);
    localLinearLayout2.addView(this.e);
    this.a = new BaseWebView(this);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams2.addRule(2, 1);
    this.a.setLayoutParams(localLayoutParams2);
    localRelativeLayout.addView(this.a);
    return localLinearLayout1;
  }

  public void finish()
  {
    ((ViewGroup)getWindow().getDecorView()).removeAllViews();
    super.finish();
  }

  public ImageButton getBackButton()
  {
    return this.b;
  }

  public ImageButton getCloseButton()
  {
    return this.e;
  }

  public ImageButton getForwardButton()
  {
    return this.c;
  }

  public ImageButton getRefreshButton()
  {
    return this.d;
  }

  public WebView getWebView()
  {
    return this.a;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setResult(-1);
    this.f = getWindow().requestFeature(2);
    if (this.f)
      getWindow().setFeatureInt(2, -1);
    setContentView(d());
    a();
    b();
    c();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.a.destroy();
    this.a = null;
  }

  protected void onPause()
  {
    super.onPause();
    CookieSyncManager.getInstance().stopSync();
    this.a.setWebChromeClient(null);
    WebViews.onPause(this.a, isFinishing());
  }

  protected void onResume()
  {
    super.onResume();
    CookieSyncManager.getInstance().startSync();
    this.a.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 100)
          MoPubBrowser.this.setTitle(paramAnonymousWebView.getUrl());
        while (true)
        {
          if ((MoPubBrowser.b(MoPubBrowser.this)) && (Build.VERSION.SDK_INT < 24))
            MoPubBrowser.this.setProgress(paramAnonymousInt * 100);
          return;
          MoPubBrowser.this.setTitle("Loading...");
        }
      }
    });
    this.a.onResume();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.MoPubBrowser
 * JD-Core Version:    0.6.2
 */