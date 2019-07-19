package com.facebook.datasource;

public abstract interface DataSubscriber<T>
{
  public abstract void onCancellation(DataSource<T> paramDataSource);

  public abstract void onFailure(DataSource<T> paramDataSource);

  public abstract void onNewResult(DataSource<T> paramDataSource);

  public abstract void onProgressUpdate(DataSource<T> paramDataSource);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.datasource.DataSubscriber
 * JD-Core Version:    0.6.2
 */