package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public final class zzb extends zza
  implements ICameraUpdateFactoryDelegate
{
  zzb(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
  }

  public final IObjectWrapper newCameraPosition(CameraPosition paramCameraPosition)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramCameraPosition);
    Parcel localParcel2 = zza(7, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper newLatLng(LatLng paramLatLng)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramLatLng);
    Parcel localParcel2 = zza(8, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramLatLngBounds);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = zza(10, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper newLatLngBoundsWithSize(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramLatLngBounds);
    localParcel1.writeInt(paramInt1);
    localParcel1.writeInt(paramInt2);
    localParcel1.writeInt(paramInt3);
    Parcel localParcel2 = zza(11, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper newLatLngZoom(LatLng paramLatLng, float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramLatLng);
    localParcel1.writeFloat(paramFloat);
    Parcel localParcel2 = zza(9, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper scrollBy(float paramFloat1, float paramFloat2)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    localParcel1.writeFloat(paramFloat1);
    localParcel1.writeFloat(paramFloat2);
    Parcel localParcel2 = zza(3, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zoomBy(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    localParcel1.writeFloat(paramFloat);
    Parcel localParcel2 = zza(5, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zoomByWithFocus(float paramFloat, int paramInt1, int paramInt2)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    localParcel1.writeFloat(paramFloat);
    localParcel1.writeInt(paramInt1);
    localParcel1.writeInt(paramInt2);
    Parcel localParcel2 = zza(6, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zoomIn()
    throws RemoteException
  {
    Parcel localParcel = zza(1, zza());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zoomOut()
    throws RemoteException
  {
    Parcel localParcel = zza(2, zza());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zoomTo(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    localParcel1.writeFloat(paramFloat);
    Parcel localParcel2 = zza(4, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzb
 * JD-Core Version:    0.6.2
 */