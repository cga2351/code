package com.viber.voip.vln.a;

import android.support.v4.util.ArrayMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.viber.voip.analytics.story.b.a;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.j;
import com.viber.voip.analytics.story.k;
import com.viber.voip.analytics.story.k.e.a;
import com.viber.voip.analytics.story.n;
import com.viber.voip.util.da;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class e
{
  static ArrayMap<f, com.viber.voip.analytics.e.g> a(ReadableArray paramReadableArray, com.viber.voip.analytics.e.g paramg)
  {
    int i = paramReadableArray.size();
    ArrayMap localArrayMap = new ArrayMap(i);
    for (int j = 0; j < i; j++)
      localArrayMap.put(n.a(paramReadableArray.getString(j), ""), paramg);
    return localArrayMap;
  }

  static ArrayMap<f, com.viber.voip.analytics.e.g> a(ReadableMap paramReadableMap, com.viber.voip.analytics.e.g paramg)
  {
    HashMap localHashMap = paramReadableMap.toHashMap();
    ArrayMap localArrayMap = new ArrayMap(localHashMap.size());
    Iterator localIterator = localHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayMap.put(n.a((String)localEntry.getKey(), localEntry.getValue()), paramg);
    }
    return localArrayMap;
  }

  static com.viber.voip.analytics.story.e a(String paramString, ReadableMap paramReadableMap1, ReadableMap paramReadableMap2, Class paramClass)
  {
    b.a locala = com.viber.voip.analytics.story.b.a(new String[0]);
    com.viber.voip.analytics.story.e locale = new com.viber.voip.analytics.story.e(paramString);
    if (paramReadableMap1 != null)
    {
      Iterator localIterator = paramReadableMap1.toHashMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ((String)localEntry.getKey());
        locala.a(arrayOfString);
        locale.a((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    if (paramReadableMap2 != null)
    {
      com.viber.voip.analytics.story.k.a locala1 = a(paramString, paramReadableMap2);
      if (locala1 != null)
        locale.a(locala1);
    }
    return locale.a(paramClass, locala.a());
  }

  static com.viber.voip.analytics.story.e a(String paramString, ReadableMap paramReadableMap, Class paramClass)
  {
    return a(paramString, paramReadableMap, null, paramClass);
  }

  static j a(String paramString1, String paramString2)
  {
    String str = k.a(paramString1 + "_all_values", paramString1, paramString2);
    if (!da.a(str))
      return com.viber.voip.analytics.story.g.a(new com.viber.voip.analytics.story.k.b(paramString2, paramString1, ""), paramString1, str.split(",", -1), new Class[] { com.viber.voip.analytics.b.a.class });
    return null;
  }

  private static com.viber.voip.analytics.story.k.a a(String paramString, ReadableMap paramReadableMap)
  {
    String str;
    int i;
    if (paramReadableMap.hasKey("timeRule"))
    {
      str = paramReadableMap.getString("timeRule");
      i = -1;
      switch (str.hashCode())
      {
      default:
      case 2430593:
      case 840651132:
      case -391287680:
      }
    }
    while (true)
      switch (i)
      {
      default:
        return null;
        if (str.equals("ONCE"))
        {
          i = 0;
          continue;
          if (str.equals("ONCE_PER_DAY"))
          {
            i = 1;
            continue;
            if (str.equals("ONCE_AT_24_HOURS"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    return new com.viber.voip.analytics.story.k.e(e.a.a, paramString, "");
    return new com.viber.voip.analytics.story.k.e(e.a.b, paramString, "");
    return new com.viber.voip.analytics.story.k.e(e.a.c, paramString, "");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.a.e
 * JD-Core Version:    0.6.2
 */