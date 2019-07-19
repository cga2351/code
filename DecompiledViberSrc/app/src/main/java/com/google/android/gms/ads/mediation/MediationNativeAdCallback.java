package com.google.android.gms.ads.mediation;

public abstract interface MediationNativeAdCallback extends MediationAdCallback
{
  public abstract void onAdLeftApplication();

  public abstract void onVideoComplete();

  public abstract void onVideoMute();

  public abstract void onVideoPause();

  public abstract void onVideoPlay();

  public abstract void onVideoUnmute();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationNativeAdCallback
 * JD-Core Version:    0.6.2
 */