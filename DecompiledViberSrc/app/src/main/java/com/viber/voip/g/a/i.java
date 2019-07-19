package com.viber.voip.g.a;

import com.viber.voip.ads.b.c.a.b;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class i
  implements d<b>
{
  private final Provider<e> a;
  private final Provider<f> b;
  private final Provider<f> c;

  public i(Provider<e> paramProvider, Provider<f> paramProvider1, Provider<f> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static i a(Provider<e> paramProvider, Provider<f> paramProvider1, Provider<f> paramProvider2)
  {
    return new i(paramProvider, paramProvider1, paramProvider2);
  }

  public b a()
  {
    return (b)h.a(c.a((e)this.a.get(), (f)this.b.get(), (f)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.i
 * JD-Core Version:    0.6.2
 */