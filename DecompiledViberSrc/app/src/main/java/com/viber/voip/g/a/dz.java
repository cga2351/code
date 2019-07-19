package com.viber.voip.g.a;

import com.viber.voip.messages.k;
import dagger.a.h;
import javax.inject.Provider;

public final class dz
  implements dagger.a.d<com.viber.voip.u.d>
{
  private final Provider<k> a;

  public static com.viber.voip.u.d a(k paramk)
  {
    return (com.viber.voip.u.d)h.a(dj.f(paramk), "Cannot return null from a non-@Nullable @Provides method");
  }

  public com.viber.voip.u.d a()
  {
    return (com.viber.voip.u.d)h.a(dj.f((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dz
 * JD-Core Version:    0.6.2
 */