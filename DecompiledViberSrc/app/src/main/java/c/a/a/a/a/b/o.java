package c.a.a.a.a.b;

import c.a.a.a.c;
import c.a.a.a.l;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class o
{
  public static ExecutorService a(String paramString)
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor(c(paramString));
    a(paramString, localExecutorService);
    return localExecutorService;
  }

  private static final void a(String paramString, ExecutorService paramExecutorService)
  {
    a(paramString, paramExecutorService, 2L, TimeUnit.SECONDS);
  }

  public static final void a(String paramString, final ExecutorService paramExecutorService, final long paramLong, TimeUnit paramTimeUnit)
  {
    Runtime.getRuntime().addShutdownHook(new Thread(new h()
    {
      public void a()
      {
        try
        {
          c.g().a("Fabric", "Executing shutdown hook for " + this.a);
          paramExecutorService.shutdown();
          if (!paramExecutorService.awaitTermination(paramLong, this.d))
          {
            c.g().a("Fabric", this.a + " did not shut down in the allocated time. Requesting immediate shutdown.");
            paramExecutorService.shutdownNow();
          }
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          l locall = c.g();
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = this.a;
          locall.a("Fabric", String.format(localLocale, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", arrayOfObject));
          paramExecutorService.shutdownNow();
        }
      }
    }
    , "Crashlytics Shutdown Hook for " + paramString));
  }

  public static ScheduledExecutorService b(String paramString)
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newSingleThreadScheduledExecutor(c(paramString));
    a(paramString, localScheduledExecutorService);
    return localScheduledExecutorService;
  }

  public static final ThreadFactory c(String paramString)
  {
    return new ThreadFactory()
    {
      public Thread newThread(final Runnable paramAnonymousRunnable)
      {
        Thread localThread = Executors.defaultThreadFactory().newThread(new h()
        {
          public void a()
          {
            paramAnonymousRunnable.run();
          }
        });
        localThread.setName(this.a + this.b.getAndIncrement());
        return localThread;
      }
    };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.o
 * JD-Core Version:    0.6.2
 */