package com.google.e.f;

import com.google.e.d;
import com.google.e.e;
import com.google.e.j;
import com.google.e.m;
import com.google.e.n;
import com.google.e.q;
import java.util.Arrays;
import java.util.Map;

public abstract class p extends k
{
  static final int[] b = { 1, 1, 1 };
  static final int[] c = { 1, 1, 1, 1, 1 };
  static final int[][] d = { { 3, 2, 1, 1 }, { 2, 2, 2, 1 }, { 2, 1, 2, 2 }, { 1, 4, 1, 1 }, { 1, 1, 3, 2 }, { 1, 2, 3, 1 }, { 1, 1, 1, 4 }, { 1, 3, 1, 2 }, { 1, 2, 1, 3 }, { 3, 1, 1, 2 } };
  static final int[][] e = new int[20][];
  private final StringBuilder a = new StringBuilder(20);
  private final o f = new o();
  private final g g = new g();

  static
  {
    System.arraycopy(d, 0, e, 0, 10);
    for (int i = 10; i < 20; i++)
    {
      int[] arrayOfInt1 = d[(i - 10)];
      int[] arrayOfInt2 = new int[arrayOfInt1.length];
      for (int j = 0; j < arrayOfInt1.length; j++)
        arrayOfInt2[j] = arrayOfInt1[(-1 + (arrayOfInt1.length - j))];
      e[i] = arrayOfInt2;
    }
  }

  static int a(com.google.e.c.a parama, int[] paramArrayOfInt, int paramInt, int[][] paramArrayOfInt1)
    throws j
  {
    a(parama, paramInt, paramArrayOfInt);
    float f1 = 0.48F;
    int i = -1;
    int j = paramArrayOfInt1.length;
    int k = 0;
    float f2;
    if (k < j)
    {
      f2 = a(paramArrayOfInt, paramArrayOfInt1[k], 0.7F);
      if (f2 >= f1)
        break label73;
      i = k;
    }
    while (true)
    {
      k++;
      f1 = f2;
      break;
      if (i >= 0)
        return i;
      throw j.a();
      label73: f2 = f1;
    }
  }

  static boolean a(CharSequence paramCharSequence)
    throws com.google.e.g
  {
    int i = paramCharSequence.length();
    if (i == 0);
    int m;
    do
    {
      return false;
      int j = i - 2;
      int k = 0;
      while (j >= 0)
      {
        int i2 = '￐' + paramCharSequence.charAt(j);
        if ((i2 < 0) || (i2 > 9))
          throw com.google.e.g.a();
        k += i2;
        j -= 2;
      }
      m = k * 3;
      for (int n = i - 1; n >= 0; n -= 2)
      {
        int i1 = '￐' + paramCharSequence.charAt(n);
        if ((i1 < 0) || (i1 > 9))
          throw com.google.e.g.a();
        m += i1;
      }
    }
    while (m % 10 != 0);
    return true;
  }

  static int[] a(com.google.e.c.a parama)
    throws j
  {
    int[] arrayOfInt1 = new int[b.length];
    int i = 0;
    int[] arrayOfInt2 = null;
    boolean bool = false;
    while (!bool)
    {
      Arrays.fill(arrayOfInt1, 0, b.length, 0);
      arrayOfInt2 = a(parama, i, false, b, arrayOfInt1);
      int j = arrayOfInt2[0];
      i = arrayOfInt2[1];
      int k = j - (i - j);
      if (k >= 0)
        bool = parama.a(k, j, false);
    }
    return arrayOfInt2;
  }

  static int[] a(com.google.e.c.a parama, int paramInt, boolean paramBoolean, int[] paramArrayOfInt)
    throws j
  {
    return a(parama, paramInt, paramBoolean, paramArrayOfInt, new int[paramArrayOfInt.length]);
  }

  private static int[] a(com.google.e.c.a parama, int paramInt, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    throws j
  {
    int i = paramArrayOfInt1.length;
    int j = parama.a();
    int k;
    int m;
    int n;
    boolean bool;
    if (paramBoolean)
    {
      k = parama.d(paramInt);
      m = k;
      n = 0;
      bool = paramBoolean;
      label31: if (m >= j)
        break label190;
      if (!(bool ^ parama.a(m)))
        break label78;
      paramArrayOfInt2[n] = (1 + paramArrayOfInt2[n]);
    }
    while (true)
    {
      m++;
      break label31;
      k = parama.c(paramInt);
      break;
      label78: if (n == i - 1)
      {
        if (a(paramArrayOfInt2, paramArrayOfInt1, 0.7F) < 0.48F)
          return new int[] { k, m };
        k += paramArrayOfInt2[0] + paramArrayOfInt2[1];
        System.arraycopy(paramArrayOfInt2, 2, paramArrayOfInt2, 0, i - 2);
        paramArrayOfInt2[(i - 2)] = 0;
        paramArrayOfInt2[(i - 1)] = 0;
        n--;
      }
      while (true)
      {
        paramArrayOfInt2[n] = 1;
        if (bool)
          break label184;
        bool = true;
        break;
        n++;
      }
      label184: bool = false;
    }
    label190: throw j.a();
  }

  protected abstract int a(com.google.e.c.a parama, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws j;

  public n a(int paramInt, com.google.e.c.a parama, Map<e, ?> paramMap)
    throws j, d, com.google.e.g
  {
    return a(paramInt, parama, a(parama), paramMap);
  }

  public n a(int paramInt, com.google.e.c.a parama, int[] paramArrayOfInt, Map<e, ?> paramMap)
    throws j, d, com.google.e.g
  {
    if (paramMap == null);
    StringBuilder localStringBuilder;
    int[] arrayOfInt1;
    for (q localq = null; ; localq = (q)paramMap.get(e.j))
    {
      if (localq != null)
        localq.a(new com.google.e.p((paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F, paramInt));
      localStringBuilder = this.a;
      localStringBuilder.setLength(0);
      int i = a(parama, paramArrayOfInt, localStringBuilder);
      if (localq != null)
        localq.a(new com.google.e.p(i, paramInt));
      arrayOfInt1 = a(parama, i);
      if (localq != null)
        localq.a(new com.google.e.p((arrayOfInt1[0] + arrayOfInt1[1]) / 2.0F, paramInt));
      int j = arrayOfInt1[1];
      int k = j + (j - arrayOfInt1[0]);
      if ((k < parama.a()) && (parama.a(j, k, false)))
        break;
      throw j.a();
    }
    String str1 = localStringBuilder.toString();
    if (str1.length() < 8)
      throw com.google.e.g.a();
    if (!a(str1))
      throw d.a();
    float f1 = (paramArrayOfInt[1] + paramArrayOfInt[0]) / 2.0F;
    float f2 = (arrayOfInt1[1] + arrayOfInt1[0]) / 2.0F;
    com.google.e.a locala = b();
    com.google.e.p[] arrayOfp = new com.google.e.p[2];
    arrayOfp[0] = new com.google.e.p(f1, paramInt);
    arrayOfp[1] = new com.google.e.p(f2, paramInt);
    n localn1 = new n(str1, null, arrayOfp, locala);
    try
    {
      n localn2 = this.f.a(paramInt, parama, arrayOfInt1[1]);
      localn1.a(com.google.e.o.h, localn2.a());
      localn1.a(localn2.e());
      localn1.a(localn2.c());
      int i3 = localn2.a().length();
      m = i3;
      if (paramMap == null)
      {
        arrayOfInt2 = null;
        if (arrayOfInt2 == null)
          break label456;
        int n = arrayOfInt2.length;
        i1 = 0;
        int i2 = 0;
        if (i1 < n)
        {
          if (m != arrayOfInt2[i1])
            break label450;
          i2 = 1;
        }
        if (i2 != 0)
          break label456;
        throw j.a();
      }
    }
    catch (m localm)
    {
      while (true)
      {
        int i1;
        int m = 0;
        continue;
        int[] arrayOfInt2 = (int[])paramMap.get(e.k);
        continue;
        label450: i1++;
      }
      label456: if ((locala == com.google.e.a.h) || (locala == com.google.e.a.o))
      {
        String str2 = this.g.a(str1);
        if (str2 != null)
          localn1.a(com.google.e.o.g, str2);
      }
    }
    return localn1;
  }

  boolean a(String paramString)
    throws com.google.e.g
  {
    return a(paramString);
  }

  int[] a(com.google.e.c.a parama, int paramInt)
    throws j
  {
    return a(parama, paramInt, false, b);
  }

  abstract com.google.e.a b();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.p
 * JD-Core Version:    0.6.2
 */