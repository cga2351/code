package com.viber.voip.g.a;

import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ds
  implements d<com.viber.voip.messages.controller.manager.k>
{
  private final Provider<com.viber.voip.messages.k> a;

  public ds(Provider<com.viber.voip.messages.k> paramProvider)
  {
    this.a = paramProvider;
  }

  public static ds a(Provider<com.viber.voip.messages.k> paramProvider)
  {
    return new ds(paramProvider);
  }

  public static com.viber.voip.messages.controller.manager.k a(com.viber.voip.messages.k paramk)
  {
    return (com.viber.voip.messages.controller.manager.k)h.a(dj.a(paramk), "Cannot return null from a non-@Nullable @Provides method");
  }

  public com.viber.voip.messages.controller.manager.k a()
  {
    return (com.viber.voip.messages.controller.manager.k)h.a(dj.a((com.viber.voip.messages.k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ds
 * JD-Core Version:    0.6.2
 */