package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ny
{
  private final fb a;
  private final List<le> b;
  private final String c;

  public ny(Context paramContext, String paramString, List<le> paramList)
  {
    this.c = paramString;
    this.a = fb.a(paramContext);
    if (paramList != null);
    while (true)
    {
      this.b = paramList;
      return;
      paramList = Collections.emptyList();
    }
  }

  public final void a(List<String> paramList)
  {
    List localList = this.b;
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localArrayList1.add(((le)localIterator.next()).a());
    ArrayList localArrayList2 = new ArrayList(paramList);
    localArrayList2.removeAll(localArrayList1);
    if (!localArrayList2.isEmpty())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("block_id", this.c);
      localHashMap.put("assets", localArrayList2.toArray());
      fd localfd = new fd(fd.b.y, localHashMap);
      this.a.a(localfd);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ny
 * JD-Core Version:    0.6.2
 */