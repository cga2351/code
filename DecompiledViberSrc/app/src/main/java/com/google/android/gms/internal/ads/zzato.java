package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzare
public final class zzato
  implements MediationRewardedVideoAdListener
{
  private final zzatl zzdqw;

  public zzato(zzatl paramzzatl)
  {
    this.zzdqw = paramzzatl;
  }

  public final void onAdClicked(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdClicked.");
    try
    {
      this.zzdqw.zzaj(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onAdClosed(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdClosed.");
    try
    {
      this.zzdqw.zzai(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, int paramInt)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdFailedToLoad.");
    try
    {
      this.zzdqw.zze(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onAdLeftApplication(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdLeftApplication.");
    try
    {
      this.zzdqw.zzak(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onAdLoaded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdLoaded.");
    try
    {
      this.zzdqw.zzaf(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onAdOpened(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdOpened.");
    try
    {
      this.zzdqw.zzag(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onInitializationFailed(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, int paramInt)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onInitializationFailed.");
    try
    {
      this.zzdqw.zzd(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onInitializationSucceeded.");
    try
    {
      this.zzdqw.zzae(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onRewarded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, RewardItem paramRewardItem)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onRewarded.");
    if (paramRewardItem != null);
    try
    {
      this.zzdqw.zza(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter), new zzatp(paramRewardItem));
      return;
      this.zzdqw.zza(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter), new zzatp("", 1));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onVideoCompleted(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onVideoCompleted.");
    try
    {
      this.zzdqw.zzal(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onVideoStarted(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onVideoStarted.");
    try
    {
      this.zzdqw.zzah(ObjectWrapper.wrap(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void zzb(Bundle paramBundle)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdMetadataChanged.");
    try
    {
      this.zzdqw.zzb(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzato
 * JD-Core Version:    0.6.2
 */