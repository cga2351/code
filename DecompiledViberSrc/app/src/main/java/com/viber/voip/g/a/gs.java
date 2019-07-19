package com.viber.voip.g.a;

import com.viber.voip.util.cv;
import dagger.a.d;
import dagger.a.h;

public final class gs
  implements d<cv>
{
  private static final gs a = new gs();

  public static gs b()
  {
    return a;
  }

  public static cv c()
  {
    return (cv)h.a(go.a(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public cv a()
  {
    return (cv)h.a(go.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gs
 * JD-Core Version:    0.6.2
 */