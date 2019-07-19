package f;

import java.io.IOException;

public final class m
{
  final long a;
  final c b = new c();
  boolean c;
  boolean d;
  private final s e = new a();
  private final t f = new b();

  public m(long paramLong)
  {
    if (paramLong < 1L)
      throw new IllegalArgumentException("maxBufferSize < 1: " + paramLong);
    this.a = paramLong;
  }

  public t a()
  {
    return this.f;
  }

  public s b()
  {
    return this.e;
  }

  final class a
    implements s
  {
    final u a = new u();

    a()
    {
    }

    public void close()
      throws IOException
    {
      synchronized (m.this.b)
      {
        if (m.this.c)
          return;
        if ((m.this.d) && (m.this.b.a() > 0L))
          throw new IOException("source is closed");
      }
      m.this.c = true;
      m.this.b.notifyAll();
    }

    public void flush()
      throws IOException
    {
      synchronized (m.this.b)
      {
        if (m.this.c)
          throw new IllegalStateException("closed");
      }
      if ((m.this.d) && (m.this.b.a() > 0L))
        throw new IOException("source is closed");
    }

    public u timeout()
    {
      return this.a;
    }

    public void write(c paramc, long paramLong)
      throws IOException
    {
      synchronized (m.this.b)
      {
        if (!m.this.c)
          break label81;
        throw new IllegalStateException("closed");
      }
      long l1 = m.this.a - m.this.b.a();
      if (l1 == 0L)
        this.a.waitUntilNotified(m.this.b);
      while (true)
      {
        label81: if (paramLong <= 0L)
          break label146;
        if (!m.this.d)
          break;
        throw new IOException("source is closed");
        long l2 = Math.min(l1, paramLong);
        m.this.b.write(paramc, l2);
        paramLong -= l2;
        m.this.b.notifyAll();
      }
      label146:
    }
  }

  final class b
    implements t
  {
    final u a = new u();

    b()
    {
    }

    public void close()
      throws IOException
    {
      synchronized (m.this.b)
      {
        m.this.d = true;
        m.this.b.notifyAll();
        return;
      }
    }

    public long read(c paramc, long paramLong)
      throws IOException
    {
      synchronized (m.this.b)
      {
        if (m.this.d)
          throw new IllegalStateException("closed");
      }
      do
      {
        this.a.waitUntilNotified(m.this.b);
        if (m.this.b.a() != 0L)
          break;
      }
      while (!m.this.c);
      return -1L;
      long l = m.this.b.read(paramc, paramLong);
      m.this.b.notifyAll();
      return l;
    }

    public u timeout()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.m
 * JD-Core Version:    0.6.2
 */