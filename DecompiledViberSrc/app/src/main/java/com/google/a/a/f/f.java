package com.google.a.a.f;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class f
{
  public static int a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    z.a(paramInputStream);
    z.a(paramArrayOfByte);
    if (paramInt2 < 0)
      throw new IndexOutOfBoundsException("len is negative");
    int i = 0;
    while (true)
    {
      int j;
      if (i < paramInt2)
      {
        j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        if (j != -1);
      }
      else
      {
        return i;
      }
      i += j;
    }
  }

  public static long a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    z.a(paramInputStream);
    z.a(paramOutputStream);
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L; ; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return l;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }

  public static InputStream a(InputStream paramInputStream, long paramLong)
  {
    return new a(paramInputStream, paramLong);
  }

  private static final class a extends FilterInputStream
  {
    private long a;
    private long b = -1L;

    a(InputStream paramInputStream, long paramLong)
    {
      super();
      z.a(paramInputStream);
      if (paramLong >= 0L);
      for (boolean bool = true; ; bool = false)
      {
        z.a(bool, "limit must be non-negative");
        this.a = paramLong;
        return;
      }
    }

    public int available()
      throws IOException
    {
      return (int)Math.min(this.in.available(), this.a);
    }

    public void mark(int paramInt)
    {
      try
      {
        this.in.mark(paramInt);
        this.b = this.a;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public int read()
      throws IOException
    {
      if (this.a == 0L)
        return -1;
      int i = this.in.read();
      if (i != -1)
        this.a -= 1L;
      return i;
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.a == 0L)
        return -1;
      int i = (int)Math.min(paramInt2, this.a);
      int j = this.in.read(paramArrayOfByte, paramInt1, i);
      if (j != -1)
        this.a -= j;
      return j;
    }

    public void reset()
      throws IOException
    {
      try
      {
        if (!this.in.markSupported())
          throw new IOException("Mark not supported");
      }
      finally
      {
      }
      if (this.b == -1L)
        throw new IOException("Mark not set");
      this.in.reset();
      this.a = this.b;
    }

    public long skip(long paramLong)
      throws IOException
    {
      long l1 = Math.min(paramLong, this.a);
      long l2 = this.in.skip(l1);
      this.a -= l2;
      return l2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.f
 * JD-Core Version:    0.6.2
 */