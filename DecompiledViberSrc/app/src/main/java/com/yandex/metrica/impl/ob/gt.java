package com.yandex.metrica.impl.ob;

import java.util.ArrayList;
import java.util.List;

public class gt
  implements gs<iy, kt.a.d>
{
  public List<iy> a(kt.a.d[] paramArrayOfd)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfd.length);
    for (int i = 0; i < paramArrayOfd.length; i++)
    {
      kt.a.d locald = paramArrayOfd[i];
      localArrayList.add(new iy(locald.b, locald.c));
    }
    return localArrayList;
  }

  public kt.a.d[] a(List<iy> paramList)
  {
    kt.a.d[] arrayOfd = new kt.a.d[paramList.size()];
    for (int i = 0; i < paramList.size(); i++)
    {
      iy localiy = (iy)paramList.get(i);
      kt.a.d locald = new kt.a.d();
      locald.b = localiy.a;
      locald.c = localiy.b;
      arrayOfd[i] = locald;
    }
    return arrayOfd;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.gt
 * JD-Core Version:    0.6.2
 */