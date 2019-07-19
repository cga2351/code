package com.viber.voip.messages.conversation.ui.view.a.a;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationBannerView;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.bd;
import com.viber.voip.messages.conversation.ui.presenter.banners.bottom.PublicGroupBottomBannerPresenter;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.UserProfilePreviewActivity;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.bt;
import com.viber.voip.util.dj;
import com.viber.voip.util.dw;

public class d extends b<PublicGroupBottomBannerPresenter>
  implements View.OnClickListener, c
{
  public d(PublicGroupBottomBannerPresenter paramPublicGroupBottomBannerPresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, ConversationBannerView paramConversationBannerView, bd parambd)
  {
    super(paramPublicGroupBottomBannerPresenter, paramActivity, paramConversationFragment, paramView, paramBoolean, paramConversationBannerView, parambd);
  }

  private void e()
  {
    FragmentActivity localFragmentActivity = this.d.getActivity();
    UserData localUserData = UserManager.from(localFragmentActivity).getUserData();
    if ((!localUserData.getViberName().isEmpty()) && (!localUserData.getViberImage().isEmpty()))
    {
      this.d.startActivityForResult(new Intent(localFragmentActivity, UserProfilePreviewActivity.class), 900);
      return;
    }
    r.g().a(this.d).b(this.d);
  }

  private void h(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    if ((paramPublicGroupConversationItemLoaderEntity != null) && (this.c != null) && (!this.c.isFinishing()))
      ViberActionRunner.a(this.c, paramPublicGroupConversationItemLoaderEntity.getGroupId(), paramPublicGroupConversationItemLoaderEntity.getPublicAccountGroupUri());
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    this.a.a(paramPublicGroupConversationItemLoaderEntity, this, false);
    dj.c(this.d.getView());
  }

  public void b(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    this.a.a(paramPublicGroupConversationItemLoaderEntity);
  }

  public void c(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    h(paramPublicGroupConversationItemLoaderEntity);
  }

  public void d()
  {
    this.a.b();
  }

  public void d(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    dw.a(this.c, paramPublicGroupConversationItemLoaderEntity.getPublicAccountGroupUri(), paramPublicGroupConversationItemLoaderEntity.getGroupName(), paramPublicGroupConversationItemLoaderEntity.getGroupId());
  }

  public void e(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    dw.a(this.c, paramPublicGroupConversationItemLoaderEntity.getPublicAccountGroupUri());
  }

  public void f(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    this.a.a(false, paramPublicGroupConversationItemLoaderEntity);
  }

  public boolean g(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    return this.a.a(paramPublicGroupConversationItemLoaderEntity, this);
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (900 == paramInt1)
    {
      if (paramInt2 == -1)
      {
        ((PublicGroupBottomBannerPresenter)this.mPresenter).g();
        this.a.b();
      }
      return true;
    }
    return false;
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == R.id.public_group_share_banner_area) || (i == R.id.public_group_share_banner_icon))
    {
      ((PublicGroupBottomBannerPresenter)this.mPresenter).f();
      this.d.registerForContextMenu(paramView);
      this.c.openContextMenu(paramView);
      this.d.unregisterForContextMenu(paramView);
    }
    do
    {
      return;
      if (i == R.id.public_group_share_banner_close_action)
      {
        ((PublicGroupBottomBannerPresenter)this.mPresenter).d();
        return;
      }
      if (i == R.id.accept)
      {
        e();
        return;
      }
    }
    while (i != R.id.decline);
    r.a().a(this.d).b(this.d);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == R.id.menu_invite_friends)
    {
      ((PublicGroupBottomBannerPresenter)this.mPresenter).a();
      return true;
    }
    if (i == R.id.menu_invite_other)
    {
      ((PublicGroupBottomBannerPresenter)this.mPresenter).b();
      return true;
    }
    if (i == R.id.menu_copy_to_clipboard)
    {
      ((PublicGroupBottomBannerPresenter)this.mPresenter).c();
      return true;
    }
    return false;
  }

  public boolean onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if ((paramView.getId() == R.id.public_group_share_banner_area) || (paramView.getId() == R.id.public_group_share_banner_icon))
    {
      this.c.getMenuInflater().inflate(R.menu.context_menu_invite_pg, paramContextMenu);
      return true;
    }
    return false;
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D1012a)) && (-1 == paramInt))
    {
      ViberActionRunner.bt.d(this.c);
      return true;
    }
    if ((paramm.a(DialogCode.D1002a)) && (-1 == paramInt))
    {
      ((PublicGroupBottomBannerPresenter)this.mPresenter).j();
      return true;
    }
    return false;
  }

  public void onRemoteBannerVisibilityChange(boolean paramBoolean, com.viber.voip.banner.d.c paramc, com.viber.voip.banner.view.b paramb)
  {
    ((PublicGroupBottomBannerPresenter)this.mPresenter).e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.a.a.d
 * JD-Core Version:    0.6.2
 */