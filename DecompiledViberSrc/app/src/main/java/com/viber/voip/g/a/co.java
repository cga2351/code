package com.viber.voip.g.a;

import android.os.Handler;
import dagger.a.c;
import dagger.a.h;
import javax.inject.Provider;

public final class co
  implements dagger.a.d<com.viber.voip.r.a>
{
  private final Provider<Handler> a;
  private final Provider<com.viber.voip.util.d> b;
  private final Provider<com.viber.voip.engagement.a> c;

  public co(Provider<Handler> paramProvider, Provider<com.viber.voip.util.d> paramProvider1, Provider<com.viber.voip.engagement.a> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static co a(Provider<Handler> paramProvider, Provider<com.viber.voip.util.d> paramProvider1, Provider<com.viber.voip.engagement.a> paramProvider2)
  {
    return new co(paramProvider, paramProvider1, paramProvider2);
  }

  public com.viber.voip.r.a a()
  {
    return (com.viber.voip.r.a)h.a(cl.a((Handler)this.a.get(), (com.viber.voip.util.d)this.b.get(), c.b(this.c)), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.co
 * JD-Core Version:    0.6.2
 */