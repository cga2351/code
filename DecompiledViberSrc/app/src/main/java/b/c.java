package b;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class c
{
  private static final c a = new c();
  private final ExecutorService b;
  private final ScheduledExecutorService c;
  private final Executor d;

  private c()
  {
    if (!c());
    for (ExecutorService localExecutorService = Executors.newCachedThreadPool(); ; localExecutorService = a.a())
    {
      this.b = localExecutorService;
      this.c = Executors.newSingleThreadScheduledExecutor();
      this.d = new a(null);
      return;
    }
  }

  public static ExecutorService a()
  {
    return a.b;
  }

  static Executor b()
  {
    return a.d;
  }

  private static boolean c()
  {
    String str = System.getProperty("java.runtime.name");
    if (str == null)
      return false;
    return str.toLowerCase(Locale.US).contains("android");
  }

  private static class a
    implements Executor
  {
    private ThreadLocal<Integer> a = new ThreadLocal();

    private int a()
    {
      Integer localInteger = (Integer)this.a.get();
      if (localInteger == null)
        localInteger = Integer.valueOf(0);
      int i = 1 + localInteger.intValue();
      this.a.set(Integer.valueOf(i));
      return i;
    }

    private int b()
    {
      Integer localInteger = (Integer)this.a.get();
      if (localInteger == null)
        localInteger = Integer.valueOf(0);
      int i = -1 + localInteger.intValue();
      if (i == 0)
      {
        this.a.remove();
        return i;
      }
      this.a.set(Integer.valueOf(i));
      return i;
    }

    public void execute(Runnable paramRunnable)
    {
      if (a() <= 15);
      try
      {
        paramRunnable.run();
        while (true)
        {
          return;
          c.a().execute(paramRunnable);
        }
      }
      finally
      {
        b();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     b.c
 * JD-Core Version:    0.6.2
 */