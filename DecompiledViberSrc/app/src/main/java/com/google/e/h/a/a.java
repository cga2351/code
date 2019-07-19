package com.google.e.h.a;

import com.google.e.c.b;

final class a
{
  private final b a;
  private j b;
  private g c;
  private boolean d;

  a(b paramb)
    throws com.google.e.g
  {
    int i = paramb.f();
    if ((i < 21) || ((i & 0x3) != 1))
      throw com.google.e.g.a();
    this.a = paramb;
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d);
    for (boolean bool = this.a.a(paramInt2, paramInt1); bool; bool = this.a.a(paramInt1, paramInt2))
      return 0x1 | paramInt3 << 1;
    return paramInt3 << 1;
  }

  g a()
    throws com.google.e.g
  {
    int i = 0;
    if (this.c != null)
      return this.c;
    int j = 0;
    int k = 0;
    while (j < 6)
    {
      k = a(j, 8, k);
      j++;
    }
    int m = a(8, 7, a(8, 8, a(7, 8, k)));
    for (int n = 5; n >= 0; n--)
      m = a(8, n, m);
    int i1 = this.a.f();
    int i2 = i1 - 7;
    for (int i3 = i1 - 1; i3 >= i2; i3--)
      i = a(8, i3, i);
    for (int i4 = i1 - 8; i4 < i1; i4++)
      i = a(i4, 8, i);
    this.c = g.b(m, i);
    if (this.c != null)
      return this.c;
    throw com.google.e.g.a();
  }

  void a(boolean paramBoolean)
  {
    this.b = null;
    this.c = null;
    this.d = paramBoolean;
  }

  j b()
    throws com.google.e.g
  {
    if (this.b != null)
      return this.b;
    int i = this.a.f();
    int j = (i - 17) / 4;
    if (j <= 6)
      return j.b(j);
    int k = i - 11;
    int m = 5;
    int n = 0;
    while (m >= 0)
    {
      for (int i4 = i - 9; i4 >= k; i4--)
        n = a(i4, m, n);
      m--;
    }
    j localj1 = j.c(n);
    if ((localj1 != null) && (localj1.d() == i))
    {
      this.b = localj1;
      return localj1;
    }
    int i1 = 0;
    for (int i2 = 5; i2 >= 0; i2--)
      for (int i3 = i - 9; i3 >= k; i3--)
        i1 = a(i2, i3, i1);
    j localj2 = j.c(i1);
    if ((localj2 != null) && (localj2.d() == i))
    {
      this.b = localj2;
      return localj2;
    }
    throw com.google.e.g.a();
  }

  byte[] c()
    throws com.google.e.g
  {
    g localg = a();
    j localj = b();
    c localc = c.a(localg.b());
    int i = this.a.f();
    localc.a(this.a, i);
    b localb = localj.e();
    byte[] arrayOfByte = new byte[localj.c()];
    int j = i - 1;
    int k = 0;
    int m = 0;
    int n = 0;
    int i3;
    for (int i1 = 1; j > 0; i1 = i3)
    {
      if (j == 6)
        j--;
      for (int i2 = 0; i2 < i; i2++)
      {
        if (i1 != 0);
        for (int i4 = i - 1 - i2; ; i4 = i2)
          for (int i5 = 0; i5 < 2; i5++)
            if (!localb.a(j - i5, i4))
            {
              k++;
              m <<= 1;
              if (this.a.a(j - i5, i4))
                m |= 1;
              if (k == 8)
              {
                int i6 = n + 1;
                arrayOfByte[n] = ((byte)m);
                m = 0;
                n = i6;
                k = 0;
              }
            }
      }
      i3 = i1 ^ 0x1;
      j -= 2;
    }
    if (n != localj.c())
      throw com.google.e.g.a();
    return arrayOfByte;
  }

  void d()
  {
    if (this.c == null)
      return;
    c localc = c.a(this.c.b());
    int i = this.a.f();
    localc.a(this.a, i);
  }

  void e()
  {
    for (int i = 0; i < this.a.e(); i++)
      for (int j = i + 1; j < this.a.f(); j++)
        if (this.a.a(i, j) != this.a.a(j, i))
        {
          this.a.c(j, i);
          this.a.c(i, j);
        }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.a.a
 * JD-Core Version:    0.6.2
 */