package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.rewarded.RewardItem;

public abstract interface MediationRewardedAdCallback extends MediationAdCallback
{
  public abstract void onAdFailedToShow(String paramString);

  public abstract void onUserEarnedReward(RewardItem paramRewardItem);

  public abstract void onVideoComplete();

  public abstract void onVideoStart();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationRewardedAdCallback
 * JD-Core Version:    0.6.2
 */