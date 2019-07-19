package com.viber.voip.util.h;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class a extends FilterInputStream
{
  private long a = -1L;
  private final c b;

  public a(InputStream paramInputStream, d paramd)
  {
    super(paramInputStream);
    this.b = new c(paramd);
  }

  public void mark(int paramInt)
  {
    try
    {
      this.in.mark(paramInt);
      this.a = this.b.a();
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
    int i = this.in.read();
    if (i != -1)
      this.b.b(1L);
    return i;
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    this.b.c(i);
    return i;
  }

  public void reset()
    throws IOException
  {
    try
    {
      this.in.reset();
      this.b.a(this.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long skip(long paramLong)
    throws IOException
  {
    long l = this.in.skip(paramLong);
    this.b.c(l);
    return l;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.h.a
 * JD-Core Version:    0.6.2
 */