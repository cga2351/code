package com.viber.voip.messages.ui.media.simple;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.a.f.a;
import com.viber.voip.messages.a.f.a.a;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.b;
import com.viber.voip.messages.controller.ai.e;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.AlertView;
import com.viber.voip.messages.conversation.ui.banner.AlertView.b;
import com.viber.voip.messages.conversation.ui.bd;
import com.viber.voip.messages.extras.a.e.b;
import com.viber.voip.messages.forward.GroupReferralForwardInfo;
import com.viber.voip.messages.k;
import com.viber.voip.messages.l;
import com.viber.voip.messages.m;
import com.viber.voip.messages.ui.view.ViewPagerWithPagingEnable;
import com.viber.voip.util.ViberActionRunner.az.c;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.at;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.j;
import com.viber.voip.util.u;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class ViewMediaSimpleActivity extends ViberFragmentActivity
  implements ai.e, AlertView.b, e.a
{
  private final e.b A = new e.b()
  {
  };
  private final ViewPager.OnPageChangeListener B = new ViewPager.SimpleOnPageChangeListener()
  {
    public void onPageSelected(int paramAnonymousInt)
    {
      int i = 1;
      super.onPageSelected(paramAnonymousInt);
      ViewMediaSimpleActivity localViewMediaSimpleActivity = ViewMediaSimpleActivity.this;
      if (ViewMediaSimpleActivity.c(ViewMediaSimpleActivity.this).getCount() > i);
      while (true)
      {
        localViewMediaSimpleActivity.a(i);
        ViewMediaSimpleActivity.a(ViewMediaSimpleActivity.this, ViewMediaSimpleActivity.c(ViewMediaSimpleActivity.this).a(paramAnonymousInt));
        ViewMediaSimpleActivity.d(ViewMediaSimpleActivity.this);
        ViewMediaSimpleActivity.a(ViewMediaSimpleActivity.this, ViewMediaSimpleActivity.b(ViewMediaSimpleActivity.this).a());
        ViewMediaSimpleActivity.c(ViewMediaSimpleActivity.this, paramAnonymousInt);
        ViewMediaSimpleActivity.this.supportInvalidateOptionsMenu();
        return;
        int j = 0;
      }
    }
  };

  @Inject
  com.viber.voip.messages.extensions.c a;

  @Inject
  com.viber.voip.messages.controller.manager.c b;

  @Inject
  ai c;

  @Inject
  com.viber.voip.invitelinks.d d;

  @Inject
  com.viber.voip.messages.extras.a.e e;

  @Inject
  dagger.a<com.viber.voip.analytics.story.e.c> f;

  @Inject
  ScheduledExecutorService g;
  private ViewPagerWithPagingEnable i;
  private j j;
  private a k;
  private Menu l;
  private long m;
  private boolean n;
  private int o;
  private boolean p;
  private boolean q;
  private String r;
  private boolean s;
  private long t;
  private String u;
  private int v;
  private com.viber.voip.group.participants.settings.b w;
  private bd x;
  private com.viber.voip.messages.controller.manager.f y;
  private a z;

  private static File a(a parama, Context paramContext)
  {
    if (parama == null)
      return null;
    String str = parama.a();
    if (3 == parama.c())
      return dv.b.b(paramContext, str, false);
    return dv.a.b(paramContext, str, false);
  }

  private void a(int paramInt)
  {
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
    {
      int i1 = this.j.getCount();
      if (i1 > 1)
        locala.b(paramInt + 1 + "/" + i1);
    }
  }

  private void a(long paramLong)
  {
    if (paramLong >= 0L)
      ViberApplication.getInstance().getMessagesManager().c().a(paramLong, this);
  }

  private void a(b paramb)
  {
    if (this.k != null)
      av.a(av.e.f).post(new d(this, paramb, this.k.n(), this.k.c()));
  }

  private boolean a(List<SimpleMediaViewItem> paramList)
  {
    if (u.a(paramList))
      return false;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      if (!((SimpleMediaViewItem)localIterator.next()).isValid())
        return false;
    return true;
  }

  private void b()
  {
    int i1 = 1;
    if (this.l == null)
      return;
    if (this.k == null)
    {
      dj.a(this.l);
      return;
    }
    boolean bool1 = this.k.d();
    int i4;
    label79: int i7;
    label130: label153: int i8;
    label166: label199: label242: MenuItem localMenuItem6;
    if ((!this.q) && (!bool1) && (this.a.f()) && (this.k.m()))
    {
      int i2 = i1;
      if (this.k.n() == null)
        break label461;
      i4 = i1;
      if ((this.k.e() <= 0L) || (!m.a(this.n, this.o, this.k.g(), this.k.f(), this.v, this.w)))
        break label467;
      int i5 = i1;
      if ((this.k.i()) || (this.k.k()))
        break label473;
      i7 = i1;
      if (this.k.i())
        break label479;
      i8 = i1;
      MenuItem localMenuItem1 = this.l.findItem(R.id.menu_social);
      if ((i4 == 0) || (bool1) || (!this.p))
        break label485;
      int i9 = i1;
      localMenuItem1.setVisible(i9);
      MenuItem localMenuItem2 = this.l.findItem(R.id.menu_view_image_forward);
      if ((i4 == 0) || (bool1) || (!this.p))
        break label491;
      int i11 = i1;
      localMenuItem2.setVisible(i11);
      MenuItem localMenuItem3 = this.l.findItem(R.id.menu_set_wallpaper_screen);
      if ((i4 == 0) || (i7 == 0))
        break label497;
      int i13 = i1;
      label279: localMenuItem3.setVisible(i13);
      MenuItem localMenuItem4 = this.l.findItem(R.id.menu_set_lock_screen);
      if ((i4 == 0) || (i7 == 0))
        break label503;
      int i15 = i1;
      label316: localMenuItem4.setVisible(i15);
      this.l.findItem(R.id.delete_menu).setVisible(i5);
      MenuItem localMenuItem5 = this.l.findItem(R.id.menu_save_to_gallery);
      boolean bool2 = false;
      if (i4 != 0)
      {
        bool2 = false;
        if (i8 != 0)
        {
          boolean bool3 = this.k.l();
          bool2 = false;
          if (!bool3)
            bool2 = i1;
        }
      }
      localMenuItem5.setVisible(bool2);
      this.l.findItem(R.id.menu_favorite_links_bot).setVisible(i2);
      localMenuItem6 = this.l.findItem(R.id.menu_social);
      if (i2 == 0)
        break label509;
    }
    while (true)
    {
      localMenuItem6.setShowAsAction(i1);
      d();
      return;
      int i3 = 0;
      break;
      label461: i4 = 0;
      break label79;
      label467: int i6 = 0;
      break label130;
      label473: i7 = 0;
      break label153;
      label479: i8 = 0;
      break label166;
      label485: int i10 = 0;
      break label199;
      label491: int i12 = 0;
      break label242;
      label497: int i14 = 0;
      break label279;
      label503: int i16 = 0;
      break label316;
      label509: i1 = 2;
    }
  }

  private void b(String paramString)
  {
    if (!da.a(this.r));
    android.support.v7.app.a locala;
    do
    {
      return;
      locala = getSupportActionBar();
    }
    while (locala == null);
    locala.a(paramString);
  }

  private void c()
  {
    if (this.k == null);
    String str1;
    do
    {
      return;
      str1 = this.k.b();
    }
    while (this.y.b(str1));
    BotFavoriteLinksCommunicator.SaveLinkActionMessage.a locala = BotFavoriteLinksCommunicator.SaveLinkActionMessage.builder();
    if (this.k.j())
      locala.c(str1);
    while (true)
    {
      String str2 = this.y.a(str1);
      BotFavoriteLinksCommunicator.SaveLinkActionMessage localSaveLinkActionMessage = locala.a(str1).e(this.a.e()).a(4).h("Media Viewer").f(str2).b();
      d();
      this.b.a().a(localSaveLinkActionMessage);
      this.g.execute(new c(this, localSaveLinkActionMessage));
      return;
      if (this.k.i())
        locala.g("gif").a(this.k.p(), this.k.q());
    }
  }

  private void d()
  {
    if ((isFinishing()) || (this.l == null));
    MenuItem localMenuItem;
    do
    {
      do
        return;
      while (this.k == null);
      localMenuItem = this.l.findItem(R.id.menu_favorite_links_bot);
    }
    while (localMenuItem == null);
    String str = this.k.b();
    if (this.y.b(str));
    for (int i1 = R.drawable.ic_media_preview_favorites_highlighted; ; i1 = R.drawable.ic_media_preview_favorites)
    {
      localMenuItem.setIcon(i1);
      return;
    }
  }

  private void e()
  {
    if (this.k == null)
      return;
    Intent localIntent;
    if (this.k.e() > 0L)
    {
      localIntent = ViberActionRunner.u.a(this.k.e(), this.k.c());
      if (this.s)
      {
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("group_referral_extra_info", new GroupReferralForwardInfo(this.t, this.o, this.u));
        ViberActionRunner.u.a(localIntent, localBundle);
      }
    }
    while (true)
    {
      startActivity(localIntent);
      finish();
      return;
      if (this.k.i())
      {
        localIntent = ViberActionRunner.u.a(this.k.a(), false);
      }
      else
      {
        localIntent = ViberActionRunner.u.a(this.k.o(), this.k.c());
        localIntent.putExtra("need_description", false);
      }
    }
  }

  private void f()
  {
    if ((this.k == null) || (this.k.e() <= 0L))
      return;
    ai.b local2 = new ai.b()
    {
      public void a(Set<Long> paramAnonymousSet)
      {
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            ViewMediaSimpleActivity.c(ViewMediaSimpleActivity.this).a(ViewMediaSimpleActivity.b(ViewMediaSimpleActivity.this));
            if (ViewMediaSimpleActivity.c(ViewMediaSimpleActivity.this).getCount() == 0)
            {
              ViewMediaSimpleActivity.this.finish();
              return;
            }
            ViewMediaSimpleActivity.c(ViewMediaSimpleActivity.this).notifyDataSetChanged();
          }
        });
      }
    };
    if (this.n)
    {
      this.c.a(this.k.e(), local2);
      return;
    }
    this.c.a(Collections.singleton(Long.valueOf(this.k.e())), false, local2);
  }

  private void g()
  {
    if ((this.k == null) || (this.k.l()));
    File localFile;
    do
    {
      return;
      localFile = a(this.k, this);
    }
    while ((localFile == null) || (!com.viber.voip.util.upload.o.b(true)) || (!com.viber.voip.util.upload.o.a(true)));
    a(new g(new f(Uri.fromFile(localFile), this.k.c(), null)));
  }

  private void h()
  {
    if (this.k != null)
      a(new i(this, this.c, this.d, this.k.c(), this.m));
  }

  private void i()
  {
    getWindow().setFlags(1024, 1024);
    supportRequestWindowFeature(9);
  }

  private void j()
  {
    if (this.k == null)
      return;
    File localFile = a(this.k, this);
    a locala = this.k;
    if ((localFile != null) && (localFile.exists()));
    for (boolean bool = true; ; bool = false)
    {
      locala.a(bool);
      if (!this.k.l())
        break;
      this.k.a(Uri.fromFile(localFile));
      return;
    }
  }

  public AlertView M_()
  {
    return (AlertView)dj.e(getWindow().getDecorView().getRootView(), R.id.bottom_alert_banner);
  }

  public void a(final ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        String str = dg.b(paramConversationItemLoaderEntity);
        ViewMediaSimpleActivity.a(ViewMediaSimpleActivity.this, str);
        ViewMediaSimpleActivity.b(ViewMediaSimpleActivity.this, str);
        ViewMediaSimpleActivity.a(ViewMediaSimpleActivity.this, paramConversationItemLoaderEntity.isPublicGroupBehavior());
        ViewMediaSimpleActivity localViewMediaSimpleActivity = ViewMediaSimpleActivity.this;
        if (!paramConversationItemLoaderEntity.isNotShareablePublicAccount());
        for (boolean bool = true; ; bool = false)
        {
          ViewMediaSimpleActivity.b(localViewMediaSimpleActivity, bool);
          ViewMediaSimpleActivity.c(ViewMediaSimpleActivity.this, paramConversationItemLoaderEntity.isSecret());
          ViewMediaSimpleActivity.c(ViewMediaSimpleActivity.this, paramConversationItemLoaderEntity.getGroupName());
          ViewMediaSimpleActivity.a(ViewMediaSimpleActivity.this, paramConversationItemLoaderEntity.getGroupId());
          ViewMediaSimpleActivity.d(ViewMediaSimpleActivity.this, m.c(paramConversationItemLoaderEntity));
          ViewMediaSimpleActivity.a(ViewMediaSimpleActivity.this, paramConversationItemLoaderEntity.getGroupRole());
          ViewMediaSimpleActivity.b(ViewMediaSimpleActivity.this, paramConversationItemLoaderEntity.getConversationType());
          ViewMediaSimpleActivity.a(ViewMediaSimpleActivity.this, paramConversationItemLoaderEntity);
          ViewMediaSimpleActivity.a(ViewMediaSimpleActivity.this);
          return;
        }
      }
    });
  }

  public void a(String paramString)
  {
    this.j.a(paramString, null);
    supportInvalidateOptionsMenu();
  }

  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.j.a(paramString, paramInt1, paramInt2);
  }

  public void a(String paramString, Uri paramUri)
  {
    this.j.a(paramString, paramUri);
    supportInvalidateOptionsMenu();
  }

  public void a(boolean paramBoolean)
  {
    this.i.setPagingEnabled(paramBoolean);
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    i();
    super.onCreate(paramBundle);
    setContentView(R.layout.view_media_simple_layout);
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("extra_simple_media_viewer_items");
    if (!a(localArrayList))
    {
      finish();
      return;
    }
    this.y = new com.viber.voip.messages.controller.manager.f(localArrayList.size());
    this.z = new a(this, 4);
    com.viber.voip.h.a.b().register(this.z);
    this.x = new bd(this, this, av.e.a.a(), com.viber.voip.h.a.b(), 4, com.viber.voip.messages.conversation.ui.banner.o.a, getLayoutInflater());
    this.m = getIntent().getLongExtra("extra_simple_media_viewer_conversation_id", -1L);
    a(this.m);
    this.e.a(this.A);
    this.j = new j(getSupportFragmentManager(), localArrayList);
    this.i = ((ViewPagerWithPagingEnable)findViewById(R.id.media_pager));
    this.i.setAdapter(this.j);
    this.i.addOnPageChangeListener(this.B);
    int i1 = Math.max(getIntent().getIntExtra("extra_simple_media_viewer_focused_item_position", 0), 0);
    this.i.setCurrentItem(i1, false);
    this.B.onPageSelected(i1);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_media_view, paramMenu);
    this.l = paramMenu;
    this.l.findItem(R.id.menu_view_image_background).setVisible(false);
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    ViberApplication.getInstance().getFacebookManager().b(this.A);
    com.viber.voip.h.a.b().unregister(this.z);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    if (i1 == 16908332)
      finish();
    while (true)
    {
      return true;
      if (i1 == R.id.menu_social)
        h();
      else if (i1 == R.id.menu_view_image_forward)
        e();
      else if (i1 == R.id.menu_set_wallpaper_screen)
        a(new h(this));
      else if (i1 == R.id.menu_set_lock_screen)
        a(new e(this));
      else if (i1 == R.id.menu_save_to_gallery)
        g();
      else if (i1 == R.id.delete_menu)
        f();
      else if (i1 == R.id.menu_favorite_links_bot)
        c();
    }
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    b();
    return super.onPrepareOptionsMenu(paramMenu);
  }

  protected void onStart()
  {
    super.onStart();
    this.x.a();
  }

  protected void onStop()
  {
    super.onStop();
    this.x.b();
  }

  private static final class a extends f.a.a<ViewMediaSimpleActivity>
  {
    public a(ViewMediaSimpleActivity paramViewMediaSimpleActivity, int paramInt)
    {
      super(paramInt);
    }

    protected void a(ViewMediaSimpleActivity paramViewMediaSimpleActivity, f.a parama)
    {
      if ((ViewMediaSimpleActivity.e(paramViewMediaSimpleActivity).a(parama.a, parama.c)) && (!paramViewMediaSimpleActivity.isFinishing()))
        paramViewMediaSimpleActivity.supportInvalidateOptionsMenu();
    }
  }

  private static abstract interface b
  {
    public abstract void a(Uri paramUri);
  }

  private static abstract interface c
  {
    public abstract void a(Uri paramUri);
  }

  private static class d
    implements Runnable
  {
    WeakReference<Context> a = null;
    WeakReference<ViewMediaSimpleActivity.b> b = null;
    Uri c;
    final int d;

    public d(Context paramContext, ViewMediaSimpleActivity.b paramb, Uri paramUri, int paramInt)
    {
      this.a = new WeakReference(paramContext);
      this.b = new WeakReference(paramb);
      this.c = paramUri;
      this.d = paramInt;
    }

    private Uri a()
    {
      Context localContext = (Context)this.a.get();
      if ((localContext != null) && ((dx.e(this.c)) || (!at.d(localContext, this.c.toString()))))
      {
        if ((1005 == this.d) && (this.c.getScheme() != null) && (this.c.getScheme().startsWith("http")))
        {
          File localFile = dv.u.b(localContext, this.c.toString(), false);
          if ((localFile != null) && (localFile.exists()))
            return Uri.fromFile(localFile);
        }
        String str1 = com.viber.voip.util.e.e.a(this.c);
        if (str1 == null)
          return null;
        Uri localUri1 = Uri.fromFile(new File(str1));
        if (1 == this.d);
        for (String str2 = str1 + ".jpg"; ; str2 = str1 + ".mp4")
        {
          Uri localUri2 = Uri.fromFile(new File(str2));
          at.a(localUri1, localUri2);
          return localUri2;
          if (3 != this.d)
            break;
        }
        return j.a(new File(com.viber.voip.util.e.e.a(this.c)), l.j(this.d));
      }
      return this.c;
    }

    public void run()
    {
      Uri localUri = a();
      ViewMediaSimpleActivity.b localb = (ViewMediaSimpleActivity.b)this.b.get();
      if (localb != null)
        localb.a(localUri);
    }
  }

  private static class e
    implements ViewMediaSimpleActivity.b
  {
    WeakReference<Context> a = null;

    public e(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }

    public void a(final Uri paramUri)
    {
      av.a(av.e.a).post(new Runnable()
      {
        public void run()
        {
          if (paramUri != null)
          {
            Context localContext = (Context)ViewMediaSimpleActivity.e.this.a.get();
            if (localContext != null)
              com.viber.voip.messages.extras.image.b.b(localContext, paramUri);
          }
        }
      });
    }
  }

  private class f
    implements ViewMediaSimpleActivity.c
  {
    private final Uri b;
    private final int c;

    private f(Uri paramInt, int arg3)
    {
      this.b = paramInt;
      int i;
      this.c = i;
    }

    public void a(Uri paramUri)
    {
      if (at.b(paramUri, this.b))
        ViewMediaSimpleActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            int i = 1;
            if (SimpleMediaViewItem.isImageOrGifType(ViewMediaSimpleActivity.f.a(ViewMediaSimpleActivity.f.this)))
              if (com.viber.voip.util.upload.o.b(ViewMediaSimpleActivity.f.b(ViewMediaSimpleActivity.f.this)) == null);
            while (true)
            {
              if (i != 0)
              {
                ViewMediaSimpleActivity.d(ViewMediaSimpleActivity.this);
                ViewMediaSimpleActivity.this.supportInvalidateOptionsMenu();
              }
              return;
              i = 0;
              continue;
              if (SimpleMediaViewItem.isVideoType(ViewMediaSimpleActivity.f.a(ViewMediaSimpleActivity.f.this)))
              {
                if (com.viber.voip.util.upload.o.a(ViewMediaSimpleActivity.f.b(ViewMediaSimpleActivity.f.this)) == null)
                  i = 0;
              }
              else
                i = 0;
            }
          }
        });
    }
  }

  private static class g
    implements ViewMediaSimpleActivity.b
  {
    WeakReference<ViewMediaSimpleActivity.c> a = null;

    public g(ViewMediaSimpleActivity.c paramc)
    {
      this.a = new WeakReference(paramc);
    }

    public void a(Uri paramUri)
    {
      if (paramUri != null)
      {
        ViewMediaSimpleActivity.c localc = (ViewMediaSimpleActivity.c)this.a.get();
        if (localc != null)
          localc.a(paramUri);
      }
    }
  }

  private static class h
    implements ViewMediaSimpleActivity.b
  {
    WeakReference<Context> a = null;

    public h(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }

    public void a(final Uri paramUri)
    {
      av.a(av.e.a).post(new Runnable()
      {
        public void run()
        {
          if (paramUri != null)
          {
            Context localContext = (Context)ViewMediaSimpleActivity.h.this.a.get();
            if (localContext != null)
              com.viber.voip.messages.extras.image.b.a(localContext, paramUri);
          }
        }
      });
    }
  }

  private static class i
    implements ViewMediaSimpleActivity.b
  {
    WeakReference<Context> a;
    final int b;
    private final ai c;
    private final com.viber.voip.invitelinks.d d;
    private final long e;

    public i(Context paramContext, ai paramai, com.viber.voip.invitelinks.d paramd, int paramInt, long paramLong)
    {
      this.a = new WeakReference(paramContext);
      this.c = paramai;
      this.d = paramd;
      this.b = paramInt;
      this.e = paramLong;
    }

    public void a(final Uri paramUri)
    {
      av.a(av.e.a).post(new Runnable()
      {
        public void run()
        {
          if (paramUri != null)
          {
            Context localContext = (Context)ViewMediaSimpleActivity.i.this.a.get();
            if (localContext != null)
              new ViberActionRunner.az.c(localContext, ViewMediaSimpleActivity.i.b(ViewMediaSimpleActivity.i.this), new com.viber.voip.invitelinks.f(ViewMediaSimpleActivity.i.c(ViewMediaSimpleActivity.i.this), cj.a(localContext))).a(ViewMediaSimpleActivity.i.a(ViewMediaSimpleActivity.i.this), ViewMediaSimpleActivity.i.this.b, paramUri.toString());
          }
        }
      });
    }
  }

  private static class j extends FragmentStatePagerAdapter
  {
    private List<a> a = new ArrayList();

    public j(FragmentManager paramFragmentManager, List<SimpleMediaViewItem> paramList)
    {
      super();
      a(paramList);
    }

    public a a(int paramInt)
    {
      return (a)this.a.get(paramInt);
    }

    public void a(a parama)
    {
      this.a.remove(parama);
    }

    public void a(String paramString, int paramInt1, int paramInt2)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a().equals(paramString))
          locala.a(paramInt1, paramInt2);
      }
    }

    public void a(String paramString, Uri paramUri)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a().equals(paramString))
          locala.a(paramUri);
      }
    }

    public void a(List<SimpleMediaViewItem> paramList)
    {
      this.a.clear();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        SimpleMediaViewItem localSimpleMediaViewItem = (SimpleMediaViewItem)localIterator.next();
        this.a.add(new a(localSimpleMediaViewItem));
      }
    }

    public int getCount()
    {
      return this.a.size();
    }

    public Fragment getItem(int paramInt)
    {
      a locala = (a)this.a.get(paramInt);
      if (locala.h())
        return b.a(locala.a(), locala.c());
      if (locala.k())
        return f.b(locala.a());
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.simple.ViewMediaSimpleActivity
 * JD-Core Version:    0.6.2
 */