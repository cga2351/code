package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class gy
  implements gn<mb, ks.a>
{
  private static me a(ks.a.a parama)
  {
    Object localObject = new ArrayList();
    if ((parama.c != null) && (parama.c.length > 0))
    {
      ArrayList localArrayList = new ArrayList(parama.c.length);
      for (int i = 0; i < parama.c.length; i++)
        localArrayList.add(parama.c[i]);
      localObject = localArrayList;
    }
    return new me(bu.a(parama.b), (List)localObject);
  }

  public ks.a a(mb parammb)
  {
    ks.a locala = new ks.a();
    locala.b = new ks.a.a[parammb.a.size()];
    for (int i = 0; i < parammb.a.size(); i++)
    {
      ks.a.a[] arrayOfa = locala.b;
      me localme = (me)parammb.a.get(i);
      ks.a.a locala1 = new ks.a.a();
      locala1.b = localme.a;
      List localList = localme.b;
      locala1.c = new String[localList.size()];
      Iterator localIterator = localList.iterator();
      for (int j = 0; localIterator.hasNext(); j++)
      {
        String str = (String)localIterator.next();
        locala1.c[j] = str;
      }
      arrayOfa[i] = locala1;
    }
    locala.c = parammb.b;
    locala.d = parammb.c;
    locala.e = parammb.d;
    locala.f = parammb.e;
    return locala;
  }

  public mb a(ks.a parama)
  {
    ArrayList localArrayList = new ArrayList(parama.b.length);
    for (int i = 0; i < parama.b.length; i++)
      localArrayList.add(a(parama.b[i]));
    return new mb(localArrayList, parama.c, parama.d, parama.e, parama.f);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.gy
 * JD-Core Version:    0.6.2
 */