package com.viber.voip.messages.conversation.ui.view.a.c;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.bj;
import com.viber.voip.messages.conversation.ui.bj.a;
import com.viber.voip.messages.conversation.ui.bo;
import com.viber.voip.messages.conversation.ui.bp;
import com.viber.voip.messages.conversation.ui.d.a;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.messages.conversation.ui.presenter.banners.top.CommunityTopBannerPresenter;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.ViberActionRunner.o;

public class b extends d<CommunityTopBannerPresenter>
  implements bj.a, d.a, a
{
  private final bo g;
  private final bj h;
  private final com.viber.voip.messages.conversation.ui.d i;

  public b(CommunityTopBannerPresenter paramCommunityTopBannerPresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean1, boolean paramBoolean2, com.viber.voip.messages.conversation.adapter.k paramk, ConversationAlertView paramConversationAlertView, SwipeRefreshLayout paramSwipeRefreshLayout, j paramj, com.viber.voip.messages.conversation.publicaccount.k paramk1, bp parambp, MessageComposerView paramMessageComposerView, g paramg, c paramc, com.viber.voip.analytics.story.a.a parama, com.viber.voip.messages.d.b paramb, Handler paramHandler)
  {
    super(paramCommunityTopBannerPresenter, paramActivity, paramConversationFragment, paramView, paramBoolean1, paramk, paramConversationAlertView, paramSwipeRefreshLayout, paramj, paramk1, parambp, paramMessageComposerView, paramg, paramc, parama, paramb);
    this.g = new bo(paramConversationFragment.getContext(), paramConversationAlertView, paramCommunityTopBannerPresenter, paramConversationFragment.getLayoutInflater());
    this.h = new bj(this.d, this.a, paramb, paramHandler, paramBoolean1, paramBoolean2, this);
    this.i = new com.viber.voip.messages.conversation.ui.d(this.d, this.a, paramb, this);
  }

  public void a()
  {
    this.g.a();
  }

  public void a(long paramLong)
  {
    ((CommunityTopBannerPresenter)this.mPresenter).c(paramLong);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    ((CommunityTopBannerPresenter)this.mPresenter).a(paramConversationItemLoaderEntity);
  }

  public void a(m paramm)
  {
    ViberActionRunner.o.a(this.c, paramm.a(), paramm.getContactName(), paramm.o());
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.g.a(paramConversationItemLoaderEntity);
  }

  public void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.h.a(paramConversationItemLoaderEntity);
  }

  public void d(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity != null)
      this.i.a(paramConversationItemLoaderEntity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.a.c.b
 * JD-Core Version:    0.6.2
 */