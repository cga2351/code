package com.viber.voip.viberout.a;

import com.viber.voip.viberout.ui.products.model.a;
import dagger.a.d;
import javax.inject.Provider;

public final class k
  implements d<j>
{
  private final Provider<r> a;
  private final Provider<a> b;
  private final Provider<l> c;

  public k(Provider<r> paramProvider, Provider<a> paramProvider1, Provider<l> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static k a(Provider<r> paramProvider, Provider<a> paramProvider1, Provider<l> paramProvider2)
  {
    return new k(paramProvider, paramProvider1, paramProvider2);
  }

  public j a()
  {
    return new j((r)this.a.get(), (a)this.b.get(), (l)this.c.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.k
 * JD-Core Version:    0.6.2
 */