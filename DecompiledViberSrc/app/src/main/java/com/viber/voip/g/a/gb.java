package com.viber.voip.g.a;

import com.viber.voip.messages.controller.manager.at;
import com.viber.voip.messages.controller.manager.au;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class gb
  implements d<at>
{
  private final Provider<au> a;

  public gb(Provider<au> paramProvider)
  {
    this.a = paramProvider;
  }

  public static gb a(Provider<au> paramProvider)
  {
    return new gb(paramProvider);
  }

  public at a()
  {
    return (at)h.a(ga.a((au)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gb
 * JD-Core Version:    0.6.2
 */