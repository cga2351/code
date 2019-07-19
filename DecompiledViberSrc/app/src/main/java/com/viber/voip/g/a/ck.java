package com.viber.voip.g.a;

import com.viber.voip.messages.controller.y;
import dagger.a.d;
import dagger.a.h;

public final class ck
  implements d<y>
{
  private static final ck a = new ck();

  public static ck b()
  {
    return a;
  }

  public static y c()
  {
    return (y)h.a(cj.a(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public y a()
  {
    return (y)h.a(cj.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ck
 * JD-Core Version:    0.6.2
 */