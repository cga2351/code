package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzac extends IInterface
{
  public abstract void clearTileCache()
    throws RemoteException;

  public abstract boolean getFadeIn()
    throws RemoteException;

  public abstract String getId()
    throws RemoteException;

  public abstract float getTransparency()
    throws RemoteException;

  public abstract float getZIndex()
    throws RemoteException;

  public abstract boolean isVisible()
    throws RemoteException;

  public abstract void remove()
    throws RemoteException;

  public abstract void setFadeIn(boolean paramBoolean)
    throws RemoteException;

  public abstract void setTransparency(float paramFloat)
    throws RemoteException;

  public abstract void setVisible(boolean paramBoolean)
    throws RemoteException;

  public abstract void setZIndex(float paramFloat)
    throws RemoteException;

  public abstract boolean zza(zzac paramzzac)
    throws RemoteException;

  public abstract int zzj()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzac
 * JD-Core Version:    0.6.2
 */