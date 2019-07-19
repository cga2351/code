package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzagc extends IInterface
{
  public abstract void onUnconfirmedClickCancelled()
    throws RemoteException;

  public abstract void onUnconfirmedClickReceived(String paramString)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagc
 * JD-Core Version:    0.6.2
 */