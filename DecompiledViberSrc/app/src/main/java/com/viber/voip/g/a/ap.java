package com.viber.voip.g.a;

import com.viber.voip.backup.g;
import dagger.a.d;
import dagger.a.h;

public final class ap
  implements d<g>
{
  private static final ap a = new ap();

  public static ap b()
  {
    return a;
  }

  public g a()
  {
    return (g)h.a(al.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ap
 * JD-Core Version:    0.6.2
 */