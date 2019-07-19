package com.google.android.gms.internal.maps;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public final class zzg extends zza
  implements zze
{
  zzg(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
  }

  public final IObjectWrapper zza(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    localParcel1.writeFloat(paramFloat);
    Parcel localParcel2 = zza(5, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zza(int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = zza(1, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zza(Bitmap paramBitmap)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramBitmap);
    Parcel localParcel2 = zza(6, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zza(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    localParcel1.writeString(paramString);
    Parcel localParcel2 = zza(2, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zzb(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    localParcel1.writeString(paramString);
    Parcel localParcel2 = zza(3, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zzc(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    localParcel1.writeString(paramString);
    Parcel localParcel2 = zza(7, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zzi()
    throws RemoteException
  {
    Parcel localParcel = zza(4, zza());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzg
 * JD-Core Version:    0.6.2
 */