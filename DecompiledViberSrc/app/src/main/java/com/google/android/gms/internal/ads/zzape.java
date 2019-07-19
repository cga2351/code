package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzape
  implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback>
{
  zzape(zzapd paramzzapd, zzaok paramzzaok, zzamw paramzzamw)
  {
  }

  private final MediationBannerAdCallback zza(MediationBannerAd paramMediationBannerAd)
  {
    try
    {
      this.zzdhg.zzw(ObjectWrapper.wrap(paramMediationBannerAd.getView()));
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
      this.zzdhg.zzdb(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzape
 * JD-Core Version:    0.6.2
 */