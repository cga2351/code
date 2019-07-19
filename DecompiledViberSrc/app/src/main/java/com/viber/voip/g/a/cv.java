package com.viber.voip.g.a;

import com.viber.voip.messages.ui.aj;
import dagger.a.d;
import dagger.a.h;

public final class cv
  implements d<aj>
{
  private static final cv a = new cv();

  public static cv b()
  {
    return a;
  }

  public aj a()
  {
    return (aj)h.a(ct.b(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.cv
 * JD-Core Version:    0.6.2
 */