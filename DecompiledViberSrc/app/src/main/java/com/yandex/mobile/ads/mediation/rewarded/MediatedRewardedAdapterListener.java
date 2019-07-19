package com.yandex.mobile.ads.mediation.rewarded;

import com.yandex.mobile.ads.AdRequestError;

abstract interface MediatedRewardedAdapterListener
{
  public abstract void onRewarded(MediatedReward paramMediatedReward);

  public abstract void onRewardedAdClicked();

  public abstract void onRewardedAdDismissed();

  public abstract void onRewardedAdFailedToLoad(AdRequestError paramAdRequestError);

  public abstract void onRewardedAdLeftApplication();

  public abstract void onRewardedAdLoaded();

  public abstract void onRewardedAdShown();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.rewarded.MediatedRewardedAdapterListener
 * JD-Core Version:    0.6.2
 */