package com.mopub.common.util;

import java.util.concurrent.TimeUnit;

public class Timer
{
  private long a;
  private long b;
  private a c = a.STOPPED;

  public long getTime()
  {
    if (this.c == a.STARTED);
    for (long l = System.nanoTime(); ; l = this.a)
      return TimeUnit.MILLISECONDS.convert(l - this.b, TimeUnit.NANOSECONDS);
  }

  public void start()
  {
    this.b = System.nanoTime();
    this.c = a.STARTED;
  }

  public void stop()
  {
    if (this.c != a.STARTED)
      throw new IllegalStateException("EventTimer was not started.");
    this.c = a.STOPPED;
    this.a = System.nanoTime();
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = STARTED;
      arrayOfa[1] = STOPPED;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.Timer
 * JD-Core Version:    0.6.2
 */