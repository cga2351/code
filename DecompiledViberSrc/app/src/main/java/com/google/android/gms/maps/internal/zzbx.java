package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;

public final class zzbx extends zza
  implements IUiSettingsDelegate
{
  zzbx(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
  }

  public final boolean isCompassEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(10, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isIndoorLevelPickerEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(17, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isMapToolbarEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(19, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isMyLocationButtonEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(11, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isRotateGesturesEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(15, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isScrollGesturesEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(12, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isScrollGesturesEnabledDuringRotateOrZoom()
    throws RemoteException
  {
    Parcel localParcel = zza(21, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isTiltGesturesEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(14, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isZoomControlsEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(9, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isZoomGesturesEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(13, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void setAllGesturesEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(8, localParcel);
  }

  public final void setCompassEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(2, localParcel);
  }

  public final void setIndoorLevelPickerEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(16, localParcel);
  }

  public final void setMapToolbarEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(18, localParcel);
  }

  public final void setMyLocationButtonEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(3, localParcel);
  }

  public final void setRotateGesturesEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(7, localParcel);
  }

  public final void setScrollGesturesEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(4, localParcel);
  }

  public final void setScrollGesturesEnabledDuringRotateOrZoom(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(20, localParcel);
  }

  public final void setTiltGesturesEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(6, localParcel);
  }

  public final void setZoomControlsEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(1, localParcel);
  }

  public final void setZoomGesturesEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(5, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzbx
 * JD-Core Version:    0.6.2
 */