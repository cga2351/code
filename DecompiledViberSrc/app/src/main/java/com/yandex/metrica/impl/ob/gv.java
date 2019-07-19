package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.aw.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class gv
  implements gr<ku.a, kr.a>
{
  private static final Map<Integer, aw.a> a = Collections.unmodifiableMap(new HashMap()
  {
  });
  private static final Map<aw.a, Integer> b = Collections.unmodifiableMap(new HashMap()
  {
  });

  private static or<String, String> a(kr.a.a.a[] paramArrayOfa)
  {
    or localor = new or();
    int i = paramArrayOfa.length;
    for (int j = 0; j < i; j++)
    {
      kr.a.a.a locala = paramArrayOfa[j];
      localor.a(locala.b, locala.c);
    }
    return localor;
  }

  private static List<aw.a> a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      localArrayList.add(a.get(Integer.valueOf(k)));
    }
    return localArrayList;
  }

  private static List<ku.a.a> b(kr.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    for (kr.a.a locala : parama.b)
      localArrayList.add(new ku.a.a(locala.b, locala.c, locala.d, a(locala.e), locala.f, a(locala.g)));
    return localArrayList;
  }

  public kr.a a(ku.a parama)
  {
    kr.a locala = new kr.a();
    Set localSet = parama.a();
    locala.c = ((String[])localSet.toArray(new String[localSet.size()]));
    List localList1 = parama.b();
    kr.a.a[] arrayOfa = new kr.a.a[localList1.size()];
    for (int i = 0; i < localList1.size(); i++)
    {
      ku.a.a locala1 = (ku.a.a)localList1.get(i);
      kr.a.a locala2 = new kr.a.a();
      locala2.b = locala1.a;
      locala2.c = locala1.b;
      kr.a.a.a[] arrayOfa1 = new kr.a.a.a[locala1.d.a()];
      Iterator localIterator1 = locala1.d.b().iterator();
      int m;
      for (int j = 0; localIterator1.hasNext(); j = m)
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        Iterator localIterator2 = ((Collection)localEntry.getValue()).iterator();
        for (m = j; localIterator2.hasNext(); m++)
        {
          String str = (String)localIterator2.next();
          kr.a.a.a locala3 = new kr.a.a.a();
          locala3.b = ((String)localEntry.getKey());
          locala3.c = str;
          arrayOfa1[m] = locala3;
        }
      }
      locala2.e = arrayOfa1;
      locala2.d = locala1.c;
      locala2.f = locala1.e;
      List localList2 = locala1.f;
      int[] arrayOfInt = new int[localList2.size()];
      for (int k = 0; k < localList2.size(); k++)
        arrayOfInt[k] = ((Integer)b.get(localList2.get(k))).intValue();
      locala2.g = arrayOfInt;
      arrayOfa[i] = locala2;
    }
    locala.b = arrayOfa;
    return locala;
  }

  public ku.a a(kr.a parama)
  {
    return new ku.a(b(parama), Arrays.asList(parama.c));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.gv
 * JD-Core Version:    0.6.2
 */