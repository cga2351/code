package com.viber.voip.g.a;

import com.viber.voip.ViberApplication;
import com.viber.voip.messages.extras.a.e;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class fo
  implements d<e>
{
  private final Provider<ViberApplication> a;

  public fo(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static fo a(Provider<ViberApplication> paramProvider)
  {
    return new fo(paramProvider);
  }

  public static e a(ViberApplication paramViberApplication)
  {
    return (e)h.a(fn.a(paramViberApplication), "Cannot return null from a non-@Nullable @Provides method");
  }

  public e a()
  {
    return (e)h.a(fn.a((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fo
 * JD-Core Version:    0.6.2
 */