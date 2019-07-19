package com.viber.voip.shareviber.invitescreen.b;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class d
{
  private static final Logger a = ViberEnv.getLogger();

  private List<i> a(Iterator<i> paramIterator)
  {
    ArrayList localArrayList = new ArrayList(10);
    while ((paramIterator.hasNext()) && (localArrayList.size() < 10))
    {
      i locali = (i)paramIterator.next();
      if (locali.a() > 0)
        localArrayList.add(locali);
    }
    return localArrayList;
  }

  public List<a> a(h paramh)
  {
    List localList = a(paramh.iterator());
    if (!localList.isEmpty())
      return new ArrayList(localList);
    return Collections.emptyList();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.d
 * JD-Core Version:    0.6.2
 */