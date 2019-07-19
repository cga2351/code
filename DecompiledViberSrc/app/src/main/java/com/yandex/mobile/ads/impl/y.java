package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.yandex.mobile.ads.AdEventListener;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.b;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class y<T>
  implements AdEventListener, aa, ae.b, pl.a<v<T>>, w.a
{
  protected final Handler a;
  protected final Context b;
  protected final r c;
  protected final w d;
  protected final Executor e;
  protected final eo f;
  protected v<T> g;
  private final ag h;
  private final ae i;
  private final cv j;
  private final ex k;
  private final cj l;
  private final ep m;
  private final er n;
  private s o;
  private boolean p;
  private long q;
  private AdEventListener r;
  private ew s;

  protected y(Context paramContext, b paramb)
  {
    this.b = paramContext;
    this.a = new Handler(Looper.getMainLooper());
    this.c = new r(this);
    this.d = new w(this.a);
    this.d.a(this);
    this.o = s.b;
    this.i = ae.a();
    this.j = new ct();
    this.f = new eo(paramb);
    this.e = Executors.newSingleThreadExecutor(new dc("YandexMobileAds.BaseController"));
    this.h = new ag(paramContext, this.f);
    this.k = new ex(this.f);
    this.s = eu.a(paramContext);
    this.l = new cj(paramContext);
    this.m = new ep();
    this.n = new er();
  }

  private boolean a()
  {
    try
    {
      s locals1 = this.o;
      s locals2 = s.e;
      if (locals1 == locals2)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  private void b(ov paramov)
  {
    if ((paramov instanceof q))
      onAdFailedToLoad(r.a(((q)paramov).a()));
  }

  private boolean b()
  {
    try
    {
      new StringBuilder("isLoading, state = ").append(this.o);
      s locals1 = this.o;
      s locals2 = s.c;
      if (locals1 != locals2)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  private boolean d()
  {
    if (this.f.c() == null)
    {
      onAdFailedToLoad(t.n);
      return false;
    }
    return true;
  }

  private boolean g()
  {
    if (!cz.b())
    {
      onAdFailedToLoad(t.r);
      return false;
    }
    if (!al.a())
    {
      onAdFailedToLoad(t.q);
      return false;
    }
    return true;
  }

  private boolean x()
  {
    boolean bool = true;
    if (this.f.l() != bool)
    {
      onAdFailedToLoad(t.o);
      bool = false;
    }
    return bool;
  }

  protected abstract bm<T> a(String paramString1, String paramString2);

  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default:
      return;
    case 6:
      onAdOpened();
      return;
    case 8:
      onAdClosed();
      return;
    case 7:
    }
    onAdLeftApplication();
  }

  public void a(Intent paramIntent)
  {
    new StringBuilder("action = ").append(paramIntent.getAction());
  }

  public final void a(AdEventListener paramAdEventListener)
  {
    this.r = paramAdEventListener;
  }

  public void a(AdRequest paramAdRequest)
  {
    try
    {
      if (b())
      {
        if (!d(paramAdRequest))
          break label32;
        a(s.b);
        b(paramAdRequest);
      }
      while (true)
      {
        return;
        label32: h();
      }
    }
    finally
    {
    }
  }

  protected final void a(final AdRequest paramAdRequest, final cv paramcv)
  {
    try
    {
      this.e.execute(new Runnable()
      {
        public final void run()
        {
          y.this.c(paramAdRequest);
          if (y.this.m())
          {
            y.this.a(s.c);
            y.a(y.this, paramcv);
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void a(AdRequestError paramAdRequestError)
  {
    try
    {
      if (this.r != null)
        this.r.onAdFailedToLoad(paramAdRequestError);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final void a(final cv paramcv)
  {
    try
    {
      this.e.execute(new Runnable()
      {
        public final void run()
        {
          if (!y.this.a_())
          {
            String str1 = paramcv.a(y.this.f);
            if (!TextUtils.isEmpty(str1))
            {
              y.this.f.a(paramcv.a());
              cv localcv = paramcv;
              Context localContext = y.this.b;
              eo localeo = y.this.f;
              y.a(y.this);
              y.b(y.this);
              String str2 = localcv.a(localContext, localeo);
              bm localbm = y.this.a(str1, str2);
              localbm.a(cw.a(this));
              y.this.c.a(localbm);
            }
          }
          else
          {
            return;
          }
          y.this.onAdFailedToLoad(t.n);
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(ov paramov)
  {
    b(paramov);
  }

  protected final void a(s params)
  {
    try
    {
      new StringBuilder("assignLoadingState, state = ").append(params);
      this.o = params;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(v<T> paramv)
  {
    try
    {
      this.g = paramv;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a_(String paramString)
  {
    this.f.b(paramString);
  }

  public final void a_(boolean paramBoolean)
  {
    this.f.a(paramBoolean);
  }

  public final boolean a_()
  {
    try
    {
      boolean bool = this.p;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected final void b(AdRequest paramAdRequest)
  {
    try
    {
      a(paramAdRequest, this.j);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void b(aj paramaj)
  {
    this.f.a(paramaj);
  }

  public void b(cv paramcv)
  {
    a(this.f.c(), paramcv);
  }

  protected final void b(String paramString)
  {
    try
    {
      if (this.g != null)
      {
        co localco = new co(this.b, this.f.i(), this.d);
        this.l.a(paramString, this.g, localco);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected final void c(AdRequest paramAdRequest)
  {
    try
    {
      this.f.a(paramAdRequest);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected boolean d(AdRequest paramAdRequest)
  {
    try
    {
      if ((this.g != null) && (this.q > 0L) && (SystemClock.elapsedRealtime() - this.q <= this.g.n()) && ((paramAdRequest == null) || (paramAdRequest.equals(this.f.c()))))
      {
        boolean bool2 = a();
        if (!bool2)
          break label73;
      }
      label73: for (boolean bool1 = true; ; bool1 = false)
        return bool1;
    }
    finally
    {
    }
  }

  public void e()
  {
    try
    {
      if (!a_())
      {
        this.p = true;
        u();
        this.k.a(this.s);
        this.d.a(null);
        this.c.b();
        this.g = null;
        this.r = null;
        new Object[1][0] = getClass().toString();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void f()
  {
    e();
    new StringBuilder("onDestroy(), clazz = ").append(getClass());
  }

  protected void h()
  {
    try
    {
      if (this.r != null)
        this.r.onAdLoaded();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected final AdRequest i()
  {
    try
    {
      AdRequest localAdRequest = this.f.c();
      return localAdRequest;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean j()
  {
    try
    {
      s locals1 = this.o;
      s locals2 = s.d;
      if (locals1 == locals2)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public final boolean k()
  {
    try
    {
      s locals1 = this.o;
      s locals2 = s.a;
      if (locals1 == locals2)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public final Context l()
  {
    return this.b;
  }

  protected boolean m()
  {
    if (n())
    {
      int i1;
      if (this.f.b() == null)
      {
        onAdFailedToLoad(t.p);
        i1 = 0;
        if (i1 == 0)
          break label66;
        if (cw.b(this.b) == true)
          break label61;
        onAdFailedToLoad(t.b);
      }
      label61: for (int i2 = 0; ; i2 = 1)
      {
        if (i2 == 0)
          break label66;
        return true;
        i1 = 1;
        break;
      }
    }
    label66: return false;
  }

  protected final boolean n()
  {
    boolean bool1 = g();
    boolean bool2 = o();
    boolean bool3 = x();
    boolean bool4 = d();
    return (bool1) && (bool2) && (bool3) && (bool4);
  }

  protected final boolean o()
  {
    try
    {
      cz.a().a(this.b);
      return true;
    }
    catch (cz.a locala)
    {
      onAdFailedToLoad(t.a(1, locala.getMessage()));
    }
    return false;
  }

  public void onAdClosed()
  {
    try
    {
      if (this.r != null)
        this.r.onAdClosed();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onAdFailedToLoad(final AdRequestError paramAdRequestError)
  {
    fq.b(paramAdRequestError.getDescription(), new Object[0]);
    a(s.e);
    this.a.post(new Runnable()
    {
      public final void run()
      {
        y.this.a(paramAdRequestError);
      }
    });
  }

  public void onAdLeftApplication()
  {
    try
    {
      if (this.r != null)
        this.r.onAdLeftApplication();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onAdLoaded()
  {
    s();
    h();
  }

  public void onAdOpened()
  {
    try
    {
      if (this.r != null)
        this.r.onAdOpened();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String p()
  {
    return this.f.e();
  }

  public final AdEventListener q()
  {
    return this.r;
  }

  public final eo r()
  {
    return this.f;
  }

  public final void s()
  {
    a(s.d);
    this.q = SystemClock.elapsedRealtime();
  }

  public final void t()
  {
    new StringBuilder("registerPhoneStateTracker(), clazz = ").append(getClass());
    this.i.a(this, this.b);
  }

  public final void u()
  {
    new StringBuilder("unregisterPhoneStateTracker(), clazz = ").append(getClass());
    this.i.b(this, this.b);
  }

  protected final boolean v()
  {
    return !this.i.a(this.b);
  }

  public final v<T> w()
  {
    return this.g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.y
 * JD-Core Version:    0.6.2
 */