package com.viber.voip.viberout.ui.products.model;

import android.content.res.Resources;
import dagger.a.d;
import javax.inject.Provider;

public final class e
  implements d<a>
{
  private final Provider<Resources> a;
  private final Provider<com.viber.voip.viberout.ui.products.a> b;

  public e(Provider<Resources> paramProvider, Provider<com.viber.voip.viberout.ui.products.a> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static e a(Provider<Resources> paramProvider, Provider<com.viber.voip.viberout.ui.products.a> paramProvider1)
  {
    return new e(paramProvider, paramProvider1);
  }

  public a a()
  {
    return new a((Resources)this.a.get(), (com.viber.voip.viberout.ui.products.a)this.b.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.model.e
 * JD-Core Version:    0.6.2
 */