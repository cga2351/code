package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzak extends zzb
  implements zzaj
{
  public zzak()
  {
    super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      zza((zzad)zzc.zza(paramParcel1, zzad.CREATOR));
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzak
 * JD-Core Version:    0.6.2
 */