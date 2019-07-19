package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;

@zzare
public final class zzagm extends zzafl
{
  private final NativeContentAd.OnContentAdLoadedListener zzczf;

  public zzagm(NativeContentAd.OnContentAdLoadedListener paramOnContentAdLoadedListener)
  {
    this.zzczf = paramOnContentAdLoadedListener;
  }

  public final void zza(zzaez paramzzaez)
  {
    this.zzczf.onContentAdLoaded(new zzafc(paramzzaez));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagm
 * JD-Core Version:    0.6.2
 */