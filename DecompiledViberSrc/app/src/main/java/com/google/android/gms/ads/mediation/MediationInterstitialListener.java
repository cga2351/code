package com.google.android.gms.ads.mediation;

public abstract interface MediationInterstitialListener
{
  public abstract void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter);

  public abstract void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter);

  public abstract void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt);

  public abstract void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter);

  public abstract void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter);

  public abstract void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationInterstitialListener
 * JD-Core Version:    0.6.2
 */