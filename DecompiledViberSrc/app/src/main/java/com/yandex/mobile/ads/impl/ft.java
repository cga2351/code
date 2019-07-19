package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.yandex.mobile.ads.AdActivity;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.AdSize;
import com.yandex.mobile.ads.a;
import com.yandex.mobile.ads.b;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class ft extends ga
{
  private final fs h;
  private final hu i;
  private hs j;
  private hs k;
  private final k l;

  public ft(Context paramContext, b paramb, fs paramfs)
  {
    super(paramContext, paramb);
    this.h = paramfs;
    this.i = new hu();
    this.l = new gz();
    b(a.a(AdSize.FULL_SCREEN));
    l.a().a("window_type_interstitial", this.l);
  }

  private static void a(Context paramContext, hs[] paramArrayOfhs)
  {
    Iterator localIterator = new HashSet(Arrays.asList(paramArrayOfhs)).iterator();
    while (localIterator.hasNext())
    {
      hs localhs = (hs)localIterator.next();
      if (localhs != null)
        localhs.a(paramContext);
    }
  }

  protected final gf a(String paramString, v<String> paramv, aj paramaj)
  {
    fv localfv = new fv(this);
    fu localfu = new fu(this.b, paramv);
    new gg();
    boolean bool = gg.a(paramString);
    gj.a();
    return gj.a(bool).a(localfu, localfv);
  }

  protected abstract hs a(ht paramht);

  public void a()
  {
    if ((this.j != null) && (!a_()))
      this.j.b();
  }

  public void a(int paramInt, Bundle paramBundle)
  {
    new StringBuilder("onReceiveResult(), resultCode = ").append(paramInt).append(", clazz = ").append(getClass());
    switch (paramInt)
    {
    case 1:
    case 7:
    default:
      super.a(paramInt, paramBundle);
    case 5:
      return;
    case 0:
      if (paramBundle != null);
      for (Map localMap = (Map)paramBundle.getSerializable("extra_tracking_parameters"); ; localMap = null)
      {
        a(null, localMap);
        return;
      }
    case 4:
      y();
      return;
    case 3:
      b(8);
      return;
    case 2:
      b(0);
      return;
    case 6:
      onAdOpened();
      return;
    case 8:
    }
    onAdClosed();
  }

  public final void a(WebView paramWebView, Map<String, String> paramMap)
  {
    x();
    super.a(paramWebView, paramMap);
  }

  public final void a(AdRequest paramAdRequest)
  {
    t();
    super.a(paramAdRequest);
  }

  protected final void a(AdRequestError paramAdRequestError)
  {
    this.h.a(paramAdRequestError);
  }

  public void a(v<String> paramv)
  {
    super.a(paramv);
    this.j = a(hu.a(paramv));
    this.j.a(this.b, paramv);
  }

  protected final boolean a(int paramInt)
  {
    return true;
  }

  protected final boolean a(aj paramaj)
  {
    int m = paramaj.b(this.b);
    int n = paramaj.a(this.b);
    return (m > 0) && (n > 0);
  }

  protected final boolean b()
  {
    return true;
  }

  protected final boolean c()
  {
    return true;
  }

  public final void d()
  {
    Context localContext = this.b;
    v localv = w();
    eo localeo = r();
    w localw = this.d;
    Intent localIntent;
    if (localContext != null)
    {
      localIntent = new Intent(localContext, AdActivity.class);
      localIntent.putExtra("window_type", "window_type_interstitial");
      localIntent.putExtra("extra_receiver", cw.a(localw));
      localIntent.putExtra("extra_interstitial_isShouldOpenLinksInApp", localeo.i());
      localIntent.addFlags(268435456);
      gx.a().a(localv);
    }
    try
    {
      localContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      fq.c("Failed to show Interstitial Ad. Exception: ".concat(String.valueOf(localException)), new Object[0]);
    }
  }

  public final void e()
  {
    try
    {
      super.e();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void f()
  {
    Context localContext = this.b;
    hs[] arrayOfhs = new hs[2];
    arrayOfhs[0] = this.k;
    arrayOfhs[1] = this.j;
    a(localContext, arrayOfhs);
    super.f();
  }

  public final boolean g()
  {
    return (this.j != null) && (this.j.a());
  }

  protected final void h()
  {
    this.h.d();
  }

  public void onAdClosed()
  {
    super.onAdClosed();
    this.h.a();
  }

  public void onAdFailedToLoad(AdRequestError paramAdRequestError)
  {
    super.onAdFailedToLoad(paramAdRequestError);
    u();
  }

  public void onAdLeftApplication()
  {
    super.onAdLeftApplication();
    this.h.c();
  }

  public void onAdOpened()
  {
    super.onAdOpened();
    this.h.e();
  }

  public final void x()
  {
    this.h.f();
    if (this.k != this.j)
    {
      Context localContext = this.b;
      hs[] arrayOfhs = new hs[1];
      arrayOfhs[0] = this.k;
      a(localContext, arrayOfhs);
      this.k = this.j;
    }
  }

  public final void y()
  {
    u();
    this.h.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ft
 * JD-Core Version:    0.6.2
 */