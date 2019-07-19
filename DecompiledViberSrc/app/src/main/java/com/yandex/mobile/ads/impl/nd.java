package com.yandex.mobile.ads.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class nd
{
  public static Set<lh> a(ll paramll)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramll.c().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((le)localIterator.next()).c();
      if ((localObject instanceof lh))
        localHashSet.add((lh)localObject);
      if ((localObject instanceof lk))
      {
        lh locallh = ((lk)localObject).b();
        if (locallh != null)
          localHashSet.add(locallh);
      }
    }
    return localHashSet;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.nd
 * JD-Core Version:    0.6.2
 */