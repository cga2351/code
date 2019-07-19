package com.viber.voip.ads.polymorph.dfp;

import android.content.Context;
import android.os.Bundle;
import com.adsnative.ads.aa;
import com.adsnative.ads.aa.a;
import com.adsnative.ads.ab;
import com.adsnative.ads.ad;
import com.adsnative.ads.n;
import com.adsnative.ads.p;
import com.adsnative.ads.v;
import com.adsnative.ads.w;
import com.adsnative.c.i;
import com.adsnative.c.o;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private Context a;
  private Double b = Double.valueOf(0.05D);
  private PublisherAdRequest.Builder c;
  private aa.a d;
  private int e = 0;
  private int f = 0;
  private String g;
  private AdLoader h;
  private AdLoader.Builder i = null;
  private PublisherAdView j;
  private ab k;
  private String l;
  private a m = new a()
  {
    public void a()
    {
    }

    public void a(int paramAnonymousInt)
    {
    }

    public void a(NativeAppInstallAd paramAnonymousNativeAppInstallAd)
    {
    }

    public void a(NativeContentAd paramAnonymousNativeContentAd)
    {
    }

    public void b()
    {
    }

    public void c()
    {
    }

    public void d()
    {
    }

    public void e()
    {
    }

    public void f()
    {
    }
  };
  private n n;
  private String o;

  public a(Context paramContext, String paramString, AdLoader.Builder paramBuilder)
  {
    this.a = paramContext;
    this.g = paramString;
    this.i = paramBuilder;
    this.k = new ab(this.a, this.g, com.adsnative.ads.a.a.b);
    this.l = com.adsnative.ads.a.a.b.toString();
  }

  private void c()
  {
    if (this.c == null)
      this.c = new PublisherAdRequest.Builder();
    if (this.d == null)
      this.d = new aa.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("hb", "1");
    if (this.o != null)
      localHashMap.put("sdk_token", this.o);
    aa localaa = this.d.a(localHashMap).a();
    this.i.forContentAd(new NativeContentAd.OnContentAdLoadedListener()
    {
      public void onContentAdLoaded(NativeContentAd paramAnonymousNativeContentAd)
      {
        if (a.a(a.this) != null)
        {
          String str = paramAnonymousNativeContentAd.getExtras().getString("providerName");
          if ((str == null) || (!str.equalsIgnoreCase("polymorph")))
            break label57;
          a.a(a.this).p();
        }
        while (true)
        {
          a.b(a.this).a(paramAnonymousNativeContentAd);
          return;
          label57: a.a(a.this).q();
        }
      }
    });
    this.i.forAppInstallAd(new NativeAppInstallAd.OnAppInstallAdLoadedListener()
    {
      public void onAppInstallAdLoaded(NativeAppInstallAd paramAnonymousNativeAppInstallAd)
      {
        if (a.a(a.this) != null)
        {
          String str = paramAnonymousNativeAppInstallAd.getExtras().getString("providerName");
          if ((str == null) || (!str.equalsIgnoreCase("polymorph")))
            break label57;
          a.a(a.this).p();
        }
        while (true)
        {
          a.b(a.this).a(paramAnonymousNativeAppInstallAd);
          return;
          label57: a.a(a.this).q();
        }
      }
    });
    this.i.withAdListener(new AdListener()
    {
      public void onAdClicked()
      {
        a.b(a.this).e();
      }

      public void onAdClosed()
      {
        a.b(a.this).b();
      }

      public void onAdFailedToLoad(int paramAnonymousInt)
      {
        a.b(a.this).a(paramAnonymousInt);
      }

      public void onAdImpression()
      {
        a.b(a.this).f();
      }

      public void onAdLeftApplication()
      {
        a.b(a.this).c();
      }

      public void onAdLoaded()
      {
        a.b(a.this).a();
      }

      public void onAdOpened()
      {
        a.b(a.this).d();
      }
    });
    this.h = this.i.build();
    this.k.a(new p()
    {
      public void a()
      {
        i.b("PM impression recorded");
      }

      public void a(n paramAnonymousn)
      {
        a.a(a.this, paramAnonymousn);
        if (ad.c() > 0)
          ad.f();
        ad.a(paramAnonymousn);
        ad.a(a.c(a.this));
        Double localDouble1 = paramAnonymousn.u();
        if (paramAnonymousn.v() != null)
          a.a(a.this, paramAnonymousn.v());
        i.b("biddingInterval: " + a.d(a.this));
        Double localDouble2 = o.a(localDouble1, a.d(a.this));
        if (localDouble2 != null)
        {
          String str = String.format("%.2f", new Object[] { localDouble2 });
          i.b("passing ecpm of " + str);
          PublisherAdRequest localPublisherAdRequest = a.e(a.this).addCustomTargeting("ecpm", str).build();
          a.f(a.this).loadAd(localPublisherAdRequest);
          return;
        }
        a.f(a.this).loadAd(a.e(a.this).build());
      }

      public void a(String paramAnonymousString)
      {
        a.f(a.this).loadAd(a.e(a.this).build());
      }

      public boolean b(n paramAnonymousn)
      {
        i.b("PM native Ad Clicked");
        return false;
      }
    });
    this.k.a(localaa);
  }

  private void d()
  {
    if (this.c == null)
      this.c = new PublisherAdRequest.Builder();
    if (this.d == null)
      this.d = new aa.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("hb", "1");
    aa localaa = this.d.a(localHashMap).a();
    if (this.j.getAdSize() == null)
    {
      i.e("AdSize not set, please use setAdSizes() method");
      return;
    }
    this.e = this.j.getAdSize().getWidth();
    this.f = this.j.getAdSize().getHeight();
    this.k.a(this.e, this.f);
    this.k.a(new v()
    {
      public void a(w paramAnonymousw)
      {
      }

      public void a(String paramAnonymousString)
      {
        a.g(a.this).loadAd(a.e(a.this).build());
      }

      public void b(w paramAnonymousw)
      {
        if (ad.d() > 0)
          ad.b();
        ad.a(paramAnonymousw);
        Double localDouble1 = paramAnonymousw.getEcpm();
        if (paramAnonymousw.getBiddingInterval() != null)
          a.a(a.this, paramAnonymousw.getBiddingInterval());
        i.b("biddingInterval: " + a.d(a.this));
        Double localDouble2 = o.a(localDouble1, a.d(a.this));
        if (localDouble2 != null)
        {
          String str = String.format("%.2f", new Object[] { localDouble2 });
          PublisherAdRequest localPublisherAdRequest = a.e(a.this).addCustomTargeting("ecpm", str).build();
          i.b("passing ecpm of " + str);
          a.g(a.this).loadAd(localPublisherAdRequest);
          return;
        }
        a.g(a.this).loadAd(a.e(a.this).build());
      }

      public void c(w paramAnonymousw)
      {
        i.b("PM banner clicked");
      }
    });
    this.k.a(Boolean.valueOf(true));
    this.k.a(localaa);
  }

  private void e()
  {
    if (this.c == null)
      this.c = new PublisherAdRequest.Builder();
    if (this.d == null)
      this.d = new aa.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("hb", "1");
    if (this.o != null)
      localHashMap.put("sdk_token", this.o);
    aa localaa = this.d.a(localHashMap).a();
    this.k.a(this.e, this.f);
    this.k.a(new v()
    {
      public void a(w paramAnonymousw)
      {
      }

      public void a(String paramAnonymousString)
      {
        a.f(a.this).loadAd(a.e(a.this).build());
      }

      public void b(w paramAnonymousw)
      {
        if (ad.d() > 0)
          ad.b();
        ad.a(paramAnonymousw);
        Double localDouble1 = paramAnonymousw.getEcpm();
        if (paramAnonymousw.getBiddingInterval() != null)
          a.a(a.this, paramAnonymousw.getBiddingInterval());
        i.b("biddingInterval: " + a.d(a.this));
        Double localDouble2 = o.a(localDouble1, a.d(a.this));
        if (localDouble2 != null)
        {
          String str = String.format("%.2f", new Object[] { localDouble2 });
          PublisherAdRequest localPublisherAdRequest = a.e(a.this).addCustomTargeting("ecpm", str).build();
          i.b("passing ecpm of " + str);
          a.f(a.this).loadAd(localPublisherAdRequest);
          return;
        }
        a.f(a.this).loadAd(a.e(a.this).build());
      }

      public void c(w paramAnonymousw)
      {
        i.b("PM banner clicked");
      }
    });
    this.i.forContentAd(new NativeContentAd.OnContentAdLoadedListener()
    {
      public void onContentAdLoaded(NativeContentAd paramAnonymousNativeContentAd)
      {
        if (a.a(a.this) != null)
        {
          String str = paramAnonymousNativeContentAd.getExtras().getString("providerName");
          if ((str == null) || (!str.equalsIgnoreCase("polymorph")))
            break label57;
          a.a(a.this).p();
        }
        while (true)
        {
          a.b(a.this).a(paramAnonymousNativeContentAd);
          return;
          label57: a.a(a.this).q();
        }
      }
    });
    this.i.forAppInstallAd(new NativeAppInstallAd.OnAppInstallAdLoadedListener()
    {
      public void onAppInstallAdLoaded(NativeAppInstallAd paramAnonymousNativeAppInstallAd)
      {
        if (a.a(a.this) != null)
        {
          String str = paramAnonymousNativeAppInstallAd.getExtras().getString("providerName");
          if ((str == null) || (!str.equalsIgnoreCase("polymorph")))
            break label57;
          a.a(a.this).p();
        }
        while (true)
        {
          a.b(a.this).a(paramAnonymousNativeAppInstallAd);
          return;
          label57: a.a(a.this).q();
        }
      }
    });
    this.i.withAdListener(new AdListener()
    {
      public void onAdClicked()
      {
        a.b(a.this).e();
      }

      public void onAdClosed()
      {
        a.b(a.this).b();
      }

      public void onAdFailedToLoad(int paramAnonymousInt)
      {
        a.b(a.this).a(paramAnonymousInt);
      }

      public void onAdImpression()
      {
        a.b(a.this).f();
      }

      public void onAdLeftApplication()
      {
        a.b(a.this).c();
      }

      public void onAdLoaded()
      {
        a.b(a.this).a();
      }

      public void onAdOpened()
      {
        a.b(a.this).d();
      }
    });
    this.h = this.i.build();
    this.k.a(new p()
    {
      public void a()
      {
      }

      public void a(n paramAnonymousn)
      {
        a.a(a.this, paramAnonymousn);
        if (ad.c() > 0)
          ad.f();
        ad.a(paramAnonymousn);
        Double localDouble1 = paramAnonymousn.u();
        if (paramAnonymousn.v() != null)
          a.a(a.this, paramAnonymousn.v());
        i.b("biddingInterval: " + a.d(a.this));
        Double localDouble2 = o.a(localDouble1, a.d(a.this));
        if (localDouble2 != null)
        {
          String str = String.format("%.2f", new Object[] { localDouble2 });
          i.b("passing ecpm of " + str);
          PublisherAdRequest localPublisherAdRequest = a.e(a.this).addCustomTargeting("ecpm", str).build();
          a.f(a.this).loadAd(localPublisherAdRequest);
          return;
        }
        a.f(a.this).loadAd(a.e(a.this).build());
      }

      public void a(String paramAnonymousString)
      {
        a.f(a.this).loadAd(a.e(a.this).build());
      }

      public boolean b(n paramAnonymousn)
      {
        return false;
      }
    });
    this.k.a(Boolean.valueOf(true));
    this.k.a(localaa);
  }

  public void a()
  {
  }

  public void a(aa.a parama)
  {
    this.d = parama;
  }

  public void a(PublisherAdRequest.Builder paramBuilder)
  {
    this.c = paramBuilder;
  }

  public void a(a parama)
  {
    this.m = parama;
  }

  public void b()
  {
    if (this.l.equalsIgnoreCase(com.adsnative.ads.a.a.c.toString()))
      e();
    if (this.l.equalsIgnoreCase(com.adsnative.ads.a.a.a.toString()))
      d();
    if (this.l.equalsIgnoreCase(com.adsnative.ads.a.a.b.toString()))
      c();
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(int paramInt);

    public abstract void a(NativeAppInstallAd paramNativeAppInstallAd);

    public abstract void a(NativeContentAd paramNativeContentAd);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.polymorph.dfp.a
 * JD-Core Version:    0.6.2
 */