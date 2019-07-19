package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.voip.util.az;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class gj
  implements d<az>
{
  private final Provider<Handler> a;
  private final Provider<Handler> b;

  public gj(Provider<Handler> paramProvider1, Provider<Handler> paramProvider2)
  {
    this.a = paramProvider1;
    this.b = paramProvider2;
  }

  public static gj a(Provider<Handler> paramProvider1, Provider<Handler> paramProvider2)
  {
    return new gj(paramProvider1, paramProvider2);
  }

  public static az a(Handler paramHandler1, Handler paramHandler2)
  {
    return (az)h.a(gd.a(paramHandler1, paramHandler2), "Cannot return null from a non-@Nullable @Provides method");
  }

  public az a()
  {
    return (az)h.a(gd.a((Handler)this.a.get(), (Handler)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gj
 * JD-Core Version:    0.6.2
 */