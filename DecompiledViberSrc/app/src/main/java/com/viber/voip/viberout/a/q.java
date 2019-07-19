package com.viber.voip.viberout.a;

import com.viber.voip.viberout.ui.products.model.a;
import dagger.a.d;
import javax.inject.Provider;

public final class q
  implements d<p>
{
  private final Provider<r> a;
  private final Provider<a> b;

  public q(Provider<r> paramProvider, Provider<a> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static q a(Provider<r> paramProvider, Provider<a> paramProvider1)
  {
    return new q(paramProvider, paramProvider1);
  }

  public p a()
  {
    return new p((r)this.a.get(), (a)this.b.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.q
 * JD-Core Version:    0.6.2
 */