package com.viber.voip.messages.conversation.ui.presenter.input;

import android.os.Handler;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.analytics.story.f.d;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.i;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.t;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.view.l;
import com.viber.voip.publicaccount.d.e.a;
import org.greenrobot.eventbus.EventBus;

public class PublicGroupInputFieldPresenter extends InputFieldPresenter<l>
{
  public PublicGroupInputFieldPresenter(z paramz, com.viber.voip.messages.conversation.ui.b.a parama, f paramf, n paramn, i parami, t paramt, u paramu, com.viber.voip.messages.c.a.a parama1, com.viber.voip.messages.b.a.c paramc, com.viber.voip.flatbuffers.b.a<QuotedMessageData> parama2, com.viber.voip.flatbuffers.b.b<QuotedMessageData> paramb, com.viber.voip.bot.b paramb1, Im2Exchanger paramIm2Exchanger, Handler paramHandler1, Handler paramHandler2, EventBus paramEventBus, com.viber.voip.messages.extensions.c paramc1, com.viber.voip.messages.d.b paramb2, ai paramai, boolean paramBoolean1, boolean paramBoolean2, d paramd)
  {
    super(paramz, parama, paramf, paramn, parami, paramt, paramu, parama1, paramc, parama2, paramb, paramb1, paramIm2Exchanger, paramHandler1, paramHandler2, paramEventBus, paramc1, paramb2, paramai, paramBoolean1, paramBoolean2, paramd);
  }

  private void p()
  {
    e.a locala;
    boolean bool;
    if (this.p.isCommunityType())
    {
      locala = e.a.b;
      if (this.p.isPublicGroupBehavior())
        break label68;
      bool = true;
    }
    while (true)
    {
      this.e.c(bool);
      if (this.o)
        a(this.p, this.q, this.e.g());
      return;
      locala = e.a.a;
      break;
      label68: if (this.e.a(locala))
      {
        ((l)this.mView).m();
        bool = false;
      }
      else
      {
        bool = true;
      }
    }
  }

  private void q()
  {
    if ((this.p != null) && (((this.p.isPublicGroupType()) && (this.p.isAdministratorRole())) || ((this.p.isCommunityType()) && (!this.p.isNotJoinedCommunity()))))
      p();
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    if (paramBoolean)
      q();
  }

  public void n()
  {
    p();
  }

  public void o()
  {
    if (!this.o)
      q();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.input.PublicGroupInputFieldPresenter
 * JD-Core Version:    0.6.2
 */