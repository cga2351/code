package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface zzasx extends IInterface
{
  public abstract void destroy()
    throws RemoteException;

  public abstract Bundle getAdMetadata()
    throws RemoteException;

  public abstract String getMediationAdapterClassName()
    throws RemoteException;

  public abstract boolean isLoaded()
    throws RemoteException;

  public abstract void pause()
    throws RemoteException;

  public abstract void resume()
    throws RemoteException;

  public abstract void setAppPackageName(String paramString)
    throws RemoteException;

  public abstract void setCustomData(String paramString)
    throws RemoteException;

  public abstract void setImmersiveMode(boolean paramBoolean)
    throws RemoteException;

  public abstract void setUserId(String paramString)
    throws RemoteException;

  public abstract void show()
    throws RemoteException;

  public abstract void zza(zzasv paramzzasv)
    throws RemoteException;

  public abstract void zza(zzatc paramzzatc)
    throws RemoteException;

  public abstract void zza(zzati paramzzati)
    throws RemoteException;

  public abstract void zza(zzzn paramzzzn)
    throws RemoteException;

  public abstract void zzk(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void zzl(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void zzm(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void zzn(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzasx
 * JD-Core Version:    0.6.2
 */