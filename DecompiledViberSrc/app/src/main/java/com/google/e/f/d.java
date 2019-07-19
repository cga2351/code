package com.google.e.f;

import com.google.e.e;
import com.google.e.g;
import com.google.e.j;
import com.google.e.n;
import com.google.e.p;
import java.util.Arrays;
import java.util.Map;

public final class d extends k
{
  private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
  private static final int[] b = { 276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350 };
  private static final int c = b[47];
  private final StringBuilder d = new StringBuilder(20);
  private final int[] e = new int[6];

  private static char a(int paramInt)
    throws j
  {
    for (int i = 0; i < b.length; i++)
      if (b[i] == paramInt)
        return a[i];
    throw j.a();
  }

  private static int a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    int j = paramArrayOfInt.length;
    int k = 0;
    int i5;
    for (int m = 0; k < j; m = i5)
    {
      i5 = m + paramArrayOfInt[k];
      k++;
    }
    int n = 0;
    int i1 = 0;
    while (true)
    {
      int i2;
      if (n < i)
      {
        i2 = Math.round(9.0F * paramArrayOfInt[n] / m);
        if ((i2 < 1) || (i2 > 4))
          i1 = -1;
      }
      else
      {
        return i1;
      }
      if ((n & 0x1) == 0)
      {
        int i3 = 0;
        while (i3 < i2)
        {
          int i4 = 0x1 | i1 << 1;
          i3++;
          i1 = i4;
        }
      }
      i1 <<= i2;
      n++;
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
      int m;
      char c2;
      if ((c1 >= 'a') && (c1 <= 'd'))
      {
        if (j >= i - 1)
          throw g.a();
        m = paramCharSequence.charAt(j + 1);
        switch (c1)
        {
        default:
          c2 = '\000';
          label103: localStringBuilder.append(c2);
        case 'd':
        case 'a':
        case 'b':
        case 'c':
        }
      }
      for (int k = j + 1; ; k = j)
      {
        j = k + 1;
        break;
        if ((m >= 65) && (m <= 90))
        {
          c2 = (char)(m + 32);
          break label103;
        }
        throw g.a();
        if ((m >= 65) && (m <= 90))
        {
          c2 = (char)(m - 64);
          break label103;
        }
        throw g.a();
        if ((m >= 65) && (m <= 69))
        {
          c2 = (char)(m - 38);
          break label103;
        }
        if ((m >= 70) && (m <= 74))
        {
          c2 = (char)(m - 11);
          break label103;
        }
        if ((m >= 75) && (m <= 79))
        {
          c2 = (char)(m + 16);
          break label103;
        }
        if ((m >= 80) && (m <= 83))
        {
          c2 = (char)(m + 43);
          break label103;
        }
        if ((m >= 84) && (m <= 90))
        {
          c2 = '';
          break label103;
        }
        throw g.a();
        if ((m >= 65) && (m <= 79))
        {
          c2 = (char)(m - 32);
          break label103;
        }
        if (m == 90)
        {
          c2 = ':';
          break label103;
        }
        throw g.a();
        localStringBuilder.append(c1);
      }
    }
    return localStringBuilder.toString();
  }

  private static void a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    throws com.google.e.d
  {
    int i = paramInt1 - 1;
    int j = 1;
    int k = i;
    int n;
    for (int m = 0; k >= 0; m = n)
    {
      n = m + j * "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(paramCharSequence.charAt(k));
      int i1 = j + 1;
      if (i1 > paramInt2)
        i1 = 1;
      k--;
      j = i1;
    }
    if (paramCharSequence.charAt(paramInt1) != a[(m % 47)])
      throw com.google.e.d.a();
  }

  private int[] a(com.google.e.c.a parama)
    throws j
  {
    int i = parama.a();
    int j = parama.c(0);
    Arrays.fill(this.e, 0);
    int[] arrayOfInt = this.e;
    int k = arrayOfInt.length;
    int m = j;
    int n = 0;
    int i1 = j;
    int i2 = 0;
    if (m < i)
    {
      if ((n ^ parama.a(m)) != 0)
        arrayOfInt[i2] = (1 + arrayOfInt[i2]);
      while (true)
      {
        m++;
        break;
        if (i2 == k - 1)
        {
          if (a(arrayOfInt) == c)
            return new int[] { i1, m };
          i1 += arrayOfInt[0] + arrayOfInt[1];
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, k - 2);
          arrayOfInt[(k - 2)] = 0;
          arrayOfInt[(k - 1)] = 0;
          i2--;
        }
        while (true)
        {
          arrayOfInt[i2] = 1;
          if (n != 0)
            break label181;
          n = 1;
          break;
          i2++;
        }
        label181: n = 0;
      }
    }
    throw j.a();
  }

  private static void b(CharSequence paramCharSequence)
    throws com.google.e.d
  {
    int i = paramCharSequence.length();
    a(paramCharSequence, i - 2, 20);
    a(paramCharSequence, i - 1, 15);
  }

  public n a(int paramInt, com.google.e.c.a parama, Map<e, ?> paramMap)
    throws j, com.google.e.d, g
  {
    int[] arrayOfInt1 = a(parama);
    int i = parama.c(arrayOfInt1[1]);
    int j = parama.a();
    int[] arrayOfInt2 = this.e;
    Arrays.fill(arrayOfInt2, 0);
    StringBuilder localStringBuilder = this.d;
    localStringBuilder.setLength(0);
    while (true)
    {
      a(parama, i, arrayOfInt2);
      int k = a(arrayOfInt2);
      if (k < 0)
        throw j.a();
      char c1 = a(k);
      localStringBuilder.append(c1);
      int m = arrayOfInt2.length;
      int n = 0;
      int i1 = i;
      while (n < m)
      {
        i1 += arrayOfInt2[n];
        n++;
      }
      int i2 = parama.c(i1);
      if (c1 == '*')
      {
        localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
        int i3 = 0;
        int i4 = arrayOfInt2.length;
        for (int i5 = 0; i5 < i4; i5++)
          i3 += arrayOfInt2[i5];
        if ((i2 == j) || (!parama.a(i2)))
          throw j.a();
        if (localStringBuilder.length() < 2)
          throw j.a();
        b(localStringBuilder);
        localStringBuilder.setLength(-2 + localStringBuilder.length());
        String str = a(localStringBuilder);
        float f1 = (arrayOfInt1[1] + arrayOfInt1[0]) / 2.0F;
        float f2 = i + i3 / 2.0F;
        p[] arrayOfp = new p[2];
        arrayOfp[0] = new p(f1, paramInt);
        arrayOfp[1] = new p(f2, paramInt);
        return new n(str, null, arrayOfp, com.google.e.a.d);
      }
      i = i2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.d
 * JD-Core Version:    0.6.2
 */