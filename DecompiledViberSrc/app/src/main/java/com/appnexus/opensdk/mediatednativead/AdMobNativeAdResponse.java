package com.appnexus.opensdk.mediatednativead;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.appnexus.opensdk.NativeAdEventListener;
import com.appnexus.opensdk.NativeAdResponse;
import com.appnexus.opensdk.NativeAdResponse.Network;
import com.appnexus.opensdk.NativeAdResponse.Rating;
import com.appnexus.opensdk.utils.Clog;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AdMobNativeAdResponse
  implements NativeAdResponse
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private Bitmap f;
  private Bitmap g;
  private String h;
  private String i = "";
  private String j = "";
  private String k = "";
  private NativeAdResponse.Rating l;
  private HashMap<String, Object> m = new HashMap();
  private boolean n = false;
  private boolean o = false;
  private NativeAdEventListener p;
  private Runnable q;
  private final NativeAd r;
  private final AdMobNativeSettings.AdMobNativeType s;
  private Handler t;
  private NativeAdView u = null;

  AdMobNativeAdResponse(NativeAd paramNativeAd, AdMobNativeSettings.AdMobNativeType paramAdMobNativeType)
  {
    this.r = paramNativeAd;
    this.s = paramAdMobNativeType;
    this.q = new Runnable()
    {
      public void run()
      {
        if (AdMobNativeAdResponse.a(AdMobNativeAdResponse.this) != null)
        {
          AdMobNativeAdResponse.a(AdMobNativeAdResponse.this).recycle();
          AdMobNativeAdResponse.a(AdMobNativeAdResponse.this, null);
        }
        if (AdMobNativeAdResponse.b(AdMobNativeAdResponse.this) != null)
        {
          AdMobNativeAdResponse.b(AdMobNativeAdResponse.this).recycle();
          AdMobNativeAdResponse.b(AdMobNativeAdResponse.this, null);
        }
        AdMobNativeAdResponse.a(AdMobNativeAdResponse.this, null);
        AdMobNativeAdResponse.a(AdMobNativeAdResponse.this, true);
        if (AdMobNativeAdResponse.c(AdMobNativeAdResponse.this) != null);
        try
        {
          switch (AdMobNativeAdResponse.2.a[AdMobNativeAdResponse.d(AdMobNativeAdResponse.this).ordinal()])
          {
          case 1:
            ((NativeAppInstallAd)AdMobNativeAdResponse.c(AdMobNativeAdResponse.this)).destroy();
            return;
          case 2:
            ((NativeContentAd)AdMobNativeAdResponse.c(AdMobNativeAdResponse.this)).destroy();
          }
          return;
        }
        catch (ClassCastException localClassCastException)
        {
        }
      }
    };
    this.t = new Handler(Looper.getMainLooper());
    this.t.postDelayed(this.q, 3600000L);
    b();
  }

  private void b()
  {
    this.m.put(AdMobNativeSettings.NATIVE_ELEMENT_TYPE_KEY, this.s);
    this.m.put(AdMobNativeSettings.NATIVE_ELEMENT_OBJECT, this.r);
    switch (2.a[this.s.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      NativeAppInstallAd localNativeAppInstallAd = (NativeAppInstallAd)this.r;
      if (localNativeAppInstallAd.getHeadline() != null)
        this.a = localNativeAppInstallAd.getHeadline().toString();
      if (localNativeAppInstallAd.getBody() != null)
        this.b = localNativeAppInstallAd.getBody().toString();
      if (localNativeAppInstallAd.getCallToAction() != null)
        this.e = localNativeAppInstallAd.getCallToAction().toString();
      if (localNativeAppInstallAd.getIcon() != null)
      {
        NativeAd.Image localImage4 = localNativeAppInstallAd.getIcon();
        if (localImage4.getUri() != null)
          this.d = localImage4.getUri().toString();
      }
      List localList2 = localNativeAppInstallAd.getImages();
      if ((localList2 != null) && (localList2.size() > 0))
      {
        NativeAd.Image localImage3 = (NativeAd.Image)localList2.get(0);
        if (localImage3.getUri() != null)
          this.c = localImage3.getUri().toString();
      }
      if (localNativeAppInstallAd.getStarRating().doubleValue() > 0.0D)
        this.l = new NativeAdResponse.Rating(localNativeAppInstallAd.getStarRating().doubleValue(), 5.0D);
      if (localNativeAppInstallAd.getStore() != null)
        this.m.put(AdMobNativeSettings.NATIVE_ELEMENT_STORE_KEY, localNativeAppInstallAd.getStore().toString());
      if (localNativeAppInstallAd.getPrice() != null)
        this.m.put(AdMobNativeSettings.NATIVE_ELEMENT_PRICE_KEY, localNativeAppInstallAd.getPrice());
      Bundle localBundle2 = localNativeAppInstallAd.getExtras();
      if ((localBundle2 != null) && (localBundle2.size() > 0))
      {
        Iterator localIterator2 = localBundle2.keySet().iterator();
        while (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          this.m.put(str2, localBundle2.get(str2));
        }
        continue;
        NativeContentAd localNativeContentAd = (NativeContentAd)this.r;
        if (localNativeContentAd.getHeadline() != null)
          this.a = localNativeContentAd.getHeadline().toString();
        if (localNativeContentAd.getBody() != null)
          this.b = localNativeContentAd.getBody().toString();
        if (localNativeContentAd.getCallToAction() != null)
          this.e = localNativeContentAd.getCallToAction().toString();
        if (localNativeContentAd.getLogo() != null)
        {
          NativeAd.Image localImage2 = localNativeContentAd.getLogo();
          if (localImage2.getUri() != null)
            this.d = localImage2.getUri().toString();
        }
        List localList1 = localNativeContentAd.getImages();
        if ((localList1 != null) && (localList1.size() > 0))
        {
          NativeAd.Image localImage1 = (NativeAd.Image)localList1.get(0);
          if (localImage1.getUri() != null)
            this.c = localImage1.getUri().toString();
        }
        if (localNativeContentAd.getAdvertiser() != null)
          this.m.put(AdMobNativeSettings.NATIVE_ELEMENT_ADVERTISER_KEY, localNativeContentAd.getAdvertiser().toString());
        Bundle localBundle1 = localNativeContentAd.getExtras();
        if ((localBundle1 != null) && (localBundle1.size() > 0))
        {
          Iterator localIterator1 = localBundle1.keySet().iterator();
          while (localIterator1.hasNext())
          {
            String str1 = (String)localIterator1.next();
            this.m.put(str1, localBundle1.get(str1));
          }
        }
      }
    }
  }

  NativeAdEventListener a()
  {
    return this.p;
  }

  public void destroy()
  {
    if (this.t != null)
    {
      this.t.removeCallbacks(this.q);
      this.t.post(this.q);
    }
  }

  public NativeAdResponse.Rating getAdStarRating()
  {
    return this.l;
  }

  public String getCallToAction()
  {
    return this.e;
  }

  public String getCreativeId()
  {
    return this.j;
  }

  public String getDescription()
  {
    return this.b;
  }

  public String getFullText()
  {
    return this.i;
  }

  public Bitmap getIcon()
  {
    return this.g;
  }

  public String getIconUrl()
  {
    return this.d;
  }

  public Bitmap getImage()
  {
    return this.f;
  }

  public String getImageUrl()
  {
    return this.c;
  }

  public List<String> getImpressionTrackers()
  {
    return null;
  }

  public HashMap<String, Object> getNativeElements()
  {
    return this.m;
  }

  public NativeAdResponse.Network getNetworkIdentifier()
  {
    return NativeAdResponse.Network.ADMOB;
  }

  public String getOriginalResponse()
  {
    return "";
  }

  public String getSocialContext()
  {
    return this.h;
  }

  public String getSponsoredBy()
  {
    return this.k;
  }

  public String getTitle()
  {
    return this.a;
  }

  public boolean hasExpired()
  {
    return this.n;
  }

  public boolean registerView(View paramView, NativeAdEventListener paramNativeAdEventListener)
  {
    if ((paramView != null) && (!this.o) && (!this.n))
    {
      switch (2.a[this.s.ordinal()])
      {
      default:
      case 1:
      case 2:
      }
      while (this.u != null)
      {
        this.u.setNativeAd(this.r);
        this.p = paramNativeAdEventListener;
        this.o = true;
        if (this.t != null)
          this.t.removeCallbacks(this.q);
        return true;
        try
        {
          this.u = ((NativeAppInstallAdView)paramView);
        }
        catch (ClassCastException localClassCastException2)
        {
          Clog.w(Clog.mediationLogTag, "The view registered for AdMob AppInstallNativeAd has to be a subclass of com.google.android.gms.ads.formats.NativeAppInstallAdView");
        }
        continue;
        try
        {
          this.u = ((NativeContentAdView)paramView);
        }
        catch (ClassCastException localClassCastException1)
        {
          Clog.w(Clog.mediationLogTag, "The view registered for AdMob ContentAd has to be a subclass of com.google.android.gms.ads.formats.NativeContentAdView");
        }
      }
    }
    return false;
  }

  public boolean registerViewList(View paramView, List<View> paramList, NativeAdEventListener paramNativeAdEventListener)
  {
    return registerView(paramView, paramNativeAdEventListener);
  }

  public void setCreativeId(String paramString)
  {
    this.j = paramString;
  }

  public void setIcon(Bitmap paramBitmap)
  {
    this.g = paramBitmap;
  }

  public void setImage(Bitmap paramBitmap)
  {
    this.f = paramBitmap;
  }

  public void unregisterViews()
  {
    if (this.n)
      Clog.d(Clog.mediationLogTag, "This NativeAdResponse has expired.");
    if (this.u != null)
      this.u = null;
    destroy();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.mediatednativead.AdMobNativeAdResponse
 * JD-Core Version:    0.6.2
 */