package com.google.android.gms.auth;

import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;

abstract interface zzj<T>
{
  public abstract T zzb(IBinder paramIBinder)
    throws RemoteException, IOException, GoogleAuthException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.zzj
 * JD-Core Version:    0.6.2
 */