package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public abstract interface zzk extends IInterface
{
  public abstract float getBearing()
    throws RemoteException;

  public abstract LatLngBounds getBounds()
    throws RemoteException;

  public abstract float getHeight()
    throws RemoteException;

  public abstract String getId()
    throws RemoteException;

  public abstract LatLng getPosition()
    throws RemoteException;

  public abstract float getTransparency()
    throws RemoteException;

  public abstract float getWidth()
    throws RemoteException;

  public abstract float getZIndex()
    throws RemoteException;

  public abstract boolean isClickable()
    throws RemoteException;

  public abstract boolean isVisible()
    throws RemoteException;

  public abstract void remove()
    throws RemoteException;

  public abstract void setBearing(float paramFloat)
    throws RemoteException;

  public abstract void setClickable(boolean paramBoolean)
    throws RemoteException;

  public abstract void setDimensions(float paramFloat)
    throws RemoteException;

  public abstract void setPosition(LatLng paramLatLng)
    throws RemoteException;

  public abstract void setPositionFromBounds(LatLngBounds paramLatLngBounds)
    throws RemoteException;

  public abstract void setTransparency(float paramFloat)
    throws RemoteException;

  public abstract void setVisible(boolean paramBoolean)
    throws RemoteException;

  public abstract void setZIndex(float paramFloat)
    throws RemoteException;

  public abstract void zza(float paramFloat1, float paramFloat2)
    throws RemoteException;

  public abstract boolean zzb(zzk paramzzk)
    throws RemoteException;

  public abstract void zze(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void zzf(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract int zzj()
    throws RemoteException;

  public abstract IObjectWrapper zzk()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzk
 * JD-Core Version:    0.6.2
 */