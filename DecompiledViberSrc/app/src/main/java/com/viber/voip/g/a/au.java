package com.viber.voip.g.a;

import com.viber.voip.group.participants.ban.e;
import com.viber.voip.messages.k;
import dagger.a.c;
import dagger.a.h;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;

public final class au
  implements dagger.a.d<com.viber.voip.group.participants.settings.d>
{
  private final Provider<e> a;
  private final Provider<k> b;
  private final Provider<EventBus> c;

  public au(Provider<e> paramProvider, Provider<k> paramProvider1, Provider<EventBus> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static au a(Provider<e> paramProvider, Provider<k> paramProvider1, Provider<EventBus> paramProvider2)
  {
    return new au(paramProvider, paramProvider1, paramProvider2);
  }

  public com.viber.voip.group.participants.settings.d a()
  {
    return (com.viber.voip.group.participants.settings.d)h.a(ar.a((e)this.a.get(), c.b(this.b), (EventBus)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.au
 * JD-Core Version:    0.6.2
 */