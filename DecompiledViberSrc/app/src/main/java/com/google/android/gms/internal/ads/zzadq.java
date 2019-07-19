package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzare
public final class zzadq extends zzado
{
  private final OnCustomRenderedAdLoadedListener zzcjj;

  public zzadq(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    this.zzcjj = paramOnCustomRenderedAdLoadedListener;
  }

  public final void zza(zzadk paramzzadk)
  {
    this.zzcjj.onCustomRenderedAdLoaded(new zzadj(paramzzadk));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadq
 * JD-Core Version:    0.6.2
 */