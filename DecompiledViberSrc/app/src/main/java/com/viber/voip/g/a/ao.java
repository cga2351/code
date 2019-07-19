package com.viber.voip.g.a;

import com.viber.voip.backup.f;
import dagger.a.d;
import dagger.a.h;

public final class ao
  implements d<f>
{
  private static final ao a = new ao();

  public static ao b()
  {
    return a;
  }

  public f a()
  {
    return (f)h.a(al.b(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ao
 * JD-Core Version:    0.6.2
 */