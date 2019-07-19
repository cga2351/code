package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.g.a;
import java.io.IOException;
import java.io.InputStream;

public final class k extends InputStream
{
  private final h a;
  private final l b;
  private final byte[] c;
  private boolean d = false;
  private boolean e = false;
  private long f;

  public k(h paramh, l paraml)
  {
    this.a = paramh;
    this.b = paraml;
    this.c = new byte[1];
  }

  private void b()
    throws IOException
  {
    if (!this.d)
    {
      this.a.a(this.b);
      this.d = true;
    }
  }

  public void a()
    throws IOException
  {
    b();
  }

  public void close()
    throws IOException
  {
    if (!this.e)
    {
      this.a.c();
      this.e = true;
    }
  }

  public int read()
    throws IOException
  {
    if (read(this.c) == -1)
      return -1;
    return 0xFF & this.c[0];
  }

  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.e);
    int i;
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      b();
      i = this.a.a(paramArrayOfByte, paramInt1, paramInt2);
      if (i != -1)
        break;
      return -1;
    }
    this.f += i;
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.k
 * JD-Core Version:    0.6.2
 */