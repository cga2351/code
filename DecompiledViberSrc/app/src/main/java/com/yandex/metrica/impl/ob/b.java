package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class b
{
  private final byte[] a;
  private final int b;
  private int c;

  private b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = (paramInt1 + paramInt2);
  }

  public static b a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new b(paramArrayOfByte, paramInt1, paramInt2);
  }

  public static int b(int paramInt, e parame)
  {
    return i(paramInt) + b(parame);
  }

  public static int b(int paramInt, String paramString)
  {
    return i(paramInt) + b(paramString);
  }

  public static int b(int paramInt, byte[] paramArrayOfByte)
  {
    return i(paramInt) + (k(paramArrayOfByte.length) + paramArrayOfByte.length);
  }

  public static int b(e parame)
  {
    int i = parame.b();
    return i + k(i);
  }

  public static int b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      int i = k(arrayOfByte.length);
      int j = arrayOfByte.length;
      return j + i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException("UTF-8 not supported.");
  }

  public static int c(int paramInt, long paramLong)
  {
    return i(paramInt) + d(paramLong);
  }

  public static int d(int paramInt)
  {
    return 8 + i(paramInt);
  }

  public static int d(int paramInt1, int paramInt2)
  {
    return i(paramInt1) + g(paramInt2);
  }

  public static int d(int paramInt, long paramLong)
  {
    return i(paramInt) + d(paramLong);
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
    return 4 + i(paramInt);
  }

  public static int e(int paramInt1, int paramInt2)
  {
    return i(paramInt1) + k(paramInt2);
  }

  public static int f(int paramInt)
  {
    return 1 + i(paramInt);
  }

  public static int f(int paramInt1, int paramInt2)
  {
    return i(paramInt1) + k(m(paramInt2));
  }

  public static int g(int paramInt)
  {
    if (paramInt >= 0)
      return k(paramInt);
    return 10;
  }

  public static int i(int paramInt)
  {
    return k(g.a(paramInt, 0));
  }

  public static int k(int paramInt)
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

  public static int m(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }

  public int a()
  {
    return this.b - this.c;
  }

  public void a(byte paramByte)
    throws IOException
  {
    if (this.c == this.b)
      throw new a(this.c, this.b);
    byte[] arrayOfByte = this.a;
    int i = this.c;
    this.c = (i + 1);
    arrayOfByte[i] = paramByte;
  }

  public void a(double paramDouble)
    throws IOException
  {
    e(Double.doubleToLongBits(paramDouble));
  }

  public void a(float paramFloat)
    throws IOException
  {
    l(Float.floatToIntBits(paramFloat));
  }

  public void a(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      j(paramInt);
      return;
    }
    c(paramInt);
  }

  public void a(int paramInt, double paramDouble)
    throws IOException
  {
    g(paramInt, 1);
    a(paramDouble);
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
    a(paramInt2);
  }

  public void a(int paramInt, long paramLong)
    throws IOException
  {
    g(paramInt, 0);
    a(paramLong);
  }

  public void a(int paramInt, e parame)
    throws IOException
  {
    g(paramInt, 2);
    a(parame);
  }

  public void a(int paramInt, String paramString)
    throws IOException
  {
    g(paramInt, 2);
    a(paramString);
  }

  public void a(int paramInt, boolean paramBoolean)
    throws IOException
  {
    g(paramInt, 0);
    a(paramBoolean);
  }

  public void a(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    g(paramInt, 2);
    a(paramArrayOfByte);
  }

  public void a(long paramLong)
    throws IOException
  {
    c(paramLong);
  }

  public void a(e parame)
    throws IOException
  {
    j(parame.a());
    parame.a(this);
  }

  public void a(String paramString)
    throws IOException
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    j(arrayOfByte.length);
    b(arrayOfByte);
  }

  public void a(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      h(i);
      return;
    }
  }

  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    j(paramArrayOfByte.length);
    b(paramArrayOfByte);
  }

  public void b()
  {
    if (a() != 0)
      throw new IllegalStateException("Did not write as much data as expected.");
  }

  public void b(int paramInt)
    throws IOException
  {
    j(paramInt);
  }

  public void b(int paramInt1, int paramInt2)
    throws IOException
  {
    g(paramInt1, 0);
    b(paramInt2);
  }

  public void b(int paramInt, long paramLong)
    throws IOException
  {
    g(paramInt, 0);
    b(paramLong);
  }

  public void b(long paramLong)
    throws IOException
  {
    c(paramLong);
  }

  public void b(byte[] paramArrayOfByte)
    throws IOException
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.b - this.c >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, paramInt2);
      this.c = (paramInt2 + this.c);
      return;
    }
    throw new a(this.c, this.b);
  }

  public void c(int paramInt)
    throws IOException
  {
    j(m(paramInt));
  }

  public void c(int paramInt1, int paramInt2)
    throws IOException
  {
    g(paramInt1, 0);
    c(paramInt2);
  }

  public void c(long paramLong)
    throws IOException
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        h((int)paramLong);
        return;
      }
      h(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }

  public void e(long paramLong)
    throws IOException
  {
    h(0xFF & (int)paramLong);
    h(0xFF & (int)(paramLong >> 8));
    h(0xFF & (int)(paramLong >> 16));
    h(0xFF & (int)(paramLong >> 24));
    h(0xFF & (int)(paramLong >> 32));
    h(0xFF & (int)(paramLong >> 40));
    h(0xFF & (int)(paramLong >> 48));
    h(0xFF & (int)(paramLong >> 56));
  }

  public void g(int paramInt1, int paramInt2)
    throws IOException
  {
    j(g.a(paramInt1, paramInt2));
  }

  public void h(int paramInt)
    throws IOException
  {
    a((byte)paramInt);
  }

  public void j(int paramInt)
    throws IOException
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        h(paramInt);
        return;
      }
      h(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }

  public void l(int paramInt)
    throws IOException
  {
    h(paramInt & 0xFF);
    h(0xFF & paramInt >> 8);
    h(0xFF & paramInt >> 16);
    h(paramInt >>> 24);
  }

  public static class a extends IOException
  {
    private static final long serialVersionUID = -6947486886997889499L;

    a(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.b
 * JD-Core Version:    0.6.2
 */