package com.viber.voip.g.a;

import com.viber.voip.messages.extensions.d.a;
import com.viber.voip.util.i.e;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bh
  implements d<a>
{
  private final Provider<e> a;

  public bh(Provider<e> paramProvider)
  {
    this.a = paramProvider;
  }

  public static bh a(Provider<e> paramProvider)
  {
    return new bh(paramProvider);
  }

  public a a()
  {
    return (a)h.a(bg.a((e)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bh
 * JD-Core Version:    0.6.2
 */