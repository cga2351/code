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
import com.google.android.gms.maps.GoogleMapOptions;

public final class zzj extends zza
  implements IMapFragmentDelegate
{
  zzj(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.internal.IMapFragmentDelegate");
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
    zzb(12, localParcel);
  }

  public final boolean isReady()
    throws RemoteException
  {
    Parcel localParcel = zza(11, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void onCreate(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramBundle);
    zzb(3, localParcel);
  }

  public final IObjectWrapper onCreateView(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramIObjectWrapper1);
    zzc.zza(localParcel1, paramIObjectWrapper2);
    zzc.zza(localParcel1, paramBundle);
    Parcel localParcel2 = zza(4, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final void onDestroy()
    throws RemoteException
  {
    zzb(8, zza());
  }

  public final void onDestroyView()
    throws RemoteException
  {
    zzb(7, zza());
  }

  public final void onEnterAmbient(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramBundle);
    zzb(13, localParcel);
  }

  public final void onExitAmbient()
    throws RemoteException
  {
    zzb(14, zza());
  }

  public final void onInflate(IObjectWrapper paramIObjectWrapper, GoogleMapOptions paramGoogleMapOptions, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper);
    zzc.zza(localParcel, paramGoogleMapOptions);
    zzc.zza(localParcel, paramBundle);
    zzb(2, localParcel);
  }

  public final void onLowMemory()
    throws RemoteException
  {
    zzb(9, zza());
  }

  public final void onPause()
    throws RemoteException
  {
    zzb(6, zza());
  }

  public final void onResume()
    throws RemoteException
  {
    zzb(5, zza());
  }

  public final void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramBundle);
    Parcel localParcel2 = zza(10, localParcel1);
    if (localParcel2.readInt() != 0)
      paramBundle.readFromParcel(localParcel2);
    localParcel2.recycle();
  }

  public final void onStart()
    throws RemoteException
  {
    zzb(15, zza());
  }

  public final void onStop()
    throws RemoteException
  {
    zzb(16, zza());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzj
 * JD-Core Version:    0.6.2
 */