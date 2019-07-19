package com.viber.voip.messages.conversation.ui.view.a.c;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MenuItem;
import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.analytics.story.a.a;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationFragment;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.k.d;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.bi;
import com.viber.voip.messages.conversation.ui.bp;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.messages.conversation.ui.presenter.banners.top.PublicGroupBehaviorTopBannerPresenter;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.ui.MessageComposerView;

public abstract class d<P extends PublicGroupBehaviorTopBannerPresenter> extends g<P>
  implements c
{
  private final bp g;
  private final com.viber.voip.messages.conversation.publicaccount.k h;
  private final bi i;

  public d(P paramP, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, com.viber.voip.messages.conversation.adapter.k paramk, ConversationAlertView paramConversationAlertView, SwipeRefreshLayout paramSwipeRefreshLayout, j paramj, com.viber.voip.messages.conversation.publicaccount.k paramk1, bp parambp, MessageComposerView paramMessageComposerView, com.viber.voip.analytics.g paramg, com.viber.voip.analytics.story.e.c paramc, a parama, b paramb)
  {
    super(paramP, paramActivity, paramConversationFragment, paramView, paramBoolean, paramConversationAlertView, paramk, paramSwipeRefreshLayout, paramj, paramMessageComposerView, parambp, paramg, paramc, parama, paramb);
    this.h = paramk1;
    this.g = parambp;
    this.i = new bi(paramk);
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, k.d paramd)
  {
    this.h.a(this.a, paramPublicGroupConversationItemLoaderEntity, (PublicGroupConversationFragment)this.d, paramd);
  }

  public void a(ConversationAlertView.a parama)
  {
    this.a.a(parama, Bundle.EMPTY, true);
  }

  public void b()
  {
    this.h.a(this.a);
  }

  public void c()
  {
    this.i.a();
  }

  public void d()
  {
    if (!this.d.isDetached())
      this.i.b();
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.g.b();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int j = paramMenuItem.getItemId();
    if (j == R.id.menu_debug_join_alert)
    {
      ((PublicGroupBehaviorTopBannerPresenter)this.mPresenter).m();
      return true;
    }
    if ((j == R.id.menu_show_no_participants_banner) || (j == R.id.menu_show_no_conn_banner))
    {
      ((PublicGroupBehaviorTopBannerPresenter)this.mPresenter).a(ConversationAlertView.a.valueOf((String)paramMenuItem.getTitleCondensed()));
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.a.c.d
 * JD-Core Version:    0.6.2
 */