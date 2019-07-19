package com.viber.voip.g.a;

import android.app.Application;
import com.viber.voip.ViberApplication;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ai
  implements d<Application>
{
  private final Provider<ViberApplication> a;

  public ai(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static ai a(Provider<ViberApplication> paramProvider)
  {
    return new ai(paramProvider);
  }

  public Application a()
  {
    return (Application)h.a(ag.b((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ai
 * JD-Core Version:    0.6.2
 */