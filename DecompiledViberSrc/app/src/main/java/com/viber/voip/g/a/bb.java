package com.viber.voip.g.a;

import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.dialer.DialerCallInterruptionListener;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bb
  implements d<DialerCallInterruptionListener>
{
  private final Provider<EngineDelegatesManager> a;

  public bb(Provider<EngineDelegatesManager> paramProvider)
  {
    this.a = paramProvider;
  }

  public static bb a(Provider<EngineDelegatesManager> paramProvider)
  {
    return new bb(paramProvider);
  }

  public DialerCallInterruptionListener a()
  {
    return (DialerCallInterruptionListener)h.a(az.c((EngineDelegatesManager)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bb
 * JD-Core Version:    0.6.2
 */