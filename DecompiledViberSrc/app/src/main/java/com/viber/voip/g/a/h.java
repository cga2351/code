package com.viber.voip.g.a;

import com.viber.voip.ads.b.a.a.m;
import dagger.a.d;
import javax.inject.Provider;

public final class h
  implements d<com.viber.voip.ads.b.b.c.b<com.viber.voip.ads.b.a.a.a.b>>
{
  private final Provider<m> a;

  public h(Provider<m> paramProvider)
  {
    this.a = paramProvider;
  }

  public static h a(Provider<m> paramProvider)
  {
    return new h(paramProvider);
  }

  public com.viber.voip.ads.b.b.c.b<com.viber.voip.ads.b.a.a.a.b> a()
  {
    return (com.viber.voip.ads.b.b.c.b)dagger.a.h.a(c.a((m)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.h
 * JD-Core Version:    0.6.2
 */