package com.viber.voip.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class w<T>
  implements Future<T>
{
  private final CountDownLatch mCountDownLatch = new CountDownLatch(1);
  private volatile boolean mIsCancelled = false;
  private volatile T mResult = null;

  public boolean cancel(boolean paramBoolean)
  {
    boolean bool = true;
    if (isDone())
      return false;
    this.mCountDownLatch.countDown();
    this.mIsCancelled = bool;
    if (!isDone());
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public T get()
    throws InterruptedException
  {
    this.mCountDownLatch.await();
    return this.mResult;
  }

  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    this.mCountDownLatch.await(paramLong, paramTimeUnit);
    return this.mResult;
  }

  public T getSafe()
  {
    try
    {
      get();
      label5: return this.mResult;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label5;
    }
  }

  public T getSafe(long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      get(paramLong, paramTimeUnit);
      label7: return this.mResult;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label7;
    }
  }

  public boolean isCancelled()
  {
    return this.mIsCancelled;
  }

  public boolean isDone()
  {
    return this.mCountDownLatch.getCount() == 0L;
  }

  protected final void setResult(T paramT)
  {
    this.mResult = paramT;
    this.mCountDownLatch.countDown();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.w
 * JD-Core Version:    0.6.2
 */