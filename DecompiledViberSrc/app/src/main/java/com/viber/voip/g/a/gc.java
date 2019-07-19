package com.viber.voip.g.a;

import com.viber.voip.messages.controller.manager.au;
import com.viber.voip.messages.k;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class gc
  implements d<au>
{
  private final Provider<k> a;

  public gc(Provider<k> paramProvider)
  {
    this.a = paramProvider;
  }

  public static gc a(Provider<k> paramProvider)
  {
    return new gc(paramProvider);
  }

  public au a()
  {
    return (au)h.a(ga.a((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gc
 * JD-Core Version:    0.6.2
 */