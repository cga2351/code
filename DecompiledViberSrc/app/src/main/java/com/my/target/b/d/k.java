package com.my.target.b.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.my.target.b.c.a.i;
import com.my.target.cz;
import com.my.target.dc;
import com.my.target.dd;
import com.my.target.dd.a;
import com.my.target.dh;
import com.my.target.dl;
import com.my.target.dp;
import java.util.List;

public final class k
  implements j
{
  private final i a;
  private final d b;
  private final dd c;
  private dc d;
  private dl e;
  private e f;
  private h g;
  private long h;
  private long i;
  private b j;

  private k(i parami, boolean paramBoolean, Context paramContext)
  {
    this.a = parami;
    c localc = new c(this);
    com.my.target.k localk = parami.I();
    if (!parami.P().isEmpty())
    {
      dl localdl = new dl(paramContext);
      this.e = localdl;
      this.c = localdl;
      this.b = new d(this.c);
      this.c.setInterstitialPromoViewListener(localc);
      this.c.setBanner(parami);
      this.c.getCloseButton().setOnClickListener(new a(this));
      this.c.setClickArea(parami.B());
      if ((this.d != null) && (localk != null))
      {
        this.g = h.a(localk, this.d);
        this.g.a(localk, paramContext);
        if (localk.K())
          this.i = 0L;
      }
      if ((localk == null) || (!localk.K()))
      {
        this.h = (()(1000.0F * parami.E()));
        if (this.h <= 0L)
          break label347;
        dp.a("banner will be allowed to close in " + this.h + " millis");
        a(this.h);
      }
    }
    while (true)
    {
      List localList = parami.P();
      if ((!localList.isEmpty()) && (this.e != null))
        this.f = e.a(localList, this.e);
      return;
      if ((localk != null) && (parami.Q() == 1))
      {
        dh localdh = new dh(paramContext, paramBoolean);
        this.d = localdh;
        this.c = localdh;
        break;
      }
      cz localcz = new cz(paramContext, paramBoolean);
      this.d = localcz;
      this.c = localcz;
      break;
      label347: dp.a("banner is allowed to close");
      this.c.f();
    }
  }

  public static k a(i parami, boolean paramBoolean, Context paramContext)
  {
    return new k(parami, paramBoolean, paramContext);
  }

  private void a(long paramLong)
  {
    if (this.d != null)
    {
      this.d.getView().removeCallbacks(this.b);
      this.i = System.currentTimeMillis();
      this.d.getView().postDelayed(this.b, paramLong);
    }
  }

  public final b a()
  {
    return this.j;
  }

  public final void a(b paramb)
  {
    this.j = paramb;
    if (this.g != null)
      this.g.a(paramb);
    if (this.f != null)
      this.f.a(paramb);
  }

  public final void a(boolean paramBoolean)
  {
    if (this.g != null)
      this.g.a(paramBoolean);
  }

  public final void c()
  {
    if (this.g != null)
      this.g.c();
    this.c.getView().removeCallbacks(this.b);
    if (this.i > 0L)
    {
      long l = System.currentTimeMillis() - this.i;
      if ((l > 0L) && (l < this.h))
        this.h -= l;
    }
    else
    {
      return;
    }
    this.h = 0L;
  }

  public final void e()
  {
    if (this.g != null)
      this.g.b();
  }

  public final View f()
  {
    return this.c.getView();
  }

  final h g()
  {
    return this.g;
  }

  final void h()
  {
    this.g = null;
  }

  public final i i()
  {
    return this.a;
  }

  public final boolean j()
  {
    return (this.g == null) || (this.g.e());
  }

  public final void k()
  {
    if (this.g != null)
      this.g.a(this.a);
  }

  public final void l_()
  {
    if (this.g != null)
      this.g.a();
  }

  public final void m_()
  {
    if ((this.g == null) && (this.h > 0L))
      a(this.h);
  }

  private static final class a
    implements View.OnClickListener
  {
    private k a;

    a(k paramk)
    {
      this.a = paramk;
    }

    public final void onClick(View paramView)
    {
      h localh = this.a.g();
      if (localh != null)
        localh.d();
      k.b localb = this.a.a();
      if (localb != null)
        localb.b();
    }
  }

  public static abstract interface b extends j.a
  {
    public abstract void c();

    public abstract void d();
  }

  private static final class c
    implements dd.a
  {
    private final k a;

    c(k paramk)
    {
      this.a = paramk;
    }

    public final void a()
    {
      k.b localb = this.a.a();
      if (localb != null)
        localb.a(this.a.i(), null, this.a.f().getContext());
    }

    public final void a(boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        h localh = this.a.g();
        if (localh != null)
        {
          localh.a(this.a.i());
          localh.b();
        }
        this.a.h();
      }
    }
  }

  private static final class d
    implements Runnable
  {
    private final dd a;

    d(dd paramdd)
    {
      this.a = paramdd;
    }

    public final void run()
    {
      dp.a("banner became just closeable");
      this.a.f();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.d.k
 * JD-Core Version:    0.6.2
 */