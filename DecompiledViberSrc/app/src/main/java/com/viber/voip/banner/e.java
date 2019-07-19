package com.viber.voip.banner;

import android.content.Context;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.banner.d.g;
import com.viber.voip.banner.view.a.c.a;
import com.viber.voip.banner.view.f.a;
import com.viber.voip.settings.d.ad;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.cj.b;

public abstract class e
  implements g.a, c.a, f.a
{
  static final Logger a = ViberEnv.getLogger();
  private com.viber.voip.banner.d.b b;
  private dagger.a<com.viber.voip.analytics.story.g.a> c;
  private d d;
  private b e;
  private a f;
  private Handler g = av.a(av.e.e);
  private Handler h = av.a(av.e.a);
  private boolean i;
  private ArrayMap<com.viber.voip.banner.d.c, com.viber.voip.banner.view.f> j = new ArrayMap();
  private LongSparseArray<com.viber.voip.banner.d.c> k = new LongSparseArray();
  private LongSparseArray<com.viber.voip.banner.view.a.c> l = new LongSparseArray();
  private cj.b m = new cj.a()
  {
    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((paramAnonymousInt2 != -1) && (e.a(e.this)))
      {
        e.a(e.this, false);
        e.this.c();
      }
    }
  };

  protected e()
  {
  }

  public e(com.viber.voip.banner.d.b paramb, dagger.a<com.viber.voip.analytics.story.g.a> parama)
  {
    this.b = paramb;
    this.c = parama;
    this.d = new d(ViberApplication.getApplication());
  }

  private void a(final long paramLong)
  {
    if ((com.viber.voip.banner.d.c)this.k.get(paramLong) == null)
      return;
    this.g.post(new Runnable()
    {
      public void run()
      {
        e.c(e.this).a(paramLong);
      }
    });
  }

  private void a(long paramLong, int paramInt, String paramString)
  {
    Engine localEngine = ViberApplication.getInstance().getEngine(false);
    if (localEngine.isInitialized())
      localEngine.getPhoneController().handleReportBannerStatistics(paramLong, paramInt, paramString);
  }

  private void a(long paramLong1, final long paramLong2)
  {
    com.viber.voip.banner.d.c localc = (com.viber.voip.banner.d.c)this.k.get(paramLong1);
    if (localc == null)
      return;
    this.g.post(new Runnable()
    {
      public void run()
      {
        e.c(e.this).a(paramLong2, this.b);
      }
    });
  }

  private void a(final com.viber.voip.banner.d.c paramc, final com.viber.voip.banner.d.f paramf)
  {
    com.viber.voip.banner.view.f localf = (com.viber.voip.banner.view.f)this.j.get(paramc);
    if ((localf != null) && (localf.getBannerId() == paramf.getId()));
    for (int n = 1; n != 0; n = 0)
      return;
    this.h.post(new Runnable()
    {
      public void run()
      {
        e.b(e.this, paramc, paramf);
      }
    });
  }

  private void a(String paramString)
  {
    if ("Blast Spam Blocked".equals(paramString))
      ((com.viber.voip.analytics.story.g.a)this.c.get()).g("Blocked");
    do
    {
      return;
      if ("Blast Spam Unblocked".equals(paramString))
      {
        ((com.viber.voip.analytics.story.g.a)this.c.get()).g("Unblocked");
        return;
      }
    }
    while (!"Blast Spam Warning".equals(paramString));
    ((com.viber.voip.analytics.story.g.a)this.c.get()).g("Warning");
  }

  private void a(String paramString1, String paramString2)
  {
    int n;
    if (paramString1 != null)
    {
      n = -1;
      switch (paramString1.hashCode())
      {
      default:
      case 1706095965:
      case -301866908:
      case -1442987251:
      }
    }
    while (true)
      switch (n)
      {
      default:
        return;
        if (paramString1.equals("Blast Spam Blocked"))
        {
          n = 0;
          continue;
          if (paramString1.equals("Blast Spam Unblocked"))
          {
            n = 1;
            continue;
            if (paramString1.equals("Blast Spam Warning"))
              n = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    ((com.viber.voip.analytics.story.g.a)this.c.get()).h(paramString2);
  }

  private void b(com.viber.voip.banner.d.c paramc)
  {
    com.viber.voip.banner.view.f localf = (com.viber.voip.banner.view.f)this.j.get(paramc);
    if (localf == null);
    do
    {
      FrameLayout localFrameLayout;
      do
      {
        return;
        localFrameLayout = com.viber.voip.banner.view.c.a(paramc, a());
      }
      while (localFrameLayout == null);
      localFrameLayout.removeView(localf);
      this.j.remove(paramc);
      this.k.remove(localf.getBannerId());
      com.viber.voip.banner.view.c.a(localFrameLayout);
    }
    while (this.e == null);
    this.e.onRemoteBannerVisibilityChange(false, paramc, localf);
  }

  private void b(com.viber.voip.banner.d.c paramc, com.viber.voip.banner.d.f paramf)
  {
    if (b() == null);
    while (true)
    {
      return;
      if (this.k.indexOfKey(paramf.getId()) >= 0);
      for (int n = 1; n == 0; n = 0)
      {
        this.k.put(paramf.getId(), paramc);
        com.viber.voip.banner.view.a.c localc = (com.viber.voip.banner.view.a.c)paramf.a().a(b());
        this.l.put(paramf.getId(), localc);
        localc.a(paramf, this);
        return;
      }
    }
  }

  private void d(final g paramg, final com.viber.voip.banner.d.c paramc)
  {
    if (d.ad.A.d())
    {
      a(paramg, paramc);
      return;
    }
    if ((this.e != null) && (this.e.shouldDisplayBanner(paramg, paramc, this.b)))
    {
      this.g.post(new Runnable()
      {
        public void run()
        {
          com.viber.voip.banner.d.f localf = e.c(e.this).a(paramg, e.b(e.this), paramc);
          if (localf == null)
          {
            e.d(e.this).post(new Runnable()
            {
              public void run()
              {
                e.this.a(e.2.this.a, e.2.this.b);
              }
            });
            return;
          }
          e.a(e.this, paramc, localf);
        }
      });
      return;
    }
    a(paramg, paramc);
  }

  protected abstract ViewGroup a();

  public void a(long paramLong, com.viber.voip.banner.d.b paramb, com.viber.voip.banner.d.c paramc)
  {
    if (this.b == paramb)
      c();
  }

  void a(g paramg, com.viber.voip.banner.d.c paramc)
  {
  }

  public void a(a parama)
  {
    this.f = parama;
  }

  public void a(b paramb)
  {
    this.e = paramb;
  }

  public boolean a(com.viber.voip.banner.d.c paramc)
  {
    return this.j.get(paramc) != null;
  }

  protected abstract Context b();

  void b(g paramg, com.viber.voip.banner.d.c paramc)
  {
  }

  public void c()
  {
    if (!cj.b(b()))
    {
      this.i = true;
      e();
      return;
    }
    d(g.a, com.viber.voip.banner.d.c.b);
  }

  void c(g paramg, com.viber.voip.banner.d.c paramc)
  {
  }

  public void d()
  {
    this.i = false;
    b(com.viber.voip.banner.d.c.b);
  }

  void e()
  {
  }

  public void m()
  {
    h.a().a(this);
    cj.a(b()).a(this.m);
  }

  public void n()
  {
    h.a().b(this);
    cj.a(b()).b(this.m);
    this.e = null;
    this.f = null;
  }

  public com.viber.voip.banner.d.b o()
  {
    return this.b;
  }

  public boolean onBannerAction(long paramLong, String paramString, int paramInt, com.viber.voip.banner.view.f paramf)
  {
    if (this.f != null)
      this.f.onRemoteBannerAction(paramf);
    if ((g.a == paramf.getRemotePromoType()) && (!cj.b(b())))
    {
      com.viber.voip.ui.dialogs.f.b().a(b());
      return false;
    }
    String str;
    if (g.a == paramf.getRemotePromoType())
    {
      str = (String)paramf.getTag();
      switch (paramInt)
      {
      default:
      case 0:
      case 1:
      }
    }
    while (true)
    {
      if (g.a == paramf.getRemotePromoType())
      {
        a(paramf.getBannerId(), paramf.getMessageToken());
        com.viber.voip.banner.d.c localc = (com.viber.voip.banner.d.c)this.k.get(paramf.getBannerId());
        b(localc);
        b(g.a, localc);
      }
      return true;
      a(paramLong, 2, str);
      a(str, "Learn More");
      continue;
      a(paramLong, 3, str);
    }
  }

  public void onBannerCloseAction(long paramLong, com.viber.voip.banner.view.f paramf)
  {
    String str = (String)paramf.getTag();
    if (g.a == paramf.getRemotePromoType())
    {
      a(paramLong, 1, str);
      a(str, "Close");
    }
    if (paramf.getRemotePromoType() == g.a)
      a(paramf.getBannerId(), paramf.getMessageToken());
    while (true)
    {
      com.viber.voip.banner.d.c localc = (com.viber.voip.banner.d.c)this.k.get(paramf.getBannerId());
      b(localc);
      b(paramf.getRemotePromoType(), localc);
      return;
      a(paramf.getBannerId());
    }
  }

  public void onRemoteBannerError(long paramLong, com.viber.voip.banner.view.f paramf, int paramInt)
  {
    this.l.remove(paramf.getBannerId());
    if (paramInt == 1)
    {
      if (paramf.getRemotePromoType() != g.a)
        break label51;
      a(paramf.getBannerId(), paramf.getMessageToken());
    }
    while (true)
    {
      this.k.remove(paramf.getBannerId());
      return;
      label51: a(paramf.getBannerId());
    }
  }

  public void onRemoteBannerReady(long paramLong, com.viber.voip.banner.view.f paramf)
  {
    this.l.remove(paramf.getBannerId());
    com.viber.voip.banner.d.c localc = (com.viber.voip.banner.d.c)this.k.get(paramf.getBannerId());
    if (localc == null);
    String str;
    do
    {
      FrameLayout localFrameLayout;
      do
      {
        return;
        b(localc);
        str = (String)paramf.getTag();
        if (paramf.isDummyBanner())
        {
          if (g.a == paramf.getRemotePromoType())
            a(paramLong, 0, str);
          if (paramf.getRemotePromoType() == g.a)
            a(paramf.getBannerId(), paramf.getMessageToken());
          while (true)
          {
            this.k.remove(paramf.getBannerId());
            return;
            a(paramf.getBannerId());
          }
        }
        localFrameLayout = com.viber.voip.banner.view.c.a(localc, a(), b());
      }
      while (localFrameLayout == null);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramf.getLayoutParams());
      if (localc == com.viber.voip.banner.d.c.b)
        localLayoutParams.gravity = 80;
      localFrameLayout.addView(paramf, localLayoutParams);
      this.j.put(localc, paramf);
      paramf.setActionListener(this);
      c(paramf.getRemotePromoType(), localc);
      if (this.e != null)
      {
        this.e.onRemoteBannerVisibilityChange(true, localc, paramf);
        if (g.a == paramf.getRemotePromoType())
          a(paramLong, 0, str);
      }
    }
    while (g.a != paramf.getRemotePromoType());
    a(str);
  }

  public dagger.a<com.viber.voip.analytics.story.g.a> p()
  {
    return this.c;
  }

  public static abstract interface a
  {
    public abstract void onRemoteBannerAction(com.viber.voip.banner.view.b paramb);
  }

  public static abstract interface b
  {
    public abstract void onRemoteBannerVisibilityChange(boolean paramBoolean, com.viber.voip.banner.d.c paramc, com.viber.voip.banner.view.b paramb);

    public abstract boolean shouldDisplayBanner(g paramg, com.viber.voip.banner.d.c paramc, com.viber.voip.banner.d.b paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.e
 * JD-Core Version:    0.6.2
 */