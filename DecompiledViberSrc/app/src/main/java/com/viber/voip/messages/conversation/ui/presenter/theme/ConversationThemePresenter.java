package com.viber.voip.messages.conversation.ui.presenter.theme;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.at;
import com.viber.voip.messages.conversation.ui.av;
import com.viber.voip.messages.conversation.ui.b.g;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.v;
import com.viber.voip.messages.conversation.ui.b.w;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.ui.ap.a;
import com.viber.voip.ui.t.b.a;
import com.viber.voip.ui.t.c;

public class ConversationThemePresenter extends BaseMvpPresenter<com.viber.voip.messages.conversation.ui.view.f, State>
  implements g, v, ap.a<at>
{
  private static final Logger a = ViberEnv.getLogger();
  private final u b;
  private final com.viber.voip.messages.conversation.ui.b.f c;
  private final av d;

  public ConversationThemePresenter(u paramu, com.viber.voip.messages.conversation.ui.b.f paramf, av paramav)
  {
    this.b = paramu;
    this.c = paramf;
    this.d = paramav;
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      this.d.d(2);
      return;
    }
    if (paramBoolean1)
    {
      this.d.d(1);
      return;
    }
    if (paramBoolean3)
    {
      this.d.d(3);
      return;
    }
    this.d.d(0);
  }

  public void G_()
  {
    w.a(this);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if (paramBoolean)
      a(paramConversationItemLoaderEntity.isSecret(), paramConversationItemLoaderEntity.isInBusinessInbox(), paramConversationItemLoaderEntity.isVlnConversation());
  }

  public void a(aa paramaa)
  {
    com.viber.voip.messages.conversation.adapter.f.a(this, paramaa);
  }

  public void a(ConversationData paramConversationData)
  {
    if (paramConversationData == null)
      return;
    a(paramConversationData.secretConversation, paramConversationData.isInBusinessInbox, paramConversationData.isInSmsInbox);
  }

  public void a(at paramat)
  {
    ((com.viber.voip.messages.conversation.ui.view.f)this.mView).a(paramat);
  }

  public void a(t.c paramc, t.b.a parama)
  {
    w.a(this, paramc, parama);
  }

  public void a(t.c paramc, t.b.a parama, long paramLong)
  {
    w.a(this, paramc, parama, paramLong);
  }

  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    w.a(this, paramCharSequence, paramBoolean);
  }

  public void a(String paramString)
  {
    w.a(this, paramString);
  }

  public void a(boolean paramBoolean)
  {
    w.a(this, paramBoolean);
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

  public void i()
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.b.b(this);
    this.c.b(this);
    this.d.b(this);
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.b.a(this);
    this.c.a(this);
    this.d.a(this);
    ((com.viber.voip.messages.conversation.ui.view.f)this.mView).a((at)this.d.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.theme.ConversationThemePresenter
 * JD-Core Version:    0.6.2
 */