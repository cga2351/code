package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpv
  implements zzbrk, zzbrn, zzbrv, zzbsq, zzxp
{

  @GuardedBy("this")
  private zzyx zzgeo;

  public final void onAdClicked()
  {
    try
    {
      zzyx localzzyx = this.zzgeo;
      if (localzzyx != null);
      try
      {
        this.zzgeo.onAdClicked();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdClicked.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onAdClosed()
  {
    try
    {
      zzyx localzzyx = this.zzgeo;
      if (localzzyx != null);
      try
      {
        this.zzgeo.onAdClosed();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdClosed.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onAdFailedToLoad(int paramInt)
  {
    try
    {
      zzyx localzzyx = this.zzgeo;
      if (localzzyx != null);
      try
      {
        this.zzgeo.onAdFailedToLoad(paramInt);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdFailedToLoad.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onAdImpression()
  {
    try
    {
      zzyx localzzyx = this.zzgeo;
      if (localzzyx != null);
      try
      {
        this.zzgeo.onAdImpression();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdImpression.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onAdLeftApplication()
  {
    try
    {
      zzyx localzzyx = this.zzgeo;
      if (localzzyx != null);
      try
      {
        this.zzgeo.onAdLeftApplication();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdLeftApplication.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onAdLoaded()
  {
    try
    {
      zzyx localzzyx = this.zzgeo;
      if (localzzyx != null);
      try
      {
        this.zzgeo.onAdLoaded();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdLoaded.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onAdOpened()
  {
    try
    {
      zzyx localzzyx = this.zzgeo;
      if (localzzyx != null);
      try
      {
        this.zzgeo.onAdOpened();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdOpened.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void onRewardedVideoCompleted()
  {
  }

  public final void onRewardedVideoStarted()
  {
  }

  public final zzyx zzald()
  {
    try
    {
      zzyx localzzyx = this.zzgeo;
      return localzzyx;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzb(zzass paramzzass, String paramString1, String paramString2)
  {
  }

  public final void zzc(zzyx paramzzyx)
  {
    try
    {
      this.zzgeo = paramzzyx;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcpv
 * JD-Core Version:    0.6.2
 */