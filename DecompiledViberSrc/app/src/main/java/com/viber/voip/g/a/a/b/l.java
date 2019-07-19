package com.viber.voip.g.a.a.b;

import com.viber.voip.invitelinks.f;
import com.viber.voip.util.cj;
import dagger.a.h;
import javax.inject.Provider;

public final class l
  implements dagger.a.d<f>
{
  private final Provider<com.viber.voip.invitelinks.d> a;
  private final Provider<cj> b;

  public l(Provider<com.viber.voip.invitelinks.d> paramProvider, Provider<cj> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static l a(Provider<com.viber.voip.invitelinks.d> paramProvider, Provider<cj> paramProvider1)
  {
    return new l(paramProvider, paramProvider1);
  }

  public f a()
  {
    return (f)h.a(k.a((com.viber.voip.invitelinks.d)this.a.get(), (cj)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.b.l
 * JD-Core Version:    0.6.2
 */