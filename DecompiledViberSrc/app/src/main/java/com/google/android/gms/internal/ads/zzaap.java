package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzaap extends IInterface
{
  public abstract float getAspectRatio()
    throws RemoteException;

  public abstract int getPlaybackState()
    throws RemoteException;

  public abstract boolean isClickToExpandEnabled()
    throws RemoteException;

  public abstract boolean isCustomControlsEnabled()
    throws RemoteException;

  public abstract boolean isMuted()
    throws RemoteException;

  public abstract void mute(boolean paramBoolean)
    throws RemoteException;

  public abstract void pause()
    throws RemoteException;

  public abstract void play()
    throws RemoteException;

  public abstract void zza(zzaas paramzzaas)
    throws RemoteException;

  public abstract float zzpv()
    throws RemoteException;

  public abstract float zzpw()
    throws RemoteException;

  public abstract zzaas zzpx()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaap
 * JD-Core Version:    0.6.2
 */