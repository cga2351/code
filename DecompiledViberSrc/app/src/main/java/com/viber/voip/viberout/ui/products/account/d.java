package com.viber.voip.viberout.ui.products.account;

import android.content.res.Resources;
import com.viber.voip.viberout.ui.products.a;
import javax.inject.Provider;

public final class d
  implements dagger.a.d<c>
{
  private final Provider<Resources> a;
  private final Provider<a> b;

  public d(Provider<Resources> paramProvider, Provider<a> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static d a(Provider<Resources> paramProvider, Provider<a> paramProvider1)
  {
    return new d(paramProvider, paramProvider1);
  }

  public c a()
  {
    return new c((Resources)this.a.get(), (a)this.b.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.account.d
 * JD-Core Version:    0.6.2
 */