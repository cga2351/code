package com.google.android.gms.ads.mediation;

public abstract interface MediationAdCallback
{
  public abstract void onAdClosed();

  public abstract void onAdOpened();

  public abstract void reportAdClicked();

  public abstract void reportAdImpression();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationAdCallback
 * JD-Core Version:    0.6.2
 */