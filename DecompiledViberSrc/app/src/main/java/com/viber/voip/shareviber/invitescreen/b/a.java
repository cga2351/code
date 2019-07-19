package com.viber.voip.shareviber.invitescreen.b;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.Iterator;

class a
  implements j
{
  private static final Logger a = ViberEnv.getLogger();

  public void a(h paramh)
  {
    Iterator localIterator = paramh.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      boolean bool = locali.r();
      int i = 0;
      if (bool)
        i = 2;
      if (locali.o() != null)
        i++;
      if (i != 0)
        paramh.a(locali.c(), i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.a
 * JD-Core Version:    0.6.2
 */