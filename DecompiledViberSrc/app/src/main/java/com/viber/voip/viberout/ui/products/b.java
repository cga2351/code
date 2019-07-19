package com.viber.voip.viberout.ui.products;

import com.viber.voip.util.ac;
import dagger.a.d;
import javax.inject.Provider;

public final class b
  implements d<a>
{
  private final Provider<ac> a;

  public b(Provider<ac> paramProvider)
  {
    this.a = paramProvider;
  }

  public static b a(Provider<ac> paramProvider)
  {
    return new b(paramProvider);
  }

  public a a()
  {
    return new a((ac)this.a.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.b
 * JD-Core Version:    0.6.2
 */