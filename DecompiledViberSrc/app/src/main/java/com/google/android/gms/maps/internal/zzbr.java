package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public final class zzbr extends zza
  implements IProjectionDelegate
{
  zzbr(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.internal.IProjectionDelegate");
  }

  public final LatLng fromScreenLocation(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = zza(1, localParcel1);
    LatLng localLatLng = (LatLng)zzc.zza(localParcel2, LatLng.CREATOR);
    localParcel2.recycle();
    return localLatLng;
  }

  public final VisibleRegion getVisibleRegion()
    throws RemoteException
  {
    Parcel localParcel = zza(3, zza());
    VisibleRegion localVisibleRegion = (VisibleRegion)zzc.zza(localParcel, VisibleRegion.CREATOR);
    localParcel.recycle();
    return localVisibleRegion;
  }

  public final IObjectWrapper toScreenLocation(LatLng paramLatLng)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramLatLng);
    Parcel localParcel2 = zza(2, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzbr
 * JD-Core Version:    0.6.2
 */