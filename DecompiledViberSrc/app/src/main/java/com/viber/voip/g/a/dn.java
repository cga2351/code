package com.viber.voip.g.a;

import com.viber.voip.messages.k;
import dagger.a.h;
import javax.inject.Provider;

public final class dn
  implements dagger.a.d<com.viber.voip.invitelinks.d>
{
  private final Provider<k> a;

  public dn(Provider<k> paramProvider)
  {
    this.a = paramProvider;
  }

  public static dn a(Provider<k> paramProvider)
  {
    return new dn(paramProvider);
  }

  public static com.viber.voip.invitelinks.d a(k paramk)
  {
    return (com.viber.voip.invitelinks.d)h.a(dj.k(paramk), "Cannot return null from a non-@Nullable @Provides method");
  }

  public com.viber.voip.invitelinks.d a()
  {
    return (com.viber.voip.invitelinks.d)h.a(dj.k((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dn
 * JD-Core Version:    0.6.2
 */