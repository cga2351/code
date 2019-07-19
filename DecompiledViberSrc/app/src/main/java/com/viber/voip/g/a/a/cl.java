package com.viber.voip.g.a.a;

import com.viber.voip.ViberApplication;
import com.viber.voip.messages.extras.b.a;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class cl
  implements d<a>
{
  private final Provider<ViberApplication> a;

  public cl(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static cl a(Provider<ViberApplication> paramProvider)
  {
    return new cl(paramProvider);
  }

  public a a()
  {
    return (a)h.a(ck.a((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.cl
 * JD-Core Version:    0.6.2
 */