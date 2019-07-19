package com.viber.voip.analytics.story.b;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.n;

class a
{
  static ArrayMap<f, g> a(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Free Ended Calls", 1.0D);
  }

  static ArrayMap<f, g> a(ArrayMap<f, g> paramArrayMap, long paramLong)
  {
    return n.a(paramArrayMap, "Total Call Duration", paramLong);
  }

  static ArrayMap<f, g> a(ArrayMap<f, g> paramArrayMap, String paramString)
  {
    return n.a(paramArrayMap, "Call Methods Used", new String[] { paramString });
  }

  static ArrayMap<f, g> a(String paramString)
  {
    return n.a("First Ended Call", "Last Ended Call", "# of Ended Calls", paramString);
  }

  static ArrayMap<f, g> a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    ArrayMap localArrayMap = n.a("First Started Call", "Last Started Call", "# of Started Calls", paramString1);
    if (paramBoolean1)
      n.a(localArrayMap, "# of Viber Out Calls Started", 1.0D);
    if (paramBoolean2)
      n.a(localArrayMap, "# of Free Started Calls", 1.0D);
    if (paramBoolean3)
      n.a(localArrayMap, "# of Group Started Calls", 1.0D);
    if (!"".equals(paramString2))
      n.a(localArrayMap, "Call Methods Used", new String[] { paramString2 });
    return localArrayMap;
  }

  static ArrayMap<f, g> b(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Free Acted On Calls", 1.0D);
  }

  static ArrayMap<f, g> b(ArrayMap<f, g> paramArrayMap, long paramLong)
  {
    return n.a(paramArrayMap, "Total Call Video Duration", paramLong);
  }

  static ArrayMap<f, g> b(ArrayMap<f, g> paramArrayMap, String paramString)
  {
    return n.a(paramArrayMap, "Action Types Selected", new String[] { paramString });
  }

  static ArrayMap<f, g> b(String paramString)
  {
    return n.a("First Acted On Call", "Last Acted On Call", "# of Acted On Calls", paramString);
  }

  static ArrayMap<f, g> c(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Calls Answered with Video", 1.0D);
  }

  static ArrayMap<f, g> d(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Group Acted On Calls", 1.0D);
  }

  static ArrayMap<f, g> e(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Calls Answered", 1.0D);
  }

  static ArrayMap<f, g> f(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Calls Ignored", 1.0D);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.b.a
 * JD-Core Version:    0.6.2
 */