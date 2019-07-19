package b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class i<TResult>
{
  public static final ExecutorService a = c.a();
  public static final Executor b = a.b();
  private static final Executor c = c.b();
  private static volatile a d;
  private static i<?> m = new i(null);
  private static i<Boolean> n = new i(Boolean.valueOf(true));
  private static i<Boolean> o = new i(Boolean.valueOf(false));
  private static i<?> p = new i(true);
  private final Object e = new Object();
  private boolean f;
  private boolean g;
  private TResult h;
  private Exception i;
  private boolean j;
  private k k;
  private List<g<TResult, Void>> l = new ArrayList();

  i()
  {
  }

  private i(TResult paramTResult)
  {
    b(paramTResult);
  }

  private i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g();
      return;
    }
    b(null);
  }

  public static a a()
  {
    return d;
  }

  public static <TResult> i<TResult> a(Exception paramException)
  {
    j localj = new j();
    localj.b(paramException);
    return localj.a();
  }

  public static <TResult> i<TResult> a(TResult paramTResult)
  {
    if (paramTResult == null)
      return m;
    if ((paramTResult instanceof Boolean))
    {
      if (((Boolean)paramTResult).booleanValue())
        return n;
      return o;
    }
    j localj = new j();
    localj.b(paramTResult);
    return localj.a();
  }

  public static <TResult> i<TResult> a(Callable<TResult> paramCallable, Executor paramExecutor)
  {
    return a(paramCallable, paramExecutor, null);
  }

  public static <TResult> i<TResult> a(final Callable<TResult> paramCallable, Executor paramExecutor, d paramd)
  {
    final j localj = new j();
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          if ((this.a != null) && (this.a.a()))
          {
            localj.c();
            return;
          }
          try
          {
            localj.b(paramCallable.call());
            return;
          }
          catch (CancellationException localCancellationException)
          {
            localj.c();
            return;
          }
          catch (Exception localException)
          {
            localj.b(localException);
          }
        }
      });
      return localj.a();
    }
    catch (Exception localException)
    {
      while (true)
        localj.b(new h(localException));
    }
  }

  private static <TContinuationResult, TResult> void c(final j<TContinuationResult> paramj, final g<TResult, TContinuationResult> paramg, final i<TResult> parami, Executor paramExecutor, d paramd)
  {
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          if ((this.a != null) && (this.a.a()))
          {
            paramj.c();
            return;
          }
          try
          {
            Object localObject = paramg.then(parami);
            paramj.b(localObject);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            paramj.c();
            return;
          }
          catch (Exception localException)
          {
            paramj.b(localException);
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      paramj.b(new h(localException));
    }
  }

  private static <TContinuationResult, TResult> void d(final j<TContinuationResult> paramj, final g<TResult, i<TContinuationResult>> paramg, final i<TResult> parami, Executor paramExecutor, d paramd)
  {
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          if ((this.a != null) && (this.a.a()))
          {
            paramj.c();
            return;
          }
          try
          {
            locali = (i)paramg.then(parami);
            if (locali == null)
            {
              paramj.b(null);
              return;
            }
          }
          catch (CancellationException localCancellationException)
          {
            i locali;
            paramj.c();
            return;
            locali.a(new g()
            {
              public Void a(i<TContinuationResult> paramAnonymous2i)
              {
                if ((i.4.this.a != null) && (i.4.this.a.a()))
                {
                  i.4.this.b.c();
                  return null;
                }
                if (paramAnonymous2i.c())
                {
                  i.4.this.b.c();
                  return null;
                }
                if (paramAnonymous2i.d())
                {
                  i.4.this.b.b(paramAnonymous2i.f());
                  return null;
                }
                i.4.this.b.b(paramAnonymous2i.e());
                return null;
              }
            });
            return;
          }
          catch (Exception localException)
          {
            paramj.b(localException);
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      paramj.b(new h(localException));
    }
  }

  private void h()
  {
    while (true)
    {
      g localg;
      synchronized (this.e)
      {
        Iterator localIterator = this.l.iterator();
        if (!localIterator.hasNext())
          break;
        localg = (g)localIterator.next();
      }
      try
      {
        localg.then(this);
      }
      catch (RuntimeException localRuntimeException)
      {
        throw localRuntimeException;
        localObject2 = finally;
        throw localObject2;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    this.l = null;
  }

  public <TContinuationResult> i<TContinuationResult> a(g<TResult, TContinuationResult> paramg)
  {
    return a(paramg, c, null);
  }

  public <TContinuationResult> i<TContinuationResult> a(final g<TResult, TContinuationResult> paramg, final Executor paramExecutor, final d paramd)
  {
    final j localj = new j();
    synchronized (this.e)
    {
      boolean bool = b();
      if (!bool)
        this.l.add(new g()
        {
          public Void a(i<TResult> paramAnonymousi)
          {
            i.a(localj, paramg, paramAnonymousi, paramExecutor, paramd);
            return null;
          }
        });
      if (bool)
        c(localj, paramg, this, paramExecutor, paramd);
      return localj.a();
    }
  }

  public <TContinuationResult> i<TContinuationResult> b(g<TResult, i<TContinuationResult>> paramg)
  {
    return b(paramg, c, null);
  }

  public <TContinuationResult> i<TContinuationResult> b(final g<TResult, i<TContinuationResult>> paramg, final Executor paramExecutor, final d paramd)
  {
    final j localj = new j();
    synchronized (this.e)
    {
      boolean bool = b();
      if (!bool)
        this.l.add(new g()
        {
          public Void a(i<TResult> paramAnonymousi)
          {
            i.b(localj, paramg, paramAnonymousi, paramExecutor, paramd);
            return null;
          }
        });
      if (bool)
        d(localj, paramg, this, paramExecutor, paramd);
      return localj.a();
    }
  }

  public boolean b()
  {
    synchronized (this.e)
    {
      boolean bool = this.f;
      return bool;
    }
  }

  boolean b(Exception paramException)
  {
    synchronized (this.e)
    {
      if (this.f)
        return false;
      this.f = true;
      this.i = paramException;
      this.j = false;
      this.e.notifyAll();
      h();
      if ((!this.j) && (a() != null))
        this.k = new k(this);
      return true;
    }
  }

  boolean b(TResult paramTResult)
  {
    synchronized (this.e)
    {
      if (this.f)
        return false;
      this.f = true;
      this.h = paramTResult;
      this.e.notifyAll();
      h();
      return true;
    }
  }

  public boolean c()
  {
    synchronized (this.e)
    {
      boolean bool = this.g;
      return bool;
    }
  }

  public boolean d()
  {
    while (true)
    {
      synchronized (this.e)
      {
        if (f() != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public TResult e()
  {
    synchronized (this.e)
    {
      Object localObject3 = this.h;
      return localObject3;
    }
  }

  public Exception f()
  {
    synchronized (this.e)
    {
      if (this.i != null)
      {
        this.j = true;
        if (this.k != null)
        {
          this.k.a();
          this.k = null;
        }
      }
      Exception localException = this.i;
      return localException;
    }
  }

  boolean g()
  {
    synchronized (this.e)
    {
      if (this.f)
        return false;
      this.f = true;
      this.g = true;
      this.e.notifyAll();
      h();
      return true;
    }
  }

  public static abstract interface a
  {
    public abstract void a(i<?> parami, l paraml);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     b.i
 * JD-Core Version:    0.6.2
 */