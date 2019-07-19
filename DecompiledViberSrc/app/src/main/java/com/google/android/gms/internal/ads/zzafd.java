package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract interface zzafd extends IInterface
{
  public abstract void destroy()
    throws RemoteException;

  public abstract List<String> getAvailableAssetNames()
    throws RemoteException;

  public abstract String getCustomTemplateId()
    throws RemoteException;

  public abstract zzaap getVideoController()
    throws RemoteException;

  public abstract void performClick(String paramString)
    throws RemoteException;

  public abstract void recordImpression()
    throws RemoteException;

  public abstract String zzcj(String paramString)
    throws RemoteException;

  public abstract zzaeh zzck(String paramString)
    throws RemoteException;

  public abstract boolean zzp(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract IObjectWrapper zzrh()
    throws RemoteException;

  public abstract IObjectWrapper zzrm()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzafd
 * JD-Core Version:    0.6.2
 */