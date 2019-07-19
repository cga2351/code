package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public abstract interface DataSource<T>
{
  public abstract boolean close();

  @Nullable
  public abstract Throwable getFailureCause();

  public abstract float getProgress();

  @Nullable
  public abstract T getResult();

  public abstract boolean hasFailed();

  public abstract boolean hasResult();

  public abstract boolean isClosed();

  public abstract boolean isFinished();

  public abstract void subscribe(DataSubscriber<T> paramDataSubscriber, Executor paramExecutor);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.datasource.DataSource
 * JD-Core Version:    0.6.2
 */