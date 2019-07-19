package com.viber.voip.g.a;

import com.viber.voip.stickers.f;
import com.viber.voip.stickers.i;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class fy
  implements d<f>
{
  private final Provider<i> a;

  public static f a(i parami)
  {
    return (f)h.a(fv.a(parami), "Cannot return null from a non-@Nullable @Provides method");
  }

  public f a()
  {
    return (f)h.a(fv.a((i)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fy
 * JD-Core Version:    0.6.2
 */