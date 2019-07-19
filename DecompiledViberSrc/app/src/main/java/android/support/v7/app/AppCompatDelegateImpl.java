package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.app.NavUtils;
import android.support.v4.view.KeyEventDispatcher;
import android.support.v4.view.KeyEventDispatcher.Component;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.color;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.b;
import android.support.v7.view.f.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.p;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.OnAttachListener;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.reflect.Constructor;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImpl extends e
  implements h.a, LayoutInflater.Factory2
{
  private static final boolean u;
  private static final int[] v;
  private static boolean w;
  private g A;
  private boolean B = true;
  private boolean C;
  private ViewGroup D;
  private TextView E;
  private View F;
  private boolean G;
  private boolean H;
  private boolean I;
  private PanelFeatureState[] J;
  private PanelFeatureState K;
  private boolean L;
  private int M = -100;
  private boolean N;
  private e O;
  private final Runnable P = new Runnable()
  {
    public void run()
    {
      if ((0x1 & AppCompatDelegateImpl.this.t) != 0)
        AppCompatDelegateImpl.this.g(0);
      if ((0x1000 & AppCompatDelegateImpl.this.t) != 0)
        AppCompatDelegateImpl.this.g(108);
      AppCompatDelegateImpl.this.s = false;
      AppCompatDelegateImpl.this.t = 0;
    }
  };
  private boolean Q;
  private Rect R;
  private Rect S;
  private AppCompatViewInflater T;
  final Context a;
  final Window b;
  final Window.Callback c;
  final Window.Callback d;
  final d e;
  a f;
  MenuInflater g;
  b h;
  ActionBarContextView i;
  PopupWindow j;
  Runnable k;
  ViewPropertyAnimatorCompat l = null;
  boolean m;
  boolean n;
  boolean o;
  boolean p;
  boolean q;
  boolean r;
  boolean s;
  int t;
  private CharSequence x;
  private DecorContentParent y;
  private b z;

  static
  {
    if (Build.VERSION.SDK_INT < 21);
    for (boolean bool = true; ; bool = false)
    {
      u = bool;
      v = new int[] { 16842836 };
      if ((u) && (!w))
      {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          private boolean a(Throwable paramAnonymousThrowable)
          {
            boolean bool1 = paramAnonymousThrowable instanceof Resources.NotFoundException;
            boolean bool2 = false;
            if (bool1)
            {
              String str = paramAnonymousThrowable.getMessage();
              bool2 = false;
              if (str != null)
                if (!str.contains("drawable"))
                {
                  boolean bool3 = str.contains("Drawable");
                  bool2 = false;
                  if (!bool3);
                }
                else
                {
                  bool2 = true;
                }
            }
            return bool2;
          }

          public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            if (a(paramAnonymousThrowable))
            {
              Resources.NotFoundException localNotFoundException = new Resources.NotFoundException(paramAnonymousThrowable.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
              localNotFoundException.initCause(paramAnonymousThrowable.getCause());
              localNotFoundException.setStackTrace(paramAnonymousThrowable.getStackTrace());
              this.a.uncaughtException(paramAnonymousThread, localNotFoundException);
              return;
            }
            this.a.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          }
        });
        w = true;
      }
      return;
    }
  }

  AppCompatDelegateImpl(Context paramContext, Window paramWindow, d paramd)
  {
    this.a = paramContext;
    this.b = paramWindow;
    this.e = paramd;
    this.c = this.b.getCallback();
    if ((this.c instanceof d))
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    this.d = new d(this.c);
    this.b.setCallback(this.d);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, null, v);
    Drawable localDrawable = localTintTypedArray.getDrawableIfKnown(0);
    if (localDrawable != null)
      this.b.setBackgroundDrawable(localDrawable);
    localTintTypedArray.recycle();
  }

  private void A()
  {
    if (this.O == null)
      this.O = new e(k.a(this.a));
  }

  private boolean B()
  {
    if ((this.N) && ((this.a instanceof Activity)))
    {
      PackageManager localPackageManager = this.a.getPackageManager();
      try
      {
        int i1 = localPackageManager.getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0).configChanges;
        return (i1 & 0x200) == 0;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", localNameNotFoundException);
        return true;
      }
    }
    return false;
  }

  private void a(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int i1 = -1;
    if ((paramPanelFeatureState.o) || (this.r));
    label88: label94: WindowManager localWindowManager;
    do
    {
      do
      {
        while (true)
        {
          return;
          if (paramPanelFeatureState.a == 0)
            if ((0xF & this.a.getResources().getConfiguration().screenLayout) != 4)
              break label88;
          for (int i3 = 1; i3 == 0; i3 = 0)
          {
            Window.Callback localCallback = m();
            if ((localCallback == null) || (localCallback.onMenuOpened(paramPanelFeatureState.a, paramPanelFeatureState.j)))
              break label94;
            a(paramPanelFeatureState, true);
            return;
          }
        }
        localWindowManager = (WindowManager)this.a.getSystemService("window");
      }
      while ((localWindowManager == null) || (!b(paramPanelFeatureState, paramKeyEvent)));
      if ((paramPanelFeatureState.g != null) && (!paramPanelFeatureState.q))
        break label381;
      if (paramPanelFeatureState.g != null)
        break;
    }
    while ((!a(paramPanelFeatureState)) || (paramPanelFeatureState.g == null));
    label159: ViewGroup.LayoutParams localLayoutParams1;
    if ((c(paramPanelFeatureState)) && (paramPanelFeatureState.a()))
    {
      localLayoutParams1 = paramPanelFeatureState.h.getLayoutParams();
      if (localLayoutParams1 != null)
        break label417;
    }
    label411: label417: for (ViewGroup.LayoutParams localLayoutParams2 = new ViewGroup.LayoutParams(-2, -2); ; localLayoutParams2 = localLayoutParams1)
    {
      int i2 = paramPanelFeatureState.b;
      paramPanelFeatureState.g.setBackgroundResource(i2);
      ViewParent localViewParent = paramPanelFeatureState.h.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
        ((ViewGroup)localViewParent).removeView(paramPanelFeatureState.h);
      paramPanelFeatureState.g.addView(paramPanelFeatureState.h, localLayoutParams2);
      if (!paramPanelFeatureState.h.hasFocus())
        paramPanelFeatureState.h.requestFocus();
      for (i1 = -2; ; i1 = -2)
      {
        label381: ViewGroup.LayoutParams localLayoutParams3;
        do
        {
          paramPanelFeatureState.n = false;
          WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(i1, -2, paramPanelFeatureState.d, paramPanelFeatureState.e, 1002, 8519680, -3);
          localLayoutParams.gravity = paramPanelFeatureState.c;
          localLayoutParams.windowAnimations = paramPanelFeatureState.f;
          localWindowManager.addView(paramPanelFeatureState.g, localLayoutParams);
          paramPanelFeatureState.o = true;
          return;
          if ((!paramPanelFeatureState.q) || (paramPanelFeatureState.g.getChildCount() <= 0))
            break label159;
          paramPanelFeatureState.g.removeAllViews();
          break label159;
          break;
          if (paramPanelFeatureState.i == null)
            break label411;
          localLayoutParams3 = paramPanelFeatureState.i.getLayoutParams();
        }
        while ((localLayoutParams3 != null) && (localLayoutParams3.width == i1));
      }
    }
  }

  private void a(android.support.v7.view.menu.h paramh, boolean paramBoolean)
  {
    if ((this.y != null) && (this.y.canShowOverflowMenu()) && ((!ViewConfiguration.get(this.a).hasPermanentMenuKey()) || (this.y.isOverflowMenuShowPending())))
    {
      Window.Callback localCallback = m();
      if ((!this.y.isOverflowMenuShowing()) || (!paramBoolean))
        if ((localCallback != null) && (!this.r))
        {
          if ((this.s) && ((0x1 & this.t) != 0))
          {
            this.b.getDecorView().removeCallbacks(this.P);
            this.P.run();
          }
          PanelFeatureState localPanelFeatureState2 = a(0, true);
          if ((localPanelFeatureState2.j != null) && (!localPanelFeatureState2.r) && (localCallback.onPreparePanel(0, localPanelFeatureState2.i, localPanelFeatureState2.j)))
          {
            localCallback.onMenuOpened(108, localPanelFeatureState2.j);
            this.y.showOverflowMenu();
          }
        }
      do
      {
        return;
        this.y.hideOverflowMenu();
      }
      while (this.r);
      localCallback.onPanelClosed(108, a(0, true).j);
      return;
    }
    PanelFeatureState localPanelFeatureState1 = a(0, true);
    localPanelFeatureState1.q = true;
    a(localPanelFeatureState1, false);
    a(localPanelFeatureState1, null);
  }

  private boolean a(PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.a(n());
    paramPanelFeatureState.g = new f(paramPanelFeatureState.l);
    paramPanelFeatureState.c = 81;
    return true;
  }

  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool1 = paramKeyEvent.isSystem();
    boolean bool2 = false;
    if (bool1);
    do
    {
      return bool2;
      if (!paramPanelFeatureState.m)
      {
        boolean bool3 = b(paramPanelFeatureState, paramKeyEvent);
        bool2 = false;
        if (!bool3);
      }
      else
      {
        android.support.v7.view.menu.h localh = paramPanelFeatureState.j;
        bool2 = false;
        if (localh != null)
          bool2 = paramPanelFeatureState.j.performShortcut(paramInt1, paramKeyEvent, paramInt2);
      }
    }
    while ((!bool2) || ((paramInt2 & 0x1) != 0) || (this.y != null));
    a(paramPanelFeatureState, true);
    return bool2;
  }

  private boolean a(ViewParent paramViewParent)
  {
    if (paramViewParent == null)
      return false;
    View localView = this.b.getDecorView();
    for (ViewParent localViewParent = paramViewParent; ; localViewParent = localViewParent.getParent())
    {
      if (localViewParent == null)
        return true;
      if ((localViewParent == localView) || (!(localViewParent instanceof View)) || (ViewCompat.isAttachedToWindow((View)localViewParent)))
        return false;
    }
  }

  private boolean b(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.a;
    TypedValue localTypedValue;
    Resources.Theme localTheme1;
    Resources.Theme localTheme2;
    Object localObject;
    if (((paramPanelFeatureState.a == 0) || (paramPanelFeatureState.a == 108)) && (this.y != null))
    {
      localTypedValue = new TypedValue();
      localTheme1 = localContext.getTheme();
      localTheme1.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0)
      {
        localTheme2 = localContext.getResources().newTheme();
        localTheme2.setTo(localTheme1);
        localTheme2.applyStyle(localTypedValue.resourceId, true);
        localTheme2.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        if (localTypedValue.resourceId != 0)
        {
          if (localTheme2 == null)
          {
            localTheme2 = localContext.getResources().newTheme();
            localTheme2.setTo(localTheme1);
          }
          localTheme2.applyStyle(localTypedValue.resourceId, true);
        }
        Resources.Theme localTheme3 = localTheme2;
        if (localTheme3 == null)
          break label207;
        localObject = new android.support.v7.view.d(localContext, 0);
        ((Context)localObject).getTheme().setTo(localTheme3);
      }
    }
    while (true)
    {
      android.support.v7.view.menu.h localh = new android.support.v7.view.menu.h((Context)localObject);
      localh.a(this);
      paramPanelFeatureState.a(localh);
      return true;
      localTheme1.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      localTheme2 = null;
      break;
      label207: localObject = localContext;
    }
  }

  private boolean b(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (this.r)
      return false;
    if (paramPanelFeatureState.m)
      return true;
    if ((this.K != null) && (this.K != paramPanelFeatureState))
      a(this.K, false);
    Window.Callback localCallback = m();
    if (localCallback != null)
      paramPanelFeatureState.i = localCallback.onCreatePanelView(paramPanelFeatureState.a);
    if ((paramPanelFeatureState.a == 0) || (paramPanelFeatureState.a == 108));
    for (int i1 = 1; ; i1 = 0)
    {
      if ((i1 != 0) && (this.y != null))
        this.y.setMenuPrepared();
      if ((paramPanelFeatureState.i != null) || ((i1 != 0) && ((l() instanceof i))))
        break label411;
      if ((paramPanelFeatureState.j != null) && (!paramPanelFeatureState.r))
        break label279;
      if ((paramPanelFeatureState.j == null) && ((!b(paramPanelFeatureState)) || (paramPanelFeatureState.j == null)))
        break;
      if ((i1 != 0) && (this.y != null))
      {
        if (this.z == null)
          this.z = new b();
        this.y.setMenu(paramPanelFeatureState.j, this.z);
      }
      paramPanelFeatureState.j.h();
      if (localCallback.onCreatePanelMenu(paramPanelFeatureState.a, paramPanelFeatureState.j))
        break label274;
      paramPanelFeatureState.a(null);
      if ((i1 == 0) || (this.y == null))
        break;
      this.y.setMenu(null, this.z);
      return false;
    }
    label274: paramPanelFeatureState.r = false;
    label279: paramPanelFeatureState.j.h();
    if (paramPanelFeatureState.s != null)
    {
      paramPanelFeatureState.j.d(paramPanelFeatureState.s);
      paramPanelFeatureState.s = null;
    }
    if (!localCallback.onPreparePanel(0, paramPanelFeatureState.i, paramPanelFeatureState.j))
    {
      if ((i1 != 0) && (this.y != null))
        this.y.setMenu(null, this.z);
      paramPanelFeatureState.j.i();
      return false;
    }
    int i2;
    if (paramKeyEvent != null)
    {
      i2 = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i2).getKeyboardType() == 1)
        break label434;
    }
    label411: label434: for (boolean bool = true; ; bool = false)
    {
      paramPanelFeatureState.p = bool;
      paramPanelFeatureState.j.setQwertyMode(paramPanelFeatureState.p);
      paramPanelFeatureState.j.i();
      paramPanelFeatureState.m = true;
      paramPanelFeatureState.n = false;
      this.K = paramPanelFeatureState;
      return true;
      i2 = -1;
      break;
    }
  }

  private boolean c(PanelFeatureState paramPanelFeatureState)
  {
    if (paramPanelFeatureState.i != null)
    {
      paramPanelFeatureState.h = paramPanelFeatureState.i;
      return true;
    }
    if (paramPanelFeatureState.j == null)
      return false;
    if (this.A == null)
      this.A = new g();
    paramPanelFeatureState.h = ((View)paramPanelFeatureState.a(this.A));
    if (paramPanelFeatureState.h != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private boolean d(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getRepeatCount() == 0)
    {
      PanelFeatureState localPanelFeatureState = a(paramInt, true);
      if (!localPanelFeatureState.o)
        return b(localPanelFeatureState, paramKeyEvent);
    }
    return false;
  }

  private boolean e(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = true;
    if (this.h != null)
      return false;
    PanelFeatureState localPanelFeatureState = a(paramInt, bool1);
    if ((paramInt == 0) && (this.y != null) && (this.y.canShowOverflowMenu()) && (!ViewConfiguration.get(this.a).hasPermanentMenuKey()))
      if (!this.y.isOverflowMenuShowing())
      {
        if ((this.r) || (!b(localPanelFeatureState, paramKeyEvent)))
          break label233;
        bool1 = this.y.showOverflowMenu();
      }
    while (true)
    {
      if (bool1)
      {
        AudioManager localAudioManager = (AudioManager)this.a.getSystemService("audio");
        if (localAudioManager == null)
          break label221;
        localAudioManager.playSoundEffect(0);
      }
      label124: return bool1;
      bool1 = this.y.hideOverflowMenu();
      continue;
      if ((!localPanelFeatureState.o) && (!localPanelFeatureState.n))
        break;
      boolean bool2 = localPanelFeatureState.o;
      a(localPanelFeatureState, bool1);
      bool1 = bool2;
    }
    if (localPanelFeatureState.m)
    {
      if (!localPanelFeatureState.r)
        break label238;
      localPanelFeatureState.m = false;
    }
    label221: label233: label238: for (boolean bool3 = b(localPanelFeatureState, paramKeyEvent); ; bool3 = bool1)
    {
      if (bool3)
      {
        a(localPanelFeatureState, paramKeyEvent);
        break;
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
        break label124;
      }
      bool1 = false;
      break;
    }
  }

  private void j(int paramInt)
  {
    this.t |= 1 << paramInt;
    if (!this.s)
    {
      ViewCompat.postOnAnimation(this.b.getDecorView(), this.P);
      this.s = true;
    }
  }

  private int k(int paramInt)
  {
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      paramInt = 108;
    }
    while (paramInt != 9)
      return paramInt;
    Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
    return 109;
  }

  private boolean l(int paramInt)
  {
    Resources localResources = this.a.getResources();
    Configuration localConfiguration1 = localResources.getConfiguration();
    int i1 = 0x30 & localConfiguration1.uiMode;
    int i2;
    if (paramInt == 2)
    {
      i2 = 32;
      if (i1 == i2)
        break label119;
      if (!B())
        break label64;
      ((Activity)this.a).recreate();
    }
    while (true)
    {
      return true;
      i2 = 16;
      break;
      label64: Configuration localConfiguration2 = new Configuration(localConfiguration1);
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      localConfiguration2.uiMode = (i2 | 0xFFFFFFCF & localConfiguration2.uiMode);
      localResources.updateConfiguration(localConfiguration2, localDisplayMetrics);
      if (Build.VERSION.SDK_INT < 26)
        h.a(localResources);
    }
    label119: return false;
  }

  private void u()
  {
    v();
    if ((!this.m) || (this.f != null));
    while (true)
    {
      return;
      if ((this.c instanceof Activity))
        this.f = new l((Activity)this.c, this.n);
      while (this.f != null)
      {
        this.f.g(this.Q);
        return;
        if ((this.c instanceof Dialog))
          this.f = new l((Dialog)this.c);
      }
    }
  }

  private void v()
  {
    CharSequence localCharSequence;
    if (!this.C)
    {
      this.D = w();
      localCharSequence = o();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (this.y == null)
          break label93;
        this.y.setWindowTitle(localCharSequence);
      }
    }
    while (true)
    {
      x();
      a(this.D);
      this.C = true;
      PanelFeatureState localPanelFeatureState = a(0, false);
      if ((!this.r) && ((localPanelFeatureState == null) || (localPanelFeatureState.j == null)))
        j(108);
      return;
      label93: if (l() != null)
        l().c(localCharSequence);
      else if (this.E != null)
        this.E.setText(localCharSequence);
    }
  }

  private ViewGroup w()
  {
    TypedArray localTypedArray = this.a.obtainStyledAttributes(R.styleable.AppCompatTheme);
    if (!localTypedArray.hasValue(R.styleable.AppCompatTheme_windowActionBar))
    {
      localTypedArray.recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    LayoutInflater localLayoutInflater;
    Object localObject1;
    if (localTypedArray.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false))
    {
      c(1);
      if (localTypedArray.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false))
        c(109);
      if (localTypedArray.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false))
        c(10);
      this.p = localTypedArray.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
      localTypedArray.recycle();
      this.b.getDecorView();
      localLayoutInflater = LayoutInflater.from(this.a);
      if (this.q)
        break label451;
      if (!this.p)
        break label279;
      ViewGroup localViewGroup4 = (ViewGroup)localLayoutInflater.inflate(R.layout.abc_dialog_title_material, null);
      this.n = false;
      this.m = false;
      localObject1 = localViewGroup4;
    }
    while (true)
    {
      if (localObject1 == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.m + ", windowActionBarOverlay: " + this.n + ", android:windowIsFloating: " + this.p + ", windowActionModeOverlay: " + this.o + ", windowNoTitle: " + this.q + " }");
        if (!localTypedArray.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false))
          break;
        c(108);
        break;
        label279: if (!this.m)
          break label690;
        TypedValue localTypedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
        if (localTypedValue.resourceId != 0);
        for (Object localObject2 = new android.support.v7.view.d(this.a, localTypedValue.resourceId); ; localObject2 = this.a)
        {
          ViewGroup localViewGroup3 = (ViewGroup)LayoutInflater.from((Context)localObject2).inflate(R.layout.abc_screen_toolbar, null);
          this.y = ((DecorContentParent)localViewGroup3.findViewById(R.id.decor_content_parent));
          this.y.setWindowCallback(m());
          if (this.n)
            this.y.initFeature(109);
          if (this.G)
            this.y.initFeature(2);
          if (this.H)
            this.y.initFeature(5);
          localObject1 = localViewGroup3;
          break;
        }
        label451: if (this.o);
        for (ViewGroup localViewGroup1 = (ViewGroup)localLayoutInflater.inflate(R.layout.abc_screen_simple_overlay_action_mode, null); ; localViewGroup1 = (ViewGroup)localLayoutInflater.inflate(R.layout.abc_screen_simple, null))
        {
          if (Build.VERSION.SDK_INT < 21)
            break label517;
          ViewCompat.setOnApplyWindowInsetsListener(localViewGroup1, new OnApplyWindowInsetsListener()
          {
            public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
            {
              int i = paramAnonymousWindowInsetsCompat.getSystemWindowInsetTop();
              int j = AppCompatDelegateImpl.this.h(i);
              if (i != j)
                paramAnonymousWindowInsetsCompat = paramAnonymousWindowInsetsCompat.replaceSystemWindowInsets(paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft(), j, paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
              return ViewCompat.onApplyWindowInsets(paramAnonymousView, paramAnonymousWindowInsetsCompat);
            }
          });
          localObject1 = localViewGroup1;
          break;
        }
        label517: ((FitWindowsViewGroup)localViewGroup1).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener()
        {
          public void onFitSystemWindows(Rect paramAnonymousRect)
          {
            paramAnonymousRect.top = AppCompatDelegateImpl.this.h(paramAnonymousRect.top);
          }
        });
        localObject1 = localViewGroup1;
        continue;
      }
      if (this.y == null)
        this.E = ((TextView)((ViewGroup)localObject1).findViewById(R.id.title));
      ViewUtils.makeOptionalFitsSystemWindows((View)localObject1);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(R.id.action_bar_activity_content);
      ViewGroup localViewGroup2 = (ViewGroup)this.b.findViewById(16908290);
      if (localViewGroup2 != null)
      {
        while (localViewGroup2.getChildCount() > 0)
        {
          View localView = localViewGroup2.getChildAt(0);
          localViewGroup2.removeViewAt(0);
          localContentFrameLayout.addView(localView);
        }
        localViewGroup2.setId(-1);
        localContentFrameLayout.setId(16908290);
        if ((localViewGroup2 instanceof FrameLayout))
          ((FrameLayout)localViewGroup2).setForeground(null);
      }
      this.b.setContentView((View)localObject1);
      localContentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener()
      {
        public void onAttachedFromWindow()
        {
        }

        public void onDetachedFromWindow()
        {
          AppCompatDelegateImpl.this.t();
        }
      });
      return localObject1;
      label690: localObject1 = null;
    }
  }

  private void x()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.D.findViewById(16908290);
    View localView = this.b.getDecorView();
    localContentFrameLayout.setDecorPadding(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getPaddingRight(), localView.getPaddingBottom());
    TypedArray localTypedArray = this.a.obtainStyledAttributes(R.styleable.AppCompatTheme);
    localTypedArray.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    localTypedArray.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    if (localTypedArray.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor))
      localTypedArray.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, localContentFrameLayout.getFixedWidthMajor());
    if (localTypedArray.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor))
      localTypedArray.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, localContentFrameLayout.getFixedWidthMinor());
    if (localTypedArray.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor))
      localTypedArray.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, localContentFrameLayout.getFixedHeightMajor());
    if (localTypedArray.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor))
      localTypedArray.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, localContentFrameLayout.getFixedHeightMinor());
    localTypedArray.recycle();
    localContentFrameLayout.requestLayout();
  }

  private void y()
  {
    if (this.C)
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
  }

  private int z()
  {
    if (this.M != -100)
      return this.M;
    return k();
  }

  protected PanelFeatureState a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.J;
    if ((localObject == null) || (localObject.length <= paramInt))
    {
      PanelFeatureState[] arrayOfPanelFeatureState = new PanelFeatureState[paramInt + 1];
      if (localObject != null)
        System.arraycopy(localObject, 0, arrayOfPanelFeatureState, 0, localObject.length);
      this.J = arrayOfPanelFeatureState;
      localObject = arrayOfPanelFeatureState;
    }
    PanelFeatureState localPanelFeatureState1 = localObject[paramInt];
    if (localPanelFeatureState1 == null)
    {
      PanelFeatureState localPanelFeatureState2 = new PanelFeatureState(paramInt);
      localObject[paramInt] = localPanelFeatureState2;
      return localPanelFeatureState2;
    }
    return localPanelFeatureState1;
  }

  PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.J;
    int i1;
    if (arrayOfPanelFeatureState != null)
      i1 = arrayOfPanelFeatureState.length;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
        break label55;
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[i2];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.j == paramMenu))
      {
        return localPanelFeatureState;
        i1 = 0;
        break;
      }
    }
    label55: return null;
  }

  public a a()
  {
    u();
    return this.f;
  }

  public b a(android.support.v7.view.b.a parama)
  {
    if (parama == null)
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    if (this.h != null)
      this.h.c();
    c localc = new c(parama);
    a locala = a();
    if (locala != null)
    {
      this.h = locala.a(localc);
      if ((this.h != null) && (this.e != null))
        this.e.onSupportActionModeStarted(this.h);
    }
    if (this.h == null)
      this.h = b(localc);
    return this.h;
  }

  public <T extends View> T a(int paramInt)
  {
    v();
    return this.b.findViewById(paramInt);
  }

  public View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    String str;
    boolean bool2;
    if (this.T == null)
    {
      str = this.a.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
      if ((str == null) || (AppCompatViewInflater.class.getName().equals(str)))
        this.T = new AppCompatViewInflater();
    }
    else
    {
      if (!u)
        break label211;
      if (!(paramAttributeSet instanceof XmlPullParser))
        break label198;
      if (((XmlPullParser)paramAttributeSet).getDepth() <= 1)
        break label192;
      bool2 = true;
    }
    label86: for (boolean bool1 = bool2; ; bool1 = false)
    {
      while (true)
      {
        return this.T.createView(paramView, paramString, paramContext, paramAttributeSet, bool1, u, true, VectorEnabledTintResources.shouldBeUsed());
        try
        {
          this.T = ((AppCompatViewInflater)Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (Throwable localThrowable)
        {
          Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + str + ". Falling back to default.", localThrowable);
          this.T = new AppCompatViewInflater();
        }
      }
      break;
      bool2 = false;
      break label86;
      bool2 = a((ViewParent)paramView);
      break label86;
    }
  }

  void a(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    if (paramMenu == null)
    {
      if ((paramPanelFeatureState == null) && (paramInt >= 0) && (paramInt < this.J.length))
        paramPanelFeatureState = this.J[paramInt];
      if (paramPanelFeatureState != null)
        paramMenu = paramPanelFeatureState.j;
    }
    if ((paramPanelFeatureState != null) && (!paramPanelFeatureState.o));
    while (this.r)
      return;
    this.c.onPanelClosed(paramInt, paramMenu);
  }

  public void a(Configuration paramConfiguration)
  {
    if ((this.m) && (this.C))
    {
      a locala = a();
      if (locala != null)
        locala.a(paramConfiguration);
    }
    AppCompatDrawableManager.get().onConfigurationChanged(this.a);
    j();
  }

  public void a(Bundle paramBundle)
  {
    if ((this.c instanceof Activity));
    try
    {
      String str2 = NavUtils.getParentActivityName((Activity)this.c);
      str1 = str2;
      if (str1 != null)
      {
        locala = l();
        if (locala == null)
          this.Q = true;
      }
      else
      {
        if ((paramBundle != null) && (this.M == -100))
          this.M = paramBundle.getInt("appcompat:local_night_mode", -100);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        a locala;
        String str1 = null;
        continue;
        locala.g(true);
      }
    }
  }

  void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.a == 0) && (this.y != null) && (this.y.isOverflowMenuShowing()))
      a(paramPanelFeatureState.j);
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.a.getSystemService("window");
      if ((localWindowManager != null) && (paramPanelFeatureState.o) && (paramPanelFeatureState.g != null))
      {
        localWindowManager.removeView(paramPanelFeatureState.g);
        if (paramBoolean)
          a(paramPanelFeatureState.a, paramPanelFeatureState, null);
      }
      paramPanelFeatureState.m = false;
      paramPanelFeatureState.n = false;
      paramPanelFeatureState.o = false;
      paramPanelFeatureState.h = null;
      paramPanelFeatureState.q = true;
    }
    while (this.K != paramPanelFeatureState);
    this.K = null;
  }

  void a(android.support.v7.view.menu.h paramh)
  {
    if (this.I)
      return;
    this.I = true;
    this.y.dismissPopups();
    Window.Callback localCallback = m();
    if ((localCallback != null) && (!this.r))
      localCallback.onPanelClosed(108, paramh);
    this.I = false;
  }

  public void a(Toolbar paramToolbar)
  {
    if (!(this.c instanceof Activity))
      return;
    a locala = a();
    if ((locala instanceof l))
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    this.g = null;
    if (locala != null)
      locala.o();
    if (paramToolbar != null)
    {
      i locali = new i(paramToolbar, ((Activity)this.c).getTitle(), this.d);
      this.f = locali;
      this.b.setCallback(locali.p());
    }
    while (true)
    {
      f();
      return;
      this.f = null;
      this.b.setCallback(this.d);
    }
  }

  public void a(View paramView)
  {
    v();
    ViewGroup localViewGroup = (ViewGroup)this.D.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.c.onContentChanged();
  }

  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    v();
    ViewGroup localViewGroup = (ViewGroup)this.D.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.c.onContentChanged();
  }

  void a(ViewGroup paramViewGroup)
  {
  }

  public final void a(CharSequence paramCharSequence)
  {
    this.x = paramCharSequence;
    if (this.y != null)
      this.y.setWindowTitle(paramCharSequence);
    do
    {
      return;
      if (l() != null)
      {
        l().c(paramCharSequence);
        return;
      }
    }
    while (this.E == null);
    this.E.setText(paramCharSequence);
  }

  boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    a locala = a();
    if ((locala != null) && (locala.a(paramInt, paramKeyEvent)));
    boolean bool;
    do
    {
      do
      {
        return true;
        if ((this.K == null) || (!a(this.K, paramKeyEvent.getKeyCode(), paramKeyEvent, 1)))
          break;
      }
      while (this.K == null);
      this.K.n = true;
      return true;
      if (this.K != null)
        break;
      PanelFeatureState localPanelFeatureState = a(0, true);
      b(localPanelFeatureState, paramKeyEvent);
      bool = a(localPanelFeatureState, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      localPanelFeatureState.m = false;
    }
    while (bool);
    return false;
  }

  boolean a(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (((this.c instanceof KeyEventDispatcher.Component)) || ((this.c instanceof f)))
    {
      View localView = this.b.getDecorView();
      if ((localView == null) || (!KeyEventDispatcher.dispatchBeforeHierarchy(localView, paramKeyEvent)));
    }
    while ((paramKeyEvent.getKeyCode() == 82) && (this.c.dispatchKeyEvent(paramKeyEvent)))
      return bool;
    int i1 = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() == 0);
    while (bool)
    {
      return c(i1, paramKeyEvent);
      bool = false;
    }
    return b(i1, paramKeyEvent);
  }

  b b(android.support.v7.view.b.a parama)
  {
    r();
    if (this.h != null)
      this.h.c();
    if (!(parama instanceof c))
      parama = new c(parama);
    if ((this.e != null) && (!this.r));
    while (true)
    {
      try
      {
        b localb2 = this.e.onWindowStartingSupportActionMode(parama);
        localb1 = localb2;
        if (localb1 != null)
        {
          this.h = localb1;
          if ((this.h != null) && (this.e != null))
            this.e.onSupportActionModeStarted(this.h);
          return this.h;
        }
      }
      catch (AbstractMethodError localAbstractMethodError)
      {
        localb1 = null;
        continue;
        if (this.i == null)
        {
          if (!this.p)
            continue;
          TypedValue localTypedValue = new TypedValue();
          Resources.Theme localTheme1 = this.a.getTheme();
          localTheme1.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
          if (localTypedValue.resourceId != 0)
          {
            Resources.Theme localTheme2 = this.a.getResources().newTheme();
            localTheme2.setTo(localTheme1);
            localTheme2.applyStyle(localTypedValue.resourceId, true);
            localObject = new android.support.v7.view.d(this.a, 0);
            ((Context)localObject).getTheme().setTo(localTheme2);
            this.i = new ActionBarContextView((Context)localObject);
            this.j = new PopupWindow((Context)localObject, null, R.attr.actionModePopupWindowStyle);
            PopupWindowCompat.setWindowLayoutType(this.j, 2);
            this.j.setContentView(this.i);
            this.j.setWidth(-1);
            ((Context)localObject).getTheme().resolveAttribute(R.attr.actionBarSize, localTypedValue, true);
            int i1 = TypedValue.complexToDimensionPixelSize(localTypedValue.data, ((Context)localObject).getResources().getDisplayMetrics());
            this.i.setContentHeight(i1);
            this.j.setHeight(-2);
            this.k = new Runnable()
            {
              public void run()
              {
                AppCompatDelegateImpl.this.j.showAtLocation(AppCompatDelegateImpl.this.i, 55, 0, 0);
                AppCompatDelegateImpl.this.r();
                if (AppCompatDelegateImpl.this.p())
                {
                  AppCompatDelegateImpl.this.i.setAlpha(0.0F);
                  AppCompatDelegateImpl.this.l = ViewCompat.animate(AppCompatDelegateImpl.this.i).alpha(1.0F);
                  AppCompatDelegateImpl.this.l.setListener(new ViewPropertyAnimatorListenerAdapter()
                  {
                    public void onAnimationEnd(View paramAnonymous2View)
                    {
                      AppCompatDelegateImpl.this.i.setAlpha(1.0F);
                      AppCompatDelegateImpl.this.l.setListener(null);
                      AppCompatDelegateImpl.this.l = null;
                    }

                    public void onAnimationStart(View paramAnonymous2View)
                    {
                      AppCompatDelegateImpl.this.i.setVisibility(0);
                    }
                  });
                  return;
                }
                AppCompatDelegateImpl.this.i.setAlpha(1.0F);
                AppCompatDelegateImpl.this.i.setVisibility(0);
              }
            };
          }
        }
        else
        {
          if (this.i == null)
            continue;
          r();
          this.i.killMode();
          Context localContext = this.i.getContext();
          ActionBarContextView localActionBarContextView = this.i;
          if (this.j != null)
            continue;
          bool = true;
          android.support.v7.view.e locale = new android.support.v7.view.e(localContext, localActionBarContextView, parama, bool);
          if (!parama.a(locale, locale.b()))
            continue;
          locale.d();
          this.i.initForMode(locale);
          this.h = locale;
          if (!p())
            continue;
          this.i.setAlpha(0.0F);
          this.l = ViewCompat.animate(this.i).alpha(1.0F);
          this.l.setListener(new ViewPropertyAnimatorListenerAdapter()
          {
            public void onAnimationEnd(View paramAnonymousView)
            {
              AppCompatDelegateImpl.this.i.setAlpha(1.0F);
              AppCompatDelegateImpl.this.l.setListener(null);
              AppCompatDelegateImpl.this.l = null;
            }

            public void onAnimationStart(View paramAnonymousView)
            {
              AppCompatDelegateImpl.this.i.setVisibility(0);
              AppCompatDelegateImpl.this.i.sendAccessibilityEvent(32);
              if ((AppCompatDelegateImpl.this.i.getParent() instanceof View))
                ViewCompat.requestApplyInsets((View)AppCompatDelegateImpl.this.i.getParent());
            }
          });
          if (this.j == null)
            continue;
          this.b.getDecorView().post(this.k);
          continue;
        }
        Object localObject = this.a;
        continue;
        ViewStubCompat localViewStubCompat = (ViewStubCompat)this.D.findViewById(R.id.action_mode_bar_stub);
        if (localViewStubCompat == null)
          continue;
        localViewStubCompat.setLayoutInflater(LayoutInflater.from(n()));
        this.i = ((ActionBarContextView)localViewStubCompat.inflate());
        continue;
        boolean bool = false;
        continue;
        this.i.setAlpha(1.0F);
        this.i.setVisibility(0);
        this.i.sendAccessibilityEvent(32);
        if (!(this.i.getParent() instanceof View))
          continue;
        ViewCompat.requestApplyInsets((View)this.i.getParent());
        continue;
        this.h = null;
        continue;
      }
      b localb1 = null;
    }
  }

  public MenuInflater b()
  {
    if (this.g == null)
    {
      u();
      if (this.f == null)
        break label43;
    }
    label43: for (Context localContext = this.f.i(); ; localContext = this.a)
    {
      this.g = new g(localContext);
      return this.g;
    }
  }

  public void b(int paramInt)
  {
    v();
    ViewGroup localViewGroup = (ViewGroup)this.D.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.a).inflate(paramInt, localViewGroup);
    this.c.onContentChanged();
  }

  public void b(Bundle paramBundle)
  {
    v();
  }

  public void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    v();
    ((ViewGroup)this.D.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.c.onContentChanged();
  }

  boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = true;
    switch (paramInt)
    {
    default:
    case 82:
    case 4:
    }
    do
    {
      bool1 = false;
      boolean bool2;
      PanelFeatureState localPanelFeatureState;
      do
      {
        return bool1;
        e(0, paramKeyEvent);
        return bool1;
        bool2 = this.L;
        this.L = false;
        localPanelFeatureState = a(0, false);
        if ((localPanelFeatureState == null) || (!localPanelFeatureState.o))
          break;
      }
      while (bool2);
      a(localPanelFeatureState, bool1);
      return bool1;
    }
    while (!s());
    return bool1;
  }

  public void c()
  {
    j();
  }

  public void c(Bundle paramBundle)
  {
    if (this.M != -100)
      paramBundle.putInt("appcompat:local_night_mode", this.M);
  }

  public boolean c(int paramInt)
  {
    int i1 = k(paramInt);
    if ((this.q) && (i1 == 108))
      return false;
    if ((this.m) && (i1 == 1))
      this.m = false;
    switch (i1)
    {
    default:
      return this.b.requestFeature(i1);
    case 108:
      y();
      this.m = true;
      return true;
    case 109:
      y();
      this.n = true;
      return true;
    case 10:
      y();
      this.o = true;
      return true;
    case 2:
      y();
      this.G = true;
      return true;
    case 5:
      y();
      this.H = true;
      return true;
    case 1:
    }
    y();
    this.q = true;
    return true;
  }

  boolean c(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default:
      return false;
    case 82:
      d(0, paramKeyEvent);
      return bool;
    case 4:
    }
    if ((0x80 & paramKeyEvent.getFlags()) != 0);
    while (true)
    {
      this.L = bool;
      break;
      bool = false;
    }
  }

  public void d()
  {
    a locala = a();
    if (locala != null)
      locala.h(false);
    if (this.O != null)
      this.O.d();
  }

  void d(int paramInt)
  {
    if (paramInt == 108)
    {
      a locala = a();
      if (locala != null)
        locala.i(false);
    }
    PanelFeatureState localPanelFeatureState;
    do
    {
      do
        return;
      while (paramInt != 0);
      localPanelFeatureState = a(paramInt, true);
    }
    while (!localPanelFeatureState.o);
    a(localPanelFeatureState, false);
  }

  public void e()
  {
    a locala = a();
    if (locala != null)
      locala.h(true);
  }

  void e(int paramInt)
  {
    if (paramInt == 108)
    {
      a locala = a();
      if (locala != null)
        locala.i(true);
    }
  }

  public void f()
  {
    a locala = a();
    if ((locala != null) && (locala.m()))
      return;
    j(0);
  }

  void f(int paramInt)
  {
    a(a(paramInt, true), true);
  }

  public void g()
  {
    if (this.s)
      this.b.getDecorView().removeCallbacks(this.P);
    this.r = true;
    if (this.f != null)
      this.f.o();
    if (this.O != null)
      this.O.d();
  }

  void g(int paramInt)
  {
    PanelFeatureState localPanelFeatureState1 = a(paramInt, true);
    if (localPanelFeatureState1.j != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState1.j.c(localBundle);
      if (localBundle.size() > 0)
        localPanelFeatureState1.s = localBundle;
      localPanelFeatureState1.j.h();
      localPanelFeatureState1.j.clear();
    }
    localPanelFeatureState1.r = true;
    localPanelFeatureState1.q = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.y != null))
    {
      PanelFeatureState localPanelFeatureState2 = a(0, false);
      if (localPanelFeatureState2 != null)
      {
        localPanelFeatureState2.m = false;
        b(localPanelFeatureState2, null);
      }
    }
  }

  int h(int paramInt)
  {
    int i1 = 1;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i5;
    int i6;
    label198: label205: int i4;
    if ((this.i != null) && ((this.i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
      if (this.i.isShown())
      {
        if (this.R == null)
        {
          this.R = new Rect();
          this.S = new Rect();
        }
        Rect localRect1 = this.R;
        Rect localRect2 = this.S;
        localRect1.set(0, paramInt, 0, 0);
        ViewUtils.computeFitSystemWindows(this.D, localRect1, localRect2);
        if (localRect2.top == 0)
        {
          i5 = paramInt;
          if (localMarginLayoutParams.topMargin == i5)
            break label358;
          localMarginLayoutParams.topMargin = paramInt;
          if (this.F != null)
            break label279;
          this.F = new View(this.a);
          this.F.setBackgroundColor(this.a.getResources().getColor(R.color.abc_input_method_navigation_guard));
          this.D.addView(this.F, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i6 = i1;
          if (this.F == null)
            break label318;
          if ((!this.o) && (i1 != 0))
            paramInt = 0;
          int i7 = i6;
          i4 = i1;
          i1 = i7;
          label228: if (i1 != 0)
            this.i.setLayoutParams(localMarginLayoutParams);
        }
      }
    }
    for (int i2 = i4; ; i2 = 0)
    {
      View localView;
      int i3;
      if (this.F != null)
      {
        localView = this.F;
        i3 = 0;
        if (i2 == 0)
          break label343;
      }
      while (true)
      {
        localView.setVisibility(i3);
        return paramInt;
        i5 = 0;
        break;
        label279: ViewGroup.LayoutParams localLayoutParams = this.F.getLayoutParams();
        if (localLayoutParams.height != paramInt)
        {
          localLayoutParams.height = paramInt;
          this.F.setLayoutParams(localLayoutParams);
        }
        i6 = i1;
        break label198;
        label318: i1 = 0;
        break label205;
        if (localMarginLayoutParams.topMargin == 0)
          break label350;
        localMarginLayoutParams.topMargin = 0;
        i4 = 0;
        break label228;
        label343: i3 = 8;
      }
      label350: i4 = 0;
      i1 = 0;
      break label228;
      label358: i6 = 0;
      break label198;
    }
  }

  public final b.a h()
  {
    return new a();
  }

  int i(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return paramInt;
    case 0:
      if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)this.a.getSystemService(UiModeManager.class)).getNightMode() == 0))
        return -1;
      A();
      return this.O.a();
    case -100:
    }
    return -1;
  }

  public void i()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.a);
    if (localLayoutInflater.getFactory() == null)
      LayoutInflaterCompat.setFactory2(localLayoutInflater, this);
    while ((localLayoutInflater.getFactory2() instanceof AppCompatDelegateImpl))
      return;
    Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
  }

  public boolean j()
  {
    int i1 = z();
    int i2 = i(i1);
    boolean bool = false;
    if (i2 != -1)
      bool = l(i2);
    if (i1 == 0)
    {
      A();
      this.O.c();
    }
    this.N = true;
    return bool;
  }

  final a l()
  {
    return this.f;
  }

  final Window.Callback m()
  {
    return this.b.getCallback();
  }

  final Context n()
  {
    a locala = a();
    Context localContext = null;
    if (locala != null)
      localContext = locala.i();
    if (localContext == null)
      localContext = this.a;
    return localContext;
  }

  final CharSequence o()
  {
    if ((this.c instanceof Activity))
      return ((Activity)this.c).getTitle();
    return this.x;
  }

  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return a(paramView, paramString, paramContext, paramAttributeSet);
  }

  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }

  public boolean onMenuItemSelected(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = m();
    if ((localCallback != null) && (!this.r))
    {
      PanelFeatureState localPanelFeatureState = a(paramh.q());
      if (localPanelFeatureState != null)
        return localCallback.onMenuItemSelected(localPanelFeatureState.a, paramMenuItem);
    }
    return false;
  }

  public void onMenuModeChange(android.support.v7.view.menu.h paramh)
  {
    a(paramh, true);
  }

  final boolean p()
  {
    return (this.C) && (this.D != null) && (ViewCompat.isLaidOut(this.D));
  }

  public boolean q()
  {
    return this.B;
  }

  void r()
  {
    if (this.l != null)
      this.l.cancel();
  }

  boolean s()
  {
    if (this.h != null)
      this.h.c();
    a locala;
    do
    {
      return true;
      locala = a();
    }
    while ((locala != null) && (locala.n()));
    return false;
  }

  void t()
  {
    if (this.y != null)
      this.y.dismissPopups();
    if (this.j != null)
    {
      this.b.getDecorView().removeCallbacks(this.k);
      if (!this.j.isShowing());
    }
    try
    {
      this.j.dismiss();
      label55: this.j = null;
      r();
      PanelFeatureState localPanelFeatureState = a(0, false);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.j != null))
        localPanelFeatureState.j.close();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label55;
    }
  }

  protected static final class PanelFeatureState
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    ViewGroup g;
    View h;
    View i;
    android.support.v7.view.menu.h j;
    android.support.v7.view.menu.f k;
    Context l;
    boolean m;
    boolean n;
    boolean o;
    public boolean p;
    boolean q;
    boolean r;
    Bundle s;

    PanelFeatureState(int paramInt)
    {
      this.a = paramInt;
      this.q = false;
    }

    p a(o.a parama)
    {
      if (this.j == null)
        return null;
      if (this.k == null)
      {
        this.k = new android.support.v7.view.menu.f(this.l, R.layout.abc_list_menu_item_layout);
        this.k.setCallback(parama);
        this.j.a(this.k);
      }
      return this.k.a(this.g);
    }

    void a(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0)
        localTheme.applyStyle(localTypedValue.resourceId, true);
      localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0)
        localTheme.applyStyle(localTypedValue.resourceId, true);
      while (true)
      {
        android.support.v7.view.d locald = new android.support.v7.view.d(paramContext, 0);
        locald.getTheme().setTo(localTheme);
        this.l = locald;
        TypedArray localTypedArray = locald.obtainStyledAttributes(R.styleable.AppCompatTheme);
        this.b = localTypedArray.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
        this.f = localTypedArray.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
        localTypedArray.recycle();
        return;
        localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
      }
    }

    void a(android.support.v7.view.menu.h paramh)
    {
      if (paramh == this.j);
      do
      {
        return;
        if (this.j != null)
          this.j.b(this.k);
        this.j = paramh;
      }
      while ((paramh == null) || (this.k == null));
      paramh.a(this.k);
    }

    public boolean a()
    {
      boolean bool = true;
      if (this.h == null)
        bool = false;
      while ((this.i != null) || (this.k.a().getCount() > 0))
        return bool;
      return false;
    }

    private static class SavedState
      implements Parcelable
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
      {
        public AppCompatDelegateImpl.PanelFeatureState.SavedState a(Parcel paramAnonymousParcel)
        {
          return AppCompatDelegateImpl.PanelFeatureState.SavedState.readFromParcel(paramAnonymousParcel, null);
        }

        public AppCompatDelegateImpl.PanelFeatureState.SavedState a(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
        {
          return AppCompatDelegateImpl.PanelFeatureState.SavedState.readFromParcel(paramAnonymousParcel, paramAnonymousClassLoader);
        }

        public AppCompatDelegateImpl.PanelFeatureState.SavedState[] a(int paramAnonymousInt)
        {
          return new AppCompatDelegateImpl.PanelFeatureState.SavedState[paramAnonymousInt];
        }
      };
      int featureId;
      boolean isOpen;
      Bundle menuState;

      static SavedState readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        int i = 1;
        SavedState localSavedState = new SavedState();
        localSavedState.featureId = paramParcel.readInt();
        if (paramParcel.readInt() == i);
        while (true)
        {
          localSavedState.isOpen = i;
          if (localSavedState.isOpen)
            localSavedState.menuState = paramParcel.readBundle(paramClassLoader);
          return localSavedState;
          i = 0;
        }
      }

      public int describeContents()
      {
        return 0;
      }

      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.featureId);
        if (this.isOpen);
        for (int i = 1; ; i = 0)
        {
          paramParcel.writeInt(i);
          if (this.isOpen)
            paramParcel.writeBundle(this.menuState);
          return;
        }
      }
    }
  }

  private class a
    implements b.a
  {
    a()
    {
    }

    public void a(int paramInt)
    {
      a locala = AppCompatDelegateImpl.this.a();
      if (locala != null)
        locala.e(paramInt);
    }
  }

  private final class b
    implements o.a
  {
    b()
    {
    }

    public void onCloseMenu(android.support.v7.view.menu.h paramh, boolean paramBoolean)
    {
      AppCompatDelegateImpl.this.a(paramh);
    }

    public boolean onOpenSubMenu(android.support.v7.view.menu.h paramh)
    {
      Window.Callback localCallback = AppCompatDelegateImpl.this.m();
      if (localCallback != null)
        localCallback.onMenuOpened(108, paramh);
      return true;
    }
  }

  class c
    implements android.support.v7.view.b.a
  {
    private android.support.v7.view.b.a b;

    public c(android.support.v7.view.b.a arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void a(b paramb)
    {
      this.b.a(paramb);
      if (AppCompatDelegateImpl.this.j != null)
        AppCompatDelegateImpl.this.b.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.k);
      if (AppCompatDelegateImpl.this.i != null)
      {
        AppCompatDelegateImpl.this.r();
        AppCompatDelegateImpl.this.l = ViewCompat.animate(AppCompatDelegateImpl.this.i).alpha(0.0F);
        AppCompatDelegateImpl.this.l.setListener(new ViewPropertyAnimatorListenerAdapter()
        {
          public void onAnimationEnd(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.i.setVisibility(8);
            if (AppCompatDelegateImpl.this.j != null)
              AppCompatDelegateImpl.this.j.dismiss();
            while (true)
            {
              AppCompatDelegateImpl.this.i.removeAllViews();
              AppCompatDelegateImpl.this.l.setListener(null);
              AppCompatDelegateImpl.this.l = null;
              return;
              if ((AppCompatDelegateImpl.this.i.getParent() instanceof View))
                ViewCompat.requestApplyInsets((View)AppCompatDelegateImpl.this.i.getParent());
            }
          }
        });
      }
      if (AppCompatDelegateImpl.this.e != null)
        AppCompatDelegateImpl.this.e.onSupportActionModeFinished(AppCompatDelegateImpl.this.h);
      AppCompatDelegateImpl.this.h = null;
    }

    public boolean a(b paramb, Menu paramMenu)
    {
      return this.b.a(paramb, paramMenu);
    }

    public boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.b.a(paramb, paramMenuItem);
    }

    public boolean b(b paramb, Menu paramMenu)
    {
      return this.b.b(paramb, paramMenu);
    }
  }

  class d extends android.support.v7.view.i
  {
    d(Window.Callback arg2)
    {
      super();
    }

    final ActionMode a(ActionMode.Callback paramCallback)
    {
      f.a locala = new f.a(AppCompatDelegateImpl.this.a, paramCallback);
      b localb = AppCompatDelegateImpl.this.a(locala);
      if (localb != null)
        return locala.b(localb);
      return null;
    }

    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImpl.this.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (AppCompatDelegateImpl.this.a(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }

    public void onContentChanged()
    {
    }

    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof android.support.v7.view.menu.h)))
        return false;
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }

    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      AppCompatDelegateImpl.this.e(paramInt);
      return true;
    }

    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      AppCompatDelegateImpl.this.d(paramInt);
    }

    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      android.support.v7.view.menu.h localh;
      boolean bool;
      if ((paramMenu instanceof android.support.v7.view.menu.h))
      {
        localh = (android.support.v7.view.menu.h)paramMenu;
        if ((paramInt != 0) || (localh != null))
          break label34;
        bool = false;
      }
      label34: 
      do
      {
        return bool;
        localh = null;
        break;
        if (localh != null)
          localh.c(true);
        bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      }
      while (localh == null);
      localh.c(false);
      return bool;
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = AppCompatDelegateImpl.this.a(0, true);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.j != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.j, paramInt);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (Build.VERSION.SDK_INT >= 23)
        return null;
      if (AppCompatDelegateImpl.this.q())
        return a(paramCallback);
      return super.onWindowStartingActionMode(paramCallback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (AppCompatDelegateImpl.this.q());
      switch (paramInt)
      {
      default:
        return super.onWindowStartingActionMode(paramCallback, paramInt);
      case 0:
      }
      return a(paramCallback);
    }
  }

  final class e
  {
    private k b;
    private boolean c;
    private BroadcastReceiver d;
    private IntentFilter e;

    e(k arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = localObject.a();
    }

    int a()
    {
      this.c = this.b.a();
      if (this.c)
        return 2;
      return 1;
    }

    void b()
    {
      boolean bool = this.b.a();
      if (bool != this.c)
      {
        this.c = bool;
        AppCompatDelegateImpl.this.j();
      }
    }

    void c()
    {
      d();
      if (this.d == null)
        this.d = new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppCompatDelegateImpl.e.this.b();
          }
        };
      if (this.e == null)
      {
        this.e = new IntentFilter();
        this.e.addAction("android.intent.action.TIME_SET");
        this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.e.addAction("android.intent.action.TIME_TICK");
      }
      AppCompatDelegateImpl.this.a.registerReceiver(this.d, this.e);
    }

    void d()
    {
      if (this.d != null)
      {
        AppCompatDelegateImpl.this.a.unregisterReceiver(this.d);
        this.d = null;
      }
    }
  }

  private class f extends ContentFrameLayout
  {
    public f(Context arg2)
    {
      super();
    }

    private boolean a(int paramInt1, int paramInt2)
    {
      return (paramInt1 < -5) || (paramInt2 < -5) || (paramInt1 > 5 + getWidth()) || (paramInt2 > 5 + getHeight());
    }

    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImpl.this.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((paramMotionEvent.getAction() == 0) && (a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
      {
        AppCompatDelegateImpl.this.f(0);
        return true;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }

    public void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(android.support.v7.a.a.a.b(getContext(), paramInt));
    }
  }

  private final class g
    implements o.a
  {
    g()
    {
    }

    public void onCloseMenu(android.support.v7.view.menu.h paramh, boolean paramBoolean)
    {
      android.support.v7.view.menu.h localh = paramh.q();
      if (localh != paramh);
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState;
      for (int i = 1; ; i = 0)
      {
        AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
        if (i != 0)
          paramh = localh;
        localPanelFeatureState = localAppCompatDelegateImpl.a(paramh);
        if (localPanelFeatureState != null)
        {
          if (i == 0)
            break;
          AppCompatDelegateImpl.this.a(localPanelFeatureState.a, localPanelFeatureState, localh);
          AppCompatDelegateImpl.this.a(localPanelFeatureState, true);
        }
        return;
      }
      AppCompatDelegateImpl.this.a(localPanelFeatureState, paramBoolean);
    }

    public boolean onOpenSubMenu(android.support.v7.view.menu.h paramh)
    {
      if ((paramh == null) && (AppCompatDelegateImpl.this.m))
      {
        Window.Callback localCallback = AppCompatDelegateImpl.this.m();
        if ((localCallback != null) && (!AppCompatDelegateImpl.this.r))
          localCallback.onMenuOpened(108, paramh);
      }
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImpl
 * JD-Core Version:    0.6.2
 */