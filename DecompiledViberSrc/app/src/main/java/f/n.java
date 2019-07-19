package f;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

final class n
  implements d
{
  public final c a = new c();
  public final s b;
  boolean c;

  n(s params)
  {
    if (params == null)
      throw new NullPointerException("sink == null");
    this.b = params;
  }

  public long a(t paramt)
    throws IOException
  {
    if (paramt == null)
      throw new IllegalArgumentException("source == null");
    long l1 = 0L;
    while (true)
    {
      long l2 = paramt.read(this.a, 8192L);
      if (l2 == -1L)
        break;
      l1 += l2;
      y();
    }
    return l1;
  }

  public c b()
  {
    return this.a;
  }

  public d b(String paramString)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramString);
    return y();
  }

  public d c(f paramf)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.a(paramf);
    return y();
  }

  public d c(byte[] paramArrayOfByte)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.b(paramArrayOfByte);
    return y();
  }

  public d c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.b(paramArrayOfByte, paramInt1, paramInt2);
    return y();
  }

  public OutputStream c()
  {
    return new OutputStream()
    {
      public void close()
        throws IOException
      {
        n.this.close();
      }

      public void flush()
        throws IOException
      {
        if (!n.this.c)
          n.this.flush();
      }

      public String toString()
      {
        return n.this + ".outputStream()";
      }

      public void write(int paramAnonymousInt)
        throws IOException
      {
        if (n.this.c)
          throw new IOException("closed");
        n.this.a.b((byte)paramAnonymousInt);
        n.this.y();
      }

      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        if (n.this.c)
          throw new IOException("closed");
        n.this.a.b(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        n.this.y();
      }
    };
  }

  public void close()
    throws IOException
  {
    if (this.c);
    while (true)
    {
      return;
      try
      {
        boolean bool = this.a.b < 0L;
        Object localObject = null;
        if (bool)
          this.b.write(this.a, this.a.b);
        try
        {
          label44: this.b.close();
          this.c = true;
          if (localObject == null)
            continue;
          v.a((Throwable)localObject);
          return;
        }
        catch (Throwable localThrowable2)
        {
          while (true)
            if (localObject == null)
              localObject = localThrowable2;
        }
      }
      catch (Throwable localThrowable1)
      {
        break label44;
      }
    }
  }

  public d e()
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    long l = this.a.a();
    if (l > 0L)
      this.b.write(this.a, l);
    return this;
  }

  public void flush()
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    if (this.a.b > 0L)
      this.b.write(this.a, this.a.b);
    this.b.flush();
  }

  public d g(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.d(paramInt);
    return y();
  }

  public d h(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.c(paramInt);
    return y();
  }

  public d i(int paramInt)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.b(paramInt);
    return y();
  }

  public boolean isOpen()
  {
    return !this.c;
  }

  public d m(long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.l(paramLong);
    return y();
  }

  public d n(long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.k(paramLong);
    return y();
  }

  public u timeout()
  {
    return this.b.timeout();
  }

  public String toString()
  {
    return "buffer(" + this.b + ")";
  }

  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    int i = this.a.write(paramByteBuffer);
    y();
    return i;
  }

  public void write(c paramc, long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    this.a.write(paramc, paramLong);
    y();
  }

  public d y()
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    long l = this.a.h();
    if (l > 0L)
      this.b.write(this.a, l);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.n
 * JD-Core Version:    0.6.2
 */