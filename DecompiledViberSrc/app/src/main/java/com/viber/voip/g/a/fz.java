package com.viber.voip.g.a;

import com.viber.voip.stickers.i;
import dagger.a.d;
import dagger.a.h;

public final class fz
  implements d<i>
{
  private static final fz a = new fz();

  public static fz b()
  {
    return a;
  }

  public static i c()
  {
    return (i)h.a(fv.a(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public i a()
  {
    return (i)h.a(fv.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fz
 * JD-Core Version:    0.6.2
 */