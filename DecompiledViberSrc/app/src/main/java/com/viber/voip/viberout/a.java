package com.viber.voip.viberout;

import android.os.Handler;
import com.viber.common.b.c;
import com.viber.common.b.d;
import com.viber.common.b.e;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.billing.b.a;
import com.viber.voip.billing.b.h;
import com.viber.voip.billing.b.i;
import com.viber.voip.settings.d.bj;
import com.viber.voip.util.da;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class a
{
  private static final Logger b = ViberEnv.getLogger();
  b.i a;
  private Set<a> c = Collections.newSetFromMap(new WeakHashMap());

  public static a a()
  {
    return b.a();
  }

  private void a(b.a parama)
  {
    if (parama.d())
    {
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.g.a(f()));
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.g.a(true));
    }
  }

  private void b(b.a parama)
  {
    d.bj.d.a(parama.g());
    d.bj.e.a((float)parama.f());
    d.bj.f.a(parama.e());
    com.viber.common.b.b localb = d.bj.g;
    if (parama.f() <= 0.5D);
    for (boolean bool = true; ; bool = false)
    {
      localb.a(bool);
      return;
    }
  }

  private void c(long paramLong)
  {
    d.bj.h.a(paramLong);
  }

  private void c(b.a parama)
  {
    d.bj.d.a("no_balance");
    d.bj.e.e();
    d.bj.g.b();
  }

  private boolean j()
  {
    return System.currentTimeMillis() - d.bj.h.d() > 3600000L;
  }

  private boolean k()
  {
    return this.a != null;
  }

  private void l()
  {
    c(System.currentTimeMillis());
  }

  public void a(long paramLong)
  {
    av.e.a.a().post(new b(this, paramLong));
  }

  public void a(a parama)
  {
    if (parama == null);
    do
    {
      return;
      this.c.add(parama);
    }
    while (!k());
    parama.onFetchBalanceStarted();
  }

  public void b(a parama)
  {
    if (parama != null)
      this.c.remove(parama);
  }

  public boolean b()
  {
    return !da.a(d());
  }

  public void c(a parama)
  {
    parama.setLocalBalance(d(), g());
  }

  public boolean c()
  {
    return (b()) || (g() > 0);
  }

  public String d()
  {
    return d.bj.d.d();
  }

  public boolean e()
  {
    return d.bj.e.d() > 0.0F;
  }

  public float f()
  {
    return d.bj.e.d();
  }

  public int g()
  {
    return d.bj.f.d();
  }

  public void h()
  {
    if (k());
    while (true)
    {
      return;
      if (j())
        break;
      Iterator localIterator2 = this.c.iterator();
      while (localIterator2.hasNext())
        ((a)localIterator2.next()).onFetchBalanceCanceled();
    }
    Iterator localIterator1 = this.c.iterator();
    while (localIterator1.hasNext())
      ((a)localIterator1.next()).onFetchBalanceStarted();
    this.a = new b.i()
    {
      public void a(b.a paramAnonymousa)
      {
        boolean bool1 = true;
        a.this.a = null;
        String str;
        boolean bool3;
        com.viber.common.b.b localb;
        if (paramAnonymousa.b())
        {
          d.bj.f.a(paramAnonymousa.e());
          if (paramAnonymousa.d())
          {
            a.a(a.this, paramAnonymousa);
            a.c(a.this, paramAnonymousa);
            str = a.this.d();
            bool3 = bool1;
            localb = d.bj.a;
            if (paramAnonymousa.c())
              break label162;
          }
        }
        while (true)
        {
          localb.a(bool1);
          Iterator localIterator = a.a(a.this).iterator();
          while (localIterator.hasNext())
            ((a.a)localIterator.next()).onFetchBalanceFinished(paramAnonymousa, str);
          a.b(a.this, paramAnonymousa);
          break;
          if (paramAnonymousa.a() == b.h.b);
          for (boolean bool2 = bool1; ; bool2 = false)
          {
            bool3 = bool2;
            str = null;
            break;
          }
          label162: bool1 = false;
        }
        if (bool3)
          a.b(a.this);
      }
    };
    com.viber.voip.billing.b.a().a(this.a);
  }

  public void i()
  {
    d.bj.d.a("");
    d.bj.g.a(false);
  }

  public static abstract interface a
  {
    public abstract void onFetchBalanceCanceled();

    public abstract void onFetchBalanceFinished(b.a parama, String paramString);

    public abstract void onFetchBalanceStarted();

    public abstract void setLocalBalance(String paramString, int paramInt);
  }

  private static final class b
  {
    private static final a a = new a(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a
 * JD-Core Version:    0.6.2
 */