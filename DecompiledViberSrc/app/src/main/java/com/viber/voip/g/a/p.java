package com.viber.voip.g.a;

import com.viber.voip.banner.i;
import dagger.a.d;
import dagger.a.h;

public final class p
  implements d<i>
{
  private static final p a = new p();

  public static p b()
  {
    return a;
  }

  public static i c()
  {
    return (i)h.a(c.a(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public i a()
  {
    return (i)h.a(c.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.p
 * JD-Core Version:    0.6.2
 */