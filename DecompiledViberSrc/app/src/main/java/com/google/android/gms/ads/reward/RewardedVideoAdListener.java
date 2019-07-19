package com.google.android.gms.ads.reward;

public abstract interface RewardedVideoAdListener
{
  public abstract void onRewarded(RewardItem paramRewardItem);

  public abstract void onRewardedVideoAdClosed();

  public abstract void onRewardedVideoAdFailedToLoad(int paramInt);

  public abstract void onRewardedVideoAdLeftApplication();

  public abstract void onRewardedVideoAdLoaded();

  public abstract void onRewardedVideoAdOpened();

  public abstract void onRewardedVideoCompleted();

  public abstract void onRewardedVideoStarted();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.reward.RewardedVideoAdListener
 * JD-Core Version:    0.6.2
 */