package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class RetainingDataSourceSupplier<T>
  implements Supplier<DataSource<T>>
{

  @Nullable
  private Supplier<DataSource<T>> mCurrentDataSourceSupplier = null;
  private final Set<RetainingDataSource> mDataSources = Collections.newSetFromMap(new WeakHashMap());

  public DataSource<T> get()
  {
    RetainingDataSource localRetainingDataSource = new RetainingDataSource(null);
    localRetainingDataSource.setSupplier(this.mCurrentDataSourceSupplier);
    this.mDataSources.add(localRetainingDataSource);
    return localRetainingDataSource;
  }

  public void replaceSupplier(Supplier<DataSource<T>> paramSupplier)
  {
    this.mCurrentDataSourceSupplier = paramSupplier;
    Iterator localIterator = this.mDataSources.iterator();
    while (localIterator.hasNext())
    {
      RetainingDataSource localRetainingDataSource = (RetainingDataSource)localIterator.next();
      if (!localRetainingDataSource.isClosed())
        localRetainingDataSource.setSupplier(paramSupplier);
    }
  }

  private static class RetainingDataSource<T> extends AbstractDataSource<T>
  {

    @Nullable
    @GuardedBy("RetainingDataSource.this")
    private DataSource<T> mDataSource = null;

    private static <T> void closeSafely(DataSource<T> paramDataSource)
    {
      if (paramDataSource != null)
        paramDataSource.close();
    }

    private void onDataSourceFailed(DataSource<T> paramDataSource)
    {
    }

    private void onDataSourceNewResult(DataSource<T> paramDataSource)
    {
      if (paramDataSource == this.mDataSource)
        setResult(null, false);
    }

    private void onDatasourceProgress(DataSource<T> paramDataSource)
    {
      if (paramDataSource == this.mDataSource)
        setProgress(paramDataSource.getProgress());
    }

    public boolean close()
    {
      try
      {
        if (!super.close())
          return false;
        DataSource localDataSource = this.mDataSource;
        this.mDataSource = null;
        closeSafely(localDataSource);
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
        if (this.mDataSource != null)
        {
          Object localObject3 = this.mDataSource.getResult();
          localObject2 = localObject3;
          return localObject2;
        }
        Object localObject2 = null;
      }
      finally
      {
      }
    }

    public boolean hasResult()
    {
      try
      {
        if (this.mDataSource != null)
        {
          boolean bool2 = this.mDataSource.hasResult();
          if (bool2)
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

    public void setSupplier(@Nullable Supplier<DataSource<T>> paramSupplier)
    {
      if (isClosed())
        return;
      if (paramSupplier != null);
      for (DataSource localDataSource1 = (DataSource)paramSupplier.get(); ; localDataSource1 = null)
        try
        {
          if (!isClosed())
            break;
          closeSafely(localDataSource1);
          return;
        }
        finally
        {
        }
      DataSource localDataSource2 = this.mDataSource;
      this.mDataSource = localDataSource1;
      if (localDataSource1 != null)
        localDataSource1.subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.getInstance());
      closeSafely(localDataSource2);
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
        RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceFailed(paramDataSource);
      }

      public void onNewResult(DataSource<T> paramDataSource)
      {
        if (paramDataSource.hasResult())
          RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceNewResult(paramDataSource);
        while (!paramDataSource.isFinished())
          return;
        RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceFailed(paramDataSource);
      }

      public void onProgressUpdate(DataSource<T> paramDataSource)
      {
        RetainingDataSourceSupplier.RetainingDataSource.this.onDatasourceProgress(paramDataSource);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.datasource.RetainingDataSourceSupplier
 * JD-Core Version:    0.6.2
 */