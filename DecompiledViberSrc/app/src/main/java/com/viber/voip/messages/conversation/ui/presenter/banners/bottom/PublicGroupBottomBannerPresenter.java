package com.viber.voip.messages.conversation.ui.presenter.banners.bottom;

import android.os.Handler;
import com.viber.voip.contacts.c.c.a.b;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.view.a.a.c;
import com.viber.voip.mvp.core.State;
import dagger.a;
import java.util.Collections;

public class PublicGroupBottomBannerPresenter extends BottomBannerPresenter<c, State>
{
  public PublicGroupBottomBannerPresenter(f paramf, b paramb, com.viber.voip.block.k paramk, Handler paramHandler, a<com.viber.voip.messages.k> parama)
  {
    super(paramf, paramb, paramk, paramHandler, parama);
  }

  public void a()
  {
    ((c)this.mView).c((PublicGroupConversationItemLoaderEntity)this.b);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = (PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity;
    if (localPublicGroupConversationItemLoaderEntity.isPendingRole())
      ((c)this.mView).a(localPublicGroupConversationItemLoaderEntity);
    while (true)
    {
      ((c)this.mView).b(localPublicGroupConversationItemLoaderEntity);
      return;
      ((c)this.mView).d();
    }
  }

  public void b()
  {
    ((c)this.mView).d((PublicGroupConversationItemLoaderEntity)this.b);
  }

  public void c()
  {
    ((c)this.mView).e((PublicGroupConversationItemLoaderEntity)this.b);
  }

  public void d()
  {
    ((c)this.mView).f((PublicGroupConversationItemLoaderEntity)this.b);
  }

  public void e()
  {
    ((c)this.mView).f((PublicGroupConversationItemLoaderEntity)this.b);
  }

  public void f()
  {
    ((c)this.mView).f((PublicGroupConversationItemLoaderEntity)this.b);
  }

  public void g()
  {
    ((com.viber.voip.messages.k)this.c.get()).d().a(this.b.getGroupId());
  }

  public void j()
  {
    ((com.viber.voip.messages.k)this.c.get()).c().a(Collections.singleton(Long.valueOf(this.b.getId())), this.b.getConversationType());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.banners.bottom.PublicGroupBottomBannerPresenter
 * JD-Core Version:    0.6.2
 */