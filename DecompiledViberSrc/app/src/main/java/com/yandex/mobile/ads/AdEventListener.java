package com.yandex.mobile.ads;

public abstract interface AdEventListener
{
  public abstract void onAdClosed();

  public abstract void onAdFailedToLoad(AdRequestError paramAdRequestError);

  public abstract void onAdLeftApplication();

  public abstract void onAdLoaded();

  public abstract void onAdOpened();

  public static class SimpleAdEventListener
    implements AdEventListener
  {
    public void onAdClosed()
    {
    }

    public void onAdFailedToLoad(AdRequestError paramAdRequestError)
    {
    }

    public void onAdLeftApplication()
    {
    }

    public void onAdLoaded()
    {
    }

    public void onAdOpened()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.AdEventListener
 * JD-Core Version:    0.6.2
 */