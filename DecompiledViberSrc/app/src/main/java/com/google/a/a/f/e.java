package com.google.a.a.f;

import java.io.IOException;
import java.io.OutputStream;

final class e extends OutputStream
{
  long a;

  public void write(int paramInt)
    throws IOException
  {
    this.a = (1L + this.a);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a += paramInt2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.e
 * JD-Core Version:    0.6.2
 */