package com.viber.voip.settings.ui;

import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ui.j.av;

public final class j
  implements dagger.b<i>
{
  public static void a(i parami, ICdrController paramICdrController)
  {
    parami.e = paramICdrController;
  }

  public static void a(i parami, com.viber.voip.app.b paramb)
  {
    parami.b = paramb;
  }

  public static void a(i parami, dagger.a<av> parama)
  {
    parami.c = parama;
  }

  public static void b(i parami, dagger.a<com.viber.voip.analytics.story.g.a> parama)
  {
    parami.d = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.j
 * JD-Core Version:    0.6.2
 */