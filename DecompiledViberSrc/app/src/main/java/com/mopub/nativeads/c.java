package com.mopub.nativeads;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import com.mopub.common.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class c
{

  @VisibleForTesting
  static final int[] a = { 1000, 3000, 5000, 25000, 60000, 300000 };

  @VisibleForTesting
  boolean b;

  @VisibleForTesting
  boolean c;

  @VisibleForTesting
  int d;

  @VisibleForTesting
  int e;
  private final List<k<NativeAd>> f;
  private final Handler g;
  private final Runnable h;
  private final MoPubNative.MoPubNativeNetworkListener i;
  private a j;
  private RequestParameters k;
  private MoPubNative l;
  private final AdRendererRegistry m;

  c()
  {
    this(new ArrayList(1), new Handler(), new AdRendererRegistry());
  }

  @VisibleForTesting
  c(List<k<NativeAd>> paramList, Handler paramHandler, AdRendererRegistry paramAdRendererRegistry)
  {
    this.f = paramList;
    this.g = paramHandler;
    this.h = new Runnable()
    {
      public void run()
      {
        c.this.c = false;
        c.this.g();
      }
    };
    this.m = paramAdRendererRegistry;
    this.i = new MoPubNative.MoPubNativeNetworkListener()
    {
      public void onNativeFail(NativeErrorCode paramAnonymousNativeErrorCode)
      {
        c.this.b = false;
        if (c.this.e >= -1 + c.a.length)
        {
          c.this.e();
          return;
        }
        c.this.d();
        c.this.c = true;
        c.e(c.this).postDelayed(c.d(c.this), c.this.f());
      }

      public void onNativeLoad(NativeAd paramAnonymousNativeAd)
      {
        if (c.a(c.this) == null)
          return;
        c.this.b = false;
        c localc = c.this;
        localc.d = (1 + localc.d);
        c.this.e();
        c.b(c.this).add(new k(paramAnonymousNativeAd));
        if ((c.b(c.this).size() == 1) && (c.c(c.this) != null))
          c.c(c.this).onAdsAvailable();
        c.this.g();
      }
    };
    this.d = 0;
    e();
  }

  int a()
  {
    return this.m.getAdRendererCount();
  }

  void a(Activity paramActivity, String paramString, RequestParameters paramRequestParameters)
  {
    a(paramRequestParameters, new MoPubNative(paramActivity, paramString, this.i));
  }

  void a(MoPubAdRenderer paramMoPubAdRenderer)
  {
    this.m.registerAdRenderer(paramMoPubAdRenderer);
    if (this.l != null)
      this.l.registerAdRenderer(paramMoPubAdRenderer);
  }

  @VisibleForTesting
  void a(RequestParameters paramRequestParameters, MoPubNative paramMoPubNative)
  {
    b();
    Iterator localIterator = this.m.getRendererIterable().iterator();
    while (localIterator.hasNext())
      paramMoPubNative.registerAdRenderer((MoPubAdRenderer)localIterator.next());
    this.k = paramRequestParameters;
    this.l = paramMoPubNative;
    g();
  }

  void a(a parama)
  {
    this.j = parama;
  }

  void b()
  {
    if (this.l != null)
    {
      this.l.destroy();
      this.l = null;
    }
    this.k = null;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      ((NativeAd)((k)localIterator.next()).a).destroy();
    this.f.clear();
    this.g.removeMessages(0);
    this.b = false;
    this.d = 0;
    e();
  }

  NativeAd c()
  {
    long l1 = SystemClock.uptimeMillis();
    if ((!this.b) && (!this.c))
      this.g.post(this.h);
    while (!this.f.isEmpty())
    {
      k localk = (k)this.f.remove(0);
      if (l1 - localk.b < 14400000L)
        return (NativeAd)localk.a;
    }
    return null;
  }

  @VisibleForTesting
  void d()
  {
    if (this.e < -1 + a.length)
      this.e = (1 + this.e);
  }

  @VisibleForTesting
  void e()
  {
    this.e = 0;
  }

  @VisibleForTesting
  int f()
  {
    if (this.e >= a.length)
      this.e = (-1 + a.length);
    return a[this.e];
  }

  @VisibleForTesting
  void g()
  {
    if ((!this.b) && (this.l != null) && (this.f.size() < 1))
    {
      this.b = true;
      this.l.makeRequest(this.k, Integer.valueOf(this.d));
    }
  }

  public MoPubAdRenderer getAdRendererForViewType(int paramInt)
  {
    return this.m.getRendererForViewType(paramInt);
  }

  public int getViewTypeForAd(NativeAd paramNativeAd)
  {
    return this.m.getViewTypeForAd(paramNativeAd);
  }

  static abstract interface a
  {
    public abstract void onAdsAvailable();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.c
 * JD-Core Version:    0.6.2
 */