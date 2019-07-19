package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzs extends zza
  implements zzq
{
  zzs(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
  }

  public final void activate()
    throws RemoteException
  {
    zzb(3, zza());
  }

  public final String getName()
    throws RemoteException
  {
    Parcel localParcel = zza(1, zza());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final String getShortName()
    throws RemoteException
  {
    Parcel localParcel = zza(2, zza());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final boolean zzb(zzq paramzzq)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramzzq);
    Parcel localParcel2 = zza(4, localParcel1);
    boolean bool = zzc.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final int zzj()
    throws RemoteException
  {
    Parcel localParcel = zza(5, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzs
 * JD-Core Version:    0.6.2
 */