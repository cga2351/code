package com.viber.voip.g.a;

import com.viber.voip.messages.controller.manager.o;
import dagger.a.d;
import dagger.a.h;

public final class du
  implements d<o>
{
  private static final du a = new du();

  public static du b()
  {
    return a;
  }

  public static o c()
  {
    return (o)h.a(dj.c(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public o a()
  {
    return (o)h.a(dj.c(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.du
 * JD-Core Version:    0.6.2
 */