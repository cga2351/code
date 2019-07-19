package com.viber.voip.g.a;

import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.viberout.ViberOutBalanceListener;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class da
  implements d<ViberOutBalanceListener>
{
  private final Provider<EngineDelegatesManager> a;

  public da(Provider<EngineDelegatesManager> paramProvider)
  {
    this.a = paramProvider;
  }

  public static ViberOutBalanceListener a(EngineDelegatesManager paramEngineDelegatesManager)
  {
    return (ViberOutBalanceListener)h.a(cz.a(paramEngineDelegatesManager), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static da a(Provider<EngineDelegatesManager> paramProvider)
  {
    return new da(paramProvider);
  }

  public ViberOutBalanceListener a()
  {
    return (ViberOutBalanceListener)h.a(cz.a((EngineDelegatesManager)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.da
 * JD-Core Version:    0.6.2
 */