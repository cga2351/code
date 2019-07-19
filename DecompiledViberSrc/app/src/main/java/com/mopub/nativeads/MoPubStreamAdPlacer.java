package com.mopub.nativeads;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

public class MoPubStreamAdPlacer
{
  public static final int CONTENT_VIEW_TYPE;
  private static final MoPubNativeAdLoadedListener a = new MoPubNativeAdLoadedListener()
  {
    public void onAdLoaded(int paramAnonymousInt)
    {
    }

    public void onAdRemoved(int paramAnonymousInt)
    {
    }
  };
  private final Activity b;
  private final Handler c;
  private final Runnable d;
  private final PositioningSource e;
  private final c f;
  private final HashMap<NativeAd, WeakReference<View>> g;
  private final WeakHashMap<View, NativeAd> h;
  private boolean i;
  private f j;
  private boolean k;
  private boolean l;
  private f m;
  private String n;
  private MoPubNativeAdLoadedListener o = a;
  private int p;
  private int q;
  private int r;
  private boolean s;

  public MoPubStreamAdPlacer(Activity paramActivity)
  {
    this(paramActivity, MoPubNativeAdPositioning.serverPositioning());
  }

  public MoPubStreamAdPlacer(Activity paramActivity, MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning)
  {
    this(paramActivity, new c(), new a(paramMoPubClientPositioning));
  }

  public MoPubStreamAdPlacer(Activity paramActivity, MoPubNativeAdPositioning.MoPubServerPositioning paramMoPubServerPositioning)
  {
    this(paramActivity, new c(), new h(paramActivity));
  }

  @VisibleForTesting
  MoPubStreamAdPlacer(Activity paramActivity, c paramc, PositioningSource paramPositioningSource)
  {
    Preconditions.checkNotNull(paramActivity, "activity is not allowed to be null");
    Preconditions.checkNotNull(paramc, "adSource is not allowed to be null");
    Preconditions.checkNotNull(paramPositioningSource, "positioningSource is not allowed to be null");
    this.b = paramActivity;
    this.e = paramPositioningSource;
    this.f = paramc;
    this.m = f.a();
    this.h = new WeakHashMap();
    this.g = new HashMap();
    this.c = new Handler();
    this.d = new Runnable()
    {
      public void run()
      {
        if (!MoPubStreamAdPlacer.a(MoPubStreamAdPlacer.this))
          return;
        MoPubStreamAdPlacer.b(MoPubStreamAdPlacer.this);
        MoPubStreamAdPlacer.a(MoPubStreamAdPlacer.this, false);
      }
    };
    this.p = 0;
    this.q = 0;
  }

  private void a(View paramView)
  {
    if (paramView == null);
    NativeAd localNativeAd;
    do
    {
      return;
      localNativeAd = (NativeAd)this.h.get(paramView);
    }
    while (localNativeAd == null);
    localNativeAd.clear(paramView);
    this.h.remove(paramView);
    this.g.remove(localNativeAd);
  }

  private void a(NativeAd paramNativeAd, View paramView)
  {
    this.g.put(paramNativeAd, new WeakReference(paramView));
    this.h.put(paramView, paramNativeAd);
    paramNativeAd.prepare(paramView);
  }

  private void a(f paramf)
  {
    removeAdsInRange(0, this.r);
    this.m = paramf;
    c();
    this.l = true;
  }

  private boolean a(int paramInt)
  {
    NativeAd localNativeAd = this.f.c();
    if (localNativeAd == null)
      return false;
    this.m.a(paramInt, localNativeAd);
    this.r = (1 + this.r);
    this.o.onAdLoaded(paramInt);
    return true;
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2 - 1;
    while (true)
    {
      if ((paramInt1 > i1) || (paramInt1 == -1) || (paramInt1 >= this.r))
        return true;
      if (this.m.a(paramInt1))
      {
        if (!a(paramInt1))
          return false;
        i1++;
      }
      paramInt1 = this.m.b(paramInt1);
    }
  }

  private void b()
  {
    if (this.s)
      return;
    this.s = true;
    this.c.post(this.d);
  }

  private void c()
  {
    if (!a(this.p, this.q))
      return;
    a(this.q, 6 + this.q);
  }

  @VisibleForTesting
  void a()
  {
    if (this.l)
    {
      b();
      return;
    }
    if (this.i)
      a(this.j);
    this.k = true;
  }

  @VisibleForTesting
  void a(MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning)
  {
    f localf = f.a(paramMoPubClientPositioning);
    if (this.k)
      a(localf);
    while (true)
    {
      this.i = true;
      return;
      this.j = localf;
    }
  }

  public void bindAdView(NativeAd paramNativeAd, View paramView)
  {
    WeakReference localWeakReference = (WeakReference)this.g.get(paramNativeAd);
    if (localWeakReference != null);
    for (View localView = (View)localWeakReference.get(); ; localView = null)
    {
      if (!paramView.equals(localView))
      {
        a(localView);
        a(paramView);
        a(paramNativeAd, paramView);
        paramNativeAd.renderAdView(paramView);
      }
      return;
    }
  }

  public void clearAds()
  {
    removeAdsInRange(0, this.r);
    this.f.b();
  }

  public void destroy()
  {
    this.c.removeMessages(0);
    this.f.b();
    this.m.c();
  }

  public Object getAdData(int paramInt)
  {
    return this.m.d(paramInt);
  }

  public MoPubAdRenderer getAdRendererForViewType(int paramInt)
  {
    return this.f.getAdRendererForViewType(paramInt);
  }

  public View getAdView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    NativeAd localNativeAd = this.m.d(paramInt);
    if (localNativeAd == null)
      return null;
    if (paramView != null);
    while (true)
    {
      bindAdView(localNativeAd, paramView);
      return paramView;
      paramView = localNativeAd.createAdView(this.b, paramViewGroup);
    }
  }

  public int getAdViewType(int paramInt)
  {
    NativeAd localNativeAd = this.m.d(paramInt);
    if (localNativeAd == null)
      return 0;
    return this.f.getViewTypeForAd(localNativeAd);
  }

  public int getAdViewTypeCount()
  {
    return this.f.a();
  }

  public int getAdjustedCount(int paramInt)
  {
    return this.m.h(paramInt);
  }

  public int getAdjustedPosition(int paramInt)
  {
    return this.m.f(paramInt);
  }

  public int getOriginalCount(int paramInt)
  {
    return this.m.g(paramInt);
  }

  public int getOriginalPosition(int paramInt)
  {
    return this.m.e(paramInt);
  }

  public void insertItem(int paramInt)
  {
    this.m.i(paramInt);
  }

  public boolean isAd(int paramInt)
  {
    return this.m.c(paramInt);
  }

  public void loadAds(String paramString)
  {
    loadAds(paramString, null);
  }

  public void loadAds(String paramString, RequestParameters paramRequestParameters)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramString, "Cannot load ads with a null ad unit ID"))
      return;
    if (this.f.a() == 0)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "You must register at least 1 ad renderer by calling registerAdRenderer before loading ads" });
      return;
    }
    this.n = paramString;
    this.l = false;
    this.i = false;
    this.k = false;
    this.e.loadPositions(paramString, new PositioningSource.PositioningListener()
    {
      public void onFailed()
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to show ads because ad positions could not be loaded from the MoPub ad server." });
      }

      public void onLoad(MoPubNativeAdPositioning.MoPubClientPositioning paramAnonymousMoPubClientPositioning)
      {
        MoPubStreamAdPlacer.this.a(paramAnonymousMoPubClientPositioning);
      }
    });
    this.f.a(new c.a()
    {
      public void onAdsAvailable()
      {
        MoPubStreamAdPlacer.this.a();
      }
    });
    this.f.a(this.b, paramString, paramRequestParameters);
  }

  public void moveItem(int paramInt1, int paramInt2)
  {
    this.m.b(paramInt1, paramInt2);
  }

  public void placeAdsInRange(int paramInt1, int paramInt2)
  {
    this.p = paramInt1;
    this.q = Math.min(paramInt2, paramInt1 + 100);
    b();
  }

  public void registerAdRenderer(MoPubAdRenderer paramMoPubAdRenderer)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramMoPubAdRenderer, "Cannot register a null adRenderer"))
      return;
    this.f.a(paramMoPubAdRenderer);
  }

  public int removeAdsInRange(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.m.b();
    int i1 = this.m.f(paramInt1);
    int i2 = this.m.f(paramInt2);
    ArrayList localArrayList = new ArrayList();
    int i3 = -1 + arrayOfInt.length;
    if (i3 >= 0)
    {
      int i6 = arrayOfInt[i3];
      if ((i6 < i1) || (i6 >= i2));
      while (true)
      {
        i3--;
        break;
        localArrayList.add(Integer.valueOf(i6));
        if (i6 < this.p)
          this.p = (-1 + this.p);
        this.r = (-1 + this.r);
      }
    }
    int i4 = this.m.a(i1, i2);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      int i5 = ((Integer)localIterator.next()).intValue();
      this.o.onAdRemoved(i5);
    }
    return i4;
  }

  public void removeItem(int paramInt)
  {
    this.m.j(paramInt);
  }

  public void setAdLoadedListener(MoPubNativeAdLoadedListener paramMoPubNativeAdLoadedListener)
  {
    if (paramMoPubNativeAdLoadedListener == null)
      paramMoPubNativeAdLoadedListener = a;
    this.o = paramMoPubNativeAdLoadedListener;
  }

  public void setItemCount(int paramInt)
  {
    this.r = this.m.h(paramInt);
    if (this.l)
      b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.MoPubStreamAdPlacer
 * JD-Core Version:    0.6.2
 */