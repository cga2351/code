package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class pw
  implements px<List<pv>>
{
  public pv a(List<pv> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      pv localpv = (pv)localIterator.next();
      if (localpv.a())
        break label87;
      localLinkedList.add(localpv.b());
    }
    label87: for (int j = 0; ; j = i)
    {
      i = j;
      break;
      if (i != 0)
        return pv.a(this);
      return pv.a(this, TextUtils.join(", ", localLinkedList));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.pw
 * JD-Core Version:    0.6.2
 */