package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

public abstract interface MediationNativeListener
{
  public abstract void onAdClicked(MediationNativeAdapter paramMediationNativeAdapter);

  public abstract void onAdClosed(MediationNativeAdapter paramMediationNativeAdapter);

  public abstract void onAdFailedToLoad(MediationNativeAdapter paramMediationNativeAdapter, int paramInt);

  public abstract void onAdImpression(MediationNativeAdapter paramMediationNativeAdapter);

  public abstract void onAdLeftApplication(MediationNativeAdapter paramMediationNativeAdapter);

  @Deprecated
  public abstract void onAdLoaded(MediationNativeAdapter paramMediationNativeAdapter, NativeAdMapper paramNativeAdMapper);

  public abstract void onAdLoaded(MediationNativeAdapter paramMediationNativeAdapter, UnifiedNativeAdMapper paramUnifiedNativeAdMapper);

  public abstract void onAdOpened(MediationNativeAdapter paramMediationNativeAdapter);

  public abstract void onVideoEnd(MediationNativeAdapter paramMediationNativeAdapter);

  public abstract void zza(MediationNativeAdapter paramMediationNativeAdapter, NativeCustomTemplateAd paramNativeCustomTemplateAd);

  public abstract void zza(MediationNativeAdapter paramMediationNativeAdapter, NativeCustomTemplateAd paramNativeCustomTemplateAd, String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationNativeListener
 * JD-Core Version:    0.6.2
 */