package com.viber.voip.g.a;

import com.viber.voip.block.b;
import com.viber.voip.block.k;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ay
  implements d<k>
{
  private final Provider<b> a;

  public static k a(b paramb)
  {
    return (k)h.a(aw.a(paramb), "Cannot return null from a non-@Nullable @Provides method");
  }

  public k a()
  {
    return (k)h.a(aw.a((b)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ay
 * JD-Core Version:    0.6.2
 */