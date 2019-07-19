package com.viber.voip.messages.conversation.ui.presenter;

import android.arch.lifecycle.h;
import com.viber.voip.analytics.story.StoryConstants.g.a;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.analytics.story.n;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.b.q;
import com.viber.voip.messages.conversation.ui.b.s;
import com.viber.voip.messages.conversation.ui.view.g;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.util.ae;
import java.util.Collections;

public class DeleteConversationRelatedActionsPresenter extends BaseMvpPresenter<g, State>
  implements s
{
  private final q a;
  private final ai b;
  private final c c;
  private ConversationItemLoaderEntity d;

  public DeleteConversationRelatedActionsPresenter(q paramq, ai paramai, c paramc)
  {
    this.a = paramq;
    this.b = paramai;
    this.c = paramc;
  }

  public void a()
  {
    if (this.d != null)
      ((g)this.mView).a(this.d.isSnoozedConversation(), this.d.isMuteConversation());
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.d = paramConversationItemLoaderEntity;
  }

  public void a(String paramString1, String paramString2)
  {
    if (this.d != null)
      this.c.a(paramString2, paramString1, StoryConstants.g.a.a(this.d), n.a(this.d));
  }

  public void a(boolean paramBoolean)
  {
    if (this.d == null)
      return;
    boolean bool;
    label20: c localc;
    String str1;
    ConversationItemLoaderEntity localConversationItemLoaderEntity;
    if (!this.d.isSnoozedConversation())
    {
      bool = true;
      this.b.a(this.d.getId(), bool, this.d.getConversationType(), System.currentTimeMillis());
      localc = this.c;
      str1 = ae.b();
      localConversationItemLoaderEntity = this.d;
      if (!paramBoolean)
        break label110;
    }
    label110: for (String str2 = "Leave and Delete Dialog"; ; str2 = "Chat Info")
    {
      localc.a(str1, localConversationItemLoaderEntity, str2, bool);
      if ((paramBoolean) || (!bool))
        break;
      ((g)this.mView).a();
      return;
      bool = false;
      break label20;
    }
  }

  public void b()
  {
    ((g)this.mView).c();
  }

  public void b(boolean paramBoolean)
  {
    if (this.d == null);
    do
    {
      return;
      this.b.a(Collections.singleton(Long.valueOf(this.d.getId())), paramBoolean, this.d.getConversationType());
      this.c.a(ae.b(), this.d, paramBoolean);
    }
    while (!paramBoolean);
    ((g)this.mView).b();
  }

  public void c()
  {
    if (this.d != null)
      this.b.a(Collections.singleton(Long.valueOf(this.d.getId())), this.d.getConversationType());
  }

  public void onDestroy(h paramh)
  {
    this.a.b(this);
    super.onDestroy(paramh);
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.a.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.DeleteConversationRelatedActionsPresenter
 * JD-Core Version:    0.6.2
 */