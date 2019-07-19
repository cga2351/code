package com.viber.voip.invitelinks;

import com.viber.voip.util.cj;
import javax.inject.Provider;

public final class h
  implements dagger.a.d<f>
{
  private final Provider<d> a;
  private final Provider<cj> b;

  public h(Provider<d> paramProvider, Provider<cj> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static h a(Provider<d> paramProvider, Provider<cj> paramProvider1)
  {
    return new h(paramProvider, paramProvider1);
  }

  public f a()
  {
    return new f((d)this.a.get(), (cj)this.b.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.h
 * JD-Core Version:    0.6.2
 */