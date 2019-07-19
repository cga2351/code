package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

public abstract class zzv extends zzb
  implements zzu
{
  public zzv()
  {
    super("com.google.android.gms.location.ILocationCallback");
  }

  public static zzu zzb(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
    if ((localIInterface instanceof zzu))
      return (zzu)localIInterface;
    return new zzw(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      onLocationResult((LocationResult)zzc.zza(paramParcel1, LocationResult.CREATOR));
    case 2:
    }
    while (true)
    {
      return true;
      onLocationAvailability((LocationAvailability)zzc.zza(paramParcel1, LocationAvailability.CREATOR));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.zzv
 * JD-Core Version:    0.6.2
 */