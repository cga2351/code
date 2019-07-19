package com.viber.voip.messages.ui;

import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.c;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.controller.cl;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.util.cj;
import dagger.b;

public final class bu
  implements b<bk>
{
  public static void a(bk parambk, ICdrController paramICdrController)
  {
    parambk.w = paramICdrController;
  }

  public static void a(bk parambk, com.viber.voip.analytics.story.a.a parama)
  {
    parambk.y = parama;
  }

  public static void a(bk parambk, c paramc)
  {
    parambk.x = paramc;
  }

  public static void a(bk parambk, e parame)
  {
    parambk.B = parame;
  }

  public static void a(bk parambk, dagger.a<CallHandler> parama)
  {
    parambk.r = parama;
  }

  public static void b(bk parambk, dagger.a<ConferenceCallsRepository> parama)
  {
    parambk.s = parama;
  }

  public static void c(bk parambk, dagger.a<cj> parama)
  {
    parambk.t = parama;
  }

  public static void d(bk parambk, dagger.a<Engine> parama)
  {
    parambk.u = parama;
  }

  public static void e(bk parambk, dagger.a<com.viber.voip.notif.g> parama)
  {
    parambk.v = parama;
  }

  public static void f(bk parambk, dagger.a<com.viber.voip.analytics.g> parama)
  {
    parambk.z = parama;
  }

  public static void g(bk parambk, dagger.a<h> parama)
  {
    parambk.A = parama;
  }

  public static void h(bk parambk, dagger.a<cl> parama)
  {
    parambk.C = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.bu
 * JD-Core Version:    0.6.2
 */