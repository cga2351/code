package com.viber.voip.g.a;

import android.content.Context;
import android.content.res.Resources;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ak
  implements d<Resources>
{
  private final Provider<Context> a;

  public ak(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static Resources a(Context paramContext)
  {
    return (Resources)h.a(ag.a(paramContext), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ak a(Provider<Context> paramProvider)
  {
    return new ak(paramProvider);
  }

  public Resources a()
  {
    return (Resources)h.a(ag.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ak
 * JD-Core Version:    0.6.2
 */