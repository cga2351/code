package com.viber.voip.banner;

import com.viber.voip.banner.d.b;
import com.viber.voip.banner.d.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class h
  implements g
{
  private static h a;
  private Set<g.a> b = new HashSet();

  public static h a()
  {
    if (a == null);
    try
    {
      if (a == null)
        a = new h();
      return a;
    }
    finally
    {
    }
  }

  private Set<g.a> b()
  {
    return new HashSet(this.b);
  }

  public void a(long paramLong, b paramb, c paramc)
  {
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
      ((g.a)localIterator.next()).a(paramLong, paramb, paramc);
  }

  public void a(g.a parama)
  {
    this.b.add(parama);
  }

  public void b(g.a parama)
  {
    this.b.remove(parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.h
 * JD-Core Version:    0.6.2
 */