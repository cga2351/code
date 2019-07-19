package com.viber.voip.g.a;

import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.m;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bn
  implements d<m>
{
  private final Provider<g> a;

  public bn(Provider<g> paramProvider)
  {
    this.a = paramProvider;
  }

  public static m a(g paramg)
  {
    return (m)h.a(bk.b(paramg), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static bn a(Provider<g> paramProvider)
  {
    return new bn(paramProvider);
  }

  public m a()
  {
    return (m)h.a(bk.b((g)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bn
 * JD-Core Version:    0.6.2
 */