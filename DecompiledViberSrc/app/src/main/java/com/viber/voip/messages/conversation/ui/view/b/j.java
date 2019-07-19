package com.viber.voip.messages.conversation.ui.view.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.slidingmenu.lib.SlidingMenu;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ConversationListView;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.banner.d.c;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.bb;
import com.viber.voip.messages.conversation.ui.bh;
import com.viber.voip.messages.conversation.ui.ci;
import com.viber.voip.messages.conversation.ui.presenter.GeneralConversationPresenter;
import com.viber.voip.messages.conversation.ui.view.ScreenshotConversationData;
import com.viber.voip.messages.conversation.ui.view.h;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.ui.af.a;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.t.a;
import com.viber.voip.ui.t.b.a;
import com.viber.voip.ui.t.c;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.ba;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import java.io.File;

public class j<P extends GeneralConversationPresenter> extends a<P>
  implements h, t.a
{
  private static final Logger a = ViberEnv.getLogger();
  private View b;
  private View g;
  private ProgressBar h;
  private com.viber.common.dialogs.m i;
  private final Runnable j = new c(this, null);
  private final Runnable k = new b(this, null);
  private final Handler l;
  private final com.viber.voip.messages.conversation.adapter.d m;
  private boolean n;
  private ImageView o;
  private MessageComposerView p;
  private ExpandablePanelLayout q;
  private TextView r;
  private View s;
  private ci t;
  private bh u;
  private SlidingMenu v;

  public j(P paramP, MessageComposerView paramMessageComposerView, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, Handler paramHandler, com.viber.voip.messages.conversation.adapter.d paramd)
  {
    super(paramP, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.l = paramHandler;
    this.m = paramd;
    this.p = paramMessageComposerView;
    l();
    m();
  }

  private void b(Bitmap paramBitmap, Uri paramUri)
  {
    if (paramBitmap != null)
    {
      this.o.setTag(paramUri);
      this.o.setBackgroundResource(0);
      return;
    }
    this.o.setTag(null);
  }

  private void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i1;
    Uri localUri;
    if (!dj.c(ViberApplication.getApplication()))
    {
      i1 = 1;
      if ((i1 == 0) || (TextUtils.isEmpty(paramString1)))
        break label91;
      localUri = Uri.parse(paramString1);
    }
    Bitmap localBitmap;
    while (true)
    {
      Object localObject = this.o.getTag();
      if ((localUri == null) || (!localUri.equals(localObject)))
      {
        localBitmap = com.viber.voip.backgrounds.b.a().a(localUri);
        if ((paramString1 == null) || (!paramString1.equals(paramString2)))
          break label122;
        a(localBitmap, localUri);
      }
      return;
      i1 = 0;
      break;
      label91: localUri = null;
      if (i1 == 0)
      {
        boolean bool = TextUtils.isEmpty(paramString2);
        localUri = null;
        if (!bool)
          localUri = Uri.parse(paramString2);
      }
    }
    label122: a(localBitmap, localUri, paramBoolean);
  }

  private void l()
  {
    this.g = this.mRootView.findViewById(R.id.new_message_bar);
    this.b = this.e.getStickyHeader().c;
    this.h = ((ProgressBar)this.mRootView.findViewById(R.id.loading_progress));
    this.o = ((ImageView)this.mRootView.findViewById(R.id.listBgImage));
    this.q = ((ExpandablePanelLayout)this.mRootView.findViewById(R.id.conversation_menu));
    this.r = ((TextView)this.mRootView.findViewById(R.id.is_typing_text));
    this.s = this.mRootView.findViewById(R.id.btn_jump_to_bottom);
    if (!this.f)
      this.v = ((SlidingMenu)this.c.findViewById(R.id.conversation_sliding_view));
  }

  private void m()
  {
    this.t = new bb(this.d);
    View localView = this.s;
    Handler localHandler = this.l;
    GeneralConversationPresenter localGeneralConversationPresenter = (GeneralConversationPresenter)this.mPresenter;
    localGeneralConversationPresenter.getClass();
    this.u = new bh(localView, localHandler, k.a(localGeneralConversationPresenter));
    this.g.setOnClickListener(new l(this));
    if ((!this.f) && (this.v != null))
    {
      this.v.a(this.p);
      this.v.a(this.q);
    }
    this.e.setDivider(null);
    this.e.setDividerHeight(0);
    this.e.setEnablSmoothOverscroll(true);
    this.e.a(this.u);
    this.e.a(this.u);
  }

  private Rect n()
  {
    Rect localRect = new Rect();
    this.c.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    return localRect;
  }

  private Pair<String, File> o()
  {
    String str = String.valueOf(System.currentTimeMillis());
    return new Pair(str, dv.h.a(this.mRootView.getContext(), str));
  }

  public void L_()
  {
    ((GeneralConversationPresenter)this.mPresenter).m();
  }

  public void a()
  {
    dj.c(this.g, 8);
    this.g.setTag(Integer.valueOf(8));
  }

  public void a(int paramInt)
  {
    if (this.d != null)
    {
      FragmentActivity localFragmentActivity = this.d.getActivity();
      if ((localFragmentActivity != null) && (this.g != null) && (r()) && (dj.c(localFragmentActivity)))
      {
        if ((3 != paramInt) && (2 != paramInt))
          break label67;
        dj.c(this.g, 4);
        dj.c(this.b, 4);
      }
    }
    label67: Object localObject;
    do
    {
      return;
      localObject = this.g.getTag();
    }
    while ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() != 0));
    dj.c(this.g, 0);
    dj.c(this.b, 0);
  }

  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e.a(paramInt, paramBoolean1, paramBoolean2);
  }

  public void a(long paramLong)
  {
    if (this.e.a(paramLong))
      this.u.a(true);
  }

  public void a(long paramLong1, String paramString, int paramInt, long paramLong2, boolean paramBoolean)
  {
    a(paramLong1, paramString, paramLong2);
    if (paramInt >= 0)
      this.e.a(paramInt, paramBoolean);
  }

  public void a(long paramLong1, String paramString, long paramLong2)
  {
    this.m.a(paramLong1, paramString, paramLong2);
  }

  public void a(Intent paramIntent, boolean paramBoolean)
  {
    if (paramIntent == null)
      return;
    com.viber.voip.messages.conversation.ui.view.d locald = com.viber.voip.messages.conversation.ui.view.d.a(paramIntent, paramBoolean);
    ((GeneralConversationPresenter)this.mPresenter).a(locald);
    this.m.a(locald.c());
  }

  public void a(Bitmap paramBitmap, Uri paramUri)
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramBitmap);
    localBitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    this.o.setScaleType(ImageView.ScaleType.FIT_XY);
    this.o.setImageDrawable(localBitmapDrawable);
    b(paramBitmap, paramUri);
  }

  public void a(Bitmap paramBitmap, Uri paramUri, boolean paramBoolean)
  {
    if (paramBoolean)
      dj.a(this.o, new BitmapDrawable(this.o.getResources(), paramBitmap), false);
    while (true)
    {
      this.o.setScaleType(ImageView.ScaleType.MATRIX);
      b(paramBitmap, paramUri);
      return;
      this.o.setImageBitmap(paramBitmap);
    }
  }

  @TargetApi(26)
  public void a(Handler paramHandler)
  {
    Rect localRect = n();
    Bitmap localBitmap = Bitmap.createBitmap(localRect.width(), localRect.height(), Bitmap.Config.ARGB_4444);
    if (ViberApplication.getInstance().isOnForeground())
    {
      PixelCopy.request(this.c.getWindow(), localRect, localBitmap, new m(this, localBitmap), paramHandler);
      return;
    }
    ((GeneralConversationPresenter)this.mPresenter).a(null, null);
  }

  public void a(View paramView, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    PopupMenu localPopupMenu = new PopupMenu(this.c, paramView);
    localPopupMenu.getMenuInflater().inflate(R.menu.context_menu_pa_conversation_action_sheet, localPopupMenu.getMenu());
    localPopupMenu.getMenu().findItem(R.id.public_account_show_pa_info).setVisible(e.d());
    localPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        int i = paramAnonymousMenuItem.getItemId();
        if (i == R.id.public_account_show_info)
          ((GeneralConversationPresenter)j.b(j.this)).h();
        while (true)
        {
          return true;
          if (i == R.id.public_account_show_pa_info)
            ((GeneralConversationPresenter)j.c(j.this)).k();
        }
      }
    });
    localPopupMenu.show();
  }

  public void a(ScreenshotConversationData paramScreenshotConversationData)
  {
    ViberActionRunner.ba.b(this.c, paramScreenshotConversationData);
  }

  public void a(t.b.a parama)
  {
    this.l.removeCallbacks(this.j);
    ProgressBar localProgressBar = this.h;
    if (parama == t.b.a.a);
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localProgressBar, bool);
      return;
    }
  }

  public void a(t.c paramc)
  {
    if (paramc == t.c.b)
    {
      this.n = false;
      this.i = null;
    }
    this.d.a(paramc);
  }

  public void a(t.c paramc, long paramLong)
  {
    Runnable localRunnable;
    if (paramc == t.c.a)
      localRunnable = this.j;
    while (true)
    {
      this.l.removeCallbacks(localRunnable);
      this.l.postDelayed(localRunnable, paramLong);
      return;
      localRunnable = this.k;
      this.n = true;
    }
  }

  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    dj.b(this.r, paramBoolean);
    if (paramCharSequence != null)
      this.r.setText(paramCharSequence.toString());
  }

  public void a(String paramString)
  {
    if (e(paramString))
      this.t.b();
  }

  public void a(String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = ViberActionRunner.aq.a(paramString1);
    ViberActionRunner.aq.a(this.c, paramString2, paramInt, localIntent);
  }

  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    b(paramString1, paramString2, paramBoolean);
  }

  public void a(boolean paramBoolean)
  {
    this.e.a(paramBoolean);
  }

  public void b()
  {
    this.e.smoothScrollBy(1, 0);
  }

  public void b(int paramInt)
  {
    b(this.c.getResources().getString(paramInt));
  }

  public void b(t.b.a parama)
  {
    this.l.removeCallbacks(this.k);
    boolean bool;
    if (parama == t.b.a.a)
    {
      bool = true;
      this.n = bool;
      if (parama != t.b.a.a)
        break label88;
      if ((this.i == null) || (!this.i.isVisible()))
        this.i = ad.b().b(true).a(false).a(new a(this)).b(this.d);
    }
    label88: 
    while (this.i == null)
    {
      return;
      bool = false;
      break;
    }
    this.i.dismiss();
    this.i = null;
  }

  public void b(String paramString)
  {
    this.t.c();
    e(paramString);
  }

  public void b(boolean paramBoolean)
  {
    if ((!this.e.e()) && (paramBoolean))
      a(false);
  }

  public void c()
  {
    this.t.a();
  }

  public void c(String paramString)
  {
    this.d.b(paramString);
  }

  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.getWindow().setFlags(8192, 8192);
      return;
    }
    this.c.getWindow().clearFlags(8192);
  }

  public void d()
  {
    int i1 = this.e.getFirstVisiblePosition();
    ConversationListView localConversationListView = this.e;
    if (i1 > 1)
      i1--;
    localConversationListView.a(i1, false, false);
  }

  public void d(String paramString)
  {
    Intent localIntent = ViberActionRunner.aq.a(paramString);
    this.c.startActivity(localIntent);
  }

  public void d(boolean paramBoolean)
  {
    ((GeneralConversationPresenter)this.mPresenter).d(paramBoolean);
  }

  public void e()
  {
    this.u.a();
  }

  public boolean e(String paramString)
  {
    return dj.b((AppCompatActivity)this.c, paramString);
  }

  public void f()
  {
    ViberApplication.getInstance().showToast(this.d.getString(R.string.pg_follow_error));
  }

  public void g()
  {
    this.d.W();
  }

  @Deprecated
  public void h()
  {
    Rect localRect = n();
    View localView = this.c.getWindow().getDecorView();
    localView.setDrawingCacheEnabled(true);
    localView.setDrawingCacheQuality(0);
    Bitmap localBitmap = Bitmap.createBitmap(localView.getDrawingCache(), localRect.left, localRect.top, localRect.right, localRect.bottom - localRect.top);
    localView.setDrawingCacheEnabled(false);
    ((GeneralConversationPresenter)this.mPresenter).a(o(), localBitmap);
  }

  public void i()
  {
    com.viber.voip.ui.dialogs.d.m().d();
  }

  public void j()
  {
    com.viber.voip.ui.dialogs.d.q().d();
  }

  public void k()
  {
    if (!this.e.a(true))
    {
      dj.c(this.g, 0);
      this.g.setTag(Integer.valueOf(0));
      a(this.q.getPanelState());
    }
  }

  public boolean onBackPressed()
  {
    return ((GeneralConversationPresenter)this.mPresenter).f();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    ((GeneralConversationPresenter)this.mPresenter).onViewConfigurationChanged();
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.t.d();
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    ((GeneralConversationPresenter)this.mPresenter).b(paramBoolean);
  }

  public void onPause()
  {
    if (this.n)
      this.l.removeCallbacks(this.k);
  }

  public void onRemoteBannerVisibilityChange(boolean paramBoolean, c paramc, com.viber.voip.banner.view.b paramb)
  {
    bh localbh = this.u;
    if (paramBoolean);
    for (View localView = (View)paramb.getParent(); ; localView = null)
    {
      localbh.a(localView);
      return;
    }
  }

  public void onResume()
  {
    if (this.n)
      b(t.b.a.a);
  }

  public void s()
  {
    ((GeneralConversationPresenter)this.mPresenter).e();
  }

  private static class a extends m.a
  {
    private final t.a a;

    public a(t.a parama)
    {
      this.a = parama;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramInt == -1000)
        this.a.a(t.c.b);
    }
  }

  private static class b extends com.viber.voip.d.b<j>
  {
    private b(j paramj)
    {
      super();
    }

    public void a(j paramj)
    {
      paramj.b(t.b.a.a);
    }
  }

  private static class c extends com.viber.voip.d.b<j>
  {
    private c(j paramj)
    {
      super();
    }

    public void a(j paramj)
    {
      dj.c(j.a(paramj), 0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.j
 * JD-Core Version:    0.6.2
 */