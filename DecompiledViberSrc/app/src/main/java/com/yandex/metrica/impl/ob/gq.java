package com.yandex.metrica.impl.ob;

import java.util.ArrayList;
import java.util.List;

public class gq
  implements gs<hr, kt.a.a.a>
{
  public List<hr> a(kt.a.a.a[] paramArrayOfa)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfa.length;
    for (int j = 0; j < i; j++)
    {
      kt.a.a.a locala = paramArrayOfa[j];
      localArrayList.add(new hr(locala.b, locala.c));
    }
    return localArrayList;
  }

  public kt.a.a.a[] a(List<hr> paramList)
  {
    kt.a.a.a[] arrayOfa = new kt.a.a.a[paramList.size()];
    for (int i = 0; i < paramList.size(); i++)
    {
      hr localhr = (hr)paramList.get(i);
      kt.a.a.a locala = new kt.a.a.a();
      locala.b = localhr.a;
      locala.c = localhr.b;
      arrayOfa[i] = locala;
    }
    return arrayOfa;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.gq
 * JD-Core Version:    0.6.2
 */