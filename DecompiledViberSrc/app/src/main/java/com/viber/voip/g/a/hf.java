package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.voip.analytics.g;
import com.viber.voip.util.bx;
import dagger.a.h;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;

public final class hf
  implements dagger.a.d<com.viber.voip.react.d>
{
  private final Provider<bx> a;
  private final Provider<Handler> b;
  private final Provider<EventBus> c;
  private final Provider<g> d;

  public hf(Provider<bx> paramProvider, Provider<Handler> paramProvider1, Provider<EventBus> paramProvider2, Provider<g> paramProvider3)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
  }

  public static hf a(Provider<bx> paramProvider, Provider<Handler> paramProvider1, Provider<EventBus> paramProvider2, Provider<g> paramProvider3)
  {
    return new hf(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }

  public com.viber.voip.react.d a()
  {
    return (com.viber.voip.react.d)h.a(hd.a((bx)this.a.get(), (Handler)this.b.get(), (EventBus)this.c.get(), (g)this.d.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.hf
 * JD-Core Version:    0.6.2
 */