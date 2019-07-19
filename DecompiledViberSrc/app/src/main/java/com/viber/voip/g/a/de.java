package com.viber.voip.g.a;

import android.content.Context;
import com.viber.jni.Engine;
import com.viber.voip.vln.e;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;

public final class de
  implements d<com.viber.voip.l.a>
{
  private final Provider<Context> a;
  private final Provider<Engine> b;
  private final Provider<EventBus> c;
  private final Provider<com.viber.voip.analytics.story.g.a> d;
  private final Provider<e> e;

  public de(Provider<Context> paramProvider, Provider<Engine> paramProvider1, Provider<EventBus> paramProvider2, Provider<com.viber.voip.analytics.story.g.a> paramProvider3, Provider<e> paramProvider4)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
  }

  public static de a(Provider<Context> paramProvider, Provider<Engine> paramProvider1, Provider<EventBus> paramProvider2, Provider<com.viber.voip.analytics.story.g.a> paramProvider3, Provider<e> paramProvider4)
  {
    return new de(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }

  public com.viber.voip.l.a a()
  {
    return (com.viber.voip.l.a)h.a(dd.a((Context)this.a.get(), (Engine)this.b.get(), (EventBus)this.c.get(), (com.viber.voip.analytics.story.g.a)this.d.get(), (e)this.e.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.de
 * JD-Core Version:    0.6.2
 */