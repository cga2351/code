package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzxp;

public final class InterstitialAd
{
  private final zzabb zzaas;

  public InterstitialAd(Context paramContext)
  {
    this.zzaas = new zzabb(paramContext);
    Preconditions.checkNotNull(paramContext, "Context cannot be null");
  }

  public final AdListener getAdListener()
  {
    return this.zzaas.getAdListener();
  }

  public final Bundle getAdMetadata()
  {
    return this.zzaas.getAdMetadata();
  }

  public final String getAdUnitId()
  {
    return this.zzaas.getAdUnitId();
  }

  public final String getMediationAdapterClassName()
  {
    return this.zzaas.getMediationAdapterClassName();
  }

  public final boolean isLoaded()
  {
    return this.zzaas.isLoaded();
  }

  public final boolean isLoading()
  {
    return this.zzaas.isLoading();
  }

  public final void loadAd(AdRequest paramAdRequest)
  {
    this.zzaas.zza(paramAdRequest.zzde());
  }

  public final void setAdListener(AdListener paramAdListener)
  {
    this.zzaas.setAdListener(paramAdListener);
    if ((paramAdListener != null) && ((paramAdListener instanceof zzxp)))
      this.zzaas.zza((zzxp)paramAdListener);
    while (paramAdListener != null)
      return;
    this.zzaas.zza(null);
  }

  public final void setAdMetadataListener(AdMetadataListener paramAdMetadataListener)
  {
    this.zzaas.setAdMetadataListener(paramAdMetadataListener);
  }

  public final void setAdUnitId(String paramString)
  {
    this.zzaas.setAdUnitId(paramString);
  }

  public final void setImmersiveMode(boolean paramBoolean)
  {
    this.zzaas.setImmersiveMode(paramBoolean);
  }

  public final void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    this.zzaas.setRewardedVideoAdListener(paramRewardedVideoAdListener);
  }

  public final void show()
  {
    this.zzaas.show();
  }

  public final void zzc(boolean paramBoolean)
  {
    this.zzaas.zzc(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.InterstitialAd
 * JD-Core Version:    0.6.2
 */