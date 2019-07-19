package com.viber.voip.messages.conversation.community.c;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ConversationListView;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.ui.list.x;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.community.CommunityConversationMvpPresenter;
import com.viber.voip.messages.conversation.community.c;
import com.viber.voip.messages.conversation.community.d;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.aq.b;
import com.viber.voip.messages.conversation.ui.view.b.q.a;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.util.dj;

public class a<P extends CommunityConversationMvpPresenter> extends com.viber.voip.messages.conversation.ui.view.b.a<P>
  implements AbsListView.OnScrollListener, c
{
  protected static final Logger a = ViberEnv.getLogger();
  private final Handler b;
  private final com.viber.voip.messages.conversation.adapter.k g;
  private x h;
  private Menu i;
  private q.a j;
  private aq.b k;
  private MenuItem l;
  private MenuItem m;
  private MenuItem n;
  private MenuItem o;
  private MenuItem p;
  private final Runnable q = new b(this);
  private boolean r;
  private int s = 0;

  public a(P paramP, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, Handler paramHandler, com.viber.voip.messages.conversation.adapter.k paramk, boolean paramBoolean, x paramx, aq.b paramb, q.a parama)
  {
    super(paramP, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.b = paramHandler;
    this.g = paramk;
    this.h = paramx;
    this.j = parama;
    this.k = paramb;
  }

  private void a(AbsListView paramAbsListView)
  {
    int i1 = paramAbsListView.getFirstVisiblePosition();
    int i2 = paramAbsListView.getChildCount();
    for (int i3 = 0; i3 < i2; i3++)
      if (paramAbsListView.getChildAt(i3) != null)
      {
        Object localObject = this.g.getItem(i1 + i3);
        if ((localObject instanceof com.viber.voip.messages.conversation.adapter.a.a))
        {
          aa localaa = ((com.viber.voip.messages.conversation.adapter.a.a)localObject).c();
          ((CommunityConversationMvpPresenter)this.mPresenter).a(localaa);
        }
      }
  }

  private void f()
  {
    this.b.removeCallbacks(this.q);
    this.r = false;
  }

  public void a()
  {
    ad.a().b(this.d);
  }

  public void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    this.m = paramMenu.add(0, R.id.menu_share_group_link, 0, R.string.join_community_link_msg_title);
    this.m.setIcon(R.drawable.ic_ab_theme_dark_share);
    this.m.setShowAsActionFlags(2);
    this.m.setVisible(false);
    MenuItemCompat.setIconTintList(this.m, ContextCompat.getColorStateList(this.c, R.color.theme_light_action_tint));
    this.n = paramMenu.add(0, R.id.menu_add_members, 1, R.string.join_community_link_msg_title);
    this.n.setIcon(R.drawable.ic_ab_add_participant);
    this.n.setShowAsActionFlags(2);
    this.n.setVisible(false);
    MenuItemCompat.setIconTintList(this.n, ContextCompat.getColorStateList(this.c, R.color.theme_light_action_tint));
    this.l = paramMenu.add(0, R.id.menu_conversation_info, 2, R.string.menu_open_info);
    this.l.setShowAsActionFlags(0);
    this.l.setVisible(false);
    this.o = paramMenu.add(0, R.id.menu_report, 3, R.string.menu_report_community);
    this.o.setShowAsActionFlags(0);
    this.o.setVisible(false);
    this.i = paramMenu;
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.j.a(paramConversationItemLoaderEntity, "Chat Dropdown");
  }

  public void a(d paramd)
  {
    if (this.i == null)
      return;
    if ((paramd.b) && (!this.k.I()));
    for (boolean bool = true; ; bool = false)
    {
      dj.a(this.n, paramd.a);
      dj.a(this.o, paramd.d);
      dj.a(this.l, bool);
      dj.a(this.m, paramd.c);
      dj.a(this.p, bool);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.h.a(paramBoolean);
  }

  public void b()
  {
    l.g().b(this.d);
  }

  public void c()
  {
    com.viber.voip.ui.dialogs.k.n().b(this.d);
  }

  public void d()
  {
    l.p().b(this.d);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    ((CommunityConversationMvpPresenter)this.mPresenter).a(paramMenu, paramMenuInflater);
    ((CommunityConversationMvpPresenter)this.mPresenter).f();
    return false;
  }

  public void onDestroy()
  {
    f();
    super.onDestroy();
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    ((CommunityConversationMvpPresenter)this.mPresenter).f();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    if (i1 == R.id.menu_conversation_info)
    {
      ((CommunityConversationMvpPresenter)this.mPresenter).e();
      return true;
    }
    if (R.id.menu_add_members == paramMenuItem.getItemId())
    {
      this.j.S();
      return true;
    }
    if (i1 == R.id.menu_share_group_link)
    {
      ((CommunityConversationMvpPresenter)this.mPresenter).g();
      return true;
    }
    if (i1 == R.id.menu_report)
    {
      ((CommunityConversationMvpPresenter)this.mPresenter).h();
      return true;
    }
    if (i1 == R.id.menu_delete)
    {
      int i2 = this.e.getFirstVisiblePosition();
      int i3 = this.e.getLastVisiblePosition();
      for (int i4 = i2; (i4 < i3) && (i4 < this.e.getAdapter().getCount()); i4++)
        ((CommunityConversationMvpPresenter)this.mPresenter).a(i4);
      return true;
    }
    return false;
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.s == 0)
    {
      f();
      this.r = true;
      this.b.postDelayed(this.q, 500L);
    }
    while (!this.r)
      return;
    f();
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.s = paramInt;
    switch (paramInt)
    {
    default:
      return;
    case 0:
    }
    f();
    a(paramAbsListView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.c.a
 * JD-Core Version:    0.6.2
 */