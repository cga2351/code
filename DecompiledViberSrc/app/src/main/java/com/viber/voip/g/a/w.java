package com.viber.voip.g.a;

import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.c.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class w
  implements d<c>
{
  private final Provider<g> a;

  public w(Provider<g> paramProvider)
  {
    this.a = paramProvider;
  }

  public static c a(g paramg)
  {
    return (c)h.a(r.i(paramg), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static w a(Provider<g> paramProvider)
  {
    return new w(paramProvider);
  }

  public c a()
  {
    return (c)h.a(r.i((g)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.w
 * JD-Core Version:    0.6.2
 */