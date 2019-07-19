package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class FirstAvailableDataSourceSupplier<T>
  implements Supplier<DataSource<T>>
{
  private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

  private FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> paramList)
  {
    if (!paramList.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "List of suppliers is empty!");
      this.mDataSourceSuppliers = paramList;
      return;
    }
  }

  public static <T> FirstAvailableDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> paramList)
  {
    return new FirstAvailableDataSourceSupplier(paramList);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!(paramObject instanceof FirstAvailableDataSourceSupplier))
      return false;
    FirstAvailableDataSourceSupplier localFirstAvailableDataSourceSupplier = (FirstAvailableDataSourceSupplier)paramObject;
    return Objects.equal(this.mDataSourceSuppliers, localFirstAvailableDataSourceSupplier.mDataSourceSuppliers);
  }

  public DataSource<T> get()
  {
    return new FirstAvailableDataSource();
  }

  public int hashCode()
  {
    return this.mDataSourceSuppliers.hashCode();
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("list", this.mDataSourceSuppliers).toString();
  }

  @ThreadSafe
  private class FirstAvailableDataSource extends AbstractDataSource<T>
  {
    private DataSource<T> mCurrentDataSource = null;
    private DataSource<T> mDataSourceWithResult = null;
    private int mIndex = 0;

    public FirstAvailableDataSource()
    {
      if (!startNextDataSource())
        setFailure(new RuntimeException("No data source supplier or supplier returned null."));
    }

    private boolean clearCurrentDataSource(DataSource<T> paramDataSource)
    {
      try
      {
        if (!isClosed())
        {
          DataSource localDataSource = this.mCurrentDataSource;
          if (paramDataSource == localDataSource)
            break label27;
        }
        for (boolean bool = false; ; bool = true)
        {
          return bool;
          label27: this.mCurrentDataSource = null;
        }
      }
      finally
      {
      }
    }

    private void closeSafely(DataSource<T> paramDataSource)
    {
      if (paramDataSource != null)
        paramDataSource.close();
    }

    @Nullable
    private DataSource<T> getDataSourceWithResult()
    {
      try
      {
        DataSource localDataSource = this.mDataSourceWithResult;
        return localDataSource;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    @Nullable
    private Supplier<DataSource<T>> getNextSupplier()
    {
      try
      {
        if ((!isClosed()) && (this.mIndex < FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers.size()))
        {
          List localList = FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers;
          int i = this.mIndex;
          this.mIndex = (i + 1);
          localSupplier = (Supplier)localList.get(i);
          return localSupplier;
        }
        Supplier localSupplier = null;
      }
      finally
      {
      }
    }

    private void maybeSetDataSourceWithResult(DataSource<T> paramDataSource, boolean paramBoolean)
    {
      try
      {
        if ((paramDataSource != this.mCurrentDataSource) || (paramDataSource == this.mDataSourceWithResult))
          return;
        DataSource localDataSource;
        if (this.mDataSourceWithResult != null)
        {
          localDataSource = null;
          if (!paramBoolean);
        }
        else
        {
          localDataSource = this.mDataSourceWithResult;
          this.mDataSourceWithResult = paramDataSource;
        }
        closeSafely(localDataSource);
        return;
      }
      finally
      {
      }
    }

    private void onDataSourceFailed(DataSource<T> paramDataSource)
    {
      if (!clearCurrentDataSource(paramDataSource));
      do
      {
        return;
        if (paramDataSource != getDataSourceWithResult())
          closeSafely(paramDataSource);
      }
      while (startNextDataSource());
      setFailure(paramDataSource.getFailureCause());
    }

    private void onDataSourceNewResult(DataSource<T> paramDataSource)
    {
      maybeSetDataSourceWithResult(paramDataSource, paramDataSource.isFinished());
      if (paramDataSource == getDataSourceWithResult())
        setResult(null, paramDataSource.isFinished());
    }

    private boolean setCurrentDataSource(DataSource<T> paramDataSource)
    {
      try
      {
        boolean bool1 = isClosed();
        if (bool1);
        for (boolean bool2 = false; ; bool2 = true)
        {
          return bool2;
          this.mCurrentDataSource = paramDataSource;
        }
      }
      finally
      {
      }
    }

    private boolean startNextDataSource()
    {
      Supplier localSupplier = getNextSupplier();
      if (localSupplier != null);
      for (DataSource localDataSource = (DataSource)localSupplier.get(); (setCurrentDataSource(localDataSource)) && (localDataSource != null); localDataSource = null)
      {
        localDataSource.subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.getInstance());
        return true;
      }
      closeSafely(localDataSource);
      return false;
    }

    public boolean close()
    {
      try
      {
        if (!super.close())
          return false;
        DataSource localDataSource1 = this.mCurrentDataSource;
        this.mCurrentDataSource = null;
        DataSource localDataSource2 = this.mDataSourceWithResult;
        this.mDataSourceWithResult = null;
        closeSafely(localDataSource2);
        closeSafely(localDataSource1);
        return true;
      }
      finally
      {
      }
    }

    @Nullable
    public T getResult()
    {
      try
      {
        DataSource localDataSource = getDataSourceWithResult();
        Object localObject2;
        if (localDataSource != null)
          localObject2 = localDataSource.getResult();
        for (Object localObject3 = localObject2; ; localObject3 = null)
          return localObject3;
      }
      finally
      {
      }
    }

    public boolean hasResult()
    {
      try
      {
        DataSource localDataSource = getDataSourceWithResult();
        if (localDataSource != null)
        {
          boolean bool1 = localDataSource.hasResult();
          if (!bool1);
        }
        for (boolean bool2 = true; ; bool2 = false)
          return bool2;
      }
      finally
      {
      }
    }

    private class InternalDataSubscriber
      implements DataSubscriber<T>
    {
      private InternalDataSubscriber()
      {
      }

      public void onCancellation(DataSource<T> paramDataSource)
      {
      }

      public void onFailure(DataSource<T> paramDataSource)
      {
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceFailed(paramDataSource);
      }

      public void onNewResult(DataSource<T> paramDataSource)
      {
        if (paramDataSource.hasResult())
          FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceNewResult(paramDataSource);
        while (!paramDataSource.isFinished())
          return;
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceFailed(paramDataSource);
      }

      public void onProgressUpdate(DataSource<T> paramDataSource)
      {
        float f = FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.getProgress();
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.setProgress(Math.max(f, paramDataSource.getProgress()));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.datasource.FirstAvailableDataSourceSupplier
 * JD-Core Version:    0.6.2
 */