package com.viber.voip.g.a;

import android.os.Handler;
import dagger.a.d;
import dagger.a.h;

public final class gk
  implements d<Handler>
{
  private static final gk a = new gk();

  public static gk b()
  {
    return a;
  }

  public static Handler c()
  {
    return (Handler)h.a(gd.b(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public Handler a()
  {
    return (Handler)h.a(gd.b(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gk
 * JD-Core Version:    0.6.2
 */