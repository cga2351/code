package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.ViberApplication;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ah
  implements d<Context>
{
  private final Provider<ViberApplication> a;

  public ah(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static Context a(ViberApplication paramViberApplication)
  {
    return (Context)h.a(ag.a(paramViberApplication), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ah a(Provider<ViberApplication> paramProvider)
  {
    return new ah(paramProvider);
  }

  public Context a()
  {
    return (Context)h.a(ag.a((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ah
 * JD-Core Version:    0.6.2
 */