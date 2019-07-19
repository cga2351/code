package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzds extends zzq
  implements zzdq
{
  zzds(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
  }

  public final void zzb(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramBundle);
    zza(1, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzds
 * JD-Core Version:    0.6.2
 */