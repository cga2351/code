package com.yandex.mobile.ads.nativeads;

public abstract interface NativeAdEventListener
{
  public abstract void onAdClosed();

  public abstract void onAdLeftApplication();

  public abstract void onAdOpened();

  public static class SimpleNativeAdEventListener
    implements NativeAdEventListener
  {
    public void onAdClosed()
    {
    }

    public void onAdLeftApplication()
    {
    }

    public void onAdOpened()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.NativeAdEventListener
 * JD-Core Version:    0.6.2
 */