package com.appnexus.opensdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.appnexus.opensdk.ut.UTRequestParameters;
import com.appnexus.opensdk.ut.adresponse.BaseAdResponse;
import com.appnexus.opensdk.utils.AdvertisingIDUtil;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.HTTPGet;
import com.appnexus.opensdk.utils.HTTPResponse;
import com.appnexus.opensdk.utils.Settings;
import com.appnexus.opensdk.utils.ViewUtil;
import com.appnexus.opensdk.viewability.ANOmidViewabilty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class AdView extends FrameLayout
  implements b
{

  @SuppressLint({"StaticFieldLeak"})
  static FrameLayout o;

  @SuppressLint({"StaticFieldLeak"})
  static MRAIDImplementation p;
  static f.b q;
  d a;
  boolean b = false;
  int c;
  int d;
  String e = "";
  final Handler f = new Handler(Looper.getMainLooper());
  protected i g;
  boolean h = false;
  boolean i = false;
  UTRequestParameters j;
  protected ArrayList<String> k;
  protected ArrayList<String> l;
  boolean m = false;
  ImageButton n;
  int r = 0;
  private AdType s;
  private AdListener t;
  private AppEventListener u;
  private b v;
  private a w;
  private boolean x = false;
  private boolean y = true;
  private boolean z = false;

  AdView(Context paramContext)
  {
    this(paramContext, null);
  }

  AdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(int paramInt1, int paramInt2)
  {
    this.b = true;
    if (getLayoutParams() != null)
    {
      if (getLayoutParams().width > 0)
        getLayoutParams().width = paramInt1;
      if (getLayoutParams().height > 0)
        getLayoutParams().height = paramInt2;
    }
    if ((this.x) && ((getParent() instanceof View)))
    {
      View localView = (View)getParent();
      if (localView.getLayoutParams() != null)
      {
        if (localView.getLayoutParams().width > 0)
          localView.getLayoutParams().width = paramInt1;
        if (localView.getLayoutParams().height > 0)
          localView.getLayoutParams().height = paramInt2;
      }
    }
  }

  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, MRAIDImplementation.CUSTOM_CLOSE_POSITION paramCUSTOM_CLOSE_POSITION, boolean paramBoolean, final MRAIDImplementation paramMRAIDImplementation)
  {
    a(paramInt1, paramInt2);
    ViewUtil.removeChildFromParent(this.n);
    if (this.r <= 0)
      this.r = ((int)(50.0F * paramMRAIDImplementation.b.getContext().getResources().getDisplayMetrics().density));
    this.n = new ImageButton(getContext())
    {
      @SuppressLint({"NewApi", "DrawAllocation"})
      public void onLayout(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        int[] arrayOfInt1 = new int[2];
        getLocationOnScreen(arrayOfInt1);
        Point localPoint1 = new Point(0, 0);
        try
        {
          localActivity = (Activity)paramMRAIDImplementation.b.getContext();
          i = 1;
          if (i != 0)
          {
            if (Build.VERSION.SDK_INT >= 13)
              localActivity.getWindowManager().getDefaultDisplay().getSize(localPoint1);
          }
          else
          {
            arrayOfInt2 = new int[2];
            if (!AdView.this.getMediaType().equals(MediaType.INTERSTITIAL))
              break label387;
            InterstitialAdView.s.measure(0, 0);
            InterstitialAdView.s.getLocationOnScreen(arrayOfInt2);
            localPoint2 = new Point(InterstitialAdView.s.getMeasuredWidth(), InterstitialAdView.s.getMeasuredHeight());
            j = localPoint2.x - AdView.this.r;
            k = localPoint2.y - AdView.this.r;
            if (i == 0)
              break label431;
            m = arrayOfInt2[0] + Math.min(localPoint1.x, localPoint2.x) - AdView.this.r;
            n = arrayOfInt2[1] + Math.min(localPoint1.y, localPoint2.y) - AdView.this.r;
            i2 = arrayOfInt2[0];
            i1 = arrayOfInt2[1];
            if ((1 + arrayOfInt1[0] < i2) || (-1 + arrayOfInt1[0] > m) || (1 + arrayOfInt1[1] < i1) || (-1 + arrayOfInt1[1] > n))
            {
              final FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getLayoutParams());
              localLayoutParams.setMargins(0, 0, 0, 0);
              localLayoutParams.gravity = 51;
              post(new Runnable()
              {
                public void run()
                {
                  AdView.3.this.setLayoutParams(localLayoutParams);
                }
              });
              AdView.this.n.setImageDrawable(getResources().getDrawable(17301560));
            }
            return;
          }
        }
        catch (ClassCastException localClassCastException)
        {
          while (true)
          {
            int[] arrayOfInt2;
            int j;
            int k;
            Activity localActivity = null;
            int i = 0;
            continue;
            localPoint1.x = localActivity.getWindowManager().getDefaultDisplay().getWidth();
            localPoint1.y = localActivity.getWindowManager().getDefaultDisplay().getHeight();
            continue;
            label387: AdView.this.measure(0, 0);
            AdView.this.getLocationOnScreen(arrayOfInt2);
            Point localPoint2 = new Point(AdView.this.getMeasuredWidth(), AdView.this.getMeasuredHeight());
            continue;
            label431: int m = j;
            int n = k;
            int i1 = 0;
            int i2 = 0;
          }
        }
      }
    };
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.r, this.r, 17);
    int i1 = paramInt2 / 2 - this.r / 2;
    int i2 = paramInt1 / 2 - this.r / 2;
    switch (6.a[paramCUSTOM_CLOSE_POSITION.ordinal()])
    {
    case 4:
    default:
    case 1:
    case 2:
    case 3:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      this.n.setLayoutParams(localLayoutParams);
      this.n.setBackgroundColor(0);
      this.n.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramMRAIDImplementation.b();
        }
      });
      if (paramMRAIDImplementation.b.getParent() != null)
        ((ViewGroup)paramMRAIDImplementation.b.getParent()).addView(this.n);
      return;
      localLayoutParams.topMargin = i1;
      continue;
      localLayoutParams.rightMargin = i2;
      localLayoutParams.topMargin = i1;
      continue;
      localLayoutParams.leftMargin = i2;
      localLayoutParams.topMargin = i1;
      continue;
      localLayoutParams.bottomMargin = i1;
      continue;
      localLayoutParams.rightMargin = i2;
      localLayoutParams.bottomMargin = i1;
      continue;
      localLayoutParams.leftMargin = i2;
      localLayoutParams.bottomMargin = i1;
    }
  }

  protected void a(int paramInt1, int paramInt2, MRAIDImplementation paramMRAIDImplementation)
  {
    ViewUtil.removeChildFromParent(this.n);
    this.n = null;
    if (paramMRAIDImplementation.b.b)
    {
      ViewUtil.removeChildFromParent(paramMRAIDImplementation.b);
      if (paramMRAIDImplementation.e() != null)
        paramMRAIDImplementation.e().addView(paramMRAIDImplementation.b, 0);
      if (paramMRAIDImplementation.d() != null)
        paramMRAIDImplementation.d().finish();
      if ((getMediaType().equals(MediaType.BANNER)) && ((paramMRAIDImplementation.b.getContext() instanceof MutableContextWrapper)))
        ((MutableContextWrapper)paramMRAIDImplementation.b.getContext()).setBaseContext(getContext());
    }
    o = null;
    p = null;
    q = null;
    a(paramInt1, paramInt2);
    this.m = true;
    this.i = false;
  }

  void a(int paramInt1, int paramInt2, boolean paramBoolean, final MRAIDImplementation paramMRAIDImplementation, f.b paramb)
  {
    a(paramInt1, paramInt2);
    this.n = ViewUtil.createCloseButton(getContext(), paramBoolean);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.n.getLayoutParams();
    if ((!paramMRAIDImplementation.b.b) && (getChildAt(0) != null))
      localLayoutParams.rightMargin = ((getMeasuredWidth() - getChildAt(0).getMeasuredWidth()) / 2);
    this.n.setLayoutParams(localLayoutParams);
    this.n.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramMRAIDImplementation.b();
      }
    });
    if (paramMRAIDImplementation.b.b)
      a(paramMRAIDImplementation, paramBoolean, paramb);
    while (true)
    {
      this.i = true;
      return;
      addView(this.n);
    }
  }

  void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.w = new a(this.f);
    this.j = new UTRequestParameters(paramContext);
    this.s = AdType.UNKNOWN;
    AdvertisingIDUtil.retrieveAndSetAAID(paramContext);
    ANOmidViewabilty.getInstance().activateOmidAndCreatePartner(paramContext.getApplicationContext());
    Clog.setErrorContext(getContext());
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.new_adview));
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    if (localSharedPreferences.getBoolean("opensdk_first_launch", true))
    {
      Clog.v(Clog.baseLogTag, Clog.getString(R.string.first_opensdk_launch));
      Settings.getSettings().first_launch = true;
      localSharedPreferences.edit().putBoolean("opensdk_first_launch", false).commit();
    }
    try
    {
      while (true)
      {
        Settings.getSettings().ua = new WebView(paramContext).getSettings().getUserAgentString();
        Clog.v(Clog.baseLogTag, Clog.getString(R.string.ua, Settings.getSettings().ua));
        Settings.getSettings().app_id = paramContext.getApplicationContext().getPackageName();
        Clog.v(Clog.baseLogTag, Clog.getString(R.string.appid, Settings.getSettings().app_id));
        Clog.v(Clog.baseLogTag, Clog.getString(R.string.making_adman));
        setPadding(0, 0, 0, 0);
        this.a = new d(this);
        if (paramAttributeSet != null)
          b(paramContext, paramAttributeSet);
        return;
        Clog.v(Clog.baseLogTag, Clog.getString(R.string.not_first_opensdk_launch));
        Settings.getSettings().first_launch = false;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Settings.getSettings().ua = "";
        Clog.e(Clog.baseLogTag, " Exception: " + localException.getMessage());
      }
    }
  }

  protected void a(final MRAIDImplementation paramMRAIDImplementation, boolean paramBoolean, f.b paramb)
  {
    paramMRAIDImplementation.a((ViewGroup)paramMRAIDImplementation.b.getParent());
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    ViewUtil.removeChildFromParent(paramMRAIDImplementation.b);
    localFrameLayout.addView(paramMRAIDImplementation.b);
    if (this.n == null)
    {
      this.n = ViewUtil.createCloseButton(getContext(), paramBoolean);
      this.n.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramMRAIDImplementation.b();
        }
      });
    }
    localFrameLayout.addView(this.n);
    o = localFrameLayout;
    p = paramMRAIDImplementation;
    q = paramb;
    Class localClass = AdActivity.getActivityClass();
    try
    {
      Intent localIntent = new Intent(getContext(), localClass);
      localIntent.putExtra("ACTIVITY_TYPE", "MRAID");
      getContext().startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Clog.e(Clog.baseLogTag, Clog.getString(R.string.adactivity_missing, localClass.getName()));
      o = null;
      p = null;
      q = null;
    }
  }

  protected abstract void a(i parami);

  protected abstract void a(q paramq);

  void a(final String paramString)
  {
    new HTTPGet()
    {
      protected String a()
      {
        return paramString;
      }

      protected void a(HTTPResponse paramAnonymousHTTPResponse)
      {
        if ((paramAnonymousHTTPResponse != null) && (paramAnonymousHTTPResponse.getSucceeded()))
          Clog.d(Clog.baseLogTag, "Impression Tracked successfully!");
      }
    }
    .execute(new Void[0]);
  }

  boolean a()
  {
    return this.i;
  }

  public abstract void activityOnDestroy();

  public abstract void activityOnPause();

  public abstract void activityOnResume();

  public void addCustomKeywords(String paramString1, String paramString2)
  {
    this.j.addCustomKeywords(paramString1, paramString2);
  }

  void b()
  {
    if (getVisibility() != 0)
      setVisibility(0);
  }

  protected abstract void b(Context paramContext, AttributeSet paramAttributeSet);

  void c()
  {
    if (getVisibility() != 8)
      setVisibility(8);
  }

  public void clearCustomKeywords()
  {
    this.j.clearCustomKeywords();
  }

  abstract boolean d();

  public void destroy()
  {
    Clog.d(Clog.baseLogTag, "called destroy() on AdView");
    if (this.g != null)
    {
      this.g.destroy();
      this.g = null;
    }
    if (this.a != null)
      this.a.a();
  }

  abstract boolean e();

  void f()
  {
    while (true)
    {
      SharedNetworkManager localSharedNetworkManager;
      String str;
      synchronized (this.k)
      {
        localSharedNetworkManager = SharedNetworkManager.getInstance(getContext());
        if ((this.k == null) || (this.k.size() <= 0))
          break label106;
        Iterator localIterator = this.k.iterator();
        if (!localIterator.hasNext())
          break;
        str = (String)localIterator.next();
        if (localSharedNetworkManager.isConnected(getContext()))
          a(str);
      }
      localSharedNetworkManager.a(str, getContext());
    }
    this.k = null;
    label106: if (this.g != null)
      this.g.n();
  }

  boolean g()
  {
    if (Build.VERSION.SDK_INT >= 19)
      return isAttachedToWindow();
    return this.z;
  }

  public c getAdDispatcher()
  {
    return this.w;
  }

  public AdListener getAdListener()
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.get_ad_listener));
    return this.t;
  }

  public AdType getAdType()
  {
    return this.s;
  }

  public String getAge()
  {
    return this.j.getAge();
  }

  public AppEventListener getAppEventListener()
  {
    return this.u;
  }

  b getBrowserStyle()
  {
    return this.v;
  }

  public ANClickThroughAction getClickThroughAction()
  {
    return this.j.getClickThroughAction();
  }

  public int getCreativeHeight()
  {
    return this.d;
  }

  public String getCreativeId()
  {
    return this.e;
  }

  public int getCreativeWidth()
  {
    return this.c;
  }

  public ArrayList<Pair<String, String>> getCustomKeywords()
  {
    return this.j.getCustomKeywords();
  }

  public String getExternalUid()
  {
    return this.j.getExternalUid();
  }

  public GENDER getGender()
  {
    return this.j.getGender();
  }

  public List<String> getImpressionUrls()
  {
    if (this.l != null)
      return this.l;
    return Collections.emptyList();
  }

  public String getInventoryCode()
  {
    return this.j.getInvCode();
  }

  public boolean getLoadsInBackground()
  {
    return this.j.getLoadsInBackground();
  }

  public int getMemberID()
  {
    return this.j.getMemberID();
  }

  public boolean getOpensNativeBrowser()
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.get_opens_native_browser, this.j.getOpensNativeBrowser()));
    return this.j.getOpensNativeBrowser();
  }

  public String getPlacementID()
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.get_placement_id, this.j.getPlacementID()));
    return this.j.getPlacementID();
  }

  public UTRequestParameters getRequestParameters()
  {
    return this.j;
  }

  public float getReserve()
  {
    return this.j.getReserve();
  }

  public boolean getShouldServePSAs()
  {
    return this.j.getShouldServePSAs();
  }

  public boolean getShowLoadingIndicator()
  {
    return this.y;
  }

  abstract void h();

  public boolean isReadyToStart()
  {
    if (a())
    {
      Clog.e(Clog.baseLogTag, Clog.getString(R.string.already_expanded));
      return false;
    }
    return this.j.isReadyForRequest();
  }

  public boolean loadAd()
  {
    if (!isReadyToStart());
    while (this.a == null)
      return false;
    this.a.a();
    this.a.c();
    this.a.b();
    if (getWindowVisibility() != 0)
      this.h = true;
    return true;
  }

  public boolean loadAd(String paramString)
  {
    this.j.setPlacementID(paramString);
    return loadAd();
  }

  @Deprecated
  public void loadAdOffscreen()
  {
    loadAd();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.z = true;
    if ((getMediaType().equals(MediaType.BANNER)) && (this.k != null) && (this.k.size() > 0))
      f();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.z = false;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void removeCustomKeyword(String paramString)
  {
    this.j.removeCustomKeyword(paramString);
  }

  public void setAdListener(AdListener paramAdListener)
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.set_ad_listener));
    this.t = paramAdListener;
  }

  void setAdType(AdType paramAdType)
  {
    this.s = paramAdType;
  }

  public void setAge(String paramString)
  {
    this.j.setAge(paramString);
  }

  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.u = paramAppEventListener;
  }

  protected void setBrowserStyle(b paramb)
  {
    this.v = paramb;
  }

  public void setClickThroughAction(ANClickThroughAction paramANClickThroughAction)
  {
    this.j.setClickThroughAction(paramANClickThroughAction);
  }

  void setCreativeHeight(int paramInt)
  {
    this.d = paramInt;
  }

  void setCreativeId(String paramString)
  {
    this.e = paramString;
  }

  void setCreativeWidth(int paramInt)
  {
    this.c = paramInt;
  }

  public void setExternalUid(String paramString)
  {
    this.j.setExternalUid(paramString);
  }

  public void setGender(GENDER paramGENDER)
  {
    this.j.setGender(paramGENDER);
  }

  public void setInventoryCodeAndMemberID(int paramInt, String paramString)
  {
    this.j.setInventoryCodeAndMemberID(paramInt, paramString);
  }

  public void setLoadsInBackground(boolean paramBoolean)
  {
    this.j.setLoadsInBackground(paramBoolean);
  }

  public void setOpensNativeBrowser(boolean paramBoolean)
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.set_opens_native_browser, paramBoolean));
    this.j.setOpensNativeBrowser(paramBoolean);
  }

  public void setPlacementID(String paramString)
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.set_placement_id, paramString));
    this.j.setPlacementID(paramString);
  }

  public void setReserve(float paramFloat)
  {
    this.j.setReserve(paramFloat);
  }

  protected void setShouldResizeParent(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }

  public void setShouldServePSAs(boolean paramBoolean)
  {
    this.j.setShouldServePSAs(paramBoolean);
  }

  public void setShowLoadingIndicator(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }

  public static enum GENDER
  {
    static
    {
      MALE = new GENDER("MALE", 1);
      FEMALE = new GENDER("FEMALE", 2);
      GENDER[] arrayOfGENDER = new GENDER[3];
      arrayOfGENDER[0] = UNKNOWN;
      arrayOfGENDER[1] = MALE;
      arrayOfGENDER[2] = FEMALE;
    }
  }

  private class a
    implements c
  {
    Handler a;

    public a(Handler arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    private void b(AdResponse paramAdResponse)
    {
      AdView.this.setAdType(AdType.NATIVE);
      AdView.this.setCreativeId(paramAdResponse.getResponseData().getCreativeId());
      NativeAdResponse localNativeAdResponse = paramAdResponse.getNativeAdResponse();
      localNativeAdResponse.setCreativeId(paramAdResponse.getResponseData().getCreativeId());
      AdView.a(AdView.this).onAdLoaded(localNativeAdResponse);
    }

    private void c(final AdResponse paramAdResponse)
    {
      this.a.post(new Runnable()
      {
        public void run()
        {
          AdView.this.setCreativeWidth(paramAdResponse.getDisplayable().k());
          AdView.this.setCreativeHeight(paramAdResponse.getDisplayable().l());
          AdView.this.setCreativeId(paramAdResponse.getResponseData().getCreativeId());
          if (paramAdResponse.isMediated());
          while (true)
          {
            try
            {
              AdView.this.a((q)paramAdResponse.getDisplayable());
              if ((paramAdResponse.getResponseData() != null) && (paramAdResponse.getResponseData().getImpressionURLs().size() > 0))
              {
                AdView.this.k = paramAdResponse.getResponseData().getImpressionURLs();
                if (AdView.this.k != null)
                  AdView.this.l = new ArrayList(AdView.this.k);
              }
              if ((AdView.this.getMediaType().equals(MediaType.BANNER)) && (AdView.this.g()) && (AdView.this.k != null) && (AdView.this.k.size() > 0))
                AdView.this.f();
              if (!paramAdResponse.getResponseData().getAdType().equalsIgnoreCase("video"))
                break label402;
              AdView.this.setAdType(AdType.VIDEO);
              if (AdView.this.a.d() == d.c.c)
                AdView.this.a.a();
              if (AdView.a(AdView.this) != null)
                AdView.a(AdView.this).onAdLoaded(AdView.this);
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              Clog.e(Clog.baseLogTag, "The SDK shouldn't fail downcasts to MediatedDisplayable in AdView");
              continue;
            }
            AdView.this.a(paramAdResponse.getDisplayable());
            continue;
            label402: if (paramAdResponse.getResponseData().getAdType().equalsIgnoreCase("banner"))
              AdView.this.setAdType(AdType.BANNER);
          }
        }
      });
    }

    public void a()
    {
      this.a.post(new Runnable()
      {
        public void run()
        {
          if (AdView.a(AdView.this) != null)
            AdView.a(AdView.this).onAdExpanded(AdView.this);
        }
      });
    }

    public void a(AdResponse paramAdResponse)
    {
      if ((paramAdResponse.getMediaType().equals(MediaType.BANNER)) || (paramAdResponse.getMediaType().equals(MediaType.INTERSTITIAL)))
      {
        c(paramAdResponse);
        return;
      }
      if (paramAdResponse.getMediaType().equals(MediaType.NATIVE))
      {
        b(paramAdResponse);
        return;
      }
      Clog.e(Clog.baseLogTag, "UNKNOWN media type::" + paramAdResponse.getMediaType());
      a(ResultCode.INTERNAL_ERROR);
    }

    public void a(final ResultCode paramResultCode)
    {
      this.a.post(new Runnable()
      {
        public void run()
        {
          if (AdView.a(AdView.this) != null)
            AdView.a(AdView.this).onAdRequestFailed(AdView.this, paramResultCode);
        }
      });
    }

    public void a(final String paramString)
    {
      this.a.post(new Runnable()
      {
        public void run()
        {
          if (AdView.a(AdView.this) != null)
          {
            Clog.e("ADVIEW", "onAdClicked clickUrl");
            AdView.a(AdView.this).onAdClicked(AdView.this, paramString);
          }
        }
      });
    }

    public void a(final String paramString1, final String paramString2)
    {
      this.a.post(new Runnable()
      {
        public void run()
        {
          if (AdView.b(AdView.this) != null)
            AdView.b(AdView.this).onAppEvent(AdView.this, paramString1, paramString2);
        }
      });
    }

    public void b()
    {
      this.a.post(new Runnable()
      {
        public void run()
        {
          if (AdView.a(AdView.this) != null)
            AdView.a(AdView.this).onAdCollapsed(AdView.this);
        }
      });
    }

    public void c()
    {
      this.a.post(new Runnable()
      {
        public void run()
        {
          if (AdView.a(AdView.this) != null)
          {
            Clog.d("ADVIEW", "onAdClicked");
            AdView.a(AdView.this).onAdClicked(AdView.this);
          }
        }
      });
    }

    public void d()
    {
      if ((AdView.this.getMediaType().equals(MediaType.BANNER)) && (AdView.this.a.d() == d.c.a))
        AdView.this.a.b();
    }
  }

  static class b
  {
    static final ArrayList<Pair<String, b>> d = new ArrayList();
    final Drawable a;
    final Drawable b;
    final Drawable c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.AdView
 * JD-Core Version:    0.6.2
 */