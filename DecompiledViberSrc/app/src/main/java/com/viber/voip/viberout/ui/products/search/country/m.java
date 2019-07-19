package com.viber.voip.viberout.ui.products.search.country;

import android.os.Handler;
import com.viber.voip.viberout.a.n;
import dagger.a.d;
import javax.inject.Provider;

public final class m
  implements d<ViberOutCountrySearchPresenter>
{
  private final Provider<n> a;
  private final Provider<Handler> b;

  public m(Provider<n> paramProvider, Provider<Handler> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static m a(Provider<n> paramProvider, Provider<Handler> paramProvider1)
  {
    return new m(paramProvider, paramProvider1);
  }

  public ViberOutCountrySearchPresenter a()
  {
    return new ViberOutCountrySearchPresenter((n)this.a.get(), (Handler)this.b.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.search.country.m
 * JD-Core Version:    0.6.2
 */