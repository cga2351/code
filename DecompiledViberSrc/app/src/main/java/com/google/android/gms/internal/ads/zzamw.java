package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzamw extends IInterface
{
  public abstract void onAdClicked()
    throws RemoteException;

  public abstract void onAdClosed()
    throws RemoteException;

  public abstract void onAdFailedToLoad(int paramInt)
    throws RemoteException;

  public abstract void onAdImpression()
    throws RemoteException;

  public abstract void onAdLeftApplication()
    throws RemoteException;

  public abstract void onAdLoaded()
    throws RemoteException;

  public abstract void onAdOpened()
    throws RemoteException;

  public abstract void onAppEvent(String paramString1, String paramString2)
    throws RemoteException;

  public abstract void onVideoEnd()
    throws RemoteException;

  public abstract void onVideoPause()
    throws RemoteException;

  public abstract void onVideoPlay()
    throws RemoteException;

  public abstract void zza(zzafd paramzzafd, String paramString)
    throws RemoteException;

  public abstract void zza(zzamz paramzzamz)
    throws RemoteException;

  public abstract void zza(zzatr paramzzatr)
    throws RemoteException;

  public abstract void zzb(Bundle paramBundle)
    throws RemoteException;

  public abstract void zzb(zzatp paramzzatp)
    throws RemoteException;

  public abstract void zzcs(int paramInt)
    throws RemoteException;

  public abstract void zzcz(String paramString)
    throws RemoteException;

  public abstract void zzsm()
    throws RemoteException;

  public abstract void zzsn()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamw
 * JD-Core Version:    0.6.2
 */