package com.my.target;

import android.content.Context;
import android.util.LruCache;
import com.my.target.b.c.b.a;
import com.my.target.common.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class bt extends do.a
{
  public static bt a()
  {
    return new bt();
  }

  protected final Map<String, String> a(z paramz, Context paramContext)
  {
    Map localMap1 = super.a(paramz, paramContext);
    if ((c.b()) && (!c.a()))
      return localMap1;
    Map localMap2 = a.b().snapshot();
    if ((localMap2 != null) && (localMap2.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = localMap2.keySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (i != 0)
          localStringBuilder.append(",");
        while (true)
        {
          localStringBuilder.append(str2);
          break;
          i = 1;
        }
      }
      String str1 = localStringBuilder.toString();
      localMap1.put("exb", str1);
      dp.a("Exclude list: " + str1);
    }
    return localMap1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bt
 * JD-Core Version:    0.6.2
 */