package com.viber.voip.contacts.ui.list;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import com.viber.voip.util.e.e;
import dagger.a;

public final class m
  implements dagger.b<l>
{
  public static void a(l paraml, Handler paramHandler)
  {
    paraml.a = paramHandler;
  }

  public static void a(l paraml, com.viber.common.permission.c paramc)
  {
    paraml.i = paramc;
  }

  public static void a(l paraml, Engine paramEngine)
  {
    paraml.g = paramEngine;
  }

  public static void a(l paraml, PhoneController paramPhoneController)
  {
    paraml.d = paramPhoneController;
  }

  public static void a(l paraml, bs parambs)
  {
    paraml.k = parambs;
  }

  public static void a(l paraml, com.viber.voip.messages.d.b paramb)
  {
    paraml.n = paramb;
  }

  public static void a(l paraml, CallHandler paramCallHandler)
  {
    paraml.c = paramCallHandler;
  }

  public static void a(l paraml, ConferenceParticipantMapper paramConferenceParticipantMapper)
  {
    paraml.m = paramConferenceParticipantMapper;
  }

  public static void a(l paraml, OnlineUserActivityHelper paramOnlineUserActivityHelper)
  {
    paraml.e = paramOnlineUserActivityHelper;
  }

  public static void a(l paraml, UserManager paramUserManager)
  {
    paraml.j = paramUserManager;
  }

  public static void a(l paraml, cj paramcj)
  {
    paraml.f = paramcj;
  }

  public static void a(l paraml, cn paramcn)
  {
    paraml.l = paramcn;
  }

  public static void a(l paraml, e parame)
  {
    paraml.h = parame;
  }

  public static void a(l paraml, a<h> parama)
  {
    paraml.o = parama;
  }

  public static void b(l paraml, Handler paramHandler)
  {
    paraml.b = paramHandler;
  }

  public static void b(l paraml, a<com.viber.voip.analytics.story.b.a.c> parama)
  {
    paraml.p = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.m
 * JD-Core Version:    0.6.2
 */