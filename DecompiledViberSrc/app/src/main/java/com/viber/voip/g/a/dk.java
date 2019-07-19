package com.viber.voip.g.a;

import com.viber.voip.messages.controller.manager.c;
import com.viber.voip.messages.k;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class dk
  implements d<c>
{
  private final Provider<k> a;

  public static c a(k paramk)
  {
    return (c)h.a(dj.d(paramk), "Cannot return null from a non-@Nullable @Provides method");
  }

  public c a()
  {
    return (c)h.a(dj.d((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dk
 * JD-Core Version:    0.6.2
 */