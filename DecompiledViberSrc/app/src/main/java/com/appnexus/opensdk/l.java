package com.appnexus.opensdk;

import android.app.Activity;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.ViewUtil;
import java.lang.ref.WeakReference;
import java.util.Queue;

class l
  implements AdActivity.a
{
  private Activity a;
  private f b;
  private FrameLayout c;
  private long d;
  private InterstitialAdView e;
  private ImageButton f;

  public l(Activity paramActivity)
  {
    this.a = paramActivity;
  }

  private void a()
  {
    if ((this.c == null) || (this.f != null))
      return;
    f localf = this.b;
    boolean bool = false;
    if (localf != null)
      bool = this.b.o();
    this.f = ViewUtil.createCloseButton(this.a, bool);
    this.f.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        l.a(l.this);
      }
    });
    this.c.addView(this.f);
  }

  private void a(InterstitialAdView paramInterstitialAdView)
  {
    this.e = paramInterstitialAdView;
    if (this.e == null);
    m localm;
    do
    {
      return;
      this.e.setAdImplementation(this);
      this.c.setBackgroundColor(this.e.getBackgroundColor());
      this.c.removeAllViews();
      if (this.e.getParent() != null)
        ((ViewGroup)this.e.getParent()).removeAllViews();
      for (localm = (m)this.e.getAdQueue().poll(); (localm != null) && ((this.d - localm.a() > 270000L) || (this.d - localm.a() < 0L)); localm = (m)this.e.getAdQueue().poll())
        Clog.w(Clog.baseLogTag, Clog.getString(R.string.too_old));
    }
    while ((localm == null) || (!(localm.d() instanceof f)));
    this.b = ((f)localm.d());
    if ((this.b.getContext() instanceof MutableContextWrapper))
      ((MutableContextWrapper)this.b.getContext()).setBaseContext(this.a);
    if ((this.b.k() != 1) || (this.b.l() != 1))
      AdActivity.a(this.a, this.b.h());
    this.c.addView(this.b);
  }

  private void b()
  {
    if (this.a != null)
    {
      if ((this.e != null) && (this.e.getAdDispatcher() != null))
        this.e.getAdDispatcher().b();
      this.a.finish();
    }
  }

  public void backPressed()
  {
    if ((this.e != null) && (this.e.getAdDispatcher() != null))
      this.e.getAdDispatcher().b();
  }

  public void browserLaunched()
  {
    if ((this.e != null) && (this.e.shouldDismissOnClick()))
      b();
  }

  public void create()
  {
    this.c = new FrameLayout(this.a);
    this.a.setContentView(this.c);
    this.d = this.a.getIntent().getLongExtra("TIME", System.currentTimeMillis());
    a(InterstitialAdView.s);
    int i = this.a.getIntent().getIntExtra("CLOSE_BUTTON_DELAY", 10000);
    new a(this).sendEmptyMessageDelayed(8000, i);
    int j = this.a.getIntent().getIntExtra("AUTODISMISS_DELAY", -1);
    if ((this.e != null) && (j > -1))
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          l.a(l.this);
        }
      }
      , j * 1000);
  }

  public void destroy()
  {
    if (this.b != null)
    {
      ViewUtil.removeChildFromParent(this.b);
      this.b.destroy();
    }
    if (this.e != null)
      this.e.setAdImplementation(null);
  }

  public WebView getWebView()
  {
    return this.b;
  }

  public void interacted()
  {
    a();
  }

  static class a extends Handler
  {
    WeakReference<l> a;

    public a(l paraml)
    {
      this.a = new WeakReference(paraml);
    }

    public void handleMessage(Message paramMessage)
    {
      l locall = (l)this.a.get();
      if ((paramMessage.what == 8000) && (locall != null))
        l.b(locall);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.l
 * JD-Core Version:    0.6.2
 */