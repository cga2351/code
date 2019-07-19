package com.viber.voip.util;

import android.content.res.Resources;
import dagger.a.d;
import javax.inject.Provider;

public final class ad
  implements d<ac>
{
  private final Provider<Resources> a;

  public ad(Provider<Resources> paramProvider)
  {
    this.a = paramProvider;
  }

  public static ad a(Provider<Resources> paramProvider)
  {
    return new ad(paramProvider);
  }

  public ac a()
  {
    return new ac((Resources)this.a.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ad
 * JD-Core Version:    0.6.2
 */