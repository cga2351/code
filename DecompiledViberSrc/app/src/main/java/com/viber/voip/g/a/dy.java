package com.viber.voip.g.a;

import com.viber.voip.messages.k;
import dagger.a.h;
import javax.inject.Provider;

public final class dy
  implements dagger.a.d<com.viber.voip.messages.controller.publicaccount.d>
{
  private final Provider<k> a;

  public dy(Provider<k> paramProvider)
  {
    this.a = paramProvider;
  }

  public static dy a(Provider<k> paramProvider)
  {
    return new dy(paramProvider);
  }

  public static com.viber.voip.messages.controller.publicaccount.d a(k paramk)
  {
    return (com.viber.voip.messages.controller.publicaccount.d)h.a(dj.h(paramk), "Cannot return null from a non-@Nullable @Provides method");
  }

  public com.viber.voip.messages.controller.publicaccount.d a()
  {
    return (com.viber.voip.messages.controller.publicaccount.d)h.a(dj.h((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dy
 * JD-Core Version:    0.6.2
 */