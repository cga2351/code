package com.viber.voip.g.a;

import com.viber.voip.group.participants.settings.e;
import com.viber.voip.messages.controller.ci;
import dagger.a.d;
import javax.inject.Provider;

public final class as
  implements d<com.viber.voip.group.participants.ban.h>
{
  private final Provider<e> a;
  private final Provider<ci> b;

  public as(Provider<e> paramProvider, Provider<ci> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static as a(Provider<e> paramProvider, Provider<ci> paramProvider1)
  {
    return new as(paramProvider, paramProvider1);
  }

  public com.viber.voip.group.participants.ban.h a()
  {
    return (com.viber.voip.group.participants.ban.h)dagger.a.h.a(ar.a((e)this.a.get(), (ci)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.as
 * JD-Core Version:    0.6.2
 */