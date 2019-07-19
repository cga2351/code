package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;

@zzare
public final class zzagl extends zzafi
{
  private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzcze;

  public zzagl(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
  {
    this.zzcze = paramOnAppInstallAdLoadedListener;
  }

  public final void zza(zzaev paramzzaev)
  {
    this.zzcze.onAppInstallAdLoaded(new zzaey(paramzzaev));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagl
 * JD-Core Version:    0.6.2
 */