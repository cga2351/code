package com.viber.voip.g.a;

import com.viber.voip.analytics.g;
import dagger.a.d;
import dagger.a.h;

public final class s
  implements d<g>
{
  private static final s a = new s();

  public static s b()
  {
    return a;
  }

  public static g c()
  {
    return (g)h.a(r.a(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public g a()
  {
    return (g)h.a(r.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.s
 * JD-Core Version:    0.6.2
 */