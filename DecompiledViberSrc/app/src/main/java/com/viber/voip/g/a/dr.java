package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.messages.controller.bs;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class dr
  implements d<bs>
{
  private final Provider<Context> a;

  public dr(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static dr a(Provider<Context> paramProvider)
  {
    return new dr(paramProvider);
  }

  public static bs a(Context paramContext)
  {
    return (bs)h.a(dj.a(paramContext), "Cannot return null from a non-@Nullable @Provides method");
  }

  public bs a()
  {
    return (bs)h.a(dj.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dr
 * JD-Core Version:    0.6.2
 */