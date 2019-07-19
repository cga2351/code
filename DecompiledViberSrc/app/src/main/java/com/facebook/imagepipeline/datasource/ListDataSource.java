package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>>
{
  private final DataSource<CloseableReference<T>>[] mDataSources;

  @GuardedBy("this")
  private int mFinishedDataSources;

  protected ListDataSource(DataSource<CloseableReference<T>>[] paramArrayOfDataSource)
  {
    this.mDataSources = paramArrayOfDataSource;
    this.mFinishedDataSources = 0;
  }

  public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>[] paramArrayOfDataSource)
  {
    int i = 0;
    Preconditions.checkNotNull(paramArrayOfDataSource);
    if (paramArrayOfDataSource.length > 0);
    ListDataSource localListDataSource;
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      localListDataSource = new ListDataSource(paramArrayOfDataSource);
      int j = paramArrayOfDataSource.length;
      while (i < j)
      {
        DataSource<CloseableReference<T>> localDataSource = paramArrayOfDataSource[i];
        if (localDataSource != null)
        {
          localListDataSource.getClass();
          localDataSource.subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.getInstance());
        }
        i++;
      }
    }
    return localListDataSource;
  }

  private boolean increaseAndCheckIfLast()
  {
    try
    {
      int i = 1 + this.mFinishedDataSources;
      this.mFinishedDataSources = i;
      int j = this.mDataSources.length;
      if (i == j)
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

  private void onDataSourceCancelled()
  {
    setFailure(new CancellationException());
  }

  private void onDataSourceFailed(DataSource<CloseableReference<T>> paramDataSource)
  {
    setFailure(paramDataSource.getFailureCause());
  }

  private void onDataSourceFinished()
  {
    if (increaseAndCheckIfLast())
      setResult(null, true);
  }

  private void onDataSourceProgress()
  {
    float f = 0.0F;
    DataSource[] arrayOfDataSource = this.mDataSources;
    int i = arrayOfDataSource.length;
    for (int j = 0; j < i; j++)
      f += arrayOfDataSource[j].getProgress();
    setProgress(f / this.mDataSources.length);
  }

  public boolean close()
  {
    int i = 0;
    if (!super.close())
      return false;
    DataSource[] arrayOfDataSource = this.mDataSources;
    int j = arrayOfDataSource.length;
    while (i < j)
    {
      arrayOfDataSource[i].close();
      i++;
    }
    return true;
  }

  @Nullable
  public List<CloseableReference<T>> getResult()
  {
    try
    {
      boolean bool = hasResult();
      Object localObject2;
      if (!bool)
        localObject2 = null;
      while (true)
      {
        return localObject2;
        localObject2 = new ArrayList(this.mDataSources.length);
        DataSource[] arrayOfDataSource = this.mDataSources;
        int i = arrayOfDataSource.length;
        for (int j = 0; j < i; j++)
          ((List)localObject2).add(arrayOfDataSource[j].getResult());
      }
    }
    finally
    {
    }
  }

  public boolean hasResult()
  {
    try
    {
      if (!isClosed())
      {
        int i = this.mFinishedDataSources;
        int j = this.mDataSources.length;
        if (i == j)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  private class InternalDataSubscriber
    implements DataSubscriber<CloseableReference<T>>
  {

    @GuardedBy("InternalDataSubscriber.this")
    boolean mFinished = false;

    private InternalDataSubscriber()
    {
    }

    private boolean tryFinish()
    {
      boolean bool1 = true;
      try
      {
        boolean bool2 = this.mFinished;
        if (bool2)
          bool1 = false;
        while (true)
        {
          return bool1;
          this.mFinished = true;
        }
      }
      finally
      {
      }
    }

    public void onCancellation(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceCancelled();
    }

    public void onFailure(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceFailed(paramDataSource);
    }

    public void onNewResult(DataSource<CloseableReference<T>> paramDataSource)
    {
      if ((paramDataSource.isFinished()) && (tryFinish()))
        ListDataSource.this.onDataSourceFinished();
    }

    public void onProgressUpdate(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceProgress();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.datasource.ListDataSource
 * JD-Core Version:    0.6.2
 */