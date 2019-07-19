package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

final class zzapn
  implements zzo
{
  zzapn(zzapm paramzzapm)
  {
  }

  public final void onPause()
  {
    zzbae.zzdp("AdMobCustomTabsAdapter overlay is paused.");
  }

  public final void onResume()
  {
    zzbae.zzdp("AdMobCustomTabsAdapter overlay is resumed.");
  }

  public final void zzsz()
  {
    zzbae.zzdp("AdMobCustomTabsAdapter overlay is closed.");
    zzapm.zza(this.zzdhr).onAdClosed(this.zzdhr);
  }

  public final void zzta()
  {
    zzbae.zzdp("Opening AdMobCustomTabsAdapter overlay.");
    zzapm.zza(this.zzdhr).onAdOpened(this.zzdhr);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapn
 * JD-Core Version:    0.6.2
 */