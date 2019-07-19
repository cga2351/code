package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface zzdag extends IInterface
{
  public abstract String getVersion()
    throws RemoteException;

  public abstract IObjectWrapper zza(String paramString1, IObjectWrapper paramIObjectWrapper, String paramString2, String paramString3, String paramString4, String paramString5)
    throws RemoteException;

  public abstract void zzaa(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void zzab(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract boolean zzap(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void zzd(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdag
 * JD-Core Version:    0.6.2
 */