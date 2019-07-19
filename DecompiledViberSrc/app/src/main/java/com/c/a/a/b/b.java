package com.c.a.a.b;

import java.util.Arrays;

public final class b
{
  static final int[] a;
  static final int[] b;
  static final int[] c;
  static final int[] d;
  static final int[] e;
  static final int[] f;
  static final int[] g;
  private static final char[] h = "0123456789ABCDEF".toCharArray();
  private static final byte[] i;

  static
  {
    int j = h.length;
    i = new byte[j];
    for (int k = 0; k < j; k++)
      i[k] = ((byte)h[k]);
    int[] arrayOfInt1 = new int[256];
    for (int m = 0; m < 32; m++)
      arrayOfInt1[m] = -1;
    arrayOfInt1[34] = 1;
    arrayOfInt1[92] = 1;
    a = arrayOfInt1;
    int[] arrayOfInt2 = new int[a.length];
    System.arraycopy(a, 0, arrayOfInt2, 0, a.length);
    int n = 128;
    if (n < 256)
    {
      int i5;
      if ((n & 0xE0) == 192)
        i5 = 2;
      while (true)
      {
        arrayOfInt2[n] = i5;
        n++;
        break;
        if ((n & 0xF0) == 224)
          i5 = 3;
        else if ((n & 0xF8) == 240)
          i5 = 4;
        else
          i5 = -1;
      }
    }
    b = arrayOfInt2;
    int[] arrayOfInt3 = new int[256];
    Arrays.fill(arrayOfInt3, -1);
    for (int i1 = 33; i1 < 256; i1++)
      if (Character.isJavaIdentifierPart((char)i1))
        arrayOfInt3[i1] = 0;
    arrayOfInt3[64] = 0;
    arrayOfInt3[35] = 0;
    arrayOfInt3[42] = 0;
    arrayOfInt3[45] = 0;
    arrayOfInt3[43] = 0;
    c = arrayOfInt3;
    int[] arrayOfInt4 = new int[256];
    System.arraycopy(c, 0, arrayOfInt4, 0, c.length);
    Arrays.fill(arrayOfInt4, 128, 128, 0);
    d = arrayOfInt4;
    e = new int[256];
    System.arraycopy(b, 128, e, 128, 128);
    Arrays.fill(e, 0, 32, -1);
    e[9] = 0;
    e[10] = 10;
    e[13] = 13;
    e[42] = 42;
    int[] arrayOfInt5 = new int[''];
    for (int i2 = 0; i2 < 32; i2++)
      arrayOfInt5[i2] = -1;
    arrayOfInt5[34] = 34;
    arrayOfInt5[92] = 92;
    arrayOfInt5[8] = 98;
    arrayOfInt5[9] = 116;
    arrayOfInt5[12] = 102;
    arrayOfInt5[10] = 110;
    arrayOfInt5[13] = 114;
    f = arrayOfInt5;
    g = new int[''];
    Arrays.fill(g, -1);
    for (int i3 = 0; i3 < 10; i3++)
      g[(i3 + 48)] = i3;
    for (int i4 = 0; i4 < 6; i4++)
    {
      g[(i4 + 97)] = (i4 + 10);
      g[(i4 + 65)] = (i4 + 10);
    }
  }

  public static int a(int paramInt)
  {
    if (paramInt > 127)
      return -1;
    return g[paramInt];
  }

  public static void a(StringBuilder paramStringBuilder, String paramString)
  {
    int[] arrayOfInt = f;
    int j = arrayOfInt.length;
    int k = 0;
    int m = paramString.length();
    if (k < m)
    {
      int n = paramString.charAt(k);
      if ((n >= j) || (arrayOfInt[n] == 0))
        paramStringBuilder.append(n);
      while (true)
      {
        k++;
        break;
        paramStringBuilder.append('\\');
        int i1 = arrayOfInt[n];
        if (i1 < 0)
        {
          paramStringBuilder.append('u');
          paramStringBuilder.append('0');
          paramStringBuilder.append('0');
          int i2 = -(i1 + 1);
          paramStringBuilder.append(h[(i2 >> 4)]);
          paramStringBuilder.append(h[(i2 & 0xF)]);
        }
        else
        {
          paramStringBuilder.append((char)i1);
        }
      }
    }
  }

  public static int[] a()
  {
    return a;
  }

  public static int[] b()
  {
    return b;
  }

  public static int[] c()
  {
    return c;
  }

  public static int[] d()
  {
    return d;
  }

  public static int[] e()
  {
    return e;
  }

  public static int[] f()
  {
    return f;
  }

  public static char[] g()
  {
    return (char[])h.clone();
  }

  public static byte[] h()
  {
    return (byte[])i.clone();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.b.b
 * JD-Core Version:    0.6.2
 */