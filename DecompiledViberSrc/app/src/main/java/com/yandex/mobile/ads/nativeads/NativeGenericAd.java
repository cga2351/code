package com.yandex.mobile.ads.nativeads;

public abstract interface NativeGenericAd
{
  public abstract void addImageLoadingListener(NativeAdImageLoadingListener paramNativeAdImageLoadingListener);

  public abstract void bindNativeAd(NativeAdViewBinder paramNativeAdViewBinder)
    throws NativeAdException;

  public abstract NativeAdAssets getAdAssets();

  public abstract NativeAdType getAdType();

  public abstract String getInfo();

  public abstract void loadImages();

  public abstract void removeImageLoadingListener(NativeAdImageLoadingListener paramNativeAdImageLoadingListener);

  public abstract void setAdEventListener(NativeAdEventListener paramNativeAdEventListener);

  public abstract void shouldOpenLinksInApp(boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.NativeGenericAd
 * JD-Core Version:    0.6.2
 */