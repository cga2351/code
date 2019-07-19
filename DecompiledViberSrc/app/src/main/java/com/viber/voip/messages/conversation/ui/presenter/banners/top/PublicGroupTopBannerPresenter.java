package com.viber.voip.messages.conversation.ui.presenter.banners.top;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.s;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.b.af;
import com.viber.voip.messages.conversation.ui.b.aj;
import com.viber.voip.messages.conversation.ui.b.e;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.i;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.notif.g;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.util.cj;
import dagger.a;

public class PublicGroupTopBannerPresenter extends PublicGroupBehaviorTopBannerPresenter<com.viber.voip.messages.conversation.ui.view.a.c.c>
{
  public PublicGroupTopBannerPresenter(f paramf, n paramn, i parami, u paramu, af paramaf, s params, j paramj, o paramo, Handler paramHandler, cj paramcj, Engine paramEngine, com.viber.voip.contacts.c.c.a.b paramb, com.viber.voip.block.b paramb1, com.viber.voip.analytics.story.d.c paramc, com.viber.voip.analytics.story.b.c paramc1, aj paramaj, SpamController paramSpamController, a<ConferenceCallsRepository> parama, CallHandler paramCallHandler, e parame, ai paramai, a<g> parama1, bv parambv)
  {
    super(paramf, paramn, parami, paramu, paramaf, params, paramj, paramo, paramHandler, paramcj, paramEngine, paramb, paramb1, paramc, paramc1, paramaj, paramSpamController, parama, paramCallHandler, parame, paramai, parama1, parambv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.banners.top.PublicGroupTopBannerPresenter
 * JD-Core Version:    0.6.2
 */