package com.appnexus.opensdk;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import com.appnexus.opensdk.transitionanimation.Animator;
import com.appnexus.opensdk.transitionanimation.TransitionDirection;
import com.appnexus.opensdk.transitionanimation.TransitionType;
import com.appnexus.opensdk.ut.UTRequestParameters;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.Settings;
import com.appnexus.opensdk.utils.WebviewUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class BannerAdView extends AdView
{
  private boolean A;
  private boolean B;
  private Animator C;
  private boolean D;
  private i E;
  private AdAlignment F;
  protected boolean s;
  protected int t;
  protected int u;
  private int v;
  private boolean w;
  private boolean x;
  private BroadcastReceiver y;
  private boolean z;

  public BannerAdView(Context paramContext)
  {
    super(paramContext);
  }

  public BannerAdView(Context paramContext, int paramInt)
  {
    super(paramContext);
    setAutoRefreshInterval(paramInt);
  }

  public BannerAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public BannerAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0) && (this.j.getSizes() != null))
    {
      Iterator localIterator = this.j.getSizes().iterator();
      while (localIterator.hasNext())
      {
        AdSize localAdSize = (AdSize)localIterator.next();
        if ((paramInt2 < localAdSize.height()) || (paramInt1 < localAdSize.width()))
          Clog.w(Clog.baseLogTag, Clog.getString(R.string.adsize_too_big, paramInt1, paramInt2, localAdSize.width(), localAdSize.height()));
      }
    }
  }

  private void k()
  {
    this.w = false;
    this.v = 30000;
    this.x = false;
    this.D = false;
  }

  private void l()
  {
    if (this.y != null)
      return;
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    this.y = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        int i = 1;
        if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
        {
          BannerAdView.this.j();
          Clog.d(Clog.baseLogTag, Clog.getString(R.string.screen_off_stop));
        }
        while (true)
        {
          return;
          if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_ON"))
          {
            if (BannerAdView.a(BannerAdView.this) > 0)
              BannerAdView.this.i();
            while (i != 0)
            {
              Clog.d(Clog.baseLogTag, Clog.getString(R.string.screen_on_start));
              return;
              if (BannerAdView.b(BannerAdView.this))
              {
                BannerAdView.this.j();
                BannerAdView.this.i();
              }
              else
              {
                i = 0;
              }
            }
          }
        }
      }
    };
    getContext().registerReceiver(this.y, localIntentFilter);
  }

  private void m()
  {
    if (this.v > 0)
      l();
  }

  private void n()
  {
    if (this.y == null)
      return;
    try
    {
      getContext().unregisterReceiver(this.y);
      label19: this.y = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label19;
    }
  }

  @SuppressLint({"NewApi"})
  protected void a(int paramInt1, int paramInt2, f paramf)
  {
    int i;
    if (getWidth() <= 0)
    {
      i = getMeasuredWidth();
      if (getHeight() > 0)
        break label54;
    }
    label54: for (int j = getMeasuredHeight(); ; j = getHeight())
    {
      if ((j > 0) && (i > 0))
        break label63;
      Clog.w(Clog.baseLogTag, "Unable to resize ad to fit container because of failure to obtain the container size.");
      return;
      i = getWidth();
      break;
    }
    label63: int m;
    int n;
    if (paramInt1 / i < paramInt2 / j)
    {
      int i1 = paramInt1 * j / paramInt2;
      paramf.setInitialScale((int)Math.ceil(j * 100 / paramInt2));
      int i2 = j;
      m = i1;
      n = i2;
      if (paramf.getLayoutParams() != null)
        break label188;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(m, n);
      localLayoutParams.gravity = 17;
      paramf.setLayoutParams(localLayoutParams);
    }
    while (true)
    {
      paramf.invalidate();
      return;
      int k = paramInt2 * i / paramInt1;
      paramf.setInitialScale((int)Math.ceil(i * 100 / paramInt1));
      m = i;
      n = k;
      break;
      label188: paramf.getLayoutParams().width = m;
      paramf.getLayoutParams().height = n;
      ((FrameLayout.LayoutParams)paramf.getLayoutParams()).gravity = 17;
    }
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.v = 30000;
    this.s = false;
    this.z = false;
    this.A = false;
    this.B = false;
    this.C = new Animator(getContext(), TransitionType.NONE, TransitionDirection.UP, 1000L);
    super.a(paramContext, paramAttributeSet);
    m();
    this.j.setMediaType(MediaType.BANNER);
    this.a.a(this.v);
    if (this.D)
      this.a.b();
  }

  protected void a(i parami)
  {
    if ((parami == null) || (parami.j()) || (parami.i() == null))
    {
      Clog.e(Clog.baseLogTag, "Loaded an ad with an invalid displayable");
      return;
    }
    this.E = parami;
    if (getTransitionType() == TransitionType.NONE)
    {
      removeAllViews();
      if (this.g != null)
        this.g.destroy();
      View localView = parami.i();
      addView(localView);
      if (localView.getLayoutParams() != null)
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = getAdAlignment().a();
    }
    while (true)
    {
      b();
      this.g = parami;
      return;
      if ((getChildCount() == 0) || (indexOfChild(this.C) > -1))
      {
        removeAllViews();
        addView(this.C);
      }
      this.C.addView(parami.i());
      if (parami.i().getLayoutParams() != null)
      {
        ((FrameLayout.LayoutParams)parami.i().getLayoutParams()).gravity = getAdAlignment().a();
        this.C.setLayoutParams(parami.i().getLayoutParams());
      }
      this.C.showNext();
      i locali = this.g;
      if (locali != null)
        if (locali.i().getAnimation() != null)
          locali.i().getAnimation().setAnimationListener(new a(locali, this.C));
        else
          locali.destroy();
    }
  }

  protected void a(q paramq)
  {
    a(paramq);
  }

  public void activityOnDestroy()
  {
    if (this.E != null)
    {
      this.E.m();
      this.E = null;
    }
    n();
    if (this.a != null)
      j();
  }

  public void activityOnPause()
  {
    if (this.E != null)
      this.E.onPause();
  }

  public void activityOnResume()
  {
    if (this.E != null)
      this.E.onResume();
  }

  protected void b()
  {
    super.b();
  }

  @SuppressLint({"NewApi"})
  protected void b(int paramInt1, int paramInt2, f paramf)
  {
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    int i;
    float f;
    if (Build.VERSION.SDK_INT >= 13)
    {
      Point localPoint = new Point();
      localDisplay.getSize(localPoint);
      i = localPoint.x;
      f = i / paramInt1;
      int j = (int)Math.floor(f * paramInt2);
      this.t = getLayoutParams().height;
      this.u = getLayoutParams().width;
      if ((getLayoutParams().width > 0) || (getLayoutParams().width == -2))
        getLayoutParams().width = i;
      getLayoutParams().height = j;
      if (paramf.getLayoutParams() != null)
        break label188;
      paramf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }
    while (true)
    {
      paramf.setInitialScale((int)Math.ceil(100.0F * f));
      paramf.invalidate();
      this.s = true;
      return;
      i = localDisplay.getWidth();
      break;
      label188: paramf.getLayoutParams().width = -1;
      paramf.getLayoutParams().height = -1;
    }
  }

  protected void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    k();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BannerAdView);
    int i = localTypedArray.getIndexCount();
    Clog.v(Clog.xmlLogTag, Clog.getString(R.string.found_n_in_xml, i));
    int j = 0;
    int k = -1;
    int m = -1;
    if (j < i)
    {
      int n = localTypedArray.getIndex(j);
      if (n == R.styleable.BannerAdView_placement_id)
      {
        setPlacementID(localTypedArray.getString(n));
        Clog.d(Clog.xmlLogTag, Clog.getString(R.string.placement_id, localTypedArray.getString(n)));
      }
      while (true)
      {
        j++;
        break;
        if (n == R.styleable.BannerAdView_auto_refresh_interval)
        {
          int i1 = localTypedArray.getInt(n, 30000);
          setAutoRefreshInterval(i1);
          if (i1 <= 0)
            this.D = true;
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_set_period, i1));
        }
        else if (n == R.styleable.BannerAdView_test)
        {
          Settings.getSettings().test_mode = localTypedArray.getBoolean(n, false);
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_set_test, Settings.getSettings().test_mode));
        }
        else if (n == R.styleable.BannerAdView_adWidth)
        {
          m = localTypedArray.getInt(n, -1);
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_ad_width, localTypedArray.getInt(n, -1)));
        }
        else if (n == R.styleable.BannerAdView_adHeight)
        {
          k = localTypedArray.getInt(n, -1);
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_ad_height, localTypedArray.getInt(n, -1)));
        }
        else if (n == R.styleable.BannerAdView_should_reload_on_resume)
        {
          setShouldReloadOnResume(localTypedArray.getBoolean(n, false));
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_set_should_reload, this.x));
        }
        else if (n == R.styleable.BannerAdView_opens_native_browser)
        {
          setOpensNativeBrowser(localTypedArray.getBoolean(n, false));
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_set_opens_native_browser, getOpensNativeBrowser()));
        }
        else if (n == R.styleable.BannerAdView_expands_to_fit_screen_width)
        {
          setExpandsToFitScreenWidth(localTypedArray.getBoolean(n, false));
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_set_expands_to_full_screen_width, this.z));
        }
        else if (n == R.styleable.BannerAdView_resize_ad_to_fit_container)
        {
          setResizeAdToFitContainer(localTypedArray.getBoolean(n, false));
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_resize_ad_to_fit_container, this.A));
        }
        else if (n == R.styleable.BannerAdView_show_loading_indicator)
        {
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.show_loading_indicator_xml));
          setShowLoadingIndicator(localTypedArray.getBoolean(n, true));
        }
        else if (n == R.styleable.BannerAdView_transition_type)
        {
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.transition_type));
          setTransitionType(TransitionType.getTypeForInt(localTypedArray.getInt(n, 0)));
        }
        else if (n == R.styleable.BannerAdView_transition_direction)
        {
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.transition_direction));
          setTransitionDirection(TransitionDirection.getDirectionForInt(localTypedArray.getInt(n, 0)));
        }
        else if (n == R.styleable.BannerAdView_transition_duration)
        {
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.transition_duration));
          setTransitionDuration(localTypedArray.getInt(n, 1000));
        }
        else if (n == R.styleable.BannerAdView_load_landing_page_in_background)
        {
          setLoadsInBackground(localTypedArray.getBoolean(n, true));
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_load_landing_page_in_background, getLoadsInBackground()));
        }
      }
    }
    if ((m != -1) && (k != -1))
      setAdSize(m, k);
    localTypedArray.recycle();
  }

  boolean d()
  {
    return true;
  }

  public void destroy()
  {
    super.destroy();
  }

  boolean e()
  {
    return false;
  }

  public AdAlignment getAdAlignment()
  {
    if (this.F == null)
      this.F = AdAlignment.CENTER;
    return this.F;
  }

  public int getAdHeight()
  {
    String str = Clog.baseLogTag;
    int i = R.string.get_height;
    if (this.j.getAllowSmallerSizes());
    for (long l = -1L; ; l = this.j.getPrimarySize().height())
    {
      Clog.d(str, Clog.getString(i, l));
      if (!this.j.getAllowSmallerSizes())
        break;
      return -1;
    }
    return this.j.getPrimarySize().height();
  }

  public ArrayList<AdSize> getAdSizes()
  {
    Clog.d(Clog.baseLogTag, Clog.getString(R.string.get_ad_sizes));
    if (this.j.getAllowSmallerSizes())
      return new ArrayList();
    return this.j.getSizes();
  }

  public int getAdWidth()
  {
    String str = Clog.baseLogTag;
    int i = R.string.get_width;
    if (this.j.getAllowSmallerSizes());
    for (long l = -1L; ; l = this.j.getPrimarySize().width())
    {
      Clog.d(str, Clog.getString(i, l));
      if (!this.j.getAllowSmallerSizes())
        break;
      return -1;
    }
    return this.j.getPrimarySize().width();
  }

  public boolean getAllowNativeDemand()
  {
    return this.j.isBannerNativeEnabled();
  }

  public boolean getAllowVideoDemand()
  {
    return this.j.isBannerVideoEnabled();
  }

  public int getAutoRefreshInterval()
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.get_period, this.v));
    return this.v;
  }

  public boolean getExpandsToFitScreenWidth()
  {
    return this.z;
  }

  public int getMaxHeight()
  {
    String str = Clog.baseLogTag;
    int i = R.string.get_max_height;
    if (this.j.getAllowSmallerSizes());
    for (long l = this.j.getPrimarySize().height(); ; l = -1L)
    {
      Clog.d(str, Clog.getString(i, l));
      if (!this.j.getAllowSmallerSizes())
        break;
      return this.j.getPrimarySize().height();
    }
    return -1;
  }

  public int getMaxWidth()
  {
    String str = Clog.baseLogTag;
    int i = R.string.get_max_width;
    if (this.j.getAllowSmallerSizes());
    for (long l = this.j.getPrimarySize().width(); ; l = -1L)
    {
      Clog.d(str, Clog.getString(i, l));
      if (!this.j.getAllowSmallerSizes())
        break;
      return this.j.getPrimarySize().width();
    }
    return -1;
  }

  public MediaType getMediaType()
  {
    return MediaType.BANNER;
  }

  public boolean getResizeAdToFitContainer()
  {
    return this.A;
  }

  public boolean getShouldReloadOnResume()
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.get_should_resume, this.x));
    return this.x;
  }

  public TransitionDirection getTransitionDirection()
  {
    return this.C.getTransitionDirection();
  }

  public long getTransitionDuration()
  {
    return this.C.getTransitionDuration();
  }

  public TransitionType getTransitionType()
  {
    return this.C.getTransitionType();
  }

  void h()
  {
  }

  void i()
  {
    Clog.d("BannerAdView", getAdType().name());
    if (getAdType() != AdType.VIDEO)
    {
      Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.start));
      this.a.b();
      this.w = true;
    }
  }

  void j()
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.stop));
    this.a.a();
    this.w = false;
  }

  public boolean loadAd()
  {
    this.w = true;
    if (super.loadAd())
      return true;
    this.w = false;
    return false;
  }

  public boolean loadAd(String paramString, int paramInt1, int paramInt2)
  {
    setAdSize(paramInt1, paramInt2);
    setPlacementID(paramString);
    return loadAd();
  }

  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b)
      this.b = false;
    do
    {
      do
      {
        return;
        if ((!this.B) || (paramBoolean))
        {
          float f = getContext().getResources().getDisplayMetrics().density;
          a((int)(0.5F + (paramInt3 - paramInt1) / f), (int)(0.5F + (paramInt4 - paramInt2) / f));
          if ((!this.B) && (!this.h))
            c();
          if (getResizeAdToFitContainer())
            post(new Runnable()
            {
              public void run()
              {
                if ((BannerAdView.this.getChildAt(0) instanceof f))
                {
                  f localf = (f)BannerAdView.this.getChildAt(0);
                  BannerAdView.this.a(localf.k(), localf.l(), localf);
                  localf.requestLayout();
                }
              }
            });
          this.h = false;
          this.B = true;
        }
      }
      while (!this.w);
      l();
    }
    while (!this.x);
    i();
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0)
    {
      l();
      Clog.d(Clog.baseLogTag, Clog.getString(R.string.unhidden));
      if (((this.w) || (this.x) || (this.v > 0)) && (!this.m) && (!this.b) && (!a()) && (this.a != null) && (!this.h))
        i();
      this.m = false;
      if ((getChildAt(0) instanceof WebView))
        WebviewUtil.onResume((WebView)getChildAt(0));
    }
    do
    {
      return;
      n();
      Clog.d(Clog.baseLogTag, Clog.getString(R.string.hidden));
      if ((this.a != null) && (this.w))
        j();
    }
    while (!(getChildAt(0) instanceof WebView));
    WebviewUtil.onPause((WebView)getChildAt(0));
  }

  public void setAdAlignment(AdAlignment paramAdAlignment)
  {
    this.F = paramAdAlignment;
  }

  public void setAdSize(int paramInt1, int paramInt2)
  {
    Clog.d(Clog.baseLogTag, Clog.getString(R.string.set_size, paramInt1, paramInt2));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new AdSize(paramInt1, paramInt2));
    setAdSizes(localArrayList);
  }

  public void setAdSizes(ArrayList<AdSize> paramArrayList)
  {
    Clog.d(Clog.baseLogTag, Clog.getString(R.string.set_ad_sizes));
    if (paramArrayList == null)
    {
      Clog.e(Clog.baseLogTag, Clog.getString(R.string.set_ad_sizes_null));
      return;
    }
    if (paramArrayList.size() == 0)
    {
      Clog.e(Clog.baseLogTag, Clog.getString(R.string.set_ad_sizes_no_elements));
      return;
    }
    this.j.setPrimarySize((AdSize)paramArrayList.get(0));
    this.j.setSizes(paramArrayList);
    this.j.setAllowSmallerSizes(false);
  }

  public void setAllowNativeDemand(boolean paramBoolean)
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.set_allow_native, paramBoolean));
    this.j.setBannerNativeEnabled(paramBoolean);
  }

  public void setAllowVideoDemand(boolean paramBoolean)
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.set_allow_video, paramBoolean));
    this.j.setBannerVideoEnabled(paramBoolean);
  }

  public void setAutoRefreshInterval(int paramInt)
  {
    if (paramInt > 0);
    for (this.v = Math.max(15000, paramInt); ; this.v = paramInt)
    {
      Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.set_period, this.v));
      if (this.a != null)
        this.a.a(this.v);
      return;
    }
  }

  public void setExpandsToFitScreenWidth(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }

  public void setMaxSize(int paramInt1, int paramInt2)
  {
    Clog.d(Clog.baseLogTag, Clog.getString(R.string.set_max_size, paramInt1, paramInt2));
    AdSize localAdSize = new AdSize(paramInt1, paramInt2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localAdSize);
    this.j.setPrimarySize((AdSize)localArrayList.get(0));
    this.j.setSizes(localArrayList);
    this.j.setAllowSmallerSizes(true);
  }

  public void setResizeAdToFitContainer(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }

  public void setShouldReloadOnResume(boolean paramBoolean)
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.set_should_resume, paramBoolean));
    this.x = paramBoolean;
  }

  public void setTransitionDirection(TransitionDirection paramTransitionDirection)
  {
    this.C.setTransitionDirection(paramTransitionDirection);
  }

  public void setTransitionDuration(long paramLong)
  {
    this.C.setTransitionDuration(paramLong);
  }

  public void setTransitionType(TransitionType paramTransitionType)
  {
    this.C.setTransitionType(paramTransitionType);
  }

  public static enum AdAlignment
  {
    static
    {
      TOP_CENTER = new AdAlignment("TOP_CENTER", 1);
      TOP_RIGHT = new AdAlignment("TOP_RIGHT", 2);
      CENTER_LEFT = new AdAlignment("CENTER_LEFT", 3);
      CENTER = new AdAlignment("CENTER", 4);
      CENTER_RIGHT = new AdAlignment("CENTER_RIGHT", 5);
      BOTTOM_LEFT = new AdAlignment("BOTTOM_LEFT", 6);
      BOTTOM_CENTER = new AdAlignment("BOTTOM_CENTER", 7);
      BOTTOM_RIGHT = new AdAlignment("BOTTOM_RIGHT", 8);
      AdAlignment[] arrayOfAdAlignment = new AdAlignment[9];
      arrayOfAdAlignment[0] = TOP_LEFT;
      arrayOfAdAlignment[1] = TOP_CENTER;
      arrayOfAdAlignment[2] = TOP_RIGHT;
      arrayOfAdAlignment[3] = CENTER_LEFT;
      arrayOfAdAlignment[4] = CENTER;
      arrayOfAdAlignment[5] = CENTER_RIGHT;
      arrayOfAdAlignment[6] = BOTTOM_LEFT;
      arrayOfAdAlignment[7] = BOTTOM_CENTER;
      arrayOfAdAlignment[8] = BOTTOM_RIGHT;
    }

    int a()
    {
      switch (BannerAdView.3.a[ordinal()])
      {
      case 5:
      default:
        return 17;
      case 1:
        return 51;
      case 2:
        return 49;
      case 3:
        return 53;
      case 4:
        return 19;
      case 6:
        return 21;
      case 7:
        return 83;
      case 8:
        return 81;
      case 9:
      }
      return 85;
    }
  }

  class a
    implements Animation.AnimationListener
  {
    private final WeakReference<i> b;
    private final WeakReference<Animator> c;

    a(i paramAnimator, Animator arg3)
    {
      this.b = new WeakReference(paramAnimator);
      Object localObject;
      this.c = new WeakReference(localObject);
    }

    public void onAnimationEnd(Animation paramAnimation)
    {
      paramAnimation.setAnimationListener(null);
      final i locali = (i)this.b.get();
      final Animator localAnimator = (Animator)this.c.get();
      if ((locali != null) && (localAnimator != null))
        locali.i().getHandler().post(new Runnable()
        {
          public void run()
          {
            localAnimator.clearAnimation();
            locali.destroy();
            localAnimator.setAnimation();
          }
        });
    }

    public void onAnimationRepeat(Animation paramAnimation)
    {
    }

    public void onAnimationStart(Animation paramAnimation)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.BannerAdView
 * JD-Core Version:    0.6.2
 */