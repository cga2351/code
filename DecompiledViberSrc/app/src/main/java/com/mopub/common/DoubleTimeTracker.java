package com.mopub.common;

import android.os.SystemClock;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

public class DoubleTimeTracker
{
  private volatile a a;
  private long b;
  private long c;
  private final Clock d;

  public DoubleTimeTracker()
  {
    this(new b(null));
  }

  @VisibleForTesting
  public DoubleTimeTracker(Clock paramClock)
  {
    this.d = paramClock;
    this.a = a.PAUSED;
  }

  private long a()
  {
    try
    {
      a locala1 = this.a;
      a locala2 = a.PAUSED;
      if (locala1 == locala2);
      long l1;
      long l2;
      for (long l3 = 0L; ; l3 = l1 - l2)
      {
        return l3;
        l1 = this.d.elapsedRealTime();
        l2 = this.b;
      }
    }
    finally
    {
    }
  }

  public double getInterval()
  {
    try
    {
      long l1 = this.c;
      long l2 = a();
      double d1 = l1 + l2;
      return d1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void pause()
  {
    try
    {
      if (this.a == a.PAUSED)
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "DoubleTimeTracker already paused." });
      while (true)
      {
        return;
        this.c += a();
        this.b = 0L;
        this.a = a.PAUSED;
      }
    }
    finally
    {
    }
  }

  public void start()
  {
    try
    {
      if (this.a == a.STARTED)
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "DoubleTimeTracker already started." });
      while (true)
      {
        return;
        this.a = a.STARTED;
        this.b = this.d.elapsedRealTime();
      }
    }
    finally
    {
    }
  }

  public static abstract interface Clock
  {
    public abstract long elapsedRealTime();
  }

  private static enum a
  {
    static
    {
      PAUSED = new a("PAUSED", 1);
      a[] arrayOfa = new a[2];
      arrayOfa[0] = STARTED;
      arrayOfa[1] = PAUSED;
    }
  }

  private static class b
    implements DoubleTimeTracker.Clock
  {
    public long elapsedRealTime()
    {
      return SystemClock.elapsedRealtime();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.DoubleTimeTracker
 * JD-Core Version:    0.6.2
 */