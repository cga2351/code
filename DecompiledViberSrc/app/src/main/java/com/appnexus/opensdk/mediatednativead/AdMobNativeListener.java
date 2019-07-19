package com.appnexus.opensdk.mediatednativead;

import com.appnexus.opensdk.MediatedNativeAdController;
import com.appnexus.opensdk.NativeAdEventListener;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.utils.Clog;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;

public class AdMobNativeListener extends AdListener
  implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener
{
  MediatedNativeAdController a;
  AdMobNativeAdResponse b;

  public AdMobNativeListener(MediatedNativeAdController paramMediatedNativeAdController)
  {
    this.a = paramMediatedNativeAdController;
  }

  public void onAdClicked()
  {
    Clog.e(Clog.mediationLogTag, "AdMob - onAdClicked");
    if (this.b != null)
    {
      NativeAdEventListener localNativeAdEventListener = this.b.a();
      if (localNativeAdEventListener != null)
        localNativeAdEventListener.onAdWasClicked();
    }
  }

  public void onAdFailedToLoad(int paramInt)
  {
    ResultCode localResultCode;
    if (this.a != null)
    {
      localResultCode = ResultCode.INTERNAL_ERROR;
      switch (paramInt)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      this.a.onAdFailed(localResultCode);
      return;
      localResultCode = ResultCode.INTERNAL_ERROR;
      continue;
      localResultCode = ResultCode.INVALID_REQUEST;
      continue;
      localResultCode = ResultCode.NETWORK_ERROR;
      continue;
      localResultCode = ResultCode.UNABLE_TO_FILL;
    }
  }

  public void onAdImpression()
  {
    Clog.e(Clog.mediationLogTag, "AdMob - onAdImpression");
    if (this.a != null)
      this.a.onAdImpression();
  }

  public void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd)
  {
    if (this.a != null)
    {
      this.b = new AdMobNativeAdResponse(paramNativeAppInstallAd, AdMobNativeSettings.AdMobNativeType.APP_INSTALL);
      this.a.onAdLoaded(this.b);
    }
  }

  public void onContentAdLoaded(NativeContentAd paramNativeContentAd)
  {
    if (this.a != null)
    {
      this.b = new AdMobNativeAdResponse(paramNativeContentAd, AdMobNativeSettings.AdMobNativeType.CONTENT_AD);
      this.a.onAdLoaded(this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.mediatednativead.AdMobNativeListener
 * JD-Core Version:    0.6.2
 */