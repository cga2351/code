package com.viber.voip.g.a;

import com.viber.voip.messages.extensions.i;
import dagger.a.d;
import dagger.a.h;

public final class bi
  implements d<i>
{
  private static final bi a = new bi();

  public static bi b()
  {
    return a;
  }

  public i a()
  {
    return (i)h.a(bg.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bi
 * JD-Core Version:    0.6.2
 */