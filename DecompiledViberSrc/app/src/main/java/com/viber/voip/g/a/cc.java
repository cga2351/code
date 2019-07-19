package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class cc
  implements d<EngineDelegatesManager>
{
  private final Provider<Engine> a;

  public cc(Provider<Engine> paramProvider)
  {
    this.a = paramProvider;
  }

  public static EngineDelegatesManager a(Engine paramEngine)
  {
    return (EngineDelegatesManager)h.a(ca.a(paramEngine), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static cc a(Provider<Engine> paramProvider)
  {
    return new cc(paramProvider);
  }

  public EngineDelegatesManager a()
  {
    return (EngineDelegatesManager)h.a(ca.a((Engine)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.cc
 * JD-Core Version:    0.6.2
 */