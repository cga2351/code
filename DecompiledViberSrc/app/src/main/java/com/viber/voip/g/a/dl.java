package com.viber.voip.g.a;

import com.viber.voip.messages.controller.a.a;
import com.viber.voip.messages.k;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class dl
  implements d<a>
{
  private final Provider<k> a;

  public dl(Provider<k> paramProvider)
  {
    this.a = paramProvider;
  }

  public static dl a(Provider<k> paramProvider)
  {
    return new dl(paramProvider);
  }

  public a a()
  {
    return (a)h.a(dj.i((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dl
 * JD-Core Version:    0.6.2
 */