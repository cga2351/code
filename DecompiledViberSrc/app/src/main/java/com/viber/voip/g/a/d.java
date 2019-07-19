package com.viber.voip.g.a;

import com.viber.voip.util.e.f;
import dagger.a.h;

public final class d
  implements dagger.a.d<f>
{
  private static final d a = new d();

  public static d b()
  {
    return a;
  }

  public f a()
  {
    return (f)h.a(c.b(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.d
 * JD-Core Version:    0.6.2
 */