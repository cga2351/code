package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public abstract interface zze extends IInterface
{
  public abstract IMapViewDelegate zza(IObjectWrapper paramIObjectWrapper, GoogleMapOptions paramGoogleMapOptions)
    throws RemoteException;

  public abstract IStreetViewPanoramaViewDelegate zza(IObjectWrapper paramIObjectWrapper, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
    throws RemoteException;

  public abstract void zza(IObjectWrapper paramIObjectWrapper, int paramInt)
    throws RemoteException;

  public abstract IMapFragmentDelegate zzc(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract IStreetViewPanoramaFragmentDelegate zzd(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract ICameraUpdateFactoryDelegate zze()
    throws RemoteException;

  public abstract com.google.android.gms.internal.maps.zze zzf()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zze
 * JD-Core Version:    0.6.2
 */