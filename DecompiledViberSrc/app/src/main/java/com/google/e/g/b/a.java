package com.google.e.g.b;

import com.google.e.c;
import com.google.e.e;
import com.google.e.j;
import com.google.e.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final int[] a = { 0, 4, 1, 5 };
  private static final int[] b = { 6, 2, 7, 3 };
  private static final int[] c = { 8, 1, 1, 1, 1, 1, 1, 3 };
  private static final int[] d = { 7, 1, 1, 3, 1, 1, 1, 2, 1 };

  private static float a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, float paramFloat)
  {
    int i = paramArrayOfInt1.length;
    int j = 0;
    int k = 0;
    int m = 0;
    while (j < i)
    {
      m += paramArrayOfInt1[j];
      k += paramArrayOfInt2[j];
      j++;
    }
    if (m < k);
    float f3;
    label142: 
    while (true)
    {
      return (1.0F / 1.0F);
      float f1 = m / k;
      float f2 = paramFloat * f1;
      f3 = 0.0F;
      int n = 0;
      if (n >= i)
        break;
      int i1 = paramArrayOfInt1[n];
      float f4 = f1 * paramArrayOfInt2[n];
      if (i1 > f4);
      for (float f5 = i1 - f4; ; f5 = f4 - i1)
      {
        if (f5 > f2)
          break label142;
        f3 += f5;
        n++;
        break;
      }
    }
    return f3 / m;
  }

  public static b a(c paramc, Map<e, ?> paramMap, boolean paramBoolean)
    throws j
  {
    com.google.e.c.b localb = paramc.c();
    List localList = a(paramBoolean, localb);
    if (localList.isEmpty())
    {
      localb = localb.g();
      localb.a();
      localList = a(paramBoolean, localb);
    }
    return new b(localb, localList);
  }

  private static List<p[]> a(boolean paramBoolean, com.google.e.c.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    int k = 0;
    p[] arrayOfp1;
    if (k < paramb.f())
    {
      arrayOfp1 = a(paramb, k, j);
      if ((arrayOfp1[0] != null) || (arrayOfp1[3] != null))
        break label144;
      if (i != 0)
        break label55;
    }
    label55: 
    do
    {
      return localArrayList;
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        p[] arrayOfp2 = (p[])localIterator.next();
        if (arrayOfp2[1] != null)
          k = (int)Math.max(k, arrayOfp2[1].b());
        if (arrayOfp2[3] != null)
          k = Math.max(k, (int)arrayOfp2[3].b());
      }
      k += 5;
      i = 0;
      j = 0;
      break;
      localArrayList.add(arrayOfp1);
    }
    while (!paramBoolean);
    label144: int m;
    if (arrayOfp1[2] != null)
      m = (int)arrayOfp1[2].a();
    for (int n = (int)arrayOfp1[2].b(); ; n = (int)arrayOfp1[4].b())
    {
      k = n;
      j = m;
      i = 1;
      break;
      m = (int)arrayOfp1[4].a();
    }
  }

  private static void a(p[] paramArrayOfp1, p[] paramArrayOfp2, int[] paramArrayOfInt)
  {
    for (int i = 0; i < paramArrayOfInt.length; i++)
      paramArrayOfp1[paramArrayOfInt[i]] = paramArrayOfp2[i];
  }

  private static int[] a(com.google.e.c.b paramb, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Arrays.fill(paramArrayOfInt2, 0, paramArrayOfInt2.length, 0);
    int i = paramArrayOfInt1.length;
    int n;
    for (int j = 0; (paramb.a(paramInt1, paramInt2)) && (paramInt1 > 0); j = n)
    {
      n = j + 1;
      if (j >= 3)
        break;
      paramInt1--;
    }
    int k = 0;
    int m = paramInt1;
    boolean bool = paramBoolean;
    if (paramInt1 < paramInt3)
    {
      if ((bool ^ paramb.a(paramInt1, paramInt2)))
        paramArrayOfInt2[k] = (1 + paramArrayOfInt2[k]);
      while (true)
      {
        paramInt1++;
        break;
        if (k == i - 1)
        {
          if (a(paramArrayOfInt2, paramArrayOfInt1, 0.8F) < 0.42F)
            return new int[] { m, paramInt1 };
          m += paramArrayOfInt2[0] + paramArrayOfInt2[1];
          System.arraycopy(paramArrayOfInt2, 2, paramArrayOfInt2, 0, i - 2);
          paramArrayOfInt2[(i - 2)] = 0;
          paramArrayOfInt2[(i - 1)] = 0;
          k--;
        }
        while (true)
        {
          paramArrayOfInt2[k] = 1;
          if (bool)
            break label204;
          bool = true;
          break;
          k++;
        }
        label204: bool = false;
      }
    }
    if ((k == i - 1) && (a(paramArrayOfInt2, paramArrayOfInt1, 0.8F) < 0.42F))
    {
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = m;
      arrayOfInt[1] = (paramInt1 - 1);
      return arrayOfInt;
    }
    return null;
  }

  private static p[] a(com.google.e.c.b paramb, int paramInt1, int paramInt2)
  {
    int i = paramb.f();
    int j = paramb.e();
    p[] arrayOfp = new p[8];
    a(arrayOfp, a(paramb, i, j, paramInt1, paramInt2, c), a);
    int k;
    if (arrayOfp[4] != null)
      k = (int)arrayOfp[4].a();
    for (int m = (int)arrayOfp[4].b(); ; m = paramInt1)
    {
      a(arrayOfp, a(paramb, i, j, m, k, d), b);
      return arrayOfp;
      k = paramInt2;
    }
  }

  private static p[] a(com.google.e.c.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    p[] arrayOfp = new p[4];
    int[] arrayOfInt1 = new int[paramArrayOfInt.length];
    int i = paramInt3;
    int k;
    int j;
    if (i < paramInt1)
    {
      int[] arrayOfInt2 = a(paramb, paramInt4, i, paramInt2, false, paramArrayOfInt, arrayOfInt1);
      if (arrayOfInt2 != null)
      {
        Object localObject3 = arrayOfInt2;
        int i4 = i;
        while (i4 > 0)
        {
          int i5 = i4 - 1;
          int[] arrayOfInt3 = a(paramb, paramInt4, i5, paramInt2, false, paramArrayOfInt, arrayOfInt1);
          if (arrayOfInt3 != null)
          {
            localObject3 = arrayOfInt3;
            i4 = i5;
          }
          else
          {
            i4 = i5 + 1;
          }
        }
        arrayOfp[0] = new p(localObject3[0], i4);
        arrayOfp[1] = new p(localObject3[1], i4);
        k = 1;
        j = i4;
      }
    }
    while (true)
    {
      int m = j + 1;
      Object localObject1;
      int i1;
      int i2;
      label192: Object localObject2;
      int i3;
      if (k != 0)
      {
        localObject1 = new int[2];
        localObject1[0] = ((int)arrayOfp[0].a());
        localObject1[1] = ((int)arrayOfp[1].a());
        i1 = 0;
        i2 = m;
        if (i2 < paramInt1)
        {
          localObject2 = a(paramb, localObject1[0], i2, paramInt2, false, paramArrayOfInt, arrayOfInt1);
          if ((localObject2 != null) && (Math.abs(localObject1[0] - localObject2[0]) < 5) && (Math.abs(localObject1[1] - localObject2[1]) < 5))
            i3 = 0;
        }
      }
      while (true)
      {
        i2++;
        localObject1 = localObject2;
        i1 = i3;
        break label192;
        i += 5;
        break;
        if (i1 > 25)
        {
          m = i2 - (i1 + 1);
          arrayOfp[2] = new p(localObject1[0], m);
          arrayOfp[3] = new p(localObject1[1], m);
          if (m - j >= 10)
            break label376;
          for (int n = 0; n < arrayOfp.length; n++)
            arrayOfp[n] = null;
        }
        i3 = i1 + 1;
        localObject2 = localObject1;
      }
      label376: return arrayOfp;
      j = i;
      k = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g.b.a
 * JD-Core Version:    0.6.2
 */