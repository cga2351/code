package org.webrtc;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class ThreadUtils
{
  public static void awaitUninterruptibly(CountDownLatch paramCountDownLatch)
  {
    executeUninterruptibly(new BlockingOperation()
    {
      public void run()
        throws InterruptedException
      {
        ThreadUtils.this.await();
      }
    });
  }

  public static boolean awaitUninterruptibly(CountDownLatch paramCountDownLatch, long paramLong)
  {
    long l1 = SystemClock.elapsedRealtime();
    int i = 0;
    long l2 = paramLong;
    while (true)
    {
      boolean bool1;
      try
      {
        boolean bool2 = paramCountDownLatch.await(l2, TimeUnit.MILLISECONDS);
        bool1 = bool2;
        if (i != 0)
          Thread.currentThread().interrupt();
        return bool1;
      }
      catch (InterruptedException localInterruptedException)
      {
        i = 1;
        l2 = paramLong - (SystemClock.elapsedRealtime() - l1);
      }
      if (l2 <= 0L)
        bool1 = false;
    }
  }

  public static void checkIsOnMainThread()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
      throw new IllegalStateException("Not on main thread!");
  }

  static StackTraceElement[] concatStackTraces(StackTraceElement[] paramArrayOfStackTraceElement1, StackTraceElement[] paramArrayOfStackTraceElement2)
  {
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[paramArrayOfStackTraceElement1.length + paramArrayOfStackTraceElement2.length];
    System.arraycopy(paramArrayOfStackTraceElement1, 0, arrayOfStackTraceElement, 0, paramArrayOfStackTraceElement1.length);
    System.arraycopy(paramArrayOfStackTraceElement2, 0, arrayOfStackTraceElement, paramArrayOfStackTraceElement1.length, paramArrayOfStackTraceElement2.length);
    return arrayOfStackTraceElement;
  }

  public static void executeUninterruptibly(BlockingOperation paramBlockingOperation)
  {
    int i = 0;
    while (true)
      try
      {
        paramBlockingOperation.run();
        if (i != 0)
          Thread.currentThread().interrupt();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        i = 1;
      }
  }

  public static <V> V invokeAtFrontUninterruptibly(Handler paramHandler, final Callable<V> paramCallable)
  {
    if (paramHandler.getLooper().getThread() == Thread.currentThread())
      try
      {
        Object localObject = paramCallable.call();
        return localObject;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    Object local1Result = new Object()
    {
      public V value;
    };
    final Object local1CaughtException = new Object()
    {
      Exception e;
    };
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        try
        {
          ThreadUtils.this.value = paramCallable.call();
          localCountDownLatch.countDown();
          return;
        }
        catch (Exception localException)
        {
          while (true)
            local1CaughtException.e = localException;
        }
      }
    });
    awaitUninterruptibly(localCountDownLatch);
    if (local1CaughtException.e != null)
    {
      RuntimeException localRuntimeException = new RuntimeException(local1CaughtException.e);
      localRuntimeException.setStackTrace(concatStackTraces(local1CaughtException.e.getStackTrace(), localRuntimeException.getStackTrace()));
      throw localRuntimeException;
    }
    return local1Result.value;
  }

  public static void invokeAtFrontUninterruptibly(Handler paramHandler, Runnable paramRunnable)
  {
    invokeAtFrontUninterruptibly(paramHandler, new Callable()
    {
      public Void call()
      {
        ThreadUtils.this.run();
        return null;
      }
    });
  }

  public static void joinUninterruptibly(Thread paramThread)
  {
    executeUninterruptibly(new BlockingOperation()
    {
      public void run()
        throws InterruptedException
      {
        ThreadUtils.this.join();
      }
    });
  }

  public static boolean joinUninterruptibly(Thread paramThread, long paramLong)
  {
    long l1 = SystemClock.elapsedRealtime();
    int i = 0;
    long l2 = paramLong;
    while (true)
    {
      if (l2 > 0L);
      try
      {
        paramThread.join(l2);
        if (i != 0)
          Thread.currentThread().interrupt();
        if (paramThread.isAlive())
          break;
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        l2 = paramLong - (SystemClock.elapsedRealtime() - l1);
        i = 1;
      }
    }
    return false;
  }

  public static abstract interface BlockingOperation
  {
    public abstract void run()
      throws InterruptedException;
  }

  public static class ThreadChecker
  {

    @Nullable
    private Thread thread = Thread.currentThread();

    public void checkIsOnValidThread()
    {
      if (this.thread == null)
        this.thread = Thread.currentThread();
      if (Thread.currentThread() != this.thread)
        throw new IllegalStateException("Wrong thread");
    }

    public void detachThread()
    {
      this.thread = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.ThreadUtils
 * JD-Core Version:    0.6.2
 */