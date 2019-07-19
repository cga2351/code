package com.viber.voip.messages.conversation.ui;

import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.invitelinks.q;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.cl;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.y;
import com.viber.voip.messages.k;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import org.greenrobot.eventbus.EventBus;

public final class aw
  implements dagger.b<ConversationFragment>
{
  public static void a(ConversationFragment paramConversationFragment, com.viber.common.permission.c paramc)
  {
    paramConversationFragment.aa = paramc;
  }

  public static void a(ConversationFragment paramConversationFragment, Engine paramEngine)
  {
    paramConversationFragment.S = paramEngine;
  }

  public static void a(ConversationFragment paramConversationFragment, ICdrController paramICdrController)
  {
    paramConversationFragment.V = paramICdrController;
  }

  public static void a(ConversationFragment paramConversationFragment, PhoneController paramPhoneController)
  {
    paramConversationFragment.T = paramPhoneController;
  }

  public static void a(ConversationFragment paramConversationFragment, Im2Exchanger paramIm2Exchanger)
  {
    paramConversationFragment.U = paramIm2Exchanger;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.analytics.g paramg)
  {
    paramConversationFragment.G = paramg;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.analytics.story.a.a parama)
  {
    paramConversationFragment.J = parama;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.analytics.story.b.c paramc)
  {
    paramConversationFragment.K = paramc;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.analytics.story.d.c paramc)
  {
    paramConversationFragment.H = paramc;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.analytics.story.e.c paramc)
  {
    paramConversationFragment.I = paramc;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.analytics.story.f.d paramd)
  {
    paramConversationFragment.L = paramd;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.app.b paramb)
  {
    paramConversationFragment.R = paramb;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.banner.i parami)
  {
    paramConversationFragment.Y = parami;
  }

  public static void a(ConversationFragment paramConversationFragment, m paramm)
  {
    paramConversationFragment.O = paramm;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.invitelinks.d paramd)
  {
    paramConversationFragment.Q = paramd;
  }

  public static void a(ConversationFragment paramConversationFragment, ai paramai)
  {
    paramConversationFragment.P = paramai;
  }

  public static void a(ConversationFragment paramConversationFragment, o paramo)
  {
    paramConversationFragment.Z = paramo;
  }

  public static void a(ConversationFragment paramConversationFragment, y paramy)
  {
    paramConversationFragment.D = paramy;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.messages.d.b paramb)
  {
    paramConversationFragment.N = paramb;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.messages.extensions.c paramc)
  {
    paramConversationFragment.ab = paramc;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.messages.extensions.i parami)
  {
    paramConversationFragment.af = parami;
  }

  public static void a(ConversationFragment paramConversationFragment, CallHandler paramCallHandler)
  {
    paramConversationFragment.bf = paramCallHandler;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.q.i parami)
  {
    paramConversationFragment.E = parami;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.stickers.a.a parama)
  {
    paramConversationFragment.B = parama;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.stickers.b paramb)
  {
    paramConversationFragment.z = paramb;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.stickers.f paramf)
  {
    paramConversationFragment.A = paramf;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.stickers.i parami)
  {
    paramConversationFragment.C = parami;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.u.d paramd)
  {
    paramConversationFragment.F = paramd;
  }

  public static void a(ConversationFragment paramConversationFragment, UserData paramUserData)
  {
    paramConversationFragment.M = paramUserData;
  }

  public static void a(ConversationFragment paramConversationFragment, UserManager paramUserManager)
  {
    paramConversationFragment.ad = paramUserManager;
  }

  public static void a(ConversationFragment paramConversationFragment, com.viber.voip.util.e.g paramg)
  {
    paramConversationFragment.ai = paramg;
  }

  public static void a(ConversationFragment paramConversationFragment, dagger.a<k> parama)
  {
    paramConversationFragment.W = parama;
  }

  public static void a(ConversationFragment paramConversationFragment, EventBus paramEventBus)
  {
    paramConversationFragment.ah = paramEventBus;
  }

  public static void b(ConversationFragment paramConversationFragment, dagger.a<com.viber.voip.messages.controller.publicaccount.d> parama)
  {
    paramConversationFragment.X = parama;
  }

  public static void c(ConversationFragment paramConversationFragment, dagger.a<h> parama)
  {
    paramConversationFragment.ac = parama;
  }

  public static void d(ConversationFragment paramConversationFragment, dagger.a<com.viber.voip.messages.controller.a> parama)
  {
    paramConversationFragment.ae = parama;
  }

  public static void e(ConversationFragment paramConversationFragment, dagger.a<com.viber.voip.notif.f> parama)
  {
    paramConversationFragment.ag = parama;
  }

  public static void f(ConversationFragment paramConversationFragment, dagger.a<q> parama)
  {
    paramConversationFragment.aj = parama;
  }

  public static void g(ConversationFragment paramConversationFragment, dagger.a<cl> parama)
  {
    paramConversationFragment.ak = parama;
  }

  public static void h(ConversationFragment paramConversationFragment, dagger.a<ConferenceCallsRepository> parama)
  {
    paramConversationFragment.be = parama;
  }

  public static void i(ConversationFragment paramConversationFragment, dagger.a<com.viber.voip.notif.g> parama)
  {
    paramConversationFragment.bg = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.aw
 * JD-Core Version:    0.6.2
 */