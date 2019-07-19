package com.google.e.f;

import com.google.e.d;
import com.google.e.e;
import com.google.e.g;
import com.google.e.j;
import com.google.e.n;
import com.google.e.p;
import java.util.Arrays;
import java.util.Map;

public final class c extends k
{
  static final int[] a = { 52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42 };
  private static final char[] b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();
  private static final int c = a[39];
  private final boolean d;
  private final boolean e;
  private final StringBuilder f;
  private final int[] g;

  public c()
  {
    this(false);
  }

  public c(boolean paramBoolean)
  {
    this(paramBoolean, false);
  }

  public c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = new StringBuilder(20);
    this.g = new int[9];
  }

  private static char a(int paramInt)
    throws j
  {
    for (int i = 0; i < a.length; i++)
      if (a[i] == paramInt)
        return b[i];
    throw j.a();
  }

  private static int a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    int k;
    for (int j = 0; ; j = k)
    {
      k = 2147483647;
      int m = paramArrayOfInt.length;
      for (int n = 0; n < m; n++)
      {
        int i9 = paramArrayOfInt[n];
        if ((i9 < k) && (i9 > j))
          k = i9;
      }
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      int i4 = 0;
      while (i1 < i)
      {
        int i8 = paramArrayOfInt[i1];
        if (i8 > k)
        {
          i2 |= 1 << i - 1 - i1;
          i4++;
          i3 += i8;
        }
        i1++;
      }
      if (i4 == 3)
      {
        int i5 = i4;
        for (int i6 = 0; ; i6++)
          if ((i6 < i) && (i5 > 0))
          {
            int i7 = paramArrayOfInt[i6];
            if (i7 > k)
            {
              i5--;
              if (i7 * 2 >= i3)
                i2 = -1;
            }
          }
          else
          {
            return i2;
          }
      }
      if (i4 <= 3)
        return -1;
    }
  }

  private static String a(CharSequence paramCharSequence)
    throws g
  {
    int i = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(i);
    int j = 0;
    if (j < i)
    {
      char c1 = paramCharSequence.charAt(j);
      int k;
      char c2;
      if ((c1 == '+') || (c1 == '$') || (c1 == '%') || (c1 == '/'))
      {
        k = paramCharSequence.charAt(j + 1);
        switch (c1)
        {
        default:
          c2 = '\000';
          label119: localStringBuilder.append(c2);
        case '+':
        case '$':
        case '%':
        case '/':
        }
      }
      for (int m = j + 1; ; m = j)
      {
        j = m + 1;
        break;
        if ((k >= 65) && (k <= 90))
        {
          c2 = (char)(k + 32);
          break label119;
        }
        throw g.a();
        if ((k >= 65) && (k <= 90))
        {
          c2 = (char)(k - 64);
          break label119;
        }
        throw g.a();
        if ((k >= 65) && (k <= 69))
        {
          c2 = (char)(k - 38);
          break label119;
        }
        if ((k >= 70) && (k <= 87))
        {
          c2 = (char)(k - 11);
          break label119;
        }
        throw g.a();
        if ((k >= 65) && (k <= 79))
        {
          c2 = (char)(k - 32);
          break label119;
        }
        if (k == 90)
        {
          c2 = ':';
          break label119;
        }
        throw g.a();
        localStringBuilder.append(c1);
      }
    }
    return localStringBuilder.toString();
  }

  private static int[] a(com.google.e.c.a parama, int[] paramArrayOfInt)
    throws j
  {
    int i = parama.a();
    int j = parama.c(0);
    int k = paramArrayOfInt.length;
    int m = j;
    int n = 0;
    int i1 = 0;
    if (m < i)
    {
      if ((n ^ parama.a(m)) != 0)
        paramArrayOfInt[i1] = (1 + paramArrayOfInt[i1]);
      while (true)
      {
        m++;
        break;
        if (i1 == k - 1)
        {
          if ((a(paramArrayOfInt) == c) && (parama.a(Math.max(0, j - (m - j) / 2), j, false)))
            return new int[] { j, m };
          j += paramArrayOfInt[0] + paramArrayOfInt[1];
          System.arraycopy(paramArrayOfInt, 2, paramArrayOfInt, 0, k - 2);
          paramArrayOfInt[(k - 2)] = 0;
          paramArrayOfInt[(k - 1)] = 0;
          i1--;
        }
        while (true)
        {
          paramArrayOfInt[i1] = 1;
          if (n != 0)
            break label171;
          n = 1;
          break;
          i1++;
        }
        label171: n = 0;
      }
    }
    throw j.a();
  }

  public n a(int paramInt, com.google.e.c.a parama, Map<e, ?> paramMap)
    throws j, d, g
  {
    int[] arrayOfInt1 = this.g;
    Arrays.fill(arrayOfInt1, 0);
    StringBuilder localStringBuilder = this.f;
    localStringBuilder.setLength(0);
    int[] arrayOfInt2 = a(parama, arrayOfInt1);
    int i = parama.c(arrayOfInt2[1]);
    int j = parama.a();
    while (true)
    {
      a(parama, i, arrayOfInt1);
      int k = a(arrayOfInt1);
      if (k < 0)
        throw j.a();
      char c1 = a(k);
      localStringBuilder.append(c1);
      int m = arrayOfInt1.length;
      int n = 0;
      int i1 = i;
      while (n < m)
      {
        i1 += arrayOfInt1[n];
        n++;
      }
      int i2 = parama.c(i1);
      if (c1 == '*')
      {
        localStringBuilder.setLength(-1 + localStringBuilder.length());
        int i3 = 0;
        int i4 = arrayOfInt1.length;
        for (int i5 = 0; i5 < i4; i5++)
          i3 += arrayOfInt1[i5];
        int i6 = i2 - i - i3;
        if ((i2 != j) && (i6 * 2 < i3))
          throw j.a();
        if (this.d)
        {
          int i7 = -1 + localStringBuilder.length();
          int i8 = 0;
          for (int i9 = 0; i9 < i7; i9++)
            i8 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(this.f.charAt(i9));
          if (localStringBuilder.charAt(i7) != b[(i8 % 43)])
            throw d.a();
          localStringBuilder.setLength(i7);
        }
        if (localStringBuilder.length() == 0)
          throw j.a();
        if (this.e);
        for (String str = a(localStringBuilder); ; str = localStringBuilder.toString())
        {
          float f1 = (arrayOfInt2[1] + arrayOfInt2[0]) / 2.0F;
          float f2 = i + i3 / 2.0F;
          p[] arrayOfp = new p[2];
          arrayOfp[0] = new p(f1, paramInt);
          arrayOfp[1] = new p(f2, paramInt);
          return new n(str, null, arrayOfp, com.google.e.a.c);
        }
      }
      i = i2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.c
 * JD-Core Version:    0.6.2
 */