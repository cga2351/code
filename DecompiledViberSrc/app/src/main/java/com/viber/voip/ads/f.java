package com.viber.voip.ads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import com.viber.jni.cdr.CdrConst.AdTypes;
import com.viber.jni.cdr.CdrConst.AdsAfterCallTypeCall.Converter;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.a.a.a.a.a;
import com.viber.voip.ads.d.d;
import com.viber.voip.ads.d.h;
import com.viber.voip.ads.d.i;
import com.viber.voip.banner.datatype.AdsCallMetaInfo;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AltAdsConfig;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.CustomAdsNativesConfig;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.util.ax;
import com.viber.voip.util.da;
import com.viber.voip.util.e.j;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class f
  implements i
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();
  private Context b;
  private com.viber.voip.ads.d.a c;
  private final Object d = new Object();
  private final Handler e;
  private final Handler f;
  private o g;
  private final PhoneController h;
  private final ICdrController i;
  private final AtomicReference<a> j = new AtomicReference();
  private final com.viber.voip.ads.b.a.a.a k;

  public f(Context paramContext, PhoneController paramPhoneController, ICdrController paramICdrController, Handler paramHandler1, Handler paramHandler2, com.viber.voip.ads.b.a.a.a parama)
  {
    this.b = paramContext;
    this.h = paramPhoneController;
    this.e = paramHandler2;
    this.f = paramHandler1;
    this.i = paramICdrController;
    this.k = parama;
  }

  private View a(Context paramContext, NativeAd paramNativeAd, com.viber.voip.banner.view.f paramf)
  {
    if ((paramNativeAd instanceof NativeContentAd));
    for (Object localObject = new com.viber.voip.ads.d.e(new NativeContentAdView(paramContext)); ; localObject = new com.viber.voip.ads.d.c(new NativeAppInstallAdView(paramContext)))
    {
      ((h)localObject).a(paramNativeAd);
      ImageView localImageView = (ImageView)paramf.findViewById(R.id.after_call_ad_image);
      if (localImageView != null)
        ((h)localObject).a(localImageView);
      View localView2 = paramf.findViewById(R.id.after_call_ad_app_icon);
      LinearLayout localLinearLayout = null;
      if (localView2 != null)
      {
        localLinearLayout = a(paramContext);
        ViewGroup localViewGroup = (ViewGroup)localView2.getParent();
        int m = localViewGroup.indexOfChild(localView2);
        localViewGroup.removeView(localView2);
        localLinearLayout.addView(localView2);
        localViewGroup.addView(localLinearLayout, m);
        ((h)localObject).e(localView2);
      }
      View localView3 = paramf.findViewById(R.id.after_call_ad_title);
      if (localView3 != null)
      {
        if (localLinearLayout != null)
        {
          ((ViewGroup)localView3.getParent()).removeView(localView3);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.setMargins(j.a(10.0F), 0, 0, 0);
          localLinearLayout.addView(localView3, localLayoutParams);
        }
        ((h)localObject).b(localView3);
      }
      View localView4 = paramf.findViewById(R.id.after_call_ad_text);
      if (localView4 != null)
        ((h)localObject).c(localView4);
      View localView5 = paramf.findViewById(R.id.remote_banner_button);
      if (localView5 != null)
        ((h)localObject).d(localView5);
      ((h)localObject).a(paramf, new FrameLayout.LayoutParams(paramf.getLayoutParams()));
      View localView1 = ((h)localObject).a();
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
    localLayoutParams.topMargin = j.a(7.0F);
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setId(R.id.after_call_ad_google_icon_container);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(19);
    return localLinearLayout;
  }

  public com.viber.voip.ads.d.a a()
  {
    synchronized (this.d)
    {
      com.viber.voip.ads.d.a locala = this.c;
      return locala;
    }
  }

  public void a(Activity paramActivity, AdsCallMetaInfo paramAdsCallMetaInfo, final CallInfo paramCallInfo, final int paramInt, com.viber.voip.ads.b.b.b.c paramc)
  {
    final a locala = new a(this.b, this.h, this.i, 3, paramCallInfo, paramInt, paramAdsCallMetaInfo.getAltAdsConfig().getAdUnitId(), 0);
    this.j.set(locala);
    final AdsCallMetaInfo.AltAdsConfig localAltAdsConfig = paramAdsCallMetaInfo.getAltAdsConfig();
    boolean bool1 = localAltAdsConfig instanceof AdsCallMetaInfo.CustomAdsNativesConfig;
    String str1 = null;
    String str2 = null;
    if (bool1)
    {
      str2 = ((AdsCallMetaInfo.CustomAdsNativesConfig)localAltAdsConfig).getAdsNativeAdUnitId();
      str1 = ((AdsCallMetaInfo.CustomAdsNativesConfig)localAltAdsConfig).getAdsNativeGoogleAdUnitId();
    }
    if ((da.a(str2)) || (da.a(str1)))
      return;
    Map localMap1 = com.viber.voip.util.k.a.b(this.b);
    Map localMap2 = com.viber.voip.util.k.a.c(this.b);
    boolean bool2 = com.viber.common.permission.c.a(ViberApplication.getApplication()).a(new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
    Location localLocation = null;
    if (bool2)
      localLocation = ViberApplication.getInstance().getLocationManager().b(0);
    com.viber.voip.ads.b.a.a.a.a locala1 = new a.a(paramActivity, 0, str2, str1).a(localMap1).b(localMap2).a(localLocation).a(1).a();
    this.k.a(locala1, new com.viber.voip.ads.b.b.a.c()
    {
      public void a()
      {
        if (f.a(f.this) != null)
          f.a(f.this).onAdClosed(f.this);
      }

      public void a(com.viber.voip.ads.b.b.b.a paramAnonymousa)
      {
        synchronized (f.b(f.this))
        {
          if ((paramAnonymousa instanceof com.viber.voip.ads.b.a.b.a.a))
          {
            f.a(f.this, new com.viber.voip.ads.d.b((NativeAppInstallAd)((com.viber.voip.ads.b.a.b.a.a)paramAnonymousa).x(), null, "", ""));
            ((com.viber.voip.ads.d.b)f.c(f.this)).b(false);
          }
          while (!(paramAnonymousa instanceof com.viber.voip.ads.b.a.b.a.b))
          {
            f.c(f.this).a(true);
            if (f.d(f.this).compareAndSet(locala, null))
              f.h(f.this).post(new f.a(f.e(f.this), f.f(f.this), f.g(f.this), 0, paramCallInfo, paramInt, localAltAdsConfig.getAdUnitId(), 0));
            return;
          }
          f.a(f.this, new d((NativeContentAd)((com.viber.voip.ads.b.a.b.a.b)paramAnonymousa).x(), null, "", ""));
          ((d)f.c(f.this)).b(false);
        }
      }

      public void a(com.viber.voip.ads.b.b.b.b paramAnonymousb)
      {
        if (f.d(f.this).compareAndSet(locala, null))
          f.h(f.this).post(new f.a(f.e(f.this), f.f(f.this), f.g(f.this), paramAnonymousb.a(), paramCallInfo, paramInt, localAltAdsConfig.getAdUnitId(), 0));
      }

      public void b()
      {
        if (f.a(f.this) != null)
          f.a(f.this).onAdClicked(f.this);
      }

      public void c()
      {
      }

      public void d()
      {
        com.viber.voip.ads.b.b.a.b.d(this);
      }
    });
  }

  public void a(Context paramContext, com.viber.voip.banner.view.f paramf, c paramc)
  {
    View localView = a(paramContext, this.c.a(), paramf);
    if (paramc != null)
      paramc.onAdLoaded(localView);
  }

  public void a(o paramo)
  {
    this.g = paramo;
  }

  public void b()
  {
    this.e.post(new g(this));
    a locala = (a)this.j.getAndSet(null);
    if (locala != null)
      this.f.post(locala);
  }

  public boolean c()
  {
    while (true)
    {
      synchronized (this.d)
      {
        if (this.c != null)
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

  private static class a
    implements Runnable
  {
    private final Context a;
    private final PhoneController b;
    private final ICdrController c;
    private final int d;
    private final CallInfo e;
    private final int f;
    private final String g;
    private final int h;

    public a(Context paramContext, PhoneController paramPhoneController, ICdrController paramICdrController, int paramInt1, CallInfo paramCallInfo, int paramInt2, String paramString, int paramInt3)
    {
      this.a = paramContext;
      this.b = paramPhoneController;
      this.c = paramICdrController;
      this.d = paramInt1;
      this.e = paramCallInfo;
      this.f = paramInt2;
      this.g = paramString;
      this.h = paramInt3;
    }

    public void run()
    {
      long l = this.e.getInCallState().getCallToken();
      if (l <= 0L)
        l = this.b.handleGetCallToken();
      int i = CdrConst.AdTypes.fromAdType("google admob sdk");
      this.c.handleReportAdRequestSent(ax.a(this.a.getPackageManager()), this.d, l, this.f, CdrConst.AdsAfterCallTypeCall.Converter.fromCallInfo(this.e), 2, i, this.g, "", this.h);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.f
 * JD-Core Version:    0.6.2
 */