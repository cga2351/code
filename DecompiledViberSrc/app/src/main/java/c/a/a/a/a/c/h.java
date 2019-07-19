package c.a.a.a.a.c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class h<V> extends FutureTask<V>
  implements b<l>, i, l
{
  final Object b = a(paramCallable);

  public h(Runnable paramRunnable, V paramV)
  {
    super(paramRunnable, paramV);
  }

  public h(Callable<V> paramCallable)
  {
    super(paramCallable);
  }

  public <T extends b<l>,  extends i,  extends l> T a()
  {
    return (b)this.b;
  }

  protected <T extends b<l>,  extends i,  extends l> T a(Object paramObject)
  {
    if (j.a(paramObject))
      return (b)paramObject;
    return new j();
  }

  public void a(l paraml)
  {
    ((b)a()).c(paraml);
  }

  public void a(Throwable paramThrowable)
  {
    ((l)a()).a(paramThrowable);
  }

  public e b()
  {
    return ((i)a()).b();
  }

  public void b(boolean paramBoolean)
  {
    ((l)a()).b(paramBoolean);
  }

  public Collection<l> c()
  {
    return ((b)a()).c();
  }

  public int compareTo(Object paramObject)
  {
    return ((i)a()).compareTo(paramObject);
  }

  public boolean d()
  {
    return ((b)a()).d();
  }

  public boolean f()
  {
    return ((l)a()).f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.c.h
 * JD-Core Version:    0.6.2
 */