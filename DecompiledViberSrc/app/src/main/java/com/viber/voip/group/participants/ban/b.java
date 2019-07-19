package com.viber.voip.group.participants.ban;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.util.dj;
import com.viber.voip.widget.LayoutCompleteAwareLinearLayoutManager;

public class b extends com.viber.voip.mvp.core.d<BannedParticipantsListPresenter>
  implements a, com.viber.voip.ui.a.a
{
  private aq a;
  private d b;
  private LayoutCompleteAwareLinearLayoutManager c;
  private MenuItem d;
  private MenuItem e;
  private TextView f;
  private View g;

  protected b(aq paramaq, BannedParticipantsListPresenter paramBannedParticipantsListPresenter, com.viber.voip.group.participants.settings.d paramd, View paramView)
  {
    super(paramBannedParticipantsListPresenter, paramView);
    this.a = paramaq;
    this.b = new d(paramaq.getActivity(), paramd, this, paramaq.getLayoutInflater());
    a(paramView);
  }

  private void a(View paramView)
  {
    this.g = paramView.findViewById(R.id.divider);
    RecyclerView localRecyclerView = (RecyclerView)paramView.findViewById(R.id.participant_settings_list);
    this.c = new LayoutCompleteAwareLinearLayoutManager(paramView.getContext(), 1, false);
    localRecyclerView.setLayoutManager(this.c);
    localRecyclerView.setAdapter(this.b);
    localRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
    {
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0)
          b.a(b.this);
      }
    });
    this.f = ((TextView)paramView.findViewById(R.id.member_privileges_summary));
    this.f.setText(R.string.banned_users_description);
  }

  private void g()
  {
    int i = this.b.c(this.c.findFirstVisibleItemPosition());
    int j = this.b.c(this.c.findLastVisibleItemPosition());
    ((BannedParticipantsListPresenter)this.mPresenter).a(i, j);
  }

  public void a()
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null)
      localFragmentActivity.finish();
  }

  public void a(int paramInt, View paramView)
  {
    String str = ((ae)this.b.b(paramInt)).p();
    com.viber.voip.ui.dialogs.d.n().a(str).a(this.a).b(this.a);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.b.a(paramConversationItemLoaderEntity.getGroupRole());
  }

  public void a(boolean paramBoolean)
  {
    dj.a(this.d, paramBoolean);
    dj.a(this.e, false);
    dj.b(this.f, paramBoolean);
    dj.b(this.g, paramBoolean);
    if (!paramBoolean)
      this.b.a(false);
  }

  public void b()
  {
    this.b.notifyDataSetChanged();
    this.c.a(new c(this));
  }

  public void b(boolean paramBoolean)
  {
    dj.a(this.a, paramBoolean);
  }

  public void c()
  {
    ad.a().b(this.a);
  }

  public void c(boolean paramBoolean)
  {
    MenuItem localMenuItem = this.d;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      dj.a(localMenuItem, bool);
      dj.a(this.e, paramBoolean);
      this.b.a(paramBoolean);
      ((BannedParticipantsListPresenter)this.mPresenter).a(paramBoolean);
      return;
    }
  }

  public void d()
  {
    k.z().b(this.a);
  }

  public void e()
  {
    k.n().b(this.a);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_banned_user, paramMenu);
    this.d = paramMenu.findItem(R.id.menu_edit);
    this.e = paramMenu.findItem(R.id.menu_done);
    if (((BannedParticipantsListPresenter)this.mPresenter).b())
      c(((BannedParticipantsListPresenter)this.mPresenter).a());
    while (true)
    {
      return true;
      dj.a(this.d, false);
      dj.a(this.e, false);
    }
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D1039))
    {
      if (paramInt == -1)
      {
        String str = (String)paramm.d();
        ((BannedParticipantsListPresenter)this.mPresenter).a(str);
      }
      return true;
    }
    return false;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == R.id.menu_edit)
      c(true);
    while (i != R.id.menu_done)
      return false;
    c(false);
    return false;
  }

  public void onStop()
  {
    if (this.a.getActivity().isFinishing())
      ((BannedParticipantsListPresenter)this.mPresenter).d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.ban.b
 * JD-Core Version:    0.6.2
 */