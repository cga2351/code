package com.crashlytics.android.c;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class g
  implements Flushable
{
  private final byte[] a;
  private final int b;
  private int c;
  private final OutputStream d;

  private g(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.d = paramOutputStream;
    this.a = paramArrayOfByte;
    this.c = 0;
    this.b = paramArrayOfByte.length;
  }

  public static g a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, 4096);
  }

  public static g a(OutputStream paramOutputStream, int paramInt)
  {
    return new g(paramOutputStream, new byte[paramInt]);
  }

  private void a()
    throws IOException
  {
    if (this.d == null)
      throw new a();
    this.d.write(this.a, 0, this.c);
    this.c = 0;
  }

  public static int b(float paramFloat)
  {
    return 4;
  }

  public static int b(int paramInt, float paramFloat)
  {
    return j(paramInt) + b(paramFloat);
  }

  public static int b(int paramInt, long paramLong)
  {
    return j(paramInt) + b(paramLong);
  }

  public static int b(int paramInt, d paramd)
  {
    return j(paramInt) + b(paramd);
  }

  public static int b(int paramInt, boolean paramBoolean)
  {
    return j(paramInt) + b(paramBoolean);
  }

  public static int b(long paramLong)
  {
    return d(paramLong);
  }

  public static int b(d paramd)
  {
    return l(paramd.a()) + paramd.a();
  }

  public static int b(boolean paramBoolean)
  {
    return 1;
  }

  public static int d(int paramInt1, int paramInt2)
  {
    return j(paramInt1) + f(paramInt2);
  }

  public static int d(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L)
      return 1;
    if ((0xFFFFC000 & paramLong) == 0L)
      return 2;
    if ((0xFFE00000 & paramLong) == 0L)
      return 3;
    if ((0xF0000000 & paramLong) == 0L)
      return 4;
    if ((0x0 & paramLong) == 0L)
      return 5;
    if ((0x0 & paramLong) == 0L)
      return 6;
    if ((0x0 & paramLong) == 0L)
      return 7;
    if ((0x0 & paramLong) == 0L)
      return 8;
    if ((0x0 & paramLong) == 0L)
      return 9;
    return 10;
  }

  public static int e(int paramInt)
  {
    if (paramInt >= 0)
      return l(paramInt);
    return 10;
  }

  public static int e(int paramInt1, int paramInt2)
  {
    return j(paramInt1) + g(paramInt2);
  }

  public static int f(int paramInt)
  {
    return l(paramInt);
  }

  public static int f(int paramInt1, int paramInt2)
  {
    return j(paramInt1) + h(paramInt2);
  }

  public static int g(int paramInt)
  {
    return e(paramInt);
  }

  public static int h(int paramInt)
  {
    return l(n(paramInt));
  }

  public static int j(int paramInt)
  {
    return l(ba.a(paramInt, 0));
  }

  public static int l(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0)
      return 1;
    if ((paramInt & 0xFFFFC000) == 0)
      return 2;
    if ((0xFFE00000 & paramInt) == 0)
      return 3;
    if ((0xF0000000 & paramInt) == 0)
      return 4;
    return 5;
  }

  public static int n(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }

  public void a(byte paramByte)
    throws IOException
  {
    if (this.c == this.b)
      a();
    byte[] arrayOfByte = this.a;
    int i = this.c;
    this.c = (i + 1);
    arrayOfByte[i] = paramByte;
  }

  public void a(float paramFloat)
    throws IOException
  {
    m(Float.floatToRawIntBits(paramFloat));
  }

  public void a(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      k(paramInt);
      return;
    }
    c(paramInt);
  }

  public void a(int paramInt, float paramFloat)
    throws IOException
  {
    g(paramInt, 5);
    a(paramFloat);
  }

  public void a(int paramInt1, int paramInt2)
    throws IOException
  {
    g(paramInt1, 0);
    b(paramInt2);
  }

  public void a(int paramInt, long paramLong)
    throws IOException
  {
    g(paramInt, 0);
    a(paramLong);
  }

  public void a(int paramInt, d paramd)
    throws IOException
  {
    g(paramInt, 2);
    a(paramd);
  }

  public void a(int paramInt, boolean paramBoolean)
    throws IOException
  {
    g(paramInt, 0);
    a(paramBoolean);
  }

  public void a(long paramLong)
    throws IOException
  {
    c(paramLong);
  }

  public void a(d paramd)
    throws IOException
  {
    k(paramd.a());
    c(paramd);
  }

  public void a(d paramd, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.b - this.c >= paramInt2)
    {
      paramd.a(this.a, paramInt1, this.c, paramInt2);
      this.c = (paramInt2 + this.c);
      return;
    }
    int i = this.b - this.c;
    paramd.a(this.a, paramInt1, this.c, i);
    int j = paramInt1 + i;
    int k = paramInt2 - i;
    this.c = this.b;
    a();
    if (k <= this.b)
    {
      paramd.a(this.a, j, 0, k);
      this.c = k;
      return;
    }
    InputStream localInputStream = paramd.b();
    if (j != localInputStream.skip(j))
      throw new IllegalStateException("Skip failed.");
    int n;
    int m;
    do
    {
      this.d.write(this.a, 0, n);
      k -= n;
      if (k <= 0)
        break;
      m = Math.min(k, this.b);
      n = localInputStream.read(this.a, 0, m);
    }
    while (n == m);
    throw new IllegalStateException("Read failed.");
  }

  public void a(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      i(i);
      return;
    }
  }

  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.b - this.c >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, paramInt2);
      this.c = (paramInt2 + this.c);
      return;
    }
    int i = this.b - this.c;
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, i);
    int j = paramInt1 + i;
    int k = paramInt2 - i;
    this.c = this.b;
    a();
    if (k <= this.b)
    {
      System.arraycopy(paramArrayOfByte, j, this.a, 0, k);
      this.c = k;
      return;
    }
    this.d.write(paramArrayOfByte, j, k);
  }

  public void b(int paramInt)
    throws IOException
  {
    k(paramInt);
  }

  public void b(int paramInt1, int paramInt2)
    throws IOException
  {
    g(paramInt1, 0);
    c(paramInt2);
  }

  public void c(int paramInt)
    throws IOException
  {
    a(paramInt);
  }

  public void c(int paramInt1, int paramInt2)
    throws IOException
  {
    g(paramInt1, 0);
    d(paramInt2);
  }

  public void c(long paramLong)
    throws IOException
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        i((int)paramLong);
        return;
      }
      i(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }

  public void c(d paramd)
    throws IOException
  {
    a(paramd, 0, paramd.a());
  }

  public void d(int paramInt)
    throws IOException
  {
    k(n(paramInt));
  }

  public void flush()
    throws IOException
  {
    if (this.d != null)
      a();
  }

  public void g(int paramInt1, int paramInt2)
    throws IOException
  {
    k(ba.a(paramInt1, paramInt2));
  }

  public void i(int paramInt)
    throws IOException
  {
    a((byte)paramInt);
  }

  public void k(int paramInt)
    throws IOException
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        i(paramInt);
        return;
      }
      i(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }

  public void m(int paramInt)
    throws IOException
  {
    i(paramInt & 0xFF);
    i(0xFF & paramInt >> 8);
    i(0xFF & paramInt >> 16);
    i(0xFF & paramInt >> 24);
  }

  static class a extends IOException
  {
    a()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.g
 * JD-Core Version:    0.6.2
 */