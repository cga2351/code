package com.facebook.react.bridge.queue;

public abstract interface ReactQueueConfiguration
{
  public abstract void destroy();

  public abstract MessageQueueThread getJSQueueThread();

  public abstract MessageQueueThread getNativeModulesQueueThread();

  public abstract MessageQueueThread getUIQueueThread();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.ReactQueueConfiguration
 * JD-Core Version:    0.6.2
 */