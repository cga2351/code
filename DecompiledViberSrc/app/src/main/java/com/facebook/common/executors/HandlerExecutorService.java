package com.facebook.common.executors;

import java.util.concurrent.ScheduledExecutorService;

public abstract interface HandlerExecutorService extends ScheduledExecutorService
{
  public abstract boolean isHandlerThread();

  public abstract void quit();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.executors.HandlerExecutorService
 * JD-Core Version:    0.6.2
 */