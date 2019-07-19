package com.viber.voip.messages.conversation.ui.presenter;

import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.g;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.messages.ui.d.h;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.c;
import com.viber.voip.messages.ui.expanel.d;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.settings.d.n;
import com.viber.voip.stickers.i;

public class BottomPanelPresenter extends BaseMvpPresenter<com.viber.voip.messages.conversation.ui.view.b, BottomPanelPresenterState>
  implements g, com.viber.voip.messages.conversation.ui.view.a, d.h, ExpandablePanelLayout.c
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.messages.conversation.ui.b.a b;
  private final f c;
  private final z d;
  private final SpamController e;
  private i f;
  private ConversationItemLoaderEntity g;
  private long h = -1L;
  private long i;

  public BottomPanelPresenter(com.viber.voip.messages.conversation.ui.b.a parama, f paramf, z paramz, SpamController paramSpamController, i parami)
  {
    this.b = parama;
    this.c = paramf;
    this.d = paramz;
    this.e = paramSpamController;
    this.f = parami;
  }

  protected BottomPanelPresenterState a()
  {
    return new BottomPanelPresenterState(((com.viber.voip.messages.conversation.ui.view.b)this.mView).b(), this.h, this.i);
  }

  public void a(int paramInt)
  {
    ((com.viber.voip.messages.conversation.ui.view.b)this.mView).a(paramInt);
  }

  public void a(int paramInt1, int paramInt2, View paramView)
  {
    int j;
    SpamController localSpamController;
    if (paramInt1 == 3)
    {
      j = 1;
      if ((j == 0) && (paramInt2 == R.id.options_menu_open_gallery))
        ((com.viber.voip.messages.conversation.ui.view.b)this.mView).a();
      ((com.viber.voip.messages.conversation.ui.view.b)this.mView).a(paramInt1, paramInt2, paramView);
      localSpamController = this.e;
      if ((j == 0) && (paramInt1 != 2))
        break label80;
    }
    label80: for (boolean bool = true; ; bool = false)
    {
      localSpamController.a(bool);
      return;
      j = 0;
      break;
    }
  }

  public void a(BotReplyConfig paramBotReplyConfig, d paramd)
  {
    ((com.viber.voip.messages.conversation.ui.view.b)this.mView).a(paramBotReplyConfig, paramd);
  }

  public void a(ReplyButton paramReplyButton)
  {
    if ((paramReplyButton.getReplyType() == ReplyButton.b.MESSAGE) && (e.a(paramReplyButton.getActionType())))
    {
      this.d.b(true);
      d.n.a.a(true);
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    this.g = paramConversationItemLoaderEntity;
    if ((paramBoolean) && (this.h != paramConversationItemLoaderEntity.getId()))
    {
      ((com.viber.voip.messages.conversation.ui.view.b)this.mView).e();
      ((com.viber.voip.messages.conversation.ui.view.b)this.mView).d();
      ((com.viber.voip.messages.conversation.ui.view.b)this.mView).j();
    }
    boolean bool;
    if ((paramConversationItemLoaderEntity.canWrite()) && (!paramConversationItemLoaderEntity.isCommunityBlocked()))
    {
      if ((paramConversationItemLoaderEntity.isPublicGroupBehavior()) || (paramConversationItemLoaderEntity.isBroadcastListType()))
        break label201;
      BotReplyConfig localBotReplyConfig = e.a(paramConversationItemLoaderEntity.getBotReply());
      if (localBotReplyConfig == null)
        break label169;
      long l = localBotReplyConfig.getKeyboardDate();
      if (this.i == l)
        break label163;
      bool = true;
      this.i = l;
      ((com.viber.voip.messages.conversation.ui.view.b)this.mView).a(localBotReplyConfig, paramConversationItemLoaderEntity.getParticipantMemberId(), bool);
      label141: ((com.viber.voip.messages.conversation.ui.view.b)this.mView).a(localBotReplyConfig);
    }
    while (true)
    {
      this.h = paramConversationItemLoaderEntity.getId();
      return;
      label163: bool = false;
      break;
      label169: this.i = 0L;
      ((com.viber.voip.messages.conversation.ui.view.b)this.mView).c();
      ((com.viber.voip.messages.conversation.ui.view.b)this.mView).j();
      break label141;
      label201: this.i = 0L;
      ((com.viber.voip.messages.conversation.ui.view.b)this.mView).c();
      ((com.viber.voip.messages.conversation.ui.view.b)this.mView).a(null);
    }
  }

  protected void a(BottomPanelPresenterState paramBottomPanelPresenterState)
  {
    super.onViewAttached(paramBottomPanelPresenterState);
    if (paramBottomPanelPresenterState != null)
    {
      this.h = paramBottomPanelPresenterState.getConversationId();
      this.i = paramBottomPanelPresenterState.getDate();
    }
    this.b.a(this);
    this.b.a(this);
    this.c.a(this);
    com.viber.voip.messages.conversation.ui.view.b localb = (com.viber.voip.messages.conversation.ui.view.b)this.mView;
    if (paramBottomPanelPresenterState != null);
    for (int j = paramBottomPanelPresenterState.getExpanderState(); ; j = 1)
    {
      localb.b(j);
      return;
    }
  }

  public void a(String paramString1, int paramInt, String paramString2)
  {
    ((com.viber.voip.messages.conversation.ui.view.b)this.mView).a(this.g, paramString1, paramInt, paramString2);
  }

  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ((com.viber.voip.messages.conversation.ui.view.b)this.mView).a(this.g, paramString1, paramString2, paramInt, paramString3);
  }

  public void b()
  {
    ((com.viber.voip.messages.conversation.ui.view.b)this.mView).e();
  }

  public void b(int paramInt)
  {
    com.viber.voip.stickers.entity.a locala = this.f.g(paramInt);
    if (locala == null)
      return;
    ((com.viber.voip.messages.conversation.ui.view.b)this.mView).a(locala);
  }

  public void b(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.b(this, paramLong);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramConversationItemLoaderEntity, paramBoolean);
  }

  public void b_(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramLong);
  }

  public void c()
  {
    ((com.viber.voip.messages.conversation.ui.view.b)this.mView).f();
  }

  public void c(int paramInt)
  {
    ((com.viber.voip.messages.conversation.ui.view.b)this.mView).c(paramInt);
  }

  public void d()
  {
    if (this.g.isConversation1on1());
    for (String str = this.g.getParticipantMemberId(); ; str = "")
    {
      OpenShopChatPanelData localOpenShopChatPanelData = new OpenShopChatPanelData(str, this.g.getGroupId(), "");
      this.d.a(localOpenShopChatPanelData);
      return;
    }
  }

  public void e()
  {
    ((com.viber.voip.messages.conversation.ui.view.b)this.mView).g();
  }

  public void f()
  {
    ((com.viber.voip.messages.conversation.ui.view.b)this.mView).h();
  }

  public void g()
  {
    ((com.viber.voip.messages.conversation.ui.view.b)this.mView).i();
  }

  public void i()
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.b.b(this);
    this.b.b(this);
    this.c.b(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.BottomPanelPresenter
 * JD-Core Version:    0.6.2
 */