package com.viber.voip.analytics.story.i;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.n;

class a
{
  static ArrayMap<f, g> a(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap(2);
    localArrayMap.put(n.a("First More Screen View", paramString), g.b);
    localArrayMap.put(n.a("Last More Screen View", paramString), g.c);
    return localArrayMap;
  }

  static ArrayMap<f, g> a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayMap localArrayMap = new ArrayMap(3);
    localArrayMap.put(n.a("Has Name?", Boolean.valueOf(paramBoolean1)), g.c);
    localArrayMap.put(n.a("Has Birth Date?", Boolean.valueOf(paramBoolean2)), g.c);
    localArrayMap.put(n.a("Has Photo?", Boolean.valueOf(paramBoolean3)), g.c);
    return localArrayMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.i.a
 * JD-Core Version:    0.6.2
 */