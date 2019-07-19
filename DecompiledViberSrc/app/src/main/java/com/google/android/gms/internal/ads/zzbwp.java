package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

public final class zzbwp
  implements zzo
{
  private final zzbsu zzflp;
  private final zzbuu zzflq;

  public zzbwp(zzbsu paramzzbsu, zzbuu paramzzbuu)
  {
    this.zzflp = paramzzbsu;
    this.zzflq = paramzzbuu;
  }

  public final void onPause()
  {
    this.zzflp.onPause();
  }

  public final void onResume()
  {
    this.zzflp.onResume();
  }

  public final void zzsz()
  {
    this.zzflp.zzsz();
    this.zzflq.onHide();
  }

  public final void zzta()
  {
    this.zzflp.zzta();
    this.zzflq.zzagw();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbwp
 * JD-Core Version:    0.6.2
 */