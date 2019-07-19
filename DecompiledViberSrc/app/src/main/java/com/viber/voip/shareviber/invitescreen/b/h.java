package com.viber.voip.shareviber.invitescreen.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class h
  implements Iterable<i>
{
  private static final Comparator<i> a = new Comparator()
  {
    public int a(i paramAnonymousi1, i paramAnonymousi2)
    {
      return paramAnonymousi2.a() - paramAnonymousi1.a();
    }
  };
  private final Map<String, i> b;

  private h(Map<String, i> paramMap)
  {
    this.b = paramMap;
  }

  public static h a(List<i> paramList)
  {
    HashMap localHashMap = new HashMap(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      localHashMap.put(locali.c(), locali);
    }
    return new h(localHashMap);
  }

  public void a(String paramString, int paramInt)
  {
    i locali = (i)this.b.get(paramString);
    if (locali != null)
      locali.a(paramInt);
  }

  public Iterator<i> iterator()
  {
    ArrayList localArrayList = new ArrayList(this.b.values());
    Collections.sort(localArrayList, a);
    return localArrayList.iterator();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.h
 * JD-Core Version:    0.6.2
 */