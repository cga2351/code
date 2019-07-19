package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzckz extends zzamx
  implements zzbsl
{

  @GuardedBy("this")
  private zzamw zzdhn;

  @GuardedBy("this")
  private zzbsm zzgai;

  public final void onAdClicked()
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.onAdClicked();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onAdClosed()
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.onAdClosed();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onAdFailedToLoad(int paramInt)
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.onAdFailedToLoad(paramInt);
      if (this.zzgai != null)
        this.zzgai.onAdFailedToLoad(paramInt);
      return;
    }
    finally
    {
    }
  }

  public final void onAdImpression()
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.onAdImpression();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onAdLeftApplication()
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.onAdLeftApplication();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onAdLoaded()
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.onAdLoaded();
      if (this.zzgai != null)
        this.zzgai.onAdLoaded();
      return;
    }
    finally
    {
    }
  }

  public final void onAdOpened()
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.onAdOpened();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onAppEvent(String paramString1, String paramString2)
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.onAppEvent(paramString1, paramString2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onVideoEnd()
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.onVideoEnd();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onVideoPause()
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.onVideoPause();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onVideoPlay()
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.onVideoPlay();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzafd paramzzafd, String paramString)
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.zza(paramzzafd, paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzamw paramzzamw)
  {
    try
    {
      this.zzdhn = paramzzamw;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzamz paramzzamz)
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.zza(paramzzamz);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzatr paramzzatr)
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.zza(paramzzatr);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzbsm paramzzbsm)
  {
    try
    {
      this.zzgai = paramzzbsm;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzb(Bundle paramBundle)
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.zzb(paramBundle);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzb(zzatp paramzzatp)
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.zzb(paramzzatp);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzcs(int paramInt)
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.zzcs(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzcz(String paramString)
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.zzcz(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzsm()
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.zzsm();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzsn()
    throws RemoteException
  {
    try
    {
      if (this.zzdhn != null)
        this.zzdhn.zzsn();
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzckz
 * JD-Core Version:    0.6.2
 */