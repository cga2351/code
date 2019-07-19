package com.viber.voip.engagement.d;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class i
{
  private static final Logger a = ViberEnv.getLogger();
  private final e b;
  private final h c;
  private final List<l> d;

  public i(e parame, h paramh, l[] paramArrayOfl)
  {
    this.b = parame;
    this.c = paramh;
    this.d = Arrays.asList(paramArrayOfl);
  }

  public List<a> a(Map<String, m> paramMap)
  {
    k localk = this.b.a();
    Iterator localIterator1 = this.d.iterator();
    while (localIterator1.hasNext())
      ((l)localIterator1.next()).a(localk);
    if (paramMap != null)
    {
      Iterator localIterator2 = localk.iterator();
      while (localIterator2.hasNext())
      {
        m localm = (m)localIterator2.next();
        paramMap.put(String.valueOf(localm.getId()), localm);
      }
    }
    return this.c.a(localk);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d.i
 * JD-Core Version:    0.6.2
 */