package com.facebook.react.bridge.queue;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@DoNotStrip
public abstract interface MessageQueueThread
{
  @DoNotStrip
  public abstract void assertIsOnThread();

  @DoNotStrip
  public abstract void assertIsOnThread(String paramString);

  @DoNotStrip
  public abstract <T> Future<T> callOnQueue(Callable<T> paramCallable);

  @DoNotStrip
  public abstract MessageQueueThreadPerfStats getPerfStats();

  @DoNotStrip
  public abstract boolean isOnThread();

  @DoNotStrip
  public abstract void quitSynchronous();

  @DoNotStrip
  public abstract void resetPerfStats();

  @DoNotStrip
  public abstract void runOnQueue(Runnable paramRunnable);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.MessageQueueThread
 * JD-Core Version:    0.6.2
 */