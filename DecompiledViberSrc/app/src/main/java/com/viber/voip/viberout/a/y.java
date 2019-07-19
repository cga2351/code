package com.viber.voip.viberout.a;

import android.content.res.Resources;
import android.os.Handler;
import com.viber.voip.api.a.b.a;
import dagger.a.d;
import javax.inject.Provider;

public final class y
  implements d<t>
{
  private final Provider<Handler> a;
  private final Provider<Handler> b;
  private final Provider<a> c;
  private final Provider<com.viber.voip.registration.af> d;
  private final Provider<com.viber.voip.billing.af> e;
  private final Provider<t.d> f;
  private final Provider<Resources> g;

  public y(Provider<Handler> paramProvider1, Provider<Handler> paramProvider2, Provider<a> paramProvider, Provider<com.viber.voip.registration.af> paramProvider3, Provider<com.viber.voip.billing.af> paramProvider4, Provider<t.d> paramProvider5, Provider<Resources> paramProvider6)
  {
    this.a = paramProvider1;
    this.b = paramProvider2;
    this.c = paramProvider;
    this.d = paramProvider3;
    this.e = paramProvider4;
    this.f = paramProvider5;
    this.g = paramProvider6;
  }

  public static y a(Provider<Handler> paramProvider1, Provider<Handler> paramProvider2, Provider<a> paramProvider, Provider<com.viber.voip.registration.af> paramProvider3, Provider<com.viber.voip.billing.af> paramProvider4, Provider<t.d> paramProvider5, Provider<Resources> paramProvider6)
  {
    return new y(paramProvider1, paramProvider2, paramProvider, paramProvider3, paramProvider4, paramProvider5, paramProvider6);
  }

  public t a()
  {
    return new t((Handler)this.a.get(), (Handler)this.b.get(), (a)this.c.get(), (com.viber.voip.registration.af)this.d.get(), (com.viber.voip.billing.af)this.e.get(), (t.d)this.f.get(), (Resources)this.g.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.y
 * JD-Core Version:    0.6.2
 */