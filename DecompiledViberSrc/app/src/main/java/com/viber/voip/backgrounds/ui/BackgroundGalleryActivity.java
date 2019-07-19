package com.viber.voip.backgrounds.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av.e;
import com.viber.voip.backgrounds.c.e.a;
import com.viber.voip.backgrounds.l;
import com.viber.voip.backgrounds.p;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.d;
import com.viber.voip.model.entity.h;
import com.viber.voip.permissions.m;
import com.viber.voip.settings.d.i;
import com.viber.voip.ui.c.j;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.at;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import javax.inject.Inject;

public class BackgroundGalleryActivity extends ViberFragmentActivity
  implements AdapterView.OnItemClickListener
{
  private static final Logger g = ViberEnv.getLogger();
  protected Uri a;
  protected com.viber.voip.backgrounds.a.a b;

  @Inject
  com.viber.voip.analytics.g c;
  com.viber.voip.backgrounds.c.e d;
  e.a e;
  long f;
  private View h;
  private GridView i;
  private View j;
  private h k;
  private MenuItem l;
  private com.viber.voip.backgrounds.b m;
  private com.viber.common.permission.c n;
  private volatile int o;
  private boolean p;
  private final com.viber.common.permission.b q;
  private final Runnable r;
  private com.viber.voip.backgrounds.f s;

  public BackgroundGalleryActivity()
  {
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = m.a(6);
    arrayOfPair[1] = m.a(125);
    this.q = new com.viber.voip.permissions.f(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 6:
          BackgroundGalleryActivity.a(BackgroundGalleryActivity.this);
          return;
        case 125:
        }
        BackgroundGalleryActivity.b(BackgroundGalleryActivity.this);
      }
    };
    this.r = new Runnable()
    {
      public void run()
      {
        int i = com.viber.voip.backgrounds.g.b(BackgroundGalleryActivity.c(BackgroundGalleryActivity.this), BackgroundGalleryActivity.d(BackgroundGalleryActivity.this));
        BackgroundGalleryActivity.this.b.b(i);
        BackgroundGalleryActivity.d(BackgroundGalleryActivity.this).setAdapter(BackgroundGalleryActivity.this.b);
        BackgroundGalleryActivity.this.b.notifyDataSetChanged();
      }
    };
    this.s = new com.viber.voip.backgrounds.e()
    {
      public void a(final com.viber.voip.backgrounds.a paramAnonymousa)
      {
        com.viber.voip.av.a(av.e.f).post(new Runnable()
        {
          public void run()
          {
            int i = d.i.a.d();
            if ((paramAnonymousa != null) && (paramAnonymousa.a() > i))
              com.viber.voip.backgrounds.b.a().b(paramAnonymousa.a());
            while (true)
            {
              com.viber.voip.av.a(av.e.a).post(new Runnable()
              {
                public void run()
                {
                  BackgroundGalleryActivity.e(BackgroundGalleryActivity.this);
                }
              });
              return;
              com.viber.voip.backgrounds.b.a().b(i);
            }
          }
        });
      }

      public void a(l paramAnonymousl)
      {
        com.viber.voip.av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            BackgroundGalleryActivity.e(BackgroundGalleryActivity.this);
          }
        });
      }

      public void a(l paramAnonymousl, int paramAnonymousInt)
      {
        BackgroundGalleryActivity.f(BackgroundGalleryActivity.this);
      }

      public void a(l paramAnonymousl, p paramAnonymousp)
      {
      }

      public void b(l paramAnonymousl)
      {
        com.viber.voip.av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            BackgroundGalleryActivity.e(BackgroundGalleryActivity.this);
          }
        });
        com.viber.voip.ui.dialogs.k.n().d();
      }
    };
    this.d = ViberApplication.getInstance().getBackgroundDownloadTaskController();
    this.e = new e.a()
    {
      public long a()
      {
        return BackgroundGalleryActivity.this.f;
      }

      public void a(int paramAnonymousInt)
      {
        if (BackgroundGalleryActivity.g(BackgroundGalleryActivity.this) == 0)
          return;
        BackgroundGalleryActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            dj.b(BackgroundGalleryActivity.h(BackgroundGalleryActivity.this), true);
          }
        });
      }

      public void a(int paramAnonymousInt, Uri[] paramAnonymousArrayOfUri)
      {
        if (paramAnonymousInt == BackgroundGalleryActivity.g(BackgroundGalleryActivity.this))
          BackgroundGalleryActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              dj.b(BackgroundGalleryActivity.h(BackgroundGalleryActivity.this), false);
              BackgroundGalleryActivity.this.setResult(-1, new Intent("conversation_viber_background_set"));
              BackgroundGalleryActivity.this.finish();
            }
          });
      }

      public void b(int paramAnonymousInt)
      {
        BackgroundGalleryActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            dj.b(BackgroundGalleryActivity.h(BackgroundGalleryActivity.this), false);
            if (cj.c(BackgroundGalleryActivity.this))
              com.viber.voip.ui.dialogs.f.d().a(BackgroundGalleryActivity.this);
            BackgroundGalleryActivity.a(BackgroundGalleryActivity.this, 0);
          }
        });
      }
    };
  }

  private void a(Intent paramIntent)
  {
    if (paramIntent.getExtras() != null)
    {
      this.f = paramIntent.getExtras().getLong("thread_id", -1L);
      if (this.f == -1L)
        break label74;
      ViberApplication.getInstance().getMessagesManager().c().a(this.f, new ai.d()
      {
        public void a(h paramAnonymoush)
        {
          BackgroundGalleryActivity.a(BackgroundGalleryActivity.this, paramAnonymoush, BackgroundGalleryActivity.this.f);
        }
      });
    }
    while (true)
    {
      this.p = paramIntent.getBooleanExtra("opened_from_settings", false);
      return;
      label74: this.k = null;
    }
  }

  private void a(Uri paramUri1, Uri paramUri2)
  {
    if (this.k == null);
    while ((paramUri1 == null) || (paramUri2 == null))
      return;
    ViberApplication.getInstance().getMessagesManager().d().a(this.k.getId(), this.k.j(), paramUri1.toString(), paramUri2.toString());
  }

  private void a(final h paramh, long paramLong)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        BackgroundGalleryActivity.a(BackgroundGalleryActivity.this, paramh);
        if ((BackgroundGalleryActivity.i(BackgroundGalleryActivity.this) != null) && (!BackgroundGalleryActivity.this.a()))
          BackgroundGalleryActivity.i(BackgroundGalleryActivity.this).setVisible(false);
        BackgroundGalleryActivity.this.a(BackgroundGalleryActivity.j(BackgroundGalleryActivity.this));
      }
    });
  }

  private Activity b()
  {
    return this;
  }

  private void c()
  {
    if (this.h.getVisibility() == 0)
      this.h.setVisibility(8);
  }

  private void d()
  {
    if (this.h.getVisibility() == 8)
      this.h.setVisibility(0);
  }

  private void e()
  {
    this.i = ((GridView)findViewById(R.id.gridview));
    this.i.setClipToPadding(false);
    this.i.setOnItemClickListener(this);
    this.h = findViewById(R.id.progressView);
  }

  private void f()
  {
    if (this.n.a(com.viber.voip.permissions.n.c))
    {
      g();
      return;
    }
    this.n.a(this, 6, com.viber.voip.permissions.n.c);
  }

  private void g()
  {
    this.a = dv.h.a(this, null, true);
    if (this.a != null)
      ViberActionRunner.a(this, this.a, 2002);
  }

  private void h()
  {
    if (this.n.a(com.viber.voip.permissions.n.m))
    {
      i();
      return;
    }
    this.n.a(this, 125, com.viber.voip.permissions.n.m);
  }

  private void i()
  {
    startActivityForResult(ViberActionRunner.a(new Intent().setType("image/*").setAction("android.intent.action.GET_CONTENT"), getString(R.string.msg_options_take_photo), new Intent[0]), 2001);
  }

  private boolean j()
  {
    return ((this.k != null) && (!da.a(this.k.t()))) || (k());
  }

  private boolean k()
  {
    Intent localIntent = getIntent();
    boolean bool1 = false;
    if (localIntent != null)
    {
      Bundle localBundle = getIntent().getExtras();
      bool1 = false;
      if (localBundle != null)
      {
        boolean bool2 = getIntent().getExtras().getBoolean("has_background", false);
        bool1 = false;
        if (bool2)
          bool1 = true;
      }
    }
    return bool1;
  }

  private void l()
  {
    d();
    this.b.c(null);
    this.m.f();
  }

  protected void a(Uri paramUri, String paramString)
  {
    Intent localIntent = com.viber.voip.messages.extras.image.b.a(this, new com.viber.voip.backgrounds.n(paramUri));
    localIntent.putExtra("image_change_type", paramString);
    startActivityForResult(localIntent, 2004);
  }

  protected void a(h paramh)
  {
  }

  protected boolean a()
  {
    return j();
  }

  protected com.viber.voip.ui.c.c createActivityDecorator()
  {
    return new com.viber.voip.ui.c.d(new j(), this, (com.viber.voip.ui.j.av)ViberApplication.getInstance().getThemeController().get());
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
      switch (paramInt1)
      {
      case 2003:
      default:
      case 2001:
      case 2002:
      case 2004:
      }
    do
    {
      do
      {
        do
        {
          do
            return;
          while ((paramIntent == null) || (paramIntent.getData() == null));
          Uri localUri = paramIntent.getData();
          if (!localUri.equals(this.a))
            at.d(this, this.a);
          a(localUri, "Gallery");
          return;
        }
        while (this.a == null);
        a(this.a, "Camera");
        return;
      }
      while ((paramIntent == null) || (paramIntent.getExtras() == null));
      setResult(-1, paramIntent);
      a(Uri.parse(paramIntent.getAction()), Uri.parse(paramIntent.getStringExtra("landscapeUri")));
      finish();
    }
    while (this.a == null);
    this.a = null;
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    setContentView(R.layout.background_gallery_layout);
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    this.j = findViewById(R.id.toolbar_indeterminate_progress);
    android.support.v7.app.a locala = getSupportActionBar();
    locala.a(false);
    locala.b(true);
    locala.b(R.string.select_background_title);
    a(getIntent());
    e();
    this.n = com.viber.common.permission.c.a(this);
    this.m = com.viber.voip.backgrounds.b.a();
    this.m.a(this.s);
    this.b = new com.viber.voip.backgrounds.a.a(this);
    this.m.a(true);
    dj.a(this.i, this.r);
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getString("temp_uri_key");
      this.o = paramBundle.getInt("background_id_key");
      if (!da.a(str))
        break label172;
    }
    label172: for (Uri localUri = null; ; localUri = Uri.parse(str))
    {
      this.a = localUri;
      return;
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_background_gallery, paramMenu);
    this.l = paramMenu.findItem(R.id.menu_remove_background);
    if (!a())
      paramMenu.removeItem(R.id.menu_remove_background);
    paramMenu.removeItem(R.id.menu_clear_backgrounds);
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    com.viber.voip.backgrounds.b.a().b(this.s);
    if (this.b != null)
      this.b.a();
    GridView localGridView = this.i;
    int i1 = localGridView.getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      ImageView localImageView = (ImageView)localGridView.getChildAt(i2);
      if ((localImageView != null) && (localImageView.getDrawable() != null))
        localImageView.getDrawable().setCallback(null);
    }
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.o = this.b.a(paramInt).a;
    this.d.a(this.f, this.b.a(paramInt), true);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    if (i1 == 16908332)
      finish();
    while (true)
    {
      return true;
      if (i1 == R.id.menu_take_photo)
      {
        f();
      }
      else if (i1 == R.id.menu_photo_gallery)
      {
        h();
      }
      else if (i1 == R.id.menu_remove_background)
      {
        setResult(-1, new Intent("remove_conversation_background"));
        finish();
      }
      else
      {
        if (i1 != R.id.menu_clear_backgrounds)
          break;
        l();
      }
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onPause()
  {
    super.onPause();
    if (this.p)
      this.c.h().a(false);
  }

  protected void onResume()
  {
    super.onResume();
    if (this.p)
      this.c.h().a(true);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.a == null);
    for (String str = ""; ; str = this.a.toString())
    {
      paramBundle.putString("temp_uri_key", str);
      paramBundle.putInt("background_id_key", this.o);
      super.onSaveInstanceState(paramBundle);
      return;
    }
  }

  protected void onStart()
  {
    super.onStart();
    this.d.a(this.e);
    this.n.a(this.q);
  }

  protected void onStop()
  {
    super.onStop();
    this.n.b(this.q);
    this.d.b(this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.ui.BackgroundGalleryActivity
 * JD-Core Version:    0.6.2
 */