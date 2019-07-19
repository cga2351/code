package com.viber.voip.g.a;

import com.viber.voip.messages.controller.manager.ak;
import dagger.a.d;
import dagger.a.h;

public final class er
  implements d<ak>
{
  private static final er a = new er();

  public static er b()
  {
    return a;
  }

  public ak a()
  {
    return (ak)h.a(eq.b(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.er
 * JD-Core Version:    0.6.2
 */