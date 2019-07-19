package com.viber.voip.viberout.a;

import com.viber.voip.viberout.ui.products.model.a;
import dagger.a.d;
import javax.inject.Provider;

public final class o
  implements d<n>
{
  private final Provider<t> a;
  private final Provider<a> b;

  public o(Provider<t> paramProvider, Provider<a> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static o a(Provider<t> paramProvider, Provider<a> paramProvider1)
  {
    return new o(paramProvider, paramProvider1);
  }

  public n a()
  {
    return new n((t)this.a.get(), (a)this.b.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.o
 * JD-Core Version:    0.6.2
 */