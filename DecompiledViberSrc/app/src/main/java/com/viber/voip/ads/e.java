package com.viber.voip.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.MediaView;
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
import com.viber.voip.ads.a.d;
import com.viber.voip.ads.d.g;
import com.viber.voip.ads.d.h;
import com.viber.voip.ads.d.i;
import com.viber.voip.banner.datatype.AdsCallMetaInfo;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AltAdsConfig;
import com.viber.voip.banner.view.f;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.util.ax;
import com.viber.voip.util.dj;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class e
  implements i
{
  public static final long a = TimeUnit.MINUTES.toSeconds(2L);
  private static final com.viber.common.a.e b = ViberEnv.getLogger();
  private Context c;
  private com.viber.voip.ads.d.a d;
  private final Object e = new Object();
  private final Handler f;
  private final Handler g;
  private o h;
  private final PhoneController i;
  private final ICdrController j;
  private final AtomicReference<a> k = new AtomicReference();

  public e(Context paramContext, PhoneController paramPhoneController, ICdrController paramICdrController, Handler paramHandler1, Handler paramHandler2)
  {
    this.c = paramContext;
    this.i = paramPhoneController;
    this.f = paramHandler2;
    this.g = paramHandler1;
    this.j = paramICdrController;
  }

  private View a(Context paramContext, NativeAd paramNativeAd, f paramf)
  {
    if ((paramNativeAd instanceof NativeContentAd));
    for (Object localObject = new com.viber.voip.ads.d.e(new NativeContentAdView(paramContext)); ; localObject = new com.viber.voip.ads.d.c(new NativeAppInstallAdView(paramContext)))
    {
      dj.h(((h)localObject).a());
      ((h)localObject).a(paramNativeAd);
      MediaView localMediaView = (MediaView)paramf.findViewById(R.id.after_call_ad_image);
      if (localMediaView != null)
        ((h)localObject).a(localMediaView);
      View localView1 = paramf.findViewById(R.id.after_call_ad_app_icon);
      if (localView1 != null)
        ((h)localObject).e(localView1);
      View localView2 = paramf.findViewById(R.id.after_call_ad_title);
      if (localView2 != null)
        ((h)localObject).b(localView2);
      View localView3 = paramf.findViewById(R.id.after_call_ad_text);
      if (localView3 != null)
        ((h)localObject).c(localView3);
      View localView4 = paramf.findViewById(R.id.remote_banner_button);
      if (localView4 != null)
        ((h)localObject).d(localView4);
      ((h)localObject).a(paramf, new FrameLayout.LayoutParams(paramf.getLayoutParams()));
      return ((h)localObject).a();
      if (!(paramNativeAd instanceof NativeAppInstallAd))
        break;
    }
    return null;
  }

  public com.viber.voip.ads.d.a a()
  {
    synchronized (this.e)
    {
      com.viber.voip.ads.d.a locala = this.d;
      return locala;
    }
  }

  public void a(Activity paramActivity, AdsCallMetaInfo paramAdsCallMetaInfo, final CallInfo paramCallInfo, final int paramInt, com.viber.voip.ads.b.b.b.c paramc)
  {
    final a locala = new a(this.c, this.i, this.j, 3, paramCallInfo, paramInt, paramAdsCallMetaInfo.getAltAdsConfig().getAdUnitId(), 0);
    this.k.set(locala);
    final AdSize localAdSize = AdSize.MEDIUM_RECTANGLE;
    final AdsCallMetaInfo.AltAdsConfig localAltAdsConfig = paramAdsCallMetaInfo.getAltAdsConfig();
    if (!com.viber.voip.util.k.a.a(localAdSize, this.c))
      return;
    final Map localMap = com.viber.voip.util.k.a.b(this.c);
    this.f.post(new Runnable()
    {
      public void run()
      {
        final PublisherAdView localPublisherAdView = new PublisherAdView(e.c(e.this));
        localPublisherAdView.setAdUnitId(localAltAdsConfig.getAdUnitId());
        AdSize[] arrayOfAdSize = new AdSize[1];
        arrayOfAdSize[0] = localAdSize;
        localPublisherAdView.setAdSizes(arrayOfAdSize);
        localPublisherAdView.setAdListener(new AdListener()
        {
          public void onAdClosed()
          {
            if (e.d(e.this) != null)
              e.d(e.this).onAdClosed(e.this);
          }

          public void onAdFailedToLoad(int paramAnonymous2Int)
          {
            int i;
            switch (paramAnonymous2Int)
            {
            default:
              i = 1;
            case 0:
            case 1:
            case 2:
            case 3:
            }
            while (true)
            {
              if (e.e(e.this).compareAndSet(e.2.this.c, null))
                e.h(e.this).post(new e.a(e.c(e.this), e.f(e.this), e.g(e.this), i, e.2.this.d, e.2.this.e, e.2.this.a.getAdUnitId(), 0));
              return;
              i = 4;
              continue;
              i = 5;
              continue;
              i = 6;
              continue;
              i = 7;
            }
          }

          public void onAdLoaded()
          {
            synchronized (e.a(e.this))
            {
              e.a(e.this, new g(localPublisherAdView, e.2.this.a));
              e.b(e.this).a(true);
              if (e.e(e.this).compareAndSet(e.2.this.c, null))
                e.h(e.this).post(new e.a(e.c(e.this), e.f(e.this), e.g(e.this), 0, e.2.this.d, e.2.this.e, e.2.this.a.getAdUnitId(), 0));
              return;
            }
          }

          public void onAdOpened()
          {
            if (e.d(e.this) != null)
              e.d(e.this).onAdClicked(e.this);
          }
        });
        PublisherAdRequest.Builder localBuilder = new PublisherAdRequest.Builder();
        com.viber.voip.util.k.a.a(com.viber.common.permission.c.a(ViberApplication.getApplication()), localBuilder);
        Calendar localCalendar = com.viber.voip.util.k.a.b();
        if (localCalendar != null)
          localBuilder.setBirthday(localCalendar.getTime());
        localBuilder.setGender(d.values()[com.viber.voip.settings.d.c.a.d()].toAdmobGender());
        if (localMap != null)
        {
          Iterator localIterator = localMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            localBuilder.addCustomTargeting((String)localEntry.getKey(), (String)localEntry.getValue());
          }
        }
        localPublisherAdView.loadAd(localBuilder.build());
      }
    });
  }

  public void a(Context paramContext, f paramf, c paramc)
  {
    if ((this.d instanceof g));
    for (Object localObject = ((g)this.d).c(); ; localObject = a(paramContext, this.d.a(), paramf))
    {
      if (paramc != null)
        paramc.onAdLoaded((View)localObject);
      return;
    }
  }

  public void a(o paramo)
  {
    this.h = paramo;
  }

  public void b()
  {
    this.f.post(new Runnable()
    {
      public void run()
      {
        synchronized (e.a(e.this))
        {
          if (e.b(e.this) != null)
          {
            e.b(e.this).b();
            e.a(e.this, null);
          }
          return;
        }
      }
    });
    a locala = (a)this.k.getAndSet(null);
    if (locala != null)
      this.g.post(locala);
  }

  public boolean c()
  {
    while (true)
    {
      synchronized (this.e)
      {
        if (this.d != null)
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
    this.h = null;
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
 * Qualified Name:     com.viber.voip.ads.e
 * JD-Core Version:    0.6.2
 */