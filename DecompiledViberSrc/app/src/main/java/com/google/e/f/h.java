package com.google.e.f;

import com.google.e.e;
import com.google.e.g;
import com.google.e.j;
import com.google.e.n;
import com.google.e.p;
import java.util.Map;

public final class h extends k
{
  static final int[][] a = { { 1, 1, 3, 3, 1 }, { 3, 1, 1, 1, 3 }, { 1, 3, 1, 1, 3 }, { 3, 3, 1, 1, 1 }, { 1, 1, 3, 1, 3 }, { 3, 1, 3, 1, 1 }, { 1, 3, 3, 1, 1 }, { 1, 1, 1, 3, 3 }, { 3, 1, 1, 3, 1 }, { 1, 3, 1, 3, 1 } };
  private static final int[] b = { 6, 8, 10, 12, 14 };
  private static final int[] d = { 1, 1, 1, 1 };
  private static final int[] e = { 1, 1, 3 };
  private int c = -1;

  private static int a(int[] paramArrayOfInt)
    throws j
  {
    float f1 = 0.38F;
    int i = -1;
    int j = a.length;
    int k = 0;
    float f2;
    if (k < j)
    {
      f2 = a(paramArrayOfInt, a[k], 0.78F);
      if (f2 >= f1)
        break label62;
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
      label62: f2 = f1;
    }
  }

  private void a(com.google.e.c.a parama, int paramInt)
    throws j
  {
    int i = 10 * this.c;
    int j;
    int k;
    if (i < paramInt)
    {
      j = paramInt - 1;
      k = i;
    }
    for (int m = j; ; m--)
    {
      if ((k <= 0) || (m < 0) || (parama.a(m)))
      {
        if (k == 0)
          return;
        throw j.a();
        i = paramInt;
        break;
      }
      k--;
    }
  }

  private static void a(com.google.e.c.a parama, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
    throws j
  {
    int[] arrayOfInt1 = new int[10];
    int[] arrayOfInt2 = new int[5];
    int[] arrayOfInt3 = new int[5];
    int m;
    for (int i = paramInt1; i < paramInt2; i = m)
    {
      a(parama, i, arrayOfInt1);
      for (int j = 0; j < 5; j++)
      {
        int i1 = j * 2;
        arrayOfInt2[j] = arrayOfInt1[i1];
        arrayOfInt3[j] = arrayOfInt1[(i1 + 1)];
      }
      paramStringBuilder.append((char)(48 + a(arrayOfInt2)));
      paramStringBuilder.append((char)(48 + a(arrayOfInt3)));
      int k = arrayOfInt1.length;
      m = i;
      for (int n = 0; n < k; n++)
        m += arrayOfInt1[n];
    }
  }

  private static int c(com.google.e.c.a parama)
    throws j
  {
    int i = parama.a();
    int j = parama.c(0);
    if (j == i)
      throw j.a();
    return j;
  }

  private static int[] c(com.google.e.c.a parama, int paramInt, int[] paramArrayOfInt)
    throws j
  {
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i];
    int j = parama.a();
    int k = paramInt;
    int m = 0;
    int n = 0;
    if (paramInt < j)
    {
      if ((n ^ parama.a(paramInt)) != 0)
        arrayOfInt[m] = (1 + arrayOfInt[m]);
      while (true)
      {
        paramInt++;
        break;
        if (m == i - 1)
        {
          if (a(arrayOfInt, paramArrayOfInt, 0.78F) < 0.38F)
            return new int[] { k, paramInt };
          k += arrayOfInt[0] + arrayOfInt[1];
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i - 2);
          arrayOfInt[(i - 2)] = 0;
          arrayOfInt[(i - 1)] = 0;
          m--;
        }
        while (true)
        {
          arrayOfInt[m] = 1;
          if (n != 0)
            break label159;
          n = 1;
          break;
          m++;
        }
        label159: n = 0;
      }
    }
    throw j.a();
  }

  public n a(int paramInt, com.google.e.c.a parama, Map<e, ?> paramMap)
    throws g, j
  {
    int[] arrayOfInt1 = a(parama);
    int[] arrayOfInt2 = b(parama);
    StringBuilder localStringBuilder = new StringBuilder(20);
    a(parama, arrayOfInt1[1], arrayOfInt2[0], localStringBuilder);
    String str = localStringBuilder.toString();
    if (paramMap != null);
    for (int[] arrayOfInt3 = (int[])paramMap.get(e.f); ; arrayOfInt3 = null)
    {
      if (arrayOfInt3 == null)
        arrayOfInt3 = b;
      int i = str.length();
      int j = arrayOfInt3.length;
      int k = 0;
      int m = 0;
      int i1;
      if (k < j)
      {
        i1 = arrayOfInt3[k];
        if (i != i1);
      }
      for (int n = 1; ; n = 0)
      {
        if ((n == 0) && (i > m))
          n = 1;
        if (n == 0)
        {
          throw g.a();
          if (i1 <= m)
            break label218;
        }
        while (true)
        {
          k++;
          m = i1;
          break;
          p[] arrayOfp = new p[2];
          arrayOfp[0] = new p(arrayOfInt1[1], paramInt);
          arrayOfp[1] = new p(arrayOfInt2[0], paramInt);
          return new n(str, null, arrayOfp, com.google.e.a.i);
          label218: i1 = m;
        }
      }
    }
  }

  int[] a(com.google.e.c.a parama)
    throws j
  {
    int[] arrayOfInt = c(parama, c(parama), d);
    this.c = ((arrayOfInt[1] - arrayOfInt[0]) / 4);
    a(parama, arrayOfInt[0]);
    return arrayOfInt;
  }

  int[] b(com.google.e.c.a parama)
    throws j
  {
    parama.e();
    try
    {
      int[] arrayOfInt = c(parama, c(parama), e);
      a(parama, arrayOfInt[0]);
      int i = arrayOfInt[0];
      arrayOfInt[0] = (parama.a() - arrayOfInt[1]);
      arrayOfInt[1] = (parama.a() - i);
      return arrayOfInt;
    }
    finally
    {
      parama.e();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.h
 * JD-Core Version:    0.6.2
 */