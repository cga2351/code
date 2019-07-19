package com.viber.voip.engagement.d;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class h
{
  private static final Logger a = ViberEnv.getLogger();

  private List<m> a(Iterator<m> paramIterator)
  {
    ArrayList localArrayList = new ArrayList(5);
    while ((paramIterator.hasNext()) && (localArrayList.size() < 5))
    {
      m localm = (m)paramIterator.next();
      if (localm.a() > 0)
        localArrayList.add(localm);
    }
    return localArrayList;
  }

  public List<a> a(k paramk)
  {
    List localList = a(paramk.iterator());
    if (!localList.isEmpty())
      return new ArrayList(localList);
    return Collections.emptyList();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d.h
 * JD-Core Version:    0.6.2
 */