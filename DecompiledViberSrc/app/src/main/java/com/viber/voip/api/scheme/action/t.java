package com.viber.voip.api.scheme.action;

import android.content.Context;
import com.viber.voip.av.f;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage.a;
import com.viber.voip.messages.controller.manager.d;
import java.util.concurrent.ScheduledExecutorService;

class t extends aa
{
  private final com.viber.voip.messages.controller.manager.c f;
  private final com.viber.voip.messages.extensions.c g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final int l;
  private final int m;
  private final com.viber.voip.analytics.story.e.c n;

  t(com.viber.voip.messages.controller.manager.c paramc, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, com.viber.voip.messages.extensions.c paramc1, com.viber.voip.analytics.story.e.c paramc2)
  {
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramString4;
    this.l = paramInt1;
    this.m = paramInt2;
    this.f = paramc;
    this.g = paramc1;
    this.n = paramc2;
  }

  void a(Context paramContext)
  {
    BotFavoriteLinksCommunicator.SaveLinkActionMessage localSaveLinkActionMessage = BotFavoriteLinksCommunicator.SaveLinkActionMessage.builder().a(this.i).g(this.h).b(this.j).c(this.k).a(this.l, this.m).e(this.g.e()).a(1).h("URL Scheme").b();
    this.f.a().a(localSaveLinkActionMessage);
    av.f.d.execute(new u(this, localSaveLinkActionMessage));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.t
 * JD-Core Version:    0.6.2
 */