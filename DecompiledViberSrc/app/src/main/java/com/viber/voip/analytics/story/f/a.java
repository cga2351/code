package com.viber.voip.analytics.story.f;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.n;

class a
{
  static ArrayMap<f, g> a(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap(1);
    n.a(localArrayMap, "Activation Methods Used", new String[] { paramString });
    return localArrayMap;
  }

  static ArrayMap<f, g> a(String paramString1, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2, int paramInt, String paramString4, String paramString5)
  {
    ArrayMap localArrayMap = new ArrayMap(7);
    if (paramBoolean1)
    {
      localArrayMap.put(n.a("# of App Opens before Registration", Integer.valueOf(paramInt)), g.c);
      localArrayMap.put(n.a("# of App Opens", Integer.valueOf(1)), g.a);
    }
    localArrayMap.put(n.a("First App Open", paramString4), g.b);
    localArrayMap.put(n.a("Last App Open", paramString1), g.c);
    localArrayMap.put(n.a("Viber Device Type", paramString2), g.c);
    if (paramBoolean2)
      localArrayMap.put(n.a("Last Primary Device Used", paramString3), g.c);
    while (true)
    {
      localArrayMap.put(n.a("Mobile Viber Theme", paramString5), g.c);
      return localArrayMap;
      localArrayMap.put(n.a("Last Secondary Device Used", paramString3), g.c);
    }
  }

  static ArrayMap<f, g> a(boolean paramBoolean)
  {
    ArrayMap localArrayMap = new ArrayMap(1);
    localArrayMap.put(n.a("Facebook Connected?", Boolean.valueOf(paramBoolean)), g.c);
    return localArrayMap;
  }

  static ArrayMap<f, g> a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean2)
  {
    ArrayMap localArrayMap = new ArrayMap(10);
    localArrayMap.put(n.a("Referred?", Boolean.valueOf(paramBoolean1)), g.c);
    n.a(localArrayMap, "List of Advertising IDs", new String[] { paramString4 });
    localArrayMap.put(n.a("Platforms Used", "Android"), g.c);
    localArrayMap.put(n.a("OS Language", paramString1), g.c);
    localArrayMap.put(n.a("Registration Date", paramString2), g.c);
    localArrayMap.put(n.a("Registration Country", paramString3), g.c);
    localArrayMap.put(n.a("ADID", paramString4), g.c);
    if (paramBoolean2)
      localArrayMap.put(n.a("Last Primary Device Used", paramString2), g.c);
    while (true)
    {
      localArrayMap.put(n.a("# of Devices Used", Integer.valueOf(1)), g.a);
      return localArrayMap;
      localArrayMap.put(n.a("Last Secondary Device Used", paramString2), g.c);
    }
  }

  static ArrayMap<f, g> b(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap(2);
    localArrayMap.put(n.a("First Edited Message", paramString), g.b);
    localArrayMap.put(n.a("Last Edited Message", paramString), g.c);
    return localArrayMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.f.a
 * JD-Core Version:    0.6.2
 */