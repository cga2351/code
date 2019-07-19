package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbjk extends zzfm
  implements zzbji
{
  zzbjk(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.measurement.IMeasurementManager");
  }

  public final void zzc(zzbjg paramzzbjg)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzbjg);
    zza(1, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbjk
 * JD-Core Version:    0.6.2
 */