package com.viber.voip.g.a.a.a;

import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.af;
import com.viber.voip.viberout.a.a;
import com.viber.voip.viberout.a.t.d;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bv
  implements d<t.d>
{
  private final Provider<HardwareParameters> a;
  private final Provider<af> b;
  private final Provider<a> c;

  public bv(Provider<HardwareParameters> paramProvider, Provider<af> paramProvider1, Provider<a> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static bv a(Provider<HardwareParameters> paramProvider, Provider<af> paramProvider1, Provider<a> paramProvider2)
  {
    return new bv(paramProvider, paramProvider1, paramProvider2);
  }

  public t.d a()
  {
    return (t.d)h.a(bs.a((HardwareParameters)this.a.get(), (af)this.b.get(), (a)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.a.bv
 * JD-Core Version:    0.6.2
 */