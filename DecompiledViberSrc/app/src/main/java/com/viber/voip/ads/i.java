package com.viber.voip.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.appnexus.opensdk.AdListener;
import com.appnexus.opensdk.AdView;
import com.appnexus.opensdk.NativeAdEventListener;
import com.appnexus.opensdk.NativeAdResponse;
import com.appnexus.opensdk.NativeAdResponse.Network;
import com.appnexus.opensdk.NativeAdSDK;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.SDKSettings;
import com.appnexus.opensdk.ViberBannerAdView;
import com.appnexus.opensdk.mediatednativead.AdMobNativeSettings;
import com.appnexus.opensdk.mediatednativead.AdMobNativeSettings.AdMobNativeType;
import com.appnexus.opensdk.utils.Settings;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.d.k;
import com.viber.voip.ads.d.m;
import com.viber.voip.ads.mediated.AdsNativeNativeAd;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.banner.datatype.AdsCallMetaInfo;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AltAdsConfig;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.f;
import com.viber.voip.util.ax;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class i extends p
{
  private static final long b = TimeUnit.MINUTES.toMillis(5L);
  private static final long c = TimeUnit.HOURS.toMillis(6L);
  private static final com.viber.common.a.e d = ViberEnv.getLogger();
  private Context e;
  private final Handler f;
  private o g;
  private final Object h = new Object();
  private com.viber.voip.ads.d.j i;
  private NativeAdResponse j;
  private AdView k;
  private boolean l;
  private h m;
  private CallInfo n;
  private AdsCallMetaInfo o;
  private Activity p;
  private int q;
  private com.viber.voip.ads.b.b.b.c r;
  private boolean s;
  private final d.al t;
  private final com.viber.common.permission.c u;
  private com.viber.voip.g.b.b<com.viber.voip.util.e.e> v;
  private com.viber.voip.util.e.f w;

  public i(final Context paramContext, PhoneController paramPhoneController, ICdrController paramICdrController, Handler paramHandler1, Handler paramHandler2)
  {
    super("AppNexusTimer");
    this.e = paramContext;
    this.f = paramHandler2;
    SDKSettings.useHttps(true);
    Context localContext = this.e;
    Settings.getSettings().getClass();
    this.m = new h(localContext, paramPhoneController, paramICdrController, 3, paramHandler1, "4.11.2");
    AdMobNativeSettings.setEnableAppInstallAd(true);
    AdMobNativeSettings.setEnableContentAd(true);
    this.u = com.viber.common.permission.c.a(ViberApplication.getApplication());
    this.v = new com.viber.voip.g.b.b()
    {
      protected com.viber.voip.util.e.e a()
      {
        return com.viber.voip.util.e.e.a(paramContext);
      }
    };
    this.w = com.viber.voip.util.e.f.a();
    g();
    Handler localHandler = this.f;
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
    arrayOfa[0] = d.f.d;
    this.t = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        i.a(i.this);
      }
    };
    com.viber.voip.settings.d.a(this.t);
    Settings.getSettings().externalMediationClasses.put("com.appnexus.opensdk.mediatednativead.InMobiNativeAd", AdsNativeNativeAd.class.getName());
  }

  private View a(Context paramContext, NativeAd paramNativeAd, com.viber.voip.banner.view.f paramf)
  {
    if ((paramNativeAd instanceof NativeContentAd));
    for (Object localObject = new com.viber.voip.ads.d.e(new NativeContentAdView(paramContext)); ; localObject = new com.viber.voip.ads.d.c(new NativeAppInstallAdView(paramContext)))
    {
      dj.h(((com.viber.voip.ads.d.h)localObject).a());
      MediaView localMediaView = (MediaView)paramf.findViewById(R.id.after_call_ad_media);
      if (localMediaView != null)
        ((com.viber.voip.ads.d.h)localObject).a(localMediaView);
      View localView2 = paramf.findViewById(R.id.after_call_ad_app_icon);
      LinearLayout localLinearLayout = null;
      if (localView2 != null)
      {
        localLinearLayout = a(paramContext);
        ViewGroup localViewGroup = (ViewGroup)localView2.getParent();
        int i1 = localViewGroup.indexOfChild(localView2);
        localViewGroup.removeView(localView2);
        localLinearLayout.addView(localView2);
        localViewGroup.addView(localLinearLayout, i1);
        ((com.viber.voip.ads.d.h)localObject).e(localView2);
      }
      View localView3 = paramf.findViewById(R.id.after_call_ad_title);
      if (localView3 != null)
      {
        if (localLinearLayout != null)
        {
          ((ViewGroup)localView3.getParent()).removeView(localView3);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.setMargins(com.viber.voip.util.e.j.a(10.0F), 0, 0, 0);
          localLinearLayout.addView(localView3, localLayoutParams);
        }
        ((com.viber.voip.ads.d.h)localObject).b(localView3);
      }
      View localView4 = paramf.findViewById(R.id.after_call_ad_text);
      if (localView4 != null)
        ((com.viber.voip.ads.d.h)localObject).c(localView4);
      View localView5 = paramf.findViewById(R.id.remote_banner_button);
      if (localView5 != null)
        ((com.viber.voip.ads.d.h)localObject).d(localView5);
      ((com.viber.voip.ads.d.h)localObject).a(paramf, new FrameLayout.LayoutParams(paramf.getLayoutParams()));
      a(((com.viber.voip.ads.d.h)localObject).a());
      ((com.viber.voip.ads.d.h)localObject).a(paramNativeAd);
      View localView1 = ((com.viber.voip.ads.d.h)localObject).a();
      boolean bool;
      do
      {
        return localView1;
        bool = paramNativeAd instanceof NativeAppInstallAd;
        localView1 = null;
      }
      while (!bool);
    }
  }

  private LinearLayout a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = com.viber.voip.util.e.j.a(7.0F);
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setId(R.id.after_call_ad_google_icon_container);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(19);
    return localLinearLayout;
  }

  private void a(Context paramContext, final c paramc)
  {
    if ((this.k != null) && (paramc != null) && (this.l))
    {
      paramc.onAdLoaded(this.k);
      return;
    }
    this.m.a(6);
    this.m.a(f());
    com.viber.voip.util.k.a.a(this.u);
    final ViberBannerAdView localViberBannerAdView = new ViberBannerAdView(paramContext);
    localViberBannerAdView.setAutoRefreshInterval(0);
    localViberBannerAdView.setOpensNativeBrowser(true);
    localViberBannerAdView.setPlacementID(com.viber.voip.util.k.a.a(this.r, false));
    localViberBannerAdView.setAllowNativeDemand(true);
    localViberBannerAdView.setAdSize(300, 250);
    localViberBannerAdView.addCustomKeywords("viber_version", com.viber.voip.p.d());
    localViberBannerAdView.setGender(com.viber.voip.ads.a.d.values()[com.viber.voip.settings.d.c.a.d()].toAppNexusGender());
    Calendar localCalendar = com.viber.voip.util.k.a.b();
    if (localCalendar != null)
      localViberBannerAdView.setAge(String.valueOf(localCalendar.get(1)));
    if (d.f.d.d())
      localViberBannerAdView.addCustomKeywords("advertising_id", ax.a());
    AdListener local4 = new AdListener()
    {
      public void onAdClicked(AdView paramAnonymousAdView)
      {
        if (i.b(i.this) != null)
          i.b(i.this).onAdClicked(i.this);
      }

      public void onAdClicked(AdView paramAnonymousAdView, String paramAnonymousString)
      {
      }

      public void onAdCollapsed(AdView paramAnonymousAdView)
      {
        if (i.b(i.this) != null)
          i.b(i.this).onAdClosed(i.this);
      }

      public void onAdExpanded(AdView paramAnonymousAdView)
      {
      }

      public void onAdLoaded(AdView paramAnonymousAdView)
      {
        i.a(i.this, paramAnonymousAdView, paramc);
      }

      public void onAdLoaded(NativeAdResponse paramAnonymousNativeAdResponse)
      {
        i.a(i.this, paramAnonymousNativeAdResponse, i.c(i.this), i.d(i.this));
      }

      public void onAdRequestFailed(AdView paramAnonymousAdView, ResultCode paramAnonymousResultCode)
      {
        i.a(i.this, paramAnonymousResultCode);
      }
    };
    localViberBannerAdView.setAdListener(new a((com.viber.voip.util.e.e)this.v.get(), this.w, local4));
    av.a(av.e.e).post(new Runnable()
    {
      public void run()
      {
        localViberBannerAdView.loadAdOffscreen();
      }
    });
    h();
    dj.h(localViberBannerAdView);
    this.k = localViberBannerAdView;
  }

  private void a(View paramView)
  {
    NativeAdSDK.registerTracking(this.j, paramView, new NativeAdEventListener()
    {
      public void onAdWasClicked()
      {
        if (i.b(i.this) != null)
          i.b(i.this).onAdClicked(i.this);
      }

      public void onAdWasClicked(String paramAnonymousString1, String paramAnonymousString2)
      {
      }

      public void onAdWillLeaveApplication()
      {
      }
    });
  }

  private void a(ImageView paramImageView, com.viber.voip.ads.d.p paramp)
  {
    try
    {
      Bitmap localBitmap = paramp.b();
      if (localBitmap != null)
      {
        paramImageView.setImageBitmap(localBitmap);
        return;
      }
      String str = paramp.n();
      if (!da.b(str))
      {
        Uri localUri = Uri.parse(str);
        ((com.viber.voip.util.e.e)this.v.get()).a(localUri, paramImageView, this.w);
        return;
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void a(final AdView paramAdView, final c paramc)
  {
    int i1 = 1;
    h localh;
    if (!this.s)
    {
      this.l = i1;
      boolean bool1 = a(paramAdView);
      boolean bool2 = b(paramAdView);
      localh = this.m;
      if (!bool1)
        break label143;
      if (!bool2)
        break label138;
    }
    while (true)
    {
      localh.b(i1);
      this.m.a(101, this.n, this.q);
      synchronized (this.h)
      {
        this.i = new k(paramAdView, this.o.getAltAdsConfig());
        this.i.a(true);
        this.a.a();
        if (paramc != null)
          this.f.post(new Runnable()
          {
            public void run()
            {
              paramc.onAdLoaded(paramAdView);
            }
          });
        return;
        label138: i1 = 2;
        continue;
        label143: i1 = 0;
      }
    }
  }

  private void a(NativeAdResponse paramNativeAdResponse, CallInfo paramCallInfo, int paramInt)
  {
    int i1 = 1;
    label64: NativeContentAd localNativeContentAd;
    if (!this.s)
    {
      i();
      this.j = paramNativeAdResponse;
      NativeAdResponse.Network localNetwork = paramNativeAdResponse.getNetworkIdentifier();
      if ((localNetwork != NativeAdResponse.Network.ADMOB) && (localNetwork != NativeAdResponse.Network.CUSTOM))
        break label210;
      h localh = this.m;
      if (localNetwork != NativeAdResponse.Network.ADMOB)
        break label204;
      localh.b(i1);
      if (NativeAdResponse.Network.ADMOB != localNetwork)
        break label363;
      if (paramNativeAdResponse.getNativeElements().get(AdMobNativeSettings.NATIVE_ELEMENT_TYPE_KEY) != AdMobNativeSettings.AdMobNativeType.CONTENT_AD)
        break label243;
      localNativeContentAd = (NativeContentAd)paramNativeAdResponse.getNativeElements().get(AdMobNativeSettings.NATIVE_ELEMENT_OBJECT);
    }
    while (true)
    {
      synchronized (this.h)
      {
        AdsCallMetaInfo.AltAdsConfig localAltAdsConfig2 = this.o.getAltAdsConfig();
        if (localAltAdsConfig2 != null)
        {
          localLong2 = localAltAdsConfig2.getTimer();
          if (localAltAdsConfig2 == null)
            continue;
          str2 = localAltAdsConfig2.getPromotedByTag();
          this.i = new com.viber.voip.ads.d.d(localNativeContentAd, localLong2, str2, paramNativeAdResponse.getCreativeId());
          this.i.a(true);
          this.m.a(100, paramCallInfo, paramInt);
          this.a.a();
          return;
          label204: i1 = 2;
          break;
          label210: this.m.b(0);
          break label64;
        }
        Long localLong2 = null;
        continue;
        String str2 = "";
      }
      label243: NativeAppInstallAd localNativeAppInstallAd = (NativeAppInstallAd)paramNativeAdResponse.getNativeElements().get(AdMobNativeSettings.NATIVE_ELEMENT_OBJECT);
      while (true)
      {
        synchronized (this.h)
        {
          AdsCallMetaInfo.AltAdsConfig localAltAdsConfig1 = this.o.getAltAdsConfig();
          if (localAltAdsConfig1 != null)
          {
            localLong1 = localAltAdsConfig1.getTimer();
            if (localAltAdsConfig1 == null)
              break label355;
            str1 = localAltAdsConfig1.getPromotedByTag();
            this.i = new com.viber.voip.ads.d.b(localNativeAppInstallAd, localLong1, str1, paramNativeAdResponse.getCreativeId());
            this.i.a(true);
          }
        }
        Long localLong1 = null;
        continue;
        label355: String str1 = "";
      }
      label363: synchronized (this.h)
      {
        this.i = new m(this.j, this.o.getAltAdsConfig());
        this.i.a(true);
      }
    }
  }

  private void a(ResultCode paramResultCode)
  {
    if (paramResultCode == null);
    Pair localPair = com.viber.voip.util.k.a.a(paramResultCode);
    this.m.b(0);
    this.m.a(((Integer)localPair.first).intValue(), this.n, this.q);
  }

  private void a(com.viber.voip.banner.view.f paramf, c paramc)
  {
    ImageView localImageView = (ImageView)paramf.findViewById(R.id.after_call_ad_image);
    Object localObject1 = this.h;
    if (localImageView != null);
    try
    {
      if ((this.i instanceof com.viber.voip.ads.d.p))
        a(localImageView, (com.viber.voip.ads.d.p)this.i);
      a(paramf);
      paramc.onAdLoaded(paramf);
      return;
    }
    finally
    {
    }
  }

  private boolean a(AdView paramAdView)
  {
    return ((paramAdView instanceof ViberBannerAdView)) && (((ViberBannerAdView)paramAdView).isMediated());
  }

  private boolean b(AdView paramAdView)
  {
    return ((paramAdView instanceof ViberBannerAdView)) && ("Google".equals(((ViberBannerAdView)paramAdView).getAdNetworkName()));
  }

  private void g()
  {
    SDKSettings.setAAIDEnabled(d.f.d.d());
  }

  private void h()
  {
    if (this.k != null)
    {
      this.k.activityOnDestroy();
      this.k.destroy();
      this.k = null;
    }
  }

  private void i()
  {
    if (this.j != null)
    {
      this.j.destroy();
      this.j = null;
    }
  }

  public void a()
  {
    this.f.post(new Runnable()
    {
      public void run()
      {
        i.e(i.this);
        i.f(i.this);
      }
    });
    av.a(av.e.e).post(new Runnable()
    {
      public void run()
      {
        if (!i.g(i.this))
          i.this.a(i.h(i.this), i.i(i.this), i.c(i.this), i.d(i.this), i.j(i.this));
      }
    });
  }

  public void a(final Activity paramActivity, AdsCallMetaInfo paramAdsCallMetaInfo, CallInfo paramCallInfo, int paramInt, com.viber.voip.ads.b.b.b.c paramc)
  {
    if ((!com.viber.common.d.a.g()) && (paramActivity != null))
      CookieSyncManager.createInstance(paramActivity);
    this.s = false;
    this.p = paramActivity;
    this.n = paramCallInfo;
    this.o = paramAdsCallMetaInfo;
    this.q = paramInt;
    this.r = paramc;
    synchronized (this.h)
    {
      this.i = null;
      this.a.a(b);
      AdMobNativeSettings.setCallScreen(true);
      if (paramActivity != null)
        this.f.post(new Runnable()
        {
          public void run()
          {
            i.a(i.this, paramActivity, null);
          }
        });
      return;
    }
  }

  public void a(Context paramContext, com.viber.voip.banner.view.f paramf, c paramc)
  {
    super.a(paramContext, paramf, paramc);
    if ((this.i != null) && (this.i.y()))
    {
      if (((this.i instanceof com.viber.voip.ads.d.d)) || ((this.i instanceof com.viber.voip.ads.d.b)))
      {
        paramc.onAdLoaded(a(this.e, ((com.viber.voip.ads.d.a)this.i).a(), paramf));
        return;
      }
      a(paramf, paramc);
      return;
    }
    a(paramContext, paramc);
  }

  public void a(o paramo)
  {
    this.g = paramo;
  }

  public void b()
  {
    super.b();
    this.f.post(new Runnable()
    {
      public void run()
      {
        i.e(i.this);
        i.f(i.this);
        i.a(i.this, false);
        i.a(i.this, null);
      }
    });
    this.p = null;
    this.s = true;
  }

  public boolean c()
  {
    while (true)
    {
      synchronized (this.h)
      {
        if (this.i != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public void d()
  {
    this.g = null;
  }

  public com.viber.voip.ads.d.j e()
  {
    synchronized (this.h)
    {
      com.viber.voip.ads.d.j localj = this.i;
      return localj;
    }
  }

  public String f()
  {
    if ((this.o != null) && (this.o.getAltAdsConfig() != null))
      return com.viber.voip.util.k.a.a(this.r, false);
    return "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.i
 * JD-Core Version:    0.6.2
 */