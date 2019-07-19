package com.google.e.f;

import com.google.e.g;
import com.google.e.j;

public final class q extends p
{
  private static final int[] a = { 1, 1, 1, 1, 1, 1 };
  private static final int[][] f = { { 56, 52, 50, 49, 44, 38, 35, 42, 41, 37 }, { 7, 11, 13, 14, 19, 25, 28, 21, 22, 26 } };
  private final int[] g = new int[4];

  private static void a(StringBuilder paramStringBuilder, int paramInt)
    throws j
  {
    for (int i = 0; i <= 1; i++)
      for (int j = 0; j < 10; j++)
        if (paramInt == f[i][j])
        {
          paramStringBuilder.insert(0, (char)(i + 48));
          paramStringBuilder.append((char)(j + 48));
          return;
        }
    throw j.a();
  }

  public static String b(String paramString)
  {
    char[] arrayOfChar = new char[6];
    paramString.getChars(1, 7, arrayOfChar, 0);
    StringBuilder localStringBuilder = new StringBuilder(12);
    localStringBuilder.append(paramString.charAt(0));
    char c = arrayOfChar[5];
    switch (c)
    {
    default:
      localStringBuilder.append(arrayOfChar, 0, 5);
      localStringBuilder.append("0000");
      localStringBuilder.append(c);
    case '0':
    case '1':
    case '2':
    case '3':
    case '4':
    }
    while (true)
    {
      localStringBuilder.append(paramString.charAt(7));
      return localStringBuilder.toString();
      localStringBuilder.append(arrayOfChar, 0, 2);
      localStringBuilder.append(c);
      localStringBuilder.append("0000");
      localStringBuilder.append(arrayOfChar, 2, 3);
      continue;
      localStringBuilder.append(arrayOfChar, 0, 3);
      localStringBuilder.append("00000");
      localStringBuilder.append(arrayOfChar, 3, 2);
      continue;
      localStringBuilder.append(arrayOfChar, 0, 4);
      localStringBuilder.append("00000");
      localStringBuilder.append(arrayOfChar[4]);
    }
  }

  protected int a(com.google.e.c.a parama, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws j
  {
    int[] arrayOfInt = this.g;
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
      int n = a(parama, arrayOfInt, j, e);
      paramStringBuilder.append((char)(48 + n % 10));
      int i1 = arrayOfInt.length;
      int i2 = j;
      for (int i3 = 0; i3 < i1; i3++)
        i2 += arrayOfInt[i3];
      if (n >= 10)
        m |= 1 << 5 - k;
      k++;
      j = i2;
    }
    a(paramStringBuilder, m);
    return j;
  }

  protected boolean a(String paramString)
    throws g
  {
    return super.a(b(paramString));
  }

  protected int[] a(com.google.e.c.a parama, int paramInt)
    throws j
  {
    return a(parama, paramInt, true, a);
  }

  com.google.e.a b()
  {
    return com.google.e.a.p;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.q
 * JD-Core Version:    0.6.2
 */