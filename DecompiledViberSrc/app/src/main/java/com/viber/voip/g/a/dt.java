package com.viber.voip.g.a;

import com.viber.voip.messages.controller.bv;
import dagger.a.d;
import dagger.a.h;

public final class dt
  implements d<bv>
{
  private static final dt a = new dt();

  public static dt b()
  {
    return a;
  }

  public static bv c()
  {
    return (bv)h.a(dj.b(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public bv a()
  {
    return (bv)h.a(dj.b(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dt
 * JD-Core Version:    0.6.2
 */