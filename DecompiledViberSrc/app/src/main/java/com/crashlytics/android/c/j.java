package com.crashlytics.android.c;

import android.os.Looper;
import c.a.a.a.c;
import c.a.a.a.l;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class j
{
  private final ExecutorService a;

  public j(ExecutorService paramExecutorService)
  {
    this.a = paramExecutorService;
  }

  <T> T a(Callable<T> paramCallable)
  {
    try
    {
      if (Looper.getMainLooper() == Looper.myLooper())
        return this.a.submit(paramCallable).get(4L, TimeUnit.SECONDS);
      Object localObject = this.a.submit(paramCallable).get();
      return localObject;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      c.g().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
      return null;
    }
    catch (Exception localException)
    {
      c.g().e("CrashlyticsCore", "Failed to execute task.", localException);
    }
    return null;
  }

  Future<?> a(final Runnable paramRunnable)
  {
    try
    {
      Future localFuture = this.a.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            paramRunnable.run();
            return;
          }
          catch (Exception localException)
          {
            c.g().e("CrashlyticsCore", "Failed to execute task.", localException);
          }
        }
      });
      return localFuture;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      c.g().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
    }
    return null;
  }

  <T> Future<T> b(final Callable<T> paramCallable)
  {
    try
    {
      Future localFuture = this.a.submit(new Callable()
      {
        public T call()
          throws Exception
        {
          try
          {
            Object localObject = paramCallable.call();
            return localObject;
          }
          catch (Exception localException)
          {
            c.g().e("CrashlyticsCore", "Failed to execute task.", localException);
          }
          return null;
        }
      });
      return localFuture;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      c.g().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.j
 * JD-Core Version:    0.6.2
 */