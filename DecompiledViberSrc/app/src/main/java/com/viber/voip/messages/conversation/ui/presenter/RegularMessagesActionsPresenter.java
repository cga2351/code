package com.viber.voip.messages.conversation.ui.presenter;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.analytics.g;
import com.viber.voip.invitelinks.q;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.publicaccount.d;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.b.ac;
import com.viber.voip.messages.conversation.ui.b.aj;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.x;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.bm;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.af;
import com.viber.voip.sound.tones.IRingtonePlayer;

public class RegularMessagesActionsPresenter extends MessagesActionsPresenter<com.viber.voip.messages.conversation.ui.view.j>
{
  public RegularMessagesActionsPresenter(SpamController paramSpamController, f paramf, ac paramac, com.viber.voip.messages.conversation.ui.b.i parami, ai paramai, com.viber.common.permission.c paramc, com.viber.voip.messages.conversation.ui.j paramj, Engine paramEngine, af paramaf, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, g paramg, IRingtonePlayer paramIRingtonePlayer, d paramd, com.viber.voip.messages.conversation.ui.b.a parama, com.viber.voip.messages.d.b paramb, boolean paramBoolean, o paramo, Handler paramHandler4, bm parambm, x paramx, aj paramaj, com.viber.voip.stickers.b paramb1, com.viber.voip.stickers.i parami1, com.viber.voip.stickers.a.a parama1, n paramn, u paramu, ActivationController paramActivationController, z paramz, com.viber.common.b.b paramb2, com.viber.voip.messages.extensions.c paramc1, dagger.a<q> parama2)
  {
    super(paramSpamController, paramf, paramac, parami, paramai, paramc, paramj, paramEngine, paramaf, paramHandler1, paramHandler2, paramHandler3, paramg, paramIRingtonePlayer, paramd, parama, paramb, paramBoolean, paramo, paramHandler4, parambm, paramx, paramaj, paramb1, parami1, parama1, paramn, paramu, paramActivationController, paramz, paramb2, paramc1, parama2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.RegularMessagesActionsPresenter
 * JD-Core Version:    0.6.2
 */