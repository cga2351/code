package com.viber.voip.g.a;

import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.k;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class dq
  implements d<ai>
{
  private final Provider<k> a;

  public dq(Provider<k> paramProvider)
  {
    this.a = paramProvider;
  }

  public static dq a(Provider<k> paramProvider)
  {
    return new dq(paramProvider);
  }

  public static ai a(k paramk)
  {
    return (ai)h.a(dj.c(paramk), "Cannot return null from a non-@Nullable @Provides method");
  }

  public ai a()
  {
    return (ai)h.a(dj.c((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dq
 * JD-Core Version:    0.6.2
 */