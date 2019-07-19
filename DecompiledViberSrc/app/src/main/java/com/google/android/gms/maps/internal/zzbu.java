package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

public final class zzbu extends zza
  implements IStreetViewPanoramaDelegate
{
  zzbu(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
  }

  public final void animateTo(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramStreetViewPanoramaCamera);
    localParcel.writeLong(paramLong);
    zzb(9, localParcel);
  }

  public final void enablePanning(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(2, localParcel);
  }

  public final void enableStreetNames(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(4, localParcel);
  }

  public final void enableUserNavigation(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(3, localParcel);
  }

  public final void enableZoom(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(1, localParcel);
  }

  public final StreetViewPanoramaCamera getPanoramaCamera()
    throws RemoteException
  {
    Parcel localParcel = zza(10, zza());
    StreetViewPanoramaCamera localStreetViewPanoramaCamera = (StreetViewPanoramaCamera)zzc.zza(localParcel, StreetViewPanoramaCamera.CREATOR);
    localParcel.recycle();
    return localStreetViewPanoramaCamera;
  }

  public final StreetViewPanoramaLocation getStreetViewPanoramaLocation()
    throws RemoteException
  {
    Parcel localParcel = zza(14, zza());
    StreetViewPanoramaLocation localStreetViewPanoramaLocation = (StreetViewPanoramaLocation)zzc.zza(localParcel, StreetViewPanoramaLocation.CREATOR);
    localParcel.recycle();
    return localStreetViewPanoramaLocation;
  }

  public final boolean isPanningGesturesEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(6, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isStreetNamesEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(8, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isUserNavigationEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(7, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isZoomGesturesEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(5, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final IObjectWrapper orientationToPoint(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramStreetViewPanoramaOrientation);
    Parcel localParcel2 = zza(19, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final StreetViewPanoramaOrientation pointToOrientation(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = zza(18, localParcel1);
    StreetViewPanoramaOrientation localStreetViewPanoramaOrientation = (StreetViewPanoramaOrientation)zzc.zza(localParcel2, StreetViewPanoramaOrientation.CREATOR);
    localParcel2.recycle();
    return localStreetViewPanoramaOrientation;
  }

  public final void setOnStreetViewPanoramaCameraChangeListener(zzbh paramzzbh)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramzzbh);
    zzb(16, localParcel);
  }

  public final void setOnStreetViewPanoramaChangeListener(zzbj paramzzbj)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramzzbj);
    zzb(15, localParcel);
  }

  public final void setOnStreetViewPanoramaClickListener(zzbl paramzzbl)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramzzbl);
    zzb(17, localParcel);
  }

  public final void setOnStreetViewPanoramaLongClickListener(zzbn paramzzbn)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramzzbn);
    zzb(20, localParcel);
  }

  public final void setPosition(LatLng paramLatLng)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramLatLng);
    zzb(12, localParcel);
  }

  public final void setPositionWithID(String paramString)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeString(paramString);
    zzb(11, localParcel);
  }

  public final void setPositionWithRadius(LatLng paramLatLng, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramLatLng);
    localParcel.writeInt(paramInt);
    zzb(13, localParcel);
  }

  public final void setPositionWithRadiusAndSource(LatLng paramLatLng, int paramInt, StreetViewSource paramStreetViewSource)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramLatLng);
    localParcel.writeInt(paramInt);
    zzc.zza(localParcel, paramStreetViewSource);
    zzb(22, localParcel);
  }

  public final void setPositionWithSource(LatLng paramLatLng, StreetViewSource paramStreetViewSource)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramLatLng);
    zzc.zza(localParcel, paramStreetViewSource);
    zzb(21, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzbu
 * JD-Core Version:    0.6.2
 */