package com.viber.voip.g.a;

import com.viber.voip.messages.d.b;
import dagger.a.d;
import dagger.a.h;

public final class dx
  implements d<b>
{
  private static final dx a = new dx();

  public static dx b()
  {
    return a;
  }

  public static b c()
  {
    return (b)h.a(dj.a(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public b a()
  {
    return (b)h.a(dj.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dx
 * JD-Core Version:    0.6.2
 */