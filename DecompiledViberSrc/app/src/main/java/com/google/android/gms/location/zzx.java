package com.google.android.gms.location;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzx extends IInterface
{
  public abstract void onLocationChanged(Location paramLocation)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.zzx
 * JD-Core Version:    0.6.2
 */