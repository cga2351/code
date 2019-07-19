package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;

final class h extends AdMetadataListener
{
  h(AbstractAdViewAdapter paramAbstractAdViewAdapter)
  {
  }

  public final void onAdMetadataChanged()
  {
    if ((AbstractAdViewAdapter.zzb(this.a) != null) && (AbstractAdViewAdapter.zza(this.a) != null))
    {
      Bundle localBundle = AbstractAdViewAdapter.zzb(this.a).getAdMetadata();
      AbstractAdViewAdapter.zza(this.a).zzb(localBundle);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.h
 * JD-Core Version:    0.6.2
 */