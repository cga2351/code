package com.viber.voip.g.a;

import com.viber.voip.pixie.PixieController;
import dagger.a.d;
import dagger.a.h;

public final class eg
  implements d<PixieController>
{
  private static final eg a = new eg();

  public static PixieController b()
  {
    return (PixieController)h.a(ec.a(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public PixieController a()
  {
    return (PixieController)h.a(ec.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.eg
 * JD-Core Version:    0.6.2
 */