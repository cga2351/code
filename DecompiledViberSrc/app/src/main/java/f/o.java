package f;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class o
  implements e
{
  public final c a = new c();
  public final t b;
  boolean c;

  o(t paramt)
  {
    if (paramt == null)
      throw new NullPointerException("source == null");
    this.b = paramt;
  }

  public long a(byte paramByte)
    throws IOException
  {
    return a(paramByte, 0L, 9223372036854775807L);
  }

  public long a(byte paramByte, long paramLong1, long paramLong2)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    if ((paramLong1 < 0L) || (paramLong2 < paramLong1))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Long.valueOf(paramLong1);
      arrayOfObject[1] = Long.valueOf(paramLong2);
      throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", arrayOfObject));
    }
    Object localObject1;
    Object localObject2;
    for (long l1 = Math.max(localObject1, localObject2); ; l1 = paramLong1)
    {
      if (l1 < paramLong2)
      {
        long l2 = this.a.a(paramByte, l1, paramLong2);
        if (l2 != -1L)
          return l2;
        long l3 = this.a.b;
        if ((l3 < paramLong2) && (this.b.read(this.a, 8192L) != -1L))
          break;
        return -1L;
      }
      return -1L;
    }
  }

  public long a(f paramf, long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    do
    {
      Object localObject;
      paramLong = Math.max(paramLong, 1L + (localObject - paramf.h()));
      long l1 = this.a.a(paramf, paramLong);
      if (l1 != -1L)
        return l1;
      long l2 = this.a.b;
    }
    while (this.b.read(this.a, 8192L) != -1L);
    return -1L;
  }

  public long a(s params)
    throws IOException
  {
    if (params == null)
      throw new IllegalArgumentException("sink == null");
    long l1 = 0L;
    while (this.b.read(this.a, 8192L) != -1L)
    {
      long l2 = this.a.h();
      if (l2 > 0L)
      {
        l1 += l2;
        params.write(this.a, l2);
      }
    }
    if (this.a.a() > 0L)
    {
      l1 += this.a.a();
      params.write(this.a, this.a.a());
    }
    return l1;
  }

  public String a(Charset paramCharset)
    throws IOException
  {
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null");
    this.a.a(this.b);
    return this.a.a(paramCharset);
  }

  public void a(long paramLong)
    throws IOException
  {
    if (!b(paramLong))
      throw new EOFException();
  }

  public void a(c paramc, long paramLong)
    throws IOException
  {
    try
    {
      a(paramLong);
      this.a.a(paramc, paramLong);
      return;
    }
    catch (EOFException localEOFException)
    {
      paramc.a(this.a);
      throw localEOFException;
    }
  }

  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      a(paramArrayOfByte.length);
      this.a.a(paramArrayOfByte);
      return;
    }
    catch (EOFException localEOFException)
    {
      int i = 0;
      while (this.a.b > 0L)
      {
        int j = this.a.a(paramArrayOfByte, i, (int)this.a.b);
        if (j == -1)
          throw new AssertionError();
        i += j;
      }
      throw localEOFException;
    }
  }

  public boolean a(long paramLong, f paramf)
    throws IOException
  {
    return a(paramLong, paramf, 0, paramf.h());
  }

  public boolean a(long paramLong, f paramf, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 < 0) || (paramf.h() - paramInt1 < paramInt2))
      return false;
    for (int i = 0; ; i++)
    {
      if (i >= paramInt2)
        break label102;
      long l = paramLong + i;
      if ((!b(1L + l)) || (this.a.c(l) != paramf.a(paramInt1 + i)))
        break;
    }
    label102: return true;
  }

  public long b(f paramf)
    throws IOException
  {
    return a(paramf, 0L);
  }

  public c b()
  {
    return this.a;
  }

  public boolean b(long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (this.c)
      throw new IllegalStateException("closed");
    while (this.a.b < paramLong)
      if (this.b.read(this.a, 8192L) == -1L)
        return false;
    return true;
  }

  public void close()
    throws IOException
  {
    if (this.c)
      return;
    this.c = true;
    this.b.close();
    this.a.v();
  }

  public f d(long paramLong)
    throws IOException
  {
    a(paramLong);
    return this.a.d(paramLong);
  }

  public String f(long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("limit < 0: " + paramLong);
    if (paramLong == 9223372036854775807L);
    for (long l1 = 9223372036854775807L; ; l1 = paramLong + 1L)
    {
      long l2 = a((byte)10, 0L, l1);
      if (l2 == -1L)
        break;
      return this.a.g(l2);
    }
    if ((l1 < 9223372036854775807L) && (b(l1)) && (this.a.c(l1 - 1L) == 13) && (b(1L + l1)) && (this.a.c(l1) == 10))
      return this.a.g(l1);
    c localc = new c();
    this.a.a(localc, 0L, Math.min(32L, this.a.a()));
    throw new EOFException("\\n not found: limit=" + Math.min(this.a.a(), paramLong) + " content=" + localc.q().f() + '…');
  }

  public boolean f()
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    return (this.a.f()) && (this.b.read(this.a, 8192L) == -1L);
  }

  public InputStream g()
  {
    return new InputStream()
    {
      public int available()
        throws IOException
      {
        if (o.this.c)
          throw new IOException("closed");
        return (int)Math.min(o.this.a.b, 2147483647L);
      }

      public void close()
        throws IOException
      {
        o.this.close();
      }

      public int read()
        throws IOException
      {
        if (o.this.c)
          throw new IOException("closed");
        if ((o.this.a.b == 0L) && (o.this.b.read(o.this.a, 8192L) == -1L))
          return -1;
        return 0xFF & o.this.a.i();
      }

      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        if (o.this.c)
          throw new IOException("closed");
        v.a(paramAnonymousArrayOfByte.length, paramAnonymousInt1, paramAnonymousInt2);
        if ((o.this.a.b == 0L) && (o.this.b.read(o.this.a, 8192L) == -1L))
          return -1;
        return o.this.a.a(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }

      public String toString()
      {
        return o.this + ".inputStream()";
      }
    };
  }

  public byte[] h(long paramLong)
    throws IOException
  {
    a(paramLong);
    return this.a.h(paramLong);
  }

  public byte i()
    throws IOException
  {
    a(1L);
    return this.a.i();
  }

  public void i(long paramLong)
    throws IOException
  {
    if (this.c)
      throw new IllegalStateException("closed");
    do
    {
      long l = Math.min(paramLong, this.a.a());
      this.a.i(l);
      paramLong -= l;
      if (paramLong <= 0L)
        break;
    }
    while ((this.a.b != 0L) || (this.b.read(this.a, 8192L) != -1L));
    throw new EOFException();
  }

  public boolean isOpen()
  {
    return !this.c;
  }

  public short j()
    throws IOException
  {
    a(2L);
    return this.a.j();
  }

  public int k()
    throws IOException
  {
    a(4L);
    return this.a.k();
  }

  public long l()
    throws IOException
  {
    a(8L);
    return this.a.l();
  }

  public short m()
    throws IOException
  {
    a(2L);
    return this.a.m();
  }

  public int n()
    throws IOException
  {
    a(4L);
    return this.a.n();
  }

  public long o()
    throws IOException
  {
    a(1L);
    for (int i = 0; b(i + 1); i++)
    {
      byte b1 = this.a.c(i);
      if (((b1 < 48) || (b1 > 57)) && ((i != 0) || (b1 != 45)))
      {
        if (i != 0)
          break;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(b1);
        throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", arrayOfObject));
      }
    }
    return this.a.o();
  }

  public long p()
    throws IOException
  {
    a(1L);
    for (int i = 0; b(i + 1); i++)
    {
      byte b1 = this.a.c(i);
      if (((b1 < 48) || (b1 > 57)) && ((b1 < 97) || (b1 > 102)) && ((b1 < 65) || (b1 > 70)))
      {
        if (i != 0)
          break;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(b1);
        throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", arrayOfObject));
      }
    }
    return this.a.p();
  }

  public String r()
    throws IOException
  {
    this.a.a(this.b);
    return this.a.r();
  }

  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if ((this.a.b == 0L) && (this.b.read(this.a, 8192L) == -1L))
      return -1;
    return this.a.read(paramByteBuffer);
  }

  public long read(c paramc, long paramLong)
    throws IOException
  {
    if (paramc == null)
      throw new IllegalArgumentException("sink == null");
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (this.c)
      throw new IllegalStateException("closed");
    if ((this.a.b == 0L) && (this.b.read(this.a, 8192L) == -1L))
      return -1L;
    long l = Math.min(paramLong, this.a.b);
    return this.a.read(paramc, l);
  }

  public String s()
    throws IOException
  {
    return f(9223372036854775807L);
  }

  public u timeout()
  {
    return this.b.timeout();
  }

  public String toString()
  {
    return "buffer(" + this.b + ")";
  }

  public byte[] u()
    throws IOException
  {
    this.a.a(this.b);
    return this.a.u();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.o
 * JD-Core Version:    0.6.2
 */