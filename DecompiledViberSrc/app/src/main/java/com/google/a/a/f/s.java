package com.google.a.a.f;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class s extends FilterInputStream
{
  private final r a;

  public s(InputStream paramInputStream, Logger paramLogger, Level paramLevel, int paramInt)
  {
    super(paramInputStream);
    this.a = new r(paramLogger, paramLevel, paramInt);
  }

  public void close()
    throws IOException
  {
    this.a.close();
    super.close();
  }

  public int read()
    throws IOException
  {
    int i = super.read();
    this.a.write(i);
    return i;
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i > 0)
      this.a.write(paramArrayOfByte, paramInt1, i);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.s
 * JD-Core Version:    0.6.2
 */