package com.google.e.f;

import com.google.e.c;
import com.google.e.c.a;
import com.google.e.d;
import com.google.e.e;
import com.google.e.g;
import com.google.e.j;
import com.google.e.l;
import com.google.e.m;
import com.google.e.n;
import com.google.e.o;
import com.google.e.p;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class k
  implements l
{
  protected static float a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, float paramFloat)
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

  protected static void a(a parama, int paramInt, int[] paramArrayOfInt)
    throws j
  {
    int i = paramArrayOfInt.length;
    Arrays.fill(paramArrayOfInt, 0, i, 0);
    int j = parama.a();
    if (paramInt >= j)
      throw j.a();
    if (!parama.a(paramInt));
    int m;
    int n;
    int i4;
    for (int k = 1; ; k = 0)
    {
      m = k;
      n = 0;
      while (true)
      {
        if (paramInt >= j)
          break label162;
        if ((m ^ parama.a(paramInt)) == 0)
          break;
        paramArrayOfInt[n] = (1 + paramArrayOfInt[n]);
        i4 = m;
        paramInt++;
        m = i4;
      }
    }
    int i1 = n + 1;
    if (i1 == i);
    while (true)
    {
      if ((i1 != i) && ((i1 != i - 1) || (paramInt != j)))
      {
        throw j.a();
        paramArrayOfInt[i1] = 1;
        if (m == 0);
        for (int i2 = 1; ; i2 = 0)
        {
          int i3 = i1;
          i4 = i2;
          n = i3;
          break;
        }
      }
      return;
      label162: i1 = n;
    }
  }

  private n b(c paramc, Map<e, ?> paramMap)
    throws j
  {
    int i = paramc.a();
    int j = paramc.b();
    a locala1 = new a(i);
    int k = j >> 1;
    int m;
    int n;
    label55: int i1;
    int i2;
    label75: int i3;
    Object localObject1;
    Object localObject2;
    int i4;
    int i5;
    if ((paramMap != null) && (paramMap.containsKey(e.d)))
    {
      m = 1;
      if (m == 0)
        break label147;
      n = 8;
      i1 = Math.max(1, j >> n);
      if (m == 0)
        break label153;
      i2 = j;
      i3 = 0;
      localObject1 = locala1;
      localObject2 = paramMap;
      if (i3 < i2)
      {
        i4 = (i3 + 1) / 2;
        if ((i3 & 0x1) != 0)
          break label160;
        i5 = 1;
        label110: if (i5 == 0)
          break label166;
      }
    }
    int i6;
    while (true)
    {
      i6 = k + i4 * i1;
      if ((i6 >= 0) && (i6 < j))
        break label174;
      throw j.a();
      m = 0;
      break;
      label147: n = 5;
      break label55;
      label153: i2 = 15;
      break label75;
      label160: i5 = 0;
      break label110;
      label166: i4 = -i4;
    }
    while (true)
    {
      try
      {
        label174: a locala2 = paramc.a(i6, (a)localObject1);
        localObject1 = locala2;
        int i7 = 0;
        if (i7 < 2)
        {
          if (i7 != 1)
            break label384;
          ((a)localObject1).e();
          if ((localObject2 == null) || (!((Map)localObject2).containsKey(e.j)))
            break label384;
          localObject3 = new EnumMap(e.class);
          ((Map)localObject3).putAll((Map)localObject2);
          ((Map)localObject3).remove(e.j);
          try
          {
            n localn = a(i6, (a)localObject1, (Map)localObject3);
            if (i7 == 1)
            {
              localn.a(o.b, Integer.valueOf(180));
              p[] arrayOfp = localn.c();
              if (arrayOfp != null)
              {
                arrayOfp[0] = new p(i - arrayOfp[0].a() - 1.0F, arrayOfp[0].b());
                arrayOfp[1] = new p(i - arrayOfp[1].a() - 1.0F, arrayOfp[1].b());
              }
            }
            return localn;
          }
          catch (m localm)
          {
            i7++;
            localObject2 = localObject3;
          }
          continue;
        }
      }
      catch (j localj)
      {
        i3++;
      }
      break;
      label384: Object localObject3 = localObject2;
    }
  }

  protected static void b(a parama, int paramInt, int[] paramArrayOfInt)
    throws j
  {
    int i = paramArrayOfInt.length;
    boolean bool = parama.a(paramInt);
    while ((paramInt > 0) && (i >= 0))
    {
      paramInt--;
      if (parama.a(paramInt) != bool)
      {
        i--;
        if (!bool)
          bool = true;
        else
          bool = false;
      }
    }
    if (i >= 0)
      throw j.a();
    a(parama, paramInt + 1, paramArrayOfInt);
  }

  public abstract n a(int paramInt, a parama, Map<e, ?> paramMap)
    throws j, d, g;

  public n a(c paramc, Map<e, ?> paramMap)
    throws j, g
  {
    try
    {
      n localn2 = b(paramc, paramMap);
      return localn2;
    }
    catch (j localj)
    {
      if (paramMap == null)
        break label192;
    }
    int i;
    c localc;
    n localn1;
    Map localMap;
    if (paramMap.containsKey(e.d))
    {
      i = 1;
      if ((i == 0) || (!paramc.d()))
        break label201;
      localc = paramc.e();
      localn1 = b(localc, paramMap);
      localMap = localn1.e();
      if ((localMap == null) || (!localMap.containsKey(o.b)))
        break label203;
    }
    label192: label201: label203: for (int j = (270 + ((Integer)localMap.get(o.b)).intValue()) % 360; ; j = 270)
    {
      localn1.a(o.b, Integer.valueOf(j));
      p[] arrayOfp = localn1.c();
      if (arrayOfp != null)
      {
        int k = localc.b();
        int m = 0;
        while (true)
          if (m < arrayOfp.length)
          {
            arrayOfp[m] = new p(k - arrayOfp[m].b() - 1.0F, arrayOfp[m].a());
            m++;
            continue;
            i = 0;
            break;
          }
      }
      return localn1;
      throw localj;
    }
  }

  public void a()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.k
 * JD-Core Version:    0.6.2
 */