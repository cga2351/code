package com.facebook.imagepipeline.core;

import java.util.concurrent.Executor;

public abstract interface ExecutorSupplier
{
  public abstract Executor forBackgroundTasks();

  public abstract Executor forDecode();

  public abstract Executor forLightweightBackgroundTasks();

  public abstract Executor forLocalStorageRead();

  public abstract Executor forLocalStorageWrite();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.ExecutorSupplier
 * JD-Core Version:    0.6.2
 */