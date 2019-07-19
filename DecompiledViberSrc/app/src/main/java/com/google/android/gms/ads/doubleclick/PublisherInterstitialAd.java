package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabb;

public final class PublisherInterstitialAd
{
  private final zzabb zzaas = new zzabb(paramContext, this);

  public PublisherInterstitialAd(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext, "Context cannot be null");
  }

  public final AdListener getAdListener()
  {
    return this.zzaas.getAdListener();
  }

  public final String getAdUnitId()
  {
    return this.zzaas.getAdUnitId();
  }

  public final AppEventListener getAppEventListener()
  {
    return this.zzaas.getAppEventListener();
  }

  public final String getMediationAdapterClassName()
  {
    return this.zzaas.getMediationAdapterClassName();
  }

  public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return this.zzaas.getOnCustomRenderedAdLoadedListener();
  }

  public final boolean isLoaded()
  {
    return this.zzaas.isLoaded();
  }

  public final boolean isLoading()
  {
    return this.zzaas.isLoading();
  }

  public final void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.zzaas.zza(paramPublisherAdRequest.zzde());
  }

  public final void setAdListener(AdListener paramAdListener)
  {
    this.zzaas.setAdListener(paramAdListener);
  }

  public final void setAdUnitId(String paramString)
  {
    this.zzaas.setAdUnitId(paramString);
  }

  public final void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.zzaas.setAppEventListener(paramAppEventListener);
  }

  public final void setCorrelator(Correlator paramCorrelator)
  {
    this.zzaas.setCorrelator(paramCorrelator);
  }

  public final void setImmersiveMode(boolean paramBoolean)
  {
    this.zzaas.setImmersiveMode(paramBoolean);
  }

  public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    this.zzaas.setOnCustomRenderedAdLoadedListener(paramOnCustomRenderedAdLoadedListener);
  }

  public final void show()
  {
    this.zzaas.show();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherInterstitialAd
 * JD-Core Version:    0.6.2
 */