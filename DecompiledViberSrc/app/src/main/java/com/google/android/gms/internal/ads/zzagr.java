package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;

@zzare
public final class zzagr extends zzafx
{
  private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zzczm;

  public zzagr(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener paramOnUnifiedNativeAdLoadedListener)
  {
    this.zzczm = paramOnUnifiedNativeAdLoadedListener;
  }

  public final void zza(zzagf paramzzagf)
  {
    this.zzczm.onUnifiedNativeAdLoaded(new zzagi(paramzzagf));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagr
 * JD-Core Version:    0.6.2
 */