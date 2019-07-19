package com.viber.voip.messages.conversation.ui.presenter.banners.bottom;

import android.os.Handler;
import com.viber.voip.contacts.c.c.a.b;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.g;
import com.viber.voip.messages.conversation.ui.presenter.banners.BannerPresenter;
import com.viber.voip.mvp.core.State;

public abstract class BottomBannerPresenter<VIEW extends com.viber.voip.messages.conversation.ui.view.a.a.a, STATE extends State> extends BannerPresenter<VIEW, STATE>
  implements g
{
  protected final dagger.a<com.viber.voip.messages.k> c;

  public BottomBannerPresenter(f paramf, b paramb, com.viber.voip.block.k paramk, Handler paramHandler, dagger.a<com.viber.voip.messages.k> parama)
  {
    super(paramf, paramHandler, paramb, paramk);
    this.c = parama;
  }

  protected void k()
  {
    boolean bool = this.b.isPendingInfo();
    int i;
    if ((this.b.isOneToOneWithPublicAccount()) && (!this.b.isWebhookExist()) && (!bool))
    {
      i = 1;
      if ((!this.b.isDisabledConversation()) || (this.b.isNotJoinedCommunity()) || ((!this.b.isGroupType()) && (!this.b.isCommunityType())))
        break label161;
      ((com.viber.voip.messages.conversation.ui.view.a.a.a)this.mView).a(this.b.getConversationType());
      label93: if (i == 0)
        break label176;
      ((com.viber.voip.messages.conversation.ui.view.a.a.a)this.mView).a(this.b.getViberName());
    }
    while (true)
    {
      if (!this.b.showNoPrivilegesBanner())
        break label191;
      a locala = new a(this);
      ((com.viber.voip.messages.conversation.ui.view.a.a.a)this.mView).a(this.b.getId(), locala);
      return;
      i = 0;
      break;
      label161: ((com.viber.voip.messages.conversation.ui.view.a.a.a)this.mView).a();
      break label93;
      label176: ((com.viber.voip.messages.conversation.ui.view.a.a.a)this.mView).b();
    }
    label191: ((com.viber.voip.messages.conversation.ui.view.a.a.a)this.mView).c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.banners.bottom.BottomBannerPresenter
 * JD-Core Version:    0.6.2
 */