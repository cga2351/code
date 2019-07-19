package com.viber.voip.messages.conversation.ui.presenter.banners.top;

import android.arch.lifecycle.h;
import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.k.d;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.s;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.b.af;
import com.viber.voip.messages.conversation.ui.b.aj;
import com.viber.voip.messages.conversation.ui.b.e;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.i;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.notif.g;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.util.cj;
import dagger.a;

public abstract class PublicGroupBehaviorTopBannerPresenter<VIEW extends com.viber.voip.messages.conversation.ui.view.a.c.c> extends TopBannerPresenter<VIEW>
  implements k.d
{
  private o f;
  private Runnable g = new c(this);
  private bv.t h = new bv.t()
  {
    private void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity, long paramAnonymousLong)
    {
      if (paramAnonymousConversationItemLoaderEntity.getGroupId() == paramAnonymousLong)
        PublicGroupBehaviorTopBannerPresenter.e(PublicGroupBehaviorTopBannerPresenter.this);
    }

    public void onPublicGroupSyncQueued(int paramAnonymousInt, long paramAnonymousLong)
    {
      if (PublicGroupBehaviorTopBannerPresenter.c(PublicGroupBehaviorTopBannerPresenter.this) != null)
        a(PublicGroupBehaviorTopBannerPresenter.d(PublicGroupBehaviorTopBannerPresenter.this), paramAnonymousLong);
    }

    public void onPublicGroupSyncStarted(int paramAnonymousInt, long paramAnonymousLong)
    {
      if (PublicGroupBehaviorTopBannerPresenter.a(PublicGroupBehaviorTopBannerPresenter.this) != null)
        a(PublicGroupBehaviorTopBannerPresenter.b(PublicGroupBehaviorTopBannerPresenter.this), paramAnonymousLong);
    }
  };

  public PublicGroupBehaviorTopBannerPresenter(f paramf, n paramn, i parami, u paramu, af paramaf, s params, j paramj, o paramo, Handler paramHandler, cj paramcj, Engine paramEngine, com.viber.voip.contacts.c.c.a.b paramb, com.viber.voip.block.b paramb1, com.viber.voip.analytics.story.d.c paramc, com.viber.voip.analytics.story.b.c paramc1, aj paramaj, SpamController paramSpamController, a<ConferenceCallsRepository> parama, CallHandler paramCallHandler, e parame, ai paramai, a<g> parama1, bv parambv)
  {
    super(paramf, paramn, parami, paramu, paramaf, params, paramj, paramHandler, paramcj, paramEngine, paramb, paramb1, paramc, paramc1, paramaj, paramSpamController, parama, paramCallHandler, parame, paramai, parama1, parambv);
    this.f = paramo;
  }

  private void s()
  {
    ((com.viber.voip.messages.conversation.ui.view.a.c.c)this.mView).c();
  }

  private void t()
  {
    ((com.viber.voip.messages.conversation.ui.view.a.c.c)this.mView).d();
  }

  private void u()
  {
    if (this.b == null);
    int i;
    do
    {
      return;
      i = Math.max(((PublicGroupConversationItemLoaderEntity)this.b).getLastLocalMsgId(), q());
    }
    while (!this.f.c(this.b.getGroupId(), i));
    s();
  }

  public void a()
  {
    this.a.postDelayed(this.g, 3000L);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = (PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity;
    if (paramBoolean)
    {
      this.a.removeCallbacks(this.g);
      ((com.viber.voip.messages.conversation.ui.view.a.c.c)this.mView).a(localPublicGroupConversationItemLoaderEntity, this);
    }
    if ((localPublicGroupConversationItemLoaderEntity.getLastServerMsgId() > 0) && (localPublicGroupConversationItemLoaderEntity.getLastServerMsgId() > Math.max(localPublicGroupConversationItemLoaderEntity.getLastLocalMsgId(), q())))
      s();
  }

  public void a(q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    super.a(paramq, false, paramInt, paramBoolean2);
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = (PublicGroupConversationItemLoaderEntity)this.b;
    if (localPublicGroupConversationItemLoaderEntity != null)
    {
      int i = localPublicGroupConversationItemLoaderEntity.getLastServerMsgId();
      int j = paramq.w();
      if ((i > 0) && (j < i))
        s();
    }
    else
    {
      return;
    }
    t();
  }

  public void a(ConversationAlertView.a parama)
  {
    ((com.viber.voip.messages.conversation.ui.view.a.c.c)this.mView).a(parama);
  }

  protected void k()
  {
    super.k();
    ((com.viber.voip.messages.conversation.ui.view.a.c.c)this.mView).b((PublicGroupConversationItemLoaderEntity)this.b, false);
  }

  public void m()
  {
    ((com.viber.voip.messages.conversation.ui.view.a.c.c)this.mView).b();
  }

  public void onDestroy(h paramh)
  {
    super.onDestroy(paramh);
    this.a.removeCallbacks(this.g);
  }

  public void onStart(h paramh)
  {
    super.onStart(paramh);
    this.f.a(this.h, this.a);
    u();
  }

  public void onStop(h paramh)
  {
    super.onStop(paramh);
    this.f.b(this.h);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.banners.top.PublicGroupBehaviorTopBannerPresenter
 * JD-Core Version:    0.6.2
 */