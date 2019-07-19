package com.google.e.f;

import com.google.e.j;

public final class e extends p
{
  static final int[] a = { 0, 11, 13, 14, 19, 25, 28, 21, 22, 26 };
  private final int[] f = new int[4];

  private static void a(StringBuilder paramStringBuilder, int paramInt)
    throws j
  {
    for (int i = 0; i < 10; i++)
      if (paramInt == a[i])
      {
        paramStringBuilder.insert(0, (char)(i + 48));
        return;
      }
    throw j.a();
  }

  protected int a(com.google.e.c.a parama, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws j
  {
    int[] arrayOfInt = this.f;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = parama.a();
    int j = paramArrayOfInt[1];
    int k = 0;
    int m = 0;
    while ((k < 6) && (j < i))
    {
      int i5 = a(parama, arrayOfInt, j, e);
      paramStringBuilder.append((char)(48 + i5 % 10));
      int i6 = arrayOfInt.length;
      int i7 = j;
      for (int i8 = 0; i8 < i6; i8++)
        i7 += arrayOfInt[i8];
      if (i5 >= 10)
        m |= 1 << 5 - k;
      k++;
      j = i7;
    }
    a(paramStringBuilder, m);
    int n = a(parama, j, true, c)[1];
    int i1 = 0;
    while ((i1 < 6) && (n < i))
    {
      paramStringBuilder.append((char)(48 + a(parama, arrayOfInt, n, d)));
      int i2 = arrayOfInt.length;
      int i3 = n;
      for (int i4 = 0; i4 < i2; i4++)
        i3 += arrayOfInt[i4];
      i1++;
      n = i3;
    }
    return n;
  }

  com.google.e.a b()
  {
    return com.google.e.a.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.e
 * JD-Core Version:    0.6.2
 */