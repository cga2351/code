package f;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class i extends u
{
  private u a;

  public i(u paramu)
  {
    if (paramu == null)
      throw new IllegalArgumentException("delegate == null");
    this.a = paramu;
  }

  public final i a(u paramu)
  {
    if (paramu == null)
      throw new IllegalArgumentException("delegate == null");
    this.a = paramu;
    return this;
  }

  public final u a()
  {
    return this.a;
  }

  public u clearDeadline()
  {
    return this.a.clearDeadline();
  }

  public u clearTimeout()
  {
    return this.a.clearTimeout();
  }

  public long deadlineNanoTime()
  {
    return this.a.deadlineNanoTime();
  }

  public u deadlineNanoTime(long paramLong)
  {
    return this.a.deadlineNanoTime(paramLong);
  }

  public boolean hasDeadline()
  {
    return this.a.hasDeadline();
  }

  public void throwIfReached()
    throws IOException
  {
    this.a.throwIfReached();
  }

  public u timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.timeout(paramLong, paramTimeUnit);
  }

  public long timeoutNanos()
  {
    return this.a.timeoutNanos();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.i
 * JD-Core Version:    0.6.2
 */