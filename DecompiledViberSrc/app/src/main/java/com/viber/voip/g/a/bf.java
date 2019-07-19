package com.viber.voip.g.a;

import com.viber.voip.ViberApplication;
import dagger.a.h;
import javax.inject.Provider;

public final class bf
  implements dagger.a.d<com.viber.voip.calls.d>
{
  private final Provider<ViberApplication> a;

  public bf(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static com.viber.voip.calls.d a(ViberApplication paramViberApplication)
  {
    return (com.viber.voip.calls.d)h.a(az.a(paramViberApplication), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static bf a(Provider<ViberApplication> paramProvider)
  {
    return new bf(paramProvider);
  }

  public com.viber.voip.calls.d a()
  {
    return (com.viber.voip.calls.d)h.a(az.a((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bf
 * JD-Core Version:    0.6.2
 */