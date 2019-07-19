package com.google.android.gms.location;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzu extends IInterface
{
  public abstract void onLocationAvailability(LocationAvailability paramLocationAvailability)
    throws RemoteException;

  public abstract void onLocationResult(LocationResult paramLocationResult)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.zzu
 * JD-Core Version:    0.6.2
 */