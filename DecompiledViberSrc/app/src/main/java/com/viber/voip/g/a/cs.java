package com.viber.voip.g.a;

import com.viber.voip.ViberApplication;
import com.viber.voip.news.q;
import com.viber.voip.ui.f.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class cs
  implements d<c>
{
  private final Provider<ViberApplication> a;
  private final Provider<q> b;

  public static c a(ViberApplication paramViberApplication, q paramq)
  {
    return (c)h.a(cp.a(paramViberApplication, paramq), "Cannot return null from a non-@Nullable @Provides method");
  }

  public c a()
  {
    return (c)h.a(cp.a((ViberApplication)this.a.get(), (q)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.cs
 * JD-Core Version:    0.6.2
 */