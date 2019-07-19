package com.viber.voip.messages.conversation.ui.view.b;

import android.app.Activity;
import android.app.Application;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.getkeepsafe.taptargetview.c;
import com.getkeepsafe.taptargetview.c.a;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.c.g;
import com.viber.voip.i.f;
import com.viber.voip.messages.controller.manager.an;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.aq.b;
import com.viber.voip.messages.conversation.ui.at;
import com.viber.voip.messages.conversation.ui.presenter.OptionsMenuPresenter;
import com.viber.voip.messages.conversation.ui.view.k;
import com.viber.voip.settings.d.m;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;

public class q extends a<OptionsMenuPresenter>
  implements k
{
  private static final Logger a = ViberEnv.getLogger();
  private Menu b;
  private MenuItem g;
  private MenuItem h;
  private MenuItem i;
  private MenuItem j;
  private MenuItem k;
  private MenuItem l;
  private MenuItem m;
  private MenuItem n;
  private MenuItem o;
  private MenuItem p;
  private MenuItem q;
  private MenuItem r;
  private a s;
  private aq.b t;
  private at u;

  public q(OptionsMenuPresenter paramOptionsMenuPresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, a parama, aq.b paramb)
  {
    super(paramOptionsMenuPresenter, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.s = parama;
    this.t = paramb;
  }

  private void a(MenuItem paramMenuItem, ColorStateList paramColorStateList)
  {
    if ((paramMenuItem != null) && (paramMenuItem.isVisible()))
      MenuItemCompat.setIconTintList(paramMenuItem, paramColorStateList);
  }

  private Resources b()
  {
    return ViberApplication.getApplication().getResources();
  }

  public void a()
  {
    if (this.b != null)
      for (int i1 = 0; i1 < this.b.size(); i1++)
        dj.a(this.b.getItem(i1), false);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.s.a(paramConversationItemLoaderEntity, "Chat Dropdown");
  }

  public void a(at paramat)
  {
    this.u = paramat;
  }

  public void a(String paramString)
  {
    Toolbar localToolbar = (Toolbar)this.c.findViewById(R.id.toolbar);
    if (localToolbar == null)
      return;
    dj.a(localToolbar, new r(this, localToolbar, paramString));
  }

  public void a(boolean paramBoolean, ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt)
  {
    if (this.b == null)
      return;
    boolean bool1 = this.t.I();
    boolean bool2 = paramConversationItemLoaderEntity.isGroupBehavior();
    paramConversationItemLoaderEntity.isConversation1on1();
    boolean bool3 = paramConversationItemLoaderEntity.isGroupType();
    boolean bool4 = paramConversationItemLoaderEntity.isDisabledConversation();
    boolean bool5 = paramConversationItemLoaderEntity.isSystemConversation();
    boolean bool6 = paramConversationItemLoaderEntity.isOneToOneWithPublicAccount();
    boolean bool7 = paramConversationItemLoaderEntity.isNotShareablePublicAccount();
    boolean bool8 = paramConversationItemLoaderEntity.isSecret();
    boolean bool9 = paramConversationItemLoaderEntity.isVlnConversation();
    boolean bool10 = paramConversationItemLoaderEntity.isAnonymous();
    boolean bool11 = paramConversationItemLoaderEntity.isHiddenConversation();
    boolean bool12;
    label136: boolean bool13;
    label170: boolean bool14;
    label211: boolean bool15;
    label247: boolean bool16;
    label283: boolean bool17;
    label318: boolean bool18;
    label353: boolean bool19;
    label399: boolean bool20;
    label425: boolean bool21;
    label456: boolean bool22;
    label497: MenuItem localMenuItem11;
    if ((c.g.a.e()) && (bool3) && (!bool4) && (!bool8) && (!bool11) && (!bool9) && (paramInt > 1) && (paramInt <= d.m.w.d()))
    {
      bool12 = true;
      MenuItem localMenuItem1 = this.i;
      if ((bool2) || (bool5) || (bool6) || (bool9) || (bool10))
        break label757;
      bool13 = true;
      dj.a(localMenuItem1, bool13);
      MenuItem localMenuItem2 = this.k;
      if ((bool2) || (bool5) || (bool6) || (bool9) || (bool10))
        break label763;
      bool14 = true;
      dj.a(localMenuItem2, bool14);
      MenuItem localMenuItem3 = this.l;
      if ((!bool2) || (bool4) || (bool9) || (bool10))
        break label769;
      bool15 = true;
      dj.a(localMenuItem3, bool15);
      MenuItem localMenuItem4 = this.h;
      if ((bool4) || (bool5) || (bool1) || (bool9))
        break label775;
      bool16 = true;
      dj.a(localMenuItem4, bool16);
      MenuItem localMenuItem5 = this.g;
      if ((bool5) || (!paramBoolean) || (bool1) || (bool9))
        break label781;
      bool17 = true;
      dj.a(localMenuItem5, bool17);
      MenuItem localMenuItem6 = this.p;
      if ((bool5) || (!paramBoolean) || (bool1) || (bool9))
        break label787;
      bool18 = true;
      dj.a(localMenuItem6, bool18);
      MenuItem localMenuItem7 = this.j;
      if ((bool2) || (bool5) || (bool1) || (bool6) || (bool9) || (bool10))
        break label793;
      bool19 = true;
      dj.a(localMenuItem7, bool19);
      MenuItem localMenuItem8 = this.m;
      if ((!bool6) || (bool9))
        break label799;
      bool20 = true;
      dj.a(localMenuItem8, bool20);
      MenuItem localMenuItem9 = this.n;
      if ((!bool6) || (bool7) || (bool9))
        break label805;
      bool21 = true;
      dj.a(localMenuItem9, bool21);
      MenuItem localMenuItem10 = this.o;
      if ((bool2) || (bool5) || (bool6) || (bool9) || (bool10))
        break label811;
      bool22 = true;
      dj.a(localMenuItem10, bool22);
      localMenuItem11 = this.q;
      if ((bool8) || (bool6) || (bool5) || (bool4) || (bool2) || (!an.a(this.f)) || (bool9) || (bool10))
        break label817;
    }
    label769: label775: label781: label787: label793: label799: label805: label811: label817: for (boolean bool23 = true; ; bool23 = false)
    {
      dj.a(localMenuItem11, bool23);
      dj.a(this.r, bool12);
      if (this.u != null)
      {
        a(this.i, this.u.p());
        a(this.k, this.u.p());
        a(this.r, this.u.p());
        a(this.l, this.u.p());
        a(this.n, this.u.p());
        a(this.m, this.u.p());
      }
      if ((this.o == null) || (!this.o.isVisible()))
        break;
      MenuItem localMenuItem12 = this.o;
      Resources localResources = b();
      int i1 = R.string.menu_create_a_group_with;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = dg.a(paramConversationItemLoaderEntity);
      localMenuItem12.setTitle(localResources.getString(i1, arrayOfObject));
      return;
      bool12 = false;
      break label136;
      label757: bool13 = false;
      break label170;
      label763: bool14 = false;
      break label211;
      bool15 = false;
      break label247;
      bool16 = false;
      break label283;
      bool17 = false;
      break label318;
      bool18 = false;
      break label353;
      bool19 = false;
      break label399;
      bool20 = false;
      break label425;
      bool21 = false;
      break label456;
      bool22 = false;
      break label497;
    }
  }

  public void d_(boolean paramBoolean)
  {
    if (!paramBoolean)
      ((OptionsMenuPresenter)this.mPresenter).c();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    this.i = paramMenu.add(0, R.id.menu_viber_call, 0, R.string.menu_free_call);
    this.i.setShowAsActionFlags(2);
    this.i.setIcon(R.drawable.ic_ab_voice_call);
    this.r = paramMenu.add(0, R.id.menu_group_call, 0, R.string.group_call);
    this.r.setShowAsActionFlags(2);
    this.r.setIcon(R.drawable.ic_ab_voice_call);
    this.k = paramMenu.add(0, R.id.menu_video_call, 1, R.string.menu_video_call);
    this.k.setShowAsActionFlags(2);
    this.k.setIcon(R.drawable.ic_ab_video_call);
    this.l = paramMenu.add(0, R.id.menu_add_participants, 2, R.string.add_participants);
    this.l.setShowAsActionFlags(2);
    this.l.setIcon(R.drawable.ic_ab_add_participant);
    this.j = paramMenu.add(0, R.id.menu_viber_out_call, 3, R.string.menu_viber_out_call);
    this.o = paramMenu.add(0, R.id.menu_create_group, 4, R.string.menu_create_a_group_with);
    this.h = paramMenu.add(0, R.id.menu_conversation_info, 5, R.string.menu_open_info);
    this.g = paramMenu.add(0, R.id.menu_edit, 6, R.string.messages_edit_header);
    this.q = paramMenu.add(0, R.id.menu_switch_to_secret, 8, R.string.conversation_info_switch_to_secret_chat);
    this.n = paramMenu.add(0, R.id.menu_share_public_account, 9, R.string.menu_open_info);
    this.n.setShowAsActionFlags(2);
    this.n.setIcon(R.drawable.ic_ab_theme_dark_share);
    this.p = paramMenu.add(0, R.id.menu_clear_chat, 10, R.string.menu_clear_chat);
    this.m = paramMenu.add(0, R.id.menu_open_public_chat, 11, R.string.public_account_info_button_public_chat);
    this.m.setShowAsActionFlags(2);
    this.m.setIcon(R.drawable.ic_ab_public_account);
    this.b = paramMenu;
    a();
    ((OptionsMenuPresenter)this.mPresenter).c();
    ((OptionsMenuPresenter)this.mPresenter).e();
    return false;
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    ((OptionsMenuPresenter)this.mPresenter).c();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    if (i1 == R.id.menu_edit)
      this.s.N();
    do
    {
      return false;
      if (i1 == R.id.menu_viber_call)
      {
        ((OptionsMenuPresenter)this.mPresenter).b(false, false);
        return false;
      }
      if (i1 == R.id.menu_viber_out_call)
      {
        ((OptionsMenuPresenter)this.mPresenter).b(false, true);
        return false;
      }
      if (i1 == R.id.menu_video_call)
      {
        ((OptionsMenuPresenter)this.mPresenter).b(true, false);
        return false;
      }
      if (i1 == R.id.menu_group_call)
      {
        ((OptionsMenuPresenter)this.mPresenter).d();
        return false;
      }
      if ((i1 == R.id.menu_add_participants) || (i1 == R.id.menu_create_group))
      {
        this.s.R();
        return false;
      }
      if (i1 == R.id.menu_clear_chat)
      {
        this.s.Q();
        return false;
      }
      if (i1 == R.id.menu_switch_to_secret)
      {
        this.s.O();
        return false;
      }
      if (i1 == R.id.menu_generate_engagement_notification)
      {
        this.s.T();
        return false;
      }
      if (i1 == R.id.menu_mark_as_invalid)
      {
        this.s.b(true, false);
        return false;
      }
      if (i1 == R.id.menu_mark_as_invalid_member_id)
      {
        this.s.b(true, true);
        return false;
      }
      if (i1 == R.id.menu_create_duplicate_participant)
      {
        this.s.U();
        return false;
      }
      if (i1 == R.id.menu_share_public_account)
      {
        this.s.H();
        return false;
      }
      if (i1 == R.id.menu_open_public_chat)
      {
        this.s.G();
        return false;
      }
      if (i1 == R.id.menu_conversation_info)
      {
        ((OptionsMenuPresenter)this.mPresenter).b();
        return false;
      }
    }
    while (i1 != R.id.menu_try_remove_conference_banner);
    this.s.V();
    return false;
  }

  public static abstract interface a
  {
    public abstract void G();

    public abstract void H();

    public abstract void N();

    public abstract void O();

    public abstract void Q();

    public abstract void R();

    public abstract void S();

    public abstract void T();

    public abstract void U();

    public abstract void V();

    public abstract boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString);

    public abstract void b(boolean paramBoolean1, boolean paramBoolean2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.q
 * JD-Core Version:    0.6.2
 */