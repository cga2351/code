package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.jni.dialer.DialerController;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bc
  implements d<DialerController>
{
  private final Provider<Engine> a;

  public bc(Provider<Engine> paramProvider)
  {
    this.a = paramProvider;
  }

  public static bc a(Provider<Engine> paramProvider)
  {
    return new bc(paramProvider);
  }

  public DialerController a()
  {
    return (DialerController)h.a(az.b((Engine)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bc
 * JD-Core Version:    0.6.2
 */