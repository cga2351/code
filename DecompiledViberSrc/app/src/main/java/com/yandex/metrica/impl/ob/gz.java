package com.yandex.metrica.impl.ob;

import java.util.Iterator;
import java.util.List;

public class gz
  implements gr<mn, kt.a.g>
{
  public kt.a.g a(mn parammn)
  {
    kt.a.g localg = new kt.a.g();
    localg.b = parammn.a;
    localg.c = parammn.b;
    List localList = parammn.c;
    int[] arrayOfInt = new int[localList.size()];
    Iterator localIterator = localList.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
      arrayOfInt[i] = ((Integer)localIterator.next()).intValue();
    localg.d = arrayOfInt;
    return localg;
  }

  public mn a(kt.a.g paramg)
  {
    return new mn(paramg.b, paramg.c, nu.a(paramg.d));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.gz
 * JD-Core Version:    0.6.2
 */