package com.viber.voip.g.a;

import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.m.e;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class af
  implements d<e>
{
  private final Provider<g> a;

  public af(Provider<g> paramProvider)
  {
    this.a = paramProvider;
  }

  public static e a(g paramg)
  {
    return (e)h.a(r.f(paramg), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static af a(Provider<g> paramProvider)
  {
    return new af(paramProvider);
  }

  public e a()
  {
    return (e)h.a(r.f((g)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.af
 * JD-Core Version:    0.6.2
 */