package com.yandex.mobile.ads.rewarded;

import com.yandex.mobile.ads.AdRequestError;

public abstract class RewardedAdEventListener
{
  public abstract void onAdClosed();

  public abstract void onAdDismissed();

  public abstract void onAdFailedToLoad(AdRequestError paramAdRequestError);

  public abstract void onAdLeftApplication();

  public abstract void onAdLoaded();

  public abstract void onAdOpened();

  public abstract void onAdShown();

  public abstract void onRewarded(Reward paramReward);

  public static class SimpleRewardedAdEventListener extends RewardedAdEventListener
  {
    public void onAdClosed()
    {
    }

    public void onAdDismissed()
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

    public void onAdShown()
    {
    }

    public void onRewarded(Reward paramReward)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.rewarded.RewardedAdEventListener
 * JD-Core Version:    0.6.2
 */