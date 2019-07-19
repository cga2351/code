package com.yandex.mobile.ads.mediation.nativeads;

import com.yandex.mobile.ads.AdRequestError;

abstract interface MediatedNativeAdapterListener
{
  public abstract void onAdClicked();

  public abstract void onAdClosed();

  public abstract void onAdFailedToLoad(AdRequestError paramAdRequestError);

  public abstract void onAdImpression();

  public abstract void onAdLeftApplication();

  public abstract void onAdOpened();

  public abstract void onAppInstallAdLoaded(MediatedNativeAd paramMediatedNativeAd);

  public abstract void onContentAdLoaded(MediatedNativeAd paramMediatedNativeAd);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAdapterListener
 * JD-Core Version:    0.6.2
 */