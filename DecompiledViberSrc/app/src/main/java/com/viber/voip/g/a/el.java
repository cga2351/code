package com.viber.voip.g.a;

import android.content.Context;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.analytics.g;
import com.viber.voip.app.b;
import com.viber.voip.news.q;
import com.viber.voip.util.cv;
import dagger.a.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class el
  implements d<q>
{
  private final Provider<Context> a;
  private final Provider<g> b;
  private final Provider<b> c;
  private final Provider<cv> d;
  private final Provider<ICdrController> e;

  public el(Provider<Context> paramProvider, Provider<g> paramProvider1, Provider<b> paramProvider2, Provider<cv> paramProvider3, Provider<ICdrController> paramProvider4)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
  }

  public static el a(Provider<Context> paramProvider, Provider<g> paramProvider1, Provider<b> paramProvider2, Provider<cv> paramProvider3, Provider<ICdrController> paramProvider4)
  {
    return new el(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }

  public q a()
  {
    return (q)h.a(ei.a((Context)this.a.get(), (g)this.b.get(), (b)this.c.get(), c.b(this.d), c.b(this.e)), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.el
 * JD-Core Version:    0.6.2
 */