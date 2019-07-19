package com.viber.voip.backup.b;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class c extends FilterInputStream
{
  private final e a;

  public c(InputStream paramInputStream, e parame)
  {
    super(paramInputStream);
    this.a = parame;
  }

  public int read()
    throws IOException
  {
    this.a.a();
    return this.in.read();
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.a();
    return this.in.read(paramArrayOfByte, paramInt1, paramInt2);
  }

  public void reset()
    throws IOException
  {
    try
    {
      this.a.a();
      this.in.reset();
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
    this.a.a();
    return this.in.skip(paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.b.c
 * JD-Core Version:    0.6.2
 */