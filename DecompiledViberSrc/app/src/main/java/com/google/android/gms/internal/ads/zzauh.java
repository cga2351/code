package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzauh
{
  private final zzatu zzdqx;
  private final Context zzys;

  public zzauh(Context paramContext, String paramString)
  {
    this.zzys = paramContext.getApplicationContext();
    this.zzdqx = zzyr.zzpb().zzc(paramContext, paramString, new zzamp());
  }

  public final Bundle getAdMetadata()
  {
    try
    {
      Bundle localBundle = this.zzdqx.getAdMetadata();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
    return new Bundle();
  }

  public final String getMediationAdapterClassName()
  {
    try
    {
      String str = this.zzdqx.getMediationAdapterClassName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
    return "";
  }

  @Nullable
  public final RewardItem getRewardItem()
  {
    try
    {
      zzatr localzzatr = this.zzdqx.zzqh();
      if (localzzatr == null)
        return null;
      zzaui localzzaui = new zzaui(localzzatr);
      return localzzaui;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
    return null;
  }

  public final boolean isLoaded()
  {
    try
    {
      boolean bool = this.zzdqx.isLoaded();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
    return false;
  }

  public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener paramOnAdMetadataChangedListener)
  {
    try
    {
      this.zzdqx.zza(new zzaby(paramOnAdMetadataChangedListener));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void setServerSideVerificationOptions(ServerSideVerificationOptions paramServerSideVerificationOptions)
  {
    try
    {
      this.zzdqx.zza(new zzaun(paramServerSideVerificationOptions));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void show(Activity paramActivity, RewardedAdCallback paramRewardedAdCallback)
  {
    try
    {
      this.zzdqx.zza(new zzauj(paramRewardedAdCallback));
      this.zzdqx.zzj(ObjectWrapper.wrap(paramActivity));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void show(Activity paramActivity, RewardedAdCallback paramRewardedAdCallback, boolean paramBoolean)
  {
    try
    {
      this.zzdqx.zza(new zzauj(paramRewardedAdCallback));
      this.zzdqx.zza(ObjectWrapper.wrap(paramActivity), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void zza(zzaax paramzzaax, RewardedAdLoadCallback paramRewardedAdLoadCallback)
  {
    try
    {
      this.zzdqx.zza(zzya.zza(this.zzys, paramzzaax), new zzaum(paramRewardedAdLoadCallback));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzauh
 * JD-Core Version:    0.6.2
 */