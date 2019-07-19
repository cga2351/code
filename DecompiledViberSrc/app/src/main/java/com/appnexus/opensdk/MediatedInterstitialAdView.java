package com.appnexus.opensdk;

import android.app.Activity;

public abstract interface MediatedInterstitialAdView extends p
{
  public abstract boolean isReady();

  public abstract void requestAd(MediatedInterstitialAdViewController paramMediatedInterstitialAdViewController, Activity paramActivity, String paramString1, String paramString2, TargetingParameters paramTargetingParameters);

  public abstract void show();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.MediatedInterstitialAdView
 * JD-Core Version:    0.6.2
 */