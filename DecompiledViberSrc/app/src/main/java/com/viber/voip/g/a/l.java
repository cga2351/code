package com.viber.voip.g.a;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ads.b.a.a.a.b;
import com.viber.voip.ads.b.c.b.f;
import com.viber.voip.ads.s;
import com.viber.voip.util.cj;
import dagger.a.d;
import javax.inject.Provider;

public final class l
  implements d<f>
{
  private final Provider<com.viber.voip.ads.b.b.d.a<b>> a;
  private final Provider<Handler> b;
  private final Provider<Handler> c;
  private final Provider<com.viber.common.permission.c> d;
  private final Provider<ViberApplication> e;
  private final Provider<PhoneController> f;
  private final Provider<ICdrController> g;
  private final Provider<com.viber.voip.util.i.c> h;
  private final Provider<com.viber.voip.analytics.story.g.a> i;
  private final Provider<cj> j;
  private final Provider<s> k;
  private final Provider<com.viber.voip.ads.h> l;
  private final Provider<Context> m;

  public l(Provider<com.viber.voip.ads.b.b.d.a<b>> paramProvider, Provider<Handler> paramProvider1, Provider<Handler> paramProvider2, Provider<com.viber.common.permission.c> paramProvider3, Provider<ViberApplication> paramProvider4, Provider<PhoneController> paramProvider5, Provider<ICdrController> paramProvider6, Provider<com.viber.voip.util.i.c> paramProvider7, Provider<com.viber.voip.analytics.story.g.a> paramProvider8, Provider<cj> paramProvider9, Provider<s> paramProvider10, Provider<com.viber.voip.ads.h> paramProvider11, Provider<Context> paramProvider12)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
    this.f = paramProvider5;
    this.g = paramProvider6;
    this.h = paramProvider7;
    this.i = paramProvider8;
    this.j = paramProvider9;
    this.k = paramProvider10;
    this.l = paramProvider11;
    this.m = paramProvider12;
  }

  public static l a(Provider<com.viber.voip.ads.b.b.d.a<b>> paramProvider, Provider<Handler> paramProvider1, Provider<Handler> paramProvider2, Provider<com.viber.common.permission.c> paramProvider3, Provider<ViberApplication> paramProvider4, Provider<PhoneController> paramProvider5, Provider<ICdrController> paramProvider6, Provider<com.viber.voip.util.i.c> paramProvider7, Provider<com.viber.voip.analytics.story.g.a> paramProvider8, Provider<cj> paramProvider9, Provider<s> paramProvider10, Provider<com.viber.voip.ads.h> paramProvider11, Provider<Context> paramProvider12)
  {
    return new l(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7, paramProvider8, paramProvider9, paramProvider10, paramProvider11, paramProvider12);
  }

  public f a()
  {
    return (f)dagger.a.h.a(c.d((com.viber.voip.ads.b.b.d.a)this.a.get(), (Handler)this.b.get(), (Handler)this.c.get(), (com.viber.common.permission.c)this.d.get(), (ViberApplication)this.e.get(), (PhoneController)this.f.get(), (ICdrController)this.g.get(), (com.viber.voip.util.i.c)this.h.get(), (com.viber.voip.analytics.story.g.a)this.i.get(), (cj)this.j.get(), (s)this.k.get(), (com.viber.voip.ads.h)this.l.get(), (Context)this.m.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.l
 * JD-Core Version:    0.6.2
 */