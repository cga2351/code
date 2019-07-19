package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaax;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzafn;
import com.google.android.gms.internal.ads.zzagl;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzagn;
import com.google.android.gms.internal.ads.zzago;
import com.google.android.gms.internal.ads.zzagp;
import com.google.android.gms.internal.ads.zzagr;
import com.google.android.gms.internal.ads.zzamp;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzxt;
import com.google.android.gms.internal.ads.zzya;
import com.google.android.gms.internal.ads.zzyb;
import com.google.android.gms.internal.ads.zzyf;
import com.google.android.gms.internal.ads.zzyr;
import com.google.android.gms.internal.ads.zzza;
import com.google.android.gms.internal.ads.zzzd;

public class AdLoader
{
  private final zzya zzaaj;
  private final zzza zzaak;
  private final Context zzlj;

  AdLoader(Context paramContext, zzza paramzzza)
  {
    this(paramContext, paramzzza, zzya.zzchf);
  }

  private AdLoader(Context paramContext, zzza paramzzza, zzya paramzzya)
  {
    this.zzlj = paramContext;
    this.zzaak = paramzzza;
    this.zzaaj = paramzzya;
  }

  private final void zza(zzaax paramzzaax)
  {
    try
    {
      this.zzaak.zza(zzya.zza(this.zzlj, paramzzaax));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Failed to load ad.", localRemoteException);
    }
  }

  @Deprecated
  public String getMediationAdapterClassName()
  {
    try
    {
      String str = this.zzaak.zzpj();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }

  public boolean isLoading()
  {
    try
    {
      boolean bool = this.zzaak.isLoading();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Failed to check if ad is loading.", localRemoteException);
    }
    return false;
  }

  public void loadAd(AdRequest paramAdRequest)
  {
    zza(paramAdRequest.zzde());
  }

  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    zza(paramPublisherAdRequest.zzde());
  }

  public void loadAds(AdRequest paramAdRequest, int paramInt)
  {
    zzaax localzzaax = paramAdRequest.zzde();
    try
    {
      this.zzaak.zza(zzya.zza(this.zzlj, localzzaax), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Failed to load ads.", localRemoteException);
    }
  }

  public static class Builder
  {
    private final zzzd zzaal;
    private final Context zzlj;

    private Builder(Context paramContext, zzzd paramzzzd)
    {
      this.zzlj = paramContext;
      this.zzaal = paramzzzd;
    }

    public Builder(Context paramContext, String paramString)
    {
      this((Context)Preconditions.checkNotNull(paramContext, "context cannot be null"), zzyr.zzpb().zzb(paramContext, paramString, new zzamp()));
    }

    public AdLoader build()
    {
      try
      {
        AdLoader localAdLoader = new AdLoader(this.zzlj, this.zzaal.zzpk());
        return localAdLoader;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzc("Failed to build AdLoader.", localRemoteException);
      }
      return null;
    }

    @Deprecated
    public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
    {
      try
      {
        this.zzaal.zza(new zzagl(paramOnAppInstallAdLoadedListener));
        return this;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzd("Failed to add app install ad listener", localRemoteException);
      }
      return this;
    }

    @Deprecated
    public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener paramOnContentAdLoadedListener)
    {
      try
      {
        this.zzaal.zza(new zzagm(paramOnContentAdLoadedListener));
        return this;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzd("Failed to add content ad listener", localRemoteException);
      }
      return this;
    }

    public Builder forCustomTemplateAd(String paramString, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener paramOnCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener paramOnCustomClickListener)
    {
      try
      {
        zzzd localzzzd = this.zzaal;
        zzago localzzago = new zzago(paramOnCustomTemplateAdLoadedListener);
        if (paramOnCustomClickListener == null);
        for (Object localObject = null; ; localObject = new zzagn(paramOnCustomClickListener))
        {
          localzzzd.zza(paramString, localzzago, (zzafn)localObject);
          return this;
        }
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzd("Failed to add custom template ad listener", localRemoteException);
      }
      return this;
    }

    public Builder forPublisherAdView(OnPublisherAdViewLoadedListener paramOnPublisherAdViewLoadedListener, AdSize[] paramArrayOfAdSize)
    {
      if ((paramArrayOfAdSize == null) || (paramArrayOfAdSize.length <= 0))
        throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
      try
      {
        zzyb localzzyb = new zzyb(this.zzlj, paramArrayOfAdSize);
        this.zzaal.zza(new zzagp(paramOnPublisherAdViewLoadedListener), localzzyb);
        return this;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzd("Failed to add publisher banner ad listener", localRemoteException);
      }
      return this;
    }

    public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener paramOnUnifiedNativeAdLoadedListener)
    {
      try
      {
        this.zzaal.zza(new zzagr(paramOnUnifiedNativeAdLoadedListener));
        return this;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzd("Failed to add google native ad listener", localRemoteException);
      }
      return this;
    }

    public Builder withAdListener(AdListener paramAdListener)
    {
      try
      {
        this.zzaal.zza(new zzxt(paramAdListener));
        return this;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzd("Failed to set AdListener.", localRemoteException);
      }
      return this;
    }

    public Builder withCorrelator(Correlator paramCorrelator)
    {
      Preconditions.checkNotNull(paramCorrelator);
      try
      {
        this.zzaal.zza(paramCorrelator.zzaar);
        return this;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzd("Failed to set correlator.", localRemoteException);
      }
      return this;
    }

    public Builder withNativeAdOptions(NativeAdOptions paramNativeAdOptions)
    {
      try
      {
        this.zzaal.zza(new zzadx(paramNativeAdOptions));
        return this;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzd("Failed to specify native ad options", localRemoteException);
      }
      return this;
    }

    public Builder withPublisherAdViewOptions(PublisherAdViewOptions paramPublisherAdViewOptions)
    {
      try
      {
        this.zzaal.zza(paramPublisherAdViewOptions);
        return this;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzd("Failed to specify DFP banner ad options", localRemoteException);
      }
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.AdLoader
 * JD-Core Version:    0.6.2
 */