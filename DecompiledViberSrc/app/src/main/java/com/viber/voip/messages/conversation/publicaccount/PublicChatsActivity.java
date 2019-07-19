package com.viber.voip.messages.conversation.publicaccount;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.TextView;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.c;
import com.slidingmenu.lib.SlidingMenu.e;
import com.slidingmenu.lib.SlidingMenu.g;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.i.c.l;
import com.viber.voip.i.f;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.e;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.ConversationFragment.a;
import com.viber.voip.messages.conversation.ui.ap;
import com.viber.voip.messages.ui.view.ViewPagerWithPagingEnable;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.dj;
import java.lang.reflect.Field;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class PublicChatsActivity extends ViberFragmentActivity
  implements SlidingMenu.c, SlidingMenu.e, SlidingMenu.g, PublicGroupsFragment.a, ConversationFragment.a, dagger.android.support.b
{
  public static final String a = PublicChatsActivity.class.getName();
  public static int b = 2;
  private static final Logger g = ViberEnv.getLogger();

  @Inject
  g c;

  @Inject
  com.viber.voip.analytics.story.e.c d;

  @Inject
  com.viber.voip.messages.controller.manager.k e;

  @Inject
  dagger.android.c<Fragment> f;
  private PublicGroupsFragment h;
  private TabletPublicGroupConversationFragment i;
  private SlidingMenu j;
  private boolean k;
  private int l = -1;
  private View m;
  private View n;
  private Toolbar o;
  private TabLayout p;
  private ViewPagerWithPagingEnable q;
  private TextView r;

  private void a(boolean paramBoolean)
  {
    dj.b(this.p, paramBoolean);
    if (this.q != null)
    {
      this.q.setPagingEnabled(paramBoolean);
      if ((!paramBoolean) && (this.q.getCurrentItem() == 0))
        this.q.setCurrentItem(1, false);
    }
  }

  private void b(Intent paramIntent)
  {
    ConversationData localConversationData = (ConversationData)paramIntent.getParcelableExtra("extra_conversation_data");
    if (localConversationData == null)
      return;
    ai.e local3 = new ai.e()
    {
      public void a(final ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        if (paramAnonymousConversationItemLoaderEntity != null)
          PublicChatsActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              PublicChatsActivity.e(PublicChatsActivity.this).a(paramAnonymousConversationItemLoaderEntity.getId());
            }
          });
      }
    };
    ViberApplication.getInstance().getMessagesManager().c().a(localConversationData.conversationId, local3);
  }

  private void c()
  {
    try
    {
      Field localField = Toolbar.class.getDeclaredField("mTitleTextView");
      localField.setAccessible(true);
      final TextView localTextView = (TextView)localField.get(this.o);
      localTextView.setSingleLine(true);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setGravity(19);
      localTextView.setBackgroundResource(R.drawable.ab_title_bg);
      dj.a(localTextView, new Runnable()
      {
        public void run()
        {
          ViewGroup.LayoutParams localLayoutParams1;
          if (localTextView.getWidth() != 0)
          {
            View localView = PublicChatsActivity.this.findViewById(com.viber.voip.R.id.public_groups_fragment);
            int i = 0;
            if (localView != null)
              i = localView.getMeasuredWidth();
            if (i == 0)
              i = (int)dj.g(PublicChatsActivity.this);
            int j = PublicChatsActivity.this.getResources().getDimensionPixelSize(R.dimen.formatted_separator_divider_height);
            localTextView.setWidth(j + (i - localTextView.getLeft()));
            localTextView.setHeight(PublicChatsActivity.b(PublicChatsActivity.this).getHeight());
            if (PublicChatsActivity.c(PublicChatsActivity.this) == null)
              break label179;
            localLayoutParams1 = PublicChatsActivity.c(PublicChatsActivity.this).getLayoutParams();
            if ((localLayoutParams1 instanceof ViewGroup.MarginLayoutParams))
              ((ViewGroup.MarginLayoutParams)localLayoutParams1).leftMargin = this.b;
            if (PublicChatsActivity.d(PublicChatsActivity.this) == null)
              break label185;
          }
          label179: label185: for (ViewGroup.LayoutParams localLayoutParams2 = PublicChatsActivity.d(PublicChatsActivity.this).getLayoutParams(); ; localLayoutParams2 = null)
          {
            if ((localLayoutParams2 instanceof ViewGroup.MarginLayoutParams))
              ((ViewGroup.MarginLayoutParams)localLayoutParams2).leftMargin = this.c;
            return;
            localLayoutParams1 = null;
            break;
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void c(Intent paramIntent)
  {
    this.i.a(paramIntent, true);
  }

  private void d()
  {
    boolean bool1 = this.j.f();
    this.h.setHasOptionsMenu(bool1);
    TabletPublicGroupConversationFragment localTabletPublicGroupConversationFragment = this.i;
    if (!bool1);
    for (boolean bool2 = true; ; bool2 = false)
    {
      localTabletPublicGroupConversationFragment.setHasOptionsMenu(bool2);
      if (this.k)
        e();
      return;
    }
  }

  private void e()
  {
    boolean bool1 = true;
    if (this.j != null)
    {
      boolean bool2 = this.j.f();
      android.support.v7.app.a locala2 = getSupportActionBar();
      boolean bool3;
      boolean bool4;
      label64: label84: View localView;
      int i1;
      if ((this.l == 0) || (bool2))
      {
        bool3 = bool1;
        locala2.c(bool3);
        android.support.v7.app.a locala3 = getSupportActionBar();
        if ((this.l != 0) && (!bool2))
          break label124;
        bool4 = bool1;
        locala3.b(bool4);
        android.support.v7.app.a locala4 = getSupportActionBar();
        if (this.l == 0)
          break label130;
        locala4.d(bool1);
        localView = this.n;
        if (this.l == 0)
          break label135;
        i1 = 0;
        if (bool2)
          break label135;
      }
      while (true)
      {
        localView.setVisibility(i1);
        return;
        bool3 = false;
        break;
        label124: bool4 = false;
        break label64;
        label130: bool1 = false;
        break label84;
        label135: i1 = 8;
      }
    }
    getSupportActionBar().c(bool1);
    getSupportActionBar().b(bool1);
    android.support.v7.app.a locala1 = getSupportActionBar();
    if (this.l != 0);
    while (true)
    {
      locala1.d(bool1);
      return;
      bool1 = false;
    }
  }

  public void a()
  {
    d();
  }

  public void a(int paramInt)
  {
    this.i.ab();
    if (paramInt == 0)
      ViberApplication.getInstance().getMessagesManager().n().a(false, false);
  }

  public void a(int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    if (this.l != paramInt2)
    {
      this.l = paramInt2;
      if (this.j == null)
        break label145;
      if (this.l != 0)
        break label102;
      this.i.setHasOptionsMenu(false);
      this.j.a(false);
      this.j.setTouchModeBehind(2);
      if (this.k)
        e();
      if (this.i != null)
      {
        if (this.l != 0)
          break label184;
        this.i.b();
      }
    }
    label85: if (paramInt1 == 0)
      if (this.l <= 0)
        break label195;
    while (true)
    {
      a(bool1);
      return;
      label102: TabletPublicGroupConversationFragment localTabletPublicGroupConversationFragment2 = this.i;
      if (!this.j.f());
      for (boolean bool3 = bool1; ; bool3 = false)
      {
        localTabletPublicGroupConversationFragment2.setHasOptionsMenu(bool3);
        this.j.setTouchModeBehind(0);
        break;
      }
      label145: if (this.i == null)
        break;
      TabletPublicGroupConversationFragment localTabletPublicGroupConversationFragment1 = this.i;
      if (this.l != 0);
      for (boolean bool2 = bool1; ; bool2 = false)
      {
        localTabletPublicGroupConversationFragment1.setHasOptionsMenu(bool2);
        break;
      }
      label184: this.i.a(false);
      break label85;
      label195: bool1 = false;
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt, String paramString)
  {
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if (this.k)
      this.h.a(paramConversationItemLoaderEntity, paramBoolean);
  }

  public void a(ConversationData paramConversationData)
  {
  }

  public boolean a(Fragment paramFragment)
  {
    return true;
  }

  public boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString)
  {
    if ((paramConversationItemLoaderEntity != null) && (com.viber.voip.publicaccount.d.e.d()))
    {
      this.d.b(paramConversationItemLoaderEntity, paramString);
      ViberActionRunner.aq.d(this, paramConversationItemLoaderEntity.getPublicAccountGroupUri());
      return true;
    }
    return false;
  }

  public void addConversationIgnoredView(View paramView)
  {
    if (this.j != null)
      this.j.a(paramView);
  }

  public void b()
  {
    d();
  }

  public void b_(Intent paramIntent)
  {
    if (!this.k)
    {
      startActivity(paramIntent);
      overridePendingTransition(R.anim.screen_in, R.anim.screen_no_transition);
      return;
    }
    c(paramIntent);
  }

  public void c(boolean paramBoolean)
  {
  }

  public void finish()
  {
    com.viber.voip.util.links.e.a().a(false, hashCode());
    super.finish();
    overridePendingTransition(0, 0);
  }

  public void m()
  {
  }

  public TextView n()
  {
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
      return (TextView)locala.a().findViewById(com.viber.voip.R.id.abs__action_bar_title);
    return null;
  }

  public TextView o()
  {
    if (this.r == null)
      this.r = dj.g(findViewById(android.support.design.R.id.action_bar));
    return this.r;
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    getWindow().setFormat(-3);
    super.onCreate(paramBundle);
    setActionBarTitle(R.string.vibes);
    this.k = ViberApplication.isTablet(this);
    if (!this.k)
    {
      if (getRequestedOrientation() != 1)
        com.viber.voip.n.a.d(this);
      if ((getResources().getConfiguration().orientation != 1) && ((!com.viber.common.d.a.k()) || (!isInMultiWindowMode())))
        return;
    }
    setContentView(R.layout.activity_public_chats);
    this.o = ((Toolbar)findViewById(com.viber.voip.R.id.toolbar));
    setSupportActionBar(this.o);
    getSupportActionBar().b(true);
    if (this.k)
    {
      this.j = ((SlidingMenu)findViewById(com.viber.voip.R.id.sliding_public_chats));
      getSupportActionBar().a(false);
      this.m = dj.a(this, getLayoutInflater());
      this.n = this.m.findViewById(com.viber.voip.R.id.abs__up);
      if (this.j != null)
        this.m.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            PublicChatsActivity.a(PublicChatsActivity.this).a();
          }
        });
      getSupportActionBar().a(this.m);
      c();
    }
    if (this.j != null)
    {
      this.j.setContent(R.layout.activity_public_chats_content);
      this.j.setMenu(R.layout.activity_public_chats_menu);
      this.j.setFadeDegree(0.35F);
      this.j.setMode(0);
      this.j.setShadowDrawable(R.drawable.shadow_left);
      this.j.setOnOpenedListener(this);
      this.j.setOnClosedListener(this);
      this.j.setOnStartDragListener(this);
      Resources localResources = getResources();
      float f1 = dj.a(localResources);
      int i1 = localResources.getDisplayMetrics().widthPixels;
      int i2 = (int)(i1 * (1.0F - f1));
      int i3 = (int)(0.5F * i1);
      this.j.setBehindOffset(i2);
      this.j.setTouchmodeMarginThreshold(i3);
      this.j.a(false);
    }
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (!this.k)
    {
      a locala = new a(localFragmentManager);
      this.p = ((TabLayout)findViewById(com.viber.voip.R.id.tab_layout));
      this.q = ((ViewPagerWithPagingEnable)findViewById(com.viber.voip.R.id.pager));
      this.q.setAdapter(locala);
      this.p.setupWithViewPager(this.q);
      this.p.setVisibility(8);
      this.q.setCurrentItem(1, false);
    }
    while (true)
    {
      this.i = ((TabletPublicGroupConversationFragment)localFragmentManager.findFragmentById(com.viber.voip.R.id.conversation_fragment));
      if (this.j != null)
      {
        this.j.a(this.i.Z());
        this.j.a(this.i.aa());
        this.i.a(this.j.getBehindOffset());
      }
      getSupportActionBar().b(true);
      return;
      this.h = ((PublicGroupsFragment)localFragmentManager.findFragmentById(com.viber.voip.R.id.public_groups_fragment));
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_public_groups, paramMenu);
    return true;
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.k)
    {
      b(getIntent());
      c(getIntent());
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    if (i1 == 16908332)
    {
      finish();
      return true;
    }
    if (i1 == com.viber.voip.R.id.menu_search_in_web)
    {
      ViberActionRunner.aq.a(this, null, c.l.a.e(), 0);
      return true;
    }
    return false;
  }

  protected void onPause()
  {
    super.onPause();
    this.e.c(false);
    if (isFinishing())
      ViberApplication.getInstance().getMessagesManager().a().f();
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (this.k)
      if (paramBundle == null)
      {
        Intent localIntent = getIntent();
        if (localIntent.hasExtra("extra_conversation_data"))
        {
          ConversationData localConversationData = (ConversationData)localIntent.getParcelableExtra("extra_conversation_data");
          if (localConversationData.conversationId < 0L)
            break label69;
          this.h.c(localConversationData.conversationId);
        }
      }
    while (true)
    {
      c(getIntent());
      return;
      label69: this.h.l();
    }
  }

  protected void onResume()
  {
    super.onResume();
    this.e.c(true);
    com.viber.voip.gdpr.d.a(this);
    com.viber.voip.h.a.b().post(new com.viber.voip.ui.e.a());
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    ViberApplication.getInstance().getMessagesManager().a().a(paramBoolean);
    if (!isFinishing())
      com.viber.voip.util.links.e.a().a(paramBoolean, hashCode());
  }

  public void p()
  {
    ap.a(this);
  }

  public void removeConversationIgnoredView(View paramView)
  {
    if (this.j != null)
      this.j.b(paramView);
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.f;
  }

  public class a extends FragmentPagerAdapter
  {
    public a(FragmentManager arg2)
    {
      super();
    }

    public int getCount()
    {
      return PublicChatsActivity.b;
    }

    public Fragment getItem(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 1:
        if (PublicChatsActivity.e(PublicChatsActivity.this) == null)
          PublicChatsActivity.a(PublicChatsActivity.this, new PublicGroupsFragment());
        return PublicChatsActivity.e(PublicChatsActivity.this);
      case 0:
      }
      return new d();
    }

    public CharSequence getPageTitle(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 1:
        return PublicChatsActivity.this.getResources().getString(R.string.public_accounts_tab_all);
      case 0:
      }
      return PublicChatsActivity.this.getResources().getString(R.string.public_accounts_tab_mine);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.PublicChatsActivity
 * JD-Core Version:    0.6.2
 */