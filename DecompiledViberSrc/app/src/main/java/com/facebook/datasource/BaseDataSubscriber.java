package com.facebook.datasource;

public abstract class BaseDataSubscriber<T>
  implements DataSubscriber<T>
{
  public void onCancellation(DataSource<T> paramDataSource)
  {
  }

  public void onFailure(DataSource<T> paramDataSource)
  {
    try
    {
      onFailureImpl(paramDataSource);
      return;
    }
    finally
    {
      paramDataSource.close();
    }
  }

  protected abstract void onFailureImpl(DataSource<T> paramDataSource);

  public void onNewResult(DataSource<T> paramDataSource)
  {
    boolean bool = paramDataSource.isFinished();
    try
    {
      onNewResultImpl(paramDataSource);
      return;
    }
    finally
    {
      if (bool)
        paramDataSource.close();
    }
  }

  protected abstract void onNewResultImpl(DataSource<T> paramDataSource);

  public void onProgressUpdate(DataSource<T> paramDataSource)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.datasource.BaseDataSubscriber
 * JD-Core Version:    0.6.2
 */