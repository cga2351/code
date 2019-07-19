package com.viber.voip.engagement.d;

import com.viber.voip.model.j;
import com.viber.voip.util.da;
import java.util.Iterator;

class c extends l
{
  public void a(k paramk)
  {
    Iterator localIterator = paramk.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      boolean bool = localm.r();
      int i = 0;
      if (bool)
        i = 2;
      if (!da.a(localm.n().d()))
        i++;
      if (i != 0)
        paramk.a(localm.getId(), i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d.c
 * JD-Core Version:    0.6.2
 */