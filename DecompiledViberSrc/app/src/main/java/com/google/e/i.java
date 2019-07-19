package com.google.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class i
  implements l
{
  private Map<e, ?> a;
  private l[] b;

  private n b(c paramc)
    throws j
  {
    if (this.b != null)
    {
      l[] arrayOfl = this.b;
      int i = arrayOfl.length;
      int j = 0;
      while (j < i)
      {
        l locall = arrayOfl[j];
        try
        {
          n localn = locall.a(paramc, this.a);
          return localn;
        }
        catch (m localm)
        {
          j++;
        }
      }
    }
    throw j.a();
  }

  public n a(c paramc)
    throws j
  {
    if (this.b == null)
      a(null);
    return b(paramc);
  }

  public n a(c paramc, Map<e, ?> paramMap)
    throws j
  {
    a(paramMap);
    return b(paramc);
  }

  public void a()
  {
    if (this.b != null)
    {
      l[] arrayOfl = this.b;
      int i = arrayOfl.length;
      for (int j = 0; j < i; j++)
        arrayOfl[j].a();
    }
  }

  public void a(Map<e, ?> paramMap)
  {
    this.a = paramMap;
    int i;
    if ((paramMap != null) && (paramMap.containsKey(e.d)))
    {
      i = 1;
      if (paramMap != null)
        break label524;
    }
    label524: for (Collection localCollection = null; ; localCollection = (Collection)paramMap.get(e.c))
    {
      ArrayList localArrayList = new ArrayList();
      if (localCollection != null)
      {
        int j;
        if ((!localCollection.contains(a.o)) && (!localCollection.contains(a.p)) && (!localCollection.contains(a.h)) && (!localCollection.contains(a.g)) && (!localCollection.contains(a.b)) && (!localCollection.contains(a.c)) && (!localCollection.contains(a.d)) && (!localCollection.contains(a.e)) && (!localCollection.contains(a.i)) && (!localCollection.contains(a.m)))
        {
          boolean bool = localCollection.contains(a.n);
          j = 0;
          if (!bool);
        }
        else
        {
          j = 1;
        }
        if ((j != 0) && (i == 0))
          localArrayList.add(new com.google.e.f.i(paramMap));
        if (localCollection.contains(a.l))
          localArrayList.add(new com.google.e.h.a());
        if (localCollection.contains(a.f))
          localArrayList.add(new com.google.e.d.a());
        if (localCollection.contains(a.a))
          localArrayList.add(new com.google.e.a.b());
        if (localCollection.contains(a.k))
          localArrayList.add(new com.google.e.g.b());
        if (localCollection.contains(a.j))
          localArrayList.add(new com.google.e.e.a());
        if ((j != 0) && (i != 0))
          localArrayList.add(new com.google.e.f.i(paramMap));
      }
      if (localArrayList.isEmpty())
      {
        if (i == 0)
          localArrayList.add(new com.google.e.f.i(paramMap));
        localArrayList.add(new com.google.e.h.a());
        localArrayList.add(new com.google.e.d.a());
        localArrayList.add(new com.google.e.a.b());
        localArrayList.add(new com.google.e.g.b());
        localArrayList.add(new com.google.e.e.a());
        if (i != 0)
          localArrayList.add(new com.google.e.f.i(paramMap));
      }
      this.b = ((l[])localArrayList.toArray(new l[localArrayList.size()]));
      return;
      i = 0;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.i
 * JD-Core Version:    0.6.2
 */