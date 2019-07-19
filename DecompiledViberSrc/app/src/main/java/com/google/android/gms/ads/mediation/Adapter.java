package com.google.android.gms.ads.mediation;

import android.content.Context;
import java.util.List;

public abstract class Adapter
  implements MediationExtrasReceiver
{
  public abstract VersionInfo getSDKVersionInfo();

  public abstract VersionInfo getVersionInfo();

  public abstract void initialize(Context paramContext, InitializationCompleteCallback paramInitializationCompleteCallback, List<MediationConfiguration> paramList);

  public void loadBannerAd(MediationBannerAdConfiguration paramMediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> paramMediationAdLoadCallback)
  {
    paramMediationAdLoadCallback.onFailure(String.valueOf(getClass().getSimpleName()).concat(" does not support banner ads."));
  }

  public void loadInterstitialAd(MediationInterstitialAdConfiguration paramMediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> paramMediationAdLoadCallback)
  {
    paramMediationAdLoadCallback.onFailure(String.valueOf(getClass().getSimpleName()).concat(" does not support interstitial ads."));
  }

  public void loadNativeAd(MediationNativeAdConfiguration paramMediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> paramMediationAdLoadCallback)
  {
    paramMediationAdLoadCallback.onFailure(String.valueOf(getClass().getSimpleName()).concat(" does not support native ads."));
  }

  public void loadRewardedAd(MediationRewardedAdConfiguration paramMediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> paramMediationAdLoadCallback)
  {
    paramMediationAdLoadCallback.onFailure(String.valueOf(getClass().getSimpleName()).concat(" does not support rewarded ads."));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.Adapter
 * JD-Core Version:    0.6.2
 */