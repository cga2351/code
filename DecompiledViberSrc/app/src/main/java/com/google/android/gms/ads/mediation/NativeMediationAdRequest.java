package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAdOptions;
import java.util.Map;

public abstract interface NativeMediationAdRequest extends MediationAdRequest
{
  public abstract float getAdVolume();

  public abstract NativeAdOptions getNativeAdOptions();

  public abstract boolean isAdMuted();

  public abstract boolean isAppInstallAdRequested();

  public abstract boolean isContentAdRequested();

  public abstract boolean isUnifiedNativeAdRequested();

  public abstract boolean zzsu();

  public abstract Map<String, Boolean> zzsv();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.NativeMediationAdRequest
 * JD-Core Version:    0.6.2
 */