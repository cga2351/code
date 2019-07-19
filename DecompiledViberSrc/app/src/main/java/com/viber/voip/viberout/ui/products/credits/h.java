package com.viber.voip.viberout.ui.products.credits;

import com.viber.voip.analytics.story.m.e;
import com.viber.voip.viberout.a.g;
import com.viber.voip.viberout.a.j;
import dagger.a.d;
import javax.inject.Provider;

public final class h
  implements d<ViberOutCreditsPresenter>
{
  private final Provider<j> a;
  private final Provider<g> b;
  private final Provider<e> c;

  public h(Provider<j> paramProvider, Provider<g> paramProvider1, Provider<e> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static h a(Provider<j> paramProvider, Provider<g> paramProvider1, Provider<e> paramProvider2)
  {
    return new h(paramProvider, paramProvider1, paramProvider2);
  }

  public ViberOutCreditsPresenter a()
  {
    return new ViberOutCreditsPresenter((j)this.a.get(), (g)this.b.get(), (e)this.c.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.credits.h
 * JD-Core Version:    0.6.2
 */