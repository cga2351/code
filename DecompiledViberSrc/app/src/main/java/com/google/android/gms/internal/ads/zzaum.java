package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

@zzare
public final class zzaum extends zzaud
{
  private final RewardedAdLoadCallback zzdra;

  public zzaum(RewardedAdLoadCallback paramRewardedAdLoadCallback)
  {
    this.zzdra = paramRewardedAdLoadCallback;
  }

  public final void onRewardedAdFailedToLoad(int paramInt)
  {
    if (this.zzdra != null)
      this.zzdra.onRewardedAdFailedToLoad(paramInt);
  }

  public final void onRewardedAdLoaded()
  {
    if (this.zzdra != null)
      this.zzdra.onRewardedAdLoaded();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaum
 * JD-Core Version:    0.6.2
 */