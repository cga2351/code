package com.viber.voip.g.a;

import android.os.Handler;
import dagger.a.d;
import dagger.a.h;

public final class gl
  implements d<Handler>
{
  private static final gl a = new gl();

  public static gl b()
  {
    return a;
  }

  public Handler a()
  {
    return (Handler)h.a(gd.g(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gl
 * JD-Core Version:    0.6.2
 */