package com.viber.voip.g.a;

import android.os.Handler;
import com.google.d.f;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ads.a.b;
import com.viber.voip.registration.af;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class e
  implements d<b>
{
  private final Provider<Engine> a;
  private final Provider<com.viber.voip.util.i.e> b;
  private final Provider<Im2Exchanger> c;
  private final Provider<PhoneController> d;
  private final Provider<Handler> e;
  private final Provider<af> f;
  private final Provider<f> g;

  public e(Provider<Engine> paramProvider, Provider<com.viber.voip.util.i.e> paramProvider1, Provider<Im2Exchanger> paramProvider2, Provider<PhoneController> paramProvider3, Provider<Handler> paramProvider4, Provider<af> paramProvider5, Provider<f> paramProvider6)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
    this.f = paramProvider5;
    this.g = paramProvider6;
  }

  public static e a(Provider<Engine> paramProvider, Provider<com.viber.voip.util.i.e> paramProvider1, Provider<Im2Exchanger> paramProvider2, Provider<PhoneController> paramProvider3, Provider<Handler> paramProvider4, Provider<af> paramProvider5, Provider<f> paramProvider6)
  {
    return new e(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6);
  }

  public b a()
  {
    return (b)h.a(c.a(dagger.a.c.b(this.a), (com.viber.voip.util.i.e)this.b.get(), (Im2Exchanger)this.c.get(), (PhoneController)this.d.get(), (Handler)this.e.get(), (af)this.f.get(), (f)this.g.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.e
 * JD-Core Version:    0.6.2
 */