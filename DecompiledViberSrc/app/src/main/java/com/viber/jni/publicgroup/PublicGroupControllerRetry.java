package com.viber.jni.publicgroup;

import android.util.SparseArray;
import android.util.SparseIntArray;

public class PublicGroupControllerRetry extends PublicGroupControllerWrapper
{
  private static final int MAX_RETRY = 3;
  private SparseIntArray mRetryCounter = new SparseIntArray();
  private SparseArray<Runnable> mRetryTasks = new SparseArray();

  public PublicGroupControllerRetry(PublicGroupController paramPublicGroupController)
  {
    super(paramPublicGroupController);
  }

  public boolean handleGetPublicGroupMessages(final int paramInt1, final long paramLong, int paramInt2)
  {
    return tryTask(paramInt1, new Runnable()
    {
      public void run()
      {
        PublicGroupControllerRetry.this.handleGetPublicGroupMessages(paramInt1, paramLong, this.val$lastMessageId);
      }
    });
  }

  void removeTask(int paramInt)
  {
    try
    {
      this.mRetryTasks.delete(paramInt);
      this.mRetryCounter.delete(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  boolean retryTask(int paramInt)
  {
    try
    {
      int i = this.mRetryCounter.get(paramInt, 0);
      int j = this.mRetryTasks.indexOfKey(paramInt);
      boolean bool = false;
      if (j >= 0)
      {
        bool = false;
        if (i < 3)
        {
          ((Runnable)this.mRetryTasks.get(paramInt)).run();
          int k = i + 1;
          this.mRetryCounter.put(paramInt, k);
          bool = true;
        }
      }
      return bool;
    }
    finally
    {
    }
  }

  boolean tryTask(int paramInt, Runnable paramRunnable)
  {
    try
    {
      this.mRetryTasks.put(paramInt, paramRunnable);
      this.mRetryCounter.put(paramInt, 1);
      paramRunnable.run();
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicgroup.PublicGroupControllerRetry
 * JD-Core Version:    0.6.2
 */