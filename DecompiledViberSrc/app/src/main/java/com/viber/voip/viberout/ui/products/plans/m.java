package com.viber.voip.viberout.ui.products.plans;

import com.viber.voip.viberout.a.e;
import com.viber.voip.viberout.a.p;
import dagger.a.d;
import javax.inject.Provider;

public final class m
  implements d<ViberOutPlansPresenter>
{
  private final Provider<p> a;
  private final Provider<e> b;
  private final Provider<com.viber.voip.viberout.a.g> c;
  private final Provider<com.viber.voip.analytics.g> d;

  public m(Provider<p> paramProvider, Provider<e> paramProvider1, Provider<com.viber.voip.viberout.a.g> paramProvider2, Provider<com.viber.voip.analytics.g> paramProvider3)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
  }

  public static m a(Provider<p> paramProvider, Provider<e> paramProvider1, Provider<com.viber.voip.viberout.a.g> paramProvider2, Provider<com.viber.voip.analytics.g> paramProvider3)
  {
    return new m(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }

  public ViberOutPlansPresenter a()
  {
    return new ViberOutPlansPresenter((p)this.a.get(), (e)this.b.get(), (com.viber.voip.viberout.a.g)this.c.get(), (com.viber.voip.analytics.g)this.d.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.plans.m
 * JD-Core Version:    0.6.2
 */