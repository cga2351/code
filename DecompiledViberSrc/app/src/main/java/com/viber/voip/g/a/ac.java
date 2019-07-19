package com.viber.voip.g.a;

import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.g.a;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ac
  implements d<a>
{
  private final Provider<g> a;

  public ac(Provider<g> paramProvider)
  {
    this.a = paramProvider;
  }

  public static a a(g paramg)
  {
    return (a)h.a(r.d(paramg), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ac a(Provider<g> paramProvider)
  {
    return new ac(paramProvider);
  }

  public a a()
  {
    return (a)h.a(r.d((g)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ac
 * JD-Core Version:    0.6.2
 */