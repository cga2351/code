package com.yandex.metrica.impl.ob;

import java.util.Iterator;
import java.util.Set;

class du
  implements gn<dt, kp.a>
{
  public dt a(kp.a parama)
  {
    return new dt(parama.b, parama.c, parama.d, parama.e);
  }

  public kp.a a(dt paramdt)
  {
    kp.a locala = new kp.a();
    locala.e = new int[paramdt.c().size()];
    Iterator localIterator = paramdt.c().iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      Integer localInteger = (Integer)localIterator.next();
      locala.e[i] = localInteger.intValue();
    }
    locala.d = paramdt.d();
    locala.c = paramdt.e();
    locala.b = paramdt.b();
    return locala;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.du
 * JD-Core Version:    0.6.2
 */