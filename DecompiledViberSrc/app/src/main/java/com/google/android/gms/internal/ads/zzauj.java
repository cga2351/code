package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;

@zzare
public final class zzauj extends zzaty
{
  private final RewardedAdCallback zzdqz;

  public zzauj(RewardedAdCallback paramRewardedAdCallback)
  {
    this.zzdqz = paramRewardedAdCallback;
  }

  public final void onRewardedAdClosed()
  {
    if (this.zzdqz != null)
      this.zzdqz.onRewardedAdClosed();
  }

  public final void onRewardedAdFailedToShow(int paramInt)
  {
    if (this.zzdqz != null)
      this.zzdqz.onRewardedAdFailedToShow(paramInt);
  }

  public final void onRewardedAdOpened()
  {
    if (this.zzdqz != null)
      this.zzdqz.onRewardedAdOpened();
  }

  public final void zza(zzatr paramzzatr)
  {
    if (this.zzdqz != null)
      this.zzdqz.onUserEarnedReward(new zzaui(paramzzatr));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzauj
 * JD-Core Version:    0.6.2
 */