package com.c.a.a.b;

import java.io.IOException;
import java.io.InputStream;

public final class g extends InputStream
{
  protected final d a;
  final InputStream b;
  byte[] c;
  int d;
  final int e;

  public g(d paramd, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramd;
    this.b = paramInputStream;
    this.c = paramArrayOfByte;
    this.d = paramInt1;
    this.e = paramInt2;
  }

  private void a()
  {
    byte[] arrayOfByte = this.c;
    if (arrayOfByte != null)
    {
      this.c = null;
      if (this.a != null)
        this.a.a(arrayOfByte);
    }
  }

  public int available()
    throws IOException
  {
    if (this.c != null)
      return this.e - this.d;
    return this.b.available();
  }

  public void close()
    throws IOException
  {
    a();
    this.b.close();
  }

  public void mark(int paramInt)
  {
    if (this.c == null)
      this.b.mark(paramInt);
  }

  public boolean markSupported()
  {
    return (this.c == null) && (this.b.markSupported());
  }

  public int read()
    throws IOException
  {
    if (this.c != null)
    {
      byte[] arrayOfByte = this.c;
      int i = this.d;
      this.d = (i + 1);
      int j = 0xFF & arrayOfByte[i];
      if (this.d >= this.e)
        a();
      return j;
    }
    return this.b.read();
  }

  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.c != null)
    {
      int i = this.e - this.d;
      if (paramInt2 > i)
        paramInt2 = i;
      System.arraycopy(this.c, this.d, paramArrayOfByte, paramInt1, paramInt2);
      this.d = (paramInt2 + this.d);
      if (this.d >= this.e)
        a();
      return paramInt2;
    }
    return this.b.read(paramArrayOfByte, paramInt1, paramInt2);
  }

  public void reset()
    throws IOException
  {
    if (this.c == null)
      this.b.reset();
  }

  public long skip(long paramLong)
    throws IOException
  {
    long l;
    if (this.c != null)
    {
      int i = this.e - this.d;
      if (i > paramLong)
      {
        this.d += (int)paramLong;
        return paramLong;
      }
      a();
      l = 0L + i;
      paramLong -= i;
    }
    while (true)
    {
      if (paramLong > 0L)
        l += this.b.skip(paramLong);
      return l;
      l = 0L;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.b.g
 * JD-Core Version:    0.6.2
 */