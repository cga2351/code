package c.a.a.a.a.c;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class f<Params, Progress, Result> extends a<Params, Progress, Result>
  implements b<l>, i, l
{
  private final j a = new j();

  public void a(l paraml)
  {
    if (ai_() != a.d.a)
      throw new IllegalStateException("Must not add Dependency after task is running");
    ((b)g()).c(paraml);
  }

  public void a(Throwable paramThrowable)
  {
    ((l)g()).a(paramThrowable);
  }

  public final void a(ExecutorService paramExecutorService, Params[] paramArrayOfParams)
  {
    super.a(new a(paramExecutorService, this), paramArrayOfParams);
  }

  public e b()
  {
    return ((i)g()).b();
  }

  public void b(boolean paramBoolean)
  {
    ((l)g()).b(paramBoolean);
  }

  public Collection<l> c()
  {
    return ((b)g()).c();
  }

  public int compareTo(Object paramObject)
  {
    return e.a(this, paramObject);
  }

  public boolean d()
  {
    return ((b)g()).d();
  }

  public boolean f()
  {
    return ((l)g()).f();
  }

  public <T extends b<l>,  extends i,  extends l> T g()
  {
    return this.a;
  }

  private static class a<Result>
    implements Executor
  {
    private final Executor a;
    private final f b;

    public a(Executor paramExecutor, f paramf)
    {
      this.a = paramExecutor;
      this.b = paramf;
    }

    public void execute(Runnable paramRunnable)
    {
      this.a.execute(new h(paramRunnable, null)
      {
        public <T extends b<l>,  extends i,  extends l> T a()
        {
          return f.this;
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.c.f
 * JD-Core Version:    0.6.2
 */