package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.voip.phone.call.DialerPendingController;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class cb
  implements d<DialerPendingController>
{
  private final Provider<Engine> a;

  public cb(Provider<Engine> paramProvider)
  {
    this.a = paramProvider;
  }

  public static cb a(Provider<Engine> paramProvider)
  {
    return new cb(paramProvider);
  }

  public DialerPendingController a()
  {
    return (DialerPendingController)h.a(ca.b((Engine)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.cb
 * JD-Core Version:    0.6.2
 */