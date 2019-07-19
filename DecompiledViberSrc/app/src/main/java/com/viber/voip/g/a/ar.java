package com.viber.voip.g.a;

import android.os.Bundle;
import android.os.Handler;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.group.participants.ban.BannedParticipantsListPresenter;
import com.viber.voip.group.participants.ban.h;
import com.viber.voip.group.participants.settings.d;
import com.viber.voip.invitelinks.linkscreen.g;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.conversation.m;
import com.viber.voip.messages.k;
import org.greenrobot.eventbus.EventBus;

public abstract class ar
{
  static BannedParticipantsListPresenter a(com.viber.voip.group.participants.ban.e parame, com.viber.voip.messages.controller.a parama, Handler paramHandler, Im2Exchanger paramIm2Exchanger, PhoneController paramPhoneController, g paramg, d paramd, h paramh)
  {
    return new BannedParticipantsListPresenter(parame.getArguments().getLong("extra_conversation_id"), paramHandler, paramIm2Exchanger, paramPhoneController, parama, paramg, paramd, paramh);
  }

  static h a(com.viber.voip.group.participants.settings.e parame, ci paramci)
  {
    return new h(parame, paramci);
  }

  static d a(com.viber.voip.group.participants.ban.e parame, dagger.a<k> parama, EventBus paramEventBus)
  {
    return new d(parame.getContext(), parame.getLoaderManager(), parama, 3, paramEventBus);
  }

  static g a(com.viber.voip.group.participants.ban.e parame, dagger.a<k> parama)
  {
    return new g(parame.getArguments().getLong("extra_conversation_id"), new m(5, parame.getContext(), parame.getLoaderManager(), parama));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ar
 * JD-Core Version:    0.6.2
 */