package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public final class zzm extends zza
  implements zzk
{
  zzm(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
  }

  public final float getBearing()
    throws RemoteException
  {
    Parcel localParcel = zza(12, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final LatLngBounds getBounds()
    throws RemoteException
  {
    Parcel localParcel = zza(10, zza());
    LatLngBounds localLatLngBounds = (LatLngBounds)zzc.zza(localParcel, LatLngBounds.CREATOR);
    localParcel.recycle();
    return localLatLngBounds;
  }

  public final float getHeight()
    throws RemoteException
  {
    Parcel localParcel = zza(8, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final String getId()
    throws RemoteException
  {
    Parcel localParcel = zza(2, zza());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final LatLng getPosition()
    throws RemoteException
  {
    Parcel localParcel = zza(4, zza());
    LatLng localLatLng = (LatLng)zzc.zza(localParcel, LatLng.CREATOR);
    localParcel.recycle();
    return localLatLng;
  }

  public final float getTransparency()
    throws RemoteException
  {
    Parcel localParcel = zza(18, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final float getWidth()
    throws RemoteException
  {
    Parcel localParcel = zza(7, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final float getZIndex()
    throws RemoteException
  {
    Parcel localParcel = zza(14, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final boolean isClickable()
    throws RemoteException
  {
    Parcel localParcel = zza(23, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isVisible()
    throws RemoteException
  {
    Parcel localParcel = zza(16, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void remove()
    throws RemoteException
  {
    zzb(1, zza());
  }

  public final void setBearing(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(11, localParcel);
  }

  public final void setClickable(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(22, localParcel);
  }

  public final void setDimensions(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(5, localParcel);
  }

  public final void setPosition(LatLng paramLatLng)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramLatLng);
    zzb(3, localParcel);
  }

  public final void setPositionFromBounds(LatLngBounds paramLatLngBounds)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramLatLngBounds);
    zzb(9, localParcel);
  }

  public final void setTransparency(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(17, localParcel);
  }

  public final void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(15, localParcel);
  }

  public final void setZIndex(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(13, localParcel);
  }

  public final void zza(float paramFloat1, float paramFloat2)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat1);
    localParcel.writeFloat(paramFloat2);
    zzb(6, localParcel);
  }

  public final boolean zzb(zzk paramzzk)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramzzk);
    Parcel localParcel2 = zza(19, localParcel1);
    boolean bool = zzc.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final void zze(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper);
    zzb(24, localParcel);
  }

  public final void zzf(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper);
    zzb(21, localParcel);
  }

  public final int zzj()
    throws RemoteException
  {
    Parcel localParcel = zza(20, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final IObjectWrapper zzk()
    throws RemoteException
  {
    Parcel localParcel = zza(25, zza());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzm
 * JD-Core Version:    0.6.2
 */