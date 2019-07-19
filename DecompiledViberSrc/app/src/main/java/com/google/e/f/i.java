package com.google.e.f;

import com.google.e.l;
import com.google.e.m;
import com.google.e.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class i extends k
{
  private final k[] a;

  public i(Map<com.google.e.e, ?> paramMap)
  {
    Collection localCollection;
    if (paramMap == null)
    {
      localCollection = null;
      if ((paramMap == null) || (paramMap.get(com.google.e.e.g) == null))
        break label467;
    }
    label467: for (boolean bool = true; ; bool = false)
    {
      ArrayList localArrayList = new ArrayList();
      if (localCollection != null)
      {
        if ((localCollection.contains(com.google.e.a.h)) || (localCollection.contains(com.google.e.a.o)) || (localCollection.contains(com.google.e.a.g)) || (localCollection.contains(com.google.e.a.p)))
          localArrayList.add(new j(paramMap));
        if (localCollection.contains(com.google.e.a.c))
          localArrayList.add(new c(bool));
        if (localCollection.contains(com.google.e.a.d))
          localArrayList.add(new d());
        if (localCollection.contains(com.google.e.a.e))
          localArrayList.add(new b());
        if (localCollection.contains(com.google.e.a.i))
          localArrayList.add(new h());
        if (localCollection.contains(com.google.e.a.b))
          localArrayList.add(new a());
        if (localCollection.contains(com.google.e.a.m))
          localArrayList.add(new com.google.e.f.a.e());
        if (localCollection.contains(com.google.e.a.n))
          localArrayList.add(new com.google.e.f.a.a.d());
      }
      if (localArrayList.isEmpty())
      {
        localArrayList.add(new j(paramMap));
        localArrayList.add(new c());
        localArrayList.add(new a());
        localArrayList.add(new d());
        localArrayList.add(new b());
        localArrayList.add(new h());
        localArrayList.add(new com.google.e.f.a.e());
        localArrayList.add(new com.google.e.f.a.a.d());
      }
      this.a = ((k[])localArrayList.toArray(new k[localArrayList.size()]));
      return;
      localCollection = (Collection)paramMap.get(com.google.e.e.c);
      break;
    }
  }

  public n a(int paramInt, com.google.e.c.a parama, Map<com.google.e.e, ?> paramMap)
    throws com.google.e.j
  {
    k[] arrayOfk = this.a;
    int i = arrayOfk.length;
    int j = 0;
    while (j < i)
    {
      k localk = arrayOfk[j];
      try
      {
        n localn = localk.a(paramInt, parama, paramMap);
        return localn;
      }
      catch (m localm)
      {
        j++;
      }
    }
    throw com.google.e.j.a();
  }

  public void a()
  {
    k[] arrayOfk = this.a;
    int i = arrayOfk.length;
    for (int j = 0; j < i; j++)
      arrayOfk[j].a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.i
 * JD-Core Version:    0.6.2
 */