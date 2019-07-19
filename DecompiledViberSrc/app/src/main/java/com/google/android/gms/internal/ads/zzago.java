package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;

@zzare
public final class zzago extends zzafr
{
  private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzczh;

  public zzago(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener paramOnCustomTemplateAdLoadedListener)
  {
    this.zzczh = paramOnCustomTemplateAdLoadedListener;
  }

  public final void zzb(zzafd paramzzafd)
  {
    this.zzczh.onCustomTemplateAdLoaded(zzafg.zza(paramzzafd));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzago
 * JD-Core Version:    0.6.2
 */