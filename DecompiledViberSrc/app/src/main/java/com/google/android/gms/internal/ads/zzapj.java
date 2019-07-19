package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

final class zzapj
  implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationNativeAdCallback, MediationRewardedAdCallback
{
  private zzamw zzdhn;

  zzapj(zzamw paramzzamw)
  {
    this.zzdhn = paramzzamw;
  }

  public final void onAdClosed()
  {
    try
    {
      this.zzdhn.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public final void onAdFailedToShow(String paramString)
  {
    try
    {
      String str1 = String.valueOf(paramString);
      if (str1.length() != 0);
      for (String str2 = "Mediated ad failed to show: ".concat(str1); ; str2 = new String("Mediated ad failed to show: "))
      {
        zzbae.zzep(str2);
        this.zzdhn.zzcs(0);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public final void onAdLeftApplication()
  {
    try
    {
      this.zzdhn.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public final void onAdOpened()
  {
    try
    {
      this.zzdhn.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public final void onUserEarnedReward(RewardItem paramRewardItem)
  {
    try
    {
      this.zzdhn.zza(new zzauq(paramRewardItem));
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public final void onVideoComplete()
  {
    try
    {
      this.zzdhn.onVideoEnd();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public final void onVideoMute()
  {
  }

  public final void onVideoPause()
  {
  }

  public final void onVideoPlay()
  {
    try
    {
      this.zzdhn.onVideoPlay();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public final void onVideoStart()
  {
    try
    {
      this.zzdhn.zzsm();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public final void onVideoUnmute()
  {
  }

  public final void reportAdClicked()
  {
    try
    {
      this.zzdhn.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public final void reportAdImpression()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapj
 * JD-Core Version:    0.6.2
 */