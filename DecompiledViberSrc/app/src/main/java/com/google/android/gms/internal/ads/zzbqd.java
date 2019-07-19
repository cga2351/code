package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbqd
  implements zzbrk, zzbrv, zzbsq, zzbtj, zzxp
{
  private final Clock zzbsb;
  private final zzawk zzfjk;

  public zzbqd(Clock paramClock, zzawk paramzzawk)
  {
    this.zzbsb = paramClock;
    this.zzfjk = paramzzawk;
  }

  public final void onAdClicked()
  {
    this.zzfjk.zzuk();
  }

  public final void onAdClosed()
  {
    this.zzfjk.zzul();
  }

  public final void onAdImpression()
  {
    this.zzfjk.zzuj();
  }

  public final void onAdLeftApplication()
  {
  }

  public final void onAdLoaded()
  {
    this.zzfjk.zzah(true);
  }

  public final void onAdOpened()
  {
  }

  public final void onRewardedVideoCompleted()
  {
  }

  public final void onRewardedVideoStarted()
  {
  }

  public final void zza(zzcxt paramzzcxt)
  {
    this.zzfjk.zzfb(this.zzbsb.elapsedRealtime());
  }

  public final void zzb(zzary paramzzary)
  {
  }

  public final void zzb(zzass paramzzass, String paramString1, String paramString2)
  {
  }

  public final void zzf(zzxx paramzzxx)
  {
    this.zzfjk.zze(paramzzxx);
  }

  public final String zzum()
  {
    return this.zzfjk.zzum();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbqd
 * JD-Core Version:    0.6.2
 */