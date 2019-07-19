package com.viber.voip.messages.extensions.b;

import android.os.Handler;
import com.viber.voip.messages.extensions.a;
import dagger.b;
import org.greenrobot.eventbus.EventBus;

public final class l
  implements b<i>
{
  public static void a(i parami, Handler paramHandler)
  {
    parami.d = paramHandler;
  }

  public static void a(i parami, com.viber.voip.analytics.story.c.c paramc)
  {
    parami.e = paramc;
  }

  public static void a(i parami, a parama)
  {
    parami.b = parama;
  }

  public static void a(i parami, com.viber.voip.messages.extensions.c paramc)
  {
    parami.a = paramc;
  }

  public static void a(i parami, EventBus paramEventBus)
  {
    parami.c = paramEventBus;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.b.l
 * JD-Core Version:    0.6.2
 */