package com.google.android.exoplayer2.g;

import java.nio.charset.Charset;

public final class r
{
  public byte[] a;
  private int b;
  private int c;

  public r()
  {
    this.a = ag.f;
  }

  public r(int paramInt)
  {
    this.a = new byte[paramInt];
    this.c = paramInt;
  }

  public r(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.c = paramArrayOfByte.length;
  }

  public r(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt;
  }

  public String A()
  {
    if (b() == 0)
      return null;
    for (int i = this.b; (i < this.c) && (this.a[i] != 0); i++);
    String str = ag.a(this.a, this.b, i - this.b);
    this.b = i;
    if (this.b < this.c)
      this.b = (1 + this.b);
    return str;
  }

  public String B()
  {
    if (b() == 0)
      return null;
    for (int i = this.b; (i < this.c) && (!ag.a(this.a[i])); i++);
    if ((i - this.b >= 3) && (this.a[this.b] == -17) && (this.a[(1 + this.b)] == -69) && (this.a[(2 + this.b)] == -65))
      this.b = (3 + this.b);
    String str = ag.a(this.a, this.b, i - this.b);
    this.b = i;
    if (this.b == this.c)
      return str;
    if (this.a[this.b] == 13)
    {
      this.b = (1 + this.b);
      if (this.b == this.c)
        return str;
    }
    if (this.a[this.b] == 10)
      this.b = (1 + this.b);
    return str;
  }

  public long C()
  {
    int i = 1;
    long l = this.a[this.b];
    int k;
    for (int j = 7; ; j--)
    {
      k = 0;
      if (j >= 0)
      {
        if ((l & i << j) != 0L)
          continue;
        if (j >= 6)
          break label93;
        l &= -1 + (i << j);
        k = 7 - j;
      }
      while (k == 0)
      {
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + l);
        label93: k = 0;
        if (j == 7)
          k = i;
      }
    }
    int m;
    do
    {
      l = l << 6 | m & 0x3F;
      i++;
      if (i >= k)
        break;
      m = this.a[(i + this.b)];
    }
    while ((m & 0xC0) == 128);
    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + l);
    this.b = (k + this.b);
    return l;
  }

  public String a(int paramInt, Charset paramCharset)
  {
    String str = new String(this.a, this.b, paramInt, paramCharset);
    this.b = (paramInt + this.b);
    return str;
  }

  public void a()
  {
    this.b = 0;
    this.c = 0;
  }

  public void a(int paramInt)
  {
    if (e() < paramInt);
    for (byte[] arrayOfByte = new byte[paramInt]; ; arrayOfByte = this.a)
    {
      a(arrayOfByte, paramInt);
      return;
    }
  }

  public void a(q paramq, int paramInt)
  {
    a(paramq.a, 0, paramInt);
    paramq.a(0);
  }

  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, paramArrayOfByte.length);
  }

  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt;
    this.b = 0;
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, paramInt2);
    this.b = (paramInt2 + this.b);
  }

  public int b()
  {
    return this.c - this.b;
  }

  public void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.a.length));
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool);
      this.c = paramInt;
      return;
    }
  }

  public int c()
  {
    return this.c;
  }

  public void c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.c));
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool);
      this.b = paramInt;
      return;
    }
  }

  public int d()
  {
    return this.b;
  }

  public void d(int paramInt)
  {
    c(paramInt + this.b);
  }

  public int e()
  {
    return this.a.length;
  }

  public String e(int paramInt)
  {
    return a(paramInt, Charset.forName("UTF-8"));
  }

  public int f()
  {
    return 0xFF & this.a[this.b];
  }

  public String f(int paramInt)
  {
    if (paramInt == 0)
      return "";
    int i = -1 + (paramInt + this.b);
    if ((i < this.c) && (this.a[i] == 0));
    for (int j = paramInt - 1; ; j = paramInt)
    {
      String str = ag.a(this.a, this.b, j);
      this.b = (paramInt + this.b);
      return str;
    }
  }

  public char g()
  {
    return (char)((0xFF & this.a[this.b]) << 8 | 0xFF & this.a[(1 + this.b)]);
  }

  public int h()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    return 0xFF & arrayOfByte[i];
  }

  public int i()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 8;
    byte[] arrayOfByte2 = this.a;
    int k = this.b;
    this.b = (k + 1);
    return j | 0xFF & arrayOfByte2[k];
  }

  public int j()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    int j = 0xFF & arrayOfByte1[i];
    byte[] arrayOfByte2 = this.a;
    int k = this.b;
    this.b = (k + 1);
    return j | (0xFF & arrayOfByte2[k]) << 8;
  }

  public short k()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 8;
    byte[] arrayOfByte2 = this.a;
    int k = this.b;
    this.b = (k + 1);
    return (short)(j | 0xFF & arrayOfByte2[k]);
  }

  public int l()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 16;
    byte[] arrayOfByte2 = this.a;
    int k = this.b;
    this.b = (k + 1);
    int m = j | (0xFF & arrayOfByte2[k]) << 8;
    byte[] arrayOfByte3 = this.a;
    int n = this.b;
    this.b = (n + 1);
    return m | 0xFF & arrayOfByte3[n];
  }

  public int m()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 24 >> 8;
    byte[] arrayOfByte2 = this.a;
    int k = this.b;
    this.b = (k + 1);
    int m = j | (0xFF & arrayOfByte2[k]) << 8;
    byte[] arrayOfByte3 = this.a;
    int n = this.b;
    this.b = (n + 1);
    return m | 0xFF & arrayOfByte3[n];
  }

  public long n()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    long l1 = (0xFF & arrayOfByte1[i]) << 24;
    byte[] arrayOfByte2 = this.a;
    int j = this.b;
    this.b = (j + 1);
    long l2 = l1 | (0xFF & arrayOfByte2[j]) << 16;
    byte[] arrayOfByte3 = this.a;
    int k = this.b;
    this.b = (k + 1);
    long l3 = l2 | (0xFF & arrayOfByte3[k]) << 8;
    byte[] arrayOfByte4 = this.a;
    int m = this.b;
    this.b = (m + 1);
    return l3 | 0xFF & arrayOfByte4[m];
  }

  public long o()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    long l1 = 0xFF & arrayOfByte1[i];
    byte[] arrayOfByte2 = this.a;
    int j = this.b;
    this.b = (j + 1);
    long l2 = l1 | (0xFF & arrayOfByte2[j]) << 8;
    byte[] arrayOfByte3 = this.a;
    int k = this.b;
    this.b = (k + 1);
    long l3 = l2 | (0xFF & arrayOfByte3[k]) << 16;
    byte[] arrayOfByte4 = this.a;
    int m = this.b;
    this.b = (m + 1);
    return l3 | (0xFF & arrayOfByte4[m]) << 24;
  }

  public int p()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 24;
    byte[] arrayOfByte2 = this.a;
    int k = this.b;
    this.b = (k + 1);
    int m = j | (0xFF & arrayOfByte2[k]) << 16;
    byte[] arrayOfByte3 = this.a;
    int n = this.b;
    this.b = (n + 1);
    int i1 = m | (0xFF & arrayOfByte3[n]) << 8;
    byte[] arrayOfByte4 = this.a;
    int i2 = this.b;
    this.b = (i2 + 1);
    return i1 | 0xFF & arrayOfByte4[i2];
  }

  public int q()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    int j = 0xFF & arrayOfByte1[i];
    byte[] arrayOfByte2 = this.a;
    int k = this.b;
    this.b = (k + 1);
    int m = j | (0xFF & arrayOfByte2[k]) << 8;
    byte[] arrayOfByte3 = this.a;
    int n = this.b;
    this.b = (n + 1);
    int i1 = m | (0xFF & arrayOfByte3[n]) << 16;
    byte[] arrayOfByte4 = this.a;
    int i2 = this.b;
    this.b = (i2 + 1);
    return i1 | (0xFF & arrayOfByte4[i2]) << 24;
  }

  public long r()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    long l1 = (0xFF & arrayOfByte1[i]) << 56;
    byte[] arrayOfByte2 = this.a;
    int j = this.b;
    this.b = (j + 1);
    long l2 = l1 | (0xFF & arrayOfByte2[j]) << 48;
    byte[] arrayOfByte3 = this.a;
    int k = this.b;
    this.b = (k + 1);
    long l3 = l2 | (0xFF & arrayOfByte3[k]) << 40;
    byte[] arrayOfByte4 = this.a;
    int m = this.b;
    this.b = (m + 1);
    long l4 = l3 | (0xFF & arrayOfByte4[m]) << 32;
    byte[] arrayOfByte5 = this.a;
    int n = this.b;
    this.b = (n + 1);
    long l5 = l4 | (0xFF & arrayOfByte5[n]) << 24;
    byte[] arrayOfByte6 = this.a;
    int i1 = this.b;
    this.b = (i1 + 1);
    long l6 = l5 | (0xFF & arrayOfByte6[i1]) << 16;
    byte[] arrayOfByte7 = this.a;
    int i2 = this.b;
    this.b = (i2 + 1);
    long l7 = l6 | (0xFF & arrayOfByte7[i2]) << 8;
    byte[] arrayOfByte8 = this.a;
    int i3 = this.b;
    this.b = (i3 + 1);
    return l7 | 0xFF & arrayOfByte8[i3];
  }

  public long s()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    long l1 = 0xFF & arrayOfByte1[i];
    byte[] arrayOfByte2 = this.a;
    int j = this.b;
    this.b = (j + 1);
    long l2 = l1 | (0xFF & arrayOfByte2[j]) << 8;
    byte[] arrayOfByte3 = this.a;
    int k = this.b;
    this.b = (k + 1);
    long l3 = l2 | (0xFF & arrayOfByte3[k]) << 16;
    byte[] arrayOfByte4 = this.a;
    int m = this.b;
    this.b = (m + 1);
    long l4 = l3 | (0xFF & arrayOfByte4[m]) << 24;
    byte[] arrayOfByte5 = this.a;
    int n = this.b;
    this.b = (n + 1);
    long l5 = l4 | (0xFF & arrayOfByte5[n]) << 32;
    byte[] arrayOfByte6 = this.a;
    int i1 = this.b;
    this.b = (i1 + 1);
    long l6 = l5 | (0xFF & arrayOfByte6[i1]) << 40;
    byte[] arrayOfByte7 = this.a;
    int i2 = this.b;
    this.b = (i2 + 1);
    long l7 = l6 | (0xFF & arrayOfByte7[i2]) << 48;
    byte[] arrayOfByte8 = this.a;
    int i3 = this.b;
    this.b = (i3 + 1);
    return l7 | (0xFF & arrayOfByte8[i3]) << 56;
  }

  public int t()
  {
    byte[] arrayOfByte1 = this.a;
    int i = this.b;
    this.b = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 8;
    byte[] arrayOfByte2 = this.a;
    int k = this.b;
    this.b = (k + 1);
    int m = j | 0xFF & arrayOfByte2[k];
    this.b = (2 + this.b);
    return m;
  }

  public int u()
  {
    int i = h();
    int j = h();
    int k = h();
    return h() | (i << 21 | j << 14 | k << 7);
  }

  public int v()
  {
    int i = p();
    if (i < 0)
      throw new IllegalStateException("Top bit not zero: " + i);
    return i;
  }

  public int w()
  {
    int i = q();
    if (i < 0)
      throw new IllegalStateException("Top bit not zero: " + i);
    return i;
  }

  public long x()
  {
    long l = r();
    if (l < 0L)
      throw new IllegalStateException("Top bit not zero: " + l);
    return l;
  }

  public float y()
  {
    return Float.intBitsToFloat(p());
  }

  public double z()
  {
    return Double.longBitsToDouble(r());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.r
 * JD-Core Version:    0.6.2
 */