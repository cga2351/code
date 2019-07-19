package com.google.firebase.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class m
{
  private static Set<a> a(Set<a> paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.c())
        localHashSet.add(locala);
    }
    return localHashSet;
  }

  static void a(List<b<?>> paramList)
  {
    Set localSet1 = b(paramList);
    Set localSet2 = a(localSet1);
    int j;
    for (int i = 0; !localSet2.isEmpty(); i = j)
    {
      a locala2 = (a)localSet2.iterator().next();
      localSet2.remove(locala2);
      j = i + 1;
      Iterator localIterator2 = locala2.a().iterator();
      while (localIterator2.hasNext())
      {
        a locala3 = (a)localIterator2.next();
        locala3.c(locala2);
        if (locala3.c())
          localSet2.add(locala3);
      }
    }
    if (i == paramList.size())
      return;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localSet1.iterator();
    while (localIterator1.hasNext())
    {
      a locala1 = (a)localIterator1.next();
      if ((!locala1.c()) && (!locala1.d()))
        localArrayList.add(locala1.b());
    }
    throw new o(localArrayList);
  }

  private static Set<a> b(List<b<?>> paramList)
  {
    HashMap localHashMap = new HashMap(paramList.size());
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      b localb = (b)localIterator1.next();
      a locala3 = new a(localb);
      Iterator localIterator7 = localb.a().iterator();
      while (localIterator7.hasNext())
      {
        Class localClass = (Class)localIterator7.next();
        if (!localb.g());
        Set localSet2;
        for (boolean bool = true; ; bool = false)
        {
          b localb1 = new b(localClass, bool, null);
          if (!localHashMap.containsKey(localb1))
            localHashMap.put(localb1, new HashSet());
          localSet2 = (Set)localHashMap.get(localb1);
          if ((localSet2.isEmpty()) || (b.a(localb1)))
            break;
          throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[] { localClass }));
        }
        localSet2.add(locala3);
      }
    }
    Iterator localIterator2 = localHashMap.values().iterator();
    while (localIterator2.hasNext())
    {
      Iterator localIterator4 = ((Set)localIterator2.next()).iterator();
      label246: if (localIterator4.hasNext())
      {
        a locala1 = (a)localIterator4.next();
        Iterator localIterator5 = locala1.b().b().iterator();
        while (localIterator5.hasNext())
        {
          n localn = (n)localIterator5.next();
          if (!localn.d())
            break label246;
          Set localSet1 = (Set)localHashMap.get(new b(localn.a(), localn.c(), null));
          if (localSet1 == null)
            break label246;
          Iterator localIterator6 = localSet1.iterator();
          while (localIterator6.hasNext())
          {
            a locala2 = (a)localIterator6.next();
            locala1.a(locala2);
            locala2.b(locala1);
          }
        }
      }
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator3 = localHashMap.values().iterator();
    while (localIterator3.hasNext())
      localHashSet.addAll((Set)localIterator3.next());
    return localHashSet;
  }

  private static class a
  {
    private final b<?> a;
    private final Set<a> b = new HashSet();
    private final Set<a> c = new HashSet();

    a(b<?> paramb)
    {
      this.a = paramb;
    }

    Set<a> a()
    {
      return this.b;
    }

    void a(a parama)
    {
      this.b.add(parama);
    }

    b<?> b()
    {
      return this.a;
    }

    void b(a parama)
    {
      this.c.add(parama);
    }

    void c(a parama)
    {
      this.c.remove(parama);
    }

    boolean c()
    {
      return this.c.isEmpty();
    }

    boolean d()
    {
      return this.b.isEmpty();
    }
  }

  private static class b
  {
    private final Class<?> a;
    private final boolean b;

    private b(Class<?> paramClass, boolean paramBoolean)
    {
      this.a = paramClass;
      this.b = paramBoolean;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof b;
      boolean bool2 = false;
      if (bool1)
      {
        b localb = (b)paramObject;
        boolean bool3 = localb.a.equals(this.a);
        bool2 = false;
        if (bool3)
        {
          boolean bool4 = localb.b;
          boolean bool5 = this.b;
          bool2 = false;
          if (bool4 == bool5)
            bool2 = true;
        }
      }
      return bool2;
    }

    public int hashCode()
    {
      return 1000003 * (0xF4243 ^ this.a.hashCode()) ^ Boolean.valueOf(this.b).hashCode();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.components.m
 * JD-Core Version:    0.6.2
 */