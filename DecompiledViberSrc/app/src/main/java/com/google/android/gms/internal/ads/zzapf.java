package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

final class zzapf
  implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback>
{
  zzapf(zzapd paramzzapd, zzaon paramzzaon, zzamw paramzzamw)
  {
  }

  private final MediationInterstitialAdCallback zza(MediationInterstitialAd paramMediationInterstitialAd)
  {
    try
    {
      zzapd.zza(this.zzdhj, paramMediationInterstitialAd);
      this.zzdhi.zzsw();
      return new zzapj(this.zzdhh);
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zzc("", localRemoteException);
    }
  }

  public final void onFailure(String paramString)
  {
    try
    {
      this.zzdhi.zzdb(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapf
 * JD-Core Version:    0.6.2
 */