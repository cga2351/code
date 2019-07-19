package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;

public final class zzk extends zza
  implements IMapViewDelegate
{
  zzk(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.internal.IMapViewDelegate");
  }

  public final IGoogleMapDelegate getMap()
    throws RemoteException
  {
    Parcel localParcel = zza(1, zza());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      if ((localIInterface instanceof IGoogleMapDelegate))
        localObject = (IGoogleMapDelegate)localIInterface;
      else
        localObject = new zzg(localIBinder);
    }
  }

  public final void getMapAsync(zzap paramzzap)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramzzap);
    zzb(9, localParcel);
  }

  public final IObjectWrapper getView()
    throws RemoteException
  {
    Parcel localParcel = zza(8, zza());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }

  public final void onCreate(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramBundle);
    zzb(2, localParcel);
  }

  public final void onDestroy()
    throws RemoteException
  {
    zzb(5, zza());
  }

  public final void onEnterAmbient(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramBundle);
    zzb(10, localParcel);
  }

  public final void onExitAmbient()
    throws RemoteException
  {
    zzb(11, zza());
  }

  public final void onLowMemory()
    throws RemoteException
  {
    zzb(6, zza());
  }

  public final void onPause()
    throws RemoteException
  {
    zzb(4, zza());
  }

  public final void onResume()
    throws RemoteException
  {
    zzb(3, zza());
  }

  public final void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramBundle);
    Parcel localParcel2 = zza(7, localParcel1);
    if (localParcel2.readInt() != 0)
      paramBundle.readFromParcel(localParcel2);
    localParcel2.recycle();
  }

  public final void onStart()
    throws RemoteException
  {
    zzb(12, zza());
  }

  public final void onStop()
    throws RemoteException
  {
    zzb(13, zza());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzk
 * JD-Core Version:    0.6.2
 */