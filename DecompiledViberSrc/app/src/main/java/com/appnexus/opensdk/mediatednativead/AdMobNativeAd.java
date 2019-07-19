package com.appnexus.opensdk.mediatednativead;

import android.content.Context;
import com.appnexus.opensdk.MediatedNativeAd;
import com.appnexus.opensdk.MediatedNativeAdController;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.TargetingParameters;
import com.appnexus.opensdk.mediatedviews.GooglePlayServicesBanner;
import com.appnexus.opensdk.utils.Clog;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;

public class AdMobNativeAd
  implements MediatedNativeAd
{
  public void requestNativeAd(Context paramContext, String paramString1, String paramString2, MediatedNativeAdController paramMediatedNativeAdController, TargetingParameters paramTargetingParameters)
  {
    AdMobNativeListener localAdMobNativeListener;
    AdLoader.Builder localBuilder1;
    NativeAdOptions.Builder localBuilder;
    if (paramMediatedNativeAdController != null)
    {
      if ((!AdMobNativeSettings.b) && (!AdMobNativeSettings.a))
        break label139;
      localAdMobNativeListener = new AdMobNativeListener(paramMediatedNativeAdController);
      localBuilder1 = new AdLoader.Builder(paramContext, paramString2).withAdListener(localAdMobNativeListener);
      localBuilder = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(false);
      if (!AdMobNativeSettings.c)
        break label133;
    }
    label133: for (int i = 1; ; i = 2)
    {
      AdLoader.Builder localBuilder2 = localBuilder1.withNativeAdOptions(localBuilder.setAdChoicesPlacement(i).build());
      if (AdMobNativeSettings.b)
        localBuilder2.forAppInstallAd(localAdMobNativeListener);
      if (AdMobNativeSettings.a)
        localBuilder2.forContentAd(localAdMobNativeListener);
      localBuilder2.withAdListener(localAdMobNativeListener);
      localBuilder2.build().loadAd(GooglePlayServicesBanner.buildRequest(paramTargetingParameters));
      return;
    }
    label139: Clog.w(Clog.mediationLogTag, "Unable to get AdMob Native ad since both AdMobNativeSettings.setEnableContentAd() and AdMobNativeSettings.setEnableAppInstallAd() were not called.");
    paramMediatedNativeAdController.onAdFailed(ResultCode.MEDIATED_SDK_UNAVAILABLE);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.mediatednativead.AdMobNativeAd
 * JD-Core Version:    0.6.2
 */