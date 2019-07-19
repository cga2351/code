package com.viber.voip.market;

import com.viber.common.b.b;
import com.viber.voip.settings.d.ah;
import java.util.HashSet;
import java.util.Set;

public class r
{
  private static Set<String> a = null;

  public static Set<String> a()
  {
    if (a == null)
      a = b();
    return a;
  }

  private static Set<String> b()
  {
    HashSet localHashSet = new HashSet();
    if (c())
      localHashSet.add("vo_googleplay_subscription");
    localHashSet.add("community");
    localHashSet.add("video_ad");
    return localHashSet;
  }

  private static boolean c()
  {
    return d.ah.e.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.r
 * JD-Core Version:    0.6.2
 */