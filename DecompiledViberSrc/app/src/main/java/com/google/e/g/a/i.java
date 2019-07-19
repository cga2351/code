package com.google.e.g.a;

import com.google.e.g.a;
import java.lang.reflect.Array;

final class i
{
  private static final float[][] a;

  static
  {
    int[] arrayOfInt = { a.a.length, 8 };
    a = (float[][])Array.newInstance(Float.TYPE, arrayOfInt);
    for (int i = 0; i < a.a.length; i++)
    {
      int j = a.a[i];
      int k = j & 0x1;
      int m = 0;
      int n = k;
      while (m < 8)
      {
        float f = 0.0F;
        while ((j & 0x1) == n)
        {
          f += 1.0F;
          j >>= 1;
        }
        n = j & 0x1;
        a[i][(-1 + (8 - m))] = (f / 17.0F);
        m++;
      }
    }
  }

  static int a(int[] paramArrayOfInt)
  {
    int i = c(b(paramArrayOfInt));
    if (i != -1)
      return i;
    return e(paramArrayOfInt);
  }

  private static int[] b(int[] paramArrayOfInt)
  {
    int i = 0;
    float f1 = a.a(paramArrayOfInt);
    int[] arrayOfInt = new int[8];
    int j = 0;
    int k = 0;
    while (j < 17)
    {
      float f2 = f1 / 34.0F + f1 * j / 17.0F;
      if (i + paramArrayOfInt[k] <= f2)
      {
        i += paramArrayOfInt[k];
        k++;
      }
      arrayOfInt[k] = (1 + arrayOfInt[k]);
      j++;
    }
    return arrayOfInt;
  }

  private static int c(int[] paramArrayOfInt)
  {
    int i = d(paramArrayOfInt);
    if (a.a(i) == -1)
      return -1;
    return i;
  }

  private static int d(int[] paramArrayOfInt)
  {
    long l1 = 0L;
    for (int i = 0; i < paramArrayOfInt.length; i++)
    {
      int j = 0;
      if (j < paramArrayOfInt[i])
      {
        long l2 = l1 << 1;
        if (i % 2 == 0);
        for (int k = 1; ; k = 0)
        {
          long l3 = l2 | k;
          j++;
          l1 = l3;
          break;
        }
      }
    }
    return (int)l1;
  }

  private static int e(int[] paramArrayOfInt)
  {
    int i = a.a(paramArrayOfInt);
    float[] arrayOfFloat1 = new float[8];
    for (int j = 0; j < arrayOfFloat1.length; j++)
      arrayOfFloat1[j] = (paramArrayOfInt[j] / i);
    float f1 = 3.4028235E+38F;
    int k = -1;
    int m = 0;
    if (m < a.length)
    {
      float f2 = 0.0F;
      float[] arrayOfFloat2 = a[m];
      for (int n = 0; ; n++)
        if (n < 8)
        {
          float f3 = arrayOfFloat2[n] - arrayOfFloat1[n];
          f2 += f3 * f3;
          if (f2 < f1);
        }
        else
        {
          if (f2 < f1)
          {
            k = a.a[m];
            f1 = f2;
          }
          m++;
          break;
        }
    }
    return k;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g.a.i
 * JD-Core Version:    0.6.2
 */