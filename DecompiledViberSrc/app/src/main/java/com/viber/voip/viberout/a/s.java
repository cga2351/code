package com.viber.voip.viberout.a;

import dagger.a.d;
import javax.inject.Provider;

public final class s
  implements d<r>
{
  private final Provider<t> a;

  public s(Provider<t> paramProvider)
  {
    this.a = paramProvider;
  }

  public static s a(Provider<t> paramProvider)
  {
    return new s(paramProvider);
  }

  public r a()
  {
    return new r((t)this.a.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.s
 * JD-Core Version:    0.6.2
 */