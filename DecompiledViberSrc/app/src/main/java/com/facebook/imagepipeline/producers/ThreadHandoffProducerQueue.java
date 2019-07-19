package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

public class ThreadHandoffProducerQueue
{
  private final Executor mExecutor;
  private boolean mQueueing = false;
  private final Deque<Runnable> mRunnableList;

  public ThreadHandoffProducerQueue(Executor paramExecutor)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mRunnableList = new ArrayDeque();
  }

  private void execInQueue()
  {
    while (!this.mRunnableList.isEmpty())
      this.mExecutor.execute((Runnable)this.mRunnableList.pop());
    this.mRunnableList.clear();
  }

  public void addToQueueOrExecute(Runnable paramRunnable)
  {
    try
    {
      if (this.mQueueing)
        this.mRunnableList.add(paramRunnable);
      while (true)
      {
        return;
        this.mExecutor.execute(paramRunnable);
      }
    }
    finally
    {
    }
  }

  public boolean isQueueing()
  {
    try
    {
      boolean bool = this.mQueueing;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void remove(Runnable paramRunnable)
  {
    try
    {
      this.mRunnableList.remove(paramRunnable);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void startQueueing()
  {
    try
    {
      this.mQueueing = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void stopQueuing()
  {
    try
    {
      this.mQueueing = false;
      execInQueue();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
 * JD-Core Version:    0.6.2
 */