package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface zzadk extends IInterface
{
  public abstract String getContent()
    throws RemoteException;

  public abstract void recordClick()
    throws RemoteException;

  public abstract void recordImpression()
    throws RemoteException;

  public abstract void zzo(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract String zzqz()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadk
 * JD-Core Version:    0.6.2
 */