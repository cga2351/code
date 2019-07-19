package com.viber.voip.g.a;

import com.viber.voip.messages.controller.manager.ab;
import dagger.a.d;
import dagger.a.h;

public final class dv
  implements d<ab>
{
  private static final dv a = new dv();

  public static dv b()
  {
    return a;
  }

  public ab a()
  {
    return (ab)h.a(dj.d(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dv
 * JD-Core Version:    0.6.2
 */