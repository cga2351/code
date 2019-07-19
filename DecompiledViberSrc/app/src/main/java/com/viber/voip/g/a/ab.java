package com.viber.voip.g.a;

import com.viber.voip.analytics.g;
import dagger.a.h;
import javax.inject.Provider;

public final class ab
  implements dagger.a.d<com.viber.voip.analytics.story.f.d>
{
  private final Provider<g> a;

  public ab(Provider<g> paramProvider)
  {
    this.a = paramProvider;
  }

  public static com.viber.voip.analytics.story.f.d a(g paramg)
  {
    return (com.viber.voip.analytics.story.f.d)h.a(r.c(paramg), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ab a(Provider<g> paramProvider)
  {
    return new ab(paramProvider);
  }

  public com.viber.voip.analytics.story.f.d a()
  {
    return (com.viber.voip.analytics.story.f.d)h.a(r.c((g)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ab
 * JD-Core Version:    0.6.2
 */