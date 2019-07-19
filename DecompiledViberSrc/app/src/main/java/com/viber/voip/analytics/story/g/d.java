package com.viber.voip.analytics.story.g;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.n;

class d
{
  static ArrayMap<f, g> a(long paramLong)
  {
    return n.a("Total Duration Spent in News", paramLong);
  }

  private static ArrayMap<f, g> a(ArrayMap<f, g> paramArrayMap, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      return paramArrayMap;
    n.a(paramArrayMap, "Accounts Connected", new String[] { paramString });
    return paramArrayMap;
  }

  static ArrayMap<f, g> a(String paramString)
  {
    return n.a("First Edited Group", "Last Edited Group", "# of Edited Group", paramString);
  }

  static ArrayMap<f, g> a(String paramString, double paramDouble)
  {
    return n.a("First Invited Friend", "Last Invited Friend", "# of Invited Friends", paramString, paramDouble);
  }

  static ArrayMap<f, g> a(String paramString1, String paramString2)
  {
    ArrayMap localArrayMap = new ArrayMap(2);
    n.a(localArrayMap, "Source Languages", new String[] { paramString1 });
    n.a(localArrayMap, "Target Languages", new String[] { paramString2 });
    return localArrayMap;
  }

  static ArrayMap<f, g> a(String paramString, boolean paramBoolean)
  {
    ArrayMap localArrayMap = new ArrayMap(1);
    if (paramBoolean);
    for (String str = "Viber Language - Secondary"; ; str = "Viber Language - Primary")
    {
      localArrayMap.put(n.a(str, paramString), g.c);
      return localArrayMap;
    }
  }

  static ArrayMap<f, g> a(boolean paramBoolean)
  {
    ArrayMap localArrayMap = new ArrayMap(1);
    if (paramBoolean);
    for (String str = "Yes"; ; str = "No")
    {
      localArrayMap.put(n.a("Deactivated Account?", str), g.c);
      return localArrayMap;
    }
  }

  static ArrayMap<f, g> b(String paramString)
  {
    return n.a("First Created Community", "Last Created Community", "# of Communities Created", paramString);
  }

  static ArrayMap<f, g> b(boolean paramBoolean)
  {
    ArrayMap localArrayMap = new ArrayMap(1);
    localArrayMap.put(n.a("Photo Set?", Boolean.valueOf(paramBoolean)), g.c);
    return localArrayMap;
  }

  static ArrayMap<f, g> c(String paramString)
  {
    return n.a("First Changed Phone Number", "Last Changed Phone Number", "# of Changed Phone Numbers", paramString);
  }

  static ArrayMap<f, g> c(boolean paramBoolean)
  {
    ArrayMap localArrayMap = new ArrayMap(2);
    localArrayMap.put(n.a("Facebook Connected?", Boolean.valueOf(paramBoolean)), g.c);
    a(localArrayMap, "Facebook", paramBoolean);
    return localArrayMap;
  }

  static ArrayMap<f, g> d(String paramString)
  {
    return n.a("First Banned User", "Last Banned User", "# of Banned Users", paramString);
  }

  static ArrayMap<f, g> d(boolean paramBoolean)
  {
    ArrayMap localArrayMap = new ArrayMap(2);
    localArrayMap.put(n.a("VK Connected?", Boolean.valueOf(paramBoolean)), g.c);
    a(localArrayMap, "VK", paramBoolean);
    return localArrayMap;
  }

  static ArrayMap<f, g> e(String paramString)
  {
    return n.a("First Unbanned User", "Last Unbanned User", "# of Unbanned Users", paramString);
  }

  static ArrayMap<f, g> e(boolean paramBoolean)
  {
    ArrayMap localArrayMap = new ArrayMap(2);
    localArrayMap.put(n.a("Rakuten Connected?", Boolean.valueOf(paramBoolean)), g.c);
    a(localArrayMap, "Rakuten", paramBoolean);
    return localArrayMap;
  }

  static ArrayMap<f, g> f(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap(2);
    localArrayMap.put(n.a("First Shared Screenshot", paramString), g.b);
    localArrayMap.put(n.a("Last Shared Screenshot", paramString), g.c);
    return localArrayMap;
  }

  static ArrayMap<f, g> g(String paramString)
  {
    return n.a("First Marked Chat", "Last Marked Chat", "# of Times Marked Chat", paramString);
  }

  static ArrayMap<f, g> h(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap(1);
    localArrayMap.put(n.a("Mobile Viber Theme", paramString), g.c);
    return localArrayMap;
  }

  static ArrayMap<f, g> i(String paramString)
  {
    return n.a("First Opened News", "Last Opened News", "# of Times Opened News", paramString);
  }

  static ArrayMap<f, g> j(String paramString)
  {
    return n.a("First Shared Article", "Last Shared Article", "# of Times Shared Article", paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.g.d
 * JD-Core Version:    0.6.2
 */