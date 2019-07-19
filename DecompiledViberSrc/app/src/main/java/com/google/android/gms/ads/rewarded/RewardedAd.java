package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzauh;
import javax.annotation.Nullable;

public final class RewardedAd
{
  private final zzauh zzgnu;

  public RewardedAd(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    Preconditions.checkNotNull(paramString, "adUnitID cannot be null");
    this.zzgnu = new zzauh(paramContext, paramString);
  }

  public final Bundle getAdMetadata()
  {
    return this.zzgnu.getAdMetadata();
  }

  public final String getMediationAdapterClassName()
  {
    return this.zzgnu.getMediationAdapterClassName();
  }

  @Nullable
  public final RewardItem getRewardItem()
  {
    return this.zzgnu.getRewardItem();
  }

  public final boolean isLoaded()
  {
    return this.zzgnu.isLoaded();
  }

  public final void loadAd(AdRequest paramAdRequest, RewardedAdLoadCallback paramRewardedAdLoadCallback)
  {
    this.zzgnu.zza(paramAdRequest.zzde(), paramRewardedAdLoadCallback);
  }

  public final void loadAd(PublisherAdRequest paramPublisherAdRequest, RewardedAdLoadCallback paramRewardedAdLoadCallback)
  {
    this.zzgnu.zza(paramPublisherAdRequest.zzde(), paramRewardedAdLoadCallback);
  }

  public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener paramOnAdMetadataChangedListener)
  {
    this.zzgnu.setOnAdMetadataChangedListener(paramOnAdMetadataChangedListener);
  }

  public final void setServerSideVerificationOptions(ServerSideVerificationOptions paramServerSideVerificationOptions)
  {
    this.zzgnu.setServerSideVerificationOptions(paramServerSideVerificationOptions);
  }

  public final void show(Activity paramActivity, RewardedAdCallback paramRewardedAdCallback)
  {
    this.zzgnu.show(paramActivity, paramRewardedAdCallback);
  }

  public final void show(Activity paramActivity, RewardedAdCallback paramRewardedAdCallback, boolean paramBoolean)
  {
    this.zzgnu.show(paramActivity, paramRewardedAdCallback, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.rewarded.RewardedAd
 * JD-Core Version:    0.6.2
 */