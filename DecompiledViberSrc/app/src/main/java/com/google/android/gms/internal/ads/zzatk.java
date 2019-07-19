package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzare
public final class zzatk
  implements RewardedVideoAd
{
  private final Object lock = new Object();
  private final zzasx zzdqs;
  private final zzath zzdqt = new zzath(null);
  private String zzdqu;
  private String zzdqv;
  private final Context zzlj;

  public zzatk(Context paramContext, zzasx paramzzasx)
  {
    if (paramzzasx == null)
      paramzzasx = new zzabw();
    this.zzdqs = paramzzasx;
    this.zzlj = paramContext.getApplicationContext();
  }

  private final void zza(String paramString, zzaax paramzzaax)
  {
    synchronized (this.lock)
    {
      if (this.zzdqs == null)
        return;
    }
    try
    {
      this.zzdqs.zza(new zzati(zzya.zza(this.zzlj, paramzzaax), paramString));
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void destroy()
  {
    destroy(null);
  }

  public final void destroy(Context paramContext)
  {
    synchronized (this.lock)
    {
      this.zzdqt.setRewardedVideoAdListener(null);
      if (this.zzdqs == null)
        return;
    }
    try
    {
      this.zzdqs.zzn(ObjectWrapper.wrap(paramContext));
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final Bundle getAdMetadata()
  {
    synchronized (this.lock)
    {
      zzasx localzzasx = this.zzdqs;
      if (localzzasx != null)
        try
        {
          Bundle localBundle2 = this.zzdqs.getAdMetadata();
          return localBundle2;
        }
        catch (RemoteException localRemoteException)
        {
          zzbae.zze("#007 Could not call remote method.", localRemoteException);
        }
      Bundle localBundle1 = new Bundle();
      return localBundle1;
    }
  }

  public final String getCustomData()
  {
    synchronized (this.lock)
    {
      String str = this.zzdqv;
      return str;
    }
  }

  public final String getMediationAdapterClassName()
  {
    try
    {
      if (this.zzdqs != null)
      {
        String str = this.zzdqs.getMediationAdapterClassName();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
    return null;
  }

  public final RewardedVideoAdListener getRewardedVideoAdListener()
  {
    synchronized (this.lock)
    {
      RewardedVideoAdListener localRewardedVideoAdListener = this.zzdqt.getRewardedVideoAdListener();
      return localRewardedVideoAdListener;
    }
  }

  public final String getUserId()
  {
    synchronized (this.lock)
    {
      String str = this.zzdqu;
      return str;
    }
  }

  public final boolean isLoaded()
  {
    synchronized (this.lock)
    {
      if (this.zzdqs == null)
        return false;
    }
    try
    {
      boolean bool = this.zzdqs.isLoaded();
      return bool;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
    return false;
  }

  public final void loadAd(String paramString, AdRequest paramAdRequest)
  {
    zza(paramString, paramAdRequest.zzde());
  }

  public final void loadAd(String paramString, PublisherAdRequest paramPublisherAdRequest)
  {
    zza(paramString, paramPublisherAdRequest.zzde());
  }

  public final void pause()
  {
    pause(null);
  }

  public final void pause(Context paramContext)
  {
    synchronized (this.lock)
    {
      if (this.zzdqs == null)
        return;
    }
    try
    {
      this.zzdqs.zzl(ObjectWrapper.wrap(paramContext));
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void resume()
  {
    resume(null);
  }

  public final void resume(Context paramContext)
  {
    synchronized (this.lock)
    {
      if (this.zzdqs == null)
        return;
    }
    try
    {
      this.zzdqs.zzm(ObjectWrapper.wrap(paramContext));
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void setAdMetadataListener(AdMetadataListener paramAdMetadataListener)
  {
    synchronized (this.lock)
    {
      zzasx localzzasx = this.zzdqs;
      if (localzzasx != null);
      try
      {
        this.zzdqs.zza(new zzxw(paramAdMetadataListener));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
  }

  public final void setCustomData(String paramString)
  {
    synchronized (this.lock)
    {
      zzasx localzzasx = this.zzdqs;
      if (localzzasx != null);
      try
      {
        this.zzdqs.setCustomData(paramString);
        this.zzdqv = paramString;
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
  }

  public final void setImmersiveMode(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      zzasx localzzasx = this.zzdqs;
      if (localzzasx != null);
      try
      {
        this.zzdqs.setImmersiveMode(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
  }

  public final void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    synchronized (this.lock)
    {
      this.zzdqt.setRewardedVideoAdListener(paramRewardedVideoAdListener);
      zzasx localzzasx = this.zzdqs;
      if (localzzasx != null);
      try
      {
        this.zzdqs.zza(this.zzdqt);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
  }

  public final void setUserId(String paramString)
  {
    synchronized (this.lock)
    {
      this.zzdqu = paramString;
      zzasx localzzasx = this.zzdqs;
      if (localzzasx != null);
      try
      {
        this.zzdqs.setUserId(paramString);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
  }

  public final void show()
  {
    synchronized (this.lock)
    {
      if (this.zzdqs == null)
        return;
    }
    try
    {
      this.zzdqs.show();
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzatk
 * JD-Core Version:    0.6.2
 */