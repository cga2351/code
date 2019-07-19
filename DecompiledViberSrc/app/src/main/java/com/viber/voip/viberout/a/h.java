package com.viber.voip.viberout.a;

import com.viber.voip.viberout.ui.products.account.c;
import dagger.a.d;
import javax.inject.Provider;

public final class h
  implements d<g>
{
  private final Provider<t> a;
  private final Provider<c> b;

  public h(Provider<t> paramProvider, Provider<c> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static h a(Provider<t> paramProvider, Provider<c> paramProvider1)
  {
    return new h(paramProvider, paramProvider1);
  }

  public g a()
  {
    return new g((t)this.a.get(), (c)this.b.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.h
 * JD-Core Version:    0.6.2
 */