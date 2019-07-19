package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

public abstract interface zzh extends IInterface
{
  public abstract LatLng getCenter()
    throws RemoteException;

  public abstract int getFillColor()
    throws RemoteException;

  public abstract String getId()
    throws RemoteException;

  public abstract double getRadius()
    throws RemoteException;

  public abstract int getStrokeColor()
    throws RemoteException;

  public abstract List<PatternItem> getStrokePattern()
    throws RemoteException;

  public abstract float getStrokeWidth()
    throws RemoteException;

  public abstract float getZIndex()
    throws RemoteException;

  public abstract boolean isClickable()
    throws RemoteException;

  public abstract boolean isVisible()
    throws RemoteException;

  public abstract void remove()
    throws RemoteException;

  public abstract void setCenter(LatLng paramLatLng)
    throws RemoteException;

  public abstract void setClickable(boolean paramBoolean)
    throws RemoteException;

  public abstract void setFillColor(int paramInt)
    throws RemoteException;

  public abstract void setRadius(double paramDouble)
    throws RemoteException;

  public abstract void setStrokeColor(int paramInt)
    throws RemoteException;

  public abstract void setStrokePattern(List<PatternItem> paramList)
    throws RemoteException;

  public abstract void setStrokeWidth(float paramFloat)
    throws RemoteException;

  public abstract void setVisible(boolean paramBoolean)
    throws RemoteException;

  public abstract void setZIndex(float paramFloat)
    throws RemoteException;

  public abstract boolean zzb(zzh paramzzh)
    throws RemoteException;

  public abstract void zze(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract int zzj()
    throws RemoteException;

  public abstract IObjectWrapper zzk()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzh
 * JD-Core Version:    0.6.2
 */