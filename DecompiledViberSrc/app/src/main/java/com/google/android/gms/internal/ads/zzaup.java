package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.Preconditions;

@zzare
public final class zzaup
  implements MediationRewardedAdCallback
{
  private final zzamw zzdgn;

  public zzaup(zzamw paramzzamw)
  {
    this.zzdgn = paramzzamw;
  }

  public final void onAdClosed()
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdClosed.");
    try
    {
      this.zzdgn.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onAdFailedToShow(String paramString)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdFailedToShow.");
    String str1 = String.valueOf(paramString);
    String str2;
    if (str1.length() != 0)
      str2 = "Mediation ad failed to show: ".concat(str1);
    while (true)
    {
      zzbae.zzep(str2);
      try
      {
        this.zzdgn.zzcs(0);
        return;
        str2 = new String("Mediation ad failed to show: ");
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
  }

  public final void onAdOpened()
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdOpened.");
    try
    {
      this.zzdgn.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onUserEarnedReward(RewardItem paramRewardItem)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onUserEarnedReward.");
    try
    {
      this.zzdgn.zza(new zzauq(paramRewardItem));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onVideoComplete()
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onVideoComplete.");
    try
    {
      this.zzdgn.zzsn();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onVideoStart()
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onVideoStart.");
    try
    {
      this.zzdgn.zzsm();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void reportAdClicked()
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called reportAdClicked.");
    try
    {
      this.zzdgn.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void reportAdImpression()
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called reportAdImpression.");
    try
    {
      this.zzdgn.onAdImpression();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaup
 * JD-Core Version:    0.6.2
 */