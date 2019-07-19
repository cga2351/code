package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class IncreasingQualityDataSourceSupplier<T>
  implements Supplier<DataSource<T>>
{
  private final boolean mDataSourceLazy;
  private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

  private IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> paramList, boolean paramBoolean)
  {
    if (!paramList.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "List of suppliers is empty!");
      this.mDataSourceSuppliers = paramList;
      this.mDataSourceLazy = paramBoolean;
      return;
    }
  }

  public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> paramList)
  {
    return create(paramList, false);
  }

  public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> paramList, boolean paramBoolean)
  {
    return new IncreasingQualityDataSourceSupplier(paramList, paramBoolean);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!(paramObject instanceof IncreasingQualityDataSourceSupplier))
      return false;
    IncreasingQualityDataSourceSupplier localIncreasingQualityDataSourceSupplier = (IncreasingQualityDataSourceSupplier)paramObject;
    return Objects.equal(this.mDataSourceSuppliers, localIncreasingQualityDataSourceSupplier.mDataSourceSuppliers);
  }

  public DataSource<T> get()
  {
    return new IncreasingQualityDataSource();
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
  private class IncreasingQualityDataSource extends AbstractDataSource<T>
  {

    @Nullable
    @GuardedBy("IncreasingQualityDataSource.this")
    private ArrayList<DataSource<T>> mDataSources;

    @Nullable
    private Throwable mDelayedError;
    private AtomicInteger mFinishedDataSources;

    @GuardedBy("IncreasingQualityDataSource.this")
    private int mIndexOfDataSourceWithResult;
    private int mNumberOfDataSources;

    public IncreasingQualityDataSource()
    {
      if (!IncreasingQualityDataSourceSupplier.this.mDataSourceLazy)
        ensureDataSourceInitialized();
    }

    private void closeSafely(DataSource<T> paramDataSource)
    {
      if (paramDataSource != null)
        paramDataSource.close();
    }

    private void ensureDataSourceInitialized()
    {
      if (this.mFinishedDataSources != null)
        return;
      while (true)
      {
        int j;
        try
        {
          if (this.mFinishedDataSources == null)
          {
            this.mFinishedDataSources = new AtomicInteger(0);
            int i = IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.size();
            this.mNumberOfDataSources = i;
            this.mIndexOfDataSourceWithResult = i;
            this.mDataSources = new ArrayList(i);
            j = 0;
            if (j < i)
            {
              DataSource localDataSource = (DataSource)((Supplier)IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.get(j)).get();
              this.mDataSources.add(localDataSource);
              localDataSource.subscribe(new InternalDataSubscriber(j), CallerThreadExecutor.getInstance());
              if (!localDataSource.hasResult())
                break label144;
            }
          }
          return;
        }
        finally
        {
        }
        label144: j++;
      }
    }

    @Nullable
    private DataSource<T> getAndClearDataSource(int paramInt)
    {
      try
      {
        ArrayList localArrayList = this.mDataSources;
        DataSource localDataSource = null;
        if (localArrayList != null)
        {
          int i = this.mDataSources.size();
          localDataSource = null;
          if (paramInt < i)
            localDataSource = (DataSource)this.mDataSources.set(paramInt, null);
        }
        return localDataSource;
      }
      finally
      {
      }
    }

    @Nullable
    private DataSource<T> getDataSource(int paramInt)
    {
      try
      {
        if ((this.mDataSources != null) && (paramInt < this.mDataSources.size()))
        {
          localDataSource = (DataSource)this.mDataSources.get(paramInt);
          return localDataSource;
        }
        DataSource localDataSource = null;
      }
      finally
      {
      }
    }

    @Nullable
    private DataSource<T> getDataSourceWithResult()
    {
      try
      {
        DataSource localDataSource = getDataSource(this.mIndexOfDataSourceWithResult);
        return localDataSource;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    private void maybeSetFailure()
    {
      if ((this.mFinishedDataSources.incrementAndGet() == this.mNumberOfDataSources) && (this.mDelayedError != null))
        setFailure(this.mDelayedError);
    }

    private void maybeSetIndexOfDataSourceWithResult(int paramInt, DataSource<T> paramDataSource, boolean paramBoolean)
    {
      while (true)
      {
        int j;
        try
        {
          int i = this.mIndexOfDataSourceWithResult;
          j = this.mIndexOfDataSourceWithResult;
          if ((paramDataSource != getDataSource(paramInt)) || (paramInt == this.mIndexOfDataSourceWithResult))
            return;
          if ((getDataSourceWithResult() == null) || ((paramBoolean) && (paramInt < this.mIndexOfDataSourceWithResult)))
          {
            this.mIndexOfDataSourceWithResult = paramInt;
            if (i <= paramInt)
              break;
            closeSafely(getAndClearDataSource(i));
            i--;
            continue;
          }
        }
        finally
        {
        }
        paramInt = j;
      }
    }

    private void onDataSourceFailed(int paramInt, DataSource<T> paramDataSource)
    {
      closeSafely(tryGetAndClearDataSource(paramInt, paramDataSource));
      if (paramInt == 0)
        this.mDelayedError = paramDataSource.getFailureCause();
      maybeSetFailure();
    }

    private void onDataSourceNewResult(int paramInt, DataSource<T> paramDataSource)
    {
      maybeSetIndexOfDataSourceWithResult(paramInt, paramDataSource, paramDataSource.isFinished());
      if (paramDataSource == getDataSourceWithResult())
        if ((paramInt != 0) || (!paramDataSource.isFinished()))
          break label47;
      label47: for (boolean bool = true; ; bool = false)
      {
        setResult(null, bool);
        maybeSetFailure();
        return;
      }
    }

    @Nullable
    private DataSource<T> tryGetAndClearDataSource(int paramInt, DataSource<T> paramDataSource)
    {
      try
      {
        DataSource localDataSource1 = getDataSourceWithResult();
        if (paramDataSource == localDataSource1)
          paramDataSource = null;
        while (true)
        {
          return paramDataSource;
          if (paramDataSource == getDataSource(paramInt))
          {
            DataSource localDataSource2 = getAndClearDataSource(paramInt);
            paramDataSource = localDataSource2;
          }
        }
      }
      finally
      {
      }
    }

    public boolean close()
    {
      if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy)
        ensureDataSourceInitialized();
      try
      {
        if (!super.close())
          return false;
        ArrayList localArrayList = this.mDataSources;
        this.mDataSources = null;
        if (localArrayList != null)
          for (int i = 0; i < localArrayList.size(); i++)
            closeSafely((DataSource)localArrayList.get(i));
      }
      finally
      {
      }
      return true;
    }

    @Nullable
    public T getResult()
    {
      try
      {
        if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy)
          ensureDataSourceInitialized();
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
        if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy)
          ensureDataSourceInitialized();
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
      private int mIndex;

      public InternalDataSubscriber(int arg2)
      {
        int i;
        this.mIndex = i;
      }

      public void onCancellation(DataSource<T> paramDataSource)
      {
      }

      public void onFailure(DataSource<T> paramDataSource)
      {
        IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, paramDataSource);
      }

      public void onNewResult(DataSource<T> paramDataSource)
      {
        if (paramDataSource.hasResult())
          IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceNewResult(this.mIndex, paramDataSource);
        while (!paramDataSource.isFinished())
          return;
        IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, paramDataSource);
      }

      public void onProgressUpdate(DataSource<T> paramDataSource)
      {
        if (this.mIndex == 0)
          IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.setProgress(paramDataSource.getProgress());
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.datasource.IncreasingQualityDataSourceSupplier
 * JD-Core Version:    0.6.2
 */