package com.viber.voip.g.a;

import com.viber.voip.ViberApplication;
import dagger.a.h;
import javax.inject.Provider;

public final class dc
  implements dagger.a.d<com.viber.voip.util.d>
{
  private final Provider<ViberApplication> a;

  public dc(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static dc a(Provider<ViberApplication> paramProvider)
  {
    return new dc(paramProvider);
  }

  public com.viber.voip.util.d a()
  {
    return (com.viber.voip.util.d)h.a(db.a((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dc
 * JD-Core Version:    0.6.2
 */