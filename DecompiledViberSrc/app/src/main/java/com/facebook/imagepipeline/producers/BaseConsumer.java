package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class BaseConsumer<T>
  implements Consumer<T>
{
  private boolean mIsFinished = false;

  public static boolean isLast(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }

  public static boolean isNotLast(int paramInt)
  {
    return !isLast(paramInt);
  }

  public static int simpleStatusForIsLast(boolean paramBoolean)
  {
    if (paramBoolean)
      return 1;
    return 0;
  }

  public static boolean statusHasAnyFlag(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }

  public static boolean statusHasFlag(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }

  public static int turnOffStatusFlag(int paramInt1, int paramInt2)
  {
    return paramInt1 & (paramInt2 ^ 0xFFFFFFFF);
  }

  public static int turnOnStatusFlag(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }

  public void onCancellation()
  {
    try
    {
      boolean bool = this.mIsFinished;
      if (bool);
      while (true)
      {
        return;
        this.mIsFinished = true;
        try
        {
          onCancellationImpl();
        }
        catch (Exception localException)
        {
          onUnhandledException(localException);
        }
      }
    }
    finally
    {
    }
  }

  protected abstract void onCancellationImpl();

  public void onFailure(Throwable paramThrowable)
  {
    try
    {
      boolean bool = this.mIsFinished;
      if (bool);
      while (true)
      {
        return;
        this.mIsFinished = true;
        try
        {
          onFailureImpl(paramThrowable);
        }
        catch (Exception localException)
        {
          onUnhandledException(localException);
        }
      }
    }
    finally
    {
    }
  }

  protected abstract void onFailureImpl(Throwable paramThrowable);

  public void onNewResult(@Nullable T paramT, int paramInt)
  {
    try
    {
      boolean bool = this.mIsFinished;
      if (bool);
      while (true)
      {
        return;
        this.mIsFinished = isLast(paramInt);
        try
        {
          onNewResultImpl(paramT, paramInt);
        }
        catch (Exception localException)
        {
          onUnhandledException(localException);
        }
      }
    }
    finally
    {
    }
  }

  protected abstract void onNewResultImpl(T paramT, int paramInt);

  public void onProgressUpdate(float paramFloat)
  {
    try
    {
      boolean bool = this.mIsFinished;
      if (bool);
      while (true)
      {
        return;
        try
        {
          onProgressUpdateImpl(paramFloat);
        }
        catch (Exception localException)
        {
          onUnhandledException(localException);
        }
      }
    }
    finally
    {
    }
  }

  protected void onProgressUpdateImpl(float paramFloat)
  {
  }

  protected void onUnhandledException(Exception paramException)
  {
    FLog.wtf(getClass(), "unhandled exception", paramException);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.BaseConsumer
 * JD-Core Version:    0.6.2
 */