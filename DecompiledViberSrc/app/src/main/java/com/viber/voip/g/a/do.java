package com.viber.voip.g.a;

import com.viber.voip.messages.controller.r;
import com.viber.voip.messages.k;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class do
  implements d<r>
{
  private final Provider<k> a;

  public do(Provider<k> paramProvider)
  {
    this.a = paramProvider;
  }

  public static do a(Provider<k> paramProvider)
  {
    return new do(paramProvider);
  }

  public r a()
  {
    return (r)h.a(dj.j((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.do
 * JD-Core Version:    0.6.2
 */