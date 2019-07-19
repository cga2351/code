package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzae extends zza
  implements zzac
{
  zzae(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
  }

  public final void clearTileCache()
    throws RemoteException
  {
    zzb(2, zza());
  }

  public final boolean getFadeIn()
    throws RemoteException
  {
    Parcel localParcel = zza(11, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final String getId()
    throws RemoteException
  {
    Parcel localParcel = zza(3, zza());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final float getTransparency()
    throws RemoteException
  {
    Parcel localParcel = zza(13, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final float getZIndex()
    throws RemoteException
  {
    Parcel localParcel = zza(5, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final boolean isVisible()
    throws RemoteException
  {
    Parcel localParcel = zza(7, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void remove()
    throws RemoteException
  {
    zzb(1, zza());
  }

  public final void setFadeIn(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(10, localParcel);
  }

  public final void setTransparency(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(12, localParcel);
  }

  public final void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(6, localParcel);
  }

  public final void setZIndex(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(4, localParcel);
  }

  public final boolean zza(zzac paramzzac)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramzzac);
    Parcel localParcel2 = zza(8, localParcel1);
    boolean bool = zzc.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final int zzj()
    throws RemoteException
  {
    Parcel localParcel = zza(9, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzae
 * JD-Core Version:    0.6.2
 */