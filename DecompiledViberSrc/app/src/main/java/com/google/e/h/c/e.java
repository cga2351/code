package com.google.e.h.c;

import com.google.e.c.a;
import com.google.e.h.a.j;
import com.google.e.r;

final class e
{
  private static final int[][] a = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
  private static final int[][] b = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
  private static final int[][] c = { { -1, -1, -1, -1, -1, -1, -1 }, { 6, 18, -1, -1, -1, -1, -1 }, { 6, 22, -1, -1, -1, -1, -1 }, { 6, 26, -1, -1, -1, -1, -1 }, { 6, 30, -1, -1, -1, -1, -1 }, { 6, 34, -1, -1, -1, -1, -1 }, { 6, 22, 38, -1, -1, -1, -1 }, { 6, 24, 42, -1, -1, -1, -1 }, { 6, 26, 46, -1, -1, -1, -1 }, { 6, 28, 50, -1, -1, -1, -1 }, { 6, 30, 54, -1, -1, -1, -1 }, { 6, 32, 58, -1, -1, -1, -1 }, { 6, 34, 62, -1, -1, -1, -1 }, { 6, 26, 46, 66, -1, -1, -1 }, { 6, 26, 48, 70, -1, -1, -1 }, { 6, 26, 50, 74, -1, -1, -1 }, { 6, 30, 54, 78, -1, -1, -1 }, { 6, 30, 56, 82, -1, -1, -1 }, { 6, 30, 58, 86, -1, -1, -1 }, { 6, 34, 62, 90, -1, -1, -1 }, { 6, 28, 50, 72, 94, -1, -1 }, { 6, 26, 50, 74, 98, -1, -1 }, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, { 6, 32, 58, 84, 110, -1, -1 }, { 6, 30, 58, 86, 114, -1, -1 }, { 6, 34, 62, 90, 118, -1, -1 }, { 6, 26, 50, 74, 98, 122, -1 }, { 6, 30, 54, 78, 102, 126, -1 }, { 6, 26, 52, 78, 104, 130, -1 }, { 6, 30, 56, 82, 108, 134, -1 }, { 6, 34, 60, 86, 112, 138, -1 }, { 6, 30, 58, 86, 114, 142, -1 }, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, { 6, 24, 50, 76, 102, 128, 154 }, { 6, 28, 54, 80, 106, 132, 158 }, { 6, 32, 58, 84, 110, 136, 162 }, { 6, 26, 54, 82, 110, 138, 166 }, { 6, 30, 58, 86, 114, 142, 170 } };
  private static final int[][] d = { { 8, 0 }, { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 7 }, { 8, 8 }, { 7, 8 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 } };

  static int a(int paramInt)
  {
    for (int i = 0; paramInt != 0; i++)
      paramInt >>>= 1;
    return i;
  }

  static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      throw new IllegalArgumentException("0 polynomial");
    int i = a(paramInt2);
    int j = paramInt1 << i - 1;
    while (a(j) >= i)
      j ^= paramInt2 << a(j) - i;
    return j;
  }

  private static void a(int paramInt1, int paramInt2, b paramb)
    throws r
  {
    for (int i = 0; i < 8; i++)
    {
      if (!b(paramb.a(paramInt1 + i, paramInt2)))
        throw new r();
      paramb.a(paramInt1 + i, paramInt2, 0);
    }
  }

  static void a(a parama, int paramInt, b paramb)
    throws r
  {
    int i = -1 + paramb.b();
    int j = -1 + paramb.a();
    int k = -1;
    int m = 0;
    int n;
    int i1;
    int i2;
    if (i > 0)
    {
      if (i != 6)
        break label270;
      int i7 = i - 1;
      n = j;
      i1 = i7;
      i2 = m;
    }
    while (true)
      if ((n >= 0) && (n < paramb.a()))
      {
        int i4 = 0;
        while (i4 < 2)
        {
          int i5 = i1 - i4;
          if (!b(paramb.a(i5, n)))
          {
            i4++;
          }
          else
          {
            int i6;
            if (i2 < parama.a())
            {
              boolean bool2 = parama.a(i2);
              i6 = i2 + 1;
              bool1 = bool2;
              label125: if ((paramInt != -1) && (d.a(paramInt, i5, n)))
                if (bool1)
                  break label176;
            }
            label176: for (boolean bool1 = true; ; bool1 = false)
            {
              paramb.a(i5, n, bool1);
              i2 = i6;
              break;
              i6 = i2;
              bool1 = false;
              break label125;
            }
          }
        }
        n += k;
      }
      else
      {
        k = -k;
        int i3 = n + k;
        i = i1 - 2;
        m = i2;
        j = i3;
        break;
        if (m != parama.a())
          throw new r("Not all bits consumed: " + m + '/' + parama.a());
        return;
        label270: n = j;
        i1 = i;
        i2 = m;
      }
  }

  static void a(a parama, com.google.e.h.a.f paramf, j paramj, int paramInt, b paramb)
    throws r
  {
    a(paramb);
    a(paramj, paramb);
    a(paramf, paramInt, paramb);
    b(paramj, paramb);
    a(parama, paramInt, paramb);
  }

  static void a(com.google.e.h.a.f paramf, int paramInt, a parama)
    throws r
  {
    if (!f.b(paramInt))
      throw new r("Invalid mask pattern");
    int i = paramInt | paramf.a() << 3;
    parama.b(i, 5);
    parama.b(a(i, 1335), 10);
    a locala = new a();
    locala.b(21522, 15);
    parama.b(locala);
    if (parama.a() != 15)
      throw new r("should not happen but we got: " + parama.a());
  }

  static void a(com.google.e.h.a.f paramf, int paramInt, b paramb)
    throws r
  {
    a locala = new a();
    a(paramf, paramInt, locala);
    int i = 0;
    if (i < locala.a())
    {
      boolean bool = locala.a(-1 + locala.a() - i);
      paramb.a(d[i][0], d[i][1], bool);
      if (i < 8)
        paramb.a(-1 + (paramb.b() - i), 8, bool);
      while (true)
      {
        i++;
        break;
        paramb.a(8, -7 + paramb.a() + (i - 8), bool);
      }
    }
  }

  static void a(j paramj, a parama)
    throws r
  {
    parama.b(paramj.a(), 6);
    parama.b(a(paramj.a(), 7973), 12);
    if (parama.a() != 18)
      throw new r("should not happen but we got: " + parama.a());
  }

  static void a(j paramj, b paramb)
    throws r
  {
    d(paramb);
    c(paramb);
    c(paramj, paramb);
    b(paramb);
  }

  static void a(b paramb)
  {
    paramb.a((byte)-1);
  }

  private static void b(int paramInt1, int paramInt2, b paramb)
    throws r
  {
    for (int i = 0; i < 7; i++)
    {
      if (!b(paramb.a(paramInt1, paramInt2 + i)))
        throw new r();
      paramb.a(paramInt1, paramInt2 + i, 0);
    }
  }

  static void b(j paramj, b paramb)
    throws r
  {
    if (paramj.a() < 7);
    while (true)
    {
      return;
      a locala = new a();
      a(paramj, locala);
      int i = 17;
      int j = 0;
      while (j < 6)
      {
        int k = i;
        for (int m = 0; m < 3; m++)
        {
          boolean bool = locala.a(k);
          k--;
          paramb.a(j, m + (-11 + paramb.a()), bool);
          paramb.a(m + (-11 + paramb.a()), j, bool);
        }
        j++;
        i = k;
      }
    }
  }

  private static void b(b paramb)
  {
    for (int i = 8; i < -8 + paramb.b(); i++)
    {
      int j = (i + 1) % 2;
      if (b(paramb.a(i, 6)))
        paramb.a(i, 6, j);
      if (b(paramb.a(6, i)))
        paramb.a(6, i, j);
    }
  }

  private static boolean b(int paramInt)
  {
    return paramInt == -1;
  }

  private static void c(int paramInt1, int paramInt2, b paramb)
  {
    for (int i = 0; i < 5; i++)
      for (int j = 0; j < 5; j++)
        paramb.a(paramInt1 + j, paramInt2 + i, b[i][j]);
  }

  private static void c(j paramj, b paramb)
  {
    if (paramj.a() < 2);
    while (true)
    {
      return;
      int i = -1 + paramj.a();
      int[] arrayOfInt = c[i];
      int j = c[i].length;
      for (int k = 0; k < j; k++)
      {
        int m = 0;
        if (m < j)
        {
          int n = arrayOfInt[k];
          int i1 = arrayOfInt[m];
          if ((i1 == -1) || (n == -1));
          while (true)
          {
            m++;
            break;
            if (b(paramb.a(i1, n)))
              c(i1 - 2, n - 2, paramb);
          }
        }
      }
    }
  }

  private static void c(b paramb)
    throws r
  {
    if (paramb.a(8, -8 + paramb.a()) == 0)
      throw new r();
    paramb.a(8, -8 + paramb.a(), 1);
  }

  private static void d(int paramInt1, int paramInt2, b paramb)
  {
    for (int i = 0; i < 7; i++)
      for (int j = 0; j < 7; j++)
        paramb.a(paramInt1 + j, paramInt2 + i, a[i][j]);
  }

  private static void d(b paramb)
    throws r
  {
    int i = a[0].length;
    d(0, 0, paramb);
    d(paramb.b() - i, 0, paramb);
    d(0, paramb.b() - i, paramb);
    a(0, 7, paramb);
    a(paramb.b() - 8, 7, paramb);
    a(0, paramb.b() - 8, paramb);
    b(7, 0, paramb);
    b(-1 + (paramb.a() - 7), 0, paramb);
    b(7, paramb.a() - 7, paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.c.e
 * JD-Core Version:    0.6.2
 */