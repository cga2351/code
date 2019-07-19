package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

public abstract interface zzw extends IInterface
{
  public abstract int getFillColor()
    throws RemoteException;

  public abstract List getHoles()
    throws RemoteException;

  public abstract String getId()
    throws RemoteException;

  public abstract List<LatLng> getPoints()
    throws RemoteException;

  public abstract int getStrokeColor()
    throws RemoteException;

  public abstract int getStrokeJointType()
    throws RemoteException;

  public abstract List<PatternItem> getStrokePattern()
    throws RemoteException;

  public abstract float getStrokeWidth()
    throws RemoteException;

  public abstract float getZIndex()
    throws RemoteException;

  public abstract boolean isClickable()
    throws RemoteException;

  public abstract boolean isGeodesic()
    throws RemoteException;

  public abstract boolean isVisible()
    throws RemoteException;

  public abstract void remove()
    throws RemoteException;

  public abstract void setClickable(boolean paramBoolean)
    throws RemoteException;

  public abstract void setFillColor(int paramInt)
    throws RemoteException;

  public abstract void setGeodesic(boolean paramBoolean)
    throws RemoteException;

  public abstract void setHoles(List paramList)
    throws RemoteException;

  public abstract void setPoints(List<LatLng> paramList)
    throws RemoteException;

  public abstract void setStrokeColor(int paramInt)
    throws RemoteException;

  public abstract void setStrokeJointType(int paramInt)
    throws RemoteException;

  public abstract void setStrokePattern(List<PatternItem> paramList)
    throws RemoteException;

  public abstract void setStrokeWidth(float paramFloat)
    throws RemoteException;

  public abstract void setVisible(boolean paramBoolean)
    throws RemoteException;

  public abstract void setZIndex(float paramFloat)
    throws RemoteException;

  public abstract boolean zzb(zzw paramzzw)
    throws RemoteException;

  public abstract void zze(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract int zzj()
    throws RemoteException;

  public abstract IObjectWrapper zzk()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzw
 * JD-Core Version:    0.6.2
 */