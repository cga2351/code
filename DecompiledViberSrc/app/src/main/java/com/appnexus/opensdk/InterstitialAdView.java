package com.appnexus.opensdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.appnexus.opensdk.ut.UTRequestParameters;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.Settings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class InterstitialAdView extends AdView
{
  static InterstitialAdView s;
  private int A;
  private AdActivity.a B = null;
  protected boolean t = false;
  protected boolean u = false;
  private int v = -16777216;
  private int w = 10000;
  private boolean x;
  private Queue<m> y = new LinkedList();
  private int z;

  public InterstitialAdView(Context paramContext)
  {
    super(paramContext);
  }

  public InterstitialAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public InterstitialAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private boolean a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.y.iterator();
    while (true)
    {
      boolean bool1 = localIterator1.hasNext();
      bool2 = false;
      if (!bool1)
        break label119;
      m localm2 = (m)localIterator1.next();
      if ((localm2 != null) && (paramLong - localm2.a() <= 270000L) && (paramLong - localm2.a() >= 0L) && ((!localm2.b()) || (!localm2.c().h)))
        break;
      localArrayList.add(localm2);
    }
    boolean bool2 = true;
    label119: Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      m localm1 = (m)localIterator2.next();
      this.y.remove(localm1);
    }
    return bool2;
  }

  private boolean b(i parami)
  {
    if ((parami == null) || (parami.j()))
    {
      Clog.e(Clog.baseLogTag, "Loaded an ad with an invalid displayable");
      return false;
    }
    return true;
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    this.a.a(-1);
    this.j.setMediaType(MediaType.INTERSTITIAL);
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.A = localDisplayMetrics.heightPixels;
    this.z = localDisplayMetrics.widthPixels;
    try
    {
      Activity localActivity = (Activity)paramContext;
      Rect localRect = new Rect();
      localActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      int i = 0 + localActivity.getWindow().findViewById(16908290).getTop();
      this.A -= i;
      label128: float f = localDisplayMetrics.density;
      this.A = ((int)(0.5F + this.A / f));
      this.z = ((int)(0.5F + this.z / f));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new AdSize(1, 1));
      AdSize localAdSize = new AdSize(this.z, this.A);
      localArrayList.add(localAdSize);
      if (new AdSize(300, 250).fitsIn(this.z, this.A))
        localArrayList.add(new AdSize(300, 250));
      if (new AdSize(320, 480).fitsIn(this.z, this.A))
        localArrayList.add(new AdSize(320, 480));
      if (new AdSize(900, 500).fitsIn(this.z, this.A))
        localArrayList.add(new AdSize(900, 500));
      if (new AdSize(1024, 1024).fitsIn(this.z, this.A))
        localArrayList.add(new AdSize(1024, 1024));
      this.j.setPrimarySize(localAdSize);
      this.j.setSizes(localArrayList);
      this.j.setAllowSmallerSizes(false);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      break label128;
    }
  }

  protected void a(i parami)
  {
    if (!b(parami));
    do
    {
      return;
      if (this.g != null)
        this.g.destroy();
      if ((!this.t) && (!this.u))
      {
        this.g = parami;
        this.y.add(new j(parami, Long.valueOf(System.currentTimeMillis()), false, null));
        return;
      }
    }
    while (parami == null);
    parami.destroy();
  }

  protected void a(q paramq)
  {
    if (!b(paramq));
    do
    {
      return;
      if (this.g != null)
        this.g.destroy();
      if ((!this.t) && (!this.u))
      {
        this.g = paramq;
        this.y.add(new j(paramq, Long.valueOf(System.currentTimeMillis()), true, paramq.a()));
        return;
      }
    }
    while (paramq == null);
    paramq.destroy();
  }

  public void activityOnDestroy()
  {
    this.t = true;
  }

  public void activityOnPause()
  {
    this.u = true;
  }

  public void activityOnResume()
  {
    this.u = false;
  }

  protected void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.InterstitialAdView);
    int i = localTypedArray.getIndexCount();
    Clog.v(Clog.xmlLogTag, Clog.getString(R.string.found_n_in_xml, i));
    int j = 0;
    if (j < i)
    {
      int k = localTypedArray.getIndex(j);
      if (k == R.styleable.InterstitialAdView_placement_id)
      {
        setPlacementID(localTypedArray.getString(k));
        Clog.d(Clog.xmlLogTag, Clog.getString(R.string.placement_id, localTypedArray.getString(k)));
      }
      while (true)
      {
        j++;
        break;
        if (k == R.styleable.InterstitialAdView_test)
        {
          Settings.getSettings().test_mode = localTypedArray.getBoolean(k, false);
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_set_test, Settings.getSettings().test_mode));
        }
        else if (k == R.styleable.InterstitialAdView_opens_native_browser)
        {
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_set_opens_native_browser));
          setOpensNativeBrowser(localTypedArray.getBoolean(k, false));
        }
        else if (k == R.styleable.InterstitialAdView_show_loading_indicator)
        {
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.show_loading_indicator_xml));
          setShowLoadingIndicator(localTypedArray.getBoolean(k, true));
        }
        else if (k == R.styleable.InterstitialAdView_load_landing_page_in_background)
        {
          setLoadsInBackground(localTypedArray.getBoolean(k, true));
          Clog.d(Clog.xmlLogTag, Clog.getString(R.string.xml_load_landing_page_in_background, getLoadsInBackground()));
        }
      }
    }
    localTypedArray.recycle();
  }

  boolean d()
  {
    return false;
  }

  public void destroy()
  {
    super.destroy();
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.destroy_int));
    if (this.a != null)
      this.a.a();
    this.y.clear();
    s = null;
  }

  boolean e()
  {
    return true;
  }

  Queue<m> getAdQueue()
  {
    return this.y;
  }

  public ArrayList<AdSize> getAllowedSizes()
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.get_allowed_sizes));
    return this.j.getSizes();
  }

  public int getBackgroundColor()
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.get_bg));
    return this.v;
  }

  public int getCloseButtonDelay()
  {
    return this.w;
  }

  public int getCreativeHeight()
  {
    return -1;
  }

  public int getCreativeWidth()
  {
    return -1;
  }

  public MediaType getMediaType()
  {
    return MediaType.INTERSTITIAL;
  }

  void h()
  {
    if (this.B != null)
      this.B.interacted();
  }

  void i()
  {
    if (this.B != null)
      this.B.browserLaunched();
  }

  public boolean isReady()
  {
    if (a(System.currentTimeMillis()))
    {
      m localm = (m)this.y.peek();
      if ((localm != null) && (localm.b()) && (localm.c() != null))
        return localm.c().c();
      return true;
    }
    return false;
  }

  public boolean loadAd()
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.load_ad_int));
    if (!isReadyToStart());
    while (this.a == null)
      return false;
    this.a.a();
    this.a.b();
    return true;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  void setAdImplementation(AdActivity.a parama)
  {
    this.B = parama;
  }

  public void setAllowedSizes(ArrayList<AdSize> paramArrayList)
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.set_allowed_sizes));
    AdSize localAdSize1 = new AdSize(1, 1);
    if (!paramArrayList.contains(localAdSize1))
      paramArrayList.add(localAdSize1);
    AdSize localAdSize2 = new AdSize(this.z, this.A);
    if (!paramArrayList.contains(localAdSize2))
      paramArrayList.add(localAdSize2);
    this.j.setPrimarySize(localAdSize2);
    this.j.setSizes(paramArrayList);
    this.j.setAllowSmallerSizes(false);
  }

  public void setBackgroundColor(int paramInt)
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.set_bg));
    this.v = paramInt;
  }

  public void setCloseButtonDelay(int paramInt)
  {
    this.w = Math.min(paramInt, 10000);
  }

  public void setDismissOnClick(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }

  public boolean shouldDismissOnClick()
  {
    return this.x;
  }

  public int show()
  {
    return showWithAutoDismissDelay(-1);
  }

  public int showWithAutoDismissDelay(int paramInt)
  {
    Clog.d(Clog.publicFunctionsLogTag, Clog.getString(R.string.show_int));
    long l = System.currentTimeMillis();
    boolean bool = a(l);
    m localm = (m)this.y.peek();
    if ((localm != null) && (localm.b()) && (localm.c() != null))
    {
      if ((this.k != null) && (this.k.size() > 0))
        f();
      localm.c().d();
      this.y.poll();
      return this.y.size();
    }
    if ((bool) && (!this.t))
    {
      Class localClass = AdActivity.getActivityClass();
      Intent localIntent = new Intent(getContext(), localClass);
      localIntent.putExtra("ACTIVITY_TYPE", "INTERSTITIAL");
      localIntent.putExtra("TIME", l);
      localIntent.putExtra("CLOSE_BUTTON_DELAY", this.w);
      localIntent.putExtra("AUTODISMISS_DELAY", paramInt);
      s = this;
      if ((this.k != null) && (this.k.size() > 0))
        f();
      try
      {
        getContext().startActivity(localIntent);
        return -1 + this.y.size();
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        while (true)
        {
          s = null;
          Clog.e(Clog.baseLogTag, Clog.getString(R.string.adactivity_missing, localClass.getName()));
        }
      }
    }
    Clog.w(Clog.baseLogTag, Clog.getString(R.string.empty_queue));
    return this.y.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.InterstitialAdView
 * JD-Core Version:    0.6.2
 */