package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzank extends zzaaq
{
  private final Object lock = new Object();
  private volatile zzaas zzdgb;

  public final float getAspectRatio()
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final int getPlaybackState()
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final boolean isClickToExpandEnabled()
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final boolean isCustomControlsEnabled()
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final boolean isMuted()
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final void mute(boolean paramBoolean)
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final void pause()
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final void play()
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final void zza(zzaas paramzzaas)
    throws RemoteException
  {
    synchronized (this.lock)
    {
      this.zzdgb = paramzzaas;
      return;
    }
  }

  public final float zzpv()
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final float zzpw()
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final zzaas zzpx()
    throws RemoteException
  {
    synchronized (this.lock)
    {
      zzaas localzzaas = this.zzdgb;
      return localzzaas;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzank
 * JD-Core Version:    0.6.2
 */