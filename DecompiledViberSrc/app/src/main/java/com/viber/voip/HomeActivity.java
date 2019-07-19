package com.viber.voip;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.LayoutParams;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.Window;
import com.viber.common.dialogs.a.a;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.banner.d.j;
import com.viber.voip.block.k.e;
import com.viber.voip.calls.ui.KeypadActivity;
import com.viber.voip.contacts.c.c.c.a;
import com.viber.voip.contacts.ui.ContactsFragment;
import com.viber.voip.contacts.ui.ContactsFragment.a;
import com.viber.voip.contacts.ui.ContactsFragment.b;
import com.viber.voip.contacts.ui.ContactsFragment.d;
import com.viber.voip.i.c.p;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.ui.bk;
import com.viber.voip.messages.ui.bk.a;
import com.viber.voip.messages.ui.bn.a;
import com.viber.voip.news.ViberNewsProviderSpec;
import com.viber.voip.permissions.l;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.phone.call.DialerPendingController;
import com.viber.voip.registration.changephonenumber.CarrierChangedSplashActivity;
import com.viber.voip.settings.d.ag;
import com.viber.voip.settings.d.bb;
import com.viber.voip.ui.dialogs.u;
import com.viber.voip.ui.f.d;
import com.viber.voip.user.more.MoreFragment;
import com.viber.voip.user.more.MoreFragment.Callbacks;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.ViberActionRunner.aw;
import com.viber.voip.util.ae;
import com.viber.voip.util.an;
import com.viber.voip.util.bb;
import com.viber.voip.util.bb.a;
import com.viber.voip.util.bc;
import com.viber.voip.util.bd;
import com.viber.voip.widget.m.c;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class HomeActivity extends ViberFragmentActivity
  implements ab, k.e, c.a, ContactsFragment.a, ContactsFragment.b, ContactsFragment.d, bk.a, bn.a, l, com.viber.voip.ui.f.e, MoreFragment.Callbacks, bb.a, w.a, m.c, z, dagger.android.support.b
{
  private static final Logger K = ViberEnv.getLogger();

  @Inject
  dagger.a<com.viber.voip.analytics.story.d.c> A;

  @Inject
  dagger.a<com.viber.voip.analytics.story.e.c> B;

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.c> C;

  @Inject
  dagger.a<com.viber.voip.analytics.story.g.a> D;

  @Inject
  dagger.a<h> E;

  @Inject
  dagger.a<com.viber.voip.vln.e> F;

  @Inject
  dagger.a<com.viber.voip.r.a> G;

  @Inject
  dagger.a<com.viber.voip.news.q> H;

  @Inject
  dagger.a<ICdrController> I;

  @Inject
  com.viber.voip.ui.f.c J;
  private int L = 0;
  private AppBarLayout M;
  private com.viber.voip.widget.m N;
  private ViewGroup O;
  private ViewGroup P;
  private boolean Q;
  private com.viber.common.permission.b R;
  private com.viber.voip.backup.ui.promotion.e S;
  private d T;
  protected bc a;
  protected ad b;
  protected bd c;
  protected Toolbar d;
  protected com.viber.voip.ui.f.f e;

  @Inject
  w f;

  @Inject
  com.viber.voip.banner.i g;

  @Inject
  com.viber.common.permission.c h;

  @Inject
  dagger.android.c<Fragment> i;

  @Inject
  EventBus j;

  @Inject
  bf k;

  @Inject
  com.viber.voip.contacts.c.c.b l;

  @Inject
  com.viber.voip.app.b m;

  @Inject
  com.viber.voip.block.k n;

  @Inject
  com.viber.voip.rakuten.a o;

  @Inject
  dagger.a<DialerPendingController> p;

  @Inject
  dagger.a<com.viber.voip.analytics.g> q;

  @Inject
  dagger.a<com.viber.voip.analytics.e.b> r;

  @Inject
  dagger.a<com.viber.voip.messages.controller.manager.k> s;

  @Inject
  dagger.a<com.viber.voip.messages.extras.a.e> t;

  @Inject
  dagger.a<com.viber.voip.messages.extras.c.a> u;

  @Inject
  dagger.a<com.viber.voip.contacts.c.d.g> v;

  @Inject
  dagger.a<com.viber.voip.messages.d.b> w;

  @Inject
  dagger.a<com.viber.voip.stickers.i> x;

  @Inject
  dagger.a<com.viber.voip.backup.auto.a> y;

  @Inject
  dagger.a<com.viber.voip.ads.a.b> z;

  public HomeActivity()
  {
    Pair[] arrayOfPair = new Pair[4];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(58);
    arrayOfPair[1] = com.viber.voip.permissions.m.a(39);
    arrayOfPair[2] = com.viber.voip.permissions.m.a(78);
    arrayOfPair[3] = com.viber.voip.permissions.m.a(94);
    this.R = new com.viber.voip.permissions.f(this, arrayOfPair)
    {
      public void onPermissionsDenied(int paramAnonymousInt, boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString1, String[] paramAnonymousArrayOfString2, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 94:
        }
        do
        {
          super.onPermissionsDenied(paramAnonymousInt, paramAnonymousBoolean, paramAnonymousArrayOfString1, paramAnonymousArrayOfString2, paramAnonymousObject);
          return;
        }
        while (!paramAnonymousBoolean);
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 58:
        case 39:
        }
        do
        {
          do
            return;
          while (!(paramAnonymousObject instanceof String));
          String str2 = (String)paramAnonymousObject;
          CallInitiationId.noteNextCallInitiationAttemptId();
          ((h)HomeActivity.this.E.get()).b(com.viber.voip.analytics.story.b.a.h.a.i().a(new String[] { str2 }).a("Native").b("Free Audio 1-On-1 Call").a(true).a());
          ((DialerPendingController)HomeActivity.this.p.get()).handlePendingDial(str2, false, false);
          return;
        }
        while (!(paramAnonymousObject instanceof String));
        String str1 = (String)paramAnonymousObject;
        CallInitiationId.noteNextCallInitiationAttemptId();
        ((h)HomeActivity.this.E.get()).b(com.viber.voip.analytics.story.b.a.h.a.i().a(new String[] { str1 }).a("Native").b("Viber Out").b(true).a());
        ((DialerPendingController)HomeActivity.this.p.get()).handlePendingDial(str1, true, false);
      }
    };
  }

  private int a(String paramString)
  {
    int i1 = -1;
    if (("com.viber.voip.action.DIALER".equals(paramString)) || ("android.intent.action.DIAL".equals(paramString)) || ("com.viber.voip.action.CONTACTS".equals(paramString)) || ("android.intent.action.CALL_BUTTON".equals(paramString)) || (("com.viber.voip.action.VIEW_CONTACT".equals(paramString)) && (this.m.a(this))))
      i1 = 1;
    do
    {
      return i1;
      if (("com.viber.voip.action.MESSAGES".equals(paramString)) || ("com.viber.voip.action.CONVERSATION".equals(paramString)) || ("com.viber.voip.action.COMMUNITY_CONVERSATION".equals(paramString)))
        return 0;
      if ("com.viber.voip.action.MORE".equals(paramString))
        return 2;
    }
    while (!"com.viber.voip.action.NEWS".equals(paramString));
    return 3;
  }

  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 2)
      if (c.p.a.e())
        ((com.viber.voip.vln.e)this.F.get()).a();
    while ((paramInt1 != 2) || (!c.p.a.e()))
      return;
    ((com.viber.voip.vln.e)this.F.get()).b();
  }

  @SuppressLint({"MissingPermission"})
  private void b(Intent paramIntent, boolean paramBoolean)
  {
    paramIntent.getAction();
    if ((this.S != null) && (!bb.a(this, this, paramIntent, this.h)))
      this.S.a(System.currentTimeMillis());
    if ((j(paramIntent)) && (paramBoolean))
      l();
    a(paramIntent, paramBoolean);
    boolean bool = paramIntent.getBooleanExtra("secondary_activation_requested", false);
    setIntent(new Intent("com.viber.voip.action.DEFAULT"));
    if (bool)
      ViberActionRunner.aw.a(this, null, null);
  }

  private void b(boolean paramBoolean)
  {
    AppBarLayout.LayoutParams localLayoutParams;
    if ((!this.m.a()) && (this.d != null))
    {
      localLayoutParams = (AppBarLayout.LayoutParams)this.d.getLayoutParams();
      if (!paramBoolean)
        break label41;
      localLayoutParams.setScrollFlags(this.L);
    }
    label41: 
    do
    {
      return;
      localLayoutParams.setScrollFlags(0);
    }
    while (this.M == null);
    this.M.setExpanded(true);
  }

  private Intent c(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("last_intent")))
      return (Intent)paramBundle.getParcelable("last_intent");
    return getIntent();
  }

  private void h(int paramInt)
  {
    if ((!this.m.a(this)) && (!this.m.a()) && (paramInt != 2))
      setSupportActionBar(this.d);
    if (this.J == null)
      return;
    com.viber.voip.ui.bottomnavigation.a[] arrayOfa = this.J.b();
    int i1 = arrayOfa.length;
    int i2 = 0;
    label56: b localb;
    if (i2 < i1)
    {
      com.viber.voip.ui.bottomnavigation.a locala = arrayOfa[i2];
      Fragment localFragment = this.b.a(locala.a());
      if ((localFragment instanceof b))
      {
        localb = (b)localFragment;
        if (locala.a() != paramInt)
          break label128;
      }
    }
    label128: for (boolean bool = true; ; bool = false)
    {
      localb.onFragmentVisibilityChanged(bool);
      i2++;
      break label56;
      break;
    }
  }

  private boolean h(Intent paramIntent)
  {
    boolean bool1 = this.m.a(this);
    boolean bool2;
    if (c() != bool1)
    {
      finish();
      ViberActionRunner.ab.a(this, bool1);
      bool2 = true;
    }
    int i1;
    do
    {
      return bool2;
      i1 = 0x100000 & paramIntent.getFlags();
      bool2 = false;
    }
    while (i1 == 0);
    return false;
  }

  private boolean i(Intent paramIntent)
  {
    boolean bool1 = paramIntent.hasExtra("fresh_start");
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = paramIntent.getBooleanExtra("fresh_start", false);
      bool2 = false;
      if (bool3)
        bool2 = true;
    }
    return bool2;
  }

  private boolean j(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("need_ask_all_permissions_at_fresh_start", false);
    paramIntent.removeExtra("need_ask_all_permissions_at_fresh_start");
    return bool;
  }

  private void k()
  {
    if (!this.h.a(n.j))
      this.h.a(this, 94, n.j);
  }

  private void l()
  {
    if (!this.h.a(n.p))
      this.h.a(this, 69, n.p);
  }

  private void m()
  {
    if ((this.M != null) && ((!this.m.a()) || (this.T.b())))
      this.M.setExpanded(true);
  }

  private void n()
  {
    this.j.postSticky(new com.viber.voip.ui.e.c(ac.a, true));
  }

  private void o()
  {
    this.j.postSticky(new com.viber.voip.ui.e.c(ac.a, false));
  }

  protected void a()
  {
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
    {
      locala.e(true);
      locala.b(false);
      locala.a(this.e.a(R.string.app_name));
      locala.c(true);
    }
    this.M = ((AppBarLayout)findViewById(R.id.app_bar_layout));
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)findViewById(R.id.activity_home_root);
    if (this.M != null)
      this.M.addOnOffsetChangedListener(new q(this, localCoordinatorLayout));
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.T.a(paramInt1, paramInt2);
  }

  public void a(int paramInt, Fragment paramFragment)
  {
  }

  public void a(int paramInt, final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!HomeActivity.this.isFinishing())
        {
          com.viber.common.dialogs.h.a locala = u.c();
          int i = R.string.dialog_3902_title;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = paramString;
          a.a locala1 = locala.a(i, arrayOfObject1);
          int j = R.string.dialog_3902_body;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = paramString;
          locala1.b(j, arrayOfObject2).a(HomeActivity.this.getSupportFragmentManager());
        }
      }
    });
  }

  protected void a(Intent paramIntent)
  {
    switch (ac.a)
    {
    default:
    case 1:
    }
    do
    {
      return;
      if (paramIntent.hasExtra("filter"))
      {
        int i1 = paramIntent.getIntExtra("filter", -1);
        this.b.b(i1);
        paramIntent.removeExtra("filter");
      }
      if (paramIntent.hasExtra("open_keypad_number"))
      {
        c(paramIntent);
        return;
      }
      if ((paramIntent.getData() != null) && (paramIntent.getData().getScheme() != null) && (paramIntent.getData().getScheme().equals("tel")))
      {
        paramIntent.putExtra("open_keypad_number", paramIntent.getData().getSchemeSpecificPart());
        c(paramIntent);
        return;
      }
    }
    while (!"com.viber.voip.action.DIALER".equals(paramIntent.getAction()));
    g();
  }

  protected void a(Intent paramIntent, boolean paramBoolean)
  {
    if (paramBoolean)
      paramIntent.removeExtra("fresh_start");
    if (paramBoolean);
    for (int i1 = d.bb.a(); ; i1 = a(paramIntent.getAction()))
    {
      if (i1 != -1)
      {
        if ((this.J != null) && (this.J.c(i1) == -1))
          i1 = 0;
        int i3 = ac.a;
        ac.a = i1;
        if ((this.m.a(this)) && (i3 == 1) && (i1 == 0))
          this.a.a(false);
        n();
      }
      if (!this.m.a(this))
      {
        this.d.collapseActionView();
        g(ac.a);
        int i2 = ac.a;
        boolean bool = false;
        if (i2 != 3)
          bool = true;
        b(bool);
        a(paramIntent);
      }
      return;
    }
  }

  protected void a(Bundle paramBundle)
  {
  }

  public void a(Set<Member> paramSet, boolean paramBoolean)
  {
    if (paramSet.size() > 0)
      runOnUiThread(new t(this, paramSet));
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      b(bool);
      return;
    }
  }

  public void a(boolean paramBoolean, Intent paramIntent)
  {
    startActivity(paramIntent);
  }

  public boolean a(int paramInt)
  {
    if ((this.N == null) || (this.N.a() == null) || (this.J == null))
      if (paramInt != ac.a);
    while (paramInt == this.J.b(this.N.b()))
    {
      return true;
      return false;
    }
    return false;
  }

  public void a_(Intent paramIntent)
  {
    startActivity(paramIntent);
    overridePendingTransition(R.anim.screen_in, R.anim.screen_no_transition);
  }

  public AppBarLayout b()
  {
    return this.M;
  }

  public void b(int paramInt)
  {
    int i1 = this.J.c(paramInt);
    this.N.a(i1, false);
    c(paramInt);
  }

  public void b(int paramInt, String paramString)
  {
  }

  protected void b(Bundle paramBundle)
  {
  }

  public void b(Set<Member> paramSet, boolean paramBoolean)
  {
  }

  protected void c(int paramInt)
  {
    if (this.m.a(this))
      this.a.a(paramInt);
    if (ac.a != paramInt)
      d(paramInt);
    if (ac.a != paramInt)
    {
      com.viber.voip.banner.i locali = this.g;
      j[] arrayOfj = new j[1];
      arrayOfj[0] = j.b;
      locali.a(arrayOfj);
    }
    int i1;
    switch (ac.a)
    {
    default:
      b(ac.a, paramInt);
      i1 = ac.a;
      ac.a = paramInt;
      n();
      if (this.c != null)
        this.c.a(i1, paramInt);
      h(paramInt);
      if (!this.m.a(this))
      {
        m();
        if (paramInt != i1)
        {
          if (paramInt != 3)
            break label239;
          b(false);
        }
      }
      break;
    case 0:
    case 1:
    }
    while (true)
    {
      if (d())
        this.g.c(true);
      return;
      Fragment localFragment2 = this.b.a(ac.a);
      if (!(localFragment2 instanceof bk))
        break;
      ((bk)localFragment2).l();
      break;
      Fragment localFragment1 = this.b.a(ac.a);
      if (!(localFragment1 instanceof ContactsFragment))
        break;
      ((ContactsFragment)localFragment1).w();
      break;
      label239: if (i1 == 3)
        b(true);
    }
  }

  public void c(Intent paramIntent)
  {
    Intent localIntent = new Intent(this, KeypadActivity.class);
    if ((paramIntent != null) && (paramIntent.hasExtra("open_keypad_number")))
      localIntent.putExtra("open_keypad_number", paramIntent.getStringExtra("open_keypad_number"));
    startActivity(localIntent);
    overridePendingTransition(0, R.anim.fade_out);
  }

  protected boolean c()
  {
    return false;
  }

  public void d(int paramInt)
  {
    switch (paramInt)
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    }
    ViberNewsProviderSpec localViberNewsProviderSpec;
    do
    {
      return;
      ((com.viber.voip.analytics.story.e.c)this.B.get()).a();
      return;
      ((com.viber.voip.analytics.story.d.c)this.A.get()).b(ae.b());
      ((com.viber.voip.analytics.story.b.c)this.C.get()).a();
      return;
      localViberNewsProviderSpec = ((com.viber.voip.news.q)this.H.get()).a();
    }
    while (!localViberNewsProviderSpec.isNewsProviderExists());
    ((com.viber.voip.analytics.story.g.a)this.D.get()).a("Tab", ae.b(), localViberNewsProviderSpec.getUrl());
    ((ICdrController)this.I.get()).handleReportScreenDisplay(6, 3);
  }

  public void d(Intent paramIntent)
  {
  }

  protected final boolean d()
  {
    return ac.a == 0;
  }

  public void e(int paramInt)
  {
    Fragment localFragment = this.b.a(ac.a);
    if ((localFragment instanceof b))
      ((b)localFragment).onTabReselected();
    if (!this.m.a(this))
      m();
  }

  public void e(Intent paramIntent)
  {
  }

  protected final boolean e()
  {
    return 2 == ac.a;
  }

  public void f()
  {
    g();
  }

  public void f(int paramInt)
  {
    c(this.J.b(paramInt));
  }

  public void f(Intent paramIntent)
  {
  }

  protected void g()
  {
    ((com.viber.voip.analytics.story.b.c)this.C.get()).a("Calls Screen - View All");
    startActivity(ViberActionRunner.ab.f(this));
  }

  public void g(int paramInt)
  {
    this.N.a(this.J.c(paramInt), true);
  }

  public void g(Intent paramIntent)
  {
  }

  public com.viber.voip.permissions.k getPermissionConfigForFragment(Fragment paramFragment)
  {
    com.viber.voip.permissions.k localk = new com.viber.voip.permissions.k();
    if ((paramFragment instanceof MoreFragment))
    {
      localk.a(0, 4);
      localk.a(1, 82);
      localk.a(4, 95);
    }
    while (!(paramFragment instanceof ContactsFragment))
      return localk;
    localk.a(0, 86);
    return localk;
  }

  public void h()
  {
    if ((!this.m.a(this)) && (this.m.a()))
    {
      android.support.v7.app.a locala = getSupportActionBar();
      if (locala != null)
      {
        locala.a(this.e.a(R.string.app_name));
        locala.b(null);
      }
    }
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((com.viber.voip.messages.extras.a.e)this.t.get()).a(this, paramInt1, paramInt2, paramIntent);
    ((com.viber.voip.messages.extras.c.a)this.u.get()).a(paramInt1, paramInt2, paramIntent);
    if (this.c != null)
      this.c.a(paramInt1, paramInt2, paramIntent);
  }

  public void onAttachFragment(Fragment paramFragment)
  {
    this.b.a(paramFragment);
    if (this.c != null)
      this.c.b(paramFragment);
  }

  public void onBackPressed()
  {
    int i1;
    if (this.N != null)
    {
      Fragment localFragment = this.b.a(this.J.b(this.N.b()));
      if ((!(localFragment instanceof com.viber.voip.app.a)) || (!((com.viber.voip.app.a)localFragment).onBackPressed()))
        break label100;
      i1 = 0;
    }
    while (true)
      if (i1 == 0)
      {
        return;
        if ((this.c != null) && (this.c.l()))
          i1 = 0;
      }
      else
      {
        if (ac.a != 0)
        {
          this.T.a(0, true);
          return;
        }
        super.onBackPressed();
        return;
        label100: i1 = 1;
      }
  }

  public void onClickOpenSettings(Intent paramIntent)
  {
    startActivity(paramIntent);
  }

  @SuppressLint({"InlinedApi"})
  protected void onCreate(Bundle paramBundle)
  {
    BT.a("APP START", "total", "HomeActivity on create");
    BT.a("APP START", "HomeActivity onCreate");
    dagger.android.a.a(this);
    BT.a("APP START", "HomeActivity onCreate", "inject di");
    ((com.viber.voip.r.a)this.G.get()).a(this);
    getWindow().setUiOptions(1);
    this.e = new com.viber.voip.ui.f.f(this, new com.viber.voip.registration.af().p());
    this.b = new ad();
    a(paramBundle);
    setInAppCampaignSupported(true);
    try
    {
      super.onCreate(paramBundle);
      if (h(getIntent()))
        return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        this.k.a();
        super.onCreate(paramBundle);
        this.k.c(this.m.a(this));
      }
      setDefaultKeyMode(1);
      setDefaultKeyMode(2);
      setContentView(R.layout.activity_home);
      BT.a("APP START", "HomeActivity onCreate", "setContentView");
      this.d = ((Toolbar)findViewById(R.id.toolbar));
      this.d.setTitleTextAppearance(this, R.style.TextAppearance_Viber_Widget_ActionBar_Title_Light_Home);
      this.L = ((AppBarLayout.LayoutParams)this.d.getLayoutParams()).getScrollFlags();
      setSupportActionBar(this.d);
      BT.a("APP START", "HomeActivity onCreate", "setSupportActionBar");
      BT.a("APP START", "HomeActivity onCreate", "HomeActionBarManager");
      if (paramBundle == null)
        break label650;
    }
    Intent localIntent;
    if (paramBundle.containsKey("extra_selected_tab_index"))
    {
      ac.a = paramBundle.getInt("extra_selected_tab_index");
      localIntent = c(paramBundle);
      a();
      b(paramBundle);
      this.P = ((ViewGroup)findViewById(R.id.homePager));
      this.O = ((ViewGroup)findViewById(R.id.moreContainer));
      this.N = new com.viber.voip.widget.m(getSupportFragmentManager());
      this.N.a(new af(getSupportFragmentManager(), this.J)
      {
        public ViewGroup a(int paramAnonymousInt)
        {
          if ((!HomeActivity.this.m.a(null)) && (HomeActivity.this.J.b(paramAnonymousInt) == 2))
            return HomeActivity.a(HomeActivity.this);
          return HomeActivity.b(HomeActivity.this);
        }
      });
      this.N.a(this);
      BT.a("APP START", "HomeActivity onCreate", "create viewPager");
      this.T = new com.viber.voip.ui.f.a(getResources(), getWindow().getDecorView(), this.J);
      this.T.a(this.N);
      this.T.a(this);
      BT.a("APP START", "HomeActivity onCreate", "setupTabs");
      boolean bool = i(localIntent);
      if ((paramBundle == null) && (!bool))
        k();
      this.S = new com.viber.voip.backup.ui.promotion.e(this);
      b(localIntent, bool);
      ((com.viber.voip.contacts.c.d.g)this.v.get()).i();
      if (paramBundle == null)
        this.Q = CarrierChangedSplashActivity.a(this);
      String str = localIntent.getAction();
      if ((str == null) || (!str.startsWith("com.viber.voip.action.")) || ("com.viber.voip.action.DEFAULT".equals(str)))
        break label659;
    }
    label650: label659: for (int i1 = 1; ; i1 = 0)
    {
      if ((paramBundle == null) && (localIntent.getBooleanExtra("EXTRA_FROM_LAUNCH_ACTIVITY", false)) && (i1 == 0) && (!this.Q))
      {
        this.g.a(true);
        ((com.viber.voip.backup.auto.a)this.y.get()).a();
      }
      BT.b("APP START", "HomeActivity onCreate");
      return;
      ac.a = d.bb.a();
      break;
    }
  }

  protected void onDestroy()
  {
    ((com.viber.voip.r.a)this.G.get()).b(this);
    if (this.N != null)
      this.N.b(this);
    if (this.T != null)
      this.T.a();
    ((com.viber.voip.analytics.e.b)this.r.get()).d();
    if (isFinishing());
    try
    {
      an.a(this);
    }
    catch (Exception localException)
    {
      try
      {
        while (true)
        {
          super.onDestroy();
          return;
          localException = localException;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
      }
    }
  }

  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (!h(paramIntent))
      b(paramIntent, i(paramIntent));
  }

  protected void onPause()
  {
    super.onPause();
    com.viber.voip.messages.extras.a.e.d(this);
    this.l.b(this);
    this.n.b(this);
    o();
  }

  protected void onPostCreate(final Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    av.e.f.a().post(new Runnable()
    {
      public void run()
      {
        ((com.viber.voip.contacts.c.d.g)HomeActivity.this.v.get()).i();
        if (paramBundle == null)
          ((com.viber.voip.messages.controller.manager.k)HomeActivity.this.s.get()).e();
      }
    });
  }

  protected void onRestart()
  {
    super.onRestart();
    sendBroadcast(new Intent("com.viber.voip.action.CLOSE_POPUP"));
  }

  protected void onResume()
  {
    super.onResume();
    BT.a("APP START", "HomeActivity onResume");
    com.viber.voip.messages.extras.a.e.c(this);
    if (d.ag.a.d())
      sendBroadcast(new Intent("com.viber.voip.action.CLOSE_POPUP"));
    if (ViberApplication.getInstance().getHandledCloudMessagesHolder().a())
    {
      ViberApplication.getInstance().getHandledCloudMessagesHolder().b();
      ViberApplication.getInstance().getNotifier().a().g();
    }
    this.o.a(this);
    this.l.a(this);
    this.n.a(this);
    n();
    av.e.f.a().post(new s(this));
    BT.b("APP START", "HomeActivity onResume");
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("last_intent", new Intent("com.viber.voip.action.DEFAULT"));
    paramBundle.putInt("extra_selected_tab_index", ac.a);
    super.onSaveInstanceState(paramBundle);
  }

  public boolean onSearchRequested()
  {
    if (this.N != null)
    {
      int i1 = this.J.b(this.N.b());
      Fragment localFragment = this.b.a(i1);
      if (((localFragment instanceof b)) && (((b)localFragment).onActivitySearchRequested()))
        return true;
    }
    return super.onSearchRequested();
  }

  protected void onStart()
  {
    super.onStart();
    if (!ViberApplication.isActivated())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.LAUNCHER");
      if (y.e());
      for (Class localClass = y.d(); ; localClass = y.a())
      {
        localIntent.setClass(this, localClass);
        startActivity(localIntent);
        finish();
        return;
      }
    }
    this.f.a(this);
    this.h.a(this.R);
  }

  protected void onStop()
  {
    super.onStop();
    this.f.a();
    this.h.b(this.R);
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.HomeActivity
 * JD-Core Version:    0.6.2
 */