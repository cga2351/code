package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;

public final class zzai extends zza
  implements zzah
{
  zzai(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.internal.IOnLocationChangeListener");
  }

  public final void zza(Location paramLocation)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramLocation);
    zzb(2, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzai
 * JD-Core Version:    0.6.2
 */