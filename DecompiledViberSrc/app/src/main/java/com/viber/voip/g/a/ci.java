package com.viber.voip.g.a;

import dagger.a.d;
import dagger.a.h;
import org.greenrobot.eventbus.EventBus;

public final class ci
  implements d<EventBus>
{
  private static final ci a = new ci();

  public static ci b()
  {
    return a;
  }

  public EventBus a()
  {
    return (EventBus)h.a(ch.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ci
 * JD-Core Version:    0.6.2
 */