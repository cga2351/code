package com.google.e.g;

import com.google.e.d;
import com.google.e.g;
import com.google.e.l;
import com.google.e.n;
import com.google.e.o;
import com.google.e.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  implements l
{
  private static int a(p paramp1, p paramp2)
  {
    if ((paramp1 == null) || (paramp2 == null))
      return 0;
    return (int)Math.abs(paramp1.a() - paramp2.a());
  }

  private static int a(p[] paramArrayOfp)
  {
    return Math.max(Math.max(a(paramArrayOfp[0], paramArrayOfp[4]), 17 * a(paramArrayOfp[6], paramArrayOfp[2]) / 18), Math.max(a(paramArrayOfp[1], paramArrayOfp[5]), 17 * a(paramArrayOfp[7], paramArrayOfp[3]) / 18));
  }

  private static n[] a(com.google.e.c paramc, Map<com.google.e.e, ?> paramMap, boolean paramBoolean)
    throws com.google.e.j, g, d
  {
    ArrayList localArrayList = new ArrayList();
    com.google.e.g.b.b localb = com.google.e.g.b.a.a(paramc, paramMap, paramBoolean);
    Iterator localIterator = localb.b().iterator();
    while (localIterator.hasNext())
    {
      p[] arrayOfp = (p[])localIterator.next();
      com.google.e.c.e locale = com.google.e.g.a.j.a(localb.a(), arrayOfp[4], arrayOfp[5], arrayOfp[6], arrayOfp[7], b(arrayOfp), a(arrayOfp));
      n localn = new n(locale.b(), locale.a(), arrayOfp, com.google.e.a.k);
      localn.a(o.d, locale.d());
      c localc = (c)locale.e();
      if (localc != null)
        localn.a(o.i, localc);
      localArrayList.add(localn);
    }
    return (n[])localArrayList.toArray(new n[localArrayList.size()]);
  }

  private static int b(p paramp1, p paramp2)
  {
    if ((paramp1 == null) || (paramp2 == null))
      return 2147483647;
    return (int)Math.abs(paramp1.a() - paramp2.a());
  }

  private static int b(p[] paramArrayOfp)
  {
    return Math.min(Math.min(b(paramArrayOfp[0], paramArrayOfp[4]), 17 * b(paramArrayOfp[6], paramArrayOfp[2]) / 18), Math.min(b(paramArrayOfp[1], paramArrayOfp[5]), 17 * b(paramArrayOfp[7], paramArrayOfp[3]) / 18));
  }

  public n a(com.google.e.c paramc, Map<com.google.e.e, ?> paramMap)
    throws com.google.e.j, g, d
  {
    n[] arrayOfn = a(paramc, paramMap, false);
    if ((arrayOfn == null) || (arrayOfn.length == 0) || (arrayOfn[0] == null))
      throw com.google.e.j.a();
    return arrayOfn[0];
  }

  public void a()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g.b
 * JD-Core Version:    0.6.2
 */