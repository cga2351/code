package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@zzare
public final class zzath extends zzatd
{
  private RewardedVideoAdListener zzcjn;

  public zzath(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    this.zzcjn = paramRewardedVideoAdListener;
  }

  public final RewardedVideoAdListener getRewardedVideoAdListener()
  {
    return this.zzcjn;
  }

  public final void onRewardedVideoAdClosed()
  {
    if (this.zzcjn != null)
      this.zzcjn.onRewardedVideoAdClosed();
  }

  public final void onRewardedVideoAdFailedToLoad(int paramInt)
  {
    if (this.zzcjn != null)
      this.zzcjn.onRewardedVideoAdFailedToLoad(paramInt);
  }

  public final void onRewardedVideoAdLeftApplication()
  {
    if (this.zzcjn != null)
      this.zzcjn.onRewardedVideoAdLeftApplication();
  }

  public final void onRewardedVideoAdLoaded()
  {
    if (this.zzcjn != null)
      this.zzcjn.onRewardedVideoAdLoaded();
  }

  public final void onRewardedVideoAdOpened()
  {
    if (this.zzcjn != null)
      this.zzcjn.onRewardedVideoAdOpened();
  }

  public final void onRewardedVideoCompleted()
  {
    if (this.zzcjn != null)
      this.zzcjn.onRewardedVideoCompleted();
  }

  public final void onRewardedVideoStarted()
  {
    if (this.zzcjn != null)
      this.zzcjn.onRewardedVideoStarted();
  }

  public final void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    this.zzcjn = paramRewardedVideoAdListener;
  }

  public final void zza(zzass paramzzass)
  {
    if (this.zzcjn != null)
      this.zzcjn.onRewarded(new zzatf(paramzzass));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzath
 * JD-Core Version:    0.6.2
 */