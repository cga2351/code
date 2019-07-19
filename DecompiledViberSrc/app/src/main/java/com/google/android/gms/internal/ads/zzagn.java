package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;

@zzare
public final class zzagn extends zzafo
{
  private final NativeCustomTemplateAd.OnCustomClickListener zzczg;

  public zzagn(NativeCustomTemplateAd.OnCustomClickListener paramOnCustomClickListener)
  {
    this.zzczg = paramOnCustomClickListener;
  }

  public final void zza(zzafd paramzzafd, String paramString)
  {
    this.zzczg.onCustomClick(zzafg.zza(paramzzafd), paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagn
 * JD-Core Version:    0.6.2
 */