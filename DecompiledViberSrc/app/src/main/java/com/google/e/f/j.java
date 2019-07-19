package com.google.e.f;

import com.google.e.m;
import com.google.e.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class j extends k
{
  private final p[] a;

  public j(Map<com.google.e.e, ?> paramMap)
  {
    Collection localCollection;
    ArrayList localArrayList;
    if (paramMap == null)
    {
      localCollection = null;
      localArrayList = new ArrayList();
      if (localCollection != null)
      {
        if (!localCollection.contains(com.google.e.a.h))
          break label190;
        localArrayList.add(new e());
      }
    }
    while (true)
    {
      if (localCollection.contains(com.google.e.a.g))
        localArrayList.add(new f());
      if (localCollection.contains(com.google.e.a.p))
        localArrayList.add(new q());
      if (localArrayList.isEmpty())
      {
        localArrayList.add(new e());
        localArrayList.add(new f());
        localArrayList.add(new q());
      }
      this.a = ((p[])localArrayList.toArray(new p[localArrayList.size()]));
      return;
      localCollection = (Collection)paramMap.get(com.google.e.e.c);
      break;
      label190: if (localCollection.contains(com.google.e.a.o))
        localArrayList.add(new l());
    }
  }

  public n a(int paramInt, com.google.e.c.a parama, Map<com.google.e.e, ?> paramMap)
    throws com.google.e.j
  {
    int[] arrayOfInt = p.a(parama);
    p[] arrayOfp = this.a;
    int i = arrayOfp.length;
    int j = 0;
    while (j < i)
    {
      p localp = arrayOfp[j];
      try
      {
        n localn1 = localp.a(paramInt, parama, arrayOfInt, paramMap);
        int k;
        Collection localCollection;
        if ((localn1.d() == com.google.e.a.h) && (localn1.a().charAt(0) == '0'))
        {
          k = 1;
          if (paramMap != null)
            break label162;
          localCollection = null;
          label81: if ((localCollection != null) && (!localCollection.contains(com.google.e.a.o)))
            break label179;
        }
        label162: label179: for (int m = 1; ; m = 0)
        {
          if ((k == 0) || (m == 0))
            break label185;
          n localn2 = new n(localn1.a().substring(1), localn1.b(), localn1.c(), com.google.e.a.o);
          localn2.a(localn1.e());
          return localn2;
          k = 0;
          break;
          localCollection = (Collection)paramMap.get(com.google.e.e.c);
          break label81;
        }
        label185: return localn1;
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
    p[] arrayOfp = this.a;
    int i = arrayOfp.length;
    for (int j = 0; j < i; j++)
      arrayOfp[j].a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.j
 * JD-Core Version:    0.6.2
 */