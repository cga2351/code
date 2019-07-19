package com.viber.voip.ads.b.c;

import android.os.Handler;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.f;
import java.lang.ref.WeakReference;

public abstract class c<T extends com.viber.voip.ads.b.c.c.a>
  implements b<T>
{
  private static final e h = ViberEnv.getLogger();
  protected final com.viber.voip.ads.b.b.b.c a;
  protected final com.viber.voip.ads.b.b.b.c.a b;
  protected final f c;
  protected final com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> d;
  protected final Handler e;
  protected final com.viber.voip.ads.b.c.c.a.a<T> f;
  protected final Object g = new Object();
  private com.viber.voip.ads.b.b.b.a i;
  private c<T>.b j;

  public c(com.viber.voip.ads.b.b.b.c paramc, com.viber.voip.ads.b.b.b.c.a parama, f paramf, com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> parama1, Handler paramHandler, com.viber.voip.ads.b.c.c.a.a<T> parama2)
  {
    this.a = paramc;
    this.b = parama;
    this.c = paramf;
    this.d = parama1;
    this.e = paramHandler;
    this.f = parama2;
  }

  protected abstract com.viber.voip.ads.b.a.a.a.b a(b.a parama);

  protected com.viber.voip.ads.b.b.a.c a(a<T> parama)
  {
    return new a(parama, this);
  }

  protected final void a(com.viber.voip.ads.b.b.b.a parama)
  {
    this.i = parama;
  }

  protected void a(b.a parama, com.viber.voip.ads.b.b.a.c paramc)
  {
    if (this.j != null)
      this.j.e();
    if ((parama.b()) && (paramc != null) && (a()))
    {
      paramc.a(b());
      return;
    }
    com.viber.voip.ads.b.a.a.a.b localb = a(parama);
    this.j = new b(paramc, null);
    f();
    this.e.post(new c(this.d, this.a, localb, this.j, null));
  }

  public void a(b.a parama, a<T> parama1)
  {
    a(parama, a(parama1));
  }

  protected boolean a()
  {
    return b() != null;
  }

  protected boolean a(com.viber.voip.ads.b.b.b.b paramb, com.viber.voip.ads.b.b.a.c paramc)
  {
    return false;
  }

  protected final com.viber.voip.ads.b.b.b.a b()
  {
    return this.i;
  }

  protected boolean b(com.viber.voip.ads.b.b.b.a parama)
  {
    return false;
  }

  protected final void c()
  {
    this.i = null;
  }

  public boolean d()
  {
    while (true)
    {
      synchronized (this.g)
      {
        if (this.j != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public boolean e()
  {
    return ((this.c == null) || (this.c.e())) && (this.b.a(this.a) != 0);
  }

  protected void f()
  {
  }

  private static class a<VM extends com.viber.voip.ads.b.c.c.a>
    implements com.viber.voip.ads.b.b.a.c
  {
    private WeakReference<c<VM>> a;
    private WeakReference<a<VM>> b;

    a(a<VM> parama, c<VM> paramc)
    {
      this.a = new WeakReference(paramc);
      this.b = new WeakReference(parama);
    }

    public void a()
    {
      com.viber.voip.ads.b.b.a.b.a(this);
    }

    public void a(com.viber.voip.ads.b.b.b.a parama)
    {
      a locala = (a)this.b.get();
      c localc = (c)this.a.get();
      if (locala == null);
      while (localc == null)
        return;
      locala.a((com.viber.voip.ads.b.c.c.a)localc.f.a(parama));
    }

    public void a(com.viber.voip.ads.b.b.b.b paramb)
    {
      a locala = (a)this.b.get();
      c localc = (c)this.a.get();
      if (locala == null);
      while (localc == null)
        return;
      locala.a();
    }

    public void b()
    {
      com.viber.voip.ads.b.b.a.b.b(this);
    }

    public void c()
    {
      com.viber.voip.ads.b.b.a.b.c(this);
    }

    public void d()
    {
      com.viber.voip.ads.b.b.a.b.d(this);
    }
  }

  private class b
    implements com.viber.voip.ads.b.b.a.c
  {
    private com.viber.voip.ads.b.b.a.c b;

    private b(com.viber.voip.ads.b.b.a.c arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void a()
    {
      if (this.b != null)
        this.b.a();
    }

    public void a(com.viber.voip.ads.b.b.b.a parama)
    {
      if (this != c.a(c.this));
      do
      {
        return;
        c.a(c.this, null);
        c.this.a(parama);
      }
      while ((c.this.b(parama)) || (this.b == null));
      this.b.a(parama);
    }

    public void a(com.viber.voip.ads.b.b.b.b paramb)
    {
      if (this != c.a(c.this));
      do
      {
        return;
        c.a(c.this, null);
      }
      while ((c.this.a(paramb, this.b)) || (this.b == null));
      this.b.a(paramb);
    }

    public void b()
    {
      if (this.b != null)
        this.b.b();
    }

    public void c()
    {
      if (this.b != null)
        this.b.c();
    }

    public void d()
    {
      if (this.b != null)
        this.b.d();
    }

    void e()
    {
      this.b = null;
      c.a(c.this, null);
    }
  }

  private static class c
    implements Runnable
  {
    private final com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> a;
    private final com.viber.voip.ads.b.b.b.c b;
    private final com.viber.voip.ads.b.a.a.a.b c;
    private final com.viber.voip.ads.b.b.a.c d;

    private c(com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> parama, com.viber.voip.ads.b.b.b.c paramc, com.viber.voip.ads.b.a.a.a.b paramb, com.viber.voip.ads.b.b.a.c paramc1)
    {
      this.a = parama;
      this.b = paramc;
      this.c = paramb;
      this.d = paramc1;
    }

    public void run()
    {
      this.a.a(this.b, this.c, this.d);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.c
 * JD-Core Version:    0.6.2
 */