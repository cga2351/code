package com.viber.voip.g.a;

import com.viber.voip.ViberApplication;
import com.viber.voip.registration.ActivationController;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class b
  implements d<ActivationController>
{
  private final Provider<ViberApplication> a;

  public b(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static b a(Provider<ViberApplication> paramProvider)
  {
    return new b(paramProvider);
  }

  public ActivationController a()
  {
    return (ActivationController)h.a(a.a((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.b
 * JD-Core Version:    0.6.2
 */