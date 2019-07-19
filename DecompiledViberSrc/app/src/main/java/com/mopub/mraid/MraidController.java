package com.mopub.mraid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.CloseableLayout.ClosePosition;
import com.mopub.common.CloseableLayout.OnCloseListener;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.UrlHandler.MoPubSchemeListener;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.Utils;
import com.mopub.common.util.Views;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.mobileads.util.WebViews;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.EnumSet;

public class MraidController
{
  private final AdReport a;
  private WeakReference<Activity> b;
  private final Context c;
  private final PlacementType d;
  private final FrameLayout e;
  private final CloseableLayout f;
  private ViewGroup g;
  private final b h;
  private final c i;
  private ViewState j = ViewState.LOADING;
  private MraidListener k;
  private UseCustomCloseListener l;
  private MraidWebViewDebugListener m;
  private MraidBridge.MraidWebView n;
  private MraidBridge.MraidWebView o;
  private final MraidBridge p;
  private final MraidBridge q;
  private a r = new a();
  private Integer s;
  private UrlHandler.MoPubSchemeListener t = new UrlHandler.MoPubSchemeListener()
  {
    public void onClose()
    {
    }

    public void onCrash()
    {
      if (MraidController.a(MraidController.this) != null)
        MraidController.a(MraidController.this).loadUrl("chrome://crash");
    }

    public void onFailLoad()
    {
    }

    public void onFinishLoad()
    {
    }
  };
  private boolean u = true;
  private b v = b.NONE;
  private final MraidNativeCommandHandler w;
  private boolean x = true;
  private final MraidBridge.MraidBridgeListener y = new MraidBridge.MraidBridgeListener()
  {
    public void onClose()
    {
      MraidController.this.d();
    }

    public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
    {
      return MraidController.this.a(paramAnonymousConsoleMessage);
    }

    public void onExpand(URI paramAnonymousURI, boolean paramAnonymousBoolean)
      throws a
    {
      MraidController.this.a(paramAnonymousURI, paramAnonymousBoolean);
    }

    public boolean onJsAlert(String paramAnonymousString, JsResult paramAnonymousJsResult)
    {
      return MraidController.this.a(paramAnonymousString, paramAnonymousJsResult);
    }

    public void onOpen(URI paramAnonymousURI)
    {
      MraidController.this.b(paramAnonymousURI.toString());
    }

    public void onPageFailedToLoad()
    {
      if (MraidController.b(MraidController.this) != null)
        MraidController.b(MraidController.this).onFailedToLoad();
    }

    public void onPageLoaded()
    {
      MraidController.this.b();
      if (MraidController.b(MraidController.this) != null)
        MraidController.b(MraidController.this).onLoaded(MraidController.c(MraidController.this));
    }

    public void onPlayVideo(URI paramAnonymousURI)
    {
      MraidController.this.a(paramAnonymousURI.toString());
    }

    public void onRenderProcessGone(MoPubErrorCode paramAnonymousMoPubErrorCode)
    {
      MraidController.this.a(paramAnonymousMoPubErrorCode);
    }

    public void onResize(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, CloseableLayout.ClosePosition paramAnonymousClosePosition, boolean paramAnonymousBoolean)
      throws a
    {
      MraidController.this.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousClosePosition, paramAnonymousBoolean);
    }

    public void onSetOrientationProperties(boolean paramAnonymousBoolean, b paramAnonymousb)
      throws a
    {
      MraidController.this.a(paramAnonymousBoolean, paramAnonymousb);
    }

    public void onUseCustomClose(boolean paramAnonymousBoolean)
    {
      MraidController.this.a(paramAnonymousBoolean);
    }

    public void onVisibilityChanged(boolean paramAnonymousBoolean)
    {
      if (!MraidController.d(MraidController.this).e())
        MraidController.e(MraidController.this).a(paramAnonymousBoolean);
    }
  };
  private final MraidBridge.MraidBridgeListener z = new MraidBridge.MraidBridgeListener()
  {
    public void onClose()
    {
      MraidController.this.d();
    }

    public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
    {
      return MraidController.this.a(paramAnonymousConsoleMessage);
    }

    public void onExpand(URI paramAnonymousURI, boolean paramAnonymousBoolean)
    {
    }

    public boolean onJsAlert(String paramAnonymousString, JsResult paramAnonymousJsResult)
    {
      return MraidController.this.a(paramAnonymousString, paramAnonymousJsResult);
    }

    public void onOpen(URI paramAnonymousURI)
    {
      MraidController.this.b(paramAnonymousURI.toString());
    }

    public void onPageFailedToLoad()
    {
    }

    public void onPageLoaded()
    {
      MraidController.this.c();
    }

    public void onPlayVideo(URI paramAnonymousURI)
    {
      MraidController.this.a(paramAnonymousURI.toString());
    }

    public void onRenderProcessGone(MoPubErrorCode paramAnonymousMoPubErrorCode)
    {
      MraidController.this.a(paramAnonymousMoPubErrorCode);
    }

    public void onResize(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, CloseableLayout.ClosePosition paramAnonymousClosePosition, boolean paramAnonymousBoolean)
      throws a
    {
      throw new a("Not allowed to resize from an expanded state");
    }

    public void onSetOrientationProperties(boolean paramAnonymousBoolean, b paramAnonymousb)
      throws a
    {
      MraidController.this.a(paramAnonymousBoolean, paramAnonymousb);
    }

    public void onUseCustomClose(boolean paramAnonymousBoolean)
    {
      MraidController.this.a(paramAnonymousBoolean);
    }

    public void onVisibilityChanged(boolean paramAnonymousBoolean)
    {
      MraidController.e(MraidController.this).a(paramAnonymousBoolean);
      MraidController.d(MraidController.this).a(paramAnonymousBoolean);
    }
  };

  public MraidController(Context paramContext, AdReport paramAdReport, PlacementType paramPlacementType)
  {
    this(paramContext, paramAdReport, paramPlacementType, new MraidBridge(paramAdReport, paramPlacementType), new MraidBridge(paramAdReport, PlacementType.INTERSTITIAL), new b());
  }

  @VisibleForTesting
  MraidController(Context paramContext, AdReport paramAdReport, PlacementType paramPlacementType, MraidBridge paramMraidBridge1, MraidBridge paramMraidBridge2, b paramb)
  {
    this.c = paramContext.getApplicationContext();
    Preconditions.checkNotNull(this.c);
    this.a = paramAdReport;
    if ((paramContext instanceof Activity));
    for (this.b = new WeakReference((Activity)paramContext); ; this.b = new WeakReference(null))
    {
      this.d = paramPlacementType;
      this.p = paramMraidBridge1;
      this.q = paramMraidBridge2;
      this.h = paramb;
      this.j = ViewState.LOADING;
      DisplayMetrics localDisplayMetrics = this.c.getResources().getDisplayMetrics();
      this.i = new c(this.c, localDisplayMetrics.density);
      this.e = new FrameLayout(this.c);
      this.f = new CloseableLayout(this.c);
      this.f.setOnCloseListener(new CloseableLayout.OnCloseListener()
      {
        public void onClose()
        {
          MraidController.this.d();
        }
      });
      View localView = new View(this.c);
      localView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.f.addView(localView, new FrameLayout.LayoutParams(-1, -1));
      this.r.register(this.c);
      this.p.a(this.y);
      this.q.a(this.z);
      this.w = new MraidNativeCommandHandler();
      return;
    }
  }

  @VisibleForTesting
  static void a(MraidListener paramMraidListener, ViewState paramViewState1, ViewState paramViewState2)
  {
    Preconditions.checkNotNull(paramMraidListener);
    Preconditions.checkNotNull(paramViewState1);
    Preconditions.checkNotNull(paramViewState2);
    if (paramViewState2 == ViewState.EXPANDED)
      paramMraidListener.onExpand();
    do
    {
      return;
      if ((paramViewState1 == ViewState.EXPANDED) && (paramViewState2 == ViewState.DEFAULT))
      {
        paramMraidListener.onClose();
        return;
      }
      if (paramViewState2 == ViewState.HIDDEN)
      {
        paramMraidListener.onClose();
        return;
      }
      if ((paramViewState1 == ViewState.RESIZED) && (paramViewState2 == ViewState.DEFAULT))
      {
        paramMraidListener.onResize(true);
        return;
      }
    }
    while (paramViewState2 != ViewState.RESIZED);
    paramMraidListener.onResize(false);
  }

  private void a(ViewState paramViewState)
  {
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("MRAID state set to " + paramViewState);
    MoPubLog.log(localSdkLogEvent, arrayOfObject);
    ViewState localViewState = this.j;
    this.j = paramViewState;
    this.p.a(paramViewState);
    if (this.q.f())
      this.q.a(paramViewState);
    if (this.k != null)
      a(this.k, localViewState, paramViewState);
    a(null);
  }

  private void a(final Runnable paramRunnable)
  {
    this.h.a();
    final MraidBridge.MraidWebView localMraidWebView = getCurrentWebView();
    if (localMraidWebView == null)
      return;
    b localb = this.h;
    View[] arrayOfView = new View[2];
    arrayOfView[0] = this.e;
    arrayOfView[1] = localMraidWebView;
    localb.a(arrayOfView).a(new Runnable()
    {
      public void run()
      {
        DisplayMetrics localDisplayMetrics = MraidController.f(MraidController.this).getResources().getDisplayMetrics();
        MraidController.j(MraidController.this).a(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
        int[] arrayOfInt = new int[2];
        ViewGroup localViewGroup = MraidController.k(MraidController.this);
        localViewGroup.getLocationOnScreen(arrayOfInt);
        MraidController.j(MraidController.this).a(arrayOfInt[0], arrayOfInt[1], localViewGroup.getWidth(), localViewGroup.getHeight());
        MraidController.c(MraidController.this).getLocationOnScreen(arrayOfInt);
        MraidController.j(MraidController.this).c(arrayOfInt[0], arrayOfInt[1], MraidController.c(MraidController.this).getWidth(), MraidController.c(MraidController.this).getHeight());
        localMraidWebView.getLocationOnScreen(arrayOfInt);
        MraidController.j(MraidController.this).b(arrayOfInt[0], arrayOfInt[1], localMraidWebView.getWidth(), localMraidWebView.getHeight());
        MraidController.e(MraidController.this).notifyScreenMetrics(MraidController.j(MraidController.this));
        if (MraidController.d(MraidController.this).e())
          MraidController.d(MraidController.this).notifyScreenMetrics(MraidController.j(MraidController.this));
        if (paramRunnable != null)
          paramRunnable.run();
      }
    });
  }

  private int h()
  {
    return ((WindowManager)this.c.getSystemService("window")).getDefaultDisplay().getRotation();
  }

  private void i()
  {
    this.p.a();
    this.n = null;
  }

  private void j()
  {
    this.q.a();
    this.o = null;
  }

  private ViewGroup k()
  {
    if (this.g != null)
      return this.g;
    View localView = Views.getTopmostView((Context)this.b.get(), this.e);
    if ((localView instanceof ViewGroup))
      return (ViewGroup)localView;
    return this.e;
  }

  private ViewGroup l()
  {
    if (this.g == null)
      this.g = k();
    return this.g;
  }

  private boolean m()
  {
    return !this.f.isCloseVisible();
  }

  int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt1, Math.min(paramInt2, paramInt3));
  }

  void a(int paramInt)
  {
    a(null);
  }

  @VisibleForTesting
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CloseableLayout.ClosePosition paramClosePosition, boolean paramBoolean)
    throws a
  {
    if (this.n == null)
      throw new a("Unable to resize after the WebView is destroyed");
    if ((this.j == ViewState.LOADING) || (this.j == ViewState.HIDDEN))
      return;
    if (this.j == ViewState.EXPANDED)
      throw new a("Not allowed to resize from an already expanded ad");
    if (this.d == PlacementType.INTERSTITIAL)
      throw new a("Not allowed to resize from an interstitial ad");
    int i1 = Dips.dipsToIntPixels(paramInt1, this.c);
    int i2 = Dips.dipsToIntPixels(paramInt2, this.c);
    int i3 = Dips.dipsToIntPixels(paramInt3, this.c);
    int i4 = Dips.dipsToIntPixels(paramInt4, this.c);
    int i5 = i3 + this.i.e().left;
    int i6 = i4 + this.i.e().top;
    Rect localRect1 = new Rect(i5, i6, i1 + i5, i6 + i2);
    if (!paramBoolean)
    {
      Rect localRect3 = this.i.b();
      if ((localRect1.width() > localRect3.width()) || (localRect1.height() > localRect3.height()))
        throw new a("resizeProperties specified a size (" + paramInt1 + ", " + paramInt2 + ") and offset (" + paramInt3 + ", " + paramInt4 + ") that doesn't allow the ad to appear within the max allowed size (" + this.i.c().width() + ", " + this.i.c().height() + ")");
      localRect1.offsetTo(a(localRect3.left, localRect1.left, localRect3.right - localRect1.width()), a(localRect3.top, localRect1.top, localRect3.bottom - localRect1.height()));
    }
    Rect localRect2 = new Rect();
    this.f.applyCloseRegionBounds(paramClosePosition, localRect1, localRect2);
    if (!this.i.b().contains(localRect2))
      throw new a("resizeProperties specified a size (" + paramInt1 + ", " + paramInt2 + ") and offset (" + paramInt3 + ", " + paramInt4 + ") that doesn't allow the close region to appear within the max allowed size (" + this.i.c().width() + ", " + this.i.c().height() + ")");
    if (!localRect1.contains(localRect2))
      throw new a("resizeProperties specified a size (" + paramInt1 + ", " + i2 + ") and offset (" + paramInt3 + ", " + paramInt4 + ") that don't allow the close region to appear within the resized ad.");
    this.f.setCloseVisible(false);
    this.f.setClosePosition(paramClosePosition);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(localRect1.width(), localRect1.height());
    localLayoutParams.leftMargin = (localRect1.left - this.i.b().left);
    localLayoutParams.topMargin = (localRect1.top - this.i.b().top);
    if (this.j == ViewState.DEFAULT)
    {
      this.e.removeView(this.n);
      this.e.setVisibility(4);
      this.f.addView(this.n, new FrameLayout.LayoutParams(-1, -1));
      l().addView(this.f, localLayoutParams);
    }
    while (true)
    {
      this.f.setClosePosition(paramClosePosition);
      a(ViewState.RESIZED);
      return;
      if (this.j == ViewState.RESIZED)
        this.f.setLayoutParams(localLayoutParams);
    }
  }

  @VisibleForTesting
  void a(MoPubErrorCode paramMoPubErrorCode)
  {
    if (this.k != null)
      this.k.onRenderProcessGone(paramMoPubErrorCode);
  }

  @VisibleForTesting
  void a(String paramString)
  {
    MraidVideoPlayerActivity.startMraid(this.c, paramString);
  }

  void a(URI paramURI, boolean paramBoolean)
    throws a
  {
    if (this.n == null)
      throw new a("Unable to expand after the WebView is destroyed");
    if (this.d == PlacementType.INTERSTITIAL);
    while ((this.j != ViewState.DEFAULT) && (this.j != ViewState.RESIZED))
      return;
    e();
    int i1;
    FrameLayout.LayoutParams localLayoutParams;
    if (paramURI != null)
    {
      i1 = 1;
      if (i1 != 0)
      {
        this.o = new MraidBridge.MraidWebView(this.c);
        this.q.a(this.o);
        this.q.setContentUrl(paramURI.toString());
      }
      localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      if (this.j != ViewState.DEFAULT)
        break label220;
      if (i1 == 0)
        break label185;
      this.f.addView(this.o, localLayoutParams);
      label138: l().addView(this.f, new FrameLayout.LayoutParams(-1, -1));
    }
    while (true)
    {
      this.f.setLayoutParams(localLayoutParams);
      a(paramBoolean);
      a(ViewState.EXPANDED);
      return;
      i1 = 0;
      break;
      label185: this.e.removeView(this.n);
      this.e.setVisibility(4);
      this.f.addView(this.n, localLayoutParams);
      break label138;
      label220: if ((this.j == ViewState.RESIZED) && (i1 != 0))
      {
        this.f.removeView(this.n);
        this.e.addView(this.n, localLayoutParams);
        this.e.setVisibility(4);
        this.f.addView(this.o, localLayoutParams);
      }
    }
  }

  @VisibleForTesting
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean == m())
      return;
    CloseableLayout localCloseableLayout = this.f;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      localCloseableLayout.setCloseVisible(bool);
      if (this.l == null)
        break;
      this.l.useCustomCloseChanged(paramBoolean);
      return;
    }
  }

  @VisibleForTesting
  void a(boolean paramBoolean, b paramb)
    throws a
  {
    if (!a(paramb))
      throw new a("Unable to force orientation to " + paramb);
    this.u = paramBoolean;
    this.v = paramb;
    if ((this.j == ViewState.EXPANDED) || ((this.d == PlacementType.INTERSTITIAL) && (!this.x)))
      e();
  }

  @VisibleForTesting
  boolean a()
  {
    Activity localActivity = (Activity)this.b.get();
    if ((localActivity == null) || (getCurrentWebView() == null))
      return false;
    if (this.d != PlacementType.INLINE)
      return true;
    return this.w.a(localActivity, getCurrentWebView());
  }

  @VisibleForTesting
  boolean a(ConsoleMessage paramConsoleMessage)
  {
    if (this.m != null)
      return this.m.onConsoleMessage(paramConsoleMessage);
    return true;
  }

  @VisibleForTesting
  boolean a(b paramb)
  {
    if (paramb == b.NONE);
    ActivityInfo localActivityInfo;
    do
    {
      return true;
      Activity localActivity = (Activity)this.b.get();
      if (localActivity == null)
        return false;
      while (true)
      {
        try
        {
          localActivityInfo = localActivity.getPackageManager().getActivityInfo(new ComponentName(localActivity, localActivity.getClass()), 0);
          int i1 = localActivityInfo.screenOrientation;
          if (i1 == -1)
            break;
          if (i1 == paramb.a())
          {
            bool = true;
            return bool;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          return false;
        }
        boolean bool = false;
      }
    }
    while ((Utils.bitMaskContainsFlag(localActivityInfo.configChanges, 128)) && (Utils.bitMaskContainsFlag(localActivityInfo.configChanges, 1024)));
    return false;
  }

  @VisibleForTesting
  boolean a(String paramString, JsResult paramJsResult)
  {
    if (this.m != null)
      return this.m.onJsAlert(paramString, paramJsResult);
    paramJsResult.confirm();
    return true;
  }

  @VisibleForTesting
  void b()
  {
    this.p.a(this.w.b(this.c), this.w.a(this.c), MraidNativeCommandHandler.c(this.c), MraidNativeCommandHandler.isStorePictureSupported(this.c), a());
    this.p.a(this.d);
    this.p.a(this.p.d());
    this.p.notifyScreenMetrics(this.i);
    a(ViewState.DEFAULT);
    this.p.b();
  }

  @VisibleForTesting
  void b(int paramInt)
    throws a
  {
    Activity localActivity = (Activity)this.b.get();
    if ((localActivity == null) || (!a(this.v)))
      throw new a("Attempted to lock orientation to unsupported value: " + this.v.name());
    if (this.s == null)
      this.s = Integer.valueOf(localActivity.getRequestedOrientation());
    localActivity.setRequestedOrientation(paramInt);
  }

  @VisibleForTesting
  void b(String paramString)
  {
    if (this.k != null)
      this.k.onOpen();
    UrlHandler.Builder localBuilder = new UrlHandler.Builder();
    if (this.a != null)
      localBuilder.withDspCreativeId(this.a.getDspCreativeId());
    UrlAction localUrlAction = UrlAction.IGNORE_ABOUT_SCHEME;
    UrlAction[] arrayOfUrlAction = new UrlAction[5];
    arrayOfUrlAction[0] = UrlAction.OPEN_NATIVE_BROWSER;
    arrayOfUrlAction[1] = UrlAction.OPEN_IN_APP_BROWSER;
    arrayOfUrlAction[2] = UrlAction.HANDLE_SHARE_TWEET;
    arrayOfUrlAction[3] = UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK;
    arrayOfUrlAction[4] = UrlAction.FOLLOW_DEEP_LINK;
    EnumSet localEnumSet = EnumSet.of(localUrlAction, arrayOfUrlAction);
    if (ManifestUtils.isDebuggable(this.c))
    {
      localEnumSet.add(UrlAction.HANDLE_MOPUB_SCHEME);
      localBuilder.withMoPubSchemeListener(this.t);
    }
    localBuilder.withSupportedUrlActions(localEnumSet).build().handleUrl(this.c, paramString);
  }

  @VisibleForTesting
  void c()
  {
    a(new Runnable()
    {
      public void run()
      {
        MraidBridge localMraidBridge = MraidController.d(MraidController.this);
        boolean bool1 = MraidController.g(MraidController.this).b(MraidController.f(MraidController.this));
        boolean bool2 = MraidController.g(MraidController.this).a(MraidController.f(MraidController.this));
        MraidController.g(MraidController.this);
        boolean bool3 = MraidNativeCommandHandler.c(MraidController.f(MraidController.this));
        MraidController.g(MraidController.this);
        localMraidBridge.a(bool1, bool2, bool3, MraidNativeCommandHandler.isStorePictureSupported(MraidController.f(MraidController.this)), MraidController.this.a());
        MraidController.d(MraidController.this).a(MraidController.h(MraidController.this));
        MraidController.d(MraidController.this).a(MraidController.i(MraidController.this));
        MraidController.d(MraidController.this).a(MraidController.d(MraidController.this).d());
        MraidController.d(MraidController.this).b();
      }
    });
  }

  @VisibleForTesting
  protected void d()
  {
    if (this.n == null);
    do
    {
      do
        return;
      while ((this.j == ViewState.LOADING) || (this.j == ViewState.HIDDEN));
      if ((this.j == ViewState.EXPANDED) || (this.d == PlacementType.INTERSTITIAL))
        f();
      if ((this.j == ViewState.RESIZED) || (this.j == ViewState.EXPANDED))
      {
        if ((this.q.e()) && (this.o != null))
        {
          MraidBridge.MraidWebView localMraidWebView = this.o;
          j();
          this.f.removeView(localMraidWebView);
        }
        while (true)
        {
          Views.removeFromParent(this.f);
          a(ViewState.DEFAULT);
          return;
          this.f.removeView(this.n);
          this.e.addView(this.n, new FrameLayout.LayoutParams(-1, -1));
          this.e.setVisibility(0);
        }
      }
    }
    while (this.j != ViewState.DEFAULT);
    this.e.setVisibility(4);
    a(ViewState.HIDDEN);
  }

  public void destroy()
  {
    this.h.a();
    try
    {
      this.r.unregister();
      if (!this.x)
        pause(true);
      Views.removeFromParent(this.f);
      i();
      j();
      f();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (localIllegalArgumentException.getMessage().contains("Receiver not registered"));
      throw localIllegalArgumentException;
    }
  }

  @VisibleForTesting
  void e()
    throws a
  {
    if (this.v == b.NONE)
    {
      if (this.u)
      {
        f();
        return;
      }
      Activity localActivity = (Activity)this.b.get();
      if (localActivity == null)
        throw new a("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
      b(DeviceUtils.getScreenOrientation(localActivity));
      return;
    }
    b(this.v.a());
  }

  @VisibleForTesting
  void f()
  {
    Activity localActivity = (Activity)this.b.get();
    if ((localActivity != null) && (this.s != null))
      localActivity.setRequestedOrientation(this.s.intValue());
    this.s = null;
  }

  public void fillContent(String paramString, MraidWebViewCacheListener paramMraidWebViewCacheListener)
  {
    Preconditions.checkNotNull(paramString, "htmlData cannot be null");
    this.n = new MraidBridge.MraidWebView(this.c);
    this.n.enablePlugins(true);
    if (paramMraidWebViewCacheListener != null)
      paramMraidWebViewCacheListener.onReady(this.n, null);
    this.p.a(this.n);
    this.e.addView(this.n, new FrameLayout.LayoutParams(-1, -1));
    this.p.setContentHtml(paramString);
  }

  WeakReference<Activity> g()
  {
    return this.b;
  }

  public FrameLayout getAdContainer()
  {
    return this.e;
  }

  public Context getContext()
  {
    return this.c;
  }

  public MraidBridge.MraidWebView getCurrentWebView()
  {
    if (this.q.e())
      return this.o;
    return this.n;
  }

  public void loadJavascript(String paramString)
  {
    this.p.a(paramString);
  }

  public void onPreloadFinished(BaseWebView paramBaseWebView)
  {
    this.n = ((MraidBridge.MraidWebView)paramBaseWebView);
    this.n.enablePlugins(true);
    this.p.a(this.n);
    this.e.addView(this.n, new FrameLayout.LayoutParams(-1, -1));
    b();
  }

  public void onShow(Activity paramActivity)
  {
    this.b = new WeakReference(paramActivity);
    if (this.l != null)
      this.l.useCustomCloseChanged(m());
    try
    {
      e();
      return;
    }
    catch (a locala)
    {
      MoPubLog.d("Failed to apply orientation.");
    }
  }

  public void pause(boolean paramBoolean)
  {
    this.x = true;
    if (this.n != null)
      WebViews.onPause(this.n, paramBoolean);
    if (this.o != null)
      WebViews.onPause(this.o, paramBoolean);
  }

  public void resume()
  {
    this.x = false;
    if (this.n != null)
      this.n.onResume();
    if (this.o != null)
      this.o.onResume();
  }

  public void setDebugListener(MraidWebViewDebugListener paramMraidWebViewDebugListener)
  {
    this.m = paramMraidWebViewDebugListener;
  }

  public void setMraidListener(MraidListener paramMraidListener)
  {
    this.k = paramMraidListener;
  }

  public void setUseCustomCloseListener(UseCustomCloseListener paramUseCustomCloseListener)
  {
    this.l = paramUseCustomCloseListener;
  }

  public static abstract interface MraidListener
  {
    public abstract void onClose();

    public abstract void onExpand();

    public abstract void onFailedToLoad();

    public abstract void onLoaded(View paramView);

    public abstract void onOpen();

    public abstract void onRenderProcessGone(MoPubErrorCode paramMoPubErrorCode);

    public abstract void onResize(boolean paramBoolean);
  }

  public static abstract interface MraidWebViewCacheListener
  {
    public abstract void onReady(MraidBridge.MraidWebView paramMraidWebView, ExternalViewabilitySessionManager paramExternalViewabilitySessionManager);
  }

  public static abstract interface UseCustomCloseListener
  {
    public abstract void useCustomCloseChanged(boolean paramBoolean);
  }

  @VisibleForTesting
  class a extends BroadcastReceiver
  {
    private Context b;
    private int c = -1;

    a()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (this.b == null);
      int i;
      do
      {
        do
          return;
        while (!"android.intent.action.CONFIGURATION_CHANGED".equals(paramIntent.getAction()));
        i = MraidController.l(MraidController.this);
      }
      while (i == this.c);
      this.c = i;
      MraidController.this.a(this.c);
    }

    public void register(Context paramContext)
    {
      Preconditions.checkNotNull(paramContext);
      this.b = paramContext.getApplicationContext();
      if (this.b != null)
        this.b.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }

    public void unregister()
    {
      if (this.b != null)
      {
        this.b.unregisterReceiver(this);
        this.b = null;
      }
    }
  }

  @VisibleForTesting
  static class b
  {
    private final Handler a = new Handler();
    private a b;

    a a(View[] paramArrayOfView)
    {
      this.b = new a(this.a, paramArrayOfView, null);
      return this.b;
    }

    void a()
    {
      if (this.b != null)
      {
        this.b.a();
        this.b = null;
      }
    }

    static class a
    {
      int a;
      private final View[] b;
      private final Handler c;
      private Runnable d;
      private final Runnable e = new Runnable()
      {
        public void run()
        {
          View[] arrayOfView = MraidController.b.a.a(MraidController.b.a.this);
          int i = arrayOfView.length;
          int j = 0;
          if (j < i)
          {
            final View localView = arrayOfView[j];
            if ((localView.getHeight() > 0) || (localView.getWidth() > 0))
              MraidController.b.a.b(MraidController.b.a.this);
            while (true)
            {
              j++;
              break;
              localView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
              {
                public boolean onPreDraw()
                {
                  localView.getViewTreeObserver().removeOnPreDrawListener(this);
                  MraidController.b.a.b(MraidController.b.a.this);
                  return true;
                }
              });
            }
          }
        }
      };

      private a(Handler paramHandler, View[] paramArrayOfView)
      {
        this.c = paramHandler;
        this.b = paramArrayOfView;
      }

      private void b()
      {
        this.a = (-1 + this.a);
        if ((this.a == 0) && (this.d != null))
        {
          this.d.run();
          this.d = null;
        }
      }

      void a()
      {
        this.c.removeCallbacks(this.e);
        this.d = null;
      }

      void a(Runnable paramRunnable)
      {
        this.d = paramRunnable;
        this.a = this.b.length;
        this.c.post(this.e);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.MraidController
 * JD-Core Version:    0.6.2
 */