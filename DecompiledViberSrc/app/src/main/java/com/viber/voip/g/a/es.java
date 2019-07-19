package com.viber.voip.g.a;

import com.viber.voip.messages.controller.manager.al;
import dagger.a.d;
import dagger.a.h;

public final class es
  implements d<al>
{
  private static final es a = new es();

  public static es b()
  {
    return a;
  }

  public al a()
  {
    return (al)h.a(eq.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.es
 * JD-Core Version:    0.6.2
 */