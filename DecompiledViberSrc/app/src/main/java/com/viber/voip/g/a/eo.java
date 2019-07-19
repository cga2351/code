package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.ViberApplication;
import com.viber.voip.notif.f;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class eo
  implements d<f>
{
  private final Provider<Context> a;
  private final Provider<ViberApplication> b;

  public eo(Provider<Context> paramProvider, Provider<ViberApplication> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static eo a(Provider<Context> paramProvider, Provider<ViberApplication> paramProvider1)
  {
    return new eo(paramProvider, paramProvider1);
  }

  public f a()
  {
    return (f)h.a(em.a((Context)this.a.get(), (ViberApplication)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.eo
 * JD-Core Version:    0.6.2
 */