package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.voip.engagement.b;
import com.viber.voip.messages.controller.y;
import com.viber.voip.stickers.i;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bz
  implements d<b>
{
  private final Provider<Handler> a;
  private final Provider<Handler> b;
  private final Provider<i> c;
  private final Provider<y> d;

  public bz(Provider<Handler> paramProvider1, Provider<Handler> paramProvider2, Provider<i> paramProvider, Provider<y> paramProvider3)
  {
    this.a = paramProvider1;
    this.b = paramProvider2;
    this.c = paramProvider;
    this.d = paramProvider3;
  }

  public static bz a(Provider<Handler> paramProvider1, Provider<Handler> paramProvider2, Provider<i> paramProvider, Provider<y> paramProvider3)
  {
    return new bz(paramProvider1, paramProvider2, paramProvider, paramProvider3);
  }

  public b a()
  {
    return (b)h.a(by.a((Handler)this.a.get(), (Handler)this.b.get(), (i)this.c.get(), (y)this.d.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bz
 * JD-Core Version:    0.6.2
 */