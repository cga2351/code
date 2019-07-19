package com.facebook.react.common;

public class SystemClock
{
  public static long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }

  public static long nanoTime()
  {
    return System.nanoTime();
  }

  public static long uptimeMillis()
  {
    return android.os.SystemClock.uptimeMillis();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.common.SystemClock
 * JD-Core Version:    0.6.2
 */