package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.extras.c.a;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class fp
  implements d<a>
{
  private final Provider<Context> a;
  private final Provider<g> b;

  public fp(Provider<Context> paramProvider, Provider<g> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static fp a(Provider<Context> paramProvider, Provider<g> paramProvider1)
  {
    return new fp(paramProvider, paramProvider1);
  }

  public a a()
  {
    return (a)h.a(fn.a((Context)this.a.get(), (g)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fp
 * JD-Core Version:    0.6.2
 */