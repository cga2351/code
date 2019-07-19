package com.viber.voip.messages.conversation.chatinfo.presentation;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.conversation.ui.b.q;
import com.viber.voip.messages.k;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.registration.af;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.util.e.e;
import org.greenrobot.eventbus.EventBus;

public final class m
  implements dagger.b<b>
{
  public static void a(b paramb, Handler paramHandler)
  {
    paramb.h = paramHandler;
  }

  public static void a(b paramb, com.viber.common.permission.c paramc)
  {
    paramb.d = paramc;
  }

  public static void a(b paramb, Engine paramEngine)
  {
    paramb.f = paramEngine;
  }

  public static void a(b paramb, PhoneController paramPhoneController)
  {
    paramb.s = paramPhoneController;
  }

  public static void a(b paramb, com.viber.voip.analytics.g paramg)
  {
    paramb.c = paramg;
  }

  public static void a(b paramb, com.viber.voip.analytics.story.e.c paramc)
  {
    paramb.m = paramc;
  }

  public static void a(b paramb, com.viber.voip.app.b paramb1)
  {
    paramb.a = paramb1;
  }

  public static void a(b paramb, com.viber.voip.contacts.c.d.m paramm)
  {
    paramb.i = paramm;
  }

  public static void a(b paramb, com.viber.voip.messages.conversation.chatinfo.b.a parama)
  {
    paramb.l = parama;
  }

  public static void a(b paramb, q paramq)
  {
    paramb.v = paramq;
  }

  public static void a(b paramb, k paramk)
  {
    paramb.b = paramk;
  }

  public static void a(b paramb, CallHandler paramCallHandler)
  {
    paramb.t = paramCallHandler;
  }

  public static void a(b paramb, af paramaf)
  {
    paramb.r = paramaf;
  }

  public static void a(b paramb, OnlineUserActivityHelper paramOnlineUserActivityHelper)
  {
    paramb.u = paramOnlineUserActivityHelper;
  }

  public static void a(b paramb, e parame)
  {
    paramb.n = parame;
  }

  public static void a(b paramb, com.viber.voip.util.e.g paramg)
  {
    paramb.o = paramg;
  }

  public static void a(b paramb, dagger.a<bv> parama)
  {
    paramb.e = parama;
  }

  public static void a(b paramb, EventBus paramEventBus)
  {
    paramb.g = paramEventBus;
  }

  public static void b(b paramb, dagger.a<ConferenceCallsRepository> parama)
  {
    paramb.j = parama;
  }

  public static void c(b paramb, dagger.a<h> parama)
  {
    paramb.k = parama;
  }

  public static void d(b paramb, dagger.a<GroupController> parama)
  {
    paramb.p = parama;
  }

  public static void e(b paramb, dagger.a<com.viber.voip.messages.controller.a> parama)
  {
    paramb.q = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.m
 * JD-Core Version:    0.6.2
 */