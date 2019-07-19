package com.viber.voip.contacts.ui.list;

import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.invitelinks.d;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.k;

public final class af
  implements dagger.b<ae>
{
  public static void a(ae paramae, com.viber.common.permission.c paramc)
  {
    paramae.l = paramc;
  }

  public static void a(ae paramae, EngineDelegatesManager paramEngineDelegatesManager)
  {
    paramae.h = paramEngineDelegatesManager;
  }

  public static void a(ae paramae, PhoneController paramPhoneController)
  {
    paramae.g = paramPhoneController;
  }

  public static void a(ae paramae, Im2Exchanger paramIm2Exchanger)
  {
    paramae.m = paramIm2Exchanger;
  }

  public static void a(ae paramae, com.viber.voip.analytics.story.e.c paramc)
  {
    paramae.b = paramc;
  }

  public static void a(ae paramae, com.viber.voip.app.b paramb)
  {
    paramae.a = paramb;
  }

  public static void a(ae paramae, m paramm)
  {
    paramae.j = paramm;
  }

  public static void a(ae paramae, d paramd)
  {
    paramae.c = paramd;
  }

  public static void a(ae paramae, dagger.a<k> parama)
  {
    paramae.d = parama;
  }

  public static void b(ae paramae, dagger.a<GroupController> parama)
  {
    paramae.e = parama;
  }

  public static void c(ae paramae, dagger.a<com.viber.voip.messages.controller.a> parama)
  {
    paramae.f = parama;
  }

  public static void d(ae paramae, dagger.a<bv> parama)
  {
    paramae.i = parama;
  }

  public static void e(ae paramae, dagger.a<h> parama)
  {
    paramae.k = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.af
 * JD-Core Version:    0.6.2
 */