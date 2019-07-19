package com.viber.voip.g.a;

import com.viber.voip.ViberApplication;
import com.viber.voip.registration.HardwareParameters;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bx
  implements d<HardwareParameters>
{
  private final Provider<ViberApplication> a;

  public bx(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static bx a(Provider<ViberApplication> paramProvider)
  {
    return new bx(paramProvider);
  }

  public HardwareParameters a()
  {
    return (HardwareParameters)h.a(bw.a((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bx
 * JD-Core Version:    0.6.2
 */