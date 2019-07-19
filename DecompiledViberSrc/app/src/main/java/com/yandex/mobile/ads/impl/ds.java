package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;

public abstract class ds extends z
  implements ae.b, dm, gb.a
{
  private static boolean a = false;
  private final gb b = new gb();
  protected dn e;
  private final he f = new he();
  private final ae g = ae.a();
  private final fk h = new fk();
  private boolean i;
  private boolean j;

  public ds(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    a_(paramContext);
    WebView localWebView;
    WindowManager.LayoutParams localLayoutParams;
    WindowManager localWindowManager;
    if (!a)
    {
      Context localContext = getContext();
      if (Build.VERSION.SDK_INT == 19)
      {
        localWebView = new WebView(localContext.getApplicationContext());
        localWebView.setBackgroundColor(0);
        localWebView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
        localLayoutParams = new WindowManager.LayoutParams();
        localLayoutParams.width = 1;
        localLayoutParams.height = 1;
        localLayoutParams.type = 2005;
        localLayoutParams.flags = 16777240;
        localLayoutParams.format = -2;
        localLayoutParams.gravity = 8388659;
        localWindowManager = (WindowManager)localContext.getSystemService("window");
      }
    }
    try
    {
      localWindowManager.addView(localWebView, localLayoutParams);
      label172: a = true;
      return;
    }
    catch (Exception localException)
    {
      break label172;
    }
  }

  private void a(boolean paramBoolean)
  {
    if (this.i != paramBoolean)
    {
      this.i = paramBoolean;
      if (this.e != null)
        this.e.b(this.i);
    }
  }

  protected abstract void a();

  public final void a(Context paramContext, String paramString)
  {
    if (this.e != null)
      this.e.a(paramString);
  }

  public final void a(Intent paramIntent)
  {
    if ((!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) && (gb.a(this)) && (this.g.a(getContext())));
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
    }
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  protected void a_(Context paramContext)
  {
    super.a_(paramContext);
    setBackgroundColor(0);
    setVisibility(4);
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollBarEnabled(false);
    setVerticalScrollbarOverlay(false);
    setScrollBarStyle(0);
    WebSettings localWebSettings1 = getSettings();
    localWebSettings1.setJavaScriptEnabled(true);
    localWebSettings1.setSupportZoom(false);
    localWebSettings1.setBuiltInZoomControls(false);
    localWebSettings1.setMinimumFontSize(1);
    localWebSettings1.setMinimumLogicalFontSize(1);
    if (fl.a(21))
      localWebSettings1.setMixedContentMode(0);
    if (Build.VERSION.SDK_INT >= 17)
      localWebSettings1.setMediaPlaybackRequiresUserGesture(false);
    WebSettings localWebSettings2 = getSettings();
    et localet = es.a().a(paramContext);
    if ((localet != null) && (localet.g()))
      localWebSettings2.setUserAgentString(this.h.a(paramContext));
    setWebViewClient(new dl(this));
    setWebChromeClient(new do());
  }

  protected String b()
  {
    return super.b() + "<style type='text/css'> \n  * { \n      -webkit-tap-highlight-color: rgba(0, 0, 0, 0) !important; \n      -webkit-focus-ring-color: rgba(0, 0, 0, 0) !important; \n      outline: none !important; \n    } \n</style> \n" + dt.d;
  }

  public void d()
  {
    this.f.a(new Runnable()
    {
      public final void run()
      {
        ds.this.a();
      }
    });
  }

  public void g()
  {
    this.e = null;
    super.g();
  }

  public final boolean h()
  {
    return this.j;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.j = true;
    this.g.a(this, getContext());
    a(gb.a(this));
  }

  protected void onDetachedFromWindow()
  {
    this.j = false;
    a(gb.a(this));
    this.g.b(this, getContext());
    super.onDetachedFromWindow();
  }

  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    a(gb.a(this));
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    a(gb.a(this));
  }

  public void setHtmlWebViewListener(dn paramdn)
  {
    this.e = paramdn;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ds
 * JD-Core Version:    0.6.2
 */