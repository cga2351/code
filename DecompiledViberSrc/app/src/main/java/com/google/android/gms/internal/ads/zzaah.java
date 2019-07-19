package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

public final class zzaah extends zzaaf
{
  private final MuteThisAdListener zzciq;

  public zzaah(MuteThisAdListener paramMuteThisAdListener)
  {
    this.zzciq = paramMuteThisAdListener;
  }

  public final void onAdMuted()
  {
    this.zzciq.onAdMuted();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaah
 * JD-Core Version:    0.6.2
 */