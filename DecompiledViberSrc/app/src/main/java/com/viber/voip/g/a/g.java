package com.viber.voip.g.a;

import com.viber.voip.ads.b.a.a.m;
import com.viber.voip.util.ap;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class g
  implements d<m>
{
  private final Provider<ap> a;

  public g(Provider<ap> paramProvider)
  {
    this.a = paramProvider;
  }

  public static g a(Provider<ap> paramProvider)
  {
    return new g(paramProvider);
  }

  public m a()
  {
    return (m)h.a(c.a((ap)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.g
 * JD-Core Version:    0.6.2
 */