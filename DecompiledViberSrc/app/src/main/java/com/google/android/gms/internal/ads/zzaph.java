package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

final class zzaph
  implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback>
{
  zzaph(zzapd paramzzapd, zzaoq paramzzaoq, zzamw paramzzamw)
  {
  }

  private final MediationNativeAdCallback zza(UnifiedNativeAdMapper paramUnifiedNativeAdMapper)
  {
    try
    {
      this.zzdhl.zza(new zzaoj(paramUnifiedNativeAdMapper));
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
      this.zzdhl.zzdb(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaph
 * JD-Core Version:    0.6.2
 */