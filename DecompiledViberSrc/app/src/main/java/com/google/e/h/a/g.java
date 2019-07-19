package com.google.e.h.a;

final class g
{
  private static final int[][] a = { { 21522, 0 }, { 20773, 1 }, { 24188, 2 }, { 23371, 3 }, { 17913, 4 }, { 16590, 5 }, { 20375, 6 }, { 19104, 7 }, { 30660, 8 }, { 29427, 9 }, { 32170, 10 }, { 30877, 11 }, { 26159, 12 }, { 25368, 13 }, { 27713, 14 }, { 26998, 15 }, { 5769, 16 }, { 5054, 17 }, { 7399, 18 }, { 6608, 19 }, { 1890, 20 }, { 597, 21 }, { 3340, 22 }, { 2107, 23 }, { 13663, 24 }, { 12392, 25 }, { 16177, 26 }, { 14854, 27 }, { 9396, 28 }, { 8579, 29 }, { 11994, 30 }, { 11245, 31 } };
  private static final int[] b = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
  private final f c;
  private final byte d;

  private g(int paramInt)
  {
    this.c = f.a(0x3 & paramInt >> 3);
    this.d = ((byte)(paramInt & 0x7));
  }

  static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 ^ paramInt2;
    return b[(i & 0xF)] + b[(0xF & i >>> 4)] + b[(0xF & i >>> 8)] + b[(0xF & i >>> 12)] + b[(0xF & i >>> 16)] + b[(0xF & i >>> 20)] + b[(0xF & i >>> 24)] + b[(0xF & i >>> 28)];
  }

  static g b(int paramInt1, int paramInt2)
  {
    g localg = c(paramInt1, paramInt2);
    if (localg != null)
      return localg;
    return c(paramInt1 ^ 0x5412, paramInt2 ^ 0x5412);
  }

  private static g c(int paramInt1, int paramInt2)
  {
    int i = 2147483647;
    int[][] arrayOfInt = a;
    int j = arrayOfInt.length;
    int k = 0;
    int m = 0;
    int[] arrayOfInt1;
    int n;
    int i1;
    if (k < j)
    {
      arrayOfInt1 = arrayOfInt[k];
      n = arrayOfInt1[0];
      if ((n == paramInt1) || (n == paramInt2))
        return new g(arrayOfInt1[1]);
      i1 = a(paramInt1, n);
      if (i1 >= i)
        break label147;
    }
    for (int i2 = arrayOfInt1[1]; ; i2 = m)
    {
      int i3;
      if (paramInt1 != paramInt2)
      {
        i3 = a(paramInt2, n);
        if (i3 < i1)
          i2 = arrayOfInt1[1];
      }
      while (true)
      {
        k++;
        int i4 = i2;
        i = i3;
        m = i4;
        break;
        if (i <= 3)
          return new g(m);
        return null;
        i3 = i1;
      }
      label147: i1 = i;
    }
  }

  f a()
  {
    return this.c;
  }

  byte b()
  {
    return this.d;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof g));
    g localg;
    do
    {
      return false;
      localg = (g)paramObject;
    }
    while ((this.c != localg.c) || (this.d != localg.d));
    return true;
  }

  public int hashCode()
  {
    return this.c.ordinal() << 3 | this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.a.g
 * JD-Core Version:    0.6.2
 */