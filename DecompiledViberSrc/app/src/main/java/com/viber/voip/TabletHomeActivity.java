package com.viber.voip;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.calls.ui.KeypadFragment.b;
import com.viber.voip.calls.ui.RecentCallsFragment.a;
import com.viber.voip.contacts.ui.ContactDetailsFragment;
import com.viber.voip.contacts.ui.ContactDetailsFragment.c;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.chatinfo.presentation.ChatInfoActivity;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.ConversationFragment.a;
import com.viber.voip.permissions.h;
import com.viber.voip.permissions.k;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.CallFragmentManager;
import com.viber.voip.phone.CallFragmentManager.CallFragmentManagerCallback;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.ui.MenuSearchMediator;
import com.viber.voip.ui.ba.a;
import com.viber.voip.ui.f.f;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.editinfo.EditInfoFragment.EditInfoPageDisplayState;
import com.viber.voip.user.more.MoreFragment.Callbacks;
import com.viber.voip.util.al;
import com.viber.voip.util.bc;
import com.viber.voip.util.bd;
import com.viber.voip.util.bd.a;
import com.viber.voip.util.dj;
import com.viber.voip.util.links.e;
import java.lang.reflect.Field;
import javax.inject.Inject;

public class TabletHomeActivity extends HomeActivity
  implements View.OnClickListener, au, KeypadFragment.b, RecentCallsFragment.a, ContactDetailsFragment.c, ConversationFragment.a, CallFragmentManager.CallFragmentManagerCallback, ba.a, EditInfoFragment.EditInfoPageDisplayState, MoreFragment.Callbacks, al, bd.a
{
  private static final Logger P = ViberEnv.getLogger();
  private static ae Q;

  @Inject
  ai K;

  @Inject
  UserManager L;

  @Inject
  e M;

  @Inject
  dagger.a<com.viber.voip.analytics.story.e.c> N;

  @Inject
  af O;
  private CallFragmentManager R;
  private boolean S;
  private TextView T;
  private TextView U;
  private ActionMenuView V;
  private boolean W = true;
  private final com.viber.common.permission.b X;

  public TabletHomeActivity()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(87);
    this.X = new h(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        TabletHomeActivity.this.c.d(false);
      }
    };
  }

  private boolean v()
  {
    return (this.mIsTablet) && (!ao.f());
  }

  private void w()
  {
    if (this.m.a());
    try
    {
      Field localField = Toolbar.class.getDeclaredField("mMenuView");
      localField.setAccessible(true);
      ActionMenuView localActionMenuView = (ActionMenuView)localField.get(this.d);
      if (this.V != localActionMenuView)
      {
        this.V = localActionMenuView;
        dj.a(this.V, new ar(this));
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void x()
  {
    if (!e());
    for (int i = t(); ; i = 35)
    {
      if (getWindow().getAttributes().softInputMode != i)
        getWindow().setSoftInputMode(i);
      return;
    }
  }

  protected void a()
  {
  }

  public void a(int paramInt, Fragment paramFragment)
  {
    if (this.c != null)
      this.c.a(paramInt, paramFragment);
  }

  protected void a(Intent paramIntent, boolean paramBoolean)
  {
    super.a(paramIntent, paramBoolean);
    a(paramIntent);
    g(ac.a);
    if ("com.viber.voip.action.MESSAGES".equals(paramIntent.getAction()))
      this.c.g();
  }

  protected void a(Bundle paramBundle)
  {
    this.c = new bd(this.b, this.N);
  }

  public void a(PreferenceScreen paramPreferenceScreen)
  {
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt, String paramString)
  {
    if (this.c != null)
      this.c.a(paramConversationItemLoaderEntity, paramInt, paramString);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if (this.c != null)
      this.c.a(paramConversationItemLoaderEntity, paramBoolean);
  }

  public void a(ConversationData paramConversationData)
  {
  }

  public void a(boolean paramBoolean)
  {
    this.c.e(paramBoolean);
  }

  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (this.c != null)
      this.c.a(paramBoolean, paramIntent);
  }

  public boolean a(Fragment paramFragment)
  {
    return (this.c == null) || (this.c.a(paramFragment));
  }

  public boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString)
  {
    if (paramConversationItemLoaderEntity != null)
    {
      ((com.viber.voip.analytics.story.e.c)this.N.get()).b(paramConversationItemLoaderEntity, paramString);
      Intent localIntent = new Intent(this, ChatInfoActivity.class);
      localIntent.putExtra("conversation_type", paramConversationItemLoaderEntity.getConversationType());
      localIntent.putExtra("conversation_id", paramConversationItemLoaderEntity.getId());
      if (paramConversationItemLoaderEntity.isSecret())
        com.viber.voip.ui.c.c.a(localIntent);
      startActivity(localIntent);
      return true;
    }
    return false;
  }

  public void a_(Intent paramIntent)
  {
    if (this.c != null)
      this.c.c(paramIntent);
    this.S = paramIntent.getBooleanExtra("clicked", true);
    if (this.S)
      Q.postDelayed(new a(this, null), 300L);
  }

  public void addConversationIgnoredView(View paramView)
  {
    if (this.c != null)
      this.c.addConversationIgnoredView(paramView);
  }

  protected void b(Bundle paramBundle)
  {
    this.a = new bc(this, getSupportActionBar(), LayoutInflater.from(this));
    bd localbd = this.c;
    bc localbc = this.a;
    f localf = this.e;
    if (paramBundle == null);
    for (Bundle localBundle = null; ; localBundle = paramBundle.getBundle("com.viber.voip.HomeActivity.fragmentManager"))
    {
      localbd.a(this, this, localbc, localf, localBundle);
      return;
    }
  }

  public void b(boolean paramBoolean)
  {
    this.c.d(paramBoolean);
  }

  protected void c(int paramInt)
  {
    super.c(paramInt);
    x();
  }

  public void c(Intent paramIntent)
  {
    if (this.c != null)
      this.c.f(paramIntent);
  }

  public void c(boolean paramBoolean)
  {
    this.c.c(paramBoolean);
  }

  protected boolean c()
  {
    return true;
  }

  public void d(Intent paramIntent)
  {
    if (this.c != null)
      this.c.e(paramIntent);
  }

  public void d(boolean paramBoolean)
  {
    if (this.W == paramBoolean)
      return;
    this.W = paramBoolean;
    invalidateOptionsMenu();
  }

  public void e(int paramInt)
  {
    super.e(paramInt);
    this.c.b();
    this.c.i();
  }

  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.c != null)
      this.c.d(paramIntent);
  }

  public void endCall()
  {
    this.R.endCall();
  }

  public void f(Intent paramIntent)
  {
  }

  protected void g()
  {
    if (this.c != null)
    {
      ((com.viber.voip.analytics.story.b.c)this.C.get()).a("Calls Screen - View All");
      this.c.e();
    }
  }

  public void g(Intent paramIntent)
  {
    ConversationData localConversationData;
    aq localaq;
    if (this.c != null)
    {
      this.c.c();
      localConversationData = (ConversationData)paramIntent.getParcelableExtra("extra_conversation_data");
      localaq = new aq(this, paramIntent);
      if (0L < localConversationData.conversationId)
        break label112;
      this.L.getUser();
      if ((localConversationData.conversationType == 0) && (!com.viber.voip.messages.m.a(this.O, localConversationData.memberId)))
        this.K.a(localConversationData.conversationType, new Member(localConversationData.memberId, localConversationData.number), localConversationData.groupId, true, localConversationData.secretConversation, localaq);
    }
    return;
    label112: this.K.a(localConversationData.conversationId, localaq);
  }

  public k getPermissionConfigForFragment(Fragment paramFragment)
  {
    k localk = super.getPermissionConfigForFragment(paramFragment);
    if ((paramFragment instanceof ContactDetailsFragment))
    {
      localk.a(0, 84);
      localk.a(1, 60);
      localk.a(3, 36);
      localk.a(2, 46);
      localk.a(4, 44);
    }
    return localk;
  }

  public void h(Intent paramIntent)
  {
    if (this.c != null)
      this.c.a(paramIntent);
  }

  public void i(Intent paramIntent)
  {
    if (this.c != null)
      this.c.b(paramIntent);
  }

  public boolean isEditInfoPageInPhoneMode()
  {
    return true;
  }

  public boolean isReadyToShowAd()
  {
    return this.R.isReadyToShowAd();
  }

  public void k()
  {
    this.c.q();
  }

  public boolean l()
  {
    return this.c.r();
  }

  public void m()
  {
    Q.postDelayed(new a(this, null), 300L);
  }

  public TextView n()
  {
    android.support.v7.app.a locala;
    if (this.T == null)
    {
      locala = getSupportActionBar();
      if (locala == null)
        break label40;
    }
    label40: for (TextView localTextView = (TextView)locala.a().findViewById(R.id.abs__action_bar_title); ; localTextView = null)
    {
      this.T = localTextView;
      return this.T;
    }
  }

  public TextView o()
  {
    android.support.v7.app.a locala;
    if (this.U == null)
    {
      locala = getSupportActionBar();
      if (locala == null)
        break label40;
    }
    label40: for (TextView localTextView = (TextView)locala.a().findViewById(R.id.abs__action_bar_title); ; localTextView = null)
    {
      this.U = localTextView;
      return this.U;
    }
  }

  public void onBackPressed()
  {
    int i = 1;
    if (this.c.l())
      i = 0;
    if ((d()) && (this.R.canVideoGoBack()))
      i = 0;
    if (i == 0)
      return;
    super.onBackPressed();
  }

  public void onClick(View paramView)
  {
    if (R.id.button_request_permission == paramView.getId())
      this.h.a(this, 87, n.j);
  }

  protected void onCreate(Bundle paramBundle)
  {
    getWindow().setFormat(-3);
    if (Q == null)
      Q = new ae(this);
    while (true)
    {
      super.onCreate(paramBundle);
      this.R = new CallFragmentManager(this, R.id.home_dialer_container, false, true);
      this.R.setSlidingMenuIgnoreViewCallback(this);
      this.c.a(this.R);
      return;
      Q.a(this);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    w();
    return bool;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (d())
      this.R.onDestroy(this);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      this.c.l();
      return true;
    }
    return false;
  }

  protected void onPause()
  {
    super.onPause();
    if (d())
      this.R.onPause(this);
    if (!isFinishing())
    {
      boolean bool1 = MenuSearchMediator.b;
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      com.viber.voip.messages.ui.MessageComposerView.a = bool2;
      com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.b = true;
      return;
    }
    com.viber.voip.messages.ui.MessageComposerView.a = false;
  }

  protected void onPostResume()
  {
    super.onPostResume();
    if (!d())
      this.c.d();
    x();
  }

  protected void onResume()
  {
    super.onResume();
    this.c.h();
  }

  protected void onResumeFragments()
  {
    super.onResumeFragments();
    if (d())
      this.R.onResume(this);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.c != null)
      paramBundle.putBundle("com.viber.voip.HomeActivity.fragmentManager", this.c.s());
    super.onSaveInstanceState(paramBundle);
  }

  protected void onStart()
  {
    super.onStart();
    if (d())
      this.R.onStart(this);
    if (v())
      this.h.a(this.X);
  }

  protected void onStop()
  {
    super.onStop();
    if (d())
      this.R.onStop(this);
    if (v())
      this.h.b(this.X);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.c.a(paramBoolean);
    this.M.a(paramBoolean, hashCode());
  }

  public void p()
  {
    if (this.c != null)
      this.c.p();
  }

  public void q()
  {
    Fragment localFragment = this.b.a(ac.a);
    if ((localFragment instanceof ContactDetailsFragment.c))
      ((ContactDetailsFragment.c)localFragment).q();
  }

  public void r()
  {
    if (this.c != null)
      this.c.j();
  }

  public void removeConversationIgnoredView(View paramView)
  {
    if (this.c != null)
      this.c.removeConversationIgnoredView(paramView);
  }

  public boolean s()
  {
    return !this.m.a();
  }

  public int t()
  {
    return 17;
  }

  private static class a extends com.viber.voip.d.b<TabletHomeActivity>
  {
    private a(TabletHomeActivity paramTabletHomeActivity)
    {
      super();
    }

    public void a(TabletHomeActivity paramTabletHomeActivity)
    {
      TabletHomeActivity.a(paramTabletHomeActivity, false);
      if (paramTabletHomeActivity.c != null)
        paramTabletHomeActivity.c.f();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.TabletHomeActivity
 * JD-Core Version:    0.6.2
 */