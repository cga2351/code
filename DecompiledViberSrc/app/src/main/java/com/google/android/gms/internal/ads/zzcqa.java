package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzcqa
  implements zzbrn, zzbsq
{

  @GuardedBy("this")
  private zzauc zzgeu;

  public final void onAdFailedToLoad(int paramInt)
  {
    try
    {
      zzauc localzzauc = this.zzgeu;
      if (localzzauc != null);
      try
      {
        this.zzgeu.onRewardedAdFailedToLoad(paramInt);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzbae.zze("#007 Could not call remote method.", localRemoteException);
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
      zzauc localzzauc = this.zzgeu;
      if (localzzauc != null);
      try
      {
        this.zzgeu.onRewardedAdLoaded();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void zza(zzauc paramzzauc)
  {
    try
    {
      this.zzgeu = paramzzauc;
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzcqa
 * JD-Core Version:    0.6.2
 */