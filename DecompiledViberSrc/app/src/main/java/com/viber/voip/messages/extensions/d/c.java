package com.viber.voip.messages.extensions.d;

import android.content.Context;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.extensions.f;
import com.viber.voip.registration.af;
import dagger.a.d;
import javax.inject.Provider;

public final class c
  implements d<b>
{
  private final Provider<Context> a;
  private final Provider<ViberApplication> b;
  private final Provider<com.viber.voip.messages.extensions.c> c;
  private final Provider<a> d;
  private final Provider<f> e;
  private final Provider<af> f;

  public c(Provider<Context> paramProvider, Provider<ViberApplication> paramProvider1, Provider<com.viber.voip.messages.extensions.c> paramProvider2, Provider<a> paramProvider3, Provider<f> paramProvider4, Provider<af> paramProvider5)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
    this.f = paramProvider5;
  }

  public static c a(Provider<Context> paramProvider, Provider<ViberApplication> paramProvider1, Provider<com.viber.voip.messages.extensions.c> paramProvider2, Provider<a> paramProvider3, Provider<f> paramProvider4, Provider<af> paramProvider5)
  {
    return new c(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }

  public b a()
  {
    return new b((Context)this.a.get(), (ViberApplication)this.b.get(), (com.viber.voip.messages.extensions.c)this.c.get(), (a)this.d.get(), dagger.a.c.b(this.e), (af)this.f.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.d.c
 * JD-Core Version:    0.6.2
 */