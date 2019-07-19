package com.viber.voip.messages.conversation.ui.presenter;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.cdr.entity.PublicAccountInteraction;
import com.viber.voip.analytics.g;
import com.viber.voip.invitelinks.q;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.publicaccount.d;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.b.ac;
import com.viber.voip.messages.conversation.ui.b.aj;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.x;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.bm;
import com.viber.voip.messages.orm.entity.json.action.MessageOpenUrlAction;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.af;
import com.viber.voip.sound.tones.IRingtonePlayer;
import java.security.SecureRandom;

public class PublicGroupMessagesActionsPresenter extends MessagesActionsPresenter<com.viber.voip.messages.conversation.ui.view.j>
{
  private final ICdrController g;
  private long h = 0L;

  public PublicGroupMessagesActionsPresenter(SpamController paramSpamController, f paramf, ac paramac, com.viber.voip.messages.conversation.ui.b.i parami, ai paramai, com.viber.common.permission.c paramc, com.viber.voip.messages.conversation.ui.j paramj, Engine paramEngine, af paramaf, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, g paramg, IRingtonePlayer paramIRingtonePlayer, d paramd, com.viber.voip.messages.conversation.ui.b.a parama, ICdrController paramICdrController, com.viber.voip.messages.d.b paramb, boolean paramBoolean, o paramo, Handler paramHandler4, bm parambm, x paramx, aj paramaj, com.viber.voip.stickers.b paramb1, com.viber.voip.stickers.i parami1, com.viber.voip.stickers.a.a parama1, n paramn, u paramu, ActivationController paramActivationController, z paramz, com.viber.common.b.b paramb2, com.viber.voip.messages.extensions.c paramc1, dagger.a<q> parama2)
  {
    super(paramSpamController, paramf, paramac, parami, paramai, paramc, paramj, paramEngine, paramaf, paramHandler1, paramHandler3, paramHandler2, paramg, paramIRingtonePlayer, paramd, parama, paramb, paramBoolean, paramo, paramHandler4, parambm, paramx, paramaj, paramb1, parami1, parama1, paramn, paramu, paramActivationController, paramz, paramb2, paramc1, parama2);
    this.g = paramICdrController;
  }

  private void b(aa paramaa, String paramString)
  {
    PublicAccountInteraction localPublicAccountInteraction = c(paramaa, paramString);
    if (localPublicAccountInteraction != null)
      this.g.handleReportPAInteractions(localPublicAccountInteraction.publicAccountId, localPublicAccountInteraction.publicAccountCategory, localPublicAccountInteraction.publicAccountSubcategory, localPublicAccountInteraction.publicAccountCountryCode, localPublicAccountInteraction.publicAccountLocationInfo, localPublicAccountInteraction.publicChatSessionToken, localPublicAccountInteraction.messageMediaType, localPublicAccountInteraction.messageUrl, null, localPublicAccountInteraction.isGifMessage, localPublicAccountInteraction.messageStickerNumber, localPublicAccountInteraction.messageToken, localPublicAccountInteraction.messageSequence, localPublicAccountInteraction.publicAccountUserRole);
  }

  private void b(MessagesActionsPresenterState paramMessagesActionsPresenterState)
  {
    if (paramMessagesActionsPresenterState != null)
    {
      long l = paramMessagesActionsPresenterState.getCdrSessionToken();
      if (l != 0L)
        this.h = l;
    }
    if (this.h == 0L)
      this.h = new SecureRandom().nextLong();
  }

  private PublicAccountInteraction c(aa paramaa, String paramString)
  {
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = (PublicGroupConversationItemLoaderEntity)this.b.b();
    if (localPublicGroupConversationItemLoaderEntity == null)
      return null;
    if (paramaa == null)
      return null;
    return PublicAccountInteraction.create(this.h, paramString, localPublicGroupConversationItemLoaderEntity, paramaa);
  }

  public void a(aa paramaa, MessageOpenUrlAction paramMessageOpenUrlAction)
  {
    b(paramaa, paramMessageOpenUrlAction.getUrl());
    super.a(paramaa, paramMessageOpenUrlAction);
  }

  public void a(aa paramaa, boolean paramBoolean)
  {
    super.a(paramaa, paramBoolean);
    b(paramaa, null);
  }

  protected void a(MessagesActionsPresenterState paramMessagesActionsPresenterState)
  {
    super.a(paramMessagesActionsPresenterState);
    b(paramMessagesActionsPresenterState);
  }

  public void b(aa paramaa)
  {
    super.b(paramaa);
    b(paramaa, null);
  }

  public void c(aa paramaa)
  {
    super.c(paramaa);
    this.b.b();
    b(paramaa, null);
  }

  protected MessagesActionsPresenterState e()
  {
    return new MessagesActionsPresenterState(this.h);
  }

  public void j(aa paramaa)
  {
    super.j(paramaa);
    this.b.b();
    b(paramaa, null);
  }

  public void k(aa paramaa)
  {
    super.k(paramaa);
    if ((!paramaa.aL()) || (paramaa.aM()))
      b(paramaa, null);
  }

  public void o(aa paramaa)
  {
    super.o(paramaa);
    b(paramaa, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.PublicGroupMessagesActionsPresenter
 * JD-Core Version:    0.6.2
 */