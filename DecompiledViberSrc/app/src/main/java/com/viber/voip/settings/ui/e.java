package com.viber.voip.settings.ui;

import com.viber.voip.analytics.g;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.notif.e.m;
import com.viber.voip.ui.j.av;
import com.viber.voip.user.UserManager;
import dagger.a;

public final class e
  implements dagger.b<d>
{
  public static void a(d paramd, com.viber.voip.app.b paramb)
  {
    paramd.d = paramb;
  }

  public static void a(d paramd, m paramm)
  {
    paramd.h = paramm;
  }

  public static void a(d paramd, UserManager paramUserManager)
  {
    paramd.c = paramUserManager;
  }

  public static void a(d paramd, com.viber.voip.vln.e parame)
  {
    paramd.b = parame;
  }

  public static void a(d paramd, a<av> parama)
  {
    paramd.e = parama;
  }

  public static void b(d paramd, a<g> parama)
  {
    paramd.f = parama;
  }

  public static void c(d paramd, a<bn> parama)
  {
    paramd.g = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.e
 * JD-Core Version:    0.6.2
 */