package com.viber.voip.g.a;

import com.viber.voip.ViberApplication;
import com.viber.voip.contacts.c.d.g;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bm
  implements d<g>
{
  private final Provider<ViberApplication> a;

  public bm(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static g a(ViberApplication paramViberApplication)
  {
    return (g)h.a(bk.a(paramViberApplication), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static bm a(Provider<ViberApplication> paramProvider)
  {
    return new bm(paramProvider);
  }

  public g a()
  {
    return (g)h.a(bk.a((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bm
 * JD-Core Version:    0.6.2
 */