package com.viber.voip.g.a;

import com.viber.voip.billing.af;
import dagger.a.d;
import dagger.a.h;

public final class hh
  implements d<af>
{
  private static final hh a = new hh();

  public static hh b()
  {
    return a;
  }

  public af a()
  {
    return (af)h.a(hg.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.hh
 * JD-Core Version:    0.6.2
 */