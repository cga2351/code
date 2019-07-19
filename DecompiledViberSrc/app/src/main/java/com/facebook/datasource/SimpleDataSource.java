package com.facebook.datasource;

import com.facebook.common.internal.Preconditions;

public class SimpleDataSource<T> extends AbstractDataSource<T>
{
  public static <T> SimpleDataSource<T> create()
  {
    return new SimpleDataSource();
  }

  public boolean setFailure(Throwable paramThrowable)
  {
    return super.setFailure((Throwable)Preconditions.checkNotNull(paramThrowable));
  }

  public boolean setProgress(float paramFloat)
  {
    return super.setProgress(paramFloat);
  }

  public boolean setResult(T paramT)
  {
    return super.setResult(Preconditions.checkNotNull(paramT), true);
  }

  public boolean setResult(T paramT, boolean paramBoolean)
  {
    return super.setResult(Preconditions.checkNotNull(paramT), paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.datasource.SimpleDataSource
 * JD-Core Version:    0.6.2
 */