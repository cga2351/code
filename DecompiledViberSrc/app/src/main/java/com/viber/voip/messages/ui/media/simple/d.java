package com.viber.voip.messages.ui.media.simple;

import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.extras.a.e;
import dagger.a;
import dagger.b;
import java.util.concurrent.ScheduledExecutorService;

public final class d
  implements b<ViewMediaSimpleActivity>
{
  public static void a(ViewMediaSimpleActivity paramViewMediaSimpleActivity, com.viber.voip.invitelinks.d paramd)
  {
    paramViewMediaSimpleActivity.d = paramd;
  }

  public static void a(ViewMediaSimpleActivity paramViewMediaSimpleActivity, ai paramai)
  {
    paramViewMediaSimpleActivity.c = paramai;
  }

  public static void a(ViewMediaSimpleActivity paramViewMediaSimpleActivity, com.viber.voip.messages.controller.manager.c paramc)
  {
    paramViewMediaSimpleActivity.b = paramc;
  }

  public static void a(ViewMediaSimpleActivity paramViewMediaSimpleActivity, com.viber.voip.messages.extensions.c paramc)
  {
    paramViewMediaSimpleActivity.a = paramc;
  }

  public static void a(ViewMediaSimpleActivity paramViewMediaSimpleActivity, e parame)
  {
    paramViewMediaSimpleActivity.e = parame;
  }

  public static void a(ViewMediaSimpleActivity paramViewMediaSimpleActivity, a<com.viber.voip.analytics.story.e.c> parama)
  {
    paramViewMediaSimpleActivity.f = parama;
  }

  public static void a(ViewMediaSimpleActivity paramViewMediaSimpleActivity, ScheduledExecutorService paramScheduledExecutorService)
  {
    paramViewMediaSimpleActivity.g = paramScheduledExecutorService;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.simple.d
 * JD-Core Version:    0.6.2
 */