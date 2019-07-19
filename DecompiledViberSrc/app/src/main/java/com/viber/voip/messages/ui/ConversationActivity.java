package com.viber.voip.messages.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.c;
import com.slidingmenu.lib.SlidingMenu.e;
import com.slidingmenu.lib.SlidingMenu.g;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.anim;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.contacts.ui.s.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationFragment;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupsFragment.a;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.ConversationFragment.a;
import com.viber.voip.messages.conversation.ui.aq.b;
import com.viber.voip.u.d;
import com.viber.voip.ui.ap.a;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.bc;
import com.viber.voip.util.ViberActionRunner.k;
import com.viber.voip.util.dj;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

public class ConversationActivity extends ViberFragmentActivity
  implements SlidingMenu.c, SlidingMenu.e, SlidingMenu.g, s.a, PublicGroupsFragment.a, ConversationFragment.a, aq.b, SmsInboxMessagesLeftMenuFragment.b, bk.a, dagger.android.support.b
{
  private static final Logger o = ViberEnv.getLogger();

  @Inject
  Handler a;

  @Inject
  com.viber.voip.messages.controller.manager.k b;

  @Inject
  com.viber.voip.messages.ui.media.player.d.e c;
  protected SlidingMenu d;
  protected h e;
  protected ConversationFragment f;
  protected com.viber.voip.messages.conversation.chatinfo.presentation.b g;
  protected TextView h;
  protected TextView i;
  protected Toolbar j;

  @Inject
  dagger.android.c<Fragment> k;

  @Inject
  ICdrController l;

  @Inject
  protected dagger.a<com.viber.voip.analytics.story.e.c> m;

  @Inject
  protected dagger.a<com.viber.voip.analytics.story.a.a> n;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private Bundle u;
  private ConversationItemLoaderEntity v;
  private com.viber.voip.ui.c w;
  private ap.a<com.viber.voip.ui.a> x;
  private Runnable y = new a(this, null);

  private boolean d(Intent paramIntent)
  {
    boolean bool1 = paramIntent.getBooleanExtra("go_up", false);
    boolean bool2 = false;
    String str;
    int i1;
    label67: Intent localIntent;
    if (bool1)
    {
      str = paramIntent.getAction();
      if (str == null)
        break label234;
      switch (str.hashCode())
      {
      default:
        i1 = -1;
        switch (i1)
        {
        default:
          localIntent = ViberActionRunner.ab.a(this);
        case 0:
        case 1:
        case 2:
        }
        break;
      case -1899526064:
      case -269058222:
      case -1845805717:
      }
    }
    while (true)
    {
      startActivity(localIntent);
      bool2 = true;
      return bool2;
      if (!str.equals("com.viber.voip.action.PUBLIC_CONVERSATION"))
        break;
      i1 = 0;
      break label67;
      if (!str.equals("com.viber.voip.action.BUSINESS_INBOX_CONVERSATION"))
        break;
      i1 = 1;
      break label67;
      if (!str.equals("com.viber.voip.action.SMS_INBOX_CONVERSATION"))
        break;
      i1 = 2;
      break label67;
      localIntent = ViberActionRunner.aq.b();
      continue;
      this.l.handleReportScreenDisplay(4, 2);
      ((com.viber.voip.analytics.story.a.a)this.n.get()).c("Back");
      localIntent = ViberActionRunner.k.a(this).addFlags(67108864);
      continue;
      localIntent = ViberActionRunner.bc.a(this, this.v.getToNumber()).addFlags(67108864);
      continue;
      label234: localIntent = ViberActionRunner.ab.a(this);
    }
  }

  private void i()
  {
    Intent localIntent = getIntent();
    this.f.a(localIntent, false);
    this.u = localIntent.getExtras();
  }

  private void j()
  {
    if (this.c != null)
      this.c.a();
  }

  private void k()
  {
    boolean bool1 = true;
    if ((isFinishing()) || (this.d == null))
      return;
    boolean bool2 = g();
    boolean bool3 = I();
    if ((bool2) || (bool3))
      dj.c(this.d);
    boolean bool4;
    if (this.f != null)
    {
      ConversationFragment localConversationFragment = this.f;
      if (bool2)
        break label160;
      bool4 = bool1;
      label63: localConversationFragment.setHasOptionsMenu(bool4);
      if (this.s != bool2)
        this.f.D();
      if ((bool2) || (bool3))
        break label166;
    }
    while (true)
    {
      b(bool1);
      a(bool3);
      if (this.t)
        this.f.d(bool3);
      if (this.e != null)
        this.e.setUserVisibleHint(bool2);
      this.s = bool2;
      this.t = false;
      if (!bool2)
        break;
      com.viber.voip.analytics.f.a.a(new com.crashlytics.android.a.m("chat_list_opened"));
      return;
      label160: bool4 = false;
      break label63;
      label166: bool1 = false;
    }
  }

  private void l()
  {
    this.d.setOnOpenedListener(this);
    this.d.setOnClosedListener(this);
    this.d.setOnStartDragListener(this);
    this.d.setShadowWidthRes(R.dimen.shadow_width);
    this.d.setBehindOffsetRes(R.dimen.slidingmenu_offset);
    this.d.setFadeDegree(0.35F);
    this.d.setMode(1);
    this.d.setTouchModeAbove(2);
    this.d.setShadowDrawable(R.drawable.shadow_left);
    this.d.setSecondaryShadowDrawable(R.drawable.shadow_right);
    this.d.setRightSwipeInitialAvailableArea(getResources().getDimensionPixelSize(R.dimen.replyable_distance_requirements));
    e();
  }

  private void q()
  {
    if (this.f != null)
    {
      FragmentTransaction localFragmentTransaction1 = getSupportFragmentManager().beginTransaction();
      Iterator localIterator1 = getSupportFragmentManager().getFragments().iterator();
      while (localIterator1.hasNext())
      {
        Fragment localFragment1 = (Fragment)localIterator1.next();
        if ((localFragment1 instanceof com.viber.common.dialogs.m))
        {
          localFragmentTransaction1.remove(localFragment1);
        }
        else if (((localFragment1 instanceof com.viber.voip.messages.conversation.chatinfo.presentation.b)) && (localFragment1.isAdded()))
        {
          List localList = localFragment1.getChildFragmentManager().getFragments();
          FragmentTransaction localFragmentTransaction2 = localFragment1.getChildFragmentManager().beginTransaction();
          Iterator localIterator2 = localList.iterator();
          while (localIterator2.hasNext())
          {
            Fragment localFragment2 = (Fragment)localIterator2.next();
            if ((localFragment2 instanceof com.viber.common.dialogs.m))
              localFragmentTransaction2.remove(localFragment2);
          }
          localFragmentTransaction2.commitNowAllowingStateLoss();
        }
      }
      localFragmentTransaction1.commitNowAllowingStateLoss();
    }
  }

  public boolean I()
  {
    return (this.d != null) && (this.d.e());
  }

  public void a()
  {
    k();
    ViberApplication.getInstance().getMessagesManager().n().a(true, false);
  }

  public void a(int paramInt)
  {
    h localh;
    if (this.e != null)
    {
      localh = this.e;
      if (paramInt != 0)
        break label59;
    }
    label59: for (boolean bool = true; ; bool = false)
    {
      localh.setUserVisibleHint(bool);
      dj.c(this.d);
      if (paramInt == 0)
        ViberApplication.getInstance().getMessagesManager().n().a(false, false);
      this.t = true;
      return;
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
  }

  public void a(int paramInt, Fragment paramFragment)
  {
  }

  public void a(Intent paramIntent)
  {
    startActivity(paramIntent);
  }

  protected void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    SlidingMenu localSlidingMenu = this.d;
    int i1;
    if (paramConversationItemLoaderEntity.isInBusinessInbox())
      i1 = R.layout._ics_activity_business_inbox_conversation_left_menu;
    while (true)
    {
      localSlidingMenu.setMenu(i1);
      if (this.d.getSecondaryMenu() == null)
        this.d.setSecondaryMenu(R.layout.activity_conversation_group_info_right_menu);
      this.g = ((com.viber.voip.messages.conversation.chatinfo.presentation.b)getSupportFragmentManager().findFragmentById(R.id.conversation_info_fragment));
      this.e = ((h)getSupportFragmentManager().findFragmentById(R.id.messages_fragment));
      this.e.setHasOptionsMenu(false);
      this.e.setUserVisibleHint(false);
      return;
      if (paramConversationItemLoaderEntity.isVlnConversation())
        i1 = R.layout._ics_activity_sms_inbox_conversation_left_menu;
      else
        i1 = R.layout._ics_activity_conversation_left_menu;
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt, String paramString)
  {
    if (this.g != null)
      this.g.a(paramInt, paramString);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if (!this.b.b().contains(Long.valueOf(paramConversationItemLoaderEntity.getId())))
      this.b.d();
    this.v = paramConversationItemLoaderEntity;
    a(this.v.isSecret(), this.v.isInBusinessInbox(), this.v.isVlnConversation());
    if (!this.q)
    {
      this.a.removeCallbacks(this.y);
      this.a.postDelayed(this.y, 650L);
    }
    while (true)
    {
      if ((paramBoolean) && (this.p))
        this.a.postDelayed(new b(this, null), 500L);
      return;
      if (!this.r)
      {
        b(paramConversationItemLoaderEntity, paramBoolean);
        b(paramConversationItemLoaderEntity);
      }
    }
  }

  public void a(ConversationData paramConversationData)
  {
    if (paramConversationData != null)
      a(paramConversationData.secretConversation, paramConversationData.isInBusinessInbox, paramConversationData.isInSmsInbox);
  }

  protected void a(boolean paramBoolean)
  {
    if (this.g != null)
      this.g.onFragmentVisibilityChanged(paramBoolean);
  }

  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      this.w.d(2);
      return;
    }
    if (paramBoolean3)
    {
      this.w.d(3);
      return;
    }
    if (paramBoolean1)
    {
      this.w.d(1);
      return;
    }
    this.w.d(0);
  }

  public boolean a(Fragment paramFragment)
  {
    return true;
  }

  public boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString)
  {
    if ((this.q) && (!this.r))
    {
      if (this.d.d())
        this.d.c();
      while (true)
      {
        return true;
        this.d.b();
        if (paramConversationItemLoaderEntity != null)
          ((com.viber.voip.analytics.story.e.c)this.m.get()).b(paramConversationItemLoaderEntity, paramString);
      }
    }
    return false;
  }

  public void a_(Intent paramIntent)
  {
    c(paramIntent);
    this.f.a(paramIntent, false);
    this.p = true;
    com.viber.voip.analytics.f.a.a(new com.crashlytics.android.a.m("chat_opened_via_left_menu"));
  }

  public void addConversationIgnoredView(View paramView)
  {
    this.d.a(paramView);
  }

  public void b()
  {
    k();
  }

  public void b(Intent paramIntent)
  {
  }

  protected void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if (isFinishing());
    do
    {
      return;
      this.e.a(paramConversationItemLoaderEntity, paramBoolean);
    }
    while (this.g == null);
    this.g.a(paramConversationItemLoaderEntity, paramBoolean);
  }

  protected void b(boolean paramBoolean)
  {
    if (this.f != null)
      this.f.onFragmentVisibilityChanged(paramBoolean);
  }

  public boolean b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    int i1 = this.d.getMode();
    if (paramConversationItemLoaderEntity != null)
      if ((paramConversationItemLoaderEntity.isSystemConversation()) || (paramConversationItemLoaderEntity.isNonReplyableChat()) || (paramConversationItemLoaderEntity.isPublicGroupType()) || (paramConversationItemLoaderEntity.isVlnConversation()) || ((paramConversationItemLoaderEntity.isDisabledConversation()) && ((paramConversationItemLoaderEntity.isGroupType()) || (paramConversationItemLoaderEntity.isCommunityType()))))
      {
        if (!this.d.g())
          break label154;
        this.d.c(false);
        i1 = 0;
      }
    while (true)
    {
      if (paramConversationItemLoaderEntity.getConversationType() == 3)
        this.d.setTouchModeAbove(2);
      while (true)
      {
        int i2 = this.d.getMode();
        boolean bool = false;
        if (i2 != i1)
        {
          this.d.setMode(i1);
          bool = true;
        }
        return bool;
        i1 = 2;
        break;
        this.d.setTouchModeAbove(0);
        continue;
        this.d.setTouchModeAbove(2);
      }
      label154: i1 = 0;
    }
  }

  public void b_(Intent paramIntent)
  {
    this.f.a(paramIntent, false);
    this.p = true;
  }

  protected void c(Intent paramIntent)
  {
    boolean bool1 = true;
    if ((paramIntent != null) && ("com.viber.voip.action.COMMUNITY_CONVERSATION".equals(paramIntent.getAction())));
    for (boolean bool2 = bool1; ; bool2 = false)
    {
      boolean bool3 = this.f instanceof PublicGroupConversationFragment;
      q();
      if ((this.f == null) || (bool2 != bool3))
        break;
      return;
    }
    int i1;
    label109: ConversationFragment localConversationFragment;
    if (bool2)
    {
      i1 = R.layout._ics_activity_conversation_community_content;
      if (this.f == null)
        break label154;
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.remove(this.f);
      localFragmentTransaction.commitNowAllowingStateLoss();
      this.d.h();
      this.d.setContentWithoutShowing(i1);
      this.f = ((ConversationFragment)getSupportFragmentManager().findFragmentById(R.id.conversation_fragment));
      localConversationFragment = this.f;
      if (this.s)
        break label173;
    }
    while (true)
    {
      localConversationFragment.setHasOptionsMenu(bool1);
      return;
      i1 = R.layout._ics_activity_conversation_content;
      break;
      label154: this.d.h();
      this.d.setContent(i1);
      break label109;
      label173: bool1 = false;
    }
  }

  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
      d(getIntent());
    finish();
  }

  protected boolean c()
  {
    return false;
  }

  protected void d()
  {
    this.j = ((Toolbar)findViewById(R.id.toolbar));
    setSupportActionBar(this.j);
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
      locala.b(true);
  }

  protected void e()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i1 = (int)TypedValue.applyDimension(0, localDisplayMetrics.widthPixels / 2, localDisplayMetrics);
    if (this.d != null)
      this.d.setTouchmodeMarginThreshold(i1);
  }

  public boolean f()
  {
    return (this.d != null) && (this.d.e());
  }

  public void finish()
  {
    try
    {
      super.finish();
      overridePendingTransition(R.anim.screen_no_transition, R.anim.screen_out);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public boolean g()
  {
    return (this.d != null) && (this.d.f());
  }

  public String h()
  {
    if (this.v != null)
      return this.v.getToNumber();
    return null;
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  public void m()
  {
    this.d.c();
  }

  public TextView n()
  {
    if (this.h == null)
      this.h = dj.f(this.j);
    return this.h;
  }

  public TextView o()
  {
    if (this.i == null)
      this.i = dj.g(this.j);
    return this.i;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ViberApplication.getInstance().getFacebookManager().a(this, paramInt1, paramInt2, paramIntent);
    if (this.f != null)
      this.f.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    if (this.d.d())
      this.d.c();
    while ((this.f != null) && (this.f.onBackPressed()))
      return;
    if (d(getIntent()))
    {
      j();
      finish();
      return;
    }
    j();
    super.onBackPressed();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    e();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    getWindow().setFormat(-3);
    super.onCreate(paramBundle);
    if (this.mIsTablet)
    {
      finish();
      return;
    }
    if (c());
    for (int i1 = R.layout.activity_public_conversation; ; i1 = R.layout.activity_conversation)
    {
      setContentView(i1);
      this.x = new r(this);
      this.w = new com.viber.voip.ui.c(this, new com.viber.voip.ui.c.h());
      this.w.a(this.x);
      d();
      this.d = ((SlidingMenu)findViewById(R.id.conversation_sliding_view));
      l();
      c(getIntent());
      if (paramBundle == null)
        break;
      this.u = paramBundle.getBundle("handled_extras");
      if (this.u == null)
        break;
      getIntent().replaceExtras(this.u);
      return;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.w != null)
      this.w.b(this.x);
    this.a.removeCallbacks(this.y);
    this.b.d();
    this.b.a(null);
    this.f = null;
    this.e = null;
    this.g = null;
    this.d = null;
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    c(paramIntent);
    this.d.c(false);
    setIntent(paramIntent);
    i();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    if (this.f != null)
      this.f.onBackPressed();
    j();
    c(true);
    return true;
  }

  protected void onPause()
  {
    super.onPause();
    b(false);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    i();
    sendBroadcast(new Intent("com.viber.voip.action.CLOSE_POPUP"));
  }

  protected void onRestart()
  {
    super.onRestart();
    sendBroadcast(new Intent("com.viber.voip.action.CLOSE_POPUP"));
  }

  protected void onResume()
  {
    super.onResume();
    if ((!g()) && (!I()))
      b(true);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.u != null)
      paramBundle.putBundle("handled_extras", this.u);
  }

  public void onSupportActionModeStarted(android.support.v7.view.b paramb)
  {
    super.onSupportActionModeStarted(paramb);
    ((com.viber.voip.ui.a)this.w.a()).d(this);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.b.a(paramBoolean);
    com.viber.voip.util.links.e.a().a(paramBoolean, hashCode());
  }

  public void p()
  {
    if (this.g != null)
      this.g.b("Add participant Icon - Chat");
  }

  public void removeConversationIgnoredView(View paramView)
  {
    this.d.b(paramView);
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.k;
  }

  private static class a extends com.viber.voip.d.b<ConversationActivity>
  {
    private a(ConversationActivity paramConversationActivity)
    {
      super();
    }

    public void a(final ConversationActivity paramConversationActivity)
    {
      if ((!paramConversationActivity.isFinishing()) && (ConversationActivity.a(paramConversationActivity) != null) && (!ConversationActivity.b(paramConversationActivity)))
        ConversationActivity.a(paramConversationActivity, true);
      try
      {
        paramConversationActivity.a(ConversationActivity.a(paramConversationActivity));
        paramConversationActivity.b(ConversationActivity.a(paramConversationActivity), true);
        paramConversationActivity.b(ConversationActivity.a(paramConversationActivity));
        paramConversationActivity.a(false);
        final ConversationFragment localConversationFragment = paramConversationActivity.f;
        if (localConversationFragment.aC)
          paramConversationActivity.a.postDelayed(new Runnable()
          {
            public void run()
            {
              ConversationFragment localConversationFragment;
              if (localConversationFragment.aC)
              {
                localConversationFragment = localConversationFragment;
                if (localConversationFragment.a(ConversationActivity.a(paramConversationActivity), null))
                  break label41;
              }
              label41: for (boolean bool = true; ; bool = false)
              {
                localConversationFragment.aC = bool;
                return;
              }
            }
          }
          , 500L);
        return;
      }
      catch (Exception localException)
      {
        ConversationActivity.b(paramConversationActivity, true);
      }
    }
  }

  private static class b extends com.viber.voip.d.b<ConversationActivity>
  {
    private b(ConversationActivity paramConversationActivity)
    {
      super();
    }

    public void a(ConversationActivity paramConversationActivity)
    {
      if ((paramConversationActivity != null) && (!paramConversationActivity.isFinishing()) && (paramConversationActivity.d != null))
      {
        paramConversationActivity.d.c();
        ConversationActivity.c(paramConversationActivity, false);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ConversationActivity
 * JD-Core Version:    0.6.2
 */