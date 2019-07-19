package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzaas extends IInterface
{
  public abstract void onVideoEnd()
    throws RemoteException;

  public abstract void onVideoMute(boolean paramBoolean)
    throws RemoteException;

  public abstract void onVideoPause()
    throws RemoteException;

  public abstract void onVideoPlay()
    throws RemoteException;

  public abstract void onVideoStart()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaas
 * JD-Core Version:    0.6.2
 */