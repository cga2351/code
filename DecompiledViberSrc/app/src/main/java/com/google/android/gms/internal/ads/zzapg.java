package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

final class zzapg
  implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback>
{
  zzapg(zzapd paramzzapd, zzaot paramzzaot, zzamw paramzzamw)
  {
  }

  private final MediationRewardedAdCallback zza(MediationRewardedAd paramMediationRewardedAd)
  {
    try
    {
      zzapd.zza(this.zzdhj, paramMediationRewardedAd);
      this.zzdhk.zzsw();
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
      this.zzdhk.zzdb(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapg
 * JD-Core Version:    0.6.2
 */