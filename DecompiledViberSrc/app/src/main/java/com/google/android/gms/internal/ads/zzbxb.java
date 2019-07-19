package com.google.android.gms.internal.ads;

public final class zzbxb
  implements zzbrk
{
  private final zzbrs zzfii;
  private final zzcxl zzflu;

  public zzbxb(zzbrs paramzzbrs, zzcxl paramzzcxl)
  {
    this.zzfii = paramzzbrs;
    this.zzflu = paramzzcxl;
  }

  public final void onAdClosed()
  {
  }

  public final void onAdLeftApplication()
  {
  }

  public final void onAdOpened()
  {
    if ((this.zzflu.zzgkp == 0) || (this.zzflu.zzgkp == 1))
      this.zzfii.onAdImpression();
  }

  public final void onRewardedVideoCompleted()
  {
  }

  public final void onRewardedVideoStarted()
  {
  }

  public final void zzb(zzass paramzzass, String paramString1, String paramString2)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbxb
 * JD-Core Version:    0.6.2
 */