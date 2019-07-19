package com.viber.voip.g.a;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberApplication;
import com.viber.voip.ads.b.a.a.m;
import com.viber.voip.ads.b.b.b.c.a;
import com.viber.voip.ads.b.c.b.d;
import com.viber.voip.ads.h;
import com.viber.voip.ads.s;
import com.viber.voip.ads.t;
import com.viber.voip.banner.a.a.g;
import com.viber.voip.banner.i;
import com.viber.voip.i.c.b;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.c;
import com.viber.voip.util.ap;
import com.viber.voip.util.cj;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.f.b;
import javax.inject.Named;
import javax.inject.Singleton;

public abstract class c
{
  @Singleton
  static com.viber.voip.ads.a.b a(dagger.a<Engine> parama, com.viber.voip.util.i.e parame, Im2Exchanger paramIm2Exchanger, PhoneController paramPhoneController, Handler paramHandler, af paramaf, com.google.d.f paramf)
  {
    com.viber.voip.ads.a.b localb = new com.viber.voip.ads.a.b(parama, d.c.a, d.c.b, d.c.c, paramf, parame, paramIm2Exchanger, paramPhoneController, paramHandler, paramaf);
    localb.a();
    return localb;
  }

  @Singleton
  static m a(ap paramap)
  {
    return new m(paramap);
  }

  @Singleton
  static com.viber.voip.ads.b.b.c.b<com.viber.voip.ads.b.a.a.a.b> a(m paramm)
  {
    return new com.viber.voip.ads.b.a.c.a(paramm, c.a.a());
  }

  static com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> a(com.viber.voip.ads.b.b.c.b<com.viber.voip.ads.b.a.a.a.b> paramb)
  {
    return new com.viber.voip.ads.b.b.d.a(paramb);
  }

  @Singleton
  static com.viber.voip.ads.b.c.a.b a(com.viber.voip.util.e.e parame, @Named("com.viber.voip.ListingAdIconImageFetcherConfig") com.viber.voip.util.e.f paramf1, @Named("com.viber.voip.ListingAdProviderIconImageFetcherConfig") com.viber.voip.util.e.f paramf2)
  {
    return new com.viber.voip.ads.b.c.a.b(parame, paramf1, paramf2);
  }

  @Named("com.viber.voip.BusinessInboxAdsController")
  @Singleton
  static com.viber.voip.ads.b.c.b.f a(com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> parama, Handler paramHandler1, Handler paramHandler2, com.viber.common.permission.c paramc, ViberApplication paramViberApplication, PhoneController paramPhoneController, ICdrController paramICdrController, com.viber.voip.util.i.c paramc1, com.viber.voip.analytics.story.g.a parama1, cj paramcj, s params, @Named("com.viber.voip.GoogleAdsTracker") h paramh, Context paramContext)
  {
    return new com.viber.voip.ads.b.c.b.a(paramContext, com.viber.voip.ads.b.b.b.c.e, c.a.a(), c.b.m, parama, new g(0), paramHandler1, paramHandler2, paramc, paramPhoneController, paramICdrController, new com.viber.voip.ads.b.c.c.a.b(), com.adsnative.a.b(), paramViberApplication.getLocationManager(), paramcj, paramc1, parama1, c.b.r, params, paramh);
  }

  @Named("com.viber.voip.GoogleAdsTracker")
  static h a(Context paramContext, PhoneController paramPhoneController, ICdrController paramICdrController, Handler paramHandler)
  {
    return new h(paramContext, paramPhoneController, paramICdrController, 2, paramHandler, "");
  }

  static s a(Context paramContext, Handler paramHandler)
  {
    return new t(paramContext, paramHandler);
  }

  static i a()
  {
    return i.a();
  }

  @Named("com.viber.voip.CallsTabAdsController")
  @Singleton
  static com.viber.voip.ads.b.c.b.f b(com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> parama, Handler paramHandler1, Handler paramHandler2, com.viber.common.permission.c paramc, ViberApplication paramViberApplication, PhoneController paramPhoneController, ICdrController paramICdrController, com.viber.voip.util.i.c paramc1, com.viber.voip.analytics.story.g.a parama1, cj paramcj, s params, @Named("com.viber.voip.GoogleAdsTracker") h paramh, Context paramContext)
  {
    return new com.viber.voip.ads.b.c.b.b(paramContext, com.viber.voip.ads.b.b.b.c.h, c.a.a(), c.b.n, parama, paramHandler1, paramHandler2, paramc, paramPhoneController, paramICdrController, new com.viber.voip.ads.b.c.c.a.b(), com.adsnative.a.b(), paramViberApplication.getLocationManager(), paramc1, parama1, paramcj, c.b.s, params, paramh);
  }

  @Named("com.viber.voip.ListingAdIconImageFetcherConfig")
  @Singleton
  static com.viber.voip.util.e.f b()
  {
    return new f.a().a(Integer.valueOf(R.drawable.ad_icon_placeholder)).b(Integer.valueOf(R.drawable.ad_icon_placeholder)).a(f.b.b).c();
  }

  @Named("com.viber.voip.ChatListAdsController")
  @Singleton
  static com.viber.voip.ads.b.c.b.f c(com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> parama, Handler paramHandler1, Handler paramHandler2, com.viber.common.permission.c paramc, ViberApplication paramViberApplication, PhoneController paramPhoneController, ICdrController paramICdrController, com.viber.voip.util.i.c paramc1, com.viber.voip.analytics.story.g.a parama1, cj paramcj, s params, @Named("com.viber.voip.GoogleAdsTracker") h paramh, Context paramContext)
  {
    return new d(paramContext, com.viber.voip.ads.b.b.b.c.i, c.a.a(), c.b.o, parama, paramHandler1, paramHandler2, paramc, paramPhoneController, paramICdrController, new com.viber.voip.ads.b.c.c.a.b(), com.adsnative.a.b(), paramViberApplication.getLocationManager(), paramc1, parama1, paramcj, c.b.p, c.b.s, params, paramh);
  }

  @Named("com.viber.voip.ListingAdProviderIconImageFetcherConfig")
  @Singleton
  static com.viber.voip.util.e.f c()
  {
    return new f.a().a(f.b.a).c();
  }

  @Named("com.viber.voip.ChatExtAdsController")
  @Singleton
  static com.viber.voip.ads.b.c.b.f d(com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> parama, Handler paramHandler1, Handler paramHandler2, com.viber.common.permission.c paramc, ViberApplication paramViberApplication, PhoneController paramPhoneController, ICdrController paramICdrController, com.viber.voip.util.i.c paramc1, com.viber.voip.analytics.story.g.a parama1, cj paramcj, s params, @Named("com.viber.voip.GoogleAdsTracker") h paramh, Context paramContext)
  {
    return new com.viber.voip.ads.b.c.b.c(paramContext, com.viber.voip.ads.b.b.b.c.j, c.a.a(), c.b.q, parama, paramHandler1, paramHandler2, paramc, paramPhoneController, paramICdrController, new com.viber.voip.ads.b.c.c.a.b(), com.adsnative.a.b(), paramViberApplication.getLocationManager(), paramc1, parama1, paramcj, c.b.s, params, paramh);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.c
 * JD-Core Version:    0.6.2
 */