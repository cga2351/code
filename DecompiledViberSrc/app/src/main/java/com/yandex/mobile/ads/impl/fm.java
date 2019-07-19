package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class fm
{
  public static String a(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1;
    if (paramList != null)
    {
      localObject1 = "";
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (TextUtils.isEmpty(str))
          break label78;
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(str);
      }
    }
    label78: for (Object localObject2 = "\n"; ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      return localStringBuilder.toString();
    }
  }

  public static <T> Collection<T> a(Collection<T> paramCollection)
  {
    if (paramCollection == null)
      paramCollection = Collections.emptyList();
    return paramCollection;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fm
 * JD-Core Version:    0.6.2
 */