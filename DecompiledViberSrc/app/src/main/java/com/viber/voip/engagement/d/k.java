package com.viber.voip.engagement.d;

import android.support.v4.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class k
  implements Iterable<m>
{
  private static final Comparator<m> a = new Comparator()
  {
    public int a(m paramAnonymousm1, m paramAnonymousm2)
    {
      if (paramAnonymousm1.b() == paramAnonymousm2.b())
        return paramAnonymousm2.a() - paramAnonymousm1.a();
      if (paramAnonymousm1.b())
        return -1;
      return 1;
    }
  };
  private final LongSparseArray<m> b;

  private k(LongSparseArray<m> paramLongSparseArray)
  {
    this.b = paramLongSparseArray;
  }

  public static k a(List<m> paramList)
  {
    LongSparseArray localLongSparseArray = new LongSparseArray(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      localLongSparseArray.put(localm.getId(), localm);
    }
    return new k(localLongSparseArray);
  }

  public void a(long paramLong, int paramInt)
  {
    m localm = (m)this.b.get(paramLong);
    if (localm != null)
      localm.a(paramInt);
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    m localm = (m)this.b.get(paramLong);
    if (localm != null)
      localm.a(paramBoolean);
  }

  public Iterator<m> iterator()
  {
    ArrayList localArrayList = new ArrayList(this.b.size());
    int i = 0;
    int j = this.b.size();
    while (i < j)
    {
      localArrayList.add(this.b.get(this.b.keyAt(i)));
      i++;
    }
    Collections.sort(localArrayList, a);
    return localArrayList.iterator();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d.k
 * JD-Core Version:    0.6.2
 */