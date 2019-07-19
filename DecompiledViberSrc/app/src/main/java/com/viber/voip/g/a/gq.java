package com.viber.voip.g.a;

import com.viber.voip.ViberApplication;
import com.viber.voip.messages.ui.media.player.d.e;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class gq
  implements d<e>
{
  private final Provider<ViberApplication> a;

  public gq(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static gq a(Provider<ViberApplication> paramProvider)
  {
    return new gq(paramProvider);
  }

  public e a()
  {
    return (e)h.a(go.a((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gq
 * JD-Core Version:    0.6.2
 */