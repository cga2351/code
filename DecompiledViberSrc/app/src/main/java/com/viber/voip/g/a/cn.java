package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.voip.contacts.c.d.n;
import com.viber.voip.contacts.c.f.b.f;
import com.viber.voip.engagement.a;
import com.viber.voip.phone.call.CallHandler;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;

public final class cn
  implements d<a>
{
  private final Provider<EventBus> a;
  private final Provider<f> b;
  private final Provider<n> c;
  private final Provider<CallHandler> d;
  private final Provider<Handler> e;

  public cn(Provider<EventBus> paramProvider, Provider<f> paramProvider1, Provider<n> paramProvider2, Provider<CallHandler> paramProvider3, Provider<Handler> paramProvider4)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
  }

  public static cn a(Provider<EventBus> paramProvider, Provider<f> paramProvider1, Provider<n> paramProvider2, Provider<CallHandler> paramProvider3, Provider<Handler> paramProvider4)
  {
    return new cn(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }

  public a a()
  {
    return (a)h.a(cl.a((EventBus)this.a.get(), (f)this.b.get(), (n)this.c.get(), (CallHandler)this.d.get(), (Handler)this.e.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.cn
 * JD-Core Version:    0.6.2
 */