package com.viber.voip.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.viber.voip.banner.notificationsoff.f.a;
import com.viber.voip.banner.notificationsoff.f.b;
import com.viber.voip.banner.notificationsoff.f.c;
import com.viber.voip.settings.d.k;

public class b extends e
  implements com.viber.voip.banner.notificationsoff.f, f.c
{
  private final e b;
  private final com.viber.voip.banner.notificationsoff.g c;
  private final f.a d;
  private final dagger.a<com.viber.voip.notif.f> e;
  private final com.viber.voip.analytics.g f;
  private com.viber.voip.banner.notificationsoff.f g;
  private f.c h;
  private boolean i;
  private LayoutInflater j;

  public b(e parame, f.a parama, dagger.a<com.viber.voip.notif.f> parama1, com.viber.voip.analytics.g paramg, LayoutInflater paramLayoutInflater)
  {
    super(parame.o(), parame.p());
    this.j = paramLayoutInflater;
    this.b = parame;
    this.d = parama;
    this.c = new com.viber.voip.banner.notificationsoff.g(parama, parama1);
    this.g = new com.viber.voip.banner.notificationsoff.d();
    this.e = parama1;
    this.f = paramg;
  }

  private void a(int paramInt)
  {
    com.viber.voip.banner.d.b localb = o();
    if (com.viber.voip.banner.d.b.b == localb)
    {
      d.k.c.a(paramInt);
      return;
    }
    if (com.viber.voip.banner.d.b.c == localb)
    {
      d.k.d.a(paramInt);
      return;
    }
    throw new IllegalStateException("unsupported location: " + o());
  }

  private void a(com.viber.voip.banner.d.g paramg)
  {
    if (com.viber.voip.banner.d.g.a == paramg)
    {
      a(0);
      this.i = false;
      t();
    }
  }

  private int q()
  {
    com.viber.voip.banner.d.b localb = o();
    if (com.viber.voip.banner.d.b.b == localb)
      return d.k.c.d();
    if (com.viber.voip.banner.d.b.c == localb)
      return d.k.d.d();
    throw new IllegalStateException("unsupported location: " + o());
  }

  private void r()
  {
    FrameLayout localFrameLayout = com.viber.voip.banner.view.c.a(com.viber.voip.banner.d.c.b, a(), b());
    if (localFrameLayout == null)
      return;
    this.g.a(null);
    this.g = new com.viber.voip.banner.notificationsoff.d();
    com.viber.voip.banner.view.c.a(localFrameLayout);
  }

  private void s()
  {
    if (!this.g.l());
    FrameLayout localFrameLayout;
    do
    {
      do
        return;
      while (!this.d.a());
      localFrameLayout = com.viber.voip.banner.view.c.a(com.viber.voip.banner.d.c.b, a(), b());
    }
    while (localFrameLayout == null);
    this.g = new com.viber.voip.banner.notificationsoff.b(new f.b()
    {
      public View a(int paramAnonymousInt)
      {
        View localView = this.a.a(paramAnonymousInt);
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = 80;
        return localView;
      }

      public boolean a(View paramAnonymousView)
      {
        if (2 != b.a(b.this))
          return false;
        return this.a.a(paramAnonymousView);
      }

      public boolean b(View paramAnonymousView)
      {
        if (2 != b.a(b.this))
          return false;
        return this.a.b(paramAnonymousView);
      }
    }
    , this.d, this.e);
    this.g.a(this);
  }

  private void t()
  {
    if (this.i);
    while ((q() != 0) || (!k()))
      return;
    a(2);
    c();
  }

  protected ViewGroup a()
  {
    return this.b.a();
  }

  void a(com.viber.voip.banner.d.g paramg, com.viber.voip.banner.d.c paramc)
  {
    super.a(paramg, paramc);
    a(paramg);
  }

  public void a(f.c paramc)
  {
    this.h = paramc;
  }

  public void a(boolean paramBoolean, com.viber.voip.banner.d.c paramc)
  {
    if (this.h != null)
      this.h.a(paramBoolean, paramc);
    if (!paramBoolean)
    {
      r();
      if (!k())
      {
        a(0);
        c();
      }
    }
  }

  protected Context b()
  {
    return this.b.b();
  }

  void b(com.viber.voip.banner.d.g paramg, com.viber.voip.banner.d.c paramc)
  {
    super.b(paramg, paramc);
    a(paramg);
  }

  public void c()
  {
    if (this.i)
      return;
    if (2 == q())
    {
      if (this.c.f())
        this.c.d();
      if (!k())
      {
        a(false, com.viber.voip.banner.d.c.b);
        return;
      }
      s();
      f();
      return;
    }
    super.c();
  }

  void c(com.viber.voip.banner.d.g paramg, com.viber.voip.banner.d.c paramc)
  {
    super.c(paramg, paramc);
    if ((com.viber.voip.banner.d.g.a == paramg) && (com.viber.voip.banner.d.c.b == paramc))
    {
      a(1);
      this.i = false;
    }
  }

  public void d()
  {
    if (2 == q())
    {
      g();
      return;
    }
    super.d();
  }

  void e()
  {
    super.e();
    this.i = false;
    if ((q() == 0) && (!a(com.viber.voip.banner.d.c.b)))
      t();
  }

  public void f()
  {
    this.g.f();
  }

  public void g()
  {
    this.g.g();
  }

  public void h()
  {
    if ((2 == q()) && (k()))
      c();
  }

  public void i()
  {
    if (this.i);
    do
    {
      return;
      this.c.c();
    }
    while (!k());
    t();
  }

  public int j()
  {
    return this.g.j();
  }

  public boolean k()
  {
    return this.c.e();
  }

  public boolean l()
  {
    return this.g.l();
  }

  public void onRemoteBannerError(long paramLong, com.viber.voip.banner.view.f paramf, int paramInt)
  {
    super.onRemoteBannerError(paramLong, paramf, paramInt);
    a(paramf.getRemotePromoType());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.b
 * JD-Core Version:    0.6.2
 */