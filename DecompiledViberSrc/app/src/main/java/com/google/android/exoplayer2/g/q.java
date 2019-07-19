package com.google.android.exoplayer2.g;

public final class q
{
  public byte[] a;
  private int b;
  private int c;
  private int d;

  public q()
  {
    this.a = ag.f;
  }

  public q(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
  }

  public q(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.d = paramInt;
  }

  private void g()
  {
    if ((this.b >= 0) && ((this.b < this.d) || ((this.b == this.d) && (this.c == 0))));
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      return;
    }
  }

  public int a()
  {
    return 8 * (this.d - this.b) - this.c;
  }

  public void a(int paramInt)
  {
    this.b = (paramInt / 8);
    this.c = (paramInt - 8 * this.b);
    g();
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 32)
      paramInt1 &= -1 + (1 << paramInt2);
    int i = Math.min(8 - this.c, paramInt2);
    int j = 8 - this.c - i;
    int k = 65280 >> this.c | -1 + (1 << j);
    this.a[this.b] = ((byte)(k & this.a[this.b]));
    int m = paramInt1 >>> paramInt2 - i;
    this.a[this.b] = ((byte)(this.a[this.b] | m << j));
    int n = paramInt2 - i;
    int i1 = 1 + this.b;
    int i2 = n;
    while (i2 > 8)
    {
      byte[] arrayOfByte = this.a;
      int i5 = i1 + 1;
      arrayOfByte[i1] = ((byte)(paramInt1 >>> i2 - 8));
      i2 -= 8;
      i1 = i5;
    }
    int i3 = 8 - i2;
    this.a[i1] = ((byte)(this.a[i1] & -1 + (1 << i3)));
    int i4 = paramInt1 & -1 + (1 << i2);
    this.a[i1] = ((byte)(this.a[i1] | i4 << i3));
    b(paramInt2);
    g();
  }

  public void a(r paramr)
  {
    a(paramr.a, paramr.c());
    a(8 * paramr.d());
  }

  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, paramArrayOfByte.length);
  }

  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.b = 0;
    this.c = 0;
    this.d = paramInt;
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + (paramInt2 >> 3);
    while (paramInt1 < i)
    {
      byte[] arrayOfByte2 = this.a;
      int i1 = this.b;
      this.b = (i1 + 1);
      paramArrayOfByte[paramInt1] = ((byte)(arrayOfByte2[i1] << this.c));
      paramArrayOfByte[paramInt1] = ((byte)(paramArrayOfByte[paramInt1] | (0xFF & this.a[this.b]) >> 8 - this.c));
      paramInt1++;
    }
    int j = paramInt2 & 0x7;
    if (j == 0)
      return;
    paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] & 255 >> j));
    if (j + this.c > 8)
    {
      int m = paramArrayOfByte[i];
      byte[] arrayOfByte1 = this.a;
      int n = this.b;
      this.b = (n + 1);
      paramArrayOfByte[i] = ((byte)(m | (0xFF & arrayOfByte1[n]) << this.c));
      this.c = (-8 + this.c);
    }
    this.c = (j + this.c);
    int k = (0xFF & this.a[this.b]) >> 8 - this.c;
    paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] | (byte)(k << 8 - j)));
    if (this.c == 8)
    {
      this.c = 0;
      this.b = (1 + this.b);
    }
    g();
  }

  public int b()
  {
    return 8 * this.b + this.c;
  }

  public void b(int paramInt)
  {
    int i = paramInt / 8;
    this.b = (i + this.b);
    this.c += paramInt - i * 8;
    if (this.c > 7)
    {
      this.b = (1 + this.b);
      this.c = (-8 + this.c);
    }
    g();
  }

  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.c == 0);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, paramInt2);
      this.b = (paramInt2 + this.b);
      g();
      return;
    }
  }

  public int c()
  {
    if (this.c == 0);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      return this.b;
    }
  }

  public int c(int paramInt)
  {
    if (paramInt == 0)
      return 0;
    this.c = (paramInt + this.c);
    int i = 0;
    while (this.c > 8)
    {
      this.c = (-8 + this.c);
      byte[] arrayOfByte = this.a;
      int k = this.b;
      this.b = (k + 1);
      i |= (0xFF & arrayOfByte[k]) << this.c;
    }
    int j = (i | (0xFF & this.a[this.b]) >> 8 - this.c) & -1 >>> 32 - paramInt;
    if (this.c == 8)
    {
      this.c = 0;
      this.b = (1 + this.b);
    }
    g();
    return j;
  }

  public void d()
  {
    int i = 1 + this.c;
    this.c = i;
    if (i == 8)
    {
      this.c = 0;
      this.b = (1 + this.b);
    }
    g();
  }

  public void d(int paramInt)
  {
    if (this.c == 0);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.b = (paramInt + this.b);
      g();
      return;
    }
  }

  public boolean e()
  {
    if ((this.a[this.b] & 128 >> this.c) != 0);
    for (boolean bool = true; ; bool = false)
    {
      d();
      return bool;
    }
  }

  public void f()
  {
    if (this.c == 0)
      return;
    this.c = 0;
    this.b = (1 + this.b);
    g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.q
 * JD-Core Version:    0.6.2
 */