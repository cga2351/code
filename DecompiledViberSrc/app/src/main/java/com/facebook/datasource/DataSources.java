package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class DataSources
{
  public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(Throwable paramThrowable)
  {
    return new Supplier()
    {
      public DataSource<T> get()
      {
        return DataSources.immediateFailedDataSource(this.val$failure);
      }
    };
  }

  public static <T> DataSource<T> immediateDataSource(T paramT)
  {
    SimpleDataSource localSimpleDataSource = SimpleDataSource.create();
    localSimpleDataSource.setResult(paramT);
    return localSimpleDataSource;
  }

  public static <T> DataSource<T> immediateFailedDataSource(Throwable paramThrowable)
  {
    SimpleDataSource localSimpleDataSource = SimpleDataSource.create();
    localSimpleDataSource.setFailure(paramThrowable);
    return localSimpleDataSource;
  }

  @Nullable
  public static <T> T waitForFinalResult(DataSource<T> paramDataSource)
    throws Throwable
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    ValueHolder localValueHolder1 = new ValueHolder(null);
    final ValueHolder localValueHolder2 = new ValueHolder(null);
    paramDataSource.subscribe(new DataSubscriber()
    {
      public void onCancellation(DataSource<T> paramAnonymousDataSource)
      {
        localCountDownLatch.countDown();
      }

      public void onFailure(DataSource<T> paramAnonymousDataSource)
      {
        try
        {
          localValueHolder2.value = paramAnonymousDataSource.getFailureCause();
          return;
        }
        finally
        {
          localCountDownLatch.countDown();
        }
      }

      public void onNewResult(DataSource<T> paramAnonymousDataSource)
      {
        if (!paramAnonymousDataSource.isFinished())
          return;
        try
        {
          this.val$resultHolder.value = paramAnonymousDataSource.getResult();
          return;
        }
        finally
        {
          localCountDownLatch.countDown();
        }
      }

      public void onProgressUpdate(DataSource<T> paramAnonymousDataSource)
      {
      }
    }
    , new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable.run();
      }
    });
    localCountDownLatch.await();
    if (localValueHolder2.value != null)
      throw ((Throwable)localValueHolder2.value);
    return localValueHolder1.value;
  }

  private static class ValueHolder<T>
  {

    @Nullable
    public T value = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.datasource.DataSources
 * JD-Core Version:    0.6.2
 */