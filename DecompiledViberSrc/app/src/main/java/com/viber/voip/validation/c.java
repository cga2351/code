package com.viber.voip.validation;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class c<V, R extends h>
  implements e.a, Runnable
{
  private static final Logger f = ViberEnv.getLogger();
  protected e<V> a;
  protected CopyOnWriteArrayList<b> b = new CopyOnWriteArrayList();
  protected CopyOnWriteArrayList<e.a> c = new CopyOnWriteArrayList();
  protected i<R> d;
  protected boolean e;
  private Handler g;
  private long h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1 != f()) || (paramBoolean2 != a()))
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
        ((b)localIterator.next()).a(this);
    }
  }

  private void b(R paramR)
  {
    boolean bool1 = f();
    boolean bool2 = a();
    this.k = false;
    if (this.j)
    {
      this.j = false;
      b(true);
    }
    while (true)
    {
      this.l = false;
      a(bool1, bool2);
      return;
      if (!this.l)
      {
        this.e = paramR.a();
        if (this.d != null)
          this.d.a(paramR);
      }
    }
  }

  private void b(boolean paramBoolean)
  {
    this.e = false;
    if ((!paramBoolean) && (this.d != null))
      this.d.a();
    this.k = true;
    final Object localObject = this.a.a();
    this.g.post(new Runnable()
    {
      public void run()
      {
        c.this.b(localObject);
      }
    });
  }

  private void g()
  {
    boolean bool = f();
    h();
    av.e.a.a().postDelayed(this, this.h);
    this.i = true;
    this.e = false;
    if ((!bool) && (this.d != null))
      this.d.a();
  }

  private void h()
  {
    if (this.i)
    {
      av.e.a.a().removeCallbacks(this);
      this.i = false;
    }
  }

  private boolean i()
  {
    h localh = a(this.a.a());
    if (localh != null)
    {
      if (this.d != null)
        this.d.a(localh);
      this.e = localh.a();
      return true;
    }
    return false;
  }

  public c<V, R> a(long paramLong)
  {
    this.h = paramLong;
    return this;
  }

  public c<V, R> a(Handler paramHandler)
  {
    this.g = paramHandler;
    return this;
  }

  public c<V, R> a(b paramb)
  {
    this.b.add(paramb);
    return this;
  }

  public c<V, R> a(e.a parama)
  {
    this.c.add(parama);
    return this;
  }

  public c<V, R> a(e<V> parame)
  {
    this.a = parame;
    parame.a(this);
    return this;
  }

  public c<V, R> a(i<R> parami)
  {
    this.d = parami;
    return this;
  }

  protected R a(V paramV)
  {
    return null;
  }

  protected void a(final R paramR)
  {
    av.e.a.a().post(new Runnable()
    {
      public void run()
      {
        c.a(c.this, paramR);
      }
    });
  }

  void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public boolean a()
  {
    return this.e;
  }

  void b()
  {
    if (this.a != null)
      this.a.a(null);
    this.c.clear();
    this.b.clear();
  }

  protected void b(V paramV)
  {
    throw new UnsupportedOperationException("validate() returned null but async validation not implemented");
  }

  public void c()
  {
    if (!this.m)
      return;
    boolean bool1 = f();
    boolean bool2 = a();
    if (this.k)
      this.l = true;
    if (i())
    {
      h();
      this.j = false;
    }
    while (true)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        ((e.a)localIterator.next()).c();
      if (this.k)
        this.j = true;
      else
        g();
    }
    a(bool1, bool2);
  }

  void d()
  {
    boolean bool1 = f();
    boolean bool2 = a();
    if (!i())
      b(false);
    a(bool1, bool2);
  }

  protected void e()
  {
    b(false);
  }

  protected boolean f()
  {
    if (this.l)
      return this.j;
    return (this.k) || (this.i);
  }

  public void run()
  {
    this.i = false;
    b(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.validation.c
 * JD-Core Version:    0.6.2
 */