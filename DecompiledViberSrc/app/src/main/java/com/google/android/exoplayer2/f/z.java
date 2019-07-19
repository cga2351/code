package com.google.android.exoplayer2.f;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class z
{
  public static final b a = a(false, -9223372036854775807L);
  public static final b b = a(true, -9223372036854775807L);
  public static final b c = new b(2, -9223372036854775807L, null);
  public static final b d = new b(3, -9223372036854775807L, null);
  private final ExecutorService e;
  private c<? extends d> f;
  private IOException g;

  public z(String paramString)
  {
    this.e = ag.a(paramString);
  }

  public static b a(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
      return new b(i, paramLong, null);
  }

  public <T extends d> long a(T paramT, a<T> parama, int paramInt)
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.g = null;
      long l = SystemClock.elapsedRealtime();
      new c(localLooper, paramT, parama, paramInt, l).a(0L);
      return l;
    }
  }

  public void a(int paramInt)
    throws IOException
  {
    if (this.g != null)
      throw this.g;
    if (this.f != null)
    {
      c localc = this.f;
      if (paramInt == -2147483648)
        paramInt = this.f.a;
      localc.a(paramInt);
    }
  }

  public void a(e parame)
  {
    if (this.f != null)
      this.f.a(true);
    if (parame != null)
      this.e.execute(new f(parame));
    this.e.shutdown();
  }

  public boolean a()
  {
    return this.f != null;
  }

  public void b()
  {
    this.f.a(false);
  }

  public void c()
  {
    a(null);
  }

  public void d()
    throws IOException
  {
    a(-2147483648);
  }

  public static abstract interface a<T extends z.d>
  {
    public abstract z.b a(T paramT, long paramLong1, long paramLong2, IOException paramIOException, int paramInt);

    public abstract void a(T paramT, long paramLong1, long paramLong2);

    public abstract void a(T paramT, long paramLong1, long paramLong2, boolean paramBoolean);
  }

  public static final class b
  {
    private final int a;
    private final long b;

    private b(int paramInt, long paramLong)
    {
      this.a = paramInt;
      this.b = paramLong;
    }

    public boolean a()
    {
      return (this.a == 0) || (this.a == 1);
    }
  }

  @SuppressLint({"HandlerLeak"})
  private final class c<T extends z.d> extends Handler
    implements Runnable
  {
    public final int a;
    private final T c;
    private final long d;
    private z.a<T> e;
    private IOException f;
    private int g;
    private volatile Thread h;
    private volatile boolean i;
    private volatile boolean j;

    public c(T parama, z.a<T> paramInt, int paramLong, long arg5)
    {
      super();
      this.c = paramInt;
      this.e = paramLong;
      int k;
      this.a = k;
      Object localObject;
      this.d = localObject;
    }

    private void a()
    {
      this.f = null;
      z.b(z.this).execute(z.a(z.this));
    }

    private void b()
    {
      z.a(z.this, null);
    }

    private long c()
    {
      return Math.min(1000 * (-1 + this.g), 5000);
    }

    public void a(int paramInt)
      throws IOException
    {
      if ((this.f != null) && (this.g > paramInt))
        throw this.f;
    }

    public void a(long paramLong)
    {
      if (z.a(z.this) == null);
      for (boolean bool = true; ; bool = false)
      {
        a.b(bool);
        z.a(z.this, this);
        if (paramLong <= 0L)
          break;
        sendEmptyMessageDelayed(0, paramLong);
        return;
      }
      a();
    }

    public void a(boolean paramBoolean)
    {
      this.j = paramBoolean;
      this.f = null;
      if (hasMessages(0))
      {
        removeMessages(0);
        if (!paramBoolean)
          sendEmptyMessage(1);
      }
      while (true)
      {
        if (paramBoolean)
        {
          b();
          long l = SystemClock.elapsedRealtime();
          this.e.a(this.c, l, l - this.d, true);
          this.e = null;
        }
        return;
        this.i = true;
        this.c.a();
        if (this.h != null)
          this.h.interrupt();
      }
    }

    public void handleMessage(Message paramMessage)
    {
      if (this.j);
      z.b localb;
      do
      {
        return;
        if (paramMessage.what == 0)
        {
          a();
          return;
        }
        if (paramMessage.what == 4)
          throw ((Error)paramMessage.obj);
        b();
        long l1 = SystemClock.elapsedRealtime();
        long l2 = l1 - this.d;
        if (this.i)
        {
          this.e.a(this.c, l1, l2, false);
          return;
        }
        switch (paramMessage.what)
        {
        default:
          return;
        case 1:
          this.e.a(this.c, l1, l2, false);
          return;
        case 2:
          try
          {
            this.e.a(this.c, l1, l2);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            l.b("LoadTask", "Unexpected exception handling load completed", localRuntimeException);
            z.a(z.this, new z.g(localRuntimeException));
            return;
          }
        case 3:
        }
        this.f = ((IOException)paramMessage.obj);
        this.g = (1 + this.g);
        localb = this.e.a(this.c, l1, l2, this.f, this.g);
        if (z.b.a(localb) == 3)
        {
          z.a(z.this, this.f);
          return;
        }
      }
      while (z.b.a(localb) == 2);
      if (z.b.a(localb) == 1)
        this.g = 1;
      if (z.b.b(localb) != -9223372036854775807L);
      for (long l3 = z.b.b(localb); ; l3 = c())
      {
        a(l3);
        return;
      }
    }

    public void run()
    {
      try
      {
        this.h = Thread.currentThread();
        if (!this.i)
          ae.a("load:" + this.c.getClass().getSimpleName());
        try
        {
          this.c.b();
          ae.a();
          if (!this.j)
          {
            sendEmptyMessage(2);
            return;
          }
        }
        finally
        {
          ae.a();
        }
      }
      catch (IOException localIOException)
      {
        if (!this.j)
        {
          obtainMessage(3, localIOException).sendToTarget();
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        a.b(this.i);
        if (!this.j)
        {
          sendEmptyMessage(2);
          return;
        }
      }
      catch (Exception localException)
      {
        l.b("LoadTask", "Unexpected exception loading stream", localException);
        if (!this.j)
        {
          obtainMessage(3, new z.g(localException)).sendToTarget();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        l.b("LoadTask", "OutOfMemory error loading stream", localOutOfMemoryError);
        if (!this.j)
        {
          obtainMessage(3, new z.g(localOutOfMemoryError)).sendToTarget();
          return;
        }
      }
      catch (Error localError)
      {
        l.b("LoadTask", "Unexpected error loading stream", localError);
        if (!this.j)
          obtainMessage(4, localError).sendToTarget();
        throw localError;
      }
    }
  }

  public static abstract interface d
  {
    public abstract void a();

    public abstract void b()
      throws IOException, InterruptedException;
  }

  public static abstract interface e
  {
    public abstract void g();
  }

  private static final class f
    implements Runnable
  {
    private final z.e a;

    public f(z.e parame)
    {
      this.a = parame;
    }

    public void run()
    {
      this.a.g();
    }
  }

  public static final class g extends IOException
  {
    public g(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.z
 * JD-Core Version:    0.6.2
 */