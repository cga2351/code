package com.viber.voip.g.a.a.b;

import com.viber.voip.analytics.g;
import com.viber.voip.contacts.ui.s;
import com.viber.voip.invitelinks.linkscreen.f;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class m
  implements d<f>
{
  private final Provider<s> a;
  private final Provider<g> b;

  public m(Provider<s> paramProvider, Provider<g> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static m a(Provider<s> paramProvider, Provider<g> paramProvider1)
  {
    return new m(paramProvider, paramProvider1);
  }

  public f a()
  {
    return (f)h.a(k.a((s)this.a.get(), (g)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.b.m
 * JD-Core Version:    0.6.2
 */