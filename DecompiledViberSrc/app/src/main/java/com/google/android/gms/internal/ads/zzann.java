package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

final class zzann
  implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback>
{
  zzann(zzanm paramzzanm, zzamw paramzzamw, Adapter paramAdapter)
  {
  }

  private final MediationRewardedAdCallback zza(MediationRewardedAd paramMediationRewardedAd)
  {
    try
    {
      zzanm.zza(this.zzdgl, paramMediationRewardedAd);
      this.zzdgj.onAdLoaded();
      return new zzaup(this.zzdgj);
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
      String str = this.zzdgk.getClass().getCanonicalName();
      zzbae.zzdp(30 + String.valueOf(str).length() + String.valueOf(paramString).length() + str + "failed to loaded medation ad: " + paramString);
      this.zzdgj.onAdFailedToLoad(0);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzann
 * JD-Core Version:    0.6.2
 */