package com.google.e.d.a;

import com.google.e.c.b;
import com.google.e.g;

final class a
{
  private final b a;
  private final b b;
  private final e c;

  a(b paramb)
    throws g
  {
    int i = paramb.f();
    if ((i < 8) || (i > 144) || ((i & 0x1) != 0))
      throw g.a();
    this.c = b(paramb);
    this.a = a(paramb);
    this.b = new b(this.a.e(), this.a.f());
  }

  private static e b(b paramb)
    throws g
  {
    return e.a(paramb.f(), paramb.e());
  }

  int a(int paramInt1, int paramInt2)
  {
    if (a(paramInt1 - 1, 0, paramInt1, paramInt2));
    for (int i = 1; ; i = 0)
    {
      int j = i << 1;
      if (a(paramInt1 - 1, 1, paramInt1, paramInt2))
        j |= 1;
      int k = j << 1;
      if (a(paramInt1 - 1, 2, paramInt1, paramInt2))
        k |= 1;
      int m = k << 1;
      if (a(0, paramInt2 - 2, paramInt1, paramInt2))
        m |= 1;
      int n = m << 1;
      if (a(0, paramInt2 - 1, paramInt1, paramInt2))
        n |= 1;
      int i1 = n << 1;
      if (a(1, paramInt2 - 1, paramInt1, paramInt2))
        i1 |= 1;
      int i2 = i1 << 1;
      if (a(2, paramInt2 - 1, paramInt1, paramInt2))
        i2 |= 1;
      int i3 = i2 << 1;
      if (a(3, paramInt2 - 1, paramInt1, paramInt2))
        i3 |= 1;
      return i3;
    }
  }

  b a(b paramb)
  {
    int i = this.c.b();
    int j = this.c.c();
    if (paramb.f() != i)
      throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
    int k = this.c.d();
    int m = this.c.e();
    int n = i / k;
    int i1 = j / m;
    int i2 = n * k;
    b localb = new b(i1 * m, i2);
    for (int i3 = 0; i3 < n; i3++)
    {
      int i4 = i3 * k;
      for (int i5 = 0; i5 < i1; i5++)
      {
        int i6 = i5 * m;
        for (int i7 = 0; i7 < k; i7++)
        {
          int i8 = i7 + (1 + i3 * (k + 2));
          int i9 = i4 + i7;
          for (int i10 = 0; i10 < m; i10++)
            if (paramb.a(i10 + (1 + i5 * (m + 2)), i8))
              localb.b(i6 + i10, i9);
        }
      }
    }
    return localb;
  }

  e a()
  {
    return this.c;
  }

  boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j;
    int i;
    if (paramInt1 < 0)
    {
      j = paramInt1 + paramInt3;
      i = paramInt2 + (4 - (0x7 & paramInt3 + 4));
    }
    while (true)
    {
      if (i < 0)
      {
        i += paramInt4;
        j += 4 - (0x7 & paramInt4 + 4);
      }
      this.b.b(i, j);
      return this.a.a(i, j);
      i = paramInt2;
      j = paramInt1;
    }
  }

  int b(int paramInt1, int paramInt2)
  {
    if (a(paramInt1 - 3, 0, paramInt1, paramInt2));
    for (int i = 1; ; i = 0)
    {
      int j = i << 1;
      if (a(paramInt1 - 2, 0, paramInt1, paramInt2))
        j |= 1;
      int k = j << 1;
      if (a(paramInt1 - 1, 0, paramInt1, paramInt2))
        k |= 1;
      int m = k << 1;
      if (a(0, paramInt2 - 4, paramInt1, paramInt2))
        m |= 1;
      int n = m << 1;
      if (a(0, paramInt2 - 3, paramInt1, paramInt2))
        n |= 1;
      int i1 = n << 1;
      if (a(0, paramInt2 - 2, paramInt1, paramInt2))
        i1 |= 1;
      int i2 = i1 << 1;
      if (a(0, paramInt2 - 1, paramInt1, paramInt2))
        i2 |= 1;
      int i3 = i2 << 1;
      if (a(1, paramInt2 - 1, paramInt1, paramInt2))
        i3 |= 1;
      return i3;
    }
  }

  int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = a(paramInt1 - 2, paramInt2 - 2, paramInt3, paramInt4);
    int i = 0;
    if (bool)
      i = 1;
    int j = i << 1;
    if (a(paramInt1 - 2, paramInt2 - 1, paramInt3, paramInt4))
      j |= 1;
    int k = j << 1;
    if (a(paramInt1 - 1, paramInt2 - 2, paramInt3, paramInt4))
      k |= 1;
    int m = k << 1;
    if (a(paramInt1 - 1, paramInt2 - 1, paramInt3, paramInt4))
      m |= 1;
    int n = m << 1;
    if (a(paramInt1 - 1, paramInt2, paramInt3, paramInt4))
      n |= 1;
    int i1 = n << 1;
    if (a(paramInt1, paramInt2 - 2, paramInt3, paramInt4))
      i1 |= 1;
    int i2 = i1 << 1;
    if (a(paramInt1, paramInt2 - 1, paramInt3, paramInt4))
      i2 |= 1;
    int i3 = i2 << 1;
    if (a(paramInt1, paramInt2, paramInt3, paramInt4))
      i3 |= 1;
    return i3;
  }

  byte[] b()
    throws g
  {
    int i = 0;
    byte[] arrayOfByte = new byte[this.c.f()];
    int j = this.a.f();
    int k = this.a.e();
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 4;
    int i4 = 0;
    int i16;
    int i18;
    int i19;
    if ((i3 == j) && (i2 == 0) && (i1 == 0))
    {
      int i29 = i4 + 1;
      arrayOfByte[i4] = ((byte)a(j, k));
      int i30 = i3 - 2;
      int i31 = i2 + 2;
      i16 = i29;
      i18 = i30;
      i19 = i31;
      i1 = 1;
    }
    label108: int i10;
    label358: int i5;
    int i9;
    int i7;
    while (true)
      if ((i18 >= j) && (i19 >= k))
        if (i16 != this.c.f())
        {
          throw g.a();
          if ((i3 == j - 2) && (i2 == 0) && ((k & 0x3) != 0) && (n == 0))
          {
            int i26 = i4 + 1;
            arrayOfByte[i4] = ((byte)b(j, k));
            int i27 = i3 - 2;
            int i28 = i2 + 2;
            i16 = i26;
            i18 = i27;
            i19 = i28;
            n = 1;
            continue;
          }
          if ((i3 == j + 4) && (i2 == 2) && ((k & 0x7) == 0) && (m == 0))
          {
            int i23 = i4 + 1;
            arrayOfByte[i4] = ((byte)c(j, k));
            int i24 = i3 - 2;
            int i25 = i2 + 2;
            i16 = i23;
            i18 = i24;
            i19 = i25;
            m = 1;
            continue;
          }
          if ((i3 != j - 2) || (i2 != 0) || ((k & 0x7) != 4) || (i != 0))
            break label583;
          int i20 = i4 + 1;
          arrayOfByte[i4] = ((byte)d(j, k));
          int i21 = i3 - 2;
          int i22 = i2 + 2;
          i16 = i20;
          i18 = i21;
          i19 = i22;
          i = 1;
          continue;
          i5 = i10;
          i7 = i9;
        }
    while (true)
    {
      if ((i8 < j) && (i5 >= 0) && (!this.b.a(i5, i8)))
      {
        i9 = i7 + 1;
        arrayOfByte[i7] = ((byte)b(i8, i5, j, k));
      }
      while (true)
      {
        i8 -= 2;
        i10 = i5 + 2;
        if ((i8 >= 0) && (i10 < k))
          break label358;
        int i11 = i8 + 1;
        int i12 = i10 + 3;
        int i13 = i11;
        int i14 = i12;
        int i15 = i9;
        label458: if ((i13 >= 0) && (i14 < k) && (!this.b.a(i14, i13)))
        {
          i16 = i15 + 1;
          arrayOfByte[i15] = ((byte)b(i13, i14, j, k));
        }
        while (true)
        {
          i13 += 2;
          int i17 = i14 - 2;
          if ((i13 >= j) || (i17 < 0))
          {
            i18 = i13 + 3;
            i19 = i17 + 1;
            break label108;
            return arrayOfByte;
            i4 = i16;
            i2 = i19;
            i3 = i18;
            break;
          }
          i14 = i17;
          i15 = i16;
          break label458;
          i16 = i15;
        }
        i9 = i7;
      }
      label583: i5 = i2;
      int i6 = i3;
      i7 = i4;
      int i8 = i6;
    }
  }

  int c(int paramInt1, int paramInt2)
  {
    if (a(paramInt1 - 1, 0, paramInt1, paramInt2));
    for (int i = 1; ; i = 0)
    {
      int j = i << 1;
      if (a(paramInt1 - 1, paramInt2 - 1, paramInt1, paramInt2))
        j |= 1;
      int k = j << 1;
      if (a(0, paramInt2 - 3, paramInt1, paramInt2))
        k |= 1;
      int m = k << 1;
      if (a(0, paramInt2 - 2, paramInt1, paramInt2))
        m |= 1;
      int n = m << 1;
      if (a(0, paramInt2 - 1, paramInt1, paramInt2))
        n |= 1;
      int i1 = n << 1;
      if (a(1, paramInt2 - 3, paramInt1, paramInt2))
        i1 |= 1;
      int i2 = i1 << 1;
      if (a(1, paramInt2 - 2, paramInt1, paramInt2))
        i2 |= 1;
      int i3 = i2 << 1;
      if (a(1, paramInt2 - 1, paramInt1, paramInt2))
        i3 |= 1;
      return i3;
    }
  }

  int d(int paramInt1, int paramInt2)
  {
    if (a(paramInt1 - 3, 0, paramInt1, paramInt2));
    for (int i = 1; ; i = 0)
    {
      int j = i << 1;
      if (a(paramInt1 - 2, 0, paramInt1, paramInt2))
        j |= 1;
      int k = j << 1;
      if (a(paramInt1 - 1, 0, paramInt1, paramInt2))
        k |= 1;
      int m = k << 1;
      if (a(0, paramInt2 - 2, paramInt1, paramInt2))
        m |= 1;
      int n = m << 1;
      if (a(0, paramInt2 - 1, paramInt1, paramInt2))
        n |= 1;
      int i1 = n << 1;
      if (a(1, paramInt2 - 1, paramInt1, paramInt2))
        i1 |= 1;
      int i2 = i1 << 1;
      if (a(2, paramInt2 - 1, paramInt1, paramInt2))
        i2 |= 1;
      int i3 = i2 << 1;
      if (a(3, paramInt2 - 1, paramInt1, paramInt2))
        i3 |= 1;
      return i3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.d.a.a
 * JD-Core Version:    0.6.2
 */