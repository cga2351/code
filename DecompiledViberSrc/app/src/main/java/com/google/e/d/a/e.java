package com.google.e.d.a;

import com.google.e.g;

public final class e
{
  private static final e[] a = h();
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final b g;
  private final int h;

  private e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, b paramb)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramb;
    int j = paramb.a();
    a[] arrayOfa = paramb.b();
    int k = arrayOfa.length;
    int m = 0;
    while (i < k)
    {
      a locala = arrayOfa[i];
      m += locala.a() * (j + locala.b());
      i++;
    }
    this.h = m;
  }

  public static e a(int paramInt1, int paramInt2)
    throws g
  {
    if (((paramInt1 & 0x1) != 0) || ((paramInt2 & 0x1) != 0))
      throw g.a();
    for (e locale : a)
      if ((locale.c == paramInt1) && (locale.d == paramInt2))
        return locale;
    throw g.a();
  }

  private static e[] h()
  {
    e[] arrayOfe = new e[30];
    arrayOfe[0] = new e(1, 10, 10, 8, 8, new b(5, new a(1, 3, null), null));
    arrayOfe[1] = new e(2, 12, 12, 10, 10, new b(7, new a(1, 5, null), null));
    arrayOfe[2] = new e(3, 14, 14, 12, 12, new b(10, new a(1, 8, null), null));
    arrayOfe[3] = new e(4, 16, 16, 14, 14, new b(12, new a(1, 12, null), null));
    arrayOfe[4] = new e(5, 18, 18, 16, 16, new b(14, new a(1, 18, null), null));
    arrayOfe[5] = new e(6, 20, 20, 18, 18, new b(18, new a(1, 22, null), null));
    arrayOfe[6] = new e(7, 22, 22, 20, 20, new b(20, new a(1, 30, null), null));
    arrayOfe[7] = new e(8, 24, 24, 22, 22, new b(24, new a(1, 36, null), null));
    arrayOfe[8] = new e(9, 26, 26, 24, 24, new b(28, new a(1, 44, null), null));
    arrayOfe[9] = new e(10, 32, 32, 14, 14, new b(36, new a(1, 62, null), null));
    arrayOfe[10] = new e(11, 36, 36, 16, 16, new b(42, new a(1, 86, null), null));
    arrayOfe[11] = new e(12, 40, 40, 18, 18, new b(48, new a(1, 114, null), null));
    arrayOfe[12] = new e(13, 44, 44, 20, 20, new b(56, new a(1, 144, null), null));
    arrayOfe[13] = new e(14, 48, 48, 22, 22, new b(68, new a(1, 174, null), null));
    arrayOfe[14] = new e(15, 52, 52, 24, 24, new b(42, new a(2, 102, null), null));
    arrayOfe[15] = new e(16, 64, 64, 14, 14, new b(56, new a(2, 140, null), null));
    arrayOfe[16] = new e(17, 72, 72, 16, 16, new b(36, new a(4, 92, null), null));
    arrayOfe[17] = new e(18, 80, 80, 18, 18, new b(48, new a(4, 114, null), null));
    arrayOfe[18] = new e(19, 88, 88, 20, 20, new b(56, new a(4, 144, null), null));
    arrayOfe[19] = new e(20, 96, 96, 22, 22, new b(68, new a(4, 174, null), null));
    arrayOfe[20] = new e(21, 104, 104, 24, 24, new b(56, new a(6, 136, null), null));
    arrayOfe[21] = new e(22, 120, 120, 18, 18, new b(68, new a(6, 175, null), null));
    arrayOfe[22] = new e(23, 132, 132, 20, 20, new b(62, new a(8, 163, null), null));
    arrayOfe[23] = new e(24, 144, 144, 22, 22, new b(62, new a(8, 156, null), new a(2, 155, null), null));
    arrayOfe[24] = new e(25, 8, 18, 6, 16, new b(7, new a(1, 5, null), null));
    arrayOfe[25] = new e(26, 8, 32, 6, 14, new b(11, new a(1, 10, null), null));
    arrayOfe[26] = new e(27, 12, 26, 10, 24, new b(14, new a(1, 16, null), null));
    arrayOfe[27] = new e(28, 12, 36, 10, 16, new b(18, new a(1, 22, null), null));
    arrayOfe[28] = new e(29, 16, 36, 14, 16, new b(24, new a(1, 32, null), null));
    arrayOfe[29] = new e(30, 16, 48, 14, 22, new b(28, new a(1, 49, null), null));
    return arrayOfe;
  }

  public int a()
  {
    return this.b;
  }

  public int b()
  {
    return this.c;
  }

  public int c()
  {
    return this.d;
  }

  public int d()
  {
    return this.e;
  }

  public int e()
  {
    return this.f;
  }

  public int f()
  {
    return this.h;
  }

  b g()
  {
    return this.g;
  }

  public String toString()
  {
    return String.valueOf(this.b);
  }

  static final class a
  {
    private final int a;
    private final int b;

    private a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }

    int a()
    {
      return this.a;
    }

    int b()
    {
      return this.b;
    }
  }

  static final class b
  {
    private final int a;
    private final e.a[] b;

    private b(int paramInt, e.a parama)
    {
      this.a = paramInt;
      this.b = new e.a[] { parama };
    }

    private b(int paramInt, e.a parama1, e.a parama2)
    {
      this.a = paramInt;
      this.b = new e.a[] { parama1, parama2 };
    }

    int a()
    {
      return this.a;
    }

    e.a[] b()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.d.a.e
 * JD-Core Version:    0.6.2
 */