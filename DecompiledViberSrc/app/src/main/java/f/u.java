package f;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class u
{
  public static final u NONE = new u()
  {
    public u deadlineNanoTime(long paramAnonymousLong)
    {
      return this;
    }

    public void throwIfReached()
      throws IOException
    {
    }

    public u timeout(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
    {
      return this;
    }
  };
  private long deadlineNanoTime;
  private boolean hasDeadline;
  private long timeoutNanos;

  public u clearDeadline()
  {
    this.hasDeadline = false;
    return this;
  }

  public u clearTimeout()
  {
    this.timeoutNanos = 0L;
    return this;
  }

  public final u deadline(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("duration <= 0: " + paramLong);
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    return deadlineNanoTime(System.nanoTime() + paramTimeUnit.toNanos(paramLong));
  }

  public long deadlineNanoTime()
  {
    if (!this.hasDeadline)
      throw new IllegalStateException("No deadline");
    return this.deadlineNanoTime;
  }

  public u deadlineNanoTime(long paramLong)
  {
    this.hasDeadline = true;
    this.deadlineNanoTime = paramLong;
    return this;
  }

  public boolean hasDeadline()
  {
    return this.hasDeadline;
  }

  public void throwIfReached()
    throws IOException
  {
    if (Thread.interrupted())
      throw new InterruptedIOException("thread interrupted");
    if ((this.hasDeadline) && (this.deadlineNanoTime - System.nanoTime() <= 0L))
      throw new InterruptedIOException("deadline reached");
  }

  public u timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("timeout < 0: " + paramLong);
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    this.timeoutNanos = paramTimeUnit.toNanos(paramLong);
    return this;
  }

  public long timeoutNanos()
  {
    return this.timeoutNanos;
  }

  public final void waitUntilNotified(Object paramObject)
    throws InterruptedIOException
  {
    long l1 = 0L;
    while (true)
    {
      boolean bool;
      long l2;
      long l3;
      try
      {
        bool = hasDeadline();
        l2 = timeoutNanos();
        if ((!bool) && (l2 == l1))
        {
          paramObject.wait();
          return;
        }
        l3 = System.nanoTime();
        if ((bool) && (l2 != l1))
        {
          l2 = Math.min(l2, deadlineNanoTime() - l3);
          if (l2 > l1)
          {
            long l5 = l2 / 1000000L;
            paramObject.wait(l5, (int)(l2 - l5 * 1000000L));
            l1 = System.nanoTime() - l3;
          }
          if (l1 < l2)
            break;
          throw new InterruptedIOException("timeout");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new InterruptedIOException("interrupted");
      }
      if (bool)
      {
        long l4 = deadlineNanoTime();
        l2 = l4 - l3;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.u
 * JD-Core Version:    0.6.2
 */