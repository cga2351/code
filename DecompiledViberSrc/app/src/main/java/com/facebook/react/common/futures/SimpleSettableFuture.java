package com.facebook.react.common.futures;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

public class SimpleSettableFuture<T>
  implements Future<T>
{

  @Nullable
  private Exception mException;
  private final CountDownLatch mReadyLatch = new CountDownLatch(1);

  @Nullable
  private T mResult;

  private void checkNotSet()
  {
    if (this.mReadyLatch.getCount() == 0L)
      throw new RuntimeException("Result has already been set!");
  }

  public boolean cancel(boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }

  @Nullable
  public T get()
    throws InterruptedException, ExecutionException
  {
    this.mReadyLatch.await();
    if (this.mException != null)
      throw new ExecutionException(this.mException);
    return this.mResult;
  }

  @Nullable
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    if (!this.mReadyLatch.await(paramLong, paramTimeUnit))
      throw new TimeoutException("Timed out waiting for result");
    if (this.mException != null)
      throw new ExecutionException(this.mException);
    return this.mResult;
  }

  @Nullable
  public T getOrThrow()
  {
    try
    {
      Object localObject = get();
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException(localInterruptedException);
    }
    catch (ExecutionException localExecutionException)
    {
      label8: break label8;
    }
  }

  @Nullable
  public T getOrThrow(long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      Object localObject = get(paramLong, paramTimeUnit);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException(localInterruptedException);
    }
    catch (ExecutionException localExecutionException)
    {
      break label13;
    }
    catch (TimeoutException localTimeoutException)
    {
      label13: break label13;
    }
  }

  public boolean isCancelled()
  {
    return false;
  }

  public boolean isDone()
  {
    return this.mReadyLatch.getCount() == 0L;
  }

  public void set(@Nullable T paramT)
  {
    checkNotSet();
    this.mResult = paramT;
    this.mReadyLatch.countDown();
  }

  public void setException(Exception paramException)
  {
    checkNotSet();
    this.mException = paramException;
    this.mReadyLatch.countDown();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.common.futures.SimpleSettableFuture
 * JD-Core Version:    0.6.2
 */