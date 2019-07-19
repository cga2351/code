package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.maps.model.LatLng;

public final class zzv extends zza
  implements zzt
{
  zzv(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
  }

  public final float getAlpha()
    throws RemoteException
  {
    Parcel localParcel = zza(26, zza());
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

  public final float getRotation()
    throws RemoteException
  {
    Parcel localParcel = zza(23, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final String getSnippet()
    throws RemoteException
  {
    Parcel localParcel = zza(8, zza());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final String getTitle()
    throws RemoteException
  {
    Parcel localParcel = zza(6, zza());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final float getZIndex()
    throws RemoteException
  {
    Parcel localParcel = zza(28, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final void hideInfoWindow()
    throws RemoteException
  {
    zzb(12, zza());
  }

  public final boolean isDraggable()
    throws RemoteException
  {
    Parcel localParcel = zza(10, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isFlat()
    throws RemoteException
  {
    Parcel localParcel = zza(21, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isInfoWindowShown()
    throws RemoteException
  {
    Parcel localParcel = zza(13, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isVisible()
    throws RemoteException
  {
    Parcel localParcel = zza(15, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void remove()
    throws RemoteException
  {
    zzb(1, zza());
  }

  public final void setAlpha(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(25, localParcel);
  }

  public final void setAnchor(float paramFloat1, float paramFloat2)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat1);
    localParcel.writeFloat(paramFloat2);
    zzb(19, localParcel);
  }

  public final void setDraggable(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(9, localParcel);
  }

  public final void setFlat(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(20, localParcel);
  }

  public final void setInfoWindowAnchor(float paramFloat1, float paramFloat2)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat1);
    localParcel.writeFloat(paramFloat2);
    zzb(24, localParcel);
  }

  public final void setPosition(LatLng paramLatLng)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramLatLng);
    zzb(3, localParcel);
  }

  public final void setRotation(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(22, localParcel);
  }

  public final void setSnippet(String paramString)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeString(paramString);
    zzb(7, localParcel);
  }

  public final void setTitle(String paramString)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeString(paramString);
    zzb(5, localParcel);
  }

  public final void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(14, localParcel);
  }

  public final void setZIndex(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(27, localParcel);
  }

  public final void showInfoWindow()
    throws RemoteException
  {
    zzb(11, zza());
  }

  public final void zze(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper);
    zzb(29, localParcel);
  }

  public final void zzg(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper);
    zzb(18, localParcel);
  }

  public final int zzj()
    throws RemoteException
  {
    Parcel localParcel = zza(17, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final boolean zzj(zzt paramzzt)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramzzt);
    Parcel localParcel2 = zza(16, localParcel1);
    boolean bool = zzc.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final IObjectWrapper zzk()
    throws RemoteException
  {
    Parcel localParcel = zza(30, zza());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzv
 * JD-Core Version:    0.6.2
 */