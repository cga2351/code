package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.g.a;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class y
{
  private final int a;
  private final int b;
  private final float c;
  private final float d;
  private final float e;
  private final int f;
  private final int g;
  private final int h;
  private final short[] i;
  private short[] j;
  private int k;
  private short[] l;
  private int m;
  private short[] n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;

  public y(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = (paramInt1 / paramInt3);
    this.f = (paramInt1 / 400);
    this.g = (paramInt1 / 65);
    this.h = (2 * this.g);
    this.i = new short[this.h];
    this.j = new short[paramInt2 * this.h];
    this.l = new short[paramInt2 * this.h];
    this.n = new short[paramInt2 * this.h];
  }

  private int a(short[] paramArrayOfShort, int paramInt)
  {
    int i1;
    int i3;
    if (this.a > 4000)
    {
      i1 = this.a / 4000;
      if ((this.b != 1) || (i1 != 1))
        break label91;
      i3 = a(paramArrayOfShort, paramInt, this.f, this.g);
    }
    while (true)
    {
      int i4;
      label69: label91: int i2;
      int i6;
      int i7;
      if (a(this.u, this.v))
      {
        i4 = this.s;
        this.t = this.u;
        this.s = i3;
        return i4;
        i1 = 1;
        break;
        c(paramArrayOfShort, paramInt, i1);
        i2 = a(this.i, 0, this.f / i1, this.g / i1);
        if (i1 == 1)
          break label247;
        int i5 = i2 * i1;
        i6 = i5 - i1 * 4;
        i7 = i5 + i1 * 4;
        if (i6 >= this.f)
          break label240;
      }
      label240: for (int i8 = this.f; ; i8 = i6)
      {
        if (i7 > this.g);
        for (int i9 = this.g; ; i9 = i7)
        {
          if (this.b == 1)
          {
            i3 = a(paramArrayOfShort, paramInt, i8, i9);
            break;
          }
          c(paramArrayOfShort, paramInt, 1);
          i3 = a(this.i, 0, i8, i9);
          break;
          i4 = i3;
          break label69;
        }
      }
      label247: i3 = i2;
    }
  }

  private int a(short[] paramArrayOfShort, int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat >= 2.0F);
    for (int i1 = (int)(paramInt2 / (paramFloat - 1.0F)); ; i1 = paramInt2)
    {
      this.l = a(this.l, this.m, i1);
      a(i1, this.b, this.l, this.m, paramArrayOfShort, paramInt1, paramArrayOfShort, paramInt1 + paramInt2);
      this.m = (i1 + this.m);
      return i1;
      this.r = ((int)(paramInt2 * (2.0F - paramFloat) / (paramFloat - 1.0F)));
    }
  }

  private int a(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 255;
    int i2 = 1;
    int i3 = paramInt1 * this.b;
    int i4 = paramInt2;
    int i5 = 0;
    int i6 = 0;
    int i8;
    if (i4 <= paramInt3)
    {
      int i7 = 0;
      int i10;
      for (i8 = 0; i7 < i4; i8 = i10)
      {
        i10 = i8 + Math.abs(paramArrayOfShort[(i3 + i7)] - paramArrayOfShort[(i7 + (i3 + i4))]);
        i7++;
      }
      if (i8 * i6 < i2 * i4)
      {
        i2 = i8;
        i6 = i4;
      }
      if (i8 * i1 <= i5 * i4)
        break label154;
    }
    for (int i9 = i4; ; i9 = i1)
    {
      i4++;
      i1 = i9;
      i5 = i8;
      break;
      this.u = (i2 / i6);
      this.v = (i5 / i1);
      return i6;
      label154: i8 = i5;
    }
  }

  private void a(float paramFloat)
  {
    if (this.k < this.h)
      return;
    int i1 = this.k;
    int i2 = 0;
    while (true)
    {
      if (this.r > 0)
        i2 += b(i2);
      while (i2 + this.h > i1)
      {
        a(i2);
        return;
        int i3 = a(this.j, i2);
        if (paramFloat > 1.0D)
          i2 += i3 + a(this.j, i2, paramFloat, i3);
        else
          i2 += b(this.j, i2, paramFloat, i3);
      }
    }
  }

  private void a(float paramFloat, int paramInt)
  {
    if (this.m == paramInt)
      return;
    int i1 = (int)(this.a / paramFloat);
    int i2 = this.a;
    int i4;
    for (int i3 = i1; (i3 > 16384) || (i2 > 16384); i3 = i4)
    {
      i4 = i3 / 2;
      i2 /= 2;
    }
    c(paramInt);
    int i5 = 0;
    if (i5 < -1 + this.o)
    {
      while (i3 * (1 + this.p) > i2 * this.q)
      {
        this.l = a(this.l, this.m, 1);
        for (int i6 = 0; i6 < this.b; i6++)
          this.l[(i6 + this.m * this.b)] = b(this.n, i6 + i5 * this.b, i2, i3);
        this.q = (1 + this.q);
        this.m = (1 + this.m);
      }
      this.p = (1 + this.p);
      if (this.p == i2)
      {
        this.p = 0;
        if (this.q != i3)
          break label249;
      }
      label249: for (boolean bool = true; ; bool = false)
      {
        a.b(bool);
        this.q = 0;
        i5++;
        break;
      }
    }
    d(-1 + this.o);
  }

  private void a(int paramInt)
  {
    int i1 = this.k - paramInt;
    System.arraycopy(this.j, paramInt * this.b, this.j, 0, i1 * this.b);
    this.k = i1;
  }

  private static void a(int paramInt1, int paramInt2, short[] paramArrayOfShort1, int paramInt3, short[] paramArrayOfShort2, int paramInt4, short[] paramArrayOfShort3, int paramInt5)
  {
    for (int i1 = 0; i1 < paramInt2; i1++)
    {
      int i2 = i1 + paramInt3 * paramInt2;
      int i3 = i1 + paramInt5 * paramInt2;
      int i4 = i1 + paramInt4 * paramInt2;
      int i5 = i2;
      int i6 = i3;
      int i7 = i4;
      for (int i8 = 0; i8 < paramInt1; i8++)
      {
        paramArrayOfShort1[i5] = ((short)((paramArrayOfShort2[i7] * (paramInt1 - i8) + i8 * paramArrayOfShort3[i6]) / paramInt1));
        i5 += paramInt2;
        i7 += paramInt2;
        i6 += paramInt2;
      }
    }
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (this.s == 0));
    while ((paramInt2 > paramInt1 * 3) || (paramInt1 * 2 <= 3 * this.t))
      return false;
    return true;
  }

  private short[] a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int i1 = paramArrayOfShort.length / this.b;
    if (paramInt1 + paramInt2 <= i1)
      return paramArrayOfShort;
    return Arrays.copyOf(paramArrayOfShort, (paramInt2 + i1 * 3 / 2) * this.b);
  }

  private int b(int paramInt)
  {
    int i1 = Math.min(this.h, this.r);
    b(this.j, paramInt, i1);
    this.r -= i1;
    return i1;
  }

  private int b(short[] paramArrayOfShort, int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat < 0.5F);
    for (int i1 = (int)(paramFloat * paramInt2 / (1.0F - paramFloat)); ; i1 = paramInt2)
    {
      this.l = a(this.l, this.m, paramInt2 + i1);
      System.arraycopy(paramArrayOfShort, paramInt1 * this.b, this.l, this.m * this.b, paramInt2 * this.b);
      a(i1, this.b, this.l, paramInt2 + this.m, paramArrayOfShort, paramInt1 + paramInt2, paramArrayOfShort, paramInt1);
      this.m += paramInt2 + i1;
      return i1;
      this.r = ((int)(paramInt2 * (2.0F * paramFloat - 1.0F) / (1.0F - paramFloat)));
    }
  }

  private short b(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramArrayOfShort[paramInt1];
    int i2 = paramArrayOfShort[(paramInt1 + this.b)];
    int i3 = paramInt2 * this.q;
    int i4 = paramInt3 * this.p;
    int i5 = paramInt3 * (1 + this.p);
    int i6 = i5 - i3;
    int i7 = i5 - i4;
    return (short)((i1 * i6 + i2 * (i7 - i6)) / i7);
  }

  private void b(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    this.l = a(this.l, this.m, paramInt2);
    System.arraycopy(paramArrayOfShort, paramInt1 * this.b, this.l, this.m * this.b, paramInt2 * this.b);
    this.m = (paramInt2 + this.m);
  }

  private void c(int paramInt)
  {
    int i1 = this.m - paramInt;
    this.n = a(this.n, this.o, i1);
    System.arraycopy(this.l, paramInt * this.b, this.n, this.o * this.b, i1 * this.b);
    this.m = paramInt;
    this.o = (i1 + this.o);
  }

  private void c(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int i1 = this.h / paramInt2;
    int i2 = paramInt2 * this.b;
    int i3 = paramInt1 * this.b;
    for (int i4 = 0; i4 < i1; i4++)
    {
      int i5 = 0;
      int i6 = 0;
      while (i5 < i2)
      {
        i6 += paramArrayOfShort[(i5 + (i3 + i4 * i2))];
        i5++;
      }
      int i7 = i6 / i2;
      this.i[i4] = ((short)i7);
    }
  }

  private void d()
  {
    int i1 = this.m;
    float f1 = this.c / this.d;
    float f2 = this.e * this.d;
    if ((f1 > 1.00001D) || (f1 < 0.9999900000000001D))
      a(f1);
    while (true)
    {
      if (f2 != 1.0F)
        a(f2, i1);
      return;
      b(this.j, 0, this.k);
      this.k = 0;
    }
  }

  private void d(int paramInt)
  {
    if (paramInt == 0)
      return;
    System.arraycopy(this.n, paramInt * this.b, this.n, 0, (this.o - paramInt) * this.b);
    this.o -= paramInt;
  }

  public void a()
  {
    int i1 = this.k;
    float f1 = this.c / this.d;
    float f2 = this.e * this.d;
    int i2 = this.m + (int)(0.5F + (i1 / f1 + this.o) / f2);
    this.j = a(this.j, this.k, i1 + 2 * this.h);
    for (int i3 = 0; i3 < 2 * this.h * this.b; i3++)
      this.j[(i3 + i1 * this.b)] = 0;
    this.k += 2 * this.h;
    d();
    if (this.m > i2)
      this.m = i2;
    this.k = 0;
    this.r = 0;
    this.o = 0;
  }

  public void a(ShortBuffer paramShortBuffer)
  {
    int i1 = paramShortBuffer.remaining() / this.b;
    int i2 = 2 * (i1 * this.b);
    this.j = a(this.j, this.k, i1);
    paramShortBuffer.get(this.j, this.k * this.b, i2 / 2);
    this.k = (i1 + this.k);
    d();
  }

  public void b()
  {
    this.k = 0;
    this.m = 0;
    this.o = 0;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.t = 0;
    this.u = 0;
    this.v = 0;
  }

  public void b(ShortBuffer paramShortBuffer)
  {
    int i1 = Math.min(paramShortBuffer.remaining() / this.b, this.m);
    paramShortBuffer.put(this.l, 0, i1 * this.b);
    this.m -= i1;
    System.arraycopy(this.l, i1 * this.b, this.l, 0, this.m * this.b);
  }

  public int c()
  {
    return this.m;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.y
 * JD-Core Version:    0.6.2
 */