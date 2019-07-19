package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.voip.analytics.story.g.a;
import com.viber.voip.notif.g;
import com.viber.voip.storage.a.i;
import com.viber.voip.storage.repository.p;
import com.viber.voip.storage.repository.u;
import dagger.a.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class dg
  implements d<i>
{
  private final Provider<p> a;
  private final Provider<u> b;
  private final Provider<a> c;
  private final Provider<g> d;
  private final Provider<Handler> e;
  private final Provider<Handler> f;

  public dg(Provider<p> paramProvider, Provider<u> paramProvider1, Provider<a> paramProvider2, Provider<g> paramProvider3, Provider<Handler> paramProvider4, Provider<Handler> paramProvider5)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
    this.f = paramProvider5;
  }

  public static dg a(Provider<p> paramProvider, Provider<u> paramProvider1, Provider<a> paramProvider2, Provider<g> paramProvider3, Provider<Handler> paramProvider4, Provider<Handler> paramProvider5)
  {
    return new dg(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }

  public i a()
  {
    return (i)h.a(df.a((p)this.a.get(), (u)this.b.get(), (a)this.c.get(), c.b(this.d), (Handler)this.e.get(), (Handler)this.f.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dg
 * JD-Core Version:    0.6.2
 */