package com.google.e.d;

import com.google.e.c;
import com.google.e.c.b;
import com.google.e.j;
import com.google.e.l;
import com.google.e.n;
import com.google.e.o;
import com.google.e.p;
import java.util.List;
import java.util.Map;

public final class a
  implements l
{
  private static final p[] a = new p[0];
  private final com.google.e.d.a.d b = new com.google.e.d.a.d();

  private static int a(int[] paramArrayOfInt, b paramb)
    throws j
  {
    int i = paramb.e();
    int j = paramArrayOfInt[0];
    int k = paramArrayOfInt[1];
    while ((j < i) && (paramb.a(j, k)))
      j++;
    if (j == i)
      throw j.a();
    int m = j - paramArrayOfInt[0];
    if (m == 0)
      throw j.a();
    return m;
  }

  private static b a(b paramb)
    throws j
  {
    int[] arrayOfInt1 = paramb.c();
    int[] arrayOfInt2 = paramb.d();
    if ((arrayOfInt1 == null) || (arrayOfInt2 == null))
      throw j.a();
    int i = a(arrayOfInt1, paramb);
    int j = arrayOfInt1[1];
    int k = arrayOfInt2[1];
    int m = arrayOfInt1[0];
    int n = (1 + (arrayOfInt2[0] - m)) / i;
    int i1 = (1 + (k - j)) / i;
    if ((n <= 0) || (i1 <= 0))
      throw j.a();
    int i2 = i / 2;
    int i3 = j + i2;
    int i4 = m + i2;
    b localb = new b(n, i1);
    for (int i5 = 0; i5 < i1; i5++)
    {
      int i6 = i3 + i5 * i;
      for (int i7 = 0; i7 < n; i7++)
        if (paramb.a(i4 + i7 * i, i6))
          localb.b(i7, i5);
    }
    return localb;
  }

  public n a(c paramc, Map<com.google.e.e, ?> paramMap)
    throws j, com.google.e.d, com.google.e.g
  {
    com.google.e.c.e locale;
    if ((paramMap != null) && (paramMap.containsKey(com.google.e.e.b)))
    {
      b localb = a(paramc.c());
      locale = this.b.a(localb);
    }
    com.google.e.c.g localg;
    for (p[] arrayOfp = a; ; arrayOfp = localg.e())
    {
      n localn = new n(locale.b(), locale.a(), arrayOfp, com.google.e.a.f);
      List localList = locale.c();
      if (localList != null)
        localn.a(o.c, localList);
      String str = locale.d();
      if (str != null)
        localn.a(o.d, str);
      return localn;
      localg = new com.google.e.d.b.a(paramc.c()).a();
      locale = this.b.a(localg.d());
    }
  }

  public void a()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.d.a
 * JD-Core Version:    0.6.2
 */