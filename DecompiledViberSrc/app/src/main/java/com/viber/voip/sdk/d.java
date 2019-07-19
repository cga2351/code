package com.viber.voip.sdk;

import com.viber.voip.block.k;
import com.viber.voip.messages.extras.a.e;
import com.viber.voip.phone.call.DialerPendingController;
import com.viber.voip.w;

public final class d
  implements dagger.b<SdkActivity>
{
  public static void a(SdkActivity paramSdkActivity, com.viber.common.permission.c paramc)
  {
    paramSdkActivity.b = paramc;
  }

  public static void a(SdkActivity paramSdkActivity, com.viber.voip.app.b paramb)
  {
    paramSdkActivity.a = paramb;
  }

  public static void a(SdkActivity paramSdkActivity, k paramk)
  {
    paramSdkActivity.e = paramk;
  }

  public static void a(SdkActivity paramSdkActivity, com.viber.voip.contacts.c.c.b paramb)
  {
    paramSdkActivity.d = paramb;
  }

  public static void a(SdkActivity paramSdkActivity, w paramw)
  {
    paramSdkActivity.c = paramw;
  }

  public static void a(SdkActivity paramSdkActivity, dagger.a<DialerPendingController> parama)
  {
    paramSdkActivity.f = parama;
  }

  public static void b(SdkActivity paramSdkActivity, dagger.a<e> parama)
  {
    paramSdkActivity.g = parama;
  }

  public static void c(SdkActivity paramSdkActivity, dagger.a<com.viber.voip.messages.extras.c.a> parama)
  {
    paramSdkActivity.h = parama;
  }

  public static void d(SdkActivity paramSdkActivity, dagger.a<com.viber.voip.messages.d.b> parama)
  {
    paramSdkActivity.i = parama;
  }

  public static void e(SdkActivity paramSdkActivity, dagger.a<com.viber.voip.analytics.story.d.c> parama)
  {
    paramSdkActivity.j = parama;
  }

  public static void f(SdkActivity paramSdkActivity, dagger.a<com.viber.voip.analytics.story.b.c> parama)
  {
    paramSdkActivity.k = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sdk.d
 * JD-Core Version:    0.6.2
 */