package com.facebook.datasource;

public abstract class BaseBooleanSubscriber
  implements DataSubscriber<Boolean>
{
  public void onCancellation(DataSource<Boolean> paramDataSource)
  {
  }

  public void onFailure(DataSource<Boolean> paramDataSource)
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

  protected abstract void onFailureImpl(DataSource<Boolean> paramDataSource);

  public void onNewResult(DataSource<Boolean> paramDataSource)
  {
    try
    {
      onNewResultImpl(((Boolean)paramDataSource.getResult()).booleanValue());
      return;
    }
    finally
    {
      paramDataSource.close();
    }
  }

  protected abstract void onNewResultImpl(boolean paramBoolean);

  public void onProgressUpdate(DataSource<Boolean> paramDataSource)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.datasource.BaseBooleanSubscriber
 * JD-Core Version:    0.6.2
 */