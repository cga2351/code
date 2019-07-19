package com.viber.voip.g.a;

import com.viber.voip.stickers.a.a;
import com.viber.voip.stickers.i;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class fw
  implements d<a>
{
  private final Provider<i> a;

  public fw(Provider<i> paramProvider)
  {
    this.a = paramProvider;
  }

  public static fw a(Provider<i> paramProvider)
  {
    return new fw(paramProvider);
  }

  public static a a(i parami)
  {
    return (a)h.a(fv.b(parami), "Cannot return null from a non-@Nullable @Provides method");
  }

  public a a()
  {
    return (a)h.a(fv.b((i)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fw
 * JD-Core Version:    0.6.2
 */