package com.viber.voip.g.a;

import com.viber.voip.messages.controller.cl;
import com.viber.voip.messages.k;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class hb
  implements d<cl>
{
  private final Provider<k> a;

  public hb(Provider<k> paramProvider)
  {
    this.a = paramProvider;
  }

  public static hb a(Provider<k> paramProvider)
  {
    return new hb(paramProvider);
  }

  public cl a()
  {
    return (cl)h.a(gv.b((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.hb
 * JD-Core Version:    0.6.2
 */