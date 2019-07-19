package com.google.e.h;

import com.google.e.c.b;
import com.google.e.d;
import com.google.e.h.a.i;
import com.google.e.j;
import com.google.e.l;
import com.google.e.n;
import com.google.e.o;
import com.google.e.p;
import java.util.List;
import java.util.Map;

public class a
  implements l
{
  private static final p[] a = new p[0];
  private final com.google.e.h.a.e b = new com.google.e.h.a.e();

  private static float a(int[] paramArrayOfInt, b paramb)
    throws j
  {
    int i = paramb.f();
    int j = paramb.e();
    int k = paramArrayOfInt[0];
    int m = paramArrayOfInt[1];
    int n = 1;
    int i1 = m;
    int i2 = k;
    int i3 = 0;
    int i5;
    if ((i2 < j) && (i1 < i))
    {
      if (n == paramb.a(i2, i1))
        break label133;
      i5 = i3 + 1;
      if (i5 != 5);
    }
    else
    {
      if ((i2 != j) && (i1 != i))
        break label122;
      throw j.a();
    }
    int i6;
    label95: int i4;
    if (n == 0)
    {
      i6 = 1;
      i4 = i6;
      i3 = i5;
    }
    while (true)
    {
      i2++;
      i1++;
      n = i4;
      break;
      i6 = 0;
      break label95;
      label122: return (i2 - paramArrayOfInt[0]) / 7.0F;
      label133: i4 = n;
    }
  }

  private static b a(b paramb)
    throws j
  {
    int[] arrayOfInt1 = paramb.c();
    int[] arrayOfInt2 = paramb.d();
    if ((arrayOfInt1 == null) || (arrayOfInt2 == null))
      throw j.a();
    float f = a(arrayOfInt1, paramb);
    int i = arrayOfInt1[1];
    int j = arrayOfInt2[1];
    int k = arrayOfInt1[0];
    int m = arrayOfInt2[0];
    if ((k >= m) || (i >= j))
      throw j.a();
    if (j - i != m - k)
      m = k + (j - i);
    int n = Math.round((1 + (m - k)) / f);
    int i1 = Math.round((1 + (j - i)) / f);
    if ((n <= 0) || (i1 <= 0))
      throw j.a();
    if (i1 != n)
      throw j.a();
    int i2 = (int)(f / 2.0F);
    int i3 = i + i2;
    int i4 = k + i2;
    int i5 = i4 + (int)(f * (n - 1)) - m;
    if (i5 > 0)
      if (i5 > i2)
        throw j.a();
    for (int i6 = i4 - i5; ; i6 = i4)
    {
      int i7 = i3 + (int)(f * (i1 - 1)) - j;
      if (i7 > 0)
        if (i7 > i2)
          throw j.a();
      for (int i8 = i3 - i7; ; i8 = i3)
      {
        b localb = new b(n, i1);
        for (int i9 = 0; i9 < i1; i9++)
        {
          int i10 = i8 + (int)(f * i9);
          for (int i11 = 0; i11 < n; i11++)
            if (paramb.a(i6 + (int)(f * i11), i10))
              localb.b(i11, i9);
        }
        return localb;
      }
    }
  }

  public final n a(com.google.e.c paramc, Map<com.google.e.e, ?> paramMap)
    throws j, d, com.google.e.g
  {
    p[] arrayOfp2;
    Object localObject1;
    if ((paramMap != null) && (paramMap.containsKey(com.google.e.e.b)))
    {
      b localb = a(paramc.c());
      com.google.e.c.e locale2 = this.b.a(localb, paramMap);
      arrayOfp2 = a;
      localObject1 = locale2;
    }
    p[] arrayOfp1;
    for (Object localObject2 = arrayOfp2; ; localObject2 = arrayOfp1)
    {
      if ((((com.google.e.c.e)localObject1).e() instanceof i))
        ((i)((com.google.e.c.e)localObject1).e()).a((p[])localObject2);
      n localn = new n(((com.google.e.c.e)localObject1).b(), ((com.google.e.c.e)localObject1).a(), (p[])localObject2, com.google.e.a.l);
      List localList = ((com.google.e.c.e)localObject1).c();
      if (localList != null)
        localn.a(o.c, localList);
      String str = ((com.google.e.c.e)localObject1).d();
      if (str != null)
        localn.a(o.d, str);
      if (((com.google.e.c.e)localObject1).f())
      {
        localn.a(o.j, Integer.valueOf(((com.google.e.c.e)localObject1).h()));
        localn.a(o.k, Integer.valueOf(((com.google.e.c.e)localObject1).g()));
      }
      return localn;
      com.google.e.c.g localg = new com.google.e.h.b.c(paramc.c()).a(paramMap);
      com.google.e.c.e locale1 = this.b.a(localg.d(), paramMap);
      arrayOfp1 = localg.e();
      localObject1 = locale1;
    }
  }

  public void a()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.a
 * JD-Core Version:    0.6.2
 */