package com.e.a.d;

import java.util.Arrays;

final class b
{
  private static final char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  private static final char[] b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
  private static final int[] c = new int[256];
  private static final int[] d = new int[256];

  static
  {
    Arrays.fill(c, -1);
    int i = a.length;
    int j = 0;
    int k;
    if (j >= i)
    {
      c[61] = 0;
      Arrays.fill(d, -1);
      k = b.length;
    }
    for (int m = 0; ; m++)
    {
      if (m >= k)
      {
        d[61] = 0;
        return;
        c[a[j]] = j;
        j++;
        break;
      }
      d[b[m]] = m;
    }
  }

  public static String a(String paramString)
  {
    int i = paramString.length();
    int j = i - b(paramString);
    int k;
    char[] arrayOfChar;
    if (j % 4 == 0)
    {
      k = 0;
      arrayOfChar = new char[i + k];
      paramString.getChars(0, i, arrayOfChar, 0);
    }
    int n;
    for (int m = 0; ; m++)
    {
      n = 0;
      if (m >= k)
      {
        if (n < i)
          break label88;
        return new String(arrayOfChar);
        k = 4 - j % 4;
        break;
      }
      arrayOfChar[(i + m)] = '=';
    }
    label88: if (arrayOfChar[n] == '_')
      arrayOfChar[n] = '/';
    while (true)
    {
      n++;
      break;
      if (arrayOfChar[n] == '-')
        arrayOfChar[n] = '+';
    }
  }

  public static int b(String paramString)
  {
    int i = 0;
    int j = 0;
    while (true)
    {
      if (i >= paramString.length())
        return j;
      int k = paramString.charAt(i);
      if ((c[k] == -1) && (d[k] == -1))
        j++;
      i++;
    }
  }

  public static byte[] c(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
      return new byte[0];
    String str = a(paramString);
    int i = str.length();
    int j = b(str);
    if ((i - j) % 4 != 0)
      return new byte[0];
    int k = i;
    int m = 0;
    int n;
    byte[] arrayOfByte;
    int i1;
    int i2;
    if (k > 1)
    {
      int[] arrayOfInt2 = c;
      k--;
      if (arrayOfInt2[str.charAt(k)] <= 0);
    }
    else
    {
      n = (6 * (i - j) >> 3) - m;
      arrayOfByte = new byte[n];
      i1 = 0;
      i2 = 0;
    }
    while (true)
    {
      if (i1 >= n)
      {
        return arrayOfByte;
        if (str.charAt(k) != '=')
          break;
        m++;
        break;
      }
      int i3 = 0;
      int i4 = i2;
      int i5 = 0;
      int i9;
      if (i5 >= 4)
      {
        int i8 = i1 + 1;
        arrayOfByte[i1] = ((byte)(i3 >> 16));
        if (i8 < n)
        {
          i9 = i8 + 1;
          arrayOfByte[i8] = ((byte)(i3 >> 8));
          if (i9 < n)
          {
            i8 = i9 + 1;
            arrayOfByte[i9] = ((byte)i3);
          }
        }
        else
        {
          i1 = i8;
          i2 = i4;
        }
      }
      else
      {
        int[] arrayOfInt1 = c;
        int i6 = i4 + 1;
        int i7 = arrayOfInt1[str.charAt(i4)];
        if (i7 >= 0)
          i3 |= i7 << 18 - i5 * 6;
        while (true)
        {
          i5++;
          i4 = i6;
          break;
          i5--;
        }
        i1 = i9;
        i2 = i4;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.d.b
 * JD-Core Version:    0.6.2
 */