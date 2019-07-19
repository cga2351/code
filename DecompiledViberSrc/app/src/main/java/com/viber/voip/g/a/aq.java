package com.viber.voip.g.a;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.backup.f;
import com.viber.voip.backup.g;
import dagger.a.d;
import javax.inject.Provider;

public final class aq
  implements d<com.viber.voip.backup.h>
{
  private final Provider<Context> a;
  private final Provider<g> b;
  private final Provider<f> c;
  private final Provider<Handler> d;
  private final Provider<Engine> e;

  public aq(Provider<Context> paramProvider, Provider<g> paramProvider1, Provider<f> paramProvider2, Provider<Handler> paramProvider3, Provider<Engine> paramProvider4)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
  }

  public static aq a(Provider<Context> paramProvider, Provider<g> paramProvider1, Provider<f> paramProvider2, Provider<Handler> paramProvider3, Provider<Engine> paramProvider4)
  {
    return new aq(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }

  public com.viber.voip.backup.h a()
  {
    return (com.viber.voip.backup.h)dagger.a.h.a(al.a((Context)this.a.get(), (g)this.b.get(), (f)this.c.get(), (Handler)this.d.get(), (Engine)this.e.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.aq
 * JD-Core Version:    0.6.2
 */