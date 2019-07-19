package com.viber.voip.g.a;

import dagger.a.d;
import dagger.a.h;
import java.util.concurrent.ScheduledExecutorService;

public final class gf
  implements d<ScheduledExecutorService>
{
  private static final gf a = new gf();

  public static ScheduledExecutorService b()
  {
    return (ScheduledExecutorService)h.a(gd.i(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public ScheduledExecutorService a()
  {
    return (ScheduledExecutorService)h.a(gd.i(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gf
 * JD-Core Version:    0.6.2
 */