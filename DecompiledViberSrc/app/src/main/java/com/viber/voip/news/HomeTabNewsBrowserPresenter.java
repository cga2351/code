package com.viber.voip.news;

import android.arch.lifecycle.h;
import android.os.Handler;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.cj;
import com.viber.voip.util.cv;
import com.viber.voip.util.dz;
import com.viber.voip.util.i.e;

class HomeTabNewsBrowserPresenter extends NewsBrowserPresenter<c, HomeTabNewsBrowserState, n>
{
  private static final Logger e = ViberEnv.getLogger();
  private boolean f;
  private boolean g;
  private final a h;

  HomeTabNewsBrowserPresenter(n paramn, cv paramcv, cj paramcj, com.viber.voip.util.i.a parama, Handler paramHandler, dagger.a<ICdrController> parama1, dagger.a<com.viber.voip.analytics.story.g.a> parama2)
  {
    super(paramn, paramcv, paramcj, parama, parama1, parama2);
    if (paramn.h() > 0L)
    {
      this.h = new c(paramn.h(), new b(null), parama, paramHandler, null);
      return;
    }
    this.h = new b(null);
  }

  public void a()
  {
    ((c)this.mView).g();
  }

  protected void a(HomeTabNewsBrowserState paramHomeTabNewsBrowserState)
  {
    super.a(paramHomeTabNewsBrowserState);
    if (paramHomeTabNewsBrowserState != null)
      this.f = paramHomeTabNewsBrowserState.isVisible();
  }

  public void a(String paramString)
  {
    super.a(paramString);
    this.g = false;
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.f)
        e();
      d();
    }
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      if (!paramBoolean)
        break label55;
      this.a.a(false);
    }
    while (true)
    {
      this.h.a(paramBoolean);
      return;
      label55: f();
    }
  }

  public boolean a(WebView paramWebView)
  {
    WebHistoryItem localWebHistoryItem;
    if (dz.a(paramWebView))
    {
      WebBackForwardList localWebBackForwardList = paramWebView.copyBackForwardList();
      int i = localWebBackForwardList.getCurrentIndex();
      if (i <= 0)
        break label58;
      localWebHistoryItem = localWebBackForwardList.getItemAtIndex(i - 1);
      if (localWebHistoryItem == null)
        break label58;
    }
    label58: for (boolean bool = dz.a(localWebHistoryItem.getUrl()); ; bool = true)
    {
      if (bool)
      {
        paramWebView.goBack();
        return true;
      }
      return false;
    }
  }

  protected HomeTabNewsBrowserState b()
  {
    return new HomeTabNewsBrowserState(this.f, c());
  }

  public void b(String paramString)
  {
    super.b(paramString);
    this.g = dz.a(paramString);
    if (this.g)
      this.h.a();
  }

  public void onDestroy(h paramh)
  {
    super.onDestroy(paramh);
    this.h.b();
  }

  private static abstract interface a
  {
    public abstract void a();

    public abstract void a(boolean paramBoolean);

    public abstract void b();
  }

  private class b
    implements HomeTabNewsBrowserPresenter.a
  {
    private b()
    {
    }

    public void a()
    {
      a.a(this);
    }

    public void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        ((c)HomeTabNewsBrowserPresenter.a(HomeTabNewsBrowserPresenter.this)).g();
        ((c)HomeTabNewsBrowserPresenter.b(HomeTabNewsBrowserPresenter.this)).b(true);
        if (HomeTabNewsBrowserPresenter.c(HomeTabNewsBrowserPresenter.this))
        {
          ((c)HomeTabNewsBrowserPresenter.d(HomeTabNewsBrowserPresenter.this)).a();
          return;
        }
        HomeTabNewsBrowserPresenter.e(HomeTabNewsBrowserPresenter.this);
        return;
      }
      HomeTabNewsBrowserPresenter.f(HomeTabNewsBrowserPresenter.this);
    }

    public void b()
    {
    }
  }

  private class c
    implements HomeTabNewsBrowserPresenter.a
  {
    private final HomeTabNewsBrowserPresenter.a b;
    private final e c;
    private final Handler d;
    private final long e;
    private final Runnable f = new b(this);
    private long g = 0L;

    private c(long arg2, HomeTabNewsBrowserPresenter.a parame, e paramHandler, Handler arg6)
    {
      this.b = parame;
      this.c = paramHandler;
      Object localObject;
      this.d = localObject;
      this.e = ???;
    }

    private boolean d()
    {
      return (this.g > 0L) && (this.c.a() - this.g < this.e);
    }

    public void a()
    {
      this.g = this.c.a();
    }

    public void a(boolean paramBoolean)
    {
      if (d())
      {
        if (paramBoolean)
        {
          this.d.removeCallbacks(this.f);
          if (!HomeTabNewsBrowserPresenter.c(HomeTabNewsBrowserPresenter.this))
          {
            ((c)HomeTabNewsBrowserPresenter.g(HomeTabNewsBrowserPresenter.this)).g();
            ((c)HomeTabNewsBrowserPresenter.h(HomeTabNewsBrowserPresenter.this)).b(true);
            HomeTabNewsBrowserPresenter.i(HomeTabNewsBrowserPresenter.this);
          }
          return;
        }
        this.d.postDelayed(this.f, this.e);
        return;
      }
      this.g = 0L;
      this.d.removeCallbacks(this.f);
      this.b.a(paramBoolean);
    }

    public void b()
    {
      this.d.removeCallbacks(this.f);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.HomeTabNewsBrowserPresenter
 * JD-Core Version:    0.6.2
 */