package com.viber.voip.messages.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.slidingmenu.lib.SlidingMenu;
import com.viber.dexshared.Logger;
import com.viber.voip.R.bool;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.manager.k;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.publicaccount.ui.screen.info.a.a;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.dj;
import com.viber.voip.widget.FullDrawerLayout;
import com.viber.voip.widget.MessageBar;

public class PublicAccountConversationActivity extends ConversationActivity
  implements DrawerLayout.DrawerListener, a.a
{
  private static final Logger o = ViberEnv.getLogger();
  private FullDrawerLayout p;
  private FrameLayout q;
  private MessageBar r;
  private Handler s;
  private a t;
  private cj u;
  private WindowInsetsCompat v;
  private boolean w;
  private cj.a x = new cj.a()
  {
    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      PublicAccountConversationActivity.b(PublicAccountConversationActivity.this).removeCallbacks(PublicAccountConversationActivity.a(PublicAccountConversationActivity.this));
      if (-1 == paramAnonymousInt2)
        PublicAccountConversationActivity.b(PublicAccountConversationActivity.this).postDelayed(PublicAccountConversationActivity.a(PublicAccountConversationActivity.this), 7000L);
    }
  };
  private FragmentManager.FragmentLifecycleCallbacks y = new FragmentManager.FragmentLifecycleCallbacks()
  {
    public void onFragmentActivityCreated(FragmentManager paramAnonymousFragmentManager, Fragment paramAnonymousFragment, Bundle paramAnonymousBundle)
    {
      if (paramAnonymousFragment.getId() == R.id.conversation_fragment)
        PublicAccountConversationActivity.d(PublicAccountConversationActivity.this).a(PublicAccountConversationActivity.c(PublicAccountConversationActivity.this));
    }

    public void onFragmentViewDestroyed(FragmentManager paramAnonymousFragmentManager, Fragment paramAnonymousFragment)
    {
      if (paramAnonymousFragment.getId() == R.id.conversation_fragment)
      {
        PublicAccountConversationActivity.b(PublicAccountConversationActivity.this).removeCallbacks(PublicAccountConversationActivity.a(PublicAccountConversationActivity.this));
        PublicAccountConversationActivity.d(PublicAccountConversationActivity.this).b(PublicAccountConversationActivity.c(PublicAccountConversationActivity.this));
        if (PublicAccountConversationActivity.e(PublicAccountConversationActivity.this) != null)
          PublicAccountConversationActivity.e(PublicAccountConversationActivity.this).a();
      }
    }
  };

  private void d(boolean paramBoolean)
  {
    dj.b(this.d, paramBoolean);
    dj.b(this.j, paramBoolean);
    b(paramBoolean);
  }

  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.p.openDrawer(5);
      return;
    }
    this.p.closeDrawer(5);
  }

  private void k()
  {
    if (isFinishing())
      return;
    if (this.r == null)
      this.r = new MessageBar(this);
    Application localApplication = ViberApplication.getApplication();
    this.r.a(localApplication.getString(R.string.vibe_no_internet_connection), localApplication.getString(R.string.vibe_unable_retrieve_recent_msgs), R.drawable.ic_mb_close, false, false);
  }

  public boolean I()
  {
    return (this.p != null) && (this.p.isDrawerOpen(5));
  }

  public void a()
  {
    super.a();
    this.p.setDrawerLockMode(0, 5);
  }

  protected void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.d.setMenu(R.layout._ics_activity_conversation_publicgroup_left_menu);
    if (this.q.getChildCount() == 0)
    {
      getLayoutInflater().inflate(R.layout.activity_public_account_info, this.q, true);
      this.g = ((com.viber.voip.messages.conversation.chatinfo.presentation.b)getSupportFragmentManager().findFragmentById(R.id.fragment_public_account_info));
      this.e = ((h)getSupportFragmentManager().findFragmentById(R.id.public_groups_fragment));
      this.e.setHasOptionsMenu(false);
      this.e.setUserVisibleHint(false);
      if ((!this.mIsTablet) && (this.v != null))
      {
        View localView = findViewById(R.id.app_bar);
        if (localView != null)
        {
          ViewCompat.onApplyWindowInsets(localView, this.v);
          this.v = null;
        }
      }
    }
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    e(false);
  }

  public boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString)
  {
    boolean bool1 = I();
    if ((paramConversationItemLoaderEntity != null) && (!bool1))
      ((c)this.m.get()).b(paramConversationItemLoaderEntity, paramString);
    if (!bool1);
    for (boolean bool2 = true; ; bool2 = false)
    {
      e(bool2);
      return true;
    }
  }

  public void b()
  {
    super.b();
    this.p.setDrawerLockMode(1);
  }

  public boolean b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    super.b(paramConversationItemLoaderEntity);
    if ((this.p != null) && (!I()) && (this.p.getDrawerLockMode(5) != 0))
      this.p.setDrawerLockMode(0, 5);
    return false;
  }

  protected void c(Intent paramIntent)
  {
    if (this.f == null)
    {
      this.f = ((ConversationFragment)getSupportFragmentManager().findFragmentById(R.id.conversation_fragment));
      this.f.setHasOptionsMenu(true);
    }
  }

  protected boolean c()
  {
    return true;
  }

  protected void e()
  {
  }

  public boolean f()
  {
    return (this.p != null) && (this.p.isDrawerVisible(5));
  }

  public void i()
  {
    e(false);
  }

  public boolean isSwitchingThemeSupported()
  {
    return false;
  }

  public boolean j()
  {
    return false;
  }

  public void m()
  {
    super.m();
    e(false);
  }

  public TextView n()
  {
    if (this.h == null)
      this.h = dj.f(this.j);
    return this.h;
  }

  public void onBackPressed()
  {
    if (I())
    {
      if ((this.g instanceof com.viber.voip.app.a))
        this.g.onBackPressed();
      e(false);
      return;
    }
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (getResources().getBoolean(R.bool.translucent_status_for_fullscreen))
    {
      View localView = getWindow().getDecorView();
      localView.setSystemUiVisibility(com.viber.voip.util.av.b(localView.getSystemUiVisibility(), 1280, true));
    }
    super.onCreate(paramBundle);
    this.q = ((FrameLayout)findViewById(R.id.conversation_info_holder));
    this.p = ((FullDrawerLayout)findViewById(R.id.drawer));
    this.p.addDrawerListener(this);
    this.p.setDrawerLockMode(1);
    FullDrawerLayout localFullDrawerLayout = this.p;
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = R.id.message_composer;
    arrayOfInt[1] = R.id.conversation_menu;
    localFullDrawerLayout.a(arrayOfInt);
    this.s = com.viber.voip.av.a(av.e.a);
    this.t = new a(this);
    this.u = cj.a(this);
    getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.y, false);
    if (!this.mIsTablet)
      ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainContentContainer), new ci(this));
  }

  public void onDrawerClosed(View paramView)
  {
    this.w = false;
    a(false);
    this.b.a(true);
    d(true);
  }

  public void onDrawerOpened(View paramView)
  {
    if (this.w)
      this.f.d(true);
    this.w = false;
    a(true);
    this.b.a(false);
    d(false);
  }

  public void onDrawerSlide(View paramView, float paramFloat)
  {
  }

  public void onDrawerStateChanged(int paramInt)
  {
    if ((paramInt == 0) && (I()))
      d(false);
    do
    {
      return;
      if (paramInt == 1)
      {
        if (this.p.isDrawerOpen(5))
          d(true);
        this.w = true;
        return;
      }
    }
    while ((paramInt != 2) || (!f()));
    d(true);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    e(false);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem.getItemId() == 16908332) && (I()))
    {
      e(false);
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!I())
      super.onWindowFocusChanged(paramBoolean);
  }

  private static class a extends com.viber.voip.d.b<PublicAccountConversationActivity>
  {
    public a(PublicAccountConversationActivity paramPublicAccountConversationActivity)
    {
      super();
    }

    public void a(PublicAccountConversationActivity paramPublicAccountConversationActivity)
    {
      if (cj.b(paramPublicAccountConversationActivity))
        return;
      PublicAccountConversationActivity.f(paramPublicAccountConversationActivity);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.PublicAccountConversationActivity
 * JD-Core Version:    0.6.2
 */