package com.viber.voip.g.a;

import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.h.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ad
  implements d<c>
{
  private final Provider<g> a;

  public ad(Provider<g> paramProvider)
  {
    this.a = paramProvider;
  }

  public static ad a(Provider<g> paramProvider)
  {
    return new ad(paramProvider);
  }

  public c a()
  {
    return (c)h.a(r.e((g)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ad
 * JD-Core Version:    0.6.2
 */