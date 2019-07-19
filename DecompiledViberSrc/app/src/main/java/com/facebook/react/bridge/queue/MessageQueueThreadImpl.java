package com.facebook.react.bridge.queue;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.futures.SimpleSettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@DoNotStrip
public class MessageQueueThreadImpl
  implements MessageQueueThread
{
  private final String mAssertionErrorMessage;
  private final MessageQueueThreadHandler mHandler;
  private volatile boolean mIsFinished = false;
  private final Looper mLooper;
  private final String mName;
  private MessageQueueThreadPerfStats mPerfStats;

  private MessageQueueThreadImpl(String paramString, Looper paramLooper, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    this(paramString, paramLooper, paramQueueThreadExceptionHandler, null);
  }

  private MessageQueueThreadImpl(String paramString, Looper paramLooper, QueueThreadExceptionHandler paramQueueThreadExceptionHandler, MessageQueueThreadPerfStats paramMessageQueueThreadPerfStats)
  {
    this.mName = paramString;
    this.mLooper = paramLooper;
    this.mHandler = new MessageQueueThreadHandler(paramLooper, paramQueueThreadExceptionHandler);
    this.mPerfStats = paramMessageQueueThreadPerfStats;
    this.mAssertionErrorMessage = ("Expected to be called from the '" + getName() + "' thread!");
  }

  private static void assignToPerfStats(MessageQueueThreadPerfStats paramMessageQueueThreadPerfStats, long paramLong1, long paramLong2)
  {
    paramMessageQueueThreadPerfStats.wallTime = paramLong1;
    paramMessageQueueThreadPerfStats.cpuTime = paramLong2;
  }

  public static MessageQueueThreadImpl create(MessageQueueThreadSpec paramMessageQueueThreadSpec, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    switch (5.$SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType[paramMessageQueueThreadSpec.getThreadType().ordinal()])
    {
    default:
      throw new RuntimeException("Unknown thread type: " + paramMessageQueueThreadSpec.getThreadType());
    case 1:
      return createForMainThread(paramMessageQueueThreadSpec.getName(), paramQueueThreadExceptionHandler);
    case 2:
    }
    return startNewBackgroundThread(paramMessageQueueThreadSpec.getName(), paramMessageQueueThreadSpec.getStackSize(), paramQueueThreadExceptionHandler);
  }

  private static MessageQueueThreadImpl createForMainThread(String paramString, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    MessageQueueThreadImpl localMessageQueueThreadImpl = new MessageQueueThreadImpl(paramString, Looper.getMainLooper(), paramQueueThreadExceptionHandler);
    if (UiThreadUtil.isOnUiThread())
    {
      Process.setThreadPriority(-4);
      return localMessageQueueThreadImpl;
    }
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        Process.setThreadPriority(-4);
      }
    });
    return localMessageQueueThreadImpl;
  }

  private static MessageQueueThreadImpl startNewBackgroundThread(String paramString, long paramLong, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    SimpleSettableFuture localSimpleSettableFuture = new SimpleSettableFuture();
    new Thread(null, new Runnable()
    {
      public void run()
      {
        Process.setThreadPriority(-4);
        Looper.prepare();
        MessageQueueThreadPerfStats localMessageQueueThreadPerfStats = new MessageQueueThreadPerfStats();
        MessageQueueThreadImpl.assignToPerfStats(localMessageQueueThreadPerfStats, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis());
        this.val$dataFuture.set(new Pair(Looper.myLooper(), localMessageQueueThreadPerfStats));
        Looper.loop();
      }
    }
    , "mqt_" + paramString, paramLong).start();
    Pair localPair = (Pair)localSimpleSettableFuture.getOrThrow();
    return new MessageQueueThreadImpl(paramString, (Looper)localPair.first, paramQueueThreadExceptionHandler, (MessageQueueThreadPerfStats)localPair.second);
  }

  @DoNotStrip
  public void assertIsOnThread()
  {
    SoftAssertions.assertCondition(isOnThread(), this.mAssertionErrorMessage);
  }

  @DoNotStrip
  public void assertIsOnThread(String paramString)
  {
    SoftAssertions.assertCondition(isOnThread(), this.mAssertionErrorMessage + " " + paramString);
  }

  @DoNotStrip
  public <T> Future<T> callOnQueue(final Callable<T> paramCallable)
  {
    final SimpleSettableFuture localSimpleSettableFuture = new SimpleSettableFuture();
    runOnQueue(new Runnable()
    {
      public void run()
      {
        try
        {
          localSimpleSettableFuture.set(paramCallable.call());
          return;
        }
        catch (Exception localException)
        {
          localSimpleSettableFuture.setException(localException);
        }
      }
    });
    return localSimpleSettableFuture;
  }

  public Looper getLooper()
  {
    return this.mLooper;
  }

  public String getName()
  {
    return this.mName;
  }

  @DoNotStrip
  public MessageQueueThreadPerfStats getPerfStats()
  {
    return this.mPerfStats;
  }

  @DoNotStrip
  public boolean isOnThread()
  {
    return this.mLooper.getThread() == Thread.currentThread();
  }

  @DoNotStrip
  public void quitSynchronous()
  {
    this.mIsFinished = true;
    this.mLooper.quit();
    if (this.mLooper.getThread() != Thread.currentThread());
    try
    {
      this.mLooper.getThread().join();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    throw new RuntimeException("Got interrupted waiting to join thread " + this.mName);
  }

  @DoNotStrip
  public void resetPerfStats()
  {
    assignToPerfStats(this.mPerfStats, -1L, -1L);
    runOnQueue(new Runnable()
    {
      public void run()
      {
        long l1 = SystemClock.uptimeMillis();
        long l2 = SystemClock.currentThreadTimeMillis();
        MessageQueueThreadImpl.assignToPerfStats(MessageQueueThreadImpl.this.mPerfStats, l1, l2);
      }
    });
  }

  @DoNotStrip
  public void runOnQueue(Runnable paramRunnable)
  {
    if (this.mIsFinished)
      FLog.w("ReactNative", "Tried to enqueue runnable on already finished thread: '" + getName() + "... dropping Runnable.");
    this.mHandler.post(paramRunnable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.MessageQueueThreadImpl
 * JD-Core Version:    0.6.2
 */