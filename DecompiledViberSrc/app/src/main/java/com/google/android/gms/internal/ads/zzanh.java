package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract interface zzanh extends IInterface
{
  public abstract String getAdvertiser()
    throws RemoteException;

  public abstract String getBody()
    throws RemoteException;

  public abstract String getCallToAction()
    throws RemoteException;

  public abstract Bundle getExtras()
    throws RemoteException;

  public abstract String getHeadline()
    throws RemoteException;

  public abstract List getImages()
    throws RemoteException;

  public abstract boolean getOverrideClickHandling()
    throws RemoteException;

  public abstract boolean getOverrideImpressionRecording()
    throws RemoteException;

  public abstract String getPrice()
    throws RemoteException;

  public abstract double getStarRating()
    throws RemoteException;

  public abstract String getStore()
    throws RemoteException;

  public abstract zzaap getVideoController()
    throws RemoteException;

  public abstract void recordImpression()
    throws RemoteException;

  public abstract void zzc(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
    throws RemoteException;

  public abstract zzaeh zzri()
    throws RemoteException;

  public abstract zzadz zzrj()
    throws RemoteException;

  public abstract IObjectWrapper zzrk()
    throws RemoteException;

  public abstract IObjectWrapper zzso()
    throws RemoteException;

  public abstract IObjectWrapper zzsp()
    throws RemoteException;

  public abstract float zzsq()
    throws RemoteException;

  public abstract void zzt(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void zzv(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzanh
 * JD-Core Version:    0.6.2
 */