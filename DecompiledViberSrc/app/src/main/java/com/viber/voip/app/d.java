package com.viber.voip.app;

import android.content.Context;
import dagger.a.c;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;

public final class d
  implements dagger.a.d<b>
{
  private final Provider<Context> a;
  private final Provider<EventBus> b;

  public d(Provider<Context> paramProvider, Provider<EventBus> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static d a(Provider<Context> paramProvider, Provider<EventBus> paramProvider1)
  {
    return new d(paramProvider, paramProvider1);
  }

  public b a()
  {
    return new b((Context)this.a.get(), c.b(this.b));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.app.d
 * JD-Core Version:    0.6.2
 */