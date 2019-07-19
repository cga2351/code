package com.facebook.datasource;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public abstract class AbstractDataSource<T>
  implements DataSource<T>
{

  @GuardedBy("this")
  private DataSourceStatus mDataSourceStatus = DataSourceStatus.IN_PROGRESS;

  @GuardedBy("this")
  private Throwable mFailureThrowable = null;

  @GuardedBy("this")
  private boolean mIsClosed = false;

  @GuardedBy("this")
  private float mProgress = 0.0F;

  @Nullable
  @GuardedBy("this")
  private T mResult = null;
  private final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> mSubscribers = new ConcurrentLinkedQueue();

  private void notifyDataSubscriber(final DataSubscriber<T> paramDataSubscriber, Executor paramExecutor, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    paramExecutor.execute(new Runnable()
    {
      public void run()
      {
        if (paramBoolean1)
        {
          paramDataSubscriber.onFailure(AbstractDataSource.this);
          return;
        }
        if (paramBoolean2)
        {
          paramDataSubscriber.onCancellation(AbstractDataSource.this);
          return;
        }
        paramDataSubscriber.onNewResult(AbstractDataSource.this);
      }
    });
  }

  private void notifyDataSubscribers()
  {
    boolean bool1 = hasFailed();
    boolean bool2 = wasCancelled();
    Iterator localIterator = this.mSubscribers.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      notifyDataSubscriber((DataSubscriber)localPair.first, (Executor)localPair.second, bool1, bool2);
    }
  }

  private boolean setFailureInternal(Throwable paramThrowable)
  {
    try
    {
      if (!this.mIsClosed)
      {
        DataSourceStatus localDataSourceStatus1 = this.mDataSourceStatus;
        DataSourceStatus localDataSourceStatus2 = DataSourceStatus.IN_PROGRESS;
        if (localDataSourceStatus1 == localDataSourceStatus2)
          break label33;
      }
      for (boolean bool = false; ; bool = true)
      {
        return bool;
        label33: this.mDataSourceStatus = DataSourceStatus.FAILURE;
        this.mFailureThrowable = paramThrowable;
      }
    }
    finally
    {
    }
  }

  private boolean setProgressInternal(float paramFloat)
  {
    try
    {
      boolean bool1 = this.mIsClosed;
      boolean bool2 = false;
      if (!bool1)
      {
        DataSourceStatus localDataSourceStatus1 = this.mDataSourceStatus;
        DataSourceStatus localDataSourceStatus2 = DataSourceStatus.IN_PROGRESS;
        bool2 = false;
        if (localDataSourceStatus1 == localDataSourceStatus2)
          break label40;
      }
      while (true)
      {
        return bool2;
        label40: boolean bool3 = paramFloat < this.mProgress;
        bool2 = false;
        if (!bool3)
        {
          this.mProgress = paramFloat;
          bool2 = true;
        }
      }
    }
    finally
    {
    }
  }

  // ERROR //
  private boolean setResultInternal(@Nullable T paramT, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/facebook/datasource/AbstractDataSource:mIsClosed	Z
    //   6: ifne +21 -> 27
    //   9: aload_0
    //   10: getfield 44	com/facebook/datasource/AbstractDataSource:mDataSourceStatus	Lcom/facebook/datasource/AbstractDataSource$DataSourceStatus;
    //   13: astore 6
    //   15: getstatic 42	com/facebook/datasource/AbstractDataSource$DataSourceStatus:IN_PROGRESS	Lcom/facebook/datasource/AbstractDataSource$DataSourceStatus;
    //   18: astore 7
    //   20: aload 6
    //   22: aload 7
    //   24: if_acmpeq +20 -> 44
    //   27: aload_0
    //   28: monitorexit
    //   29: iconst_0
    //   30: istore 5
    //   32: aload_1
    //   33: ifnull +8 -> 41
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 108	com/facebook/datasource/AbstractDataSource:closeResult	(Ljava/lang/Object;)V
    //   41: iload 5
    //   43: ireturn
    //   44: iload_2
    //   45: ifeq +15 -> 60
    //   48: aload_0
    //   49: getstatic 111	com/facebook/datasource/AbstractDataSource$DataSourceStatus:SUCCESS	Lcom/facebook/datasource/AbstractDataSource$DataSourceStatus;
    //   52: putfield 44	com/facebook/datasource/AbstractDataSource:mDataSourceStatus	Lcom/facebook/datasource/AbstractDataSource$DataSourceStatus;
    //   55: aload_0
    //   56: fconst_1
    //   57: putfield 35	com/facebook/datasource/AbstractDataSource:mProgress	F
    //   60: aload_0
    //   61: getfield 31	com/facebook/datasource/AbstractDataSource:mResult	Ljava/lang/Object;
    //   64: aload_1
    //   65: if_acmpeq +74 -> 139
    //   68: aload_0
    //   69: getfield 31	com/facebook/datasource/AbstractDataSource:mResult	Ljava/lang/Object;
    //   72: astore 8
    //   74: aload_0
    //   75: aload_1
    //   76: putfield 31	com/facebook/datasource/AbstractDataSource:mResult	Ljava/lang/Object;
    //   79: aload 8
    //   81: astore_1
    //   82: iconst_1
    //   83: istore 5
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: ifnull -47 -> 41
    //   91: aload_0
    //   92: aload_1
    //   93: invokevirtual 108	com/facebook/datasource/AbstractDataSource:closeResult	(Ljava/lang/Object;)V
    //   96: iload 5
    //   98: ireturn
    //   99: astore 4
    //   101: aconst_null
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload 4
    //   107: athrow
    //   108: astore_3
    //   109: aload_1
    //   110: ifnull +8 -> 118
    //   113: aload_0
    //   114: aload_1
    //   115: invokevirtual 108	com/facebook/datasource/AbstractDataSource:closeResult	(Ljava/lang/Object;)V
    //   118: aload_3
    //   119: athrow
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_1
    //   123: goto -14 -> 109
    //   126: astore 4
    //   128: goto -25 -> 103
    //   131: astore 4
    //   133: aload 8
    //   135: astore_1
    //   136: goto -33 -> 103
    //   139: aconst_null
    //   140: astore_1
    //   141: goto -59 -> 82
    //
    // Exception table:
    //   from	to	target	type
    //   2	20	99	finally
    //   48	60	99	finally
    //   60	74	99	finally
    //   105	108	108	finally
    //   0	2	120	finally
    //   27	29	126	finally
    //   85	87	126	finally
    //   103	105	126	finally
    //   74	79	131	finally
  }

  private boolean wasCancelled()
  {
    try
    {
      if (isClosed())
      {
        boolean bool2 = isFinished();
        if (!bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  public boolean close()
  {
    try
    {
      if (this.mIsClosed)
        return false;
      this.mIsClosed = true;
      Object localObject2 = this.mResult;
      this.mResult = null;
      if (localObject2 != null)
        closeResult(localObject2);
      if (!isFinished())
        notifyDataSubscribers();
      try
      {
        this.mSubscribers.clear();
        return true;
      }
      finally
      {
      }
    }
    finally
    {
    }
  }

  protected void closeResult(@Nullable T paramT)
  {
  }

  @Nullable
  public Throwable getFailureCause()
  {
    try
    {
      Throwable localThrowable = this.mFailureThrowable;
      return localThrowable;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public float getProgress()
  {
    try
    {
      float f = this.mProgress;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Nullable
  public T getResult()
  {
    try
    {
      Object localObject2 = this.mResult;
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }

  public boolean hasFailed()
  {
    try
    {
      DataSourceStatus localDataSourceStatus1 = this.mDataSourceStatus;
      DataSourceStatus localDataSourceStatus2 = DataSourceStatus.FAILURE;
      if (localDataSourceStatus1 == localDataSourceStatus2)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public boolean hasResult()
  {
    try
    {
      Object localObject2 = this.mResult;
      if (localObject2 != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public boolean isClosed()
  {
    try
    {
      boolean bool = this.mIsClosed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean isFinished()
  {
    try
    {
      DataSourceStatus localDataSourceStatus1 = this.mDataSourceStatus;
      DataSourceStatus localDataSourceStatus2 = DataSourceStatus.IN_PROGRESS;
      if (localDataSourceStatus1 != localDataSourceStatus2)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  protected void notifyProgressUpdate()
  {
    Iterator localIterator = this.mSubscribers.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      final DataSubscriber localDataSubscriber = (DataSubscriber)localPair.first;
      ((Executor)localPair.second).execute(new Runnable()
      {
        public void run()
        {
          localDataSubscriber.onProgressUpdate(AbstractDataSource.this);
        }
      });
    }
  }

  protected boolean setFailure(Throwable paramThrowable)
  {
    boolean bool = setFailureInternal(paramThrowable);
    if (bool)
      notifyDataSubscribers();
    return bool;
  }

  protected boolean setProgress(float paramFloat)
  {
    boolean bool = setProgressInternal(paramFloat);
    if (bool)
      notifyProgressUpdate();
    return bool;
  }

  protected boolean setResult(@Nullable T paramT, boolean paramBoolean)
  {
    boolean bool = setResultInternal(paramT, paramBoolean);
    if (bool)
      notifyDataSubscribers();
    return bool;
  }

  public void subscribe(DataSubscriber<T> paramDataSubscriber, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramDataSubscriber);
    Preconditions.checkNotNull(paramExecutor);
    while (true)
    {
      try
      {
        if (this.mIsClosed)
          return;
        if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS)
          this.mSubscribers.add(Pair.create(paramDataSubscriber, paramExecutor));
        if ((hasResult()) || (isFinished()))
          break label105;
        if (wasCancelled())
        {
          break label105;
          if (i != 0)
            notifyDataSubscriber(paramDataSubscriber, paramExecutor, hasFailed(), wasCancelled());
        }
        else
        {
          i = 0;
          continue;
        }
      }
      finally
      {
      }
      return;
      label105: int i = 1;
    }
  }

  private static enum DataSourceStatus
  {
    static
    {
      FAILURE = new DataSourceStatus("FAILURE", 2);
      DataSourceStatus[] arrayOfDataSourceStatus = new DataSourceStatus[3];
      arrayOfDataSourceStatus[0] = IN_PROGRESS;
      arrayOfDataSourceStatus[1] = SUCCESS;
      arrayOfDataSourceStatus[2] = FAILURE;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.datasource.AbstractDataSource
 * JD-Core Version:    0.6.2
 */