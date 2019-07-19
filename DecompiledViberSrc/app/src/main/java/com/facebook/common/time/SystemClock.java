package com.facebook.common.time;

public class SystemClock
  implements Clock
{
  private static final SystemClock INSTANCE = new SystemClock();

  public static SystemClock get()
  {
    return INSTANCE;
  }

  public long now()
  {
    return System.currentTimeMillis();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.time.SystemClock
 * JD-Core Version:    0.6.2
 */