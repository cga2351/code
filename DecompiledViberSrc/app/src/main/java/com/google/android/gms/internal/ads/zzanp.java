package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.internal.Preconditions;

@zzare
public final class zzanp
  implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener
{
  private final zzamw zzdgn;
  private NativeAdMapper zzdgo;
  private UnifiedNativeAdMapper zzdgp;
  private NativeCustomTemplateAd zzdgq;

  public zzanp(zzamw paramzzamw)
  {
    this.zzdgn = paramzzamw;
  }

  private static void zza(MediationNativeAdapter paramMediationNativeAdapter, UnifiedNativeAdMapper paramUnifiedNativeAdMapper, NativeAdMapper paramNativeAdMapper)
  {
    if ((paramMediationNativeAdapter instanceof AdMobAdapter));
    VideoController localVideoController;
    do
    {
      return;
      localVideoController = new VideoController();
      localVideoController.zza(new zzank());
      if ((paramUnifiedNativeAdMapper != null) && (paramUnifiedNativeAdMapper.hasVideoContent()))
        paramUnifiedNativeAdMapper.zza(localVideoController);
    }
    while ((paramNativeAdMapper == null) || (!paramNativeAdMapper.hasVideoContent()));
    paramNativeAdMapper.zza(localVideoController);
  }

  public final void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdClicked.");
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

  public final void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdClicked.");
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

  public final void onAdClicked(MediationNativeAdapter paramMediationNativeAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    NativeAdMapper localNativeAdMapper = this.zzdgo;
    UnifiedNativeAdMapper localUnifiedNativeAdMapper = this.zzdgp;
    if (this.zzdgq == null)
    {
      if ((localNativeAdMapper == null) && (localUnifiedNativeAdMapper == null))
      {
        zzbae.zze("#007 Could not call remote method.", null);
        return;
      }
      if ((localUnifiedNativeAdMapper != null) && (!localUnifiedNativeAdMapper.getOverrideClickHandling()))
      {
        zzbae.zzdp("Could not call onAdClicked since setOverrideClickHandling is not set to true");
        return;
      }
      if ((localNativeAdMapper != null) && (!localNativeAdMapper.getOverrideClickHandling()))
      {
        zzbae.zzdp("Could not call onAdClicked since setOverrideClickHandling is not set to true");
        return;
      }
    }
    zzbae.zzdp("Adapter called onAdClicked.");
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

  public final void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
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

  public final void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
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

  public final void onAdClosed(MediationNativeAdapter paramMediationNativeAdapter)
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

  public final void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp(55 + "Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.zzdgn.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp(55 + "Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.zzdgn.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onAdFailedToLoad(MediationNativeAdapter paramMediationNativeAdapter, int paramInt)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp(55 + "Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.zzdgn.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onAdImpression(MediationNativeAdapter paramMediationNativeAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    NativeAdMapper localNativeAdMapper = this.zzdgo;
    UnifiedNativeAdMapper localUnifiedNativeAdMapper = this.zzdgp;
    if (this.zzdgq == null)
    {
      if ((localNativeAdMapper == null) && (localUnifiedNativeAdMapper == null))
      {
        zzbae.zze("#007 Could not call remote method.", null);
        return;
      }
      if ((localUnifiedNativeAdMapper != null) && (!localUnifiedNativeAdMapper.getOverrideImpressionRecording()))
      {
        zzbae.zzdp("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
        return;
      }
      if ((localNativeAdMapper != null) && (!localNativeAdMapper.getOverrideImpressionRecording()))
      {
        zzbae.zzdp("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
        return;
      }
    }
    zzbae.zzdp("Adapter called onAdImpression.");
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

  public final void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdLeftApplication.");
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

  public final void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdLeftApplication.");
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

  public final void onAdLeftApplication(MediationNativeAdapter paramMediationNativeAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdLeftApplication.");
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

  public final void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdLoaded.");
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

  public final void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdLoaded.");
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

  public final void onAdLoaded(MediationNativeAdapter paramMediationNativeAdapter, NativeAdMapper paramNativeAdMapper)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdLoaded.");
    this.zzdgo = paramNativeAdMapper;
    this.zzdgp = null;
    zza(paramMediationNativeAdapter, this.zzdgp, this.zzdgo);
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

  public final void onAdLoaded(MediationNativeAdapter paramMediationNativeAdapter, UnifiedNativeAdMapper paramUnifiedNativeAdMapper)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAdLoaded.");
    this.zzdgp = paramUnifiedNativeAdMapper;
    this.zzdgo = null;
    zza(paramMediationNativeAdapter, this.zzdgp, this.zzdgo);
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

  public final void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
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

  public final void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
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

  public final void onAdOpened(MediationNativeAdapter paramMediationNativeAdapter)
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

  public final void onVideoEnd(MediationNativeAdapter paramMediationNativeAdapter)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onVideoEnd.");
    try
    {
      this.zzdgn.onVideoEnd();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void zza(MediationBannerAdapter paramMediationBannerAdapter, String paramString1, String paramString2)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzbae.zzdp("Adapter called onAppEvent.");
    try
    {
      this.zzdgn.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void zza(MediationNativeAdapter paramMediationNativeAdapter, NativeCustomTemplateAd paramNativeCustomTemplateAd)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    String str1 = String.valueOf(paramNativeCustomTemplateAd.getCustomTemplateId());
    String str2;
    if (str1.length() != 0)
      str2 = "Adapter called onAdLoaded with template id ".concat(str1);
    while (true)
    {
      zzbae.zzdp(str2);
      this.zzdgq = paramNativeCustomTemplateAd;
      try
      {
        this.zzdgn.onAdLoaded();
        return;
        str2 = new String("Adapter called onAdLoaded with template id ");
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
  }

  public final void zza(MediationNativeAdapter paramMediationNativeAdapter, NativeCustomTemplateAd paramNativeCustomTemplateAd, String paramString)
  {
    if ((paramNativeCustomTemplateAd instanceof zzafg))
      try
      {
        this.zzdgn.zza(((zzafg)paramNativeCustomTemplateAd).zzrn(), paramString);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
        return;
      }
    zzbae.zzep("Unexpected native custom template ad type.");
  }

  public final NativeAdMapper zzsr()
  {
    return this.zzdgo;
  }

  public final UnifiedNativeAdMapper zzss()
  {
    return this.zzdgp;
  }

  public final NativeCustomTemplateAd zzst()
  {
    return this.zzdgq;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzanp
 * JD-Core Version:    0.6.2
 */