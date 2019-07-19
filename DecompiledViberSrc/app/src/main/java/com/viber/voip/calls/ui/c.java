package com.viber.voip.calls.ui;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.calls.d;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import com.viber.voip.util.e.e;
import dagger.a;

public final class c
  implements dagger.b<GroupCallDetailsFragment>
{
  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, Handler paramHandler)
  {
    paramGroupCallDetailsFragment.f = paramHandler;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, com.viber.common.permission.c paramc)
  {
    paramGroupCallDetailsFragment.h = paramc;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, Engine paramEngine)
  {
    paramGroupCallDetailsFragment.c = paramEngine;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, g paramg)
  {
    paramGroupCallDetailsFragment.i = paramg;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, com.viber.voip.app.b paramb)
  {
    paramGroupCallDetailsFragment.m = paramb;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, d paramd)
  {
    paramGroupCallDetailsFragment.d = paramd;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, bs parambs)
  {
    paramGroupCallDetailsFragment.k = parambs;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, com.viber.voip.messages.d.b paramb)
  {
    paramGroupCallDetailsFragment.n = paramb;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, CallHandler paramCallHandler)
  {
    paramGroupCallDetailsFragment.a = paramCallHandler;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, UserManager paramUserManager)
  {
    paramGroupCallDetailsFragment.j = paramUserManager;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, cj paramcj)
  {
    paramGroupCallDetailsFragment.b = paramcj;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, cn paramcn)
  {
    paramGroupCallDetailsFragment.l = paramcn;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, e parame)
  {
    paramGroupCallDetailsFragment.e = parame;
  }

  public static void a(GroupCallDetailsFragment paramGroupCallDetailsFragment, a<h> parama)
  {
    paramGroupCallDetailsFragment.o = parama;
  }

  public static void b(GroupCallDetailsFragment paramGroupCallDetailsFragment, Handler paramHandler)
  {
    paramGroupCallDetailsFragment.g = paramHandler;
  }

  public static void b(GroupCallDetailsFragment paramGroupCallDetailsFragment, a<com.viber.voip.analytics.story.b.a.c> parama)
  {
    paramGroupCallDetailsFragment.p = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.c
 * JD-Core Version:    0.6.2
 */