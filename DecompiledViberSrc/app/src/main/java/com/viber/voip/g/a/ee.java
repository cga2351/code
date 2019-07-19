package com.viber.voip.g.a;

import com.viber.voip.ViberApplication;
import com.viber.voip.util.ap;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ee
  implements d<ap>
{
  private final Provider<ViberApplication> a;

  public ee(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static ee a(Provider<ViberApplication> paramProvider)
  {
    return new ee(paramProvider);
  }

  public ap a()
  {
    return (ap)h.a(ec.a((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ee
 * JD-Core Version:    0.6.2
 */