package com.google.e.e;

import com.google.e.c.b;
import com.google.e.d;
import com.google.e.g;
import com.google.e.j;
import com.google.e.l;
import com.google.e.n;
import com.google.e.o;
import com.google.e.p;
import java.util.Map;

public final class a
  implements l
{
  private static final p[] a = new p[0];
  private final com.google.e.e.a.c b = new com.google.e.e.a.c();

  private static b a(b paramb)
    throws j
  {
    int[] arrayOfInt = paramb.b();
    if (arrayOfInt == null)
      throw j.a();
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[2];
    int m = arrayOfInt[3];
    b localb = new b(30, 33);
    for (int n = 0; n < 33; n++)
    {
      int i1 = j + (n * m + m / 2) / 33;
      for (int i2 = 0; i2 < 30; i2++)
        if (paramb.a(i + (i2 * k + k / 2 + k * (n & 0x1) / 2) / 30, i1))
          localb.b(i2, n);
    }
    return localb;
  }

  public n a(com.google.e.c paramc, Map<com.google.e.e, ?> paramMap)
    throws j, d, g
  {
    if ((paramMap != null) && (paramMap.containsKey(com.google.e.e.b)))
    {
      b localb = a(paramc.c());
      com.google.e.c.e locale = this.b.a(localb, paramMap);
      p[] arrayOfp = a;
      n localn = new n(locale.b(), locale.a(), arrayOfp, com.google.e.a.j);
      String str = locale.d();
      if (str != null)
        localn.a(o.d, str);
      return localn;
    }
    throw j.a();
  }

  public void a()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.e.a
 * JD-Core Version:    0.6.2
 */