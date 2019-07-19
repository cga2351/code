package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

public abstract interface IStreetViewPanoramaDelegate extends IInterface
{
  public abstract void animateTo(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, long paramLong)
    throws RemoteException;

  public abstract void enablePanning(boolean paramBoolean)
    throws RemoteException;

  public abstract void enableStreetNames(boolean paramBoolean)
    throws RemoteException;

  public abstract void enableUserNavigation(boolean paramBoolean)
    throws RemoteException;

  public abstract void enableZoom(boolean paramBoolean)
    throws RemoteException;

  public abstract StreetViewPanoramaCamera getPanoramaCamera()
    throws RemoteException;

  public abstract StreetViewPanoramaLocation getStreetViewPanoramaLocation()
    throws RemoteException;

  public abstract boolean isPanningGesturesEnabled()
    throws RemoteException;

  public abstract boolean isStreetNamesEnabled()
    throws RemoteException;

  public abstract boolean isUserNavigationEnabled()
    throws RemoteException;

  public abstract boolean isZoomGesturesEnabled()
    throws RemoteException;

  public abstract IObjectWrapper orientationToPoint(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
    throws RemoteException;

  public abstract StreetViewPanoramaOrientation pointToOrientation(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void setOnStreetViewPanoramaCameraChangeListener(zzbh paramzzbh)
    throws RemoteException;

  public abstract void setOnStreetViewPanoramaChangeListener(zzbj paramzzbj)
    throws RemoteException;

  public abstract void setOnStreetViewPanoramaClickListener(zzbl paramzzbl)
    throws RemoteException;

  public abstract void setOnStreetViewPanoramaLongClickListener(zzbn paramzzbn)
    throws RemoteException;

  public abstract void setPosition(LatLng paramLatLng)
    throws RemoteException;

  public abstract void setPositionWithID(String paramString)
    throws RemoteException;

  public abstract void setPositionWithRadius(LatLng paramLatLng, int paramInt)
    throws RemoteException;

  public abstract void setPositionWithRadiusAndSource(LatLng paramLatLng, int paramInt, StreetViewSource paramStreetViewSource)
    throws RemoteException;

  public abstract void setPositionWithSource(LatLng paramLatLng, StreetViewSource paramStreetViewSource)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
 * JD-Core Version:    0.6.2
 */