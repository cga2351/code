package a.a;

import android.content.Context;
import com.appboy.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

public class b
{
  private static final String c = com.appboy.f.c.a(b.class);
  AtomicBoolean a = new AtomicBoolean(false);
  long b = 0L;
  private final ax d;
  private final gq e;
  private final au f;
  private final Context g;
  private final dh h;
  private final cu i;
  private final dd j;
  private final fk k;
  private final al l;
  private final am m;
  private final ba n;
  private final d o;
  private final fm p;
  private AtomicBoolean q = new AtomicBoolean(false);
  private s r;

  public b(Context paramContext, ax paramax, gq paramgq, ap paramap, dh paramdh, cu paramcu, dd paramdd, fk paramfk, fm paramfm, al paramal, am paramam, ba paramba, d paramd)
  {
    this.d = paramax;
    this.e = paramgq;
    this.f = paramap;
    this.g = paramContext;
    this.h = paramdh;
    this.i = paramcu;
    this.j = paramdd;
    this.k = paramfk;
    this.p = paramfm;
    this.l = paramal;
    this.m = paramam;
    this.n = paramba;
    this.o = paramd;
  }

  private void a(p paramp)
  {
    try
    {
      bh localbh = paramp.a();
      bp localbp = bp.a(localbh.f());
      localbp.a(localbh.a());
      this.f.a(localbp);
      return;
    }
    catch (JSONException localJSONException)
    {
      com.appboy.f.c.d(c, "Could not create session end event.");
    }
  }

  protected com.appboy.c.c<f> a()
  {
    return new com.appboy.c.c()
    {
      public void a(f paramAnonymousf)
      {
        ch localch = paramAnonymousf.a();
        bn localbn = localch.e();
        if ((localbn != null) && (localbn.c()))
          b.a(b.this).a(false);
        bl localbl = localch.c();
        if (localbl != null)
          b.b(b.this).b(localbl, true);
        bo localbo = localch.d();
        if (localbo != null)
          b.c(b.this).b(localbo, true);
        bb localbb = localch.f();
        if (localbb != null)
          b.d(b.this).a(new ArrayList(localbb.a()));
      }
    };
  }

  protected com.appboy.c.c<Throwable> a(final Semaphore paramSemaphore)
  {
    return new com.appboy.c.c()
    {
      public void a(Throwable paramAnonymousThrowable)
      {
        try
        {
          b.f(b.this).a(paramAnonymousThrowable);
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.d(b.q(), "Failed to log error.", localException);
          return;
        }
        finally
        {
          if (paramSemaphore != null)
            paramSemaphore.release();
        }
      }
    };
  }

  public void a(c paramc)
  {
    paramc.b(b(), e.class);
    paramc.b(e(), o.class);
    paramc.b(g(), p.class);
    paramc.b(j(), s.class);
    paramc.b(h(), n.class);
    paramc.b(a(null), Throwable.class);
    paramc.b(p(), x.class);
    paramc.b(k(), v.class);
    paramc.b(f(), l.class);
    paramc.b(a(), f.class);
    paramc.b(i(), j.class);
    paramc.b(l(), t.class);
    paramc.b(m(), k.class);
    paramc.b(n(), u.class);
  }

  protected com.appboy.c.c<e> b()
  {
    return new com.appboy.c.c()
    {
      public void a(e paramAnonymouse)
      {
        ch localch = paramAnonymouse.a();
        bn localbn = localch.e();
        if (localbn != null)
        {
          if (localbn.d())
          {
            b.this.c();
            b.this.d();
          }
          if (localbn.c())
            b.a(b.this).a(true);
        }
        bl localbl = localch.c();
        if (localbl != null)
          b.b(b.this).b(localbl, false);
        bo localbo = localch.d();
        if (localbo != null)
          b.c(b.this).b(localbo, false);
        bb localbb = localch.f();
        if (localbb != null)
        {
          Iterator localIterator = localbb.a().iterator();
          while (localIterator.hasNext())
          {
            be localbe = (be)localIterator.next();
            b.e(b.this).a(localbe);
          }
        }
      }
    };
  }

  protected void c()
  {
    if (this.a.compareAndSet(true, false))
      this.k.a(new fc());
  }

  protected void d()
  {
    if ((this.q.compareAndSet(true, false)) && (this.r.a() != null))
    {
      this.k.a(new fe(this.r.a(), this.r.b()));
      this.r = null;
    }
  }

  protected com.appboy.c.c<o> e()
  {
    return new com.appboy.c.c()
    {
      public void a(o paramAnonymouso)
      {
        com.appboy.f.c.b(b.q(), "Session start event for new session received.");
        bp localbp = bp.l();
        b.f(b.this).a(localbp);
        b.g(b.this).a();
        b.this.o();
        com.appboy.b.a(b.h(b.this), false);
        b.c(b.this).d();
      }
    };
  }

  protected com.appboy.c.c<l> f()
  {
    return new com.appboy.c.c()
    {
      public void a(l paramAnonymousl)
      {
        b.this.o();
      }
    };
  }

  protected com.appboy.c.c<p> g()
  {
    return new com.appboy.c.c()
    {
      public void a(p paramAnonymousp)
      {
        b.a(b.this, paramAnonymousp);
        a.a(b.h(b.this)).f();
      }
    };
  }

  protected com.appboy.c.c<n> h()
  {
    return new com.appboy.c.c()
    {
      public void a(n paramAnonymousn)
      {
        b.i(b.this).a(paramAnonymousn.a());
        b.j(b.this).a(paramAnonymousn.a());
      }
    };
  }

  protected com.appboy.c.c<j> i()
  {
    return new com.appboy.c.c()
    {
      public void a(j paramAnonymousj)
      {
        b.i(b.this).a(paramAnonymousj.a());
      }
    };
  }

  protected com.appboy.c.c<s> j()
  {
    return new com.appboy.c.c()
    {
      public void a(s paramAnonymouss)
      {
        b.k(b.this).set(true);
        b.a(b.this, paramAnonymouss);
        com.appboy.f.c.c(b.q(), "Requesting trigger update due to trigger-eligible push click event");
        b.f(b.this).a(new bn.a().b());
      }
    };
  }

  protected com.appboy.c.c<v> k()
  {
    return new com.appboy.c.c()
    {
      public void a(v paramAnonymousv)
      {
        b.l(b.this).a(paramAnonymousv.a());
        b.this.c();
        b.this.d();
      }
    };
  }

  protected com.appboy.c.c<t> l()
  {
    return new com.appboy.c.c()
    {
      public void a(t paramAnonymoust)
      {
        b.l(b.this).a(paramAnonymoust.a());
      }
    };
  }

  protected com.appboy.c.c<k> m()
  {
    return new com.appboy.c.c()
    {
      public void a(k paramAnonymousk)
      {
        dy localdy = paramAnonymousk.a();
        synchronized (b.m(b.this))
        {
          if (b.m(b.this).a(localdy))
          {
            b.n(b.this).a(new com.appboy.c.d(paramAnonymousk.b(), paramAnonymousk.c()), com.appboy.c.d.class);
            b.m(b.this).a(localdy, di.a());
            b.l(b.this).a(di.a());
            return;
          }
          com.appboy.f.c.b(b.q(), "Could not publish in-app message with trigger action id: " + localdy.b());
        }
      }
    };
  }

  protected com.appboy.c.c<u> n()
  {
    return new com.appboy.c.c()
    {
      public void a(u paramAnonymousu)
      {
        b.l(b.this).a(paramAnonymousu.a(), paramAnonymousu.b());
      }
    };
  }

  void o()
  {
    if (5L + this.b < di.a())
    {
      this.a.set(true);
      com.appboy.f.c.b(c, "Requesting trigger refresh.");
      this.f.a(new bn.a().b());
      this.b = di.a();
    }
  }

  protected com.appboy.c.c<x> p()
  {
    return new com.appboy.c.c()
    {
      public void a(x paramAnonymousx)
      {
        try
        {
          b.f(b.this).b(paramAnonymousx);
          return;
        }
        catch (Exception localException)
        {
          com.appboy.f.c.d(b.q(), "Failed to log the storage exception.", localException);
        }
      }
    };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.b
 * JD-Core Version:    0.6.2
 */