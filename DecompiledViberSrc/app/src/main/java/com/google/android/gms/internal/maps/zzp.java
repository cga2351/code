package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public final class zzp extends zza
  implements zzn
{
  zzp(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
  }

  public final int getActiveLevelIndex()
    throws RemoteException
  {
    Parcel localParcel = zza(1, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final int getDefaultLevelIndex()
    throws RemoteException
  {
    Parcel localParcel = zza(2, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final List<IBinder> getLevels()
    throws RemoteException
  {
    Parcel localParcel = zza(3, zza());
    ArrayList localArrayList = localParcel.createBinderArrayList();
    localParcel.recycle();
    return localArrayList;
  }

  public final boolean isUnderground()
    throws RemoteException
  {
    Parcel localParcel = zza(4, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean zzb(zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramzzn);
    Parcel localParcel2 = zza(5, localParcel1);
    boolean bool = zzc.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final int zzj()
    throws RemoteException
  {
    Parcel localParcel = zza(6, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzp
 * JD-Core Version:    0.6.2
 */