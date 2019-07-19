package f;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class a extends u
{
  private static final long IDLE_TIMEOUT_MILLIS = 0L;
  private static final long IDLE_TIMEOUT_NANOS = 0L;
  private static final int TIMEOUT_WRITE_SIZE = 65536;

  @Nullable
  static a head;
  private boolean inQueue;

  @Nullable
  private a next;
  private long timeoutAt;

  @Nullable
  static a awaitTimeout()
    throws InterruptedException
  {
    a locala1 = head.next;
    if (locala1 == null)
    {
      long l3 = System.nanoTime();
      a.class.wait(IDLE_TIMEOUT_MILLIS);
      a locala2 = head.next;
      a locala3 = null;
      if (locala2 == null)
      {
        boolean bool = System.nanoTime() - l3 < IDLE_TIMEOUT_NANOS;
        locala3 = null;
        if (!bool)
          locala3 = head;
      }
      return locala3;
    }
    long l1 = locala1.remainingNanos(System.nanoTime());
    if (l1 > 0L)
    {
      long l2 = l1 / 1000000L;
      a.class.wait(l2, (int)(l1 - 1000000L * l2));
      return null;
    }
    head.next = locala1.next;
    locala1.next = null;
    return locala1;
  }

  private static boolean cancelScheduledTimeout(a parama)
  {
    try
    {
      a locala = head;
      if (locala != null)
        if (locala.next == parama)
        {
          locala.next = parama.next;
          parama.next = null;
        }
      for (boolean bool = false; ; bool = true)
      {
        return bool;
        locala = locala.next;
        break;
      }
    }
    finally
    {
    }
  }

  private long remainingNanos(long paramLong)
  {
    return this.timeoutAt - paramLong;
  }

  private static void scheduleTimeout(a parama, long paramLong, boolean paramBoolean)
  {
    while (true)
    {
      a locala;
      try
      {
        if (head == null)
        {
          head = new a();
          new a().start();
        }
        long l1 = System.nanoTime();
        if ((paramLong != 0L) && (paramBoolean))
        {
          parama.timeoutAt = (l1 + Math.min(paramLong, parama.deadlineNanoTime() - l1));
          long l2 = parama.remainingNanos(l1);
          locala = head;
          if ((locala.next != null) && (l2 >= locala.next.remainingNanos(l1)))
            break label183;
          parama.next = locala.next;
          locala.next = parama;
          if (locala == head)
            a.class.notify();
          return;
        }
        if (paramLong != 0L)
        {
          long l3 = l1 + paramLong;
          parama.timeoutAt = l3;
          continue;
        }
      }
      finally
      {
      }
      if (paramBoolean)
      {
        parama.timeoutAt = parama.deadlineNanoTime();
      }
      else
      {
        throw new AssertionError();
        label183: locala = locala.next;
      }
    }
  }

  public final void enter()
  {
    if (this.inQueue)
      throw new IllegalStateException("Unbalanced enter/exit");
    long l = timeoutNanos();
    boolean bool = hasDeadline();
    if ((l == 0L) && (!bool))
      return;
    this.inQueue = true;
    scheduleTimeout(this, l, bool);
  }

  final IOException exit(IOException paramIOException)
    throws IOException
  {
    if (!exit())
      return paramIOException;
    return newTimeoutException(paramIOException);
  }

  final void exit(boolean paramBoolean)
    throws IOException
  {
    if ((exit()) && (paramBoolean))
      throw newTimeoutException(null);
  }

  public final boolean exit()
  {
    if (!this.inQueue)
      return false;
    this.inQueue = false;
    return cancelScheduledTimeout(this);
  }

  protected IOException newTimeoutException(@Nullable IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null)
      localInterruptedIOException.initCause(paramIOException);
    return localInterruptedIOException;
  }

  public final s sink(final s params)
  {
    return new s()
    {
      public void close()
        throws IOException
      {
        a.this.enter();
        try
        {
          params.close();
          a.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw a.this.exit(localIOException);
        }
        finally
        {
          a.this.exit(false);
        }
      }

      public void flush()
        throws IOException
      {
        a.this.enter();
        try
        {
          params.flush();
          a.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw a.this.exit(localIOException);
        }
        finally
        {
          a.this.exit(false);
        }
      }

      public u timeout()
      {
        return a.this;
      }

      public String toString()
      {
        return "AsyncTimeout.sink(" + params + ")";
      }

      public void write(c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        v.a(paramAnonymousc.b, 0L, paramAnonymousLong);
        long l1 = paramAnonymousLong;
        while (l1 > 0L)
        {
          p localp = paramAnonymousc.a;
          long l2 = 0L;
          label28: long l3;
          if (l2 < 65536L)
          {
            l3 = l2 + (localp.c - localp.b);
            if (l3 >= l1)
              l2 = l1;
          }
          else
          {
            a.this.enter();
          }
          try
          {
            params.write(paramAnonymousc, l2);
            l1 -= l2;
            a.this.exit(true);
            continue;
            localp = localp.f;
            l2 = l3;
            break label28;
          }
          catch (IOException localIOException)
          {
            throw a.this.exit(localIOException);
          }
          finally
          {
            a.this.exit(false);
          }
        }
      }
    };
  }

  public final t source(final t paramt)
  {
    return new t()
    {
      public void close()
        throws IOException
      {
        try
        {
          paramt.close();
          a.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw a.this.exit(localIOException);
        }
        finally
        {
          a.this.exit(false);
        }
      }

      public long read(c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        a.this.enter();
        try
        {
          long l = paramt.read(paramAnonymousc, paramAnonymousLong);
          a.this.exit(true);
          return l;
        }
        catch (IOException localIOException)
        {
          throw a.this.exit(localIOException);
        }
        finally
        {
          a.this.exit(false);
        }
      }

      public u timeout()
      {
        return a.this;
      }

      public String toString()
      {
        return "AsyncTimeout.source(" + paramt + ")";
      }
    };
  }

  protected void timedOut()
  {
  }

  private static final class a extends Thread
  {
    a()
    {
      super();
      setDaemon(true);
    }

    public void run()
    {
      while (true)
      {
        a locala;
        try
        {
          try
          {
            locala = a.awaitTimeout();
            if (locala != null)
              break label27;
            continue;
          }
          finally
          {
          }
        }
        catch (InterruptedException localInterruptedException)
        {
        }
        continue;
        label27: if (locala == a.head)
        {
          a.head = null;
          return;
        }
        locala.timedOut();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.a
 * JD-Core Version:    0.6.2
 */