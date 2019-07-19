package com.viber.voip.ui.web;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ScrollView;
import com.viber.voip.R.id;
import com.viber.voip.n.a;
import com.viber.voip.ui.n;
import com.viber.voip.util.ViberActionRunner.bd;
import com.viber.voip.util.dj;
import com.viber.voip.util.dz;
import com.viber.voip.widget.ProgressBar;
import com.viber.voip.widget.ViberWebView;

public class c<PRESENTER extends GenericWebViewPresenter> extends com.viber.voip.mvp.core.d<PRESENTER>
  implements b
{
  protected final AppCompatActivity a;
  protected final ViberWebView b;
  protected final ProgressBar c;
  private final n d;

  protected c(AppCompatActivity paramAppCompatActivity, PRESENTER paramPRESENTER, View paramView)
  {
    super(paramPRESENTER, paramView);
    this.a = paramAppCompatActivity;
    this.d = a(paramView);
    this.d.f.setOnClickListener(new d(paramPRESENTER));
    this.b = ((ViberWebView)paramView.findViewById(R.id.webview));
    a(this.b, paramAppCompatActivity.getIntent());
    this.c = ((ProgressBar)paramView.findViewById(R.id.progress));
  }

  private n a(View paramView)
  {
    View localView = paramView.findViewById(R.id.empty_root);
    if (localView != null);
    for (ViewParent localViewParent = localView.getParent(); ; localViewParent = null)
    {
      if ((localViewParent instanceof ScrollView))
      {
        localView.setId(-1);
        ((View)localViewParent).setId(R.id.empty_root);
      }
      n localn = new n(paramView);
      localn.b();
      return localn;
    }
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  protected void a(ViberWebView paramViberWebView, Intent paramIntent)
  {
    WebSettings localWebSettings = paramViberWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    dz.a(paramIntent, paramViberWebView);
    this.b.setWebChromeClient(h());
    this.b.setWebViewClient(d());
  }

  public void a(CharSequence paramCharSequence)
  {
    AppCompatActivity localAppCompatActivity = this.a;
    if (paramCharSequence != null);
    for (String str = paramCharSequence.toString(); ; str = "")
    {
      dj.a(localAppCompatActivity, str);
      return;
    }
  }

  public void a(String paramString)
  {
    this.b.stopLoading();
    this.b.loadUrl(paramString);
  }

  public void b(int paramInt)
  {
    a.a(this.a, paramInt);
  }

  public void b(boolean paramBoolean)
  {
    View localView;
    if (this.d != null)
    {
      localView = this.d.a;
      if (paramBoolean)
        break label35;
    }
    label35: for (boolean bool = true; ; bool = false)
    {
      dj.b(localView, bool);
      dj.b(this.b, paramBoolean);
      return;
    }
  }

  protected WebViewClient d()
  {
    return new b();
  }

  public void e()
  {
    this.b.getSettings().setUserAgentString(dz.b(this.b));
  }

  public void f()
  {
    ViberActionRunner.bd.a(this.a);
  }

  public void g()
  {
    this.b.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0));
    this.b.flingScroll(0, 0);
    this.b.scrollTo(0, 0);
  }

  protected WebChromeClient h()
  {
    return new a();
  }

  public boolean onBackPressed()
  {
    return ((GenericWebViewPresenter)this.mPresenter).a(this.b);
  }

  public void onDestroy()
  {
    this.b.setWebChromeClient(new WebChromeClient());
    this.b.setWebViewClient(new WebViewClient());
  }

  protected class a extends WebChromeClient
  {
    protected a()
    {
    }

    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      ((GenericWebViewPresenter)c.e(c.this)).a(paramWebView.getUrl(), paramWebView.getTitle(), paramInt);
    }

    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      ((GenericWebViewPresenter)c.f(c.this)).e(paramString);
    }
  }

  protected class b extends com.viber.voip.util.k.b
  {
    public b()
    {
      this(e.a(localGenericWebViewPresenter));
    }

    public b(Runnable arg2)
    {
      super();
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      ((GenericWebViewPresenter)c.d(c.this)).b(paramString);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      ((GenericWebViewPresenter)c.c(c.this)).a(paramString);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      return (((GenericWebViewPresenter)c.b(c.this)).c(paramString)) || (super.shouldOverrideUrlLoading(paramWebView, paramString));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.web.c
 * JD-Core Version:    0.6.2
 */