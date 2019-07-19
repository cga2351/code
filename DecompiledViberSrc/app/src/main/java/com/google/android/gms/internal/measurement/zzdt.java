package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzdt extends IInterface
{
  public abstract int id()
    throws RemoteException;

  public abstract void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdt
 * JD-Core Version:    0.6.2
 */