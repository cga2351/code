package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

public abstract interface CustomEventNativeListener extends CustomEventListener
{
  public abstract void onAdImpression();

  @Deprecated
  public abstract void onAdLoaded(NativeAdMapper paramNativeAdMapper);

  public abstract void onAdLoaded(UnifiedNativeAdMapper paramUnifiedNativeAdMapper);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
 * JD-Core Version:    0.6.2
 */