package com.viber.voip.util.h;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class b extends FilterOutputStream
{
  private final c a;

  public b(OutputStream paramOutputStream, d paramd)
  {
    super(paramOutputStream);
    this.a = new c(paramd);
  }

  public void write(int paramInt)
    throws IOException
  {
    this.out.write(paramInt);
    this.a.b(1L);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.a.c(paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.h.b
 * JD-Core Version:    0.6.2
 */