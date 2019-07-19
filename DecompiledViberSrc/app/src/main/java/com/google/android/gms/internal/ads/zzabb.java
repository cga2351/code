package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;

@zzare
public final class zzabb
{
  private final zzya zzaaj;
  private AppEventListener zzbqp;
  private boolean zzbrl;
  private zzxp zzcgj;
  private AdListener zzcgm;
  private AdMetadataListener zzcgn;
  private String zzchl;
  private final zzamp zzcjd = new zzamp();
  private Correlator zzcjh;
  private zzzi zzcji;
  private OnCustomRenderedAdLoadedListener zzcjj;
  private RewardedVideoAdListener zzcjn;
  private boolean zzcjo;
  private final Context zzlj;

  public zzabb(Context paramContext)
  {
    this(paramContext, zzya.zzchf, null);
  }

  public zzabb(Context paramContext, PublisherInterstitialAd paramPublisherInterstitialAd)
  {
    this(paramContext, zzya.zzchf, paramPublisherInterstitialAd);
  }

  @VisibleForTesting
  private zzabb(Context paramContext, zzya paramzzya, PublisherInterstitialAd paramPublisherInterstitialAd)
  {
    this.zzlj = paramContext;
    this.zzaaj = paramzzya;
  }

  private final void zzce(String paramString)
  {
    if (this.zzcji == null)
      throw new IllegalStateException(63 + String.valueOf(paramString).length() + "The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
  }

  public final AdListener getAdListener()
  {
    return this.zzcgm;
  }

  public final Bundle getAdMetadata()
  {
    try
    {
      if (this.zzcji != null)
      {
        Bundle localBundle = this.zzcji.getAdMetadata();
        return localBundle;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
    return new Bundle();
  }

  public final String getAdUnitId()
  {
    return this.zzchl;
  }

  public final AppEventListener getAppEventListener()
  {
    return this.zzbqp;
  }

  public final String getMediationAdapterClassName()
  {
    try
    {
      if (this.zzcji != null)
      {
        String str = this.zzcji.zzpj();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
    return null;
  }

  public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return this.zzcjj;
  }

  public final boolean isLoaded()
  {
    try
    {
      if (this.zzcji == null)
        return false;
      boolean bool = this.zzcji.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
    return false;
  }

  public final boolean isLoading()
  {
    try
    {
      if (this.zzcji == null)
        return false;
      boolean bool = this.zzcji.isLoading();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
    return false;
  }

  public final void setAdListener(AdListener paramAdListener)
  {
    try
    {
      this.zzcgm = paramAdListener;
      zzzi localzzzi;
      if (this.zzcji != null)
      {
        localzzzi = this.zzcji;
        if (paramAdListener == null)
          break label40;
      }
      label40: for (zzxt localzzxt = new zzxt(paramAdListener); ; localzzxt = null)
      {
        localzzzi.zzb(localzzxt);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
  }

  public final void setAdMetadataListener(AdMetadataListener paramAdMetadataListener)
  {
    try
    {
      this.zzcgn = paramAdMetadataListener;
      zzzi localzzzi;
      if (this.zzcji != null)
      {
        localzzzi = this.zzcji;
        if (paramAdMetadataListener == null)
          break label40;
      }
      label40: for (zzxw localzzxw = new zzxw(paramAdMetadataListener); ; localzzxw = null)
      {
        localzzzi.zza(localzzxw);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
  }

  public final void setAdUnitId(String paramString)
  {
    if (this.zzchl != null)
      throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    this.zzchl = paramString;
  }

  public final void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.zzbqp = paramAppEventListener;
      zzzi localzzzi;
      if (this.zzcji != null)
      {
        localzzzi = this.zzcji;
        if (paramAppEventListener == null)
          break label40;
      }
      label40: for (zzyd localzzyd = new zzyd(paramAppEventListener); ; localzzyd = null)
      {
        localzzzi.zza(localzzyd);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
  }

  public final void setCorrelator(Correlator paramCorrelator)
  {
    this.zzcjh = paramCorrelator;
    try
    {
      if (this.zzcji != null)
      {
        zzzi localzzzi = this.zzcji;
        if (this.zzcjh == null);
        zzys localzzys;
        for (Object localObject = null; ; localObject = localzzys)
        {
          localzzzi.zzb((zzzw)localObject);
          return;
          localzzys = this.zzcjh.zzdf();
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
  }

  public final void setImmersiveMode(boolean paramBoolean)
  {
    try
    {
      this.zzbrl = paramBoolean;
      if (this.zzcji != null)
        this.zzcji.setImmersiveMode(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
  }

  public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    try
    {
      this.zzcjj = paramOnCustomRenderedAdLoadedListener;
      zzzi localzzzi;
      if (this.zzcji != null)
      {
        localzzzi = this.zzcji;
        if (paramOnCustomRenderedAdLoadedListener == null)
          break label40;
      }
      label40: for (zzadq localzzadq = new zzadq(paramOnCustomRenderedAdLoadedListener); ; localzzadq = null)
      {
        localzzzi.zza(localzzadq);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
  }

  public final void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    try
    {
      this.zzcjn = paramRewardedVideoAdListener;
      zzzi localzzzi;
      if (this.zzcji != null)
      {
        localzzzi = this.zzcji;
        if (paramRewardedVideoAdListener == null)
          break label40;
      }
      label40: for (zzath localzzath = new zzath(paramRewardedVideoAdListener); ; localzzath = null)
      {
        localzzzi.zza(localzzath);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
  }

  public final void show()
  {
    try
    {
      zzce("show");
      this.zzcji.showInterstitial();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
  }

  public final void zza(zzaax paramzzaax)
  {
    try
    {
      if (this.zzcji == null)
      {
        if (this.zzchl == null)
          zzce("loadAd");
        if (!this.zzcjo)
          break label305;
      }
      label305: for (zzyb localzzyb = zzyb.zzou(); ; localzzyb = new zzyb())
      {
        zzyf localzzyf = zzyr.zzpb();
        Context localContext = this.zzlj;
        this.zzcji = ((zzzi)new zzyj(localzzyf, localContext, localzzyb, this.zzchl, this.zzcjd).zzd(localContext, false));
        if (this.zzcgm != null)
          this.zzcji.zzb(new zzxt(this.zzcgm));
        if (this.zzcgj != null)
          this.zzcji.zza(new zzxq(this.zzcgj));
        if (this.zzcgn != null)
          this.zzcji.zza(new zzxw(this.zzcgn));
        if (this.zzbqp != null)
          this.zzcji.zza(new zzyd(this.zzbqp));
        if (this.zzcjj != null)
          this.zzcji.zza(new zzadq(this.zzcjj));
        if (this.zzcjh != null)
          this.zzcji.zzb(this.zzcjh.zzdf());
        if (this.zzcjn != null)
          this.zzcji.zza(new zzath(this.zzcjn));
        this.zzcji.setImmersiveMode(this.zzbrl);
        if (!this.zzcji.zzb(zzya.zza(this.zzlj, paramzzaax)))
          break;
        this.zzcjd.zzf(paramzzaax.zzqa());
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
  }

  public final void zza(zzxp paramzzxp)
  {
    try
    {
      this.zzcgj = paramzzxp;
      zzzi localzzzi;
      if (this.zzcji != null)
      {
        localzzzi = this.zzcji;
        if (paramzzxp == null)
          break label40;
      }
      label40: for (zzxq localzzxq = new zzxq(paramzzxp); ; localzzxq = null)
      {
        localzzzi.zza(localzzxq);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#008 Must be called on the main UI thread.", localRemoteException);
    }
  }

  public final void zzc(boolean paramBoolean)
  {
    this.zzcjo = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzabb
 * JD-Core Version:    0.6.2
 */