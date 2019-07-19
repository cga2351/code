package com.yandex.mobile.ads.mediation.nativeads;

import com.yandex.mobile.ads.nativeads.NativeAdViewBinder;

abstract interface MediatedNativeAd
{
  public abstract void bindNativeAd(NativeAdViewBinder paramNativeAdViewBinder);

  public abstract void destroy();

  public abstract MediatedNativeAdAssets getMediatedNativeAdAssets();

  public abstract void unbindNativeAd(NativeAdViewBinder paramNativeAdViewBinder);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAd
 * JD-Core Version:    0.6.2
 */