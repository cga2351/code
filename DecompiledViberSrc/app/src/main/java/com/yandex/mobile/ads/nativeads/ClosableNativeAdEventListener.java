package com.yandex.mobile.ads.nativeads;

public abstract interface ClosableNativeAdEventListener extends NativeAdEventListener
{
  public abstract void closeNativeAd();

  public static class SimpleClosableNativeAdEventListener extends NativeAdEventListener.SimpleNativeAdEventListener
    implements ClosableNativeAdEventListener
  {
    public void closeNativeAd()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.ClosableNativeAdEventListener
 * JD-Core Version:    0.6.2
 */