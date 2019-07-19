package com.viber.voip.g.a;

import android.os.Handler;
import dagger.a.d;
import dagger.a.h;

public final class gh
  implements d<Handler>
{
  private static final gh a = new gh();

  public static gh b()
  {
    return a;
  }

  public Handler a()
  {
    return (Handler)h.a(gd.c(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gh
 * JD-Core Version:    0.6.2
 */