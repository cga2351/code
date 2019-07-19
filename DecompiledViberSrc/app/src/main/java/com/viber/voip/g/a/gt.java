package com.viber.voip.g.a;

import com.viber.voip.ui.j.av;
import dagger.a.d;
import dagger.a.h;

public final class gt
  implements d<av>
{
  private static final gt a = new gt();

  public static gt b()
  {
    return a;
  }

  public av a()
  {
    return (av)h.a(go.c(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gt
 * JD-Core Version:    0.6.2
 */