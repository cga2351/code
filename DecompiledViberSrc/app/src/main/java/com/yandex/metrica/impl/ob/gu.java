package com.yandex.metrica.impl.ob;

import java.util.ArrayList;
import java.util.List;

public class gu
  implements gn<List<iy>, kq.a>
{
  public kq.a a(List<iy> paramList)
  {
    kq.a locala = new kq.a();
    locala.b = new kq.a.a[paramList.size()];
    for (int i = 0; i < paramList.size(); i++)
    {
      kq.a.a[] arrayOfa = locala.b;
      iy localiy = (iy)paramList.get(i);
      kq.a.a locala1 = new kq.a.a();
      locala1.b = localiy.a;
      locala1.c = localiy.b;
      arrayOfa[i] = locala1;
    }
    return locala;
  }

  public List<iy> a(kq.a parama)
  {
    ArrayList localArrayList = new ArrayList(parama.b.length);
    for (int i = 0; i < parama.b.length; i++)
    {
      kq.a.a locala = parama.b[i];
      localArrayList.add(new iy(locala.b, locala.c));
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.gu
 * JD-Core Version:    0.6.2
 */