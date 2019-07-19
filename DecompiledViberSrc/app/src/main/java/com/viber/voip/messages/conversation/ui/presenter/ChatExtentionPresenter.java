package com.viber.voip.messages.conversation.ui.presenter;

import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.messages.conversation.ui.b.a;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.c;
import com.viber.voip.messages.ui.expanel.d;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.util.cj;

public class ChatExtentionPresenter extends BaseMvpPresenter<com.viber.voip.messages.conversation.ui.view.c, State>
  implements ExpandablePanelLayout.c
{
  private final a a;
  private final com.viber.common.b.h b;
  private final z c;

  public ChatExtentionPresenter(a parama, com.viber.common.b.h paramh, z paramz)
  {
    this.a = parama;
    this.b = paramh;
    this.c = paramz;
  }

  public void a()
  {
    if (cj.a(true))
    {
      String str = this.b.d();
      ((com.viber.voip.messages.conversation.ui.view.c)this.mView).a(str, this.c.a(str));
    }
  }

  public void a(int paramInt)
  {
    com.viber.voip.messages.ui.expanel.c.a(this, paramInt);
  }

  public void a(int paramInt1, int paramInt2)
  {
    com.viber.voip.messages.conversation.ui.view.c localc;
    if (paramInt2 == 0)
    {
      localc = (com.viber.voip.messages.conversation.ui.view.c)this.mView;
      if (paramInt2 != 0)
        break label29;
    }
    label29: for (boolean bool = true; ; bool = false)
    {
      localc.a(paramInt1, bool);
      return;
    }
  }

  public void a(int paramInt1, int paramInt2, View paramView)
  {
    if (paramInt1 == 3);
    for (int i = 1; ; i = 0)
    {
      if ((i != 0) && (paramInt2 == R.id.options_menu_open_stickers))
        ((com.viber.voip.messages.conversation.ui.view.c)this.mView).a();
      return;
    }
  }

  public void a(BotReplyConfig paramBotReplyConfig, d paramd)
  {
    this.a.a(paramBotReplyConfig, paramd);
  }

  public void a(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity)
  {
    ((com.viber.voip.messages.conversation.ui.view.c)this.mView).a(paramChatExtensionLoaderEntity.getSearchHint());
    this.c.a(true);
    ((com.viber.voip.messages.conversation.ui.view.c)this.mView).a(paramChatExtensionLoaderEntity.getPublicAccountId(), this.c.a(paramChatExtensionLoaderEntity.getPublicAccountId()));
  }

  public void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (2 == paramInt))
      ((com.viber.voip.messages.conversation.ui.view.c)this.mView).a(11);
    if ((paramBoolean) && (!this.c.m()))
      ((com.viber.voip.messages.conversation.ui.view.c)this.mView).b();
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.a.b(this);
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.a.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.ChatExtentionPresenter
 * JD-Core Version:    0.6.2
 */