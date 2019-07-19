package com.viber.voip.g.a;

import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bd
  implements d<DialerLocalCallStateListener>
{
  private final Provider<EngineDelegatesManager> a;

  public bd(Provider<EngineDelegatesManager> paramProvider)
  {
    this.a = paramProvider;
  }

  public static bd a(Provider<EngineDelegatesManager> paramProvider)
  {
    return new bd(paramProvider);
  }

  public DialerLocalCallStateListener a()
  {
    return (DialerLocalCallStateListener)h.a(az.b((EngineDelegatesManager)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bd
 * JD-Core Version:    0.6.2
 */