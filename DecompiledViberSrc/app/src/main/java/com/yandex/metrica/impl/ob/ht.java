package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.yandex.metrica.impl.bx;

public class ht
{
  private final bx a;
  private final np b;
  private final ii c;
  private final hu d;
  private final hl e;
  private final om f;
  private final Handler g;
  private hp h;
  private boolean i;
  private final Runnable j = new Runnable()
  {
    public void run()
    {
      ht.this.d();
      ht.a(ht.this);
    }
  };

  public ht(Context paramContext, bx parambx, np paramnp, ii paramii, hl paramhl, Looper paramLooper, hp paramhp)
  {
    this(parambx, paramnp, paramii, new hu(paramContext), new om(), paramhl, new Handler(paramLooper), paramhp);
  }

  ht(bx parambx, np paramnp, ii paramii, hu paramhu, om paramom, hl paramhl, Handler paramHandler, hp paramhp)
  {
    this.a = parambx;
    this.b = paramnp;
    this.c = paramii;
    this.d = paramhu;
    this.f = paramom;
    this.e = paramhl;
    this.g = paramHandler;
    this.h = paramhp;
  }

  private void e()
  {
    if ((this.h != null) && (this.h.l > 0L))
      this.g.postDelayed(this.j, this.h.l);
  }

  private void f()
  {
    this.g.removeCallbacks(this.j);
  }

  public void a()
  {
    c();
  }

  public void a(hp paramhp)
  {
    this.h = paramhp;
    c();
  }

  public void b()
  {
    f();
  }

  public void c()
  {
    if ((this.h != null) && (this.h.m));
    for (boolean bool = true; ; bool = false)
    {
      if (this.i != bool)
      {
        this.i = bool;
        if (!this.i)
          break;
        this.i = true;
        e();
      }
      return;
    }
    this.i = false;
    f();
  }

  public void d()
  {
    final hv localhv = new hv();
    localhv.a(this.f.a());
    localhv.a(this.a.a());
    this.b.a(new nh()
    {
      public void a(ng[] paramAnonymousArrayOfng)
      {
        localhv.b(nz.a(paramAnonymousArrayOfng));
      }
    });
    this.d.a(localhv);
    this.c.a();
    this.e.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ht
 * JD-Core Version:    0.6.2
 */