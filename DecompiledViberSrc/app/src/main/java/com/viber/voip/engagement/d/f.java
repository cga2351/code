package com.viber.voip.engagement.d;

import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import com.viber.voip.model.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class f
  implements e
{
  private static final Logger a = ViberEnv.getLogger();
  private final Member b;
  private final com.viber.voip.contacts.c.d.m c;

  public f(Member paramMember, com.viber.voip.contacts.c.d.m paramm)
  {
    this.b = paramMember;
    this.c = paramm;
  }

  private List<m> a(List<m> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    ArrayMap localArrayMap = new ArrayMap(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      m localm1 = (m)localIterator.next();
      j localj = localm1.n();
      if (localj != null)
        if (localArrayMap.containsKey(localj.a()))
        {
          m localm2 = (m)localArrayMap.get(localj.a());
          if (localm1.getId() > localm2.getId())
          {
            localLinkedList.add(localm2);
            localArrayMap.put(localj.a(), localm1);
          }
          else
          {
            localLinkedList.add(localm1);
          }
        }
        else if (this.b.getId().equals(localj.a()))
        {
          localLinkedList.add(localm1);
        }
        else
        {
          localArrayMap.put(localj.a(), localm1);
        }
    }
    if (!localLinkedList.isEmpty())
    {
      a(localArrayMap, localLinkedList);
      paramList.removeAll(localLinkedList);
    }
    return paramList;
  }

  private void a(ArrayMap<String, m> paramArrayMap, List<m> paramList)
  {
  }

  public k a()
  {
    return k.a(a(this.c.c()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d.f
 * JD-Core Version:    0.6.2
 */