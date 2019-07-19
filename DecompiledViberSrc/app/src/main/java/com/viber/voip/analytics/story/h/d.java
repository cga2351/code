package com.viber.voip.analytics.story.h;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.b.a;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.f.a;
import com.viber.voip.analytics.story.n;

public class d
{
  static ArrayMap<f, g> a(String paramString1, boolean paramBoolean, String paramString2)
  {
    ArrayMap localArrayMap = new ArrayMap(2);
    if (paramBoolean)
      n.a(localArrayMap, "Enabled Permissions", new String[] { paramString2 });
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { paramString1 }).a();
    localArrayMap.put(new f().b(paramString1, Boolean.valueOf(paramBoolean)).b(com.viber.voip.analytics.e.b.class, locala), g.c);
    return localArrayMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.h.d
 * JD-Core Version:    0.6.2
 */