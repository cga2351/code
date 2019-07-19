package com.viber.voip.camrecorder.preview;

import android.animation.Animator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.viber.common.b.b;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.s;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.g;
import com.viber.voip.ui.doodle.a;
import com.viber.voip.ui.doodle.a.b;
import com.viber.voip.ui.doodle.b.c.b;
import com.viber.voip.ui.doodle.extras.TextInfo;
import com.viber.voip.ui.doodle.scene.SceneView;
import com.viber.voip.util.at;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.j;
import com.viber.voip.util.upload.o;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class e extends f
  implements m.c, k.a
{
  private static final Logger i = ViberEnv.getLogger();
  protected a a;
  private ImageView j;
  private k k;
  private MenuItem l;
  private MenuItem m;
  private MenuItem n;
  private c o;
  private View p;
  private m q;
  private View r;
  private c.b s;
  private c.b t;
  private SceneState u;
  private boolean v;
  private BroadcastReceiver w = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      String str = paramAnonymousIntent.getAction();
      if ("com.viber.voip.action.COLOR_CHANGED".equals(str))
      {
        i = paramAnonymousIntent.getIntExtra("color", -1);
        e.b(e.this, i);
        if (e.e(e.this).getVisibility() != 0)
          dj.b(e.e(e.this), true);
        e.a(e.this, true);
      }
      while (!"com.viber.voip.action.TEXT_INPUT_FINISHED".equals(str))
      {
        int i;
        return;
      }
      TextInfo localTextInfo = (TextInfo)paramAnonymousIntent.getParcelableExtra("text_info");
      Context localContext = e.e(e.this).getContext();
      e.b(e.this, dc.a(localContext, R.attr.menuItemIconTint, -1));
      dj.b(e.e(e.this), false);
      e.this.a.a(localTextInfo);
      e.a(e.this, false);
    }
  };

  private View a(View paramView)
  {
    switch (5.a[this.h.ordinal()])
    {
    default:
      return paramView.findViewById(R.id.btn_undo);
    case 1:
    }
    return this.o.i();
  }

  private void a(Uri paramUri, File paramFile)
    throws IOException
  {
    Bitmap localBitmap = j.a(getContext(), paramUri, 1280, 1280, false, true);
    if (localBitmap == null)
      throw new IOException("bitmap == null");
    this.a.a(localBitmap);
    if (j.a(localBitmap, paramFile) == null)
      throw new IOException("file == null");
  }

  private void a(MenuItem paramMenuItem)
  {
    b(false);
    c(false);
    if ((this.m != paramMenuItem) && (this.k.a()))
      this.k.onHide();
    this.o.e();
  }

  private void a(c.b paramb)
  {
    if (c.b.b == paramb)
      t();
    do
    {
      return;
      if (c.b.c == paramb)
      {
        e();
        return;
      }
    }
    while (c.b.a != paramb);
    s();
  }

  private void a(final TextInfo paramTextInfo)
  {
    if ((this.k.a()) || (this.k.b()))
    {
      this.k.onHide();
      this.k.a(new k.b()
      {
        public void a(int paramAnonymousInt)
        {
          if (paramAnonymousInt == 0)
          {
            e.d(e.this).b(this);
            e.this.a(false);
            Intent localIntent = EditTextActivity.a(e.this.getActivity(), paramTextInfo);
            e.this.startActivityForResult(localIntent, 7);
          }
        }
      });
      return;
    }
    a(false);
    startActivityForResult(EditTextActivity.a(getActivity(), paramTextInfo), 7);
  }

  private Animator[] a(Animator[] paramArrayOfAnimator, Animator paramAnimator)
  {
    Animator[] arrayOfAnimator = (Animator[])Arrays.copyOf(paramArrayOfAnimator, 1 + paramArrayOfAnimator.length);
    arrayOfAnimator[(-1 + arrayOfAnimator.length)] = paramAnimator;
    return arrayOfAnimator;
  }

  private void b(boolean paramBoolean)
  {
    MenuItem localMenuItem;
    if (this.m != null)
    {
      localMenuItem = this.n;
      if (!paramBoolean)
        break label29;
    }
    label29: for (int i1 = R.drawable.menu_icon_priview_doodle_pressed; ; i1 = R.drawable.menu_icon_priview_doodle_idle)
    {
      localMenuItem.setIcon(i1);
      return;
    }
  }

  private void c(boolean paramBoolean)
  {
    int i1;
    int i2;
    label33: MenuItem localMenuItem;
    if (this.m != null)
    {
      if (!d.s.b.d())
        break label53;
      i1 = R.drawable.menu_icon_preview_sticker_idle_promo;
      if (!d.s.b.d())
        break label60;
      i2 = R.drawable.menu_icon_preview_sticker_promo_pressed;
      localMenuItem = this.m;
      if (!paramBoolean)
        break label67;
    }
    while (true)
    {
      localMenuItem.setIcon(i2);
      return;
      label53: i1 = R.drawable.menu_icon_preview_sticker_idle;
      break;
      label60: i2 = R.drawable.menu_icon_preview_sticker_pressed;
      break label33;
      label67: i2 = i1;
    }
  }

  private void d(int paramInt)
  {
    this.u.update(paramInt);
    l();
  }

  private void e(int paramInt)
  {
    if (this.l != null)
      this.l.getIcon().mutate().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
  }

  private void p()
  {
    s();
    if (this.k.a())
      this.k.onHide();
    while (true)
    {
      d.s.b.a(false);
      return;
      n();
      this.k.onShow();
    }
  }

  private void q()
  {
    a(null);
  }

  private void r()
  {
    if (c.b.c != this.s)
    {
      e();
      return;
    }
    if (this.t == null)
    {
      this.s = null;
      this.a.d();
      return;
    }
    a(this.t);
  }

  private void s()
  {
    this.a.c();
    b(false);
  }

  private void t()
  {
    this.a.e();
  }

  private boolean u()
  {
    return this.u.hasData();
  }

  private void v()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.viber.voip.action.COLOR_CHANGED");
    localIntentFilter.addAction("com.viber.voip.action.TEXT_INPUT_FINISHED");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.w, localIntentFilter);
  }

  private void w()
  {
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.w);
  }

  protected Bitmap a(Context paramContext)
  {
    try
    {
      Bitmap localBitmap = j.a(paramContext, this.d, j.a, j.a, true);
      return localBitmap;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  protected Uri a(Uri paramUri)
  {
    File localFile = new File(paramUri.getPath());
    if (u());
    try
    {
      a(paramUri, localFile);
      return paramUri;
    }
    catch (IOException localIOException)
    {
    }
    return paramUri;
  }

  protected Uri a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = at.e(getActivity(), paramUri);
    Object localObject;
    if (str1 == null)
    {
      localObject = null;
      return localObject;
    }
    if ((paramBoolean2) && (this.u.hasData()));
    for (String str2 = str1 + this.u.hashCode(); ; str2 = str1)
    {
      int i1;
      if ((paramBoolean2) || (!paramBoolean1))
      {
        i1 = 1;
        if (i1 == 0)
          break label110;
      }
      File localFile1;
      label110: for (dv localdv = dv.a; ; localdv = dv.e)
      {
        localFile1 = localdv.b(getActivity(), str2, false);
        if (localFile1 != null)
          break label118;
        return null;
        i1 = 0;
        break;
      }
      label118: localObject = Uri.fromFile(localFile1);
      if (u());
      while (true)
      {
        try
        {
          File localFile2 = new File(((Uri)localObject).getPath());
          File localFile3 = at.b(localFile2.getParentFile(), localFile2.getName(), false);
          a(paramUri, localFile3);
          Uri localUri = Uri.fromFile(localFile3);
          localObject = localUri;
          if ((localObject == null) || (i1 == 0))
            break;
          o.a(((Uri)localObject).getPath());
          return localObject;
        }
        catch (IOException localIOException)
        {
          localObject = null;
          continue;
        }
        if (paramBoolean1)
          localObject = at.f(getContext(), paramUri);
        else if (!at.b(this.d, (Uri)localObject))
          localObject = null;
      }
    }
  }

  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.activity_customcam_preview_image_fragment, paramViewGroup, false);
    this.o = new c(getActivity(), localView, this.h, paramBundle)
    {
      boolean a()
      {
        return c.b.c == e.a(e.this);
      }
    };
    return localView;
  }

  public void a(int paramInt)
  {
    int i1 = 1;
    if ((2 == paramInt) || (i1 == paramInt));
    while (true)
    {
      c(i1);
      if (paramInt == 0)
        m();
      return;
      i1 = 0;
    }
  }

  protected void a(Bitmap paramBitmap)
  {
    this.j.setImageBitmap(paramBitmap);
  }

  public void a(Sticker paramSticker)
  {
    this.a.a(paramSticker);
  }

  protected void b()
  {
    super.b();
    this.o.d();
  }

  protected void b(int paramInt)
  {
    com.viber.voip.ui.doodle.scene.c localc = this.a.i();
    ViberApplication.getInstance().getEngine(false).getCdrController().handleReportMediaScreenSend(1, localc.h(), localc.c(), localc.a(), paramInt);
  }

  protected Animator[] c()
  {
    return a(super.c(), this.o.b());
  }

  protected Animator[] d()
  {
    return a(super.d(), this.o.c());
  }

  protected void e()
  {
    this.a.f();
    c(false);
    b(true);
    this.o.d();
  }

  protected int f()
  {
    return 1;
  }

  protected boolean g()
  {
    if (!this.u.isSaved())
      return false;
    return super.g();
  }

  protected boolean h()
  {
    return (!this.u.hasData()) && (super.h());
  }

  protected void i()
  {
    this.u.onSave();
  }

  protected com.viber.voip.ui.doodle.scene.c j()
  {
    return this.a.i();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 7)
      a(true);
  }

  public boolean onBackPressed()
  {
    if (this.k.a())
    {
      this.k.onHide();
      return true;
    }
    if (!h())
    {
      g.a().a(this).b(this);
      return true;
    }
    return super.onBackPressed();
  }

  public void onClick(View paramView)
  {
    if (paramView == this.p)
    {
      this.a.g();
      return;
    }
    super.onClick(paramView);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.k.d();
    this.q.a();
    this.o.f();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("com.viber.voip.scene_mode"))
        this.s = c.b.values()[paramBundle.getInt("com.viber.voip.scene_mode")];
      if (paramBundle.containsKey("com.viber.voip.scene_previous_mode"))
        this.t = c.b.values()[paramBundle.getInt("com.viber.voip.scene_previous_mode")];
      this.u = ((SceneState)paramBundle.getParcelable("com.viber.voip.scene_state_extra"));
    }
    if (this.u == null)
      this.u = new SceneState();
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_image_preview, paramMenu);
    this.l = paramMenu.findItem(R.id.text_mode);
    this.m = paramMenu.findItem(R.id.sticker_menu_item);
    this.n = paramMenu.findItem(R.id.doodle_menu_item);
    a(this.s);
    c(false);
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.k.e();
    this.a.b();
    w();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D247)) && (paramInt == -2))
      finish();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.k.b())
      return false;
    a(paramMenuItem);
    int i1 = paramMenuItem.getItemId();
    if (i1 == R.id.text_mode)
    {
      q();
      return true;
    }
    if (i1 == R.id.sticker_menu_item)
    {
      p();
      return true;
    }
    if (i1 == R.id.doodle_menu_item)
    {
      r();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onResume()
  {
    super.onResume();
    this.k.c();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.s != null)
      paramBundle.putInt("com.viber.voip.scene_mode", this.s.ordinal());
    if (this.t != null)
      paramBundle.putInt("com.viber.voip.scene_previous_mode", this.t.ordinal());
    paramBundle.putParcelable("com.viber.voip.scene_state_extra", this.u);
    if (this.a != null)
      this.a.a(paramBundle);
    this.o.a(paramBundle);
    paramBundle.putBoolean("com.viber.voip.is_editing_text", this.v);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.j = ((ImageView)paramView.findViewById(R.id.preview_image));
    this.k = new k(this, this);
    this.q = new m(paramView);
    this.p = a(paramView);
    this.p.setOnClickListener(this);
    this.r = paramView.findViewById(R.id.dimmed_overlay);
    this.a = new a((SceneView)this.j, this.q, new a.b()
    {
      public void a()
      {
        e.a(e.this, e.a(e.this));
        e.b(e.this, c.b.a);
      }

      public void a(int paramAnonymousInt)
      {
        e.a(e.this, paramAnonymousInt);
      }

      public void a(c.b paramAnonymousb)
      {
        if (c.b.c != paramAnonymousb)
          e.c(e.this).b();
        e.this.b(true, null);
      }

      public void a(TextInfo paramAnonymousTextInfo)
      {
        e.a(e.this, paramAnonymousTextInfo);
      }

      public void a(boolean paramAnonymousBoolean)
      {
        View localView;
        if (e.this.h.equals(DoodleActivity.a.a))
        {
          localView = e.b(e.this);
          if (paramAnonymousBoolean)
            break label36;
        }
        label36: for (boolean bool = true; ; bool = false)
        {
          dj.b(localView, bool);
          return;
        }
      }

      public void b()
      {
        e.a(e.this, e.a(e.this));
        e.b(e.this, c.b.b);
      }

      public void b(c.b paramAnonymousb)
      {
        if (paramAnonymousb != c.b.c)
        {
          e.this.a.a(false);
          e.c(e.this).a(new Runnable()
          {
            public void run()
            {
              e.this.a(false, null);
              e.this.a.a(true);
            }
          });
          return;
        }
        e.this.a(false, null);
      }

      public void c()
      {
        e.a(e.this, e.a(e.this));
        e.b(e.this, c.b.c);
      }

      public void d()
      {
        g.b().b(e.this);
      }
    }
    , this.o, paramBundle);
    d(this.a.h());
    if ((paramBundle != null) && (paramBundle.getBoolean("com.viber.voip.is_editing_text")));
    for (boolean bool = true; ; bool = false)
    {
      this.v = bool;
      if (this.v)
        a(false);
      v();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.e
 * JD-Core Version:    0.6.2
 */