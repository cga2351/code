package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface zzael extends IInterface
{
  public abstract void destroy()
    throws RemoteException;

  public abstract void zzc(IObjectWrapper paramIObjectWrapper, int paramInt)
    throws RemoteException;

  public abstract void zzc(String paramString, IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract IObjectWrapper zzcf(String paramString)
    throws RemoteException;

  public abstract void zze(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void zzi(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzael
 * JD-Core Version:    0.6.2
 */