package com.google.a.a.f;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class t extends FilterOutputStream
{
  private final r a;

  public t(OutputStream paramOutputStream, Logger paramLogger, Level paramLevel, int paramInt)
  {
    super(paramOutputStream);
    this.a = new r(paramLogger, paramLevel, paramInt);
  }

  public final r a()
  {
    return this.a;
  }

  public void close()
    throws IOException
  {
    this.a.close();
    super.close();
  }

  public void write(int paramInt)
    throws IOException
  {
    this.out.write(paramInt);
    this.a.write(paramInt);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.t
 * JD-Core Version:    0.6.2
 */