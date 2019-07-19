package com.google.e.f.a;

import com.google.e.f.k;
import com.google.e.j;

public abstract class a extends k
{
  private final int[] a = new int[4];
  private final int[] b = new int[8];
  private final float[] c = new float[4];
  private final float[] d = new float[4];
  private final int[] e = new int[this.b.length / 2];
  private final int[] f = new int[this.b.length / 2];

  protected static int a(int[] paramArrayOfInt)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    int k = 0;
    while (i < j)
    {
      k += paramArrayOfInt[i];
      i++;
    }
    return k;
  }

  protected static int a(int[] paramArrayOfInt, int[][] paramArrayOfInt1)
    throws j
  {
    for (int i = 0; i < paramArrayOfInt1.length; i++)
      if (a(paramArrayOfInt, paramArrayOfInt1[i], 0.45F) < 0.2F)
        return i;
    throw j.a();
  }

  protected static void a(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    int i = 0;
    float f1 = paramArrayOfFloat[0];
    for (int j = 1; j < paramArrayOfInt.length; j++)
      if (paramArrayOfFloat[j] > f1)
      {
        f1 = paramArrayOfFloat[j];
        i = j;
      }
    paramArrayOfInt[i] = (1 + paramArrayOfInt[i]);
  }

  protected static void b(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    int i = 0;
    float f1 = paramArrayOfFloat[0];
    for (int j = 1; j < paramArrayOfInt.length; j++)
      if (paramArrayOfFloat[j] < f1)
      {
        f1 = paramArrayOfFloat[j];
        i = j;
      }
    paramArrayOfInt[i] = (-1 + paramArrayOfInt[i]);
  }

  protected static boolean b(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0] + paramArrayOfInt[1];
    int j = i + paramArrayOfInt[2] + paramArrayOfInt[3];
    float f1 = i / j;
    int k;
    int m;
    int i1;
    int i2;
    if ((f1 >= 0.7916667F) && (f1 <= 0.8928571F))
    {
      k = 2147483647;
      m = -2147483648;
      int n = paramArrayOfInt.length;
      i1 = 0;
      if (i1 < n)
      {
        i2 = paramArrayOfInt[i1];
        if (i2 > m)
          m = i2;
        if (i2 >= k)
          break label110;
      }
    }
    while (true)
    {
      i1++;
      k = i2;
      break;
      return m < k * 10;
      return false;
      label110: i2 = k;
    }
  }

  protected final int[] b()
  {
    return this.a;
  }

  protected final int[] c()
  {
    return this.b;
  }

  protected final float[] d()
  {
    return this.c;
  }

  protected final float[] e()
  {
    return this.d;
  }

  protected final int[] f()
  {
    return this.e;
  }

  protected final int[] g()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.a
 * JD-Core Version:    0.6.2
 */