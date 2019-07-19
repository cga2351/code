package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public final class zzf extends zza
  implements zze
{
  zzf(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.internal.ICreator");
  }

  public final IMapViewDelegate zza(IObjectWrapper paramIObjectWrapper, GoogleMapOptions paramGoogleMapOptions)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramIObjectWrapper);
    zzc.zza(localParcel1, paramGoogleMapOptions);
    Parcel localParcel2 = zza(3, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      if ((localIInterface instanceof IMapViewDelegate))
        localObject = (IMapViewDelegate)localIInterface;
      else
        localObject = new zzk(localIBinder);
    }
  }

  public final IStreetViewPanoramaViewDelegate zza(IObjectWrapper paramIObjectWrapper, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramIObjectWrapper);
    zzc.zza(localParcel1, paramStreetViewPanoramaOptions);
    Parcel localParcel2 = zza(7, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      if ((localIInterface instanceof IStreetViewPanoramaViewDelegate))
        localObject = (IStreetViewPanoramaViewDelegate)localIInterface;
      else
        localObject = new zzbw(localIBinder);
    }
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper);
    localParcel.writeInt(paramInt);
    zzb(6, localParcel);
  }

  public final IMapFragmentDelegate zzc(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = zza(2, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      if ((localIInterface instanceof IMapFragmentDelegate))
        localObject = (IMapFragmentDelegate)localIInterface;
      else
        localObject = new zzj(localIBinder);
    }
  }

  public final IStreetViewPanoramaFragmentDelegate zzd(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = zza(8, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      if ((localIInterface instanceof IStreetViewPanoramaFragmentDelegate))
        localObject = (IStreetViewPanoramaFragmentDelegate)localIInterface;
      else
        localObject = new zzbv(localIBinder);
    }
  }

  public final ICameraUpdateFactoryDelegate zze()
    throws RemoteException
  {
    Parcel localParcel = zza(4, zza());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      if ((localIInterface instanceof ICameraUpdateFactoryDelegate))
        localObject = (ICameraUpdateFactoryDelegate)localIInterface;
      else
        localObject = new zzb(localIBinder);
    }
  }

  public final com.google.android.gms.internal.maps.zze zzf()
    throws RemoteException
  {
    Parcel localParcel = zza(5, zza());
    com.google.android.gms.internal.maps.zze localzze = com.google.android.gms.internal.maps.zzf.zzb(localParcel.readStrongBinder());
    localParcel.recycle();
    return localzze;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzf
 * JD-Core Version:    0.6.2
 */