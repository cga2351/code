package com.adjust.sdk;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class CustomScheduledExecutor extends ScheduledThreadPoolExecutor
{
  public CustomScheduledExecutor(String paramString, boolean paramBoolean)
  {
    super(1, new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        Thread localThread = Executors.defaultThreadFactory().newThread(paramAnonymousRunnable);
        localThread.setPriority(1);
        localThread.setName("Adjust-" + localThread.getName() + "-" + CustomScheduledExecutor.this);
        localThread.setDaemon(true);
        localThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public void uncaughtException(Thread paramAnonymous2Thread, Throwable paramAnonymous2Throwable)
          {
            ILogger localILogger = AdjustFactory.getLogger();
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = paramAnonymous2Thread.getName();
            arrayOfObject[1] = paramAnonymous2Throwable.getMessage();
            localILogger.error("Thread [%s] with error [%s]", arrayOfObject);
          }
        });
        return localThread;
      }
    }
    , new RejectedExecutionHandler()
    {
      public void rejectedExecution(Runnable paramAnonymousRunnable, ThreadPoolExecutor paramAnonymousThreadPoolExecutor)
      {
        ILogger localILogger = AdjustFactory.getLogger();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramAnonymousRunnable.toString();
        arrayOfObject[1] = CustomScheduledExecutor.this;
        localILogger.warn("Runnable [%s] rejected from [%s] ", arrayOfObject);
      }
    });
    if (!paramBoolean)
    {
      setKeepAliveTime(10L, TimeUnit.MILLISECONDS);
      allowCoreThreadTimeOut(true);
    }
  }

  public ScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return super.schedule(new a(paramRunnable), paramLong, paramTimeUnit);
  }

  public ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return super.scheduleWithFixedDelay(new a(paramRunnable), paramLong1, paramLong2, paramTimeUnit);
  }

  public Future<?> submit(Runnable paramRunnable)
  {
    return super.submit(new a(paramRunnable));
  }

  private static class a
    implements Runnable
  {
    private Runnable a;

    a(Runnable paramRunnable)
    {
      this.a = paramRunnable;
    }

    public void run()
    {
      try
      {
        this.a.run();
        return;
      }
      catch (Throwable localThrowable)
      {
        ILogger localILogger = AdjustFactory.getLogger();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localThrowable.getMessage();
        arrayOfObject[1] = localThrowable.getClass().getCanonicalName();
        localILogger.error("Runnable error [%s] of type [%s]", arrayOfObject);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.CustomScheduledExecutor
 * JD-Core Version:    0.6.2
 */