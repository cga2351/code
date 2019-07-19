package com.viber.voip.analytics.story.c;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.n;

class a
{
  static ArrayMap<f, g> a(String paramString)
  {
    return n.a("First Opened Chat Extensions", "Last Opened Chat Extensions", "# Times Opened Chat Extension", paramString);
  }

  static ArrayMap<f, g> a(String paramString1, String paramString2)
  {
    ArrayMap localArrayMap = new ArrayMap(4);
    n.a(localArrayMap, "First Viewed Extension", "Last Viewed Extension", "# Times Viewed Extension", paramString1);
    n.a(localArrayMap, "Extensions Viewed", new String[] { paramString2 });
    return localArrayMap;
  }

  static ArrayMap<f, g> b(String paramString)
  {
    return n.a("First Searched Chat Extensions", "Last Searched Chat Extensions", "# Time Searched Chat Extension", paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.c.a
 * JD-Core Version:    0.6.2
 */