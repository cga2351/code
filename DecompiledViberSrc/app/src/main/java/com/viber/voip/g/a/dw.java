package com.viber.voip.g.a;

import com.viber.voip.messages.controller.manager.ah;
import com.viber.voip.messages.k;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class dw
  implements d<ah>
{
  private final Provider<k> a;

  public static ah a(k paramk)
  {
    return (ah)h.a(dj.l(paramk), "Cannot return null from a non-@Nullable @Provides method");
  }

  public ah a()
  {
    return (ah)h.a(dj.l((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dw
 * JD-Core Version:    0.6.2
 */