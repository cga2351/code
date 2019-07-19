package com.viber.voip.viberout.ui.products.account;

import dagger.a.d;
import javax.inject.Provider;

public final class g
  implements d<ViberOutAccountPresenter>
{
  private final Provider<com.viber.voip.viberout.a.g> a;
  private final Provider<com.viber.voip.viberout.a.e> b;
  private final Provider<com.viber.voip.analytics.story.m.e> c;

  public g(Provider<com.viber.voip.viberout.a.g> paramProvider, Provider<com.viber.voip.viberout.a.e> paramProvider1, Provider<com.viber.voip.analytics.story.m.e> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static g a(Provider<com.viber.voip.viberout.a.g> paramProvider, Provider<com.viber.voip.viberout.a.e> paramProvider1, Provider<com.viber.voip.analytics.story.m.e> paramProvider2)
  {
    return new g(paramProvider, paramProvider1, paramProvider2);
  }

  public ViberOutAccountPresenter a()
  {
    return new ViberOutAccountPresenter((com.viber.voip.viberout.a.g)this.a.get(), (com.viber.voip.viberout.a.e)this.b.get(), (com.viber.voip.analytics.story.m.e)this.c.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.account.g
 * JD-Core Version:    0.6.2
 */