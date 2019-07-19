package com.google.android.exoplayer2.g;

public final class s
{
  private byte[] a;
  private int b;
  private int c;
  private int d;

  public s(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte, paramInt1, paramInt2);
  }

  private boolean d(int paramInt)
  {
    return (2 <= paramInt) && (paramInt < this.b) && (this.a[paramInt] == 3) && (this.a[(paramInt - 2)] == 0) && (this.a[(paramInt - 1)] == 0);
  }

  private int f()
  {
    for (int i = 0; !b(); i++);
    int j = -1 + (1 << i);
    int k = 0;
    if (i > 0)
      k = c(i);
    return j + k;
  }

  private void g()
  {
    if ((this.c >= 0) && ((this.c < this.b) || ((this.c == this.b) && (this.d == 0))));
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      return;
    }
  }

  public void a()
  {
    int i = 1 + this.d;
    this.d = i;
    int j;
    if (i == 8)
    {
      this.d = 0;
      j = this.c;
      if (!d(1 + this.c))
        break label55;
    }
    label55: for (int k = 2; ; k = 1)
    {
      this.c = (k + j);
      g();
      return;
    }
  }

  public void a(int paramInt)
  {
    int i = this.c;
    int j = paramInt / 8;
    this.c = (j + this.c);
    this.d += paramInt - j * 8;
    if (this.d > 7)
    {
      this.c = (1 + this.c);
      this.d = (-8 + this.d);
    }
    for (int k = i + 1; k <= this.c; k++)
      if (d(k))
      {
        this.c = (1 + this.c);
        k += 2;
      }
    g();
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = paramInt2;
    this.d = 0;
    g();
  }

  public boolean b()
  {
    if ((this.a[this.c] & 128 >> this.d) != 0);
    for (boolean bool = true; ; bool = false)
    {
      a();
      return bool;
    }
  }

  public boolean b(int paramInt)
  {
    int i = this.c;
    int j = paramInt / 8;
    int k = j + this.c;
    int m = paramInt + this.d - j * 8;
    if (m > 7)
    {
      k++;
      m -= 8;
    }
    int n = i + 1;
    int i1 = k;
    for (int i2 = n; (i2 <= i1) && (i1 < this.b); i2++)
      if (d(i2))
      {
        i1++;
        i2 += 2;
      }
    return (i1 < this.b) || ((i1 == this.b) && (m == 0));
  }

  public int c(int paramInt)
  {
    int i = 2;
    this.d = (paramInt + this.d);
    int j = 0;
    if (this.d > 8)
    {
      this.d = (-8 + this.d);
      j |= (0xFF & this.a[this.c]) << this.d;
      int n = this.c;
      if (d(1 + this.c));
      for (int i1 = i; ; i1 = 1)
      {
        this.c = (i1 + n);
        break;
      }
    }
    int k = (j | (0xFF & this.a[this.c]) >> 8 - this.d) & -1 >>> 32 - paramInt;
    int m;
    if (this.d == 8)
    {
      this.d = 0;
      m = this.c;
      if (!d(1 + this.c))
        break label175;
    }
    while (true)
    {
      this.c = (m + i);
      g();
      return k;
      label175: i = 1;
    }
  }

  public boolean c()
  {
    int i = this.c;
    int j = this.d;
    for (int k = 0; (this.c < this.b) && (!b()); k++);
    if (this.c == this.b);
    for (int m = 1; ; m = 0)
    {
      this.c = i;
      this.d = j;
      if ((m != 0) || (!b(1 + k * 2)))
        break;
      return true;
    }
    return false;
  }

  public int d()
  {
    return f();
  }

  public int e()
  {
    int i = f();
    if (i % 2 == 0);
    for (int j = -1; ; j = 1)
      return j * ((i + 1) / 2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.s
 * JD-Core Version:    0.6.2
 */