package com.viber.voip.g.a;

import com.viber.voip.analytics.e.b;
import com.viber.voip.analytics.g;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class z
  implements d<b>
{
  private final Provider<g> a;

  public z(Provider<g> paramProvider)
  {
    this.a = paramProvider;
  }

  public static z a(Provider<g> paramProvider)
  {
    return new z(paramProvider);
  }

  public b a()
  {
    return (b)h.a(r.a((g)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.z
 * JD-Core Version:    0.6.2
 */