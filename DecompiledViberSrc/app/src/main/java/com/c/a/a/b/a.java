package com.c.a.a.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

abstract class a extends Reader
{
  protected final d a;
  protected InputStream b;
  protected byte[] c;
  protected int d;
  protected int e;
  protected char[] f = null;

  protected a(d paramd, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramd;
    this.b = paramInputStream;
    this.c = paramArrayOfByte;
    this.d = paramInt1;
    this.e = paramInt2;
  }

  public final void a()
  {
    byte[] arrayOfByte = this.c;
    if (arrayOfByte != null)
    {
      this.c = null;
      this.a.a(arrayOfByte);
    }
  }

  protected void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    throw new ArrayIndexOutOfBoundsException("read(buf," + paramInt1 + "," + paramInt2 + "), cbuf[" + paramArrayOfChar.length + "]");
  }

  protected void b()
    throws IOException
  {
    throw new IOException("Strange I/O stream, returned 0 bytes on read");
  }

  public void close()
    throws IOException
  {
    InputStream localInputStream = this.b;
    if (localInputStream != null)
    {
      this.b = null;
      a();
      localInputStream.close();
    }
  }

  public int read()
    throws IOException
  {
    if (this.f == null)
      this.f = new char[1];
    if (read(this.f, 0, 1) < 1)
      return -1;
    return this.f[0];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.b.a
 * JD-Core Version:    0.6.2
 */