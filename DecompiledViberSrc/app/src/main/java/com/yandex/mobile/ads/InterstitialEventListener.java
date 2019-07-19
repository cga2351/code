package com.yandex.mobile.ads;

public abstract interface InterstitialEventListener
{
  public abstract void onAdClosed();

  public abstract void onAdLeftApplication();

  public abstract void onAdOpened();

  public abstract void onInterstitialDismissed();

  public abstract void onInterstitialFailedToLoad(AdRequestError paramAdRequestError);

  public abstract void onInterstitialLoaded();

  public abstract void onInterstitialShown();

  public static class SimpleInterstitialEventListener
    implements InterstitialEventListener
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

    public void onInterstitialDismissed()
    {
    }

    public void onInterstitialFailedToLoad(AdRequestError paramAdRequestError)
    {
    }

    public void onInterstitialLoaded()
    {
    }

    public void onInterstitialShown()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.InterstitialEventListener
 * JD-Core Version:    0.6.2
 */