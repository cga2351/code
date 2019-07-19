package com.viber.voip.g.a;

import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.dialer.DialerPhoneStateListener;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class be
  implements d<DialerPhoneStateListener>
{
  private final Provider<EngineDelegatesManager> a;

  public be(Provider<EngineDelegatesManager> paramProvider)
  {
    this.a = paramProvider;
  }

  public static be a(Provider<EngineDelegatesManager> paramProvider)
  {
    return new be(paramProvider);
  }

  public DialerPhoneStateListener a()
  {
    return (DialerPhoneStateListener)h.a(az.a((EngineDelegatesManager)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.be
 * JD-Core Version:    0.6.2
 */