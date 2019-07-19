package com.viber.voip.g.a;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import dagger.a.d;
import javax.inject.Provider;

public final class o
  implements d<com.viber.voip.ads.h>
{
  private final Provider<Context> a;
  private final Provider<PhoneController> b;
  private final Provider<ICdrController> c;
  private final Provider<Handler> d;

  public o(Provider<Context> paramProvider, Provider<PhoneController> paramProvider1, Provider<ICdrController> paramProvider2, Provider<Handler> paramProvider3)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
  }

  public static o a(Provider<Context> paramProvider, Provider<PhoneController> paramProvider1, Provider<ICdrController> paramProvider2, Provider<Handler> paramProvider3)
  {
    return new o(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }

  public com.viber.voip.ads.h a()
  {
    return (com.viber.voip.ads.h)dagger.a.h.a(c.a((Context)this.a.get(), (PhoneController)this.b.get(), (ICdrController)this.c.get(), (Handler)this.d.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.o
 * JD-Core Version:    0.6.2
 */