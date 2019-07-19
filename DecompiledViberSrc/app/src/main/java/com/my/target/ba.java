package com.my.target;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class ba extends LinearLayout
{
  public static final int a = bj.a();
  public static final int b = bj.a();
  private final bj c;
  private final ImageButton d;
  private final LinearLayout e;
  private final TextView f;
  private final TextView g;
  private final FrameLayout h;
  private final View i;
  private final FrameLayout j;
  private final ImageButton k;
  private final RelativeLayout l;
  private final WebView m;
  private final ProgressBar n;
  private b o;

  public ba(Context paramContext)
  {
    super(paramContext);
    this.l = new RelativeLayout(paramContext);
    this.m = new WebView(paramContext);
    this.d = new ImageButton(paramContext);
    this.e = new LinearLayout(paramContext);
    this.f = new TextView(paramContext);
    this.g = new TextView(paramContext);
    this.h = new FrameLayout(paramContext);
    this.j = new FrameLayout(paramContext);
    this.k = new ImageButton(paramContext);
    this.n = new ProgressBar(paramContext, null, 16842872);
    this.i = new View(paramContext);
    this.c = bj.a(paramContext);
  }

  private String a(String paramString)
  {
    try
    {
      URI localURI = new URI(paramString);
      String str = localURI.getScheme() + "://" + localURI.getHost();
      return str;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      localURISyntaxException.printStackTrace();
    }
    return paramString;
  }

  private void e()
  {
    setOrientation(1);
    setGravity(16);
    a locala = new a(null);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
    this.m.setLayoutParams(localLayoutParams1);
    TypedValue localTypedValue = new TypedValue();
    int i1 = this.c.c(50);
    if (getContext().getTheme().resolveAttribute(16843499, localTypedValue, true))
      i1 = TypedValue.complexToDimensionPixelSize(localTypedValue.data, getResources().getDisplayMetrics());
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, i1);
    this.l.setLayoutParams(localLayoutParams2);
    LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(i1, i1);
    this.h.setLayoutParams(localLayoutParams3);
    this.h.setId(a);
    FrameLayout.LayoutParams localLayoutParams4 = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams4.gravity = 17;
    this.d.setLayoutParams(localLayoutParams4);
    this.d.setImageBitmap(ap.a(i1 / 4, this.c.c(2)));
    this.d.setContentDescription("Close");
    this.d.setOnClickListener(locala);
    RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(i1, i1);
    if (Build.VERSION.SDK_INT >= 18)
      localLayoutParams5.addRule(21);
    while (true)
    {
      this.j.setLayoutParams(localLayoutParams5);
      this.j.setId(b);
      FrameLayout.LayoutParams localLayoutParams6 = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams6.gravity = 17;
      this.k.setLayoutParams(localLayoutParams6);
      this.k.setImageBitmap(ap.a(getContext()));
      this.k.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.k.setContentDescription("Open outside");
      this.k.setOnClickListener(locala);
      bj.a(this.d, 0, -3355444);
      bj.a(this.k, 0, -3355444);
      RelativeLayout.LayoutParams localLayoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams7.addRule(15, -1);
      localLayoutParams7.addRule(1, a);
      localLayoutParams7.addRule(0, b);
      this.e.setLayoutParams(localLayoutParams7);
      this.e.setOrientation(1);
      this.e.setPadding(this.c.c(4), this.c.c(4), this.c.c(4), this.c.c(4));
      LinearLayout.LayoutParams localLayoutParams8 = new LinearLayout.LayoutParams(-2, -2);
      this.g.setVisibility(8);
      this.g.setLayoutParams(localLayoutParams8);
      this.g.setTextColor(-16777216);
      this.g.setTextSize(2, 18.0F);
      this.g.setSingleLine();
      this.g.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      LinearLayout.LayoutParams localLayoutParams9 = new LinearLayout.LayoutParams(-2, -2);
      this.f.setLayoutParams(localLayoutParams9);
      this.f.setSingleLine();
      this.f.setTextSize(2, 12.0F);
      this.f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ClipDrawable localClipDrawable = new ClipDrawable(new ColorDrawable(-16537100), 8388611, 1);
      ColorDrawable localColorDrawable = new ColorDrawable(-1968642);
      LayerDrawable localLayerDrawable = (LayerDrawable)this.n.getProgressDrawable();
      localLayerDrawable.setDrawableByLayerId(16908288, localColorDrawable);
      localLayerDrawable.setDrawableByLayerId(16908301, localClipDrawable);
      this.n.setProgressDrawable(localLayerDrawable);
      LinearLayout.LayoutParams localLayoutParams10 = new LinearLayout.LayoutParams(-1, this.c.c(2));
      this.n.setLayoutParams(localLayoutParams10);
      this.n.setProgress(0);
      this.e.addView(this.g);
      this.e.addView(this.f);
      this.h.addView(this.d);
      this.j.addView(this.k);
      this.l.addView(this.h);
      this.l.addView(this.e);
      this.l.addView(this.j);
      addView(this.l);
      this.i.setBackgroundColor(-5592406);
      RelativeLayout.LayoutParams localLayoutParams11 = new RelativeLayout.LayoutParams(-1, 1);
      this.i.setVisibility(8);
      this.i.setLayoutParams(localLayoutParams11);
      addView(this.n);
      addView(this.i);
      addView(this.m);
      return;
      localLayoutParams5.addRule(11);
    }
  }

  private void f()
  {
    String str = this.m.getUrl();
    if (!TextUtils.isEmpty(str));
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str));
      if (!(getContext() instanceof Activity))
        localIntent.addFlags(268435456);
      getContext().startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      dp.a("unable to open url " + str);
    }
  }

  public boolean a()
  {
    return this.m.canGoBack();
  }

  public void b()
  {
    this.m.goBack();
  }

  public void c()
  {
    this.m.setWebChromeClient(null);
    this.m.setWebViewClient(null);
    this.m.destroy();
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  public void d()
  {
    WebSettings localWebSettings = this.m.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setDisplayZoomControls(false);
    if (Build.VERSION.SDK_INT >= 16)
    {
      localWebSettings.setAllowFileAccessFromFileURLs(false);
      localWebSettings.setAllowUniversalAccessFromFileURLs(false);
    }
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
    this.m.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        paramAnonymousWebView.loadUrl(paramAnonymousString);
        ba.a(ba.this).setText(ba.a(ba.this, paramAnonymousString));
        return true;
      }
    });
    this.m.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        if ((paramAnonymousInt < 100) && (ba.c(ba.this).getVisibility() == 8))
        {
          ba.c(ba.this).setVisibility(0);
          ba.d(ba.this).setVisibility(8);
        }
        ba.c(ba.this).setProgress(paramAnonymousInt);
        if (paramAnonymousInt >= 100)
        {
          ba.c(ba.this).setVisibility(8);
          ba.d(ba.this).setVisibility(0);
        }
      }

      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        ba.b(ba.this).setText(paramAnonymousWebView.getTitle());
        ba.b(ba.this).setVisibility(0);
      }
    });
    e();
  }

  public b getListener()
  {
    return this.o;
  }

  public void setListener(b paramb)
  {
    this.o = paramb;
  }

  public void setUrl(String paramString)
  {
    this.m.loadUrl(paramString);
    this.f.setText(a(paramString));
  }

  private class a
    implements View.OnClickListener
  {
    private a()
    {
    }

    public void onClick(View paramView)
    {
      if (paramView == ba.e(ba.this))
        if (ba.f(ba.this) != null)
          ba.f(ba.this).a();
      while (paramView != ba.g(ba.this))
        return;
      ba.h(ba.this);
    }
  }

  public static abstract interface b
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ba
 * JD-Core Version:    0.6.2
 */