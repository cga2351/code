package com.viber.voip.g.a;

import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.a.a;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class t
  implements d<a>
{
  private final Provider<g> a;

  public t(Provider<g> paramProvider)
  {
    this.a = paramProvider;
  }

  public static a a(g paramg)
  {
    return (a)h.a(r.k(paramg), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static t a(Provider<g> paramProvider)
  {
    return new t(paramProvider);
  }

  public a a()
  {
    return (a)h.a(r.k((g)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.t
 * JD-Core Version:    0.6.2
 */