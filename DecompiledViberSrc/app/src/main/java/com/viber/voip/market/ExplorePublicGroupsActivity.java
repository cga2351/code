package com.viber.voip.market;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.gdpr.d;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.da;
import com.viber.voip.util.dl;
import org.greenrobot.eventbus.EventBus;

public class ExplorePublicGroupsActivity extends ViberWebApiActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private long b;
  private Runnable c;
  private bv.t d = new bv.t()
  {
    public void onJoinToPublicGroup(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      av.a(av.e.f).post(ExplorePublicGroupsActivity.a(ExplorePublicGroupsActivity.this));
    }
  };

  public static Intent a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    Intent localIntent = a(ExplorePublicGroupsActivity.class);
    if (!da.a(paramString1))
      localIntent.putExtra("search_query", paramString1);
    if (paramBoolean1)
      localIntent.putExtra("show_create_public_chat_menu_item", true);
    if (paramBoolean2)
    {
      localIntent.putExtra("extra_cards_path", true);
      if (!da.a(paramString2))
        localIntent.putExtra("origin", paramString2);
    }
    return localIntent;
  }

  public static Intent a(boolean paramBoolean, String paramString)
  {
    return a(null, false, paramBoolean, paramString);
  }

  private void a(MenuItem paramMenuItem, boolean paramBoolean)
  {
    if (paramMenuItem != null)
      paramMenuItem.setVisible(paramBoolean);
  }

  private void l()
  {
    int i = (int)(System.currentTimeMillis() - this.b) / 1000;
    ViberApplication.getInstance().getEngine(false).getCdrController().handleReportDiscoverScreenSession(w(), i);
  }

  protected WebViewClient a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: new 108	com/viber/voip/market/ExplorePublicGroupsActivity$3
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 111	com/viber/voip/market/ExplorePublicGroupsActivity$3:<init>	(Lcom/viber/voip/market/ExplorePublicGroupsActivity;Ljava/lang/Runnable;)V
    //   9: areturn
  }

  protected String a(String paramString)
  {
    Intent localIntent = getIntent();
    getSupportActionBar().a(d());
    String str1 = localIntent.getStringExtra("origin");
    if (!da.a(str1))
      paramString = dl.g(paramString, str1);
    String str2 = dl.h(dl.j(dl.b(paramString)));
    String str3 = localIntent.getStringExtra("search_query");
    if (str3 != null)
      str2 = Uri.parse(str2).buildUpon().appendEncodedPath("#").appendPath("search").appendQueryParameter("search", str3).build().toString();
    return str2;
  }

  protected String c()
  {
    if (getIntent().getBooleanExtra("extra_cards_path", false))
      return ap.c().aD + "cards";
    return ap.c().aD;
  }

  protected String d()
  {
    return getString(R.string.pg_activity_title_search);
  }

  protected Intent f()
  {
    return ViberActionRunner.aq.b();
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (!ViberApplication.isTablet(this))
      com.viber.voip.n.a.d(this);
    super.onCreate(paramBundle);
    this.c = new Runnable()
    {
      public void run()
      {
        if (ab.b().C() > 0L);
        for (final boolean bool = true; ; bool = false)
        {
          av.a(av.e.a).post(new Runnable()
          {
            public void run()
            {
              ExplorePublicGroupsActivity.this.getIntent().putExtra("extra_show_public_chats_icon", bool);
              ExplorePublicGroupsActivity.this.invalidateOptionsMenu();
            }
          });
          return;
        }
      }
    };
    av.a(av.e.f).post(this.c);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_discover_pa, paramMenu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (R.id.menu_create_public_chat == paramMenuItem.getItemId())
    {
      ViberActionRunner.aq.a(this);
      return true;
    }
    if (R.id.menu_public_chats == paramMenuItem.getItemId())
      ViberActionRunner.aq.b(this);
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool1 = getIntent().getBooleanExtra("show_create_public_chat_menu_item", false);
    boolean bool2 = getIntent().getBooleanExtra("extra_show_public_chats_icon", false);
    a(paramMenu.findItem(R.id.menu_create_public_chat), bool1);
    a(paramMenu.findItem(R.id.menu_public_chats), bool2);
    return true;
  }

  protected void onResume()
  {
    super.onResume();
    d.a(this);
    com.viber.voip.h.a.b().post(new com.viber.voip.ui.e.a());
  }

  protected void onStart()
  {
    super.onStart();
    this.b = System.currentTimeMillis();
    o.a().a(this.d);
  }

  protected void onStop()
  {
    super.onStop();
    l();
    av.a(av.e.f).removeCallbacks(this.c);
    o.a().b(this.d);
  }

  protected boolean t_()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.ExplorePublicGroupsActivity
 * JD-Core Version:    0.6.2
 */