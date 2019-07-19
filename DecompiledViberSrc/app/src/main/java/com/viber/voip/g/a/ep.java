package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.notif.g;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ep
  implements d<g>
{
  private final Provider<Context> a;

  public ep(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static ep a(Provider<Context> paramProvider)
  {
    return new ep(paramProvider);
  }

  public static g a(Context paramContext)
  {
    return (g)h.a(em.a(paramContext), "Cannot return null from a non-@Nullable @Provides method");
  }

  public g a()
  {
    return (g)h.a(em.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ep
 * JD-Core Version:    0.6.2
 */