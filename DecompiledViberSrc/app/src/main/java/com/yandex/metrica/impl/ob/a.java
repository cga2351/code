package com.yandex.metrica.impl.ob;

import java.io.IOException;

public final class a
{
  private final byte[] a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g = 2147483647;
  private int h;
  private int i = 64;
  private int j = 67108864;

  private a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = (paramInt1 + paramInt2);
    this.e = paramInt1;
  }

  public static a a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new a(paramArrayOfByte, paramInt1, paramInt2);
  }

  private void u()
  {
    this.c += this.d;
    int k = this.c;
    if (k > this.g)
    {
      this.d = (k - this.g);
      this.c -= this.d;
      return;
    }
    this.d = 0;
  }

  public int a()
    throws IOException
  {
    if (r())
    {
      this.f = 0;
      return 0;
    }
    this.f = m();
    if (this.f == 0)
      throw d.d();
    return this.f;
  }

  public void a(int paramInt)
    throws d
  {
    if (this.f != paramInt)
      throw d.e();
  }

  public void a(e parame)
    throws IOException
  {
    int k = m();
    if (this.h >= this.i)
      throw d.g();
    int m = c(k);
    this.h = (1 + this.h);
    parame.a(this);
    a(0);
    this.h = (-1 + this.h);
    d(m);
  }

  public void b()
    throws IOException
  {
    int k;
    do
      k = a();
    while ((k != 0) && (b(k)));
  }

  public boolean b(int paramInt)
    throws IOException
  {
    switch (g.a(paramInt))
    {
    default:
      throw d.f();
    case 0:
      g();
      return true;
    case 1:
      p();
      return true;
    case 2:
      g(m());
      return true;
    case 3:
      b();
      a(g.a(g.b(paramInt), 4));
      return true;
    case 4:
      return false;
    case 5:
    }
    o();
    return true;
  }

  public double c()
    throws IOException
  {
    return Double.longBitsToDouble(p());
  }

  public int c(int paramInt)
    throws d
  {
    if (paramInt < 0)
      throw d.b();
    int k = paramInt + this.e;
    int m = this.g;
    if (k > m)
      throw d.a();
    this.g = k;
    u();
    return m;
  }

  public float d()
    throws IOException
  {
    return Float.intBitsToFloat(o());
  }

  public void d(int paramInt)
  {
    this.g = paramInt;
    u();
  }

  public long e()
    throws IOException
  {
    return n();
  }

  public void e(int paramInt)
  {
    if (paramInt > this.e - this.b)
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.e - this.b));
    if (paramInt < 0)
      throw new IllegalArgumentException("Bad position ".concat(String.valueOf(paramInt)));
    this.e = (paramInt + this.b);
  }

  public long f()
    throws IOException
  {
    return n();
  }

  public byte[] f(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw d.b();
    if (paramInt + this.e > this.g)
    {
      g(this.g - this.e);
      throw d.a();
    }
    if (paramInt <= this.c - this.e)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.a, this.e, arrayOfByte, 0, paramInt);
      this.e = (paramInt + this.e);
      return arrayOfByte;
    }
    throw d.a();
  }

  public int g()
    throws IOException
  {
    return m();
  }

  public void g(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw d.b();
    if (paramInt + this.e > this.g)
    {
      g(this.g - this.e);
      throw d.a();
    }
    if (paramInt <= this.c - this.e)
    {
      this.e = (paramInt + this.e);
      return;
    }
    throw d.a();
  }

  public boolean h()
    throws IOException
  {
    return m() != 0;
  }

  public String i()
    throws IOException
  {
    int k = m();
    if ((k <= this.c - this.e) && (k > 0))
    {
      String str = new String(this.a, this.e, k, "UTF-8");
      this.e = (k + this.e);
      return str;
    }
    return new String(f(k), "UTF-8");
  }

  public byte[] j()
    throws IOException
  {
    int k = m();
    if ((k <= this.c - this.e) && (k > 0))
    {
      byte[] arrayOfByte = new byte[k];
      System.arraycopy(this.a, this.e, arrayOfByte, 0, k);
      this.e = (k + this.e);
      return arrayOfByte;
    }
    return f(k);
  }

  public int k()
    throws IOException
  {
    return m();
  }

  public int l()
    throws IOException
  {
    int k = m();
    return k >>> 1 ^ -(k & 0x1);
  }

  public int m()
    throws IOException
  {
    int k = t();
    if (k >= 0);
    int i6;
    do
    {
      return k;
      int m = k & 0x7F;
      int n = t();
      if (n >= 0)
        return m | n << 7;
      int i1 = m | (n & 0x7F) << 7;
      int i2 = t();
      if (i2 >= 0)
        return i1 | i2 << 14;
      int i3 = i1 | (i2 & 0x7F) << 14;
      int i4 = t();
      if (i4 >= 0)
        return i3 | i4 << 21;
      int i5 = i3 | (i4 & 0x7F) << 21;
      i6 = t();
      k = i5 | i6 << 28;
    }
    while (i6 >= 0);
    for (int i7 = 0; ; i7++)
    {
      if (i7 >= 5)
        break label151;
      if (t() >= 0)
        break;
    }
    label151: throw d.c();
  }

  public long n()
    throws IOException
  {
    int k = 0;
    long l = 0L;
    while (k < 64)
    {
      int m = t();
      l |= (m & 0x7F) << k;
      if ((m & 0x80) == 0)
        return l;
      k += 7;
    }
    throw d.c();
  }

  public int o()
    throws IOException
  {
    int k = t();
    int m = t();
    int n = t();
    int i1 = t();
    return k & 0xFF | (m & 0xFF) << 8 | (n & 0xFF) << 16 | (i1 & 0xFF) << 24;
  }

  public long p()
    throws IOException
  {
    int k = t();
    int m = t();
    int n = t();
    int i1 = t();
    int i2 = t();
    int i3 = t();
    int i4 = t();
    int i5 = t();
    return 0xFF & k | (0xFF & m) << 8 | (0xFF & n) << 16 | (0xFF & i1) << 24 | (0xFF & i2) << 32 | (0xFF & i3) << 40 | (0xFF & i4) << 48 | (0xFF & i5) << 56;
  }

  public int q()
  {
    if (this.g == 2147483647)
      return -1;
    int k = this.e;
    return this.g - k;
  }

  public boolean r()
  {
    return this.e == this.c;
  }

  public int s()
  {
    return this.e - this.b;
  }

  public byte t()
    throws IOException
  {
    if (this.e == this.c)
      throw d.a();
    byte[] arrayOfByte = this.a;
    int k = this.e;
    this.e = (k + 1);
    return arrayOfByte[k];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.a
 * JD-Core Version:    0.6.2
 */