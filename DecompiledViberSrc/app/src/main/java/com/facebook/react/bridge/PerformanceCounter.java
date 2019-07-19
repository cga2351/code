package com.facebook.react.bridge;

import java.util.Map;

public abstract interface PerformanceCounter
{
  public abstract Map<String, Long> getPerformanceCounters();

  public abstract void profileNextBatch();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.PerformanceCounter
 * JD-Core Version:    0.6.2
 */