package com.viber.voip.g.a;

import android.content.Context;
import android.os.Handler;
import com.viber.voip.ads.s;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class q
  implements d<s>
{
  private final Provider<Context> a;
  private final Provider<Handler> b;

  public q(Provider<Context> paramProvider, Provider<Handler> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static q a(Provider<Context> paramProvider, Provider<Handler> paramProvider1)
  {
    return new q(paramProvider, paramProvider1);
  }

  public s a()
  {
    return (s)h.a(c.a((Context)this.a.get(), (Handler)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.q
 * JD-Core Version:    0.6.2
 */