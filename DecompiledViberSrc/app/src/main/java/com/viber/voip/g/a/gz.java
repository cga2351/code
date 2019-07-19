package com.viber.voip.g.a;

import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.k;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class gz
  implements d<ci>
{
  private final Provider<k> a;

  public gz(Provider<k> paramProvider)
  {
    this.a = paramProvider;
  }

  public static gz a(Provider<k> paramProvider)
  {
    return new gz(paramProvider);
  }

  public ci a()
  {
    return (ci)h.a(gv.a((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gz
 * JD-Core Version:    0.6.2
 */