package com.viber.voip.g.a;

import com.viber.voip.ads.b.b.d.a;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class n
  implements d<a<com.viber.voip.ads.b.a.a.a.b>>
{
  private final Provider<com.viber.voip.ads.b.b.c.b<com.viber.voip.ads.b.a.a.a.b>> a;

  public n(Provider<com.viber.voip.ads.b.b.c.b<com.viber.voip.ads.b.a.a.a.b>> paramProvider)
  {
    this.a = paramProvider;
  }

  public static n a(Provider<com.viber.voip.ads.b.b.c.b<com.viber.voip.ads.b.a.a.a.b>> paramProvider)
  {
    return new n(paramProvider);
  }

  public a<com.viber.voip.ads.b.a.a.a.b> a()
  {
    return (a)h.a(c.a((com.viber.voip.ads.b.b.c.b)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.n
 * JD-Core Version:    0.6.2
 */