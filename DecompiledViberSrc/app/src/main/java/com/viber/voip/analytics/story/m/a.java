package com.viber.voip.analytics.story.m;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.n;

class a
{
  static ArrayMap<f, g> a(String paramString)
  {
    return n.a("First Viber Out Opened", "Last Viber Out Opened", "# of Viber Out Opens", paramString);
  }

  static ArrayMap<f, g> a(String paramString1, String paramString2)
  {
    ArrayMap localArrayMap = new ArrayMap(4);
    n.a(localArrayMap, "First VO Search", "Last VO Search", "# of VO Searches", paramString1);
    n.a(localArrayMap, "List of Viber Out Search Terms", new String[] { paramString2 });
    return localArrayMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.m.a
 * JD-Core Version:    0.6.2
 */