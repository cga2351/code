package com.viber.voip.settings.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.j;
import android.text.format.DateFormat;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.R.xml;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.b.e.a.a;
import com.viber.voip.settings.c.aa;
import com.viber.voip.settings.c.ab;
import com.viber.voip.settings.c.ac;
import com.viber.voip.settings.c.ad;
import com.viber.voip.settings.c.ae;
import com.viber.voip.settings.c.af;
import com.viber.voip.settings.c.ag;
import com.viber.voip.settings.c.ah;
import com.viber.voip.settings.c.ai;
import com.viber.voip.settings.c.aj;
import com.viber.voip.settings.c.ap;
import com.viber.voip.settings.c.aq;
import com.viber.voip.settings.c.ar;
import com.viber.voip.settings.c.as;
import com.viber.voip.settings.c.at;
import com.viber.voip.settings.c.au;
import com.viber.voip.settings.c.ax;
import com.viber.voip.settings.c.ay;
import com.viber.voip.settings.c.ba;
import com.viber.voip.settings.c.bb;
import com.viber.voip.settings.c.bc;
import com.viber.voip.settings.c.bd;
import com.viber.voip.settings.c.be;
import com.viber.voip.settings.c.bf;
import com.viber.voip.settings.c.bg;
import com.viber.voip.settings.c.bh;
import com.viber.voip.settings.c.bk;
import com.viber.voip.settings.c.bl;
import com.viber.voip.settings.c.bm;
import com.viber.voip.settings.c.bo;
import com.viber.voip.settings.c.bp;
import com.viber.voip.settings.c.bu;
import com.viber.voip.settings.c.bv;
import com.viber.voip.settings.c.bw;
import com.viber.voip.settings.c.bx;
import com.viber.voip.settings.c.l;
import com.viber.voip.settings.c.o;
import com.viber.voip.settings.c.q;
import com.viber.voip.settings.c.t;
import com.viber.voip.settings.c.u;
import com.viber.voip.settings.c.v;
import com.viber.voip.settings.c.x;
import com.viber.voip.settings.c.z;
import com.viber.voip.settings.d.ah;
import com.viber.voip.settings.d.az;
import com.viber.voip.settings.d.bl;
import com.viber.voip.settings.d.r;
import com.viber.voip.ui.MenuSearchMediator;
import com.viber.voip.ui.ac.a;
import com.viber.voip.user.UserManager;
import java.util.Locale;
import javax.inject.Inject;

public class d extends SettingsHeadersActivity.a
  implements ac.a
{
  private static final Logger j = ViberEnv.getLogger();

  @Inject
  com.viber.voip.vln.e b;

  @Inject
  UserManager c;

  @Inject
  com.viber.voip.app.b d;

  @Inject
  dagger.a<com.viber.voip.ui.j.av> e;

  @Inject
  dagger.a<com.viber.voip.analytics.g> f;

  @Inject
  dagger.a<com.viber.voip.messages.controller.bn> g;

  @Inject
  com.viber.voip.notif.e.m h;
  private a k;
  private com.viber.common.permission.c l;
  private com.viber.common.permission.b m;
  private MenuSearchMediator n;

  public d()
  {
    Pair[] arrayOfPair = new Pair[4];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(107);
    arrayOfPair[1] = com.viber.voip.permissions.m.a(108);
    arrayOfPair[2] = com.viber.voip.permissions.m.a(105);
    arrayOfPair[3] = com.viber.voip.permissions.m.a(106);
    this.m = new com.viber.voip.permissions.e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 107:
          d.a(d.this).a();
          return;
        case 108:
          d.a(d.this).b();
          return;
        case 105:
          d.a(d.this).c();
          return;
        case 106:
        }
        d.a(d.this).d();
      }
    };
  }

  private void a(boolean paramBoolean)
  {
    for (int i = 0; i < this.i.e(); i++)
    {
      Preference localPreference = this.i.b(i);
      localPreference.b(true);
      if ((localPreference instanceof ViberPreferenceCategoryExpandable))
        ((ViberPreferenceCategoryExpandable)localPreference).g(paramBoolean);
    }
  }

  private void j()
  {
    ListPreference localListPreference1 = (ListPreference)a(d.az.a.c());
    if (localListPreference1 != null)
      localListPreference1.b("Current server type : " + d.az.a.d());
    ListPreference localListPreference2 = (ListPreference)a(e.a.a.a.c());
    if (localListPreference2 != null)
      localListPreference2.b("Current device type : " + e.a.a.a.d());
    ListPreference localListPreference3 = (ListPreference)a("vibes_key");
    if (localListPreference3 != null)
      localListPreference3.b(localListPreference3.p());
    ListPreference localListPreference4 = (ListPreference)a(d.ah.b.c());
    if (localListPreference4 != null)
      localListPreference4.b(localListPreference4.p());
    Preference localPreference1 = a("number_of_sent_engagement_sticker_packs_reset");
    if (localPreference1 != null)
    {
      Locale localLocale = Locale.ENGLISH;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(d.r.o.d());
      localPreference1.b(String.format(localLocale, "\"Engagement Stickers\" received %d times", arrayOfObject));
    }
    Preference localPreference2 = a(d.bl.a.c());
    if (localPreference2 != null)
      localPreference2.b(DateFormat.format("dd-MM-yyyy HH:mm:ss zzzz", d.bl.a.d()));
    Preference localPreference3 = a(d.bl.c.c());
    if (localPreference3 != null)
      localPreference3.b(DateFormat.format("dd-MM-yyyy HH:mm:ss zzzz", d.bl.b.d()));
    Preference localPreference4 = a("key_ivm_duration");
    if (localPreference4 != null)
      localPreference4.b(d.bl.e.d() / 1000 + " sec");
  }

  public void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.settings_debug, paramString);
  }

  public void i()
  {
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    Context localContext = a().g();
    this.l = com.viber.common.permission.c.a(localContext);
    this.k = new a(localContext);
    new bx(localContext, this.i, (com.viber.voip.analytics.g)this.f.get()).b();
    new bh(getActivity(), this.i, (com.viber.voip.ui.j.av)this.e.get()).b();
    new bb(getActivity(), localContext, this.i).b();
    new com.viber.voip.settings.c.ao(getActivity(), localContext, this.i).b();
    new ay(localContext, this.i, this.c, this.b).b();
    new com.viber.voip.settings.c.av(localContext, this.i).b();
    new bd(localContext, this.i).b();
    new z(localContext, this.i, this.k).b();
    new com.viber.voip.settings.c.bn(localContext, this.i).b();
    new ap(localContext, this.i).b();
    new com.viber.voip.settings.c.b(localContext, this.i).b();
    new bv(localContext, this.i).b();
    new com.viber.voip.settings.c.c(localContext, this.i).b();
    new x(localContext, this.i, this.g).b();
    new bf(localContext, this.i).b();
    new l(localContext, this.i, this).b();
    new ab(localContext, this.i).b();
    new aa(localContext, this.i).b();
    new af(localContext, this.i).b();
    new aj(localContext, getContext(), this.i, getActivity(), this, this.h).b();
    new com.viber.voip.settings.c.f(localContext, this.i).b();
    new au(localContext, this.i).b();
    new bl(localContext, this.i, getActivity()).b();
    if (!this.d.a(getContext()))
    {
      new bw(localContext, this.i).b();
      new bu(localContext, this.i).b();
    }
    new v(localContext, this.i).b();
    new ba(localContext, this.i).b();
    new com.viber.voip.settings.c.g(localContext, this.i).b();
    new ah(localContext, this.i).b();
    new com.viber.voip.settings.c.d(localContext, this.i).b();
    new q(localContext, this.i).b();
    new ax(localContext, this.i).b();
    new ad(localContext, this.i).b();
    new aq(localContext, this.i).b();
    new ar(localContext, this.i).b();
    new be(localContext, this.i).b();
    new t(localContext, this.i).b();
    new ag(localContext, this.i).b();
    new bm(localContext, this.i).b();
    new ac(localContext, this.i).b();
    if (!com.viber.voip.registration.ao.f())
      new com.viber.voip.settings.c.n(localContext, this.i).b();
    if (com.viber.voip.registration.ao.f())
      new bg(localContext, this.i).b();
    new u(localContext, this.i).b();
    new at(localContext, this.i).b();
    new o(localContext, this.i).b();
    new ae(localContext, this.i).b();
    new com.viber.voip.settings.c.a(localContext, this.i).b();
    new bk(localContext, this.i).b();
    new com.viber.voip.settings.c.e(localContext, this.i).b();
    new bo(localContext, this.i).b();
    new ai(localContext, this.i).b();
    new bp(localContext, this.i).b();
    new bc(localContext, this.i).b();
    new as(localContext, this.i).b();
    this.n = new MenuSearchMediator(this);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(R.menu.menu_debug_preferences, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(R.id.menu_search);
    this.n.a(localMenuItem, false, "");
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    int i1 = R.id.menu_collapse;
    boolean bool = false;
    if (i == i1);
    while (true)
    {
      a(bool);
      return true;
      int i2 = R.id.menu_expand;
      bool = false;
      if (i == i2)
        bool = true;
    }
  }

  public boolean onQueryTextChange(String paramString)
  {
    String str = paramString.toLowerCase();
    int i = this.i.e();
    for (int i1 = 0; i1 < i; i1++)
    {
      Preference localPreference = this.i.b(i1);
      if ((localPreference instanceof ViberPreferenceCategoryExpandable))
        ((ViberPreferenceCategoryExpandable)localPreference).a(str);
    }
    return true;
  }

  public boolean onQueryTextSubmit(String paramString)
  {
    return false;
  }

  public void onResume()
  {
    super.onResume();
    j();
    com.viber.voip.analytics.g.a().h().a(false);
  }

  public boolean onSearchViewShow(boolean paramBoolean)
  {
    a(paramBoolean);
    return true;
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    super.onSharedPreferenceChanged(paramSharedPreferences, paramString);
    j();
  }

  public void onStart()
  {
    super.onStart();
    this.l.a(this.m);
  }

  public void onStop()
  {
    super.onStop();
    this.l.b(this.m);
  }

  public class a
  {
    private final Context b;

    a(Context arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    private boolean a(int paramInt)
    {
      if (!d.b(d.this).a(com.viber.voip.permissions.n.m))
      {
        d.b(d.this).a(d.this, paramInt, com.viber.voip.permissions.n.m);
        return false;
      }
      return true;
    }

    public void a()
    {
      if (a(107))
      {
        Uri localUri = Uri.parse("content://com.viber.voip.provider.vibermessages/method/copyDB");
        this.b.getContentResolver().query(localUri, null, null, null, null);
      }
    }

    public void b()
    {
      if (a(107))
      {
        Uri localUri = Uri.parse("content://com.viber.voip.provider.vibermessages/method/restoreDB");
        this.b.getContentResolver().query(localUri, null, null, null, null);
      }
    }

    public void c()
    {
      if (a(107))
      {
        Uri localUri = Uri.parse("content://com.viber.voip.provider.vibercontacts/method/copyDB");
        this.b.getContentResolver().query(localUri, null, null, null, null);
      }
    }

    public void d()
    {
      if (a(107))
      {
        Uri localUri = Uri.parse("content://com.viber.voip.provider.vibercontacts/method/restoreDB");
        this.b.getContentResolver().query(localUri, null, null, null, null);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.d
 * JD-Core Version:    0.6.2
 */