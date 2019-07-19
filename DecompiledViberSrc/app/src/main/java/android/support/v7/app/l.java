package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.h.a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class l extends a
  implements ActionBarOverlayLayout.ActionBarVisibilityCallback
{
  private static final Interpolator t;
  private static final Interpolator u;
  private boolean A;
  private boolean B;
  private ArrayList<a.b> C = new ArrayList();
  private boolean D;
  private int E = 0;
  private boolean F;
  private boolean G = true;
  private boolean H;
  Context a;
  ActionBarOverlayLayout b;
  ActionBarContainer c;
  DecorToolbar d;
  ActionBarContextView e;
  View f;
  ScrollingTabContainerView g;
  a h;
  b i;
  b.a j;
  boolean k = true;
  boolean l;
  boolean m;
  android.support.v7.view.h n;
  boolean o;
  final ViewPropertyAnimatorListener p = new ViewPropertyAnimatorListenerAdapter()
  {
    public void onAnimationEnd(View paramAnonymousView)
    {
      if ((l.this.k) && (l.this.f != null))
      {
        l.this.f.setTranslationY(0.0F);
        l.this.c.setTranslationY(0.0F);
      }
      l.this.c.setVisibility(8);
      l.this.c.setTransitioning(false);
      l.this.n = null;
      l.this.p();
      if (l.this.b != null)
        ViewCompat.requestApplyInsets(l.this.b);
    }
  };
  final ViewPropertyAnimatorListener q = new ViewPropertyAnimatorListenerAdapter()
  {
    public void onAnimationEnd(View paramAnonymousView)
    {
      l.this.n = null;
      l.this.c.requestLayout();
    }
  };
  final ViewPropertyAnimatorUpdateListener r = new ViewPropertyAnimatorUpdateListener()
  {
    public void onAnimationUpdate(View paramAnonymousView)
    {
      ((View)l.this.c.getParent()).invalidate();
    }
  };
  private Context v;
  private Activity w;
  private Dialog x;
  private ArrayList<Object> y = new ArrayList();
  private int z = -1;

  static
  {
    if (!l.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      s = bool;
      t = new AccelerateInterpolator();
      u = new DecelerateInterpolator();
      return;
    }
  }

  public l(Activity paramActivity, boolean paramBoolean)
  {
    this.w = paramActivity;
    View localView = paramActivity.getWindow().getDecorView();
    b(localView);
    if (!paramBoolean)
      this.f = localView.findViewById(16908290);
  }

  public l(Dialog paramDialog)
  {
    this.x = paramDialog;
    b(paramDialog.getWindow().getDecorView());
  }

  static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3);
    while ((!paramBoolean1) && (!paramBoolean2))
      return true;
    return false;
  }

  private void b(View paramView)
  {
    this.b = ((ActionBarOverlayLayout)paramView.findViewById(R.id.decor_content_parent));
    if (this.b != null)
      this.b.setActionBarVisibilityCallback(this);
    this.d = c(paramView.findViewById(R.id.action_bar));
    this.e = ((ActionBarContextView)paramView.findViewById(R.id.action_context_bar));
    this.c = ((ActionBarContainer)paramView.findViewById(R.id.action_bar_container));
    if ((this.d == null) || (this.e == null) || (this.c == null))
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
    this.a = this.d.getContext();
    int i1;
    android.support.v7.view.a locala;
    if ((0x4 & this.d.getDisplayOptions()) != 0)
    {
      i1 = 1;
      if (i1 != 0)
        this.A = true;
      locala = android.support.v7.view.a.a(this.a);
      if ((!locala.f()) && (i1 == 0))
        break label273;
    }
    label273: for (boolean bool = true; ; bool = false)
    {
      e(bool);
      m(locala.d());
      TypedArray localTypedArray = this.a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      if (localTypedArray.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false))
        f(true);
      int i2 = localTypedArray.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
      if (i2 != 0)
        a(i2);
      localTypedArray.recycle();
      return;
      i1 = 0;
      break;
    }
  }

  private DecorToolbar c(View paramView)
  {
    if ((paramView instanceof DecorToolbar))
      return (DecorToolbar)paramView;
    if ((paramView instanceof Toolbar))
      return ((Toolbar)paramView).getWrapper();
    StringBuilder localStringBuilder = new StringBuilder().append("Can't make a decor toolbar out of ");
    if (paramView != null);
    for (String str = paramView.getClass().getSimpleName(); ; str = "null")
      throw new IllegalStateException(str);
  }

  private void m(boolean paramBoolean)
  {
    boolean bool1 = true;
    this.D = paramBoolean;
    boolean bool2;
    label45: label78: boolean bool3;
    label98: ActionBarOverlayLayout localActionBarOverlayLayout;
    if (!this.D)
    {
      this.d.setEmbeddedTabView(null);
      this.c.setTabContainer(this.g);
      if (q() != 2)
        break label155;
      bool2 = bool1;
      if (this.g != null)
      {
        if (!bool2)
          break label160;
        this.g.setVisibility(0);
        if (this.b != null)
          ViewCompat.requestApplyInsets(this.b);
      }
      DecorToolbar localDecorToolbar = this.d;
      if ((this.D) || (!bool2))
        break label172;
      bool3 = bool1;
      localDecorToolbar.setCollapsible(bool3);
      localActionBarOverlayLayout = this.b;
      if ((this.D) || (!bool2))
        break label178;
    }
    while (true)
    {
      localActionBarOverlayLayout.setHasNonEmbeddedTabs(bool1);
      return;
      this.c.setTabContainer(null);
      this.d.setEmbeddedTabView(this.g);
      break;
      label155: bool2 = false;
      break label45;
      label160: this.g.setVisibility(8);
      break label78;
      label172: bool3 = false;
      break label98;
      label178: bool1 = false;
    }
  }

  private void n(boolean paramBoolean)
  {
    if (a(this.l, this.m, this.F))
      if (!this.G)
      {
        this.G = true;
        j(paramBoolean);
      }
    while (!this.G)
      return;
    this.G = false;
    k(paramBoolean);
  }

  private void r()
  {
    if (!this.F)
    {
      this.F = true;
      if (this.b != null)
        this.b.setShowingForActionMode(true);
      n(false);
    }
  }

  private void s()
  {
    if (this.F)
    {
      this.F = false;
      if (this.b != null)
        this.b.setShowingForActionMode(false);
      n(false);
    }
  }

  private boolean t()
  {
    return ViewCompat.isLaidOut(this.c);
  }

  public b a(b.a parama)
  {
    if (this.h != null)
      this.h.c();
    this.b.setHideOnContentScrollEnabled(false);
    this.e.killMode();
    a locala = new a(this.e.getContext(), parama);
    if (locala.e())
    {
      this.h = locala;
      locala.d();
      this.e.initForMode(locala);
      l(true);
      this.e.sendAccessibilityEvent(32);
      return locala;
    }
    return null;
  }

  public View a()
  {
    return this.d.getCustomView();
  }

  public void a(float paramFloat)
  {
    ViewCompat.setElevation(this.c, paramFloat);
  }

  public void a(int paramInt)
  {
    this.d.setIcon(paramInt);
  }

  public void a(int paramInt1, int paramInt2)
  {
    int i1 = this.d.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0)
      this.A = true;
    this.d.setDisplayOptions(paramInt1 & paramInt2 | i1 & (paramInt2 ^ 0xFFFFFFFF));
  }

  public void a(Configuration paramConfiguration)
  {
    m(android.support.v7.view.a.a(this.a).d());
  }

  public void a(Drawable paramDrawable)
  {
    this.c.setPrimaryBackground(paramDrawable);
  }

  public void a(View paramView)
  {
    this.d.setCustomView(paramView);
  }

  public void a(CharSequence paramCharSequence)
  {
    this.d.setTitle(paramCharSequence);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 2; ; i1 = 0)
    {
      a(i1, 2);
      return;
    }
  }

  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.h == null);
    Menu localMenu;
    do
    {
      return false;
      localMenu = this.h.b();
    }
    while (localMenu == null);
    int i1;
    if (paramKeyEvent != null)
    {
      i1 = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i1).getKeyboardType() == 1)
        break label70;
    }
    label70: for (boolean bool = true; ; bool = false)
    {
      localMenu.setQwertyMode(bool);
      return localMenu.performShortcut(paramInt, paramKeyEvent, 0);
      i1 = -1;
      break;
    }
  }

  public CharSequence b()
  {
    return this.d.getTitle();
  }

  public void b(int paramInt)
  {
    a(this.a.getString(paramInt));
  }

  public void b(CharSequence paramCharSequence)
  {
    this.d.setSubtitle(paramCharSequence);
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 4; ; i1 = 0)
    {
      a(i1, 4);
      return;
    }
  }

  public CharSequence c()
  {
    return this.d.getSubtitle();
  }

  public void c(int paramInt)
  {
    b(this.a.getString(paramInt));
  }

  public void c(CharSequence paramCharSequence)
  {
    this.d.setWindowTitle(paramCharSequence);
  }

  public void c(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 8; ; i1 = 0)
    {
      a(i1, 8);
      return;
    }
  }

  public int d()
  {
    return this.d.getDisplayOptions();
  }

  public void d(int paramInt)
  {
    this.d.setNavigationIcon(paramInt);
  }

  public void d(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 16; ; i1 = 0)
    {
      a(i1, 16);
      return;
    }
  }

  public int e()
  {
    return this.c.getHeight();
  }

  public void e(int paramInt)
  {
    this.d.setNavigationContentDescription(paramInt);
  }

  public void e(boolean paramBoolean)
  {
    this.d.setHomeButtonEnabled(paramBoolean);
  }

  public void enableContentAnimations(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public void f()
  {
    if (this.l)
    {
      this.l = false;
      n(false);
    }
  }

  public void f(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.b.isInOverlayMode()))
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    this.o = paramBoolean;
    this.b.setHideOnContentScrollEnabled(paramBoolean);
  }

  public void g()
  {
    if (!this.l)
    {
      this.l = true;
      n(false);
    }
  }

  public void g(boolean paramBoolean)
  {
    if (!this.A)
      b(paramBoolean);
  }

  public void h(boolean paramBoolean)
  {
    this.H = paramBoolean;
    if ((!paramBoolean) && (this.n != null))
      this.n.c();
  }

  public boolean h()
  {
    int i1 = e();
    return (this.G) && ((i1 == 0) || (j() < i1));
  }

  public void hideForSystem()
  {
    if (!this.m)
    {
      this.m = true;
      n(true);
    }
  }

  public Context i()
  {
    int i1;
    if (this.v == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      i1 = localTypedValue.resourceId;
      if (i1 == 0)
        break label61;
    }
    label61: for (this.v = new ContextThemeWrapper(this.a, i1); ; this.v = this.a)
      return this.v;
  }

  public void i(boolean paramBoolean)
  {
    if (paramBoolean == this.B);
    while (true)
    {
      return;
      this.B = paramBoolean;
      int i1 = this.C.size();
      for (int i2 = 0; i2 < i1; i2++)
        ((a.b)this.C.get(i2)).a(paramBoolean);
    }
  }

  public int j()
  {
    return this.b.getActionBarHideOffset();
  }

  public void j(boolean paramBoolean)
  {
    if (this.n != null)
      this.n.c();
    this.c.setVisibility(0);
    if ((this.E == 0) && ((this.H) || (paramBoolean)))
    {
      this.c.setTranslationY(0.0F);
      float f1 = -this.c.getHeight();
      if (paramBoolean)
      {
        int[] arrayOfInt = { 0, 0 };
        this.c.getLocationInWindow(arrayOfInt);
        f1 -= arrayOfInt[1];
      }
      this.c.setTranslationY(f1);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.c).translationY(0.0F);
      localViewPropertyAnimatorCompat.setUpdateListener(this.r);
      localh.a(localViewPropertyAnimatorCompat);
      if ((this.k) && (this.f != null))
      {
        this.f.setTranslationY(f1);
        localh.a(ViewCompat.animate(this.f).translationY(0.0F));
      }
      localh.a(u);
      localh.a(250L);
      localh.a(this.q);
      this.n = localh;
      localh.a();
    }
    while (true)
    {
      if (this.b != null)
        ViewCompat.requestApplyInsets(this.b);
      return;
      this.c.setAlpha(1.0F);
      this.c.setTranslationY(0.0F);
      if ((this.k) && (this.f != null))
        this.f.setTranslationY(0.0F);
      this.q.onAnimationEnd(null);
    }
  }

  public void k(boolean paramBoolean)
  {
    if (this.n != null)
      this.n.c();
    if ((this.E == 0) && ((this.H) || (paramBoolean)))
    {
      this.c.setAlpha(1.0F);
      this.c.setTransitioning(true);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      float f1 = -this.c.getHeight();
      if (paramBoolean)
      {
        int[] arrayOfInt = { 0, 0 };
        this.c.getLocationInWindow(arrayOfInt);
        f1 -= arrayOfInt[1];
      }
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.c).translationY(f1);
      localViewPropertyAnimatorCompat.setUpdateListener(this.r);
      localh.a(localViewPropertyAnimatorCompat);
      if ((this.k) && (this.f != null))
        localh.a(ViewCompat.animate(this.f).translationY(f1));
      localh.a(t);
      localh.a(250L);
      localh.a(this.p);
      this.n = localh;
      localh.a();
      return;
    }
    this.p.onAnimationEnd(null);
  }

  public void l(boolean paramBoolean)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2;
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1;
    if (paramBoolean)
    {
      r();
      if (!t())
        break label105;
      if (!paramBoolean)
        break label75;
      localViewPropertyAnimatorCompat2 = this.d.setupAnimatorToVisibility(4, 100L);
      localViewPropertyAnimatorCompat1 = this.e.setupAnimatorToVisibility(0, 200L);
    }
    while (true)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localViewPropertyAnimatorCompat2, localViewPropertyAnimatorCompat1);
      localh.a();
      return;
      s();
      break;
      label75: localViewPropertyAnimatorCompat1 = this.d.setupAnimatorToVisibility(0, 200L);
      localViewPropertyAnimatorCompat2 = this.e.setupAnimatorToVisibility(8, 100L);
    }
    label105: if (paramBoolean)
    {
      this.d.setVisibility(4);
      this.e.setVisibility(0);
      return;
    }
    this.d.setVisibility(0);
    this.e.setVisibility(8);
  }

  public boolean n()
  {
    if ((this.d != null) && (this.d.hasExpandedActionView()))
    {
      this.d.collapseActionView();
      return true;
    }
    return false;
  }

  public void onContentScrollStarted()
  {
    if (this.n != null)
    {
      this.n.c();
      this.n = null;
    }
  }

  public void onContentScrollStopped()
  {
  }

  public void onWindowVisibilityChanged(int paramInt)
  {
    this.E = paramInt;
  }

  void p()
  {
    if (this.j != null)
    {
      this.j.a(this.i);
      this.i = null;
      this.j = null;
    }
  }

  public int q()
  {
    return this.d.getNavigationMode();
  }

  public void showForSystem()
  {
    if (this.m)
    {
      this.m = false;
      n(true);
    }
  }

  public class a extends b
    implements h.a
  {
    private final Context b;
    private final android.support.v7.view.menu.h c;
    private b.a d;
    private WeakReference<View> e;

    public a(Context parama, b.a arg3)
    {
      this.b = parama;
      Object localObject;
      this.d = localObject;
      this.c = new android.support.v7.view.menu.h(parama).a(1);
      this.c.a(this);
    }

    public MenuInflater a()
    {
      return new g(this.b);
    }

    public void a(int paramInt)
    {
      b(l.this.a.getResources().getString(paramInt));
    }

    public void a(View paramView)
    {
      l.this.e.setCustomView(paramView);
      this.e = new WeakReference(paramView);
    }

    public void a(CharSequence paramCharSequence)
    {
      l.this.e.setSubtitle(paramCharSequence);
    }

    public void a(boolean paramBoolean)
    {
      super.a(paramBoolean);
      l.this.e.setTitleOptional(paramBoolean);
    }

    public Menu b()
    {
      return this.c;
    }

    public void b(int paramInt)
    {
      a(l.this.a.getResources().getString(paramInt));
    }

    public void b(CharSequence paramCharSequence)
    {
      l.this.e.setTitle(paramCharSequence);
    }

    public void c()
    {
      if (l.this.h != this)
        return;
      if (!l.a(l.this.l, l.this.m, false))
      {
        l.this.i = this;
        l.this.j = this.d;
      }
      while (true)
      {
        this.d = null;
        l.this.l(false);
        l.this.e.closeMode();
        l.this.d.getViewGroup().sendAccessibilityEvent(32);
        l.this.b.setHideOnContentScrollEnabled(l.this.o);
        l.this.h = null;
        return;
        this.d.a(this);
      }
    }

    public void d()
    {
      if (l.this.h != this)
        return;
      this.c.h();
      try
      {
        this.d.b(this, this.c);
        return;
      }
      finally
      {
        this.c.i();
      }
    }

    public boolean e()
    {
      this.c.h();
      try
      {
        boolean bool = this.d.a(this, this.c);
        return bool;
      }
      finally
      {
        this.c.i();
      }
    }

    public CharSequence f()
    {
      return l.this.e.getTitle();
    }

    public CharSequence g()
    {
      return l.this.e.getSubtitle();
    }

    public boolean h()
    {
      return l.this.e.isTitleOptional();
    }

    public View i()
    {
      if (this.e != null)
        return (View)this.e.get();
      return null;
    }

    public boolean onMenuItemSelected(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      if (this.d != null)
        return this.d.a(this, paramMenuItem);
      return false;
    }

    public void onMenuModeChange(android.support.v7.view.menu.h paramh)
    {
      if (this.d == null)
        return;
      d();
      l.this.e.showOverflowMenu();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.l
 * JD-Core Version:    0.6.2
 */