package com.viber.voip.g.a;

import com.viber.voip.group.participants.ban.e;
import com.viber.voip.invitelinks.linkscreen.g;
import com.viber.voip.messages.k;
import dagger.a.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class at
  implements d<g>
{
  private final Provider<e> a;
  private final Provider<k> b;

  public at(Provider<e> paramProvider, Provider<k> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static at a(Provider<e> paramProvider, Provider<k> paramProvider1)
  {
    return new at(paramProvider, paramProvider1);
  }

  public g a()
  {
    return (g)h.a(ar.a((e)this.a.get(), c.b(this.b)), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.at
 * JD-Core Version:    0.6.2
 */