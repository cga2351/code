package com.viber.voip.g.a;

import com.viber.voip.messages.controller.a;
import com.viber.voip.messages.k;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class dm
  implements d<a>
{
  private final Provider<k> a;

  public dm(Provider<k> paramProvider)
  {
    this.a = paramProvider;
  }

  public static dm a(Provider<k> paramProvider)
  {
    return new dm(paramProvider);
  }

  public static a a(k paramk)
  {
    return (a)h.a(dj.b(paramk), "Cannot return null from a non-@Nullable @Provides method");
  }

  public a a()
  {
    return (a)h.a(dj.b((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dm
 * JD-Core Version:    0.6.2
 */