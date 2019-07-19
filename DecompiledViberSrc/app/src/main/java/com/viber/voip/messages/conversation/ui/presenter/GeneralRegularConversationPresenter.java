package com.viber.voip.messages.conversation.ui.presenter;

import android.os.Handler;
import com.viber.voip.app.b;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.publicaccount.d;
import com.viber.voip.messages.conversation.ui.b.a;
import com.viber.voip.messages.conversation.ui.b.af;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.i;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.t;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.x;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.view.h;
import com.viber.voip.util.cj;
import com.viber.voip.util.cq;
import org.greenrobot.eventbus.EventBus;

public class GeneralRegularConversationPresenter extends GeneralConversationPresenter<h>
{
  public GeneralRegularConversationPresenter(a parama, f paramf, u paramu, t paramt, i parami, cj paramcj, com.viber.voip.storage.c paramc, af paramaf, n paramn, boolean paramBoolean, EventBus paramEventBus, x paramx, z paramz, ai paramai, b paramb, Handler paramHandler1, Handler paramHandler2, cq paramcq, com.viber.voip.analytics.story.e.c paramc1, d paramd)
  {
    super(parama, paramf, paramu, paramt, parami, paramcj, paramc, paramaf, paramn, paramBoolean, paramEventBus, paramx, paramz, paramai, paramb, paramHandler1, paramHandler2, paramcq, paramc1, paramd);
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    this.c.a(paramLong1, new g(this, paramLong2));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.GeneralRegularConversationPresenter
 * JD-Core Version:    0.6.2
 */