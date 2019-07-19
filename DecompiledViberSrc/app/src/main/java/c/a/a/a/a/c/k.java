package c.a.a.a.a.c;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class k extends ThreadPoolExecutor
{
  private static final int a = Runtime.getRuntime().availableProcessors();
  private static final int b = 1 + a;
  private static final int c = 1 + 2 * a;

  <T extends Runnable,  extends b,  extends l,  extends i> k(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, c<T> paramc, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramc, paramThreadFactory);
    prestartAllCoreThreads();
  }

  public static k a()
  {
    return a(b, c);
  }

  public static <T extends Runnable,  extends b,  extends l,  extends i> k a(int paramInt1, int paramInt2)
  {
    return new k(paramInt1, paramInt2, 1L, TimeUnit.SECONDS, new c(), new a(10));
  }

  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    l locall = (l)paramRunnable;
    locall.b(true);
    locall.a(paramThrowable);
    b().d();
    super.afterExecute(paramRunnable, paramThrowable);
  }

  public c b()
  {
    return (c)super.getQueue();
  }

  @TargetApi(9)
  public void execute(Runnable paramRunnable)
  {
    if (j.a(paramRunnable))
    {
      super.execute(paramRunnable);
      return;
    }
    super.execute(newTaskFor(paramRunnable, null));
  }

  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new h(paramRunnable, paramT);
  }

  protected <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
  {
    return new h(paramCallable);
  }

  protected static final class a
    implements ThreadFactory
  {
    private final int a;

    public a(int paramInt)
    {
      this.a = paramInt;
    }

    public Thread newThread(Runnable paramRunnable)
    {
      Thread localThread = new Thread(paramRunnable);
      localThread.setPriority(this.a);
      localThread.setName("Queue");
      return localThread;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.c.k
 * JD-Core Version:    0.6.2
 */