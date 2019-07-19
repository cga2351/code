package com.google.e.f;

import com.google.e.j;

public final class f extends p
{
  private final int[] a = new int[4];

  protected int a(com.google.e.c.a parama, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws j
  {
    int[] arrayOfInt = this.a;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = parama.a();
    int j = paramArrayOfInt[1];
    int k = 0;
    while ((k < 4) && (j < i))
    {
      paramStringBuilder.append((char)(48 + a(parama, arrayOfInt, j, d)));
      int i4 = arrayOfInt.length;
      int i5 = j;
      for (int i6 = 0; i6 < i4; i6++)
        i5 += arrayOfInt[i6];
      k++;
      j = i5;
    }
    int m = a(parama, j, true, c)[1];
    int n = 0;
    while ((n < 4) && (m < i))
    {
      paramStringBuilder.append((char)(48 + a(parama, arrayOfInt, m, d)));
      int i1 = arrayOfInt.length;
      int i2 = m;
      for (int i3 = 0; i3 < i1; i3++)
        i2 += arrayOfInt[i3];
      n++;
      m = i2;
    }
    return m;
  }

  com.google.e.a b()
  {
    return com.google.e.a.g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.f
 * JD-Core Version:    0.6.2
 */