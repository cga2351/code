package com.yandex.mobile.ads.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public final class md
{
  static boolean a(List<le> paramList)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localHashSet.add(((le)localIterator.next()).a());
    return paramList.size() > localHashSet.size();
  }

  public static boolean a(JSONObject paramJSONObject, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
      if (!paramJSONObject.has(paramArrayOfString[j]))
        return false;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.md
 * JD-Core Version:    0.6.2
 */