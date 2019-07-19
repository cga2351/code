package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzyx extends IInterface
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzyx
 * JD-Core Version:    0.6.2
 */