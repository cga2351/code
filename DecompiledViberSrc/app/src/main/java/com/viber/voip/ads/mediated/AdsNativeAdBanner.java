package com.viber.voip.ads.mediated;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.MediatedBannerAdViewController;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.TargetingParameters;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.q.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.banner.a.a.g;
import com.viber.voip.banner.datatype.AdsCallMetaInfo;
import com.viber.voip.banner.view.AdsAfterCallRemoteBannerLayout;
import com.viber.voip.banner.view.a.c.a;
import com.viber.voip.banner.view.f;
import com.viber.voip.banner.view.f.a;

public class AdsNativeAdBanner extends AdsNativeNativeAd
  implements MediatedBannerAdView
{
  private static final int BANNER_HEIGHT = 250;
  private static final int BANNER_WIDTH = 300;
  private static final Logger L = ViberEnv.getLogger();

  public void destroy()
  {
  }

  public void onDestroy()
  {
    destroy();
  }

  public void onPause()
  {
  }

  public void onResume()
  {
  }

  public View requestAd(final MediatedBannerAdViewController paramMediatedBannerAdViewController, final Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, TargetingParameters paramTargetingParameters)
  {
    Object localObject;
    if (((paramInt1 != 300) || (paramInt2 != 250)) && (paramMediatedBannerAdViewController != null))
    {
      paramMediatedBannerAdViewController.onAdFailed(ResultCode.INTERNAL_ERROR);
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = new AdsAfterCallRemoteBannerLayout(paramActivity);
    }
    while (paramMediatedBannerAdViewController == null);
    av.a(av.e.e).post(new Runnable()
    {
      public void run()
      {
        Uri localUri = AdsNativeAdBanner.this.adsUrlProvider.a(17);
        q.a locala = AdsNativeAdBanner.this.adsNativeFetcher.a(localUri);
        if (locala.b != 0)
        {
          av.a(av.e.a).post(new a(paramMediatedBannerAdViewController));
          return;
        }
        final AdsCallMetaInfo localAdsCallMetaInfo = com.viber.voip.banner.e.a.e(locala.a);
        if (localAdsCallMetaInfo.getItem(0) == null)
        {
          av.a(av.e.a).post(new b(paramMediatedBannerAdViewController));
          return;
        }
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            final com.viber.voip.ads.d.q localq = new com.viber.voip.ads.d.q(localAdsCallMetaInfo.getItem(0));
            com.viber.voip.banner.view.a.b.a(AdsNativeAdBanner.1.this.b).a(localq, new c.a()
            {
              public void onRemoteBannerError(long paramAnonymous3Long, f paramAnonymous3f, int paramAnonymous3Int)
              {
                AdsNativeAdBanner.1.this.a.onAdFailed(ResultCode.INTERNAL_ERROR);
              }

              public void onRemoteBannerReady(long paramAnonymous3Long, f paramAnonymous3f)
              {
                paramAnonymous3f.setActionListener(new f.a()
                {
                  public boolean onBannerAction(long paramAnonymous4Long, String paramAnonymous4String, int paramAnonymous4Int, f paramAnonymous4f)
                  {
                    AdsNativeAdBanner.this.handleAdOnClickAction(AdsNativeAdBanner.1.1.1.this.a);
                    AdsNativeAdBanner.1.this.a.onAdClicked();
                    return true;
                  }

                  public void onBannerCloseAction(long paramAnonymous4Long, f paramAnonymous4f)
                  {
                    AdsNativeAdBanner.1.this.a.onAdCollapsed();
                  }
                });
                AdsNativeAdBanner.1.this.a.onAdLoaded();
                AdsNativeAdBanner.this.handleAdLoaded(localq);
              }
            }
            , AdsNativeAdBanner.1.this.c, 1);
          }
        });
      }
    });
    return localObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.mediated.AdsNativeAdBanner
 * JD-Core Version:    0.6.2
 */