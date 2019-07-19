package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.a.a;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.c;
import com.google.ads.mediation.d;
import com.google.ads.mediation.e;
import com.google.ads.mediation.f;

@zzare
public final class zzanv<NETWORK_EXTRAS extends f, SERVER_PARAMETERS extends e>
  implements c, d
{
  private final zzamw zzdgn;

  public zzanv(zzamw paramzzamw)
  {
    this.zzdgn = paramzzamw;
  }

  public final void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzbae.zzdp("Adapter called onClick.");
    zzyr.zzpa();
    if (!zzazu.zzwy())
    {
      zzbae.zze("#008 Must be called on the main UI thread.", null);
      zzazu.zzyr.post(new zzanw(this));
      return;
    }
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

  public final void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzbae.zzdp("Adapter called onDismissScreen.");
    zzyr.zzpa();
    if (!zzazu.zzwy())
    {
      zzbae.zzep("#008 Must be called on the main UI thread.");
      zzazu.zzyr.post(new zzanz(this));
      return;
    }
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

  public final void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzbae.zzdp("Adapter called onDismissScreen.");
    zzyr.zzpa();
    if (!zzazu.zzwy())
    {
      zzbae.zze("#008 Must be called on the main UI thread.", null);
      zzazu.zzyr.post(new zzaoe(this));
      return;
    }
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

  public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, a.a parama)
  {
    String str = String.valueOf(parama);
    zzbae.zzdp(47 + String.valueOf(str).length() + "Adapter called onFailedToReceiveAd with error. " + str);
    zzyr.zzpa();
    if (!zzazu.zzwy())
    {
      zzbae.zze("#008 Must be called on the main UI thread.", null);
      zzazu.zzyr.post(new zzaoa(this, parama));
      return;
    }
    try
    {
      this.zzdgn.onAdFailedToLoad(zzaoh.zza(parama));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, a.a parama)
  {
    String str = String.valueOf(parama);
    zzbae.zzdp(47 + String.valueOf(str).length() + "Adapter called onFailedToReceiveAd with error " + str + ".");
    zzyr.zzpa();
    if (!zzazu.zzwy())
    {
      zzbae.zze("#008 Must be called on the main UI thread.", null);
      zzazu.zzyr.post(new zzaof(this, parama));
      return;
    }
    try
    {
      this.zzdgn.onAdFailedToLoad(zzaoh.zza(parama));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzbae.zzdp("Adapter called onLeaveApplication.");
    zzyr.zzpa();
    if (!zzazu.zzwy())
    {
      zzbae.zze("#008 Must be called on the main UI thread.", null);
      zzazu.zzyr.post(new zzaob(this));
      return;
    }
    try
    {
      this.zzdgn.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzbae.zzdp("Adapter called onLeaveApplication.");
    zzyr.zzpa();
    if (!zzazu.zzwy())
    {
      zzbae.zze("#008 Must be called on the main UI thread.", null);
      zzazu.zzyr.post(new zzaog(this));
      return;
    }
    try
    {
      this.zzdgn.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzbae.zzdp("Adapter called onPresentScreen.");
    zzyr.zzpa();
    if (!zzazu.zzwy())
    {
      zzbae.zze("#008 Must be called on the main UI thread.", null);
      zzazu.zzyr.post(new zzaoc(this));
      return;
    }
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

  public final void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzbae.zzdp("Adapter called onPresentScreen.");
    zzyr.zzpa();
    if (!zzazu.zzwy())
    {
      zzbae.zze("#008 Must be called on the main UI thread.", null);
      zzazu.zzyr.post(new zzanx(this));
      return;
    }
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

  public final void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzbae.zzdp("Adapter called onReceivedAd.");
    zzyr.zzpa();
    if (!zzazu.zzwy())
    {
      zzbae.zze("#008 Must be called on the main UI thread.", null);
      zzazu.zzyr.post(new zzaod(this));
      return;
    }
    try
    {
      this.zzdgn.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzbae.zzdp("Adapter called onReceivedAd.");
    zzyr.zzpa();
    if (!zzazu.zzwy())
    {
      zzbae.zze("#008 Must be called on the main UI thread.", null);
      zzazu.zzyr.post(new zzany(this));
      return;
    }
    try
    {
      this.zzdgn.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzanv
 * JD-Core Version:    0.6.2
 */