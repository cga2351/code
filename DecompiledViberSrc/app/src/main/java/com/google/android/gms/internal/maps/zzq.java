package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzq extends IInterface
{
  public abstract void activate()
    throws RemoteException;

  public abstract String getName()
    throws RemoteException;

  public abstract String getShortName()
    throws RemoteException;

  public abstract boolean zzb(zzq paramzzq)
    throws RemoteException;

  public abstract int zzj()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzq
 * JD-Core Version:    0.6.2
 */